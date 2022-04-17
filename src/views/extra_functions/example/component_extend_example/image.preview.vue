<template>
    <div>
        <page-header title="图片预览" content="ImagePreview" />
        <page-main>
            <div>
                <image-preview :src="imgUrl" :width="350" />
                <image-preview :src="imgUrl1" :width="350" />
            </div>
            <div>
                <image-preview src="" width="100px" height="100px" />
            </div>
        </page-main>
    </div>
</template>

<script>
export default {
    props: {},
    data() {
        return {
            imgUrl: require('../../../../assets/images/yuf.png'),
            imgUrl1: require('../../../../assets/images/yuf1.jpg')
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
