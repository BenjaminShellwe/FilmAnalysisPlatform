<template>
    <div>
        <page-header title="省市区联动" content="CascaderArea" />
        <page-main>
            <cascader-area v-model="area" />
        </page-main>
    </div>
</template>

<script>
export default {
    name: 'ComponentExampleArea',
    inject: ['reload'],
    props: {},
    data() {
        return {
            area: ['广东省', '广州市', '从化区']
        }
    },
    created() {},
    mounted() {},
    methods: {}
}
</script>

<style lang="scss" scoped>
// scss
</style>
