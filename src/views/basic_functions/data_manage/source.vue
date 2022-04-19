<template>
    <div>
        <page-header title="数据来源">
            <template #content>
                <el-row>
                    <el-col>
                        <p class="hover" @click="back">返回上一页</p>
                    </el-col>
                </el-row>
            </template>
        </page-header>

        <page-main title="数据来源">
            <el-descriptions class="margin-top" title="当前使用数据库信息" :column="2" border>
                <template slot="extra">
                    <el-button type="primary" size="small" @click="dialogSelect = true">操作</el-button>
                </template>
                <el-descriptions-item>
                    <template slot="label">
                        数据库名
                    </template>
                    created_by_shellwe
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        数据归属
                    </template>
                    本地数据
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        更新日期
                    </template>
                    2022-04-19
                </el-descriptions-item>
                <el-descriptions-item>
                    <template slot="label">
                        备注信息
                    </template>
                    <el-tag size="small">基本数据库</el-tag>
                </el-descriptions-item>
            </el-descriptions>
        </page-main>

        <page-main title="数据信息">
            <el-table :data="pageDataList" border stripe highlight-current-row>
                <el-table-column type="index" label="序列" width="50px" />
                <el-table-column prop="userName" label="placeholder1" />
                <el-table-column prop="userID" label="placeholder2" />
                <el-table-column prop="gid" label="placeholder3" />
                <el-table-column prop="type" label="placeholder4" />
                <el-table-column prop="date" label="placeholder5" />
            </el-table>
        </page-main>
        <el-dialog
            title="数据调整"
            :visible.sync="dialogSelect"
            width="30%"
            :before-close="handleClose"
        >
            <el-row>
                <el-col :span="6" style="padding-top: 5px;">
                    <span>选择数据库</span>
                </el-col>
                <el-col :span="10">
                    <el-select v-model="selectData" placeholder="请选择">
                        <el-option
                            v-for="item in options"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value">
                        </el-option>
                    </el-select>
                </el-col>
            </el-row>
            <el-row>

            </el-row>
            <span slot="footer" class="dialog-footer">
                <el-button @click="dialogSelect = false">取 消</el-button>
                <el-button type="primary" @click="dialogSelect = false">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
import axios from 'axios'
export default {
    name: 'Monitor',
    components: {PageMain, PageHeader},
    data() {
        return {
            options: [{
                value: '选项1',
                label: '数据库一'
            }, {
                value: '选项2',
                label: '数据库二'
            }, {
                value: '选项3',
                label: '爬虫获取'
            }],
            selectData: '',
            dialogSelect: false,
            pageMainShow: true,
            pageDataList: [{}]
        }
    },
    mounted() {
        this.handleQueryValue()
        this.$nextTick(() => {
            // 获取表头高度，然后设置 .el-table__body-wrapper 的 height
            let height = document.getElementsByClassName('el-table__header-wrapper')[0].offsetHeight
            document.getElementsByClassName('el-table__body-wrapper')[0].style.height = `calc(90% - ${height}px)`
        })
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleClose(done) {
            this.$confirm('确认取消？')
                .then(() => {
                    done()
                })
                .catch(() => {})
        },
        handleSwitchChange() {
            this.pageMainShow = !this.pageMainShow
            console.log(this.pageMainShow)
        },
        handleQueryValue() {
            const that = this
            axios({
                method: 'post',
                url: '/monitor/queryAll'
            }).then(function(response) {
                // console.log(response)
                that.pageDataList = response.data.data
            }).catch(function(error) {
                console.log(error)
            })
        }
    }
}
</script>

<style lang="scss" scoped>
.hover {
    cursor: pointer;
}
.page-main {
    display: flex;
    flex-direction: column;

    // 减去的 40px 为 page-main 的上下 margin
    // 减去的 130px 为 page-header 的高度，如果没有设置，可以去掉

    height: calc(100% - 40px - 130px);
    ::v-deep .el-table {
        height: 100%;
        .el-table__body-wrapper {
            overflow-y: auto;
        }
    }
}
</style>
