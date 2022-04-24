<template>
    <div>
        <page-header title="Mock" content="通过拦截 Ajax 请求，返回模拟的响应数据，可以让前端工程师独立于后端进行开发，本演示站的登录和权限获取就是通过 mock 实现的。更多 Mock 语法规则请查询官方文档">
            <el-button icon="el-icon-link" @click="open('http://mockjs.com/')">Mock.js 官网</el-button>
        </page-header>
        <page-main>
            <el-button @click="getPermission">测试：获取用户权限</el-button>
        </page-main>
        <el-dialog
            title="来自00的警告"
            :visible.sync="dialogVisible"
            width="30%"
            :before-close="nameCheck"
        >
            <span>此处必须输入验证信息</span>
            <el-input v-model="pageInput" placeholder="请输入测试人员名称" />{{ msg }}
            <span slot="footer" class="dialog-footer">
                <el-button @click="back()">返 回</el-button>
                <el-button type="primary" @click="nameCheck">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
export default {
    data() {
        return {
            dialogVisible: true,
            pageInput: '',
            msg: ''
        }
    },
    methods: {
        getPermission() {
            this.$store.dispatch('user/getPermissions').then(res => {
                this.$notify({
                    title: '当前用户权限',
                    dangerouslyUseHTMLString: true,
                    message: res.map(p => `<p>${p}</p>`).join('')
                })
            })
        },
        open(url) {
            window.open(url, 'top')
        },
        nameCheck(val) {
            console.log(this.pageInput)
            val = this.pageInput
            if (val == '00' || val == '01') {
                this.dialogVisible = false
            } else {
                this.msg = '此字符未授权 !请尝试全名'
                this.dialogVisible = true
            }
        },
        back() {
            history.go(-1)
        }
    }
}
</script>
