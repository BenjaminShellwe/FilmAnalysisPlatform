<template>
    <div v-if="visible" class="popup">
        <div class="dialog">
            <div v-if="title" class="title">{{ title }}</div>
            <div class="content">
                <slot />
            </div>
            <div class="btn">
                <button v-if="cancelBtn" @click="cancel">{{ cancelBtn?cancelBtn:'取消' }}</button>
                <button v-if="confirmBtn" @click="confirm">{{ confirmBtn?confirmBtn:'确认' }}</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'CDialog',
    props: {
        title: {
            type: [String],
            default: ''
        },
        cancelBtn: {
            type: [String],
            default: ''
        },
        confirmBtn: {
            type: [String],
            default: ''
        }
    },
    data() {
        return {
            visible: false
        }
    },
    methods: {
        show() {
            this.visible = true
        },
        hide() {
            this.visible = false
        },
        cancel() {
            this.hide()
        },
        confirm() {
            this.$emit('confirm')
            this.hide()
        }
    }
}
</script>

<style lang='stylus'>
@import './index.styl';
</style>
