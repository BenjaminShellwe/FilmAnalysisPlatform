<template>
    <div>
        <page-header title="即时通信">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                <div class="inLine">
                    此页为即时站内聊天室
                </div>
            </template>
        </page-header>
        <page-main>
            <CDialog
                ref="loginDialog"
                title="请输入你的昵称"
                confirm-btn="开始聊天"
                @confirm="login"
            >
                <input v-model="nickname" class="nickname" type="text" placeholder="请输入你的昵称">
            </CDialog>

            <!--            <CDialog-->
            <!--                ref="createGroupDialog"-->
            <!--                title="请输入群名称"-->
            <!--                confirm-btn="确认"-->
            <!--                @confirm="createGroup"-->
            <!--            >-->
            <!--                <el-input v-model="groupName" class="nickname" type="text" placeholder="请输入群名称" />-->
            <!--            </CDialog>-->
            <div class="web-im dis-flex">
                <div class="left">
                    <div class="aside content">
                        <div class="header">
                            <div class="tabbar dis-flex">
                                <label :class="{active:switchType==1, unread: usersUnRead}" @click="switchType=1">联系人</label>
                                <label :class="{active:switchType==2, unread: groupsUnRead}" @click="switchType=2">群聊</label>
                            </div>
                        </div>
                        <div class="body user-list">
                            <el-row>
                                <el-col v-for="item in currentGroups" :key="item.id">
                                    <div v-if="switchType==2" class="user" @click="triggerGroup(item)">
                                        {{ item.name }}
                                        <span v-if="item.unread" class="tips-num">{{ item.unread }}</span>
                                        <span v-if="!checkUserIsGroup(item)" class="add-group" @click.stop="addGroup(item)">+</span>
                                    </div>
                                </el-col>
                                <el-col v-for="item in currentUserList" :key="item.id">
                                    <div v-if="switchType==1 && item.uid!=uid" class="user" :class="{offline: !item.status}" @click="triggerPersonal(item)">
                                        {{ item.nickname }}
                                        <span v-if="item.unread" class="tips-num">{{ item.unread }}</span>
                                    </div>
                                </el-col>
                            </el-row>
                        </div>
                        <div class="footer">
                            <div class="func dis-flex">
                                <!--<label @click="$refs.createGroupDialog.show()">新建群</label>-->
                                <label @click="dialogGroupName = true">新建群</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="right content">
                    <div class="header im-title">{{ title }}</div>
                    <div id="im-record" class="body im-record">
                        <div class="ul">
                            <div v-for="item in currentMessage" :key="item.id" class="li" :class="{user: item.uid == uid}">
                                <template v-if="item.type===1">
                                    <p class="join-tips">{{ item.msg }}</p>
                                </template>
                                <template v-else>
                                    <p class="message-date">
                                        <span class="m-nickname">{{ item.nickname }}</span> {{ item.date }}
                                    </p>
                                    <p class="message-box">{{ item.msg }}</p>
                                </template>
                            </div>
                        </div>
                    </div>
                    <div class="footer im-input dis-flex">
                        <input v-model="msg" type="text" placeholder="请输入内容">
                        <button @click="send">发送</button>
                    </div>
                </div>
            </div>
            <el-dialog
                title="请输入群名称"
                :visible.sync="dialogGroupName"
                width="30%"
            >
                <el-input v-model="groupName" class="nickname" type="text" placeholder="请输入群名称" />
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogGroupName = false">取 消</el-button>
                    <el-button type="goon" @confirm="createGroup" @click="dialogGroupName = false">确 定</el-button>
                </span>
            </el-dialog>
            <!--            <CDialog-->
            <!--                ref="createGroupDialog"-->
            <!--                title="请输入群名称"-->
            <!--                confirm-btn="确认"-->
            <!--                @confirm="createGroup"-->
            <!--            >-->
            <!--                <el-input v-model="groupName" class="nickname" type="text" placeholder="请输入群名称" />-->
            <!--            </CDialog>-->
        </page-main>
    </div>
</template>

<script>
// import Vue from 'vue'
import moment from 'moment'
import PageMain from '@/components/PageMain'
import CDialog from '@/components/CDialog'
export default {
    // el: 'container',
    name: 'Chat',
    components: {CDialog, PageMain},
    data() {
        return {
            title: '请选择群或者人员进行聊天',
            switchType: 1,
            uid: '',
            nickname: this.$store.state.user.userName, // 当前用户昵称
            socket: '',
            msg: '',
            messageList: [],
            users: [],
            groups: [],
            groupId: '',
            bridge: [],
            groupName: '',
            dialogGroupName: false,
            userId: this.$store.state.user.id // 当前用户ID
            // avatar: this.$store.getters.avatar, // 当前用户头像
        }
    },
    computed: {
        currentMessage() {
            let vm = this
            let data = vm.messageList.filter(item => {
                if (item.type === 1) {
                    return item
                } else if (this.groupId) {
                    return item.groupId === this.groupId
                } else if (item.bridge.length) {
                    return item.bridge.sort().join(',') == vm.bridge.sort().join(',')
                }
            })
            data.map(item => {
                item.status = 0
                return item
            })
            return data
        },
        currentGroups() {
            let vm = this
            vm.groups.map(group => {
                group.unread = this.messageList.filter(item => {
                    return item.groupId === group.id && item.status === 1
                }).length
                return group
            })
            return vm.groups
        },
        groupsUnRead() {
            return this.messageList.some(item => {
                return item.groupId && item.status === 1
            })
        },
        usersUnRead() {
            return this.messageList.some(item => {
                return item.bridge.length && item.status === 1
            })
        },
        currentUserList() {
            let vm = this
            vm.users.map(user => {
                user.unread = this.messageList.filter(item => {
                    return item.bridge.length && item.uid === user.uid && item.status === 1
                }).length
                return user
            })
            return vm.users
        }
    },
    mounted() {
        let vm = this
        let user = localStorage.getItem('WEB_IM_USER')
        user = user && JSON.parse(user) || {}
        vm.uid = user.uid
        vm.nickname = user.nickname

        if (!vm.uid) {
            this.$notify({
                title: 'error',
                message: vm.uid,
                type: 'error',
                duration: 6500
            })
            vm.$refs.loginDialog.show()
        } else {
            // console.log(vm)
            vm.conWebSocket()
        }
    },
    destroyed() {

    },
    methods: {
        back() {
            history.go(-1)
        },
        addGroup(item) {
            this.socket.send(JSON.stringify({
                uid: this.uid,
                type: 20,
                nickname: this.nickname,
                groupId: item.id,
                groupName: item.name,
                bridge: []
            }))
            this.$message({type: 'success', message: `成功加入${item.name}群`})
        },
        checkUserIsGroup(item) {
            return item.users.some(item => {
                return item.uid === this.uid
            })
        },
        createGroup() {
            this.groupName = this.groupName.trim()
            if (!this.groupName) {
                this.$message({type: 'error', message: '请输入群名称'})
                return
            }
            this.socket.send(JSON.stringify({
                uid: this.uid,
                type: 10,
                nickname: this.nickname,
                groupName: this.groupName,
                bridge: []
            }))
        },
        triggerGroup(item) {
            let issome = item.users.some(item => {
                return item.uid === this.uid
            })
            if (!issome) {
                this.$message({type: 'error', message: `您还不是${item.name}群成员`})
                return
            }
            this.bridge = []
            this.groupId = item.id
            this.title = `和${item.name}群成员聊天`
        },
        triggerPersonal(item) {
            if (this.uid === item.uid) {
                return
            }
            this.groupId = ''
            this.bridge = [this.uid, item.uid]
            this.title = `和${item.nickname}聊天`
        },
        send() {
            this.msg = this.msg.trim()
            if (!this.msg) {
                return
            }
            if (!this.bridge.length && !this.groupId) {
                this.$message({type: 'error', message: '请选择发送人或者群'})
                return
            }
            this.sendMessage(100, this.msg)
        },
        sendMessage(type, msg) {
            this.socket.send(JSON.stringify({
                uid: this.uid,
                type: type,
                nickname: this.nickname,
                msg: msg,
                bridge: this.bridge,
                groupId: this.groupId
            }))
            this.msg = ''
        },
        conWebSocket() {
            let vm = this
            if (window.WebSocket) {
                vm.socket = new WebSocket('ws://localhost:8001')
                let socket = vm.socket

                socket.onopen = function() {
                    console.log('连接服务器成功')
                    vm.$message({type: 'success', message: '连接服务器成功'})
                    if (!vm.uid) {
                        vm.uid = 'web_im_' + moment().valueOf()
                        localStorage.setItem('WEB_IM_USER', JSON.stringify({
                            uid: vm.uid,
                            nickname: vm.nickname
                        }))
                    }
                    vm.sendMessage(1)
                }
                socket.onclose = function() {
                    console.log('服务器关闭')
                }
                socket.onerror = function() {
                    console.log('连接出错')
                }
                // 接收服务器的消息
                socket.onmessage = function(e) {
                    let message = JSON.parse(e.data)
                    vm.messageList.push(message)
                    if (message.users) {
                        vm.users = message.users
                    }
                    if (message.groups) {
                        vm.groups = message.groups
                    }

                    vm.$nextTick(function() {
                        var div = document.getElementById('im-record')
                        div.scrollTop = div.scrollHeight
                    })
                }
            }
        },
        login() {
            this.nickname = this.nickname.trim()
            if (!this.nickname) {
                this.$message({type: 'error', message: '请输入您的昵称'})
                return
            }
            this.$refs.loginDialog.hide()
            this.conWebSocket()
        }
    }
}
</script>

<style>
.el-button--goon.is-active,
.el-button--goon:active {
    background: #20b2aa;
    border-color: #20b2aa;
    color: #fff;
}
.el-button--goon:focus,
.el-button--goon:hover {
    background: #48d1cc;
    border-color: #48d1cc;
    color: #fff;
}
.el-button--goon {
    color: #fff;
    background-color: #20b2aa;
    border-color: #20b2aa;
}
</style>

<style lang='stylus'>
@import './chat.styl';
</style>
