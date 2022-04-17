<template>
    <div>
        <!-- 卡片视图区域 -->
        <el-card class="box-card itemSpacing">
            <div style="border-bottom: 1px solid #c0c4cc;" />
            <el-form :inline="true">
                <!--卡片区域第一行-->
                <el-row>
                    <el-col :span="24">
                        <div class="textHead">
                            <el-form-item>
                                <span>高级</span>
                            </el-form-item>
                        </div>
                    </el-col>
                </el-row>
                <!--卡片区域第二行-->
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="银行" prop="bank">
                            <el-select
                                v-model="valueBank"
                                size="small"
                                multiple
                                collapse-tags
                                style="margin-left: 20px;"
                                placeholder="请选择银行"
                            >
                                <el-option
                                    v-for="item in options"
                                    :key="item.value"
                                    :label="item.label"
                                    :value="item.value"
                                />
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="项目名称" prop="projectName">
                            <el-input
                                size="small"
                                placeholder="请输入项目名称"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="账号类型" prop="accountType">
                            <el-input
                                size="small"
                                placeholder="请输入账号类型"
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
                <!--卡片区域第三行-->
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="账号" prop="account">
                            <el-input
                                style="margin-left: 20px;"
                                size="small"
                                placeholder="请输入账号"
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="账号名称" prop="accountName">
                            <el-input
                                size="small"
                                placeholder="请输入账号名称"
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="财务套账号" prop="FinancialName">
                            <el-input
                                size="small"
                                placeholder="请输入财务套账号"
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
                <!--卡片区域第四行-->
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="账号状态" prop="bank">
                            <el-select
                                v-model="optionAS"
                                size="small"
                                multiple
                                collapse-tags
                                placeholder="请选择对应状态"
                            >
                                <el-option
                                    v-for="item in optionsAS"
                                    :key="item.valueAS"
                                    :label="item.labelAS"
                                    :value="item.valueAS"
                                />
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="创建时间" prop="creationTime">
                            <el-date-picker
                                v-model="chooseTime"
                                size="small"
                                type="daterange"
                                align="middle"
                                unlink-panels
                                range-separator="到"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期"
                                :picker-options="pickerOptions"
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="6" />
                </el-row>
                <!--卡片区域第五行-->
                <el-row type="flex" justify="end">
                    <el-col :span="3">
                        <div>
                            <el-button>重置</el-button>
                            <el-button type="primary">查询</el-button>
                        </div>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>

        <el-card class="box-card">
            <!-- 搜索与添加区域 -->
            <el-row class="itemSpacing">
                <el-col :span="12">
                    <el-button-group>
                        <el-button icon="el-icon-edit">自定义列</el-button>
                        <el-button icon="el-icon-s-grid">选择模式</el-button>
                    </el-button-group>
                </el-col>
                <el-col :span="12">
                    <div class="elbRight">
                        <el-button
                            style="width: 10%;"
                        >
                            新增
                        </el-button>
                        <el-select
                            v-model="valueA"
                            placeholder="导入"
                            style="width: 13%;"
                        >
                            <el-option
                                v-for="item in optionsA"
                                :key="item.valueA"
                                :label="item.labelA"
                                :value="item.valueA"
                            />
                        </el-select>
                    </div>
                </el-col>
            </el-row>
            <!-- 商品列表区域 -->
            <el-table
                :data="information"
                border=""
                style="width: 100%;"
                max-height="250"
            >
                <el-table-column
                    fixed
                    prop="none"
                    label="列"
                    width="50"
                    type="index"
                />
                <el-table-column
                    fixed
                    prop="account"
                    label="账号"
                    width="100"
                >
                    <template slot-scope="scope">
                        <span>{{ scope.row.account }}</span>
                    </template>
                </el-table-column>
                <el-table-column
                    prop="identification"
                    label="标识ID"
                    width="230"
                />
                <el-table-column
                    prop="bankID"
                    label="银行ID"
                    width="210"
                />
                <el-table-column
                    prop="accountName"
                    label="账号名称"
                    width="90"
                />
                <el-table-column
                    prop="accountState"
                    label="账号状态"
                    width="80"
                />
                <el-table-column
                    prop="depositBank"
                    label="开户行"
                    width="150"
                />
                <el-table-column
                    prop="projectName"
                    label="项目名称"
                    width="180"
                />
                <el-table-column
                    prop="financialSetAccountNumber"
                    label="财务套账号"
                    width="180"
                />
                <el-table-column
                    fixed="right"
                    label="操作"
                    width="310"
                >
                    <template>
                        <el-button
                            type="primary"
                            size="small"
                        >
                            编辑
                        </el-button>
                        <el-button
                            type="primary"
                            size="small"
                        >
                            查看流水详情
                        </el-button>
                        <el-button
                            type="danger"
                            size="small"
                        >
                            移除
                        </el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!-- 分页器 -->
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
        <!-- 修改地址的对话框 -->

        <!-- 展示物流进度的对话框 -->
    </div>
</template>

<script>
export default {
    data() {
        return {
            information: [],
            currentPage2: 5,
            currentPage3: 5,
            currentPage4: 4,
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
            chooseTime: '',
            options: [{
                value: '选项1',
                label: '黄金糕银行'
            }, {
                value: '选项2',
                label: '双皮奶银行'
            }, {
                value: '选项3',
                label: '蚵仔煎银行'
            }, {
                value: '选项4',
                label: '龙须面银行'
            }, {
                value: '选项5',
                label: '北京烤鸭银行'
            }],
            valueBank: [],

            optionsA: [{
                valueA: '选项1',
                labelA: '导入'
            }, {
                valueA: '选项2',
                labelA: '导出'
            }],
            valueA: '',

            optionsAS: [{
                valueAS: '选项1',
                labelAS: '正常'
            }, {
                valueAS: '选项2',
                labelAS: '冻结'
            }, {
                valueAS: '选项3',
                labelAS: '存疑'
            }, {
                valueAS: '选项4',
                labelAS: '限制'
            }, {
                valueAS: '选项5',
                labelAS: '停用'
            }],
            optionAS: '',
            tableData: [{
                account: '8606222',
                identification: '8606222021208017891373',
                bankID: '6222021208017891373',
                accountName: 'Shellwe',
                accountState: '正常',
                depositBank: '工商银行',
                projectName: '互联网金融项目实训',
                financialSetAccountNumber: '6222021208017891373'
            }, {
                account: '8606222',
                identification: '8606222021208017891373',
                bankID: '6222021208017891373',
                accountName: 'Shellwe',
                accountState: '正常',
                depositBank: '工商银行',
                projectName: '互联网金融项目实训',
                financialSetAccountNumber: '6222021208017891373'
            }, {
                account: '8606222',
                identification: '8606222021208017891373',
                bankID: '6222021208017891373',
                accountName: 'Shellwe',
                accountState: '正常',
                depositBank: '工商银行',
                projectName: '互联网金融项目实训',
                financialSetAccountNumber: '6222021208017891373'
            }, {
                account: '8606222',
                identification: '8606222021208017891373',
                bankID: '6222021208017891373',
                accountName: 'Shellwe',
                accountState: '正常',
                depositBank: '工商银行',
                projectName: '互联网金融项目实训',
                financialSetAccountNumber: '6222021208017891373'
            }]
        }
    },
    created() {

    },
    mounted: function() {
        this.loadInformation()
    },
    methods: {
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`)
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`)
        },
        loadInformation() {
            var _this = this
            this.$axios.get('http://localhost:8085/findAll').then(resp => {
                if (resp.data.code === 200) {
                    _this.information = resp.data.data
                }
            })
        }
    }
}
</script>

<style>
.el-range-separator {
    width: 20px !important;
}
.textHead {
    font-size: medium;
    color: #1a1a1a;
    font-style: italic;
}
.elbRight {
    display: flex;
    justify-content: flex-end;
}
.itemSpacing {
    margin-bottom: 18px;
}
</style>
