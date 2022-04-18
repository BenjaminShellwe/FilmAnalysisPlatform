<template>
    <div>
        <page-header title="表格数据">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>

                <div class="inLine">
                    此页为placeholder
                </div>
            </template>
        </page-header>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>
                开发中 暂时拒绝提交至后台 数据未更改<br>
                此页面将会优先开发企业页面
            </span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script>
export default {
    name: 'table',
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>

<style scoped>
.hover {
    cursor: pointer;
}
</style>
