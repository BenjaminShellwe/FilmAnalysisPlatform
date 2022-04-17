<template>
    <div>
        <page-header title="全局字典">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页</div>
                    <div>此页面为全局字典设置,在此页面控制本账号全局字典使用方式</div>
                    <span>是否开启数据字典 </span>
                    <el-switch
                        v-model="isShow"
                        active-text="开启"
                        inactive-text="关闭"
                        @click="changeShow"
                    />
                </div>
            </template>
        </page-header>
        <page-main v-show="isShow" id="collapsible">
            <span style="line-height: 2.2;">是否允许系统读取个人字典
                <el-switch
                    v-model="value1"
                    active-color="#13ce66"
                    inactive-color="#ff4949"
                    active-text="允许"
                    inactive-text="拒绝"
                />
            </span><br>
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

            <br>
        </page-main>
        <!--   按类型查看与修改     -->
        <page-main v-show="isShow" title="按类型查看">
            <el-row>
                <el-col :span="2">
                    <Auth :value="'permission.edit'" style="display: inline-block; padding: 0 0 0 0; margin: 0 0 0 0;">
                        <el-button v-show="pageButtonVisible" type="primary" size="mini" style="margin: 5px 5px 5px 5px;" @click="handleEditable('pageButtonVisible')">编辑模式</el-button>
                        <template slot="no-auth">
                            <span style="font-size: smaller; color: red;">没有使用权限<br>permission.edit</span>
                        </template>
                    </Auth>
                    <el-button v-show="pageButtonVisibleUni" type="success" size="mini" style="margin: 5px 5px 5px 5px;" @click="handleEditable('pageButtonVisibleUni')">完成编辑</el-button>
                </el-col>
                <el-col :span="22">
                    <el-alert title="编辑模式按钮允许你进行修改规则,但请先点击左下方左侧栏加载,删除规则请到全部字典信息表中操作" type="info" style="margin-bottom: 20px;" />
                </el-col>
            </el-row>
            <el-tabs tab-position="left" style="max-height: 330px; overflow-y: auto; overflow-x: hidden;" @tab-click="handleQueryUID">
                <el-tab-pane v-for="(item, index) in pageTabValue" :key="index" :label="item" :name="index.toString()" style="min-height: 315px; overflow-y: auto; overflow-x: hidden;">
                    <span style="margin: 5px 0 15px 0;">当前操作: {{ item }} - {{ index }}</span>
                    <el-row style="margin-top: 10px;">
                        <el-col v-for="(indexUni) in pageQueryUID.length" :key="indexUni" :span="4">
                            <el-card shadow="hover" body-style="padding: 2px;" style="margin: 2px;">
                                <el-descriptions :title="item + pageQueryUID[indexUni-1].id" :name="pageQueryUID[indexUni-1].id" :column="1" size="mini" border>
                                    <el-descriptions-item label="GID">
                                        <el-input v-model="pageFormValue.GID" :placeholder="pageQueryUID[indexUni-1].prefix+pageQueryUID[indexUni-1].uniqueID" :disabled="editable" style="width: 100px;" size="mini" clearable />
                                    </el-descriptions-item>
                                    <el-descriptions-item label="序号">
                                        <el-input v-model="pageFormValue.valueID" :placeholder="pageQueryUID[indexUni-1].valueID" :disabled="editable" style="width: 60px;" size="mini" clearable />
                                    </el-descriptions-item>
                                    <el-descriptions-item label="代码">
                                        <el-input v-model="pageFormValue.typeCode" :placeholder="pageQueryUID[indexUni-1].typeCode" :disabled="editable" style="width: 135px;" size="mini" clearable />
                                    </el-descriptions-item>
                                    <el-descriptions-item label="类型">
                                        <el-input v-model="pageFormValue.typeName" :placeholder="pageQueryUID[indexUni-1].typeName" :disabled="editable" style="width: 100px;" size="mini" clearable />
                                    </el-descriptions-item>
                                    <el-descriptions-item label="名称">
                                        <el-input v-model="pageFormValue.valueName" :placeholder="pageQueryUID[indexUni-1].valueName" :disabled="editable" style="width: 100px;" size="mini" clearable />
                                    </el-descriptions-item>
                                    <el-descriptions-item label="生效">
                                        <el-select v-model="pageFormValue.valueStatus" :placeholder="pageQueryUID[indexUni-1].valueStatus" :disabled="editable" style="width: 100px;" size="mini">
                                            <el-option v-for="itemUni in options" :key="itemUni.valueState" :label="itemUni.label" :value="itemUni.valueState" />
                                        </el-select>
                                    </el-descriptions-item>
                                </el-descriptions>
                            </el-card>
                        </el-col>
                    </el-row>
                </el-tab-pane>
            </el-tabs>
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
                        <template slot-scope="scope">
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
import PageMain from '@/components/PageMain'
import axios from 'axios'
let fields = [
    {label: '日期', prop: 'date'},
    {label: '模板名称', prop: 'model_name'},
    {label: '模板说明', prop: 'model_explain'},
    {label: '模板状态', prop: 'model_state'}
]
export default {
    name: 'GlobalDic',
    components: {PageMain},
    data() {
        return {
            editable: true,
            pageButtonVisible: true,
            pageButtonVisibleUni: false,
            pageFormHead: [],
            pageDialogVisible: false,
            pageDialogVisibleUni: false,
            isShow: true,
            value1: true,
            description: '',
            pageQueryUID: [],
            pageTabValue: [],
            pageFormValue: {
                id: '',
                GID: '',
                valueID: '',
                typeCode: '',
                typeName: '',
                valueName: '',
                valueStatus: ''
            },
            pageRowValue: {},
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
            pageQueryValue: {
                typeName: ''
            },
            valueState: '',
            options: [{
                valueState: 'efficient',
                label: '有效'
            }, {
                valueState: 'inefficient',
                label: '无效'
            }],
            key: 1, // table key
            formThead: fields, // 默认表头 Default header
            data: [{
                date: '2022-01-12-17:57',
                model_name: '示例1',
                model_explain: '展示示例',
                model_state: '有效'
            }],
            pageData: [{}]
        }
    },
    watch: {
        /**
         * 监控表格的数据data，自动设置表格宽度
         * @param https://www.cnblogs.com/huangxiaoxue/p/12034326.html
         */
        data(valArr) {
            const _this = this
            this.formThead = fields.map(function(value) {
                const arr = valArr.map(x => x[value.prop])  // 获取每一列的所有数据
                arr.push(value.label)  // 把每列的表头也加进去算
                value.width = _this.getMaxLength(arr) + 5 // 每列内容最大的宽度 + 表格的内间距(依据实际情况而定)
                return value
            })
        }
    },
    mounted() {
        this.getUser()
    },
    methods: {
        changeShow: function() {
            this.isShow = !this.isShow
            if (this.isShow == false) {
                this.value1 = false
            }
        },
        back() {
            history.go(-1)
        },
        handleClick(row) {
            console.log(row)
        },
        getMaxLength(arr) {
            return arr.reduce((acc, item) => {
                if (item) {
                    let calcLen = this.getTextWidth(item)
                    if (acc < calcLen) {
                        acc = calcLen
                    }
                }
                return acc
            }, 0)
        },
        getTextWidth(str) {
            let width = 0
            let html = document.createElement('span')
            html.innerText = str
            html.className = 'getTextWidth'
            document.querySelector('body').appendChild(html)
            width = document.querySelector('.getTextWidth').offsetWidth
            document.querySelector('.getTextWidth').remove()
            return width
        },
        deleteRow(index, rows) {
            rows.splice(index, 1)
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
        handleSuccess(code, msg) {
            let t
            if (code == 415) {
                t = 'error'
            }
            if (code == 200) {
                t = 'success'
            }
            this.$notify({
                title: t,
                message: msg,
                type: t,
                duration: 6500
            })
        },
        handleQueryUID(tab) {
            this.pageQueryUID = this.data.reduce((total, current) => {
                current.uniqueID == tab.name && total.push(current)
                return total
            }, [])
            // console.log(this.pageQueryUID)
        },
        handleEditable(button) {
            this[button] = !this[button]
            if (button == 'pageButtonVisible') {
                this.pageButtonVisibleUni = true
                this.handleQueryUID()
            }
            if (button == 'pageButtonVisibleUni') {
                this.pageButtonVisible = true
                console.log(this.pageFormValue)
            }
            this.editable = !this.editable
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
        handleButtonCancel(visible, val) {
            this[visible] = false
            this[val] = {}
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.inLine {
    display: inline-block;
}
</style>
