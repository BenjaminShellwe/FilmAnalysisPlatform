<template>
    <div>
        <page-header title="图形设置">
            <template #content>
                <div>
                    <div class="hover" @click="back">返回上一页</div>
                    <span>是否开启可视化图形 </span>
                    <el-switch
                        v-model="isShow"
                        active-text="开启"
                        inactive-text="关闭"
                        disabled
                        @click="changeShow"
                    />
                </div>
            </template>
        </page-header>
        <page-main>
        <!-- 不提供此处原始功能代码 -->
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
import axios from 'axios'

export default {
    name: 'GraphSettings',
    components: {PageMain},
    data() {
        return {
            isShow: true
        }
    },
    watch: {

    },
    mounted() {

    },
    methods: {
        changeShow: function() {
            this.isShow = !this.isShow
            if (this.isShow == false) {
                this.value1 = false
            }
        },
        back() {
            history.go(-1)
        },
        // 1. 定义getUserList方法 获取后台服务器数据
        async getUser() {
            // 新增操作请求的类型: post  接收时需要使用JSON方式处理
            let {
                data: result
            } = await axios.post('/dictionary/queryAll')
            // Ajax调用之后, 将请求结果赋值给data属性
            let keys = []
            // console.log(result)
            for (let property in result.data[0]) {
                keys.push(property)
            }
            // console.log(keys)
            this.pageFormHead = keys
            this.data = result.data
            // console.log(this.data)
            this.pageData = result.data.reduce((total, current) => {
                current.valueID !== 0 && total.push(current)
                return total
            }, [])
            // console.log(this.pageData)
            const map = {}
            this.pageData.forEach(item => {
                map[item.uniqueID] = item.typeName
            })
            // console.log(map)
            this.pageTabValue = map
            // this.handleQueryUID(1000)
            // console.log(this.pageTabValue)

            // <<数据获取思路>>
            // let values = function(object) {
            //     let values = []
            //     for (let property in object)
            //         values.push(object[property])
            //     return values
            // }
            //
            // // 写成标准的方法(数组是object的一种)：
            // function getObjectKeys(object) {
            //     let keys = []
            //     for (let property in object)
            //         keys.push(property)
            //     return keys
            // }
            //
            // function getObjectValues(object) {
            //     let values = []
            //     for (let property in object)
            //         values.push(object[property])
            //     return values
            // }
        },
        async handleButtonQuery() {
            // console.log(this.pageQueryValue)
            const that = this
            axios({
                method: 'post',
                url: '/dictionary/queryTypeName',
                data: this.pageQueryValue
            }).then(function(response) {
                // console.log(response)
                let keys = []
                if (response.data.data == null) {
                    that.data = null
                } else {
                    for (let property in response.data.data[0]) {
                        keys.push(property)
                    }
                    that.pageFormHead = keys
                }
            }).catch(error => {
                this.$notify({
                    title: '操作执行异常',
                    message: error,
                    type: 'error',
                    duration: 6500
                })
            })
        },
        handleButtonCreate() {
            const that = this
            // console.log(this.pageFormList)
            // console.log(this.pageFormList.valueStatus)
            axios({
                method: 'post',
                url: '/dictionary/addGlobalDic',
                data: this.pageFormList
            }).then(function(response) {
                that.pageDialogVisible = false
                that.handleSuccess(response.data.code, response.data.msg)
                console.log(response)
            }).catch(error => {
                this.$notify({
                    title: '操作执行异常',
                    message: error,
                    type: 'error',
                    duration: 6500
                })
            })
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
</style>
