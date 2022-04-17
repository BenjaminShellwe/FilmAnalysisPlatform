<template>
    <div>
        <page-header title="通知设置">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页&nbsp;&nbsp;</div>
                    <div class="inLine">此页面设置本管理系统通知推送</div>
                </div>
            </template>
        </page-header>
        <page-main title="系统通知设置">
            如无特殊权限，重要系统通知无法关闭推送
        </page-main>
        <page-main title="推送类型与主题风格设置">
            <span>系统通知类型管理 </span>
            <el-switch
                v-model="pageSwitch"
                active-text="系统化"
                inactive-text="自定义"
                @click.native="changeIsNeedCaptcha(pageSwitch)"
            />
            <div>
                <span v-show="pageVisibleUni" style="color: lightgreen;">注意,选择自定义将需要手动配置管理通知权重,但目前不支持自定义</span>
                <span v-show="pageVisibleBin" style="color: red;">注意,选择系统化将会由后台管理通知权重与通知主题风格</span>
            </div>
        </page-main>
        <page-main v-show="pageVisibleTer" title="通知详情 (主题默认 即ElementUI)">
            <el-row>
                <el-col :span="10">
                    <el-button
                        plain
                        @click="open1"
                    >
                        成功
                    </el-button>
                    <el-button
                        plain
                        @click="open2"
                    >
                        警告
                    </el-button>
                    <el-button
                        plain
                        @click="open3"
                    >
                        消息
                    </el-button>
                    <el-button
                        plain
                        @click="open4"
                    >
                        错误
                    </el-button>
                </el-col>
                <el-col :span="10">
                    <el-card style="margin-left: 20px; margin-right: 20px;" shadow="hover">
                        <span>暂时不支持修改通知风格</span>
                    </el-card>
                </el-col>
            </el-row>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Message',
    components: {PageMain, PageHeader},
    data() {
        return {
            dialogVisible: false,
            pageSwitch: true,
            pageVisibleUni: false,
            pageVisibleBin: true,
            pageVisibleTer: true,
            pageCollapse: ['']
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        async changeIsNeedCaptcha(val) {
            this.$confirm(`此操作将${!val ? '自定义' : '系统化'}验证, 是否继续？`, '来自shellwe的提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(async() => {
                this.pageVisibleUni = !val
                this.pageVisibleBin = val
            }).catch(() => {
                this.$message.error('取消操作')
                this.pageSwitch = !val
            })
        },
        open1() {
            this.$notify({
                title: '成功',
                message: '这是一条成功的提示通知',
                type: 'success'
            })
        },
        open2() {
            this.$notify({
                title: '警告',
                message: '这是一条警告的提示通知',
                type: 'warning'
            })
        },
        open3() {
            this.$notify.info({
                title: '消息',
                message: '这是一条消息的提示通知'
            })
        },
        open4() {
            this.$notify.error({
                title: '错误',
                message: '这是一条错误的提示通知'
            })
        }
    }
}
</script>
<style>
.inLine {
    display: inline-block;
}
.hover {
    cursor: pointer;
}
</style>

