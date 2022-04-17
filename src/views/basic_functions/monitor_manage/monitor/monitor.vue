<template>
    <div>
        <page-header title="监控设置">
            <template #content>
                <div>
                    <div class="inLine">
                        <p class="hover" @click="back">返回上一页</p>
                    </div>
                    &nbsp;
                    <div>
                        此页为系统监控设置
                    </div>
                    <span>是否读取监控数据 </span>
                    <el-switch
                        v-model="pageMainShow"
                        active-text="开启"
                        inactive-text="关闭"
                        @click="handleSwitchChange"
                    />
                </div>
            </template>
        </page-header>
        <page-main v-show="pageMainShow">
            <el-table :data="pageDataList" border stripe highlight-current-row>
                <el-table-column type="index" label="序列" width="50px" />
                <el-table-column prop="userName" label="账户名称" />
                <el-table-column prop="userID" label="账户ID" />
                <el-table-column prop="gid" label="GID" />
                <el-table-column prop="type" label="操作类型" />
                <el-table-column prop="date" label="操作时间" />
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
