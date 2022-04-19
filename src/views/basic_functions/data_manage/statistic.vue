<template>
    <div>
        <page-header title="数据统计">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                <div class="inLine">
                    placeholder
                </div>
            </template>
        </page-header>
        <page-main title="placeholder">
            <el-row style="padding: 2px 0;">
                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                    <div slot="header" class="clearfix">
                        <span>placeholder</span>
                        <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                    </div>
                    <el-tabs tab-position="left">
                        <el-tab-pane label="placeholder">
                            <el-row>
                                <el-col :span="6" style="padding: 2px;">
                                    <el-card class="Echarts" body-style="padding: 1px" style="padding: 1px; width: 340px;" shadow="hover">
                                        <div id="chartsRecruit" style="width: 300px; height: 750px; padding: 2px;" />
                                    </el-card>
                                </el-col>
                                <el-col :span="8" style="padding: 2px;">
                                    <el-card class="Echarts" body-style="padding: 1px" style="padding: 1px;" shadow="hover">
                                        <div id="chartsDetails" style="width: 450px; height: 750px;" />
                                    </el-card>
                                </el-col>
                                <el-col :span="10" style="padding: 2px;">
                                    <el-card class="Echarts" body-style="padding: 1px" style="padding: 1px;" shadow="hover">
                                        <div id="chartsResults" style="width: 600px; height: 750px; padding: 2px;" />
                                    </el-card>
                                </el-col>
                            </el-row>
                            <el-row>
                                <el-table
                                    :data="tableData"
                                    :span-method="arraySpanMethod"
                                    border
                                    style="width: 100%;"
                                >
                                    <el-table-column
                                        prop="id"
                                        label="ID"
                                        width="180"
                                    />
                                    <el-table-column
                                        prop="name"
                                        label="姓名"
                                    />
                                    <el-table-column
                                        prop="amount1"
                                        sortable
                                        label="数值 1"
                                    />
                                    <el-table-column
                                        prop="amount2"
                                        sortable
                                        label="数值 2"
                                    />
                                    <el-table-column
                                        prop="amount3"
                                        sortable
                                        label="数值 3"
                                    />
                                </el-table>
                                <el-table
                                    :data="tableData"
                                    :span-method="objectSpanMethod"
                                    border
                                    style="width: 100%; margin-top: 20px;"
                                >
                                    <el-table-column
                                        prop="id"
                                        label="ID"
                                        width="180"
                                    />
                                    <el-table-column
                                        prop="name"
                                        label="姓名"
                                    />
                                    <el-table-column
                                        prop="amount1"
                                        label="数值 1（元）"
                                    />
                                    <el-table-column
                                        prop="amount2"
                                        label="数值 2（元）"
                                    />
                                    <el-table-column
                                        prop="amount3"
                                        label="数值 3（元）"
                                    />
                                </el-table>
                            </el-row>
                        </el-tab-pane>
                        <el-tab-pane label="placeholder">
                            <el-tabs tab-position="top">
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                            </el-tabs>
                        </el-tab-pane>
                        <el-tab-pane label="placeholder">
                            <span>placeholder</span>
                            <span>placeholder</span>
                        </el-tab-pane>
                    </el-tabs>
                </el-card>
            </el-row>
            <el-row style="padding: 2px 0;">
                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                    <div slot="header" class="clearfix">
                        <span>placeholder</span>
                        <el-button style="float: right; padding: 3px 0;" type="text">placeholder</el-button>
                    </div>
                    <el-tabs tab-position="left">
                        <el-tab-pane label="placeholder">
                            <el-tabs tab-position="top">
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                            </el-tabs>
                        </el-tab-pane>
                        <el-tab-pane label="placeholder">
                            <h2>placeholder</h2>
                            <el-tabs tab-position="top">
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                                <el-tab-pane label="placeholder">
                                    <el-row>
                                        <el-table
                                            :data="tableData"
                                            :span-method="arraySpanMethod"
                                            border
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                sortable
                                                label="数值 1"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                sortable
                                                label="数值 2"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                sortable
                                                label="数值 3"
                                            />
                                        </el-table>
                                        <el-table
                                            :data="tableData"
                                            :span-method="objectSpanMethod"
                                            border
                                            style="width: 100%; margin-top: 20px;"
                                        >
                                            <el-table-column
                                                prop="id"
                                                label="ID"
                                                width="180"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="姓名"
                                            />
                                            <el-table-column
                                                prop="amount1"
                                                label="数值 1（元）"
                                            />
                                            <el-table-column
                                                prop="amount2"
                                                label="数值 2（元）"
                                            />
                                            <el-table-column
                                                prop="amount3"
                                                label="数值 3（元）"
                                            />
                                        </el-table>
                                    </el-row>
                                </el-tab-pane>
                            </el-tabs>
                        </el-tab-pane>
                    </el-tabs>
                </el-card>
            </el-row>
            <el-row style="padding: 2px 0;">
                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                    <div slot="header" class="clearfix">
                        <span>placeholder</span>
                        <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                    </div>
                    <el-tabs tab-position="left">
                        <el-tab-pane label="placeholder">
                            <h2>placeholder</h2>
                            <el-table
                                :data="pagePropsValueUni.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
                                style="width: 100%;"
                                border
                            >
                                <el-table-column
                                    v-for="(item, index) in pageTableHeaderUni"
                                    :key="index"
                                    :prop="index"
                                    :label="item"
                                    :fit="true"
                                    sortable
                                    min-width="30px"
                                />
                                <el-table-column
                                    align="right"
                                    fixed="right"
                                    width="160px"
                                >
                                    <template slot="header">
                                        <input
                                            v-model="search"
                                            size="mini"
                                            placeholder="输入事务ID搜索"
                                            style="width: 135px;"
                                        >
                                    </template>
                                    <template #default="scope">
                                        <el-button
                                            size="mini"
                                            @click="handleEdit(scope.$index, scope.row)"
                                        >
                                            Edit
                                        </el-button>
                                        <el-button
                                            size="mini"
                                            type="danger"
                                            @click="handleDelete(scope.$index, scope.row)"
                                        >
                                            Delete
                                        </el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-tab-pane>
                        <el-tab-pane label="placeholder">
                            <h2>placeholder</h2>
                            <el-table
                                :data="pagePropsValueUni.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
                                style="width: 100%;"
                                border
                            >
                                <el-table-column
                                    v-for="(item, index) in pageTableHeaderUni"
                                    :key="index"
                                    :prop="index"
                                    :label="item"
                                    :fit="true"
                                    sortable
                                    min-width="30px"
                                />
                                <el-table-column
                                    align="right"
                                    fixed="right"
                                    width="160px"
                                >
                                    <template slot="header">
                                        <input
                                            v-model="search"
                                            size="mini"
                                            placeholder="输入事务ID搜索"
                                            style="width: 135px;"
                                        >
                                    </template>
                                    <template #default="scope">
                                        <el-button
                                            size="mini"
                                            @click="handleEdit(scope.$index, scope.row)"
                                        >
                                            Edit
                                        </el-button>
                                        <el-button
                                            size="mini"
                                            type="danger"
                                            @click="handleDelete(scope.$index, scope.row)"
                                        >
                                            Delete
                                        </el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-tab-pane>
                        <el-tab-pane label="placeholder">
                            <h2>placeholder</h2>
                            <el-table
                                :data="pagePropsValueUni.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
                                style="width: 100%;"
                                border
                            >
                                <el-table-column
                                    v-for="(item, index) in pageTableHeaderUni"
                                    :key="index"
                                    :prop="index"
                                    :label="item"
                                    :fit="true"
                                    sortable
                                    min-width="30px"
                                />
                                <el-table-column
                                    align="right"
                                    fixed="right"
                                    width="160px"
                                >
                                    <template slot="header">
                                        <input
                                            v-model="search"
                                            size="mini"
                                            placeholder="输入事务ID搜索"
                                            style="width: 135px;"
                                        >
                                    </template>
                                    <template #default="scope">
                                        <el-button
                                            size="mini"
                                            @click="handleEdit(scope.$index, scope.row)"
                                        >
                                            Edit
                                        </el-button>
                                        <el-button
                                            size="mini"
                                            type="danger"
                                            @click="handleDelete(scope.$index, scope.row)"
                                        >
                                            Delete
                                        </el-button>
                                    </template>
                                </el-table-column>
                            </el-table>
                        </el-tab-pane>
                    </el-tabs>
                </el-card>
            </el-row>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
import * as echarts from 'echarts'

const graphData = [
    ['2022-02-01', 26],
    ['2022-02-04', 20],
    ['2022-02-09', 27],
    ['2022-02-13', 84],
    ['2022-02-18', 24],
    ['2022-02-23', 41],
    ['2022-03-14', 98]
]
const links = graphData.map(function(item, idx) {
    return {
        source: idx,
        target: idx + 1
    }
})
links.pop()
function getVirtulData(year) {
    year = year || '20'
    var date = +echarts.number.parseDate(year + '-01-01')
    var end = +echarts.number.parseDate(+year + 1 + '-01-01')
    var dayTime = 3600 * 24 * 100
    var data = []
    for (var time = date; time < end; time += dayTime) {
        data.push([
            echarts.format.formatTime('yyyy-MM-dd', time),
            Math.floor(Math.random() * 100)
        ])
    }
    return data
}
// prettier-ignore
let dataAxis = ['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放']
// prettier-ignore
let data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220]
let yMax = 500
let dataShadow = []
for (let i = 0; i < data.length; i++) {
    dataShadow.push(yMax)
}
export default {
    name: 'Statistic',
    components: {PageMain, PageHeader},
    data() {
        return {
            value: new Date(),
            search: '',
            pageActiveCollapse: '',
            tableData: [{
                id: '12987122',
                name: 'shellwe',
                amount1: '234',
                amount2: '3.2',
                amount3: 10
            }, {
                id: '12987123',
                name: 'shellwe',
                amount1: '165',
                amount2: '4.43',
                amount3: 12
            }, {
                id: '12987124',
                name: 'shellwe',
                amount1: '324',
                amount2: '1.9',
                amount3: 9
            }, {
                id: '12987125',
                name: 'shellwe',
                amount1: '621',
                amount2: '2.2',
                amount3: 17
            }, {
                id: '12987126',
                name: 'shellwe',
                amount1: '539',
                amount2: '4.1',
                amount3: 15
            }],
            pageTableHeaderUni: {
                id: '事务ID',
                position: '职位',
                positionStatus: '职位状态',
                department: '部门',
                departmentStatus: '部门状态',
                CV: '收到简历',
                passCV: '初筛合格简历',
                effective: '有效率',
                present: '通知后到场者',
                attendance: '到场率',
                pass: '初试通过',
                passRate: '通过率',
                description: '基本描述'
            },
            pagePropsValueUni: [
                {
                    id: '202202122333',
                    position: '经理',
                    positionStatus: '缺乏',
                    department: '项目管理部',
                    departmentStatus: 'insufficiency(未达部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                },
                {
                    id: '202202122334',
                    position: '文秘',
                    positionStatus: '缺乏',
                    department: '总务部',
                    departmentStatus: 'sufficiency(达到部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                },
                {
                    id: '202202122336',
                    position: '网络工程师',
                    positionStatus: '缺乏',
                    department: '网络系统部',
                    departmentStatus: 'sufficiency(达到部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                },
                {
                    id: '202202122339',
                    position: '研发工程师',
                    positionStatus: '缺乏',
                    department: '网络系统部',
                    departmentStatus: 'sufficiency(达到部门标准人数)',
                    CV: '50',
                    passCV: '25',
                    effective: '50%',
                    present: '13',
                    attendance: '26%',
                    pass: '5',
                    passRate: '38%',
                    description: '基本描述'
                }
            ]
        }
    },
    mounted() {
        this.handleEcharts()
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleChange(val) {
            console.log(val)
        },
        handleEdit(index, row) {
            console.log(index, row)
        },
        handleDelete(index, row) {
            console.log(index, row)
        },
        handleEcharts() {
            // 月招聘图表
            let chartRecruit = this.$echarts.init(document.getElementById('chartsRecruit'))
            let optionRecruit = {
                tooltip: {},
                calendar: {
                    top: 'middle',
                    left: 'center',
                    orient: 'vertical',
                    cellSize: 40,
                    yearLabel: {
                        margin: 50,
                        fontSize: 30
                    },
                    dayLabel: {
                        firstDay: 1,
                        nameMap: 'cn'
                    },
                    monthLabel: {
                        nameMap: 'cn',
                        margin: 15,
                        fontSize: 20,
                        color: '#999'
                    },
                    range: ['2022-02', '2022-03-31']
                },
                visualMap: {
                    min: 0,
                    max: 100,
                    type: 'piecewise',
                    left: 'center',
                    bottom: 20,
                    inRange: {
                        color: ['#5291FF', '#C7DBFF']
                    },
                    seriesIndex: [1],
                    orient: 'horizontal'
                },
                series: [
                    {
                        type: 'graph',
                        edgeSymbol: ['none', 'arrow'],
                        coordinateSystem: 'calendar',
                        links: links,
                        symbolSize: 15,
                        calendarIndex: 0,
                        itemStyle: {
                            color: 'yellow',
                            shadowBlur: 9,
                            shadowOffsetX: 1.5,
                            shadowOffsetY: 3,
                            shadowColor: '#555'
                        },
                        lineStyle: {
                            color: '#D10E00',
                            width: 1,
                            opacity: 1
                        },
                        data: graphData,
                        z: 20
                    },
                    {
                        type: 'heatmap',
                        coordinateSystem: 'calendar',
                        data: getVirtulData('2022')
                    }
                ]
            }
            chartRecruit.setOption(optionRecruit)
            // 分数柱形图表
            let chartResults = this.$echarts.init(document.getElementById('chartsResults'))
            let optionResults = {
                title: {
                    text: '特性示例：渐变色 阴影 点击缩放',
                    subtext: 'Feature Sample: Gradient Color, Shadow, Click Zoom'
                },
                xAxis: {
                    data: dataAxis,
                    axisLabel: {
                        inside: true,
                        color: '#fff'
                    },
                    axisTick: {
                        show: false
                    },
                    axisLine: {
                        show: false
                    },
                    z: 10
                },
                yAxis: {
                    axisLine: {
                        show: false
                    },
                    axisTick: {
                        show: false
                    },
                    axisLabel: {
                        color: '#999'
                    }
                },
                dataZoom: [
                    {
                        type: 'inside'
                    }
                ],
                series: [
                    {
                        type: 'bar',
                        showBackground: true,
                        itemStyle: {
                            color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                { offset: 0, color: '#83bff6' },
                                { offset: 0.5, color: '#188df0' },
                                { offset: 1, color: '#188df0' }
                            ])
                        },
                        emphasis: {
                            itemStyle: {
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                    { offset: 0, color: '#2378f7' },
                                    { offset: 0.7, color: '#2378f7' },
                                    { offset: 1, color: '#83bff6' }
                                ])
                            }
                        },
                        data: data
                    }
                ]
            }
            chartResults.setOption(optionResults)
            //  详细赋分图表
            let chartDetails = this.$echarts.init(document.getElementById('chartsDetails'))
            let optionDetails = {
                title: {
                    text: 'Basic Radar Chart'
                },
                legend: {
                    data: ['Allocated Budget', 'Actual Spending']
                },
                radar: {
                    // shape: 'circle',
                    indicator: [
                        { name: 'Sales', max: 6500 },
                        { name: 'Admin', max: 16000 },
                        { name: 'IT', max: 30000 },
                        { name: 'Support', max: 38000 },
                        { name: 'Development', max: 52000 },
                        { name: 'Marketing', max: 25000 }
                    ]
                },
                series: [
                    {
                        name: 'Budget vs spending',
                        type: 'radar',
                        data: [
                            {
                                value: [4200, 3000, 20000, 35000, 50000, 18000],
                                name: 'Allocated Budget'
                            },
                            {
                                value: [5000, 14000, 28000, 26000, 42000, 21000],
                                name: 'Actual Spending'
                            }
                        ]
                    }
                ]
            }
            chartDetails.setOption(optionDetails)
        },
        arraySpanMethod({rowIndex, columnIndex }) {
            if (rowIndex % 2 === 0) {
                if (columnIndex === 0) {
                    return [1, 2]
                } else if (columnIndex === 1) {
                    return [0, 0]
                }
            }
        },

        objectSpanMethod({rowIndex, columnIndex }) {
            if (columnIndex === 0) {
                if (rowIndex % 2 === 0) {
                    return {
                        rowspan: 2,
                        colspan: 1
                    }
                } else {
                    return {
                        rowspan: 0,
                        colspan: 0
                    }
                }
            }
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.pageTabCSS {
    height: auto;
    min-height: 150px;
}
</style>
