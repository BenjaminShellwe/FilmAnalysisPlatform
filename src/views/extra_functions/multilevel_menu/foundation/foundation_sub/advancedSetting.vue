<template>
    <div>
        <el-card class="itemSpacing">
            <div style="border-bottom: 1px solid #c0c4cc;" />
            <el-form :inline="true">
                <el-row>
                    <el-col :span="24">
                        <div class="textHead">
                            <el-form-item>
                                <span>高级</span>
                            </el-form-item>
                        </div>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col span="12">
                        <el-form-item label="姓名(登录名)" prop="projectName">
                            <el-input
                                size="small"
                                placeholder="请输入您的姓名(登录名)"
                                clearable="true"
                            />
                        </el-form-item>
                    </el-col>
                    <el-col span="12">
                        <el-form-item label="显示已停用的用户" prop="projectName">
                            <el-switch
                                v-model="valueSwitch1"
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
            </el-form>
        </el-card>
        <el-card>
            <el-table
                :data="tableData"
                style="width: 100%;"
                max-height="550"
            >
                <el-table-column
                    fixed
                    prop="ID"
                    label="ID"
                    width="90"
                />
                <el-table-column
                    prop="loginName"
                    label="姓名(登录名)"
                    width="200"
                />
                <el-table-column
                    prop="state"
                    label="状态"
                    width="200"
                >
                    <template slot-scope="scope">
                        <el-tag
                            :type="scope.row.state === '启用' ? 'success' : 'danger'"
                            disable-transitions
                        >
                            {{ scope.row.state }}
                        </el-tag>
                    </template>
                </el-table-column>
                <el-table-column
                    prop="email"
                    label="邮箱"
                    width="200"
                />
                <el-table-column
                    prop="phone"
                    label="手机号"
                    width="180"
                />
                <el-table-column
                    prop="department"
                    label="部门"
                    width="180"
                />
                <el-table-column
                    prop="errorsLogin"
                    label="登录错误次数"
                    width="120"
                />
                <el-table-column
                    fixed="right"
                    label="操作"
                    width="250"
                >
                    <template>
                        <el-button
                            type="primary"
                            size="small"
                        >
                            编辑
                        </el-button>
                        <el-dropdown size="small" split-button>
                            更多
                            <el-dropdown-menu slot="dropdown">
                                <el-dropdown-item
                                    @click="dialogVisible = true"
                                >
                                    新增指定用户
                                </el-dropdown-item>
                                <el-dropdown-item>修改目标密码</el-dropdown-item>
                                <el-dropdown-item
                                    @click="dialogVisible = true"
                                >
                                    删除目标用户
                                </el-dropdown-item>
                            </el-dropdown-menu>
                        </el-dropdown>
                        <el-dialog
                            title="操作提示"
                            :visible.sync="dialogVisible"
                            width="30%"
                        >
                            <span>时间原因修改增加的操作暂时不做添加</span>
                            <span slot="footer" class="dialog-footer">
                                <el-button @click="dialogVisible = false">取 消</el-button>
                                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
                            </span>
                        </el-dialog>
                    </template>
                </el-table-column>
            </el-table>
            <el-pagination
                :current-page="currentPage1"
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
            currentPage1: 15,
            valueSwitch1: false,
            tableData: [{
                ID: '1010',
                loginName: '',
                state: '启用',
                email: 'h.com',
                phone: '12345678912',
                department: '实验开发部门',
                errorsLogin: '0'
            }, {
                ID: '1011',
                loginName: '1',
                state: '禁用',
                email: 'h.com',
                phone: '12345678912',
                department: '实验开发部门',
                errorsLogin: '10'
            }, {
                ID: '1011',
                loginName: '',
                state: '禁用',
                email: 'h.com',
                phone: '12345678912',
                department: '实验开发部门',
                errorsLogin: '10'
            }, {
                ID: '1011',
                loginName: '',
                state: '禁用',
                email: 'h.com',
                phone: '12345678912',
                department: '实验开发部门',
                errorsLogin: '10'
            }]
        }
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
.el-dropdown {
    vertical-align: top;
}
.el-dropdown + .el-dropdown {
    margin-left: 15px;
}
.el-icon-arrow-down {
    font-size: 12px;
}
</style>
