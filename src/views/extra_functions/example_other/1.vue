<template>
    <el-row>
        <el-col :md="18">
            <page-main class="main" />
        </el-col>
    </el-row>
</template>

<style lang="scss" scoped>
.main {
    height: 0;
    padding-bottom: 60% !important;
}
iframe {
    border: 1px solid #ccc;
    position: absolute;
    width: calc(100% - 40px);
    height: calc(100% - 40px);
}
</style>
