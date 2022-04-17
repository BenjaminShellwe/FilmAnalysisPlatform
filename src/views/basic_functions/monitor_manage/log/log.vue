<template>
    <div>
        <page-header title="系统日志">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为系统日志设置
                </div>
            </template>
        </page-header>
        <page-main>
            <div>
                <el-form
                    ref="ruleForm"
                    label-position="left"
                    label-width="100px"
                    :model="ruleForm"
                    :rules="rules"
                    style="padding: 5px 0 0 5px;"
                >
                    <el-row :gutter="0">
                        <!-- 行 -->
                        <el-col :span="24" class="pageDiv">
                            <!-- 列 -->
                            <el-form-item label="具体日志查询">
                                <el-col :xs="24" :sm="24" :md="8" :lg="8" style="padding-right: 8px !important; padding-left: 0 !important; width: 110px;">
                                    <el-select
                                        v-model="ruleForm.selectFirstColumnObj"
                                        :style="'width:100%;'"
                                        value-key="id"
                                        placeholder="请选择"
                                        @change="firstColumnChangeAction($event)"
                                    >
                                        <el-option
                                            v-for="item in firstColumnList"
                                            :key="item.id"
                                            :label="item.text"
                                            :value="item"
                                        />
                                    </el-select>
                                    <el-input v-model="pageInput" placeholder="请输入内容" />
                                </el-col>
                                <el-col :xs="24" :sm="24" :md="8" :lg="8" style="padding-right: 8px !important; padding-left: 0 !important; width: 110px;">
                                    <el-select
                                        v-model="ruleForm.selectSecondColumnObj"
                                        :style="'width:100%'"
                                        value-key="id"
                                        placeholder="请选择"
                                        @change="secondColumnChangeAction($event)"
                                    >
                                        <el-option
                                            v-for="item in secondColumnList"
                                            :key="item.id"
                                            :label="item.text"
                                            :value="item"
                                        />
                                    </el-select>
                                    <el-input v-model="pageInput" placeholder="请输入内容" />
                                </el-col>
                                <el-col :xs="24" :sm="24" :md="8" :lg="8" style="padding-right: 0 !important; padding-left: 0 !important; width: 110px;">
                                    <el-select
                                        v-model="ruleForm.selectThreeColumnObj"
                                        :style="'width:100%'"
                                        value-key="id"
                                        placeholder="请选择"
                                    >
                                        <el-option
                                            v-for="item in threeColumnList"
                                            :key="item.id"
                                            :label="item.text"
                                            :value="item"
                                        />
                                    </el-select>
                                    <el-input v-model="pageInput" placeholder="请输入内容" />
                                </el-col>
                                <el-col :xs="8" :sm="8" :md="8" :lg="8" style="padding-right: 0 !important; padding-left: 0 !important; width: auto;" class="pageDiv">
                                    <el-date-picker
                                        v-model="pageValue"
                                        type="datetimerange"
                                        :picker-options="pickerOptions"
                                        range-separator="~"
                                        start-placeholder="开始日期"
                                        end-placeholder="结束日期"
                                        style="margin-left: 5px; margin-right: 5px;"
                                    />
                                    <el-button icon="el-icon-search" @click.native.prevent="dialogVisible = false">搜索输入</el-button>
                                    <el-button type="primary" icon="el-icon-refresh" @click="handleLogValue">刷新数据</el-button>
                                    <el-row class="pageComponent">
                                        <el-button icon="el-icon-delete" @click.native.prevent="dialogVisible = false">重置输入</el-button>
                                    </el-row>
                                </el-col>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </el-form>
            </div>
            <div>
                <template>
                    <el-table :key="key" v-loading="false" :data="data" style="width: 100%;">
                        <el-table-column v-for="items in formThead"
                                         :key="items.prop"
                                         :label="items.label"
                                         :width="items.width"
                                         show-overflow-tooltip
                        >
                            <template #default="scope">
                                {{ scope.row[items.prop] }}
                            </template>
                        </el-table-column>
                        <el-table-column
                            fixed="right"
                            label="操作"
                            width="160"
                        >
                            <template #default="scope">
                                <el-button type="text" size="mini" @click="dialogVisible = true">查看</el-button>
                                <el-button type="text" size="mini" @click="dialogVisible = true">编辑</el-button>
                                <el-button type="danger" size="mini" @click.native.prevent="deleteRow(scope.$index, data)">移除</el-button>
                                <!--                            <el-button type="danger" size="small" @click.native.prevent="deleteRow(scope.$index, data)">移除</el-button>-->
                            </template>
                        </el-table-column>
                    </el-table>
                </template>
            </div>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>头发和开发时间都不足,不装载该功能</span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
import axios from 'axios'
const fields = [
    {label: '日期', prop: 'date'},
    {label: '服务名称', prop: 'model_serviceName'},
    {label: '读写类型', prop: 'model_readWriteType'},
    {label: '用户名称', prop: 'model_userName'},
    {label: '账户名称', prop: 'model_accountName'},
    {label: '真实姓名', prop: 'model_realName'},
    {label: '资源类型', prop: 'model_resourceType'},
    {label: '资源名称', prop: 'model_resourceName'},
    {label: '操作名称', prop: 'model_operationName'},
    {label: '请求ID', prop: 'model_requestID'},
    {label: '密钥数值', prop: 'model_keyValue'}

]
export default {
    name: 'Log',
    components: {PageMain, PageHeader},
    data() {
        return {
            dialogVisible: false,
            formThead: fields,
            key: 1,
            pageShow: false,
            pageInput: '',
            pickerOptions: {
                shortcuts: [{
                    text: '最近一周',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
                        picker.$emit('pick', [start, end])
                    }
                }, {
                    text: '最近一个月',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
                        picker.$emit('pick', [start, end])
                    }
                }, {
                    text: '最近三个月',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
                        picker.$emit('pick', [start, end])
                    }
                }]
            },
            data: [{
                date: '2022-01-12-17:57',
                model_serviceName: '毕设2022',
                model_readWriteType: '毕设创建生成写入',
                model_userName: 'Benjamin Thomas Shellwe',
                model_accountName: 'shellweTheAdmin',
                model_realName: 'wjw',
                model_resourceType: '软件资源',
                model_resourceName: '软件工程系毕业设计',
                model_operationName: '毕设创建生成写入',
                model_requestID: '202201172025',
                model_keyValue: 'null'
            }],
            pageValue: [new Date(2021, 11, 12, 1, 1), new Date(2022, 6, 20, 1, 1)],
            firstColumnList: [
                {
                    'id': '100',
                    'text': '服务名称',
                    'children': [
                        {
                            'id': '110',
                            'text': '读写类型',
                            'children': [
                                {
                                    'id': '111',
                                    'text': '读出'
                                },
                                {
                                    'id': '112',
                                    'text': '写入'
                                }
                            ]
                        },
                        {
                            'id': '120',
                            'text': '用户名称'
                        }
                    ]
                },
                {
                    'id': '200',
                    'text': '用户名称',
                    'children': [
                        {
                            'id': '210',
                            'text': '账户名称'
                        },
                        {
                            'id': '220',
                            'text': '真实姓名'
                        },
                        {
                            'id': '230',
                            'text': '服务名称',
                            'children': [
                                {
                                    'id': '231',
                                    'text': '请求ID'
                                }
                            ]
                        }
                    ]
                }, {
                    'id': '300',
                    'text': '读写类型',
                    'children': [
                        {
                            'id': '310',
                            'text': '服务名称'
                        }]
                }, {
                    'id': '400',
                    'text': '资源类型',
                    'children': [
                        {
                            'id': '410',
                            'text': '资源名称'
                        }]
                }, {
                    'id': '500',
                    'text': '资源名称',
                    'children': [
                        {
                            'id': '510',
                            'text': '资源类型'
                        }]
                }, {
                    'id': '600',
                    'text': '操作名称'
                }, {
                    'id': '700',
                    'text': '请求ID'
                }, {
                    'id': '800',
                    'text': '密钥数值'
                }
            ],
            // 二级栏目数据
            secondColumnList: [],
            // 三级栏目数据
            threeColumnList: [],
            ruleForm: {
                selectFirstColumnObj: {}, // 选中的一级对象
                selectSecondColumnObj: {}, // 选中的二级对象
                selectThreeColumnObj: {} // 选中的三级对象
            },
            rules: {}
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
                value.width = _this.getMaxLength(arr) + 20 // 每列内容最大的宽度 + 表格的内间距(依据实际情况而定)
                return value
            })
        }
    },
    mounted() {
        this.handleLogValue()
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleChange(value) {
            console.log(value)
        },
        // 一级改动
        firstColumnChangeAction(e) {
            // 给一级model赋值
            this.ruleForm.selectFirstColumnObj = e
            // 初始化二级的列表
            this.ruleForm.selectSecondColumnObj = {}
            this.secondColumnList = e.children
            // 清空二三级对象
            this.ruleForm.selectThreeColumnObj = {}
            this.threeColumnList = []
        },
        // 二级改动
        secondColumnChangeAction(e) {
            // 给二级model赋值
            this.ruleForm.selectSecondColumnObj = e
            // 给三级列表赋值
            this.threeColumnList = e.children
            // 清空三级的ID
            this.ruleForm.selectThreeColumnObj = {}
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
        handleLogValue() {
            const that = this
            axios({
                method: 'post',
                url: '/log/queryAll'
            }).then(function(response) {
                that.data = response.data.data
                // console.log(that.data)
            }).catch(function(error) {
                console.log(error)
            })
        }
    }
}
</script>
<style>
.pageComponent {
    margin-left: 5px;
    margin-right: 5px;
}
.pageDiv {
    display: inline-block;
}
.hover {
    cursor: pointer;
}
.inLine {
    display: inline-block;
    clear: both;
}
</style>
