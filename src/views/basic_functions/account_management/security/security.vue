<template>
    <div>
        <page-header title="安全中心">
            <template #content>
                <div class="inLine">
                    <p @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为账户的安全设置 此页面设置为管理员可见
                </div>
            </template>
        </page-header>
        <!--  权限控制     -->
        <page-main title="权限控制">
            <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                <div slot="header" class="clearfix">
                    <span>权限控制 开发中 (点击右边进行操作)</span>
                    <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                </div>
                <el-row>
                    <div v-show="pagePermissionControlEShow" style="margin-top: 10px; height: 20px;">
                        <el-form v-model="pagePermissionControl" size="mini" label-position="left">
                            <el-row>
                                <el-row>
                                    <el-col :span="24">
                                        <el-table size="mini" :data="pagePermissionControl.data" border style="width: 100%;" highlight-current-row>
                                            <el-table-column label="序" type="index" width="35px" />
                                            <el-table-column
                                                v-for="(v,i) in pagePermissionControl.columnsHead"
                                                :key="i"
                                                :label="v.title"
                                                :prop="v.field" width="80px"
                                            >
                                                <template #default="scope">
                                                    <span v-if="scope.row.isSet">
                                                        <el-input v-model="pagePermissionControl.sel[v.field]" size="mini" placeholder="请输入" />
                                                    </span>
                                                    <span v-else>{{ scope.row[v.field] }}</span>
                                                </template>
                                            </el-table-column>
                                            <el-table-column label="企业高级权限">
                                                <el-table-column
                                                    v-for="(v,i) in pagePermissionControl.columnsE"
                                                    :key="i+1"
                                                    :prop="v.field"
                                                    :label="v.title"
                                                    :width="v.width"
                                                >
                                                    <template #default="scope">
                                                        <span v-if="scope.row.isSet">
                                                            <el-input v-model="pagePermissionControl.sel[v.field]" size="mini" placeholder="请输入" />
                                                        </span>
                                                        <span v-else>{{ scope.row[v.field] }}</span>
                                                    </template>
                                                </el-table-column>
                                            </el-table-column>
                                            <el-table-column label="企业基础权限">
                                                <el-table-column
                                                    v-for="(v,i) in pagePermissionControl.columnsB"
                                                    :key="i+2"
                                                    :prop="v.field"
                                                    :label="v.title"
                                                    :width="v.width"
                                                >
                                                    <template #default="scope">
                                                        <span v-if="scope.row.isSet">
                                                            <el-input v-model="pagePermissionControl.sel[v.field]" size="mini" placeholder="请输入" />
                                                        </span>
                                                        <span v-else>{{ scope.row[v.field] }}</span>
                                                    </template>
                                                </el-table-column>
                                            </el-table-column>
                                            <el-table-column label="个人权限">
                                                <el-table-column
                                                    v-for="(v,i) in pagePermissionControl.columnsP"
                                                    :key="i+3"
                                                    :prop="v.field"
                                                    :label="v.title"
                                                    :width="v.width"
                                                >
                                                    <template id="personal" #default="scope">
                                                        <span v-if="scope.row.isSet">
                                                            <el-input v-model="pagePermissionControl.sel[v.field]" size="mini" placeholder="请输入" />
                                                        </span>
                                                        <span v-else>{{ scope.row[v.field] }}</span>
                                                    </template>
                                                </el-table-column>
                                            </el-table-column>
                                            <el-table-column
                                                v-for="(v,i) in pagePermissionControl.columnsFoot"
                                                :key="i+4"
                                                :label="v.title"
                                                :prop="v.field"
                                                width="80px"
                                            >
                                                <template #default="scope">
                                                    <span v-if="scope.row.isSet">
                                                        <el-input v-model="pagePermissionControl.sel[v.field]" size="mini" placeholder="请输入" />
                                                    </span>
                                                    <span v-else>{{ scope.row[v.field] }}</span>
                                                </template>
                                            </el-table-column>
                                            <el-table-column label="操作" width="105">
                                                <template #default="scope">
                                                    <span class="el-tag el-tag--info el-tag--mini" style="cursor: pointer;" @click="pwdChange(scope.row,scope.$index,true)">
                                                        {{ scope.row.isSet?'保存':"修改" }}
                                                    </span>
                                                    <span v-if="!scope.row.isSet" class="el-tag el-tag--danger el-tag--mini" style="cursor: pointer;">
                                                        删除
                                                    </span>
                                                    <span v-else class="el-tag  el-tag--mini" style="cursor: pointer;" @click="pwdChange(scope.row,scope.$index,false)">
                                                        取消
                                                    </span>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-col>
                                    <el-col :span="24">
                                        <div class="el-table-add-row" style="width: 99.9%;" @click="addMasterUser()"><span>+ 添加</span></div>
                                    </el-col>
                                </el-row>
                            </el-row>
                        </el-form>
                    </div>
                </el-row>
            </el-card>
        </page-main>
        <page-main title="权限演示">
            {{ $store.state.settings.permissions }}
            <el-card shadow="hover">
                <el-form :model="search" size="small" label-width="180px">
                    <span>权限授予目前是固定在Vue.js前端方便演示</span>
                    此页为系统的数据统计
                    <span v-auth="'permission.browse'">
                        (可见即拥有 Basic权限  基本访问)
                    </span>
                    <el-row>
                        <el-col :span="8">
                            <el-tooltip class="item" effect="dark" content="进阶选项 部门 需要Intermediate或以上等级" placement="top">
                                <el-form-item v-auth="'permission.edit'" label="Intermediate或以上等级">
                                    <el-select v-model="search.department_id" clearable placeholder="演示框1">
                                        <el-option label="所选择不影响后台" :value="1" />
                                        <el-option label="所选择不影响后台" :value="2" />
                                        <el-option label="所选择不影响后台" :value="3" />
                                    </el-select>
                                    <br>
                                    <span v-auth-all="['permission.basic',
                                                       'permission.create',
                                                       'permission.edit',
                                                       'permission.remove',
                                                       'permission.access',
                                                       'permission.department'
                                    ]"
                                    >
                                        (可见即拥有需要Intermediate或以上 !!目前本账号拥有最高权限!!仅fip-admin,不与spring boot复合)
                                    </span>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                        <el-col :span="8">
                            <el-tooltip class="item" effect="dark" content="进阶选项 职位 需要Elementary或以上等级" placement="top">
                                <el-form-item v-auth="['permission.browse', 'permission.create']" label="Elementary或以上等级">
                                    <el-select v-model="search.department_job_id" clearable placeholder="演示框2">
                                        <el-option label="所选择不影响后台" :value="1" />
                                        <el-option label="所选择不影响后台" :value="2" />
                                        <el-option label="所选择不影响后台" :value="3" />
                                    </el-select>
                                    <br>
                                    <span v-auth="['permission.browse', 'permission.create']">
                                        (可见即拥有 Elementary权限  中阶权限)
                                    </span>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                        <el-col :span="8">
                            <el-tooltip class="item" effect="dark" content="进阶选项 角色 需要Primary或以上等级" placement="top">
                                <el-form-item v-auth="'permission.create'" label="Primary或以上等级">
                                    <el-select v-model="search.role_id" clearable placeholder="演示框3">
                                        <el-option label="所选择不影响后台" :value="1" />
                                        <el-option label="所选择不影响后台" :value="2" />
                                    </el-select>
                                    <br>
                                    <span v-auth="'permission.create'">
                                        (可见即拥有 Primary权限  初级权限)
                                    </span>
                                </el-form-item>
                            </el-tooltip>
                        </el-col>
                    </el-row>
                </el-form>
            </el-card>
        </page-main>
        <page-main title="数据脱敏">
            <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                <div slot="header" class="clearfix">
                    <span>数据脱敏 开发中 (点击右边进行操作)</span>
                    <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                </div>
                <el-row calss="pageCSSelrow">
                    <el-button-group>
                        <span>交由网页系统处理脱敏</span>
                        <el-select v-model="pageSelectValue" placeholder="默认中级" size="small" class="pageCSSSelect" shadow="hover">
                            <el-option
                                v-for="item in pageSelectOptions"
                                :key="item.pageSelectValue"
                                :label="item.pageSelectLabel"
                                :value="item.pageSelectValue"
                            />
                        </el-select>
                        <el-tooltip class="item" effect="dark" content="脱敏字符数 默认5" placement="top">
                            <el-input-number v-model="num" :min="1" :max="10" size="small" class="pageCSSSelect" />
                        </el-tooltip>
                    </el-button-group>
                    <el-button type="primary" size="small">提交</el-button>
                </el-row>
                <el-row>
                    <el-button-group>
                        <span>交由系统后台处理脱敏</span>
                        <el-select v-model="pageSelectValue" placeholder="默认中级" size="small" class="pageCSSSelect" shadow="hover">
                            <el-option
                                v-for="item in pageSelectOptions"
                                :key="item.pageSelectValue"
                                :label="item.pageSelectLabel"
                                :value="item.pageSelectValue"
                            />
                        </el-select>
                        <el-tooltip class="item" effect="dark" content="脱敏字符数 默认5" placement="top">
                            <el-input-number v-model="num" :min="1" :max="10" size="small" class="pageCSSSelect" />
                        </el-tooltip>
                    </el-button-group>
                    <el-button type="primary" size="small">提交</el-button>
                </el-row>
            </el-card>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
var generateId = {
    _count: 1,
    get() { return ((+new Date()) + '_' + (this._count++)) }
}
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    props: {
        dataHeight: {
            type: String,
            default: '50px'
        }
    },
    data() {
        return {
            search: {
                name: '',
                department_id: '',
                department_job_id: '',
                role_id: ''
            },
            searchMore: false,
            pageSelectOptions: [{
                pageSelectValue: 'psv1',
                pageSelectLabel: '次级'
            }, {
                value: 'psv2',
                pageSelectValue: '初级'
            }, {
                value: 'psv3',
                pageSelectValue: '中级'
            }, {
                value: 'psv4',
                pageSelectValue: '高级'
            }, {
                value: 'psv5',
                pageSelectValue: '特级'
            }],
            pageSelectValue: '',
            num: 5,
            pagePermissionControl: {
                sel: null, // 选中行
                columnsHead: [
                    { field: 'role', title: '角色', width: 80 }
                ],
                columnsE: [
                    { field: 'enterpriseAdd', title: '高级增添', width: 100 },
                    { field: 'enterpriseAlter', title: '高级修改', width: 100 },
                    { field: 'enterpriseQuery', title: '高级查询', width: 100 },
                    { field: 'enterpriseDelete', title: '高级删除', width: 100}
                ],
                columnsB: [
                    { field: 'basicAdd', title: '基础增添', width: 100 },
                    { field: 'basicAlter', title: '基础修改', width: 100 },
                    { field: 'basicQuery', title: '基础查询', width: 100 },
                    { field: 'basicDelete', title: '基础删除', width: 100}
                ],
                columnsP: [
                    { field: 'personalAdd', title: '个人增添', width: 100 },
                    { field: 'personalAlter', title: '个人修改', width: 100 },
                    { field: 'personalQuery', title: '个人查询', width: 100 },
                    { field: 'personalDelete', title: '个人删除', width: 100}
                ],
                columnsFoot: [
                    { field: 'status', title: '状态', width: 80 }
                ],
                data: [
                    {
                        role: '空或被阻',
                        enterprisePermission: '空或被阻',
                        enterpriseAdd: '空或被阻',
                        enterpriseAlter: '空或被阻',
                        enterpriseQuery: '空或被阻',
                        enterpriseDelete: '空或被阻',
                        basicPermission: '空或被阻',
                        basicAdd: '空或被阻',
                        basicAlter: '空或被阻',
                        basicQuery: '空或被阻',
                        basicDelete: '空或被阻',
                        personalPermission: '空或被阻',
                        personalAdd: '空或被阻',
                        personalAlter: '空或被阻',
                        personalQuery: '空或被阻',
                        personalDelete: '空或被阻',
                        status: '空或被阻'
                    }
                ]
            },
            pagePermissionControlEShow: true,
            pageInputValue: ''
        }
    },
    computed: {
    },
    mounted() {
    },
    methods: {
        back() {
            history.go(-1)
        },
        change() {
            this.$forceUpdate()
        },
        //  读取表格数据
        readMasterUser() {
            //  根据实际情况改
            this.pagePermissionControl.data.map(i => {
                i.id = generateId.get() // 模拟后台插入成功后有了id
                i.isSet = false // 给后台返回数据添加`isSet`标识
                return i
            })
        },
        // 添加账号
        addMasterUser() {
            for (let i of this.pagePermissionControl.data) {
                if (i.isSet) return this.$message.warning('请先保存当前编辑项')
            }
            let j = { id: 0, 'type': '', 'addport': '', 'user': '', 'pwd': '', 'info': '', 'isSet': true, '_temporary': true }
            this.pagePermissionControl.data.push(j)
            this.pagePermissionControl.sel = JSON.parse(JSON.stringify(j))
        },
        // 修改
        pwdChange(row, index, cg) {
            // 点击修改 判断是否已经保存所有操作
            for (let i of this.pagePermissionControl.data) {
                if (i.isSet && i.id != row.id) {
                    this.$message.warning('请先保存当前编辑项')
                    return false
                }
            }
            // 是否是取消操作
            if (!cg) {
                if (!this.pagePermissionControl.sel.id) this.pagePermissionControl.data.splice(index, 1)
                return row.isSet = !row.isSet
            }
            // 提交数据
            if (row.isSet) {
                // 项目是模拟请求操作  自己修改下
                (() => {
                    let data = JSON.parse(JSON.stringify(this.pagePermissionControl.sel))
                    for (let k in data) row[k] = data[k]
                    this.$message({
                        type: 'success',
                        message: '保存成功!'
                    })
                    // 然后这边重新读取表格数据
                    this.readMasterUser()
                    row.isSet = false
                })()
            } else {
                this.pagePermissionControl.sel = JSON.parse(JSON.stringify(row))
                row.isSet = true
            }
        }
    }
}
</script>
<style>
.carousel .item {
    height: 20px;
    background-color: #777;
}
.carousel-inner > .item > img {
    position: absolute;
    top: 0;
    left: 0;
    min-width: 100%;
    height: 200px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 15px;
    opacity: 0.75;
    line-height: 50px;
    height: 50px;
    margin: 0;
}
.el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
}
.el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
}
.el-input .el-input__inner {
    height: 26px;
    padding: 0 6px;
}
.el-input .el-input__icon {
    padding: 0 0 0 90px;
}
.el-table-add-row {
    margin-top: 10px;
    width: 100%;
    height: 34px;
    border: 1px dashed #c1c1cd;
    border-radius: 3px;
    cursor: pointer;
    justify-content: center;
    display: flex;
    line-height: 34px;
}
</style>
