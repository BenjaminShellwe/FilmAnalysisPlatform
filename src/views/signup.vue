<template>
    <div>
        <form id="app">
            <h2 class="=form-signin0-heading">Please regist</h2>
            <input v-model="userName" class="form-control" type="text" placeholder="用户名" @blur="blur" @focus="focus" @input="userNameLimit"> <span v-html="msg" /><br>
            <input v-model="userPassword" class="form-control" type="password" placeholder="密码" @input="userPasswordLimit"><br>
            <button class="btn btn-lg btn-primary btn-block" type="button" @click="register">Register</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'Signup',
    data() {
        return {
            userName: '',
            userPassword: '',
            msg: ''
        }
    },
    methods: {
        // 只能输入汉字、英文、数字
        // test1:function() {
        //     this.userName = this.userName.replace(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g, '')
        // },
        // 只能输入英文、数字
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
            let pang
            if (this.userName.length <= 0) {

                pang.msg = '<span style="color: red">用户名不能为空</span>'
            } else {
                axios.post('/user/select', {
                    userName: this.userName,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}   // 跨域
                }).then(function(dat) {
                    if (dat.data === '0') {
                        pang.msg = '<span style="color: green">用户名可用</span>'
                    } else if (dat.data === '1')
                        pang.msg = '<span style="color: red">用户名已存在</span>'
                })
            }
        },
        /**
         * 获取焦点
         * */
        focus: function() {
            let pang
            pang.msg = null
        },

        /**
         * 点击注册按钮事件
         * */
        register: function() {
            if (this.userName.length <= 0) {
                alert('用户名不能为空')
            } else if (this.userPassword.length <= 0) {
                alert('密码不能为空')
            } else {
                axios.post('/user/addUser', {
                    userName: this.userName,
                    userPassword: this.userPassword,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}   // 跨域
                }).then(function(dat) {
                    if (dat.data == '1') {
                        window.location.href = '/user/successRegister'
                    } else {
                        alert('注册失败')
                    }

                })
            }

        }
    }
}
</script>
