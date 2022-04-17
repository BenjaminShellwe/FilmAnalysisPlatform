<template>
    <div>
        <page-header title="基础设置">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
            &nbsp;
                <div class="inLine">
                    此页为后台系统的基本设置
                </div>
            </template>
        </page-header>
        <page-main>
            <span class="hover" @click="$eventBus.$emit('global-theme-toggle')">
                主题设置窗口呼出
            </span>
        </page-main>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    methods: {
        back() {
            history.go(-1)
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
</style>
