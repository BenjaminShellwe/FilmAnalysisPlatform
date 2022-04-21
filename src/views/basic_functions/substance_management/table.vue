<template>
    <div>
        <page-header title="表格数据">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                <el-row>
                    <el-col :span="10" class="hover">
                        <span @click="handleCount('minus')">上页</span>
                    </el-col>
                    <el-col :span="4">
                        |
                    </el-col>
                    <el-col :span="10" class="hover">
                        <span @click="handleCount('plus')">下页</span>
                    </el-col>
                </el-row>
            </template>
        </page-header>
        <page-main>
            <el-table
                :data="tableData"
                style="width: 100%;"
            >
                <el-table-column type="expand">
                    <template #default="props">
                        <el-form label-position="left" inline class="demo-table-expand">
                            <el-form-item label="主演">
                                <span>{{ props.row.star }}</span>
                            </el-form-item>
                            <el-form-item label="导演">
                                <span>{{ props.row.director }}</span>
                            </el-form-item>
                            <el-form-item label="预算">
                                <span>{{ props.row.budget }}</span>
                            </el-form-item>
                            <el-form-item label="票房">
                                <span>{{ props.row.boxoffice }}</span>
                            </el-form-item>
                            <el-form-item label="关键词">
                                <span>{{ props.row.keyword }}</span>
                            </el-form-item>
                            <el-form-item label="语言">
                                <span>{{ props.row.language }}</span>
                            </el-form-item>
                            <el-form-item label="受欢迎程度">
                                <span>{{ props.row.popularity }}</span>
                            </el-form-item>
                            <el-form-item label="制片国家">
                                <span>{{ props.row.county }}</span>
                            </el-form-item>
                        </el-form>
                    </template>
                </el-table-column>
                <el-table-column
                    label="列表ID"
                    prop="f1"
                />
                <el-table-column
                    label="电影名称"
                    prop="title"
                />
                <el-table-column
                    label="类型"
                    prop="type"
                />
                <el-table-column
                    label="上映时间"
                    prop="release"
                />
                <el-table-column
                    label="时长"
                    prop="duration"
                />
                <el-table-column
                    label="评分"
                    prop="score"
                />
                <el-table-column
                    label="评价人数"
                    prop="evaluators"
                />
            </el-table>
        </page-main>
    </div>
</template>
<script>
import PageMain from '@/components/PageMain'
import axios from 'axios'
export default {
    name: 'Table',
    components: {PageMain},
    data() {
        return {
            tableData: [],
            num: 0
        }
    },
    mounted() {
        this.handleTableData(0)
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleTableData(val) {
            axios({
                method: 'post',
                url: '/film/allData'
            }).then(response => {
                this.tableData = []
                for (let i = val; i < val + 50; i++) {
                    this.tableData.push(response.data.data[i])
                }
            }).catch(error => {
                console.log(error)
            })
        },
        handleCount(val) {
            if (val == 'plus') {
                console.log(this.num)
                if (this.num < 4800) {
                    this.num += 50
                    console.log(this.num)
                    this.handleTableData(this.num)
                } else {
                    this.$message('已达上限')
                }
            }
            if (val == 'minus') {
                console.log(this.num)
                if (this.num >= 50) {
                    console.log(this.num)
                    this.num -= 50
                    this.handleTableData(this.num)
                } else {
                    this.$message('处于下限')
                }

            }
        }
    }
}
</script>

<style scoped>
.hover {
    cursor: pointer;
}
.demo-table-expand {
    font-size: 0;
}
.demo-table-expand label {
    width: 90px;
    color: #99a9bf;
}
.demo-table-expand .el-form-item {
    margin-right: 0;
    margin-bottom: 0;
    width: 50%;
}
</style>
