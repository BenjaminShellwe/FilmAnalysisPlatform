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
                        <el-form-item label="项目名称" prop="projectName">
                            <el-input
                                size="small"
                                placeholder="请输入项目名称"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="备注" prop="notes">
                            <el-input
                                size="small"
                                placeholder="相关备注"
                                clearable
                            />
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <div class="elbRight">
                            <el-button>重置</el-button>
                            <el-button type="primary">查询</el-button>
                            <el-button type="primary">新增</el-button>
                        </div>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>

        <el-card class="box-card">
            <el-table
                :data="tableData"
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
                    prop="name"
                    label="名称"
                    width="250"
                />
                <el-table-column
                    prop="notes"
                    label="备注"
                    width="360"
                />
                <el-table-column
                    fixed="right"
                    label="操作"
                    width="320"
                >
                    <template>
                        <el-dropdown size="small" split-button type="primary">
                            编辑
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item
                                    @click="dialogVisible = true"
                                >
                                    网银账号授权
                                </el-dropdown-item>
                                <el-dropdown-item
                                    @click="dialogVisible = true"
                                >
                                    修改部门权限
                                </el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                        <el-button
                            type="primary"
                            size="small"
                        >
                            查看流水详情
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
                <span>时间原因修改增加的操作暂时不做添加</span>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="dialogVisible = false">取 消</el-button>
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
    </div>
</template>

<script>
export default {
    data() {
        return {
            dialogVisible: false,
            currentPage2: 5,
            currentPage3: 5,
            currentPage4: 4,
            tableData: [{
                name: 'Shellwe',
                notes: '正常'
            }, {
                name: 'Shellwe',
                notes: '正常'
            }, {
                name: 'Shellwe',
                notes: '正常'
            }]
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

