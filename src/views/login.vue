<template>
    <div>
        <div class="bg-banner" />
        <div id="login-box">
            <div class="login-banner" />
            <el-form ref="form" :model="form" :rules="rules" class="login-form" auto-complete="on" label-position="left">
                <div class="title-container">
                    <h3 class="title">{{ title }}管理后台</h3>
                </div>
                <div>
                    <el-form-item prop="account">
                        <el-input ref="name" v-model="form.account" placeholder="用户名" type="text" tabindex="1" auto-complete="on">
                            <svg-icon slot="prefix" name="user" />
                        </el-input>
                    </el-form-item>
                    <el-form-item prop="password">
                        <el-input ref="password" v-model="form.password" :type="passwordType" placeholder="密码" tabindex="2" auto-complete="on" @keyup.enter.native="handleLogin">
                            <svg-icon slot="prefix" name="password" />
                            <svg-icon slot="suffix" :name="passwordType === 'password' ? 'eye' : 'eye-open'" @click="showPassword" />
                        </el-input>
                    </el-form-item>
                </div>
                <el-checkbox v-model="form.remember">记住我</el-checkbox>
                <el-button-group style="margin-left: 10px;">
                    <el-button :loading="pageButtonLoading" type="primary" style="width: 50%;" size="small" @click.native.prevent="handleLogin">登 录</el-button>
                    <el-button :loading="pageButtonLoading" type="primary" style="width: 50%;" size="small" @click="pageDialogFormVisible = true">注 册</el-button>
                </el-button-group>
                <div style="margin-top: 20px; margin-bottom: -10px; color: #666; font-size: 14px; text-align: center; font-weight: bold;">
                    <span style="margin-right: 5px;">演示帐号一键登录：</span>
                    <el-button type="danger" size="mini" @click="testAccount('admin')">admin</el-button>
                    <el-button type="danger" size="mini" plain @click="testAccount('tester')">tester</el-button>
                </div>
            </el-form>
        </div>
        <Copyright v-if="$store.state.settings.showCopyright" />
        <el-dialog title="快速注册" :visible.sync="pageDialogFormVisible">
            <el-form :model="form">
                <el-form-item label="账户名称" :label-width="pageFormLabelWidth">
                    <input v-model="userName" class="form-control" type="text" placeholder="用户名" @blur="blur" @focus="focus" @input="userNameLimit">
                    <br>{{ msg }}<br>
                </el-form-item>
                <el-form-item label="用户密码" :label-width="pageFormLabelWidth">
                    <input v-model="userPassword" class="form-control" type="password" placeholder="密码" @input="userPasswordLimit"><br>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button :disabled="pageButtonDisabled" @click="reject">注 册</el-button>
                <el-button v-show="pageButtonVisible" type="primary" @click="pageDialogFormVisible = false">返 回</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'LoginSignup',
    data() {
        return {
            msg: '',
            pageButtonDisabled: true,
            pageButtonLoading: false,
            pageButtonVisible: false,
            pageDialogFormVisible: false,
            pageFormLabelWidth: '100px',
            title: process.env.VUE_APP_TITLE,
            userName: '',
            userPassword: '',
            form: {
                account: localStorage.login_account || '',
                password: '',
                id: '',
                remember: !!localStorage.login_account
            },
            rules: {
                account: [
                    { required: true, trigger: 'blur', message: '请输入用户名' }
                ],
                password: [
                    { required: true, trigger: 'blur', message: '请输入密码' },
                    { min: 6, max: 18, trigger: 'blur', message: '密码长度为6到18位' }
                ]
            },
            loading: false,
            passwordType: 'password',
            redirect: undefined
        }
    },
    watch: {
        $route: {
            handler: function(route) {
                this.redirect = route.query && route.query.redirect
            },
            immediate: true
        }
    },
    methods: {
        showPassword() {
            this.passwordType = this.passwordType === 'password' ? '' : 'password'
            this.$nextTick(() => {
                this.$refs.password.focus()
            })
        },
        handleLogin() {
            this.pageButtonLoading = true
            const pattern = /^(\d{6})|(\d{8})$/g
            axios.post('/user/selectUserName', {
                userName: this.form.account,
                userPassword: this.form.password
                // headers: {'Content-Type': application/x-www-form-urlencoded'}   // 跨域
            }).then(data => {
                if (data.data == '0') {
                    alert('用户不存在')
                    this.pageButtonLoading = false
                } else if (data.data == '1') {
                    console.log('1data.data= ' + data.data)
                    alert('登录失败，账号或密码错误')
                    this.pageButtonLoading = false
                } else if (pattern.test(data.data)) {
                    // 当前窗体跳转
                    this.$refs.form.validate(valid => {
                        if (valid) {
                            this.loading = true
                            this.form.id = data.data
                            this.$store.dispatch('user/login', this.form).then(() => {
                                this.loading = false
                                console.log('处理中')
                                this.form.remember && localStorage.setItem('login_account', this.form.account)
                                console.log('跳转')
                                this.$router.push({ path: this.redirect || '/' })
                            }).catch(() => {
                                this.pageButtonLoading = false
                            })
                        }
                    })
                }
                // 新窗体跳转
                // window.open('/user/successLogin')
            }).catch(function() {
                console.log('传输失败')
            })
        },
        testAccount(account) {
            this.form.account = account
            this.form.password = '123456'
            this.handleLogin()
        },
        userPasswordLimit: function() {
            this.userPassword = this.userPassword.replace(/[^a-zA-Z0-9]/g, '')
        },
        // 限制输入特殊字符
        userNameLimit: function() {
            this.userName = this.userName.replace(/[ `~!@#$%^&*()_\-+=<>?:"{}|,./;'\\[\]·~！@#￥%……&*（）——\-+={}|《》？：“”【】、；‘’，。、]/g, '')
        },
        /**
         * 失去焦点
         * */
        blur: function() {
            if (this.userName.length <= 0) {
                this.msg = '用户名不能为空'
            } else {
                console.log('执行axios')
                axios.post('/user/select', {
                    userName: this.userName
                }).then(data => {
                    console.log(data)
                    if (data.data == '0') {
                        this.msg = '用户名可创建'
                        this.pageButtonDisabled = false
                    } else if (data.data == '1') {
                        this.msg = '用户名已存在'
                    }
                }).catch(function() {
                    console.log('存在错误 请联系shellwe')
                })
            }
        },
        reject() {
            alert('为保证数据库安全,目前不开放注册')
        },
        /**
         * 获取焦点
         * */
        focus: function() {
            this.msg = null
        },
        /**
         * 点击注册按钮事件
         * */
        register: function() {
            this.loading = true
            if (this.userName.length <= 0) {
                alert('用户名不能为空')
            } else if (this.userPassword.length <= 0) {
                alert('密码不能为空')
            } else {
                this.loading = true
                axios.post('/user/addUser', {
                    userName: this.userName,
                    userPassword: this.userPassword,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}   // 跨域
                }).then(data => {
                    if (data.data == '1') {
                        this.$notify({
                            title: '成功',
                            message: '您已成功注册账号',
                            type: 'success'
                        })
                        this.pageDialogFormVisible = false
                    } else {
                        alert('注册失败')
                    }
                })
            }

        }
    }
}
</script>

<style lang="scss" scoped>
[data-mode=mobile] {
    #login-box {
        max-width: 80%;
        .login-banner {
            display: none;
        }
    }
}
::v-deep input[type=password]::-ms-reveal {
    display: none;
}
.bg-banner {
    position: absolute;
    z-index: 0;
    width: 100%;
    height: 100%;
    background-image: url(../assets/images/login-bg.jpg);
    background-size: cover;
    background-position: center center;
}
#login-box {
    display: flex;
    justify-content: space-between;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translateX(-50%) translateY(-50%);
    background: rgba(255, 255, 255, 0.8);
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 0 5px #999;
    .login-banner {
        width: 300px;
        background-image: url(../assets/images/login-banner.jpg);
        background-size: cover;
        background-position: center center;
    }
    .login-form {
        width: 450px;
        padding: 50px 35px 30px;
        overflow: hidden;
        .svg-icon {
            vertical-align: -0.35em;
        }
        .title-container {
            position: relative;
            .title {
                font-size: 22px;
                color: #666;
                margin: 0 auto 30px;
                text-align: center;
                font-weight: bold;
                @include text-overflow;
            }
        }
    }
    ::v-deep .el-input {
        display: inline-block;
        height: 48px;
        width: 100%;
        input {
            height: 48px;
        }
        .el-input__prefix {
            left: 10px;
        }
        .el-input__suffix {
            right: 10px;
        }
    }
    .el-checkbox {
        margin: 20px 0;
    }
}
.copyright {
    position: absolute;
    bottom: 30px;
    width: 100%;
    margin: 0;
    mix-blend-mode: difference;
}
</style>
