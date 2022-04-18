<template>
    <div>
        <page-header title="数据来源">
            <template #content>
                <div>
                    <div class="inLine">
                        <p class="hover" @click="back">返回上一页</p>
                    </div>
                    <div>
                        此页为系统监控设置
                    </div>
                </div>
            </template>
        </page-header>
        <page-main title="数据源选择">

        </page-main>
        <page-main v-show="pageMainShow" title="数据信息">
            <el-table :data="pageDataList" border stripe highlight-current-row>
                <el-table-column type="index" label="序列" width="50px" />
                <el-table-column prop="userName" label="placeholder1" />
                <el-table-column prop="userID" label="placeholder2" />
                <el-table-column prop="gid" label="placeholder3" />
                <el-table-column prop="type" label="placeholder4" />
                <el-table-column prop="date" label="placeholder5" />
            </el-table>
        </page-main>
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
            pageSwitchShow: true,
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
