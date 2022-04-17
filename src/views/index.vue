<template>
    <div>
        <page-header title="信息总览">
            <template #content>
                <div>
                    <div style="margin-bottom: 5px;">毕业设计开发</div>
                </div>
            </template>
        </page-header>
        <el-row :gutter="20" style="margin: 0 10px;">
            <el-col :lg="8">
                <page-main title="基本信息" style="margin: 0 0 0 0;">
                    <div class="fa-info">
                        <h1>Welcome!! {{ $store.state.user.account }} {{ $store.state.user.id }}</h1>
                        <h4>Login time {{ timeNow() }} <br> There will be some welcome message</h4>
                        <el-tabs type="border-card">
                            <el-tab-pane label="个人信息">
                                <el-descriptions class="margin-top" title="个人基本信息" :column="1" size="mini" direction="horizontal" border>
                                    <el-descriptions-item label="账户名称">{{ personal.nickName }}</el-descriptions-item>
                                    <el-descriptions-item label="性别">{{ personal.sex }}</el-descriptions-item>
                                    <el-descriptions-item label="手机号码">{{ personal.phone }}</el-descriptions-item>
                                    <el-descriptions-item label="职业状况">{{ personal.occupationStatus }}</el-descriptions-item>
                                    <el-descriptions-item label="所属企业">{{ personal.enterprise }}</el-descriptions-item>
                                    <el-descriptions-item label="注册时间">{{ personal.createTime }}</el-descriptions-item>
                                    <el-descriptions-item label="居住地">{{ personal.habitation }}</el-descriptions-item>
                                    <el-descriptions-item label="备注">{{ personal.remarks }}</el-descriptions-item>
                                    <el-descriptions-item label="联系地址">{{ personal.address }}</el-descriptions-item>
                                </el-descriptions>
                            </el-tab-pane>
                            <el-tab-pane label="工作信息">
                                <el-descriptions class="margin-top" title="职位基本信息" :column="1" size="mini" direction="horizontal" border>
                                    <el-descriptions-item label="真实姓名">{{ enterprise.realName }}</el-descriptions-item>
                                    <el-descriptions-item label="工作号码"><el-tag size="small">{{ enterprise.phone }}</el-tag></el-descriptions-item>
                                    <el-descriptions-item label="所属企业">{{ enterprise.enterpriseName }}</el-descriptions-item>
                                    <el-descriptions-item label="职位">
                                        <el-tag size="small">{{ enterprise.position }}</el-tag>
                                    </el-descriptions-item>
                                    <el-descriptions-item label="账户状态">{{ enterprise.status }}</el-descriptions-item>
                                </el-descriptions>
                            </el-tab-pane>
                            <el-tab-pane label="信息图表">
                                <div class="Echarts">
                                    <div id="chartsUni" style="width: 450px; height: 450px;" />
                                </div>
                            </el-tab-pane>
                        </el-tabs>
                    </div>
                    <br>
                    <br>
                </page-main>
            </el-col>
            <el-col :lg="16">
                <el-row :gutter="20" style="margin: 0 -10px 20px -10px;">
                    <el-col :md="4">
                        <div :title="tips.information" class="icon-box icon-box-1" @click="onIconClick('information',true)">
                            <i class="el-icon-info" />
                            <div class="title">信息总览</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.dictionary" class="icon-box icon-box-2" @click="onIconClick('dictionary',true)">
                            <i class="el-icon-notebook-2" />
                            <div class="title">个人字典</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.chat" class="icon-box icon-box-3" @click="onIconClick('chat',true)">
                            <i class="el-icon-chat-line-square" />
                            <div class="title">即时通信</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.extraFunction" class="icon-box icon-box-6" @click="onIconClick('extraFunction','')">
                            <i class="el-icon-camera" />
                            <div class="title">更多功能</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.message" class="icon-box icon-box-5" @click="onIconClick('message',true)">
                            <i class="el-icon-message" />
                            <div class="title">站内通知</div>
                        </div>
                    </el-col>
                    <el-col :md="4">
                        <div :title="tips.help" class="icon-box icon-box-4" @click="onIconClick('help',true)">
                            <i class="el-icon-help" />
                            <div class="title">快速帮助</div>
                        </div>
                    </el-col>
                </el-row>
                <page-main>
                    <VCalendar />
                </page-main>
            </el-col>
        </el-row>
    </div>
</template>

<script>
import router from '@/router'
import PageMain from '@/components/PageMain'
import axios from 'axios'
export default {
    name: 'IndexPage',
    components: {PageMain},
    data() {
        return {
            key: 1,
            currentRole: 'dashboard',
            pageQueryValue: this.$store.state.user.id,
            tips: {
                information: 'Click to refresh',
                dictionary: 'Set your personal data dictionary',
                chat: 'Start to chat with somebody',
                extraFunction: 'More action',
                message: 'Manage notification',
                help: 'Get online help'
            },
            location: {
                origin: location.origin
            },
            pageValue: {

            },
            enterprise: {
                id: '',
                realName: '',
                enterpriseName: '',
                department: '',
                position: '',
                status: '',
                phone: ''
            },
            personal: {
                id: '',
                realName: '',
                nickName: '',
                phone: '',
                sex: '',
                occupationStatus: '',
                enterprise: '',
                createTime: '',
                birth: '',
                habitation: '',
                address: '',
                remarks: ''

            },
            pageTableHeaderBasic: {},
            pageTableHeaderEnterprise: [{}]
        }
    },
    created() {
        this.handleGetInfo()
    },
    mounted() {
        this.echartsUni()
    },
    methods: {
        open(url) {
            window.open(url, 'top')
        },
        onIconClick(val, state) {
            function executeFunc(val) {
                if (val == 'information') {
                    router.go(0)
                } if (val == 'dictionary') {
                    router.push({path: '/multilevel_menu_basic/management/personal_dic'})
                } if (val == 'chat') {
                    router.push({path: '/multilevel_menu_advanced/chat'})
                } if (val == 'message') {
                    router.push({path: '/multilevel_menu_advanced/message'})
                } if (val == 'help') {
                    router.push({path: '/help/index'})
                } else {
                    console.log('Receiving an error!')
                }
            }

            if (state !== true) {
                this.$message({
                    message: `clicking ${val}, is under construction`,
                    type: 'info'
                })
            } else {
                executeFunc(val)
                console.log('执行')
            }
        },
        timeNow() {
            const h = new Date().getHours()
            const m = new Date().getMinutes()
            return h + ':' + m
        },
        handleGetInfo() {
            const that = this
            axios({
                method: 'post',
                url: '/queryInfo/employee',
                data: {
                    userID: this.pageQueryValue
                }
            }).then(function(response) {
                let keys = []
                if (response.data.data[0] === '') {
                    that.enterprise = null
                } else {
                    for (let property in response.data.data[0]) {
                        keys.push(property)
                    }
                    that.pageTableHeaderEnterprise = keys
                    // console.log(that.pageTableHeaderEnterprise)
                    that.enterprise = response.data.data[0]
                    // console.log(that.enterprise)
                }
            }).catch(function(error) {
                console.log(error)
            })
            axios({
                method: 'post',
                url: '/queryInfo/personal',
                data: {
                    userID: this.pageQueryValue
                }
            }).then(function(response) {
                let keys = []
                if (response.data.data[0] === '') {
                    that.personal = null
                } else {
                    for (let property in response.data.data[0]) {
                        keys.push(property)
                    }
                    that.pageTableHeaderEnterprise = keys
                    // console.log(that.pageTableHeaderEnterprise)
                    that.personal = response.data.data[0]
                    // console.log(that.personal)
                }
            }).catch(function(error) {
                console.log(error)
            })
        },
        echartsUni() {
            var chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            // 配置图表
            var option = {
                tooltip: {
                    trigger: 'item'
                },
                angleAxis: {
                    type: 'category'
                },
                radiusAxis: {},
                polar: {},
                series: [
                    {
                        radius: ['25%', '50%'],
                        type: 'pie',
                        color: [
                            '#d20000',
                            '#cb5600',
                            '#dee33a',
                            '#26449a',
                            '#287e24',
                            '#ff9f7f',
                            '#fb7293',
                            '#E062AE',
                            '#E690D1',
                            '#e7bcf3',
                            '#9d96f5',
                            '#8378EA',
                            '#96BFFF'
                        ],
                        data: [
                            {
                                value: 3,
                                name: '到期'
                            }, {
                                value: 10,
                                name: '紧急'
                            }, {
                                value: 2,
                                name: '待办'
                            }, {
                                value: 2,
                                name: '移交'
                            }, {
                                value: 10,
                                name: '完成'
                            }]
                    }
                ],
                roseType: 'area',
                legend: {
                    show: false
                }
            }
            chartUni.setOption(option)
        }
    }
}
</script>

<style lang="scss" scoped>
.pageTable {
    border-collapse: collapse;
    margin: 0 auto;
    text-align: center;
}
.pageTable td,
.pageTable th {
    border: 1px solid #cad9ea;
    color: #666;
    height: 60px;
}
.fa-info {
    padding: 10px 0 0;
    text-align: center;
    h1 {
        margin: 10px auto 20px;
    }
}
.question {
    .answer {
        margin: 20px 0 0;
        padding-left: 20px;
        font-size: 14px;
        color: #aaa;
        li {
            margin-bottom: 10px;
            line-height: 1.5;
            &:last-child {
                margin-bottom: 0;
            }
        }
        span {
            color: #666;
            font-weight: bold;
        }
    }
}
.icon-box {
    padding: 20px;
    text-align: center;
    background-color: #fff;
    cursor: pointer;
    transition: 0.2s;
    &:hover {
        color: #a1a1a1;
    }
    i {
        font-size: 24px;
    }
    .title {
        margin-top: 5px;
        font-size: 14px;
    }
}
</style>
