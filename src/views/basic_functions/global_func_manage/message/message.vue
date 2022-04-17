<template>
    <div>
        <page-header title="站内通知">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页</div>
                    &nbsp;&nbsp;
                    <div class="inLine">此页面设置广告和个人或企业通知推送</div>
                </div>
            </template>
        </page-header>
        <page-main title="广告通知设置">
            如无特殊情况，广告无法关闭推送
        </page-main>
        <page-main title="站内通知设置">
            <span>是否接收通知 </span>
            <el-switch
                v-model="isShow"
                active-text="开启"
                inactive-text="关闭"
                @click.native="changeIsNeedCaptcha('关闭通知')"
            />
            <div v-show="isShow" id="collapsible">
                <span style="color: red;">注意,关闭全部通知将会使工作通知无法正常投递,请自行设置通知权重</span>
            </div>
            <el-dialog
                title="来自shellwe的警告"
                :visible.sync="dialogVisible"
                width="30%"
            >
                <span>开发中 此操作暂时拒绝</span>
                <span slot="footer" class="dialog-footer">
                    <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                    <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
                </span>
            </el-dialog>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
export default {
    name: 'Message',
    components: {PageHeader},
    data() {
        return {
            dialogVisible: false,
            isShow: true
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        changeShow() {
            this.isShow = !this.isShow
        },
        async changeIsNeedCaptcha(value) {
            this.$confirm(`此操作将${!value ? '开启' : '关闭'}验证, 是否继续？`, '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(async() => {
                this.dialogVisible = !false
                this.isShow = true
            }).catch(() => {
                this.$message.error('取消操作')
                this.isShow = true
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
