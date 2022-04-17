<template>
    <div>
        <el-card class="box-card itemSpacing">
            <div slot="header" class="clearfix">
                <span>交易详情</span>
            </div>
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
                    <el-col :span="12">
                        <el-form-item label="交易时间段" prop="creationTime">
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
                    <el-col :span="12">
                        <el-form-item label="交易金额" prop="projectName">
                            <el-row>
                                <el-col span="10">
                                    <el-input
                                        size="small"
                                        placeholder="请输入金额"
                                        clearable
                                    />
                                </el-col>
                                <el-col span="2">
                                    <span>~</span>
                                </el-col>
                                <el-col span="12">
                                    <el-input
                                        size="small"
                                        placeholder="请输入金额"
                                        clearable
                                    />
                                </el-col>
                            </el-row>
                        </el-form-item>
                    </el-col>
                </el-row>
                <!--卡片区域第三行-->
                <el-row>
                    <el-col :span="12">
                        <el-form-item label="对方账户" prop="account">
                            <el-input
                                size="small"
                                placeholder="请输入对方账号"
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="对方户名" prop="FinancialName">
                            <el-input
                                size="small"
                                placeholder="请输入对方户名"
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>
        <el-card class="box-card itemSpacing">
            <el-row>
                <el-col span="6">
                    <span>账号</span>
                </el-col>
                <el-col span="6">
                    <span>账号名称</span>
                </el-col>
                <el-col span="6">
                    <span>余额(元)</span>
                </el-col>
                <el-col span="6">
                    <span>项目名称</span>
                </el-col>
            </el-row>
            <el-row>
                <el-col span="6">
                    <span>开户行</span>
                </el-col>
                <el-col span="6">
                    <span>余额更新时间</span>
                </el-col>
                <el-col span="6" />
                <el-col span="6" />
            </el-row>

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
                            style="width: 15%;"
                        >
                            <i class="el-icon-download el-icon--left" />
                            导出
                        </el-button>
                        <el-select
                            v-model="valueS"
                            placeholder="导入"
                            style="width: 13%;"
                        >
                            <el-option
                                v-for="item in optionsS"
                                :key="item.valueS"
                                :label="item.labelS"
                                :value="item.valueS"
                            />
                        </el-select>
                    </div>
                </el-col>
            </el-row>
            <el-table
                :data="recordData"
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
                    prop="tradingDate"
                    label="交易日期"
                    width="100"
                />
                <el-table-column
                    prop="tradingHour"
                    label="交易时间"
                    width="130"
                />
                <el-table-column
                    prop="debit"
                    label="借方发生额"
                    width="110"
                />
                <el-table-column
                    prop="credit"
                    label="贷方发生额"
                    width="90"
                />
                <el-table-column
                    prop="balance"
                    label="账户余额(流水)"
                    width="80"
                />
                <el-table-column
                    prop="payee"
                    label="收(付)方账号"
                    width="150"
                />
                <el-table-column
                    prop="abstract"
                    label="摘要"
                    width="150"
                />
                <el-table-column
                    prop="identification"
                    label="标识"
                    width="130"
                />
                <el-table-column
                    prop="globalIdentification"
                    label="项目名称"
                    width="130"
                />
                <el-table-column
                    prop="update"
                    label="更新时间"
                    width="130"
                />
                <el-table-column
                    fixed="right"
                    label="回单"
                    width="90"
                >
                    <template>
                        <el-button
                            type="primary"
                            size="small"
                        >
                            查看
                        </el-button>
                    </template>
                </el-table-column>
                <el-table-column
                    fixed="right"
                    label="安全区"
                    width="120"
                >
                    <template>
                        <el-button
                            type="primary"
                            size="small"
                        >
                            忽略该流水
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
    </div>
</template>

<script>
export default {
    data() {
        return {

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

            optionsS: [{
                valueS: '选项1',
                labelS: '导入'
            }, {
                valueS: '选项2',
                labelS: '导出'
            }],
            valueS: '',

            recordData: [{
                tradingDate: '2021-07-10',
                tradingHour: '15:30',
                debit: '1373',
                credit: '9179',
                balance: '1111',
                payee: '1321',
                abstract: '互联网金融项目实训',
                identification: '6222021208017891373',
                globalIdentification: '6222021208017891373',
                update: '刚刚'
            }, {
                tradingDate: '2021-07-11',
                tradingHour: '15:30',
                debit: '1373',
                credit: '9179',
                balance: '1111',
                payee: '1321',
                abstract: '互联网金融项目实训',
                identification: '6222021208017891373',
                globalIdentification: '6222021208017891373',
                update: '刚刚'
            }, {
                tradingDate: '2021-06-10',
                tradingHour: '15:30',
                debit: '1373',
                credit: '9179',
                balance: '1111',
                payee: '1321',
                abstract: '互联网金融项目实训',
                identification: '6222021208017891373',
                globalIdentification: '6222021208017891373',
                update: '刚刚'
            }, {
                tradingDate: '2021-07-02',
                tradingHour: '15:30',
                debit: '1373',
                credit: '9179',
                balance: '1111',
                payee: '1321',
                abstract: '互联网金融项目实训',
                identification: '6222021208017891373',
                globalIdentification: '6222021208017891373',
                update: '刚刚'
            }]
        }
    },
    created() {

    },
    methods: {
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`)
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`)
        }
    }
}
</script>

<style>
.el-range-separator {
    width: 20px !important;
}
.shorten {
    width: 50%;
}
.text {
    font-size: 14px;
}
.item {
    margin-bottom: 18px;
}
.clearfix::before,
.clearfix::after {
    display: table;
    content: "";
}
.clearfix::after {
    clear: both;
}
.box-card {
    width: auto;
}
.itemSpacing {
    margin-bottom: 18px;
}
.elbRight {
    display: flex;
    justify-content: flex-end;
}
</style>
