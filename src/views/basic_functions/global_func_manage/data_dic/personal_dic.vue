<template>
    <div>
        <page-header title="个人字典">
            <template #content>
                <div>
                    <div class="hover" @click="back" @mouseover="changeMask(true)" @mouseout="changeMask(false)">返回上一页</div>
                </div>
            </template>
        </page-header>
        <page-main title="个人字典" class="box-card itemSpacing">
            <el-row>
                <el-col :span="6">
                    <div class="inLine">
                        <span slot="label">
                            <el-tooltip content="定义字典的名称 必填" placement="top">
                                <i class="el-icon-warning-outline" style="color: red;" />
                            </el-tooltip>
                        </span>
                        模板名称
                        <div class="inLine">
                            <el-input
                                v-model="pageQueryValue.typeName"
                                type="text"
                                size="small"
                                placeholder="请输入模板名称"
                                style="display: inline;"
                                maxlength="10"
                                show-word-limit
                            />
                        </div>
                    </div>
                </el-col>
                <el-col :span="6" style="margin-top: 20px; margin-left: 10px;">
                    <el-button type="primary" icon="el-icon-search" size="mini" @click="handleButtonQuery">搜索</el-button>
                    <el-tooltip content="创建新字典数据" placement="top">
                        <el-button type="primary" icon="el-icon-document-add" size="mini" @click="pageDialogVisible = true">创建</el-button>
                    </el-tooltip>
                    <el-tooltip content="刷新字典数据" placement="top">
                        <el-button type="primary" icon="el-icon-refresh" size="mini" @click="getUser">刷新</el-button>
                    </el-tooltip>
                </el-col>
            </el-row>
        </page-main>
        <page-main title="字典列表">
            <el-card class="box-card" shadow="hover">
                <el-table
                    :data="tableData"
                    style="width: 100%;"
                    max-height="250"
                >
                    <el-table-column
                        fixed
                        prop="none"
                        label="列"
                        width="80"
                        type="index"
                    />
                    <el-table-column
                        fixed
                        prop="name"
                        label="名称"
                        width="300"
                    />
                    <el-table-column
                        prop="notes"
                        label="备注"
                        width="360"
                    />
                    <el-table-column
                        prop="state"
                        label="状态"
                        width="200"
                    />
                    <el-table-column
                        fixed="right"
                        label="操作"
                        width="360"
                    >
                        <template>
                            <el-dropdown size="small" split-button type="primary" @click="dialogVisible = true">
                                编辑
                                <el-dropdown-menu slot="dropdown" @click="dialogVisible = true">
                                    <el-dropdown-item @click="dialogVisible = true">
                                        信息变更
                                    </el-dropdown-item>
                                    <el-dropdown-item>
                                        修改权限
                                    </el-dropdown-item>
                                </el-dropdown-menu>
                            </el-dropdown>
                            &nbsp;
                            <el-button
                                type="primary"
                                size="small"
                                @click="dialogVisible = true"
                            >
                                详情
                            </el-button>
                            <el-button
                                type="danger"
                                size="small"
                                @click="dialogVisible = true"
                            >
                                移除
                            </el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-dialog
                    title="来自shellwe的警告"
                    :visible.sync="dialogVisible"
                    width="30%"
                >
                    <span>开发中 此操作暂时拒绝</span>
                    <span slot="footer" class="dialog-footer">
                        <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                        <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
                    </span>
                </el-dialog>
                <el-pagination
                    :current-page="currentPage4"
                    :page-sizes="[1, 3, 5, 10]"
                    :page-size="10"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="40"
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                />
            </el-card>
        </page-main>
        <page-main v-show="isShow" title="全部字典信息">
            <template>
                <el-table :key="key" v-loading="false" :data="data" style="width: 100%;" border height="550" size="mini" @cell-mouse-enter="getDetails">
                    <template slot="empty">
                        <span>未找到合适记录</span>
                    </template>
                    <el-table-column v-for="(value, index) in pageFormHead"
                                     :key="index"
                                     :label="value"
                                     :width="value.width"
                    >
                        <template #default="scope">
                            {{ scope.row[value] }}
                        </template>
                    </el-table-column>
                    <el-table-column
                        fixed="right"
                        label="操作"
                        width="150"
                    >
                        <template>
                            <el-button-group>
                                <el-button type="primary" size="mini" @click="handleButtonEdit">编辑</el-button>
                                <el-button type="danger" size="mini" @click="handleButtonDelete">移除</el-button>
                            </el-button-group>
                        </template>
                    </el-table-column>
                </el-table>
            </template>
        </page-main>
        <el-dialog
            title="创建一条新的字典规则"
            :visible.sync="pageDialogVisible"
            width="50%"
        >
            <el-form :inline="true" :model="pageFormList" label-width="200px" label-position="right" size="mini">
                <div>
                    <el-tooltip class="item" effect="dark" content="如果是组模板规制请在结尾添加_Type" placement="top">
                        <el-form-item label="类型代码/typeCode">
                            <el-input v-model="pageFormList.typeCode" placeholder="英文驼峰输入" />
                        </el-form-item>
                    </el-tooltip>
                    <el-tooltip class="item" effect="dark" content="组模板规则请用相同模板名称" placement="top">
                        <el-form-item label="模板名称/typeName">
                            <el-input v-model="pageFormList.typeName" placeholder="四字中文" />
                        </el-form-item>
                    </el-tooltip>
                    <el-tooltip class="item" effect="dark" content="组模板规则内不同名称相同模板" placement="top">
                        <el-form-item label="显示名称/valueName">
                            <el-input v-model="pageFormList.valueName" placeholder="四字中文" />
                        </el-form-item>
                    </el-tooltip>
                    <el-form-item label="模板状态/valueStatues">
                        <el-select v-model="pageFormList.valueStatus" placeholder="状态选择" style="width: 180px;">
                            <el-option label="有效" value="efficient" />
                            <el-option label="失效" value="invalid" />
                        </el-select>
                    </el-form-item>
                    <el-tooltip class="item" effect="dark" content="前缀只有一个大写字母" placement="top">
                        <el-form-item label="前缀编码/prefix">
                            <el-input v-model="pageFormList.prefix" placeholder="默认是G" />
                        </el-form-item>
                    </el-tooltip>
                    <el-tooltip class="item" effect="dark" content="必须四位数字,且以数字大于1开头" placement="top">
                        <el-form-item label="UID/uniqueID">
                            <el-input v-model="pageFormList.uniqueID" placeholder="0-1999为系统默认" />
                        </el-form-item>
                    </el-tooltip>
                    <el-form-item label="模板种类/type">
                        <el-select v-model="pageFormList.type" placeholder="种类选择" style="width: 180px;">
                            <el-option label="单一" value="single" />
                            <el-option label="模组" value="group" />
                        </el-select>
                    </el-form-item>
                    <el-tooltip class="item" effect="dark" content="模板创建说明" placement="top">
                        <el-form-item label="模板说明/description">
                            <el-input v-model="pageFormList.description" placeholder="中文" />
                        </el-form-item>
                    </el-tooltip>
                </div>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="handleButtonCancel('pageDialogVisible', 'pageFormList')">取 消</el-button>
                <el-button type="primary" @click="handleButtonCreate">创 建</el-button>
            </span>
        </el-dialog>
        <el-dialog
            title="编辑一条字典规则"
            :visible.sync="pageDialogVisibleUni"
            width="50%"
        >
            <el-form :inline="true" :model="pageFormList" label-width="200px" label-position="right" size="mini">
                <div>
                    <el-tooltip class="item" effect="dark" content="如果是组模板规制请在结尾添加 _Type" placement="top">
                        <el-form-item label="类型代码/typeCode">
                            <el-input v-model="pageFormList.typeCode" :placeholder="pageFormList.typeCode" />
                        </el-form-item>
                    </el-tooltip>
                    <el-tooltip class="item" effect="dark" content="组模板规则请用相同模板名称" placement="top">
                        <el-form-item label="模板名称/typeName">
                            <el-input v-model="pageFormList.typeName" :placeholder="pageFormList.typeName" />
                        </el-form-item>
                    </el-tooltip>
                    <el-tooltip class="item" effect="dark" content="组模板规则内不同名称相同模板" placement="top">
                        <el-form-item label="显示名称/valueName">
                            <el-input v-model="pageFormList.valueName" :placeholder="pageFormList.valueName" />
                        </el-form-item>
                    </el-tooltip>
                    <el-form-item label="模板状态/valueStatues">
                        <el-select v-model="pageFormList.valueStatus" placeholder="请重新选择" style="width: 180px;">
                            <el-option label="有效" value="efficient" />
                            <el-option label="失效" value="invalid" />
                        </el-select>
                    </el-form-item>
                    <el-tooltip class="item" effect="dark" content="前缀不可改变" placement="top">
                        <el-form-item label="前缀编码/prefix">
                            <el-input v-model="pageFormList.prefix" placeholder="pageFormList.prefix" disabled />
                        </el-form-item>
                    </el-tooltip>
                    <el-tooltip class="item" effect="dark" content="必须四位数字,且以数字大于1开头" placement="top">
                        <el-form-item label="UID/uniqueID">
                            <el-input v-model="pageFormList.uniqueID" :placeholder="pageFormList.uniqueID" />
                        </el-form-item>
                    </el-tooltip>
                    <el-form-item label="模板种类/type">
                        <el-select v-model="pageFormList.type" placeholder="请重新选择" style="width: 180px;">
                            <el-option label="单一" value="single" />
                            <el-option label="模组" value="group" />
                        </el-select>
                    </el-form-item>
                    <el-tooltip class="item" effect="dark" content="模板创建说明" placement="top">
                        <el-form-item label="模板说明/description">
                            <el-input v-model="pageFormList.description" placeholder="请重新描述" />
                        </el-form-item>
                    </el-tooltip>
                </div>
            </el-form>
            <el-row />
            <span slot="footer" class="dialog-footer">
                <el-button @click="handleButtonCancel('pageDialogVisibleUni', 'pageFormList')">取 消</el-button>
                <el-button type="primary" @click="handleButtonConfirm">修 改</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import axios from 'axios'
export default {
    name: 'PersonalDic',
    components: {PageHeader},
    data() {
        return {
            pageQueryValue: {
                typeName: ''
            },
            pageDialogVisibleUni: false,
            pageFormHead: [],
            key: 1, // table key
            isShow: true,
            pageDialogVisible: false,
            dialogVisible: false,
            currentPage2: 5,
            currentPage3: 5,
            currentPage4: 4,
            pageFormList: {
                prefix: '',
                typeCode: '',
                typeName: '',
                valueName: '',
                valueStatus: '',
                description: '',
                uniqueID: '',
                valueID: '',
                type: ''
            },
            data: [{
                date: '2022-01-12-17:57',
                model_name: '示例1',
                model_explain: '展示示例',
                model_state: '有效'
            }],
            tableData: [{
                name: 'Shellwe',
                notes: '测试数据',
                state: '正常'
            }, {
                name: 'Shellwe',
                notes: '响应操作',
                state: '停用'
            }, {
                name: 'Shellwe',
                notes: '不会改变',
                state: '弃用'
            }]
        }
    },
    mounted: function() {
        // this.loadInformation()
        this.getUser()
    },
    methods: {
        back() {
            history.go(-1)
        },
        // 修改显示状态
        changeMask: function(b) {
            if (b) {
                document.getElementById('abc').style.cursor = 'pointer'
            } else {
                document.getElementById('abc').style.cursor = 'wait'
            }
            console.log(b)
        },
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`)
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`)
        },
        async handleButtonQuery() {
            // console.log(this.pageQueryValue)
            const that = this
            axios({
                method: 'post',
                url: '/dictionary/queryTypeName',
                data: this.pageQueryValue
            }).then(function(response) {
                // console.log(response)
                let keys = []
                if (response.data.data == null) {
                    that.data = null
                } else {
                    for (let property in response.data.data[0]) {
                        keys.push(property)
                    }
                    that.pageFormHead = keys
                    that.data = response.data.data
                }
            }).catch(error => {
                this.$notify({
                    title: '操作执行异常',
                    message: error,
                    type: 'error',
                    duration: 6500
                })
            })
        },
        // 1. 定义getUserList方法 获取后台服务器数据
        async getUser() {
            // 新增操作请求的类型: post  接收时需要使用JSON方式处理
            let {
                data: result
            } = await axios.post('/dictionary/queryAll')
            // Ajax调用之后, 将请求结果赋值给data属性
            let keys = []
            // console.log(result)
            for (let property in result.data[0]) {
                keys.push(property)
            }
            // console.log(keys)
            this.pageFormHead = keys
            this.data = result.data
            // console.log(this.data)
            this.pageData = result.data.reduce((total, current) => {
                current.valueID !== 0 && total.push(current)
                return total
            }, [])
            // console.log(this.pageData)
            const map = {}
            this.pageData.forEach(item => {
                map[item.uniqueID] = item.typeName
            })
            // console.log(map)
            this.pageTabValue = map
            // this.handleQueryUID(1000)
            // console.log(this.pageTabValue)

            // <<数据获取思路>>
            // let values = function(object) {
            //     let values = []
            //     for (let property in object)
            //         values.push(object[property])
            //     return values
            // }
            //
            // // 写成标准的方法(数组是object的一种)：
            // function getObjectKeys(object) {
            //     let keys = []
            //     for (let property in object)
            //         keys.push(property)
            //     return keys
            // }
            //
            // function getObjectValues(object) {
            //     let values = []
            //     for (let property in object)
            //         values.push(object[property])
            //     return values
            // }
        },
        getDetails(row) {
            this.pageRowValue = row
            // console.log(this.pageRowValue)
        },
        handleButtonEdit() {
            const that = this
            axios({
                method: 'post',
                url: '/dictionary/queryId',
                data: {
                    id: this.pageRowValue.id
                }
            }).then(function(response) {
                // console.log(response)
                if (response.data.code === 4033) {
                    that.$notify({
                        title: '操作被拒绝',
                        message: response.data.msg,
                        type: 'error',
                        duration: 6500
                    })
                }
                if (response.data.code === 200) {
                    that.pageFormList = that.pageRowValue
                    that.pageDialogVisibleUni = true
                }

            }).catch(error => {
                this.$notify({
                    title: '操作执行异常',
                    message: error,
                    type: 'error',
                    duration: 6500
                })
            })
        },
        handleButtonDelete() {
            const that = this
            axios({
                method: 'post',
                url: '/dictionary/deleteId',
                data: {
                    id: this.pageRowValue.id
                }
            }).then(function(response) {
                if (response.data.code === 4033) {
                    that.$notify({
                        title: '操作被拒绝',
                        message: response.data.msg,
                        type: 'error',
                        duration: 6500
                    })
                }
                if (response.data.code === 200) {
                    that.$notify({
                        title: '操作被执行',
                        message: response.data.msg,
                        type: 'success',
                        duration: 6500
                    })
                    that.getUser()
                }
            }).catch(error => {
                this.$notify({
                    title: '操作执行异常',
                    message: error,
                    type: 'error',
                    duration: 6500
                })
            })
        },
        handleButtonCancel(visible, val) {
            this[visible] = false
            this[val] = {}
        },
        handleButtonConfirm() {
            axios({
                method: 'post',
                url: '/dictionary/update/field',
                data: this.pageFormList
            }).then(response => {
                this.$notify({
                    title: response.data.msg,
                    message: '操作已提交',
                    type: 'success',
                    duration: 6500
                })
                this.pageFormList = {}
                this.pageDialogVisibleUni = false
            }).catch(error => {
                this.$notify({
                    title: '发生异常',
                    message: error,
                    type: 'error',
                    duration: 6600
                })
            })
        },
        handleButtonCreate() {
            const that = this
            // console.log(this.pageFormList)
            // console.log(this.pageFormList.valueStatus)
            axios({
                method: 'post',
                url: '/dictionary/addGlobalDic',
                data: this.pageFormList
            }).then(function(response) {
                that.pageDialogVisible = false
                that.handleSuccess(response.data.code, response.data.msg)
                console.log(response)
            }).catch(error => {
                this.$notify({
                    title: '操作执行异常',
                    message: error,
                    type: 'error',
                    duration: 6500
                })
            })
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
</style>
