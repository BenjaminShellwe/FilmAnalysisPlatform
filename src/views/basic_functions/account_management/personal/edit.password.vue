<template>
    <div>
        <page-header title="修改密码" content="定期修改密码以提高帐号安全性">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为个人账户的密码修改设置页面
                </div>
            </template>
        </page-header>
        <page-main>
            <el-row>
                <el-col :md="24" :lg="12">
                    <el-form ref="form" :model="form" :rules="rules" label-width="120px">
                        <el-form-item label="原密码" prop="password">
                            <el-input v-model="form.password" type="password" placeholder="请输入原密码" />
                        </el-form-item>
                        <el-form-item label="新密码" prop="newpassword">
                            <el-input v-model="form.newpassword" type="password" placeholder="请输入原密码" />
                        </el-form-item>
                        <el-form-item label="确认新密码" prop="checkpassword">
                            <el-input v-model="form.checkpassword" type="password" placeholder="请输入原密码" />
                        </el-form-item>
                    </el-form>
                </el-col>
            </el-row>
        </page-main>
        <fixed-action-bar>
            <el-button type="primary" @click="onSubmit">提交</el-button>
        </fixed-action-bar>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        const validatePassword = (rule, value, callback) => {
            if (value !== this.form.newpassword) {
                callback(new Error('请确认新密码'))
            } else {
                callback()
            }
        }
        return {
            pageGetValue: {
                id: this.$store.state.user.id,
                userName: this.$store.state.user.account
            },
            form: {
                password: '',
                newpassword: '',
                checkpassword: ''
            },
            rules: {
                password: [
                    { required: true, message: '请输入原密码', trigger: 'blur' }
                ],
                newpassword: [
                    { required: true, message: '请输入新密码', trigger: 'blur' },
                    { min: 6, max: 18, trigger: 'blur', message: '密码长度为6到18位' }
                ],
                checkpassword: [
                    { required: true, message: '请输入新密码', trigger: 'blur' },
                    { validator: validatePassword }
                ]
            }
        }
    },
    methods: {
        back() {
            history.go(-1)
        },
        onSubmit() {
            const that = this
            this.$refs['form'].validate(valid => {
                if (valid) {
                    axios({
                        method: 'post',
                        url: '/user/update',
                        data: {
                            id: this.$store.state.user.id,
                            userName: this.$store.state.user.account,
                            psw: this.form.newpassword
                        }
                    }).then(function(response) {
                        if (response.data.code === 200) {
                            that.$message({
                                type: '操作成功',
                                message: '修改成功，请重新登录'
                            })
                            that.$store.dispatch('user/logout').then(() => {
                                this.$router.push('/login')
                            })
                        } else {
                            that.$notify.error({
                                title: '操作失败',
                                message: response.data.msg + ' 错误码: ' + response.data.code,
                                duration: 6500
                            })
                        }

                    }).catch(function(error) {
                        console.log(error)
                    })
                    // this.$store.dispatch('user/editPassword', this.form).then(() => {
                    //     // const that = this
                    //
                    // }).catch(() => {})
                }
            })
        }

    }
}
</script>
