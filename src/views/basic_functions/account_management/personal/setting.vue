<template>
    <div>
        <page-header title="个人账户">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为个人账户的基本设置
                </div>
            </template>
        </page-header>
        <page-main>
            <el-tabs tab-position="left" style="height: auto; min-height: 600px;">
                <el-tab-pane label="基本设置" class="basic">
                    <h2>基本设置</h2>
                    <div>
                        <el-row :gutter="20" style="margin-top: 10px;">
                            <el-col :span="8">
                                <div>
                                    <el-card>
                                        <div slot="header">
                                            <el-row>
                                                <el-col :span="13">
                                                    <span>个人中心 图片处理正在修复</span>
                                                </el-col>
                                                <el-col :span="11">
                                                    <image-upload action="/avatar/insert" />
                                                    <image-preview src="/avatar/query" />
                                                </el-col>
                                            </el-row>
                                        </div>
                                        <div>
                                            <span>登录人员 - {{ $store.state.user.account }}</span>
                                        </div>
                                        <div>
                                            <span>
                                                注册时间：{{ pageDataForm.createTime }}
                                            </span>
                                        </div>
                                        <el-divider />
                                        <div>
                                            <div>手机号码:  <div style="float: right; padding-right: 20px;">{{ pageDataForm.phone }}</div></div>
                                        </div>
                                        <div>
                                            <div>所属企业:  <div style="float: right; padding-right: 20px;">{{ pageDataForm.enterprise }}</div></div>
                                        </div>
                                        <div>
                                            <div>首页链接:  <div style="float: right; padding-right: 20px;">{{ pageDataForm.homeUrl }}</div></div>
                                        </div>
                                    </el-card>
                                </div>
                            </el-col>
                            <el-col :span="16">
                                <div>
                                    <el-card shadow="hover">
                                        <div slot="header" style="display: inline;">
                                            <el-row :gutter="2">
                                                <el-col :span="20">
                                                    <span style="font-size: 14px;">基本资料</span>
                                                </el-col>
                                                <el-col :span="2">
                                                    <el-button v-show="editable" style="margin: 0; padding: 5px 5px 5px 5px;" type="primary" @click="changeEditable(1)">编辑</el-button>
                                                    <el-button v-show="done" style="margin: 0; padding: 5px 5px 5px 5px;" type="success" @click="changeEditable(0)">完成</el-button>
                                                </el-col>
                                            </el-row>
                                        </div>
                                        <div>
                                            <el-form v-model="pageDataForm" label-width="100px" size="small" label-position="right">
                                                <div>
                                                    <el-form-item label="真实姓名" prop="realName" class="inLine">
                                                        <el-input v-model="pageDataForm.realName" :disabled="editable" :placeholder="pageDataForm.realName" auto-complete="off" />
                                                    </el-form-item>
                                                    <el-form-item label="账户名称" prop="nickName" class="inLine">
                                                        <el-input v-model="pageDataForm.nickName" :disabled="editable" :placeholder="pageDataForm.nickName" auto-complete="off" />
                                                    </el-form-item>
                                                    <el-form-item label="手机号码" prop="phone" class="inLine">
                                                        <el-tooltip content="绑定手机号码请于安全设置中修改" placement="top" effect="light">
                                                            <el-input v-model="pageDataForm.phone" disabled :placeholder="pageDataForm.phone" auto-complete="off" />
                                                        </el-tooltip>
                                                    </el-form-item>
                                                    <el-form-item label="首页链接" prop="homeUrl" class="inLine">
                                                        <el-input v-model="pageDataForm.homeUrl" :disabled="editable" :placeholder="pageDataForm.homeUrl" maxlength="18" />
                                                    </el-form-item>
                                                    <el-form-item label="QQ" class="inLine">
                                                        <el-input v-model="pageDataForm.qq" :disabled="editable" :placeholder="pageDataForm.qq" />
                                                    </el-form-item>
                                                    <el-form-item label="微信" class="inLine">
                                                        <el-input v-model="pageDataForm.wechat" :disabled="editable" :placeholder="pageDataForm.wechat" />
                                                    </el-form-item>
                                                    <el-form-item label="用户性别" prop="phone" class="inLine" style="width: 293px;">
                                                        <el-select v-model="value" :placeholder="pageDataForm.sex" :disabled="editable" style="width: 100%;">
                                                            <el-option
                                                                v-for="item in options"
                                                                :key="item.value"
                                                                :label="item.label"
                                                                :value="item.value"
                                                            />
                                                        </el-select>
                                                    </el-form-item>
                                                    <el-form-item label="所属公司" prop="homeUrl" class="inLine">
                                                        <el-input v-model="pageDataForm.enterprise" :disabled="editable" :placeholder="pageDataForm.enterprise" maxlength="18" />
                                                    </el-form-item>
                                                </div>
                                            </el-form>
                                        </div>
                                    </el-card>
                                </div>
                                <div>
                                    <el-card class="box-card" style="margin-top: 5px;">
                                        <div>
                                            <el-tooltip content="表内信息从数据库获取,无法直接手动修改" placement="bottom" effect="light">
                                                <el-descriptions title="职位信息" direction="vertical" :column="4" border>
                                                    <el-descriptions-item label="账户ID">{{ pageDataFormUni.userID }}</el-descriptions-item>
                                                    <el-descriptions-item label="真实姓名">{{ pageDataFormUni.realName }}</el-descriptions-item>
                                                    <el-descriptions-item label="状态">
                                                        <el-tag size="small">{{ pageDataFormUni.status }}</el-tag>
                                                    </el-descriptions-item>
                                                    <el-descriptions-item label="归属企业">{{ pageDataFormUni.enterpriseName }}</el-descriptions-item>
                                                    <el-descriptions-item label="所属部门">{{ pageDataFormUni.department }}</el-descriptions-item>
                                                    <el-descriptions-item label="所属职位">{{ pageDataFormUni.position }}</el-descriptions-item>
                                                    <el-descriptions-item label="联系电话">{{ pageDataFormUni.phone }}</el-descriptions-item>
                                                </el-descriptions>
                                            </el-tooltip>
                                        </div>
                                    </el-card>
                                </div>
                            </el-col>
                        </el-row>
                    </div>
                </el-tab-pane>
                <el-tab-pane label="安全设置" class="security">
                    <h2>安全设置</h2>
                    <div class="setting-list">
                        <div class="item">
                            <div class="content">
                                <div class="title">账户密码</div>
                                <div class="desc">当前密码强度：强</div>
                            </div>
                            <div class="action">
                                <el-button type="text" @click="editPassword">修改</el-button>
                            </div>
                        </div>
                        <div class="item">
                            <div class="content">
                                <div class="title">密保手机</div>
                                <div class="desc">已绑定手机：176****2321</div>
                            </div>
                            <div class="action">
                                <el-button type="text">修改</el-button>
                            </div>
                        </div>
                        <div class="item">
                            <div class="content">
                                <div class="title">备用邮箱</div>
                                <div class="desc">当前未绑定备用邮箱</div>
                            </div>
                            <div class="action">
                                <el-button type="text">绑定</el-button>
                            </div>
                        </div>
                    </div>
                </el-tab-pane>
            </el-tabs>
        </page-main>
    </div>
</template>

<script>
import axios from 'axios'
import ImagePreview from '@/components/ImagePreview'

export default {
    name: 'PersonalSetting',
    components: {ImagePreview},
    beforeRouteLeave(to, from, next) {
        if (['personalEditPassword'].includes(to.name)) {
            this.$store.commit('keepAlive/add', 'PersonalSetting')
        }
        next()
    },
    props: {},
    data() {
        return {
            pagePropsValueUni: {},
            pageQueryValue: this.$store.state.user.id,
            pageDataForm: {
                realName: 'Benjamin Thomas Shellwe',
                nickName: 'shellwe',
                phone: '176***2321',
                homeUrl: 'http://shellwe.top',
                enterprise: 'TernaryProjectTeam',
                qq: '774****22',
                wechat: '176***2321',
                remarks: '',
                sex: ''
            },
            pageDataFormUni: {
                userID: '',
                realName: '',
                enterpriseName: '',
                department: '',
                phone: '',
                position: '',
                status: '',
                avatar: ''
            },
            options: [{
                value: 'Male',
                label: '男'
            }, {
                value: 'Female',
                label: '女'
            }, {
                value: 'Unset',
                label: '未设置'
            }],
            value: '',
            dialogVisible: false,
            done: false,
            editable: true
        }
    },
    created() {
    },
    mounted() {
        this.handleQueryValue()
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleSuccess(res) {
            console.log(res)
            if (res.error == '') {
                this.pageDataFormUni.avatar = res.data.path
                console.log(res)
            } else {
                console.log(res)
                this.$message.warning(res.error)
            }
        },
        editPassword() {
            this.$router.push({
                name: 'personalEditPassword'
            })
        },
        changeEditable(val) {
            if (val == '1') {
                this.done = !this.done
                this.editable = !this.editable
            } else {
                this.done = !this.done
                this.editable = !this.editable
                console.log(this.pageDataForm)
                this.pagePropsValueUni = this.pageDataForm
                axios({
                    method: 'post',
                    url: '/queryInfo/update/personal',
                    data: this.pagePropsValueUni
                }).then(response => {
                    this.$notify({
                        title: response.data.code,
                        message: response.data.msg,
                        type: response.data.data,
                        duration: 6500
                    })
                }).catch(error => {
                    console.log(error)
                })
            }
        },
        handleQueryValue() {
            const that = this
            axios({
                method: 'post',
                url: '/queryInfo/personal',
                data: {
                    userID: this.pageQueryValue
                }
            }).then(function(response) {
                // console.log(response)
                that.pageDataForm = response.data.data[0]
                // console.log(that.pageDataForm)
            }).catch(function(error) {
                console.log(error)
            })
            axios({
                method: 'post',
                url: '/queryInfo/employee',
                data: {
                    userID: this.pageQueryValue
                }
            }).then(function(response) {
                // console.log(response)
                that.pageDataFormUni = response.data.data[0]
                // console.log(that.pageDataFormUni)
            }).catch(function(error) {
                console.log(error)
            })
        }
    }
}
</script>

<style lang="scss" scoped>
::v-deep .el-tabs {
    .el-tabs__header .el-tabs__nav {
        .el-tabs__active-bar {
            z-index: 0;
            width: 100%;
            background-color: #e1f0ff;
            border-right: 2px solid #409eff;
        }
        .el-tabs__item {
            text-align: left;
            padding-right: 100px;
        }
    }
    .el-tab-pane {
        padding: 0 20px 0 30px;
    }
}
h2 {
    margin: 0;
    margin-bottom: 30px;
    font-weight: normal;
}
.basic {
    ::v-deep .headimg-upload {
        > div {
            text-align: center;
        }
        .el-upload-dragger {
            border-radius: 50%;
        }
    }
}
.security {
    .setting-list {
        .item {
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 0;
            border-bottom: 1px solid #e8e8e8;
            .content {
                .title {
                    margin-bottom: 5px;
                    color: #666;
                }
                .desc {
                    font-size: 14px;
                    color: #999;
                }
            }
            &:last-child {
                border-bottom: 0;
            }
        }
    }
}
.inLine {
    display: inline-block;
    clear: both;
}
</style>
