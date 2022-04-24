<template>
    <div>
        <page-header title="更多数据">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
            </template>
        </page-header>
        <page-main>
            <el-tabs v-model="activeName">
                <el-tab-pane label="各国家/地区电影数量占比" name="first">
                    <el-card id="chartsGraphBar" class="Echarts" shadow="hover" style="margin: 5px; padding: 5px; background-color: rgb(252, 244, 247);"/>
                </el-tab-pane>
                <el-tab-pane label="占比细节" name="second">
                    <el-card id="chartsGraphPie" class="Echarts" shadow="hover" style="margin: 5px; padding: 5px; background-color: rgb(244, 251, 252);"/>
                </el-tab-pane>
            </el-tabs>
        </page-main>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'Detail',
    components: {PageMain},
    data() {
        return {
            activeName: 'first'
        }
    },
    mounted() {
        this.handleGraphs()
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleGraphs() {
            var datas = [
                [
                    { name: '美国', value: 5.6 },
                    { name: '加拿大', value: 1 },
                    { name: '墨西哥', value: 0.8 },
                    { name: '阿根廷', value: 0.5 },
                    { name: '巴西', value: 0.5 },
                    { name: '其它', value: 3.8 }
                ],
                [
                    { name: '德国', value: 1.8 },
                    { name: '英国', value: 3.8 },
                    { name: '法国', value: 1.2 },
                    { name: '西班牙', value: 1.3 },
                    { name: '俄罗斯', value: 0.8 },
                    { name: '其它', value: 1.1 }
                ],
                [
                    { name: '中国', value: 1.8 },
                    { name: '日本', value: 1.8 },
                    { name: '韩国', value: 1.7 },
                    { name: '新加坡', value: 1.4 },
                    { name: '印度', value: 1.5 },
                    { name: '其它', value: 1.8 }
                ],
                [
                    { name: '澳大利亚', value: 7.9 },
                    { name: '新西兰', value: 1.1 },
                    { name: '其它', value: 1 }
                ],
                [
                    { name: '南非', value: 6.25 },
                    { name: '其它', value: 3.75 }
                ]
            ]
            var chartGraphBar = this.$echarts.init(document.getElementById('chartsGraphBar'))
            var chartGraphPie = this.$echarts.init(document.getElementById('chartsGraphPie'), null, {width: 1500, height: 650})
            window.addEventListener('resize', function() {
                chartGraphBar.resize()
            })
            var option = {
                xAxis: {
                    type: 'value',
                    min: 0,
                    max: 5000,
                    interval: 300,
                    axisLabel: {
                        formatter: '{value} 部'
                    }
                },
                yAxis: [
                    {
                        type: 'category',
                        data: ['非洲', '大洋', '亚洲', '欧洲', '美洲']
                    },
                    {

                    }
                ],
                series: [
                    {
                        data: [
                            Math.round(Math.random() * 100),
                            Math.round(Math.random() * 100 + Math.random() * 100),
                            Math.round(Math.random() * 100 + 300),
                            Math.round(Math.random() * 100 + 1700),
                            Math.round(Math.random() * 100 + 4500)
                        ],
                        type: 'bar',
                        showBackground: true,
                        backgroundStyle: {
                            color: 'rgba(180, 180, 180, 0.2)'
                        }
                    }
                ]
            }
            var optionUni = {
                title: [
                    {
                        text: '占比细节',
                        left: 'center'
                    },
                    {
                        subtext: '美洲',
                        left: '13%',
                        top: '30%',
                        textAlign: 'center'
                    },
                    {
                        subtext: '欧洲"',
                        left: '36%',
                        top: '30%',
                        textAlign: 'center'
                    },
                    {
                        subtext: '亚洲',
                        left: '63%',
                        top: '30%',
                        textAlign: 'center'
                    },
                    {
                        subtext: '大洋',
                        left: '86%',
                        top: '30%',
                        textAlign: 'center'
                    },
                    {
                        subtext: '非洲',
                        left: '13%',
                        top: '70%',
                        textAlign: 'center'
                    }
                ],
                series: [
                    {
                        type: 'pie',
                        radius: '25%',
                        center: ['50%', '15%'],
                        data: datas[0],
                        label: {
                            position: 'outer',
                            alignTo: 'none',
                            bleedMargin: 5
                        },
                        left: 0,
                        right: '75%',
                        top: 0,
                        bottom: 0
                    },
                    {
                        type: 'pie',
                        radius: '25%',
                        center: ['50%', '15%'],
                        data: datas[1],
                        label: {
                            position: 'outer',
                            alignTo: 'labelLine',
                            bleedMargin: 5
                        },
                        left: '25%',
                        right: '50%',
                        top: 0,
                        bottom: 0
                    },
                    {
                        type: 'pie',
                        radius: '25%',
                        center: ['50%', '15%'],
                        data: datas[2],
                        label: {
                            position: 'outer',
                            alignTo: 'edge',
                            margin: 20
                        },
                        left: '50%',
                        right: '25%',
                        top: 0,
                        bottom: 0
                    },
                    {
                        type: 'pie',
                        radius: '25%',
                        center: ['50%', '15%'],
                        data: datas[3],
                        label: {
                            position: 'outer',
                            alignTo: 'edge',
                            margin: 20
                        },
                        left: '75%',
                        right: 0,
                        top: 0,
                        bottom: 0
                    },
                    {
                        type: 'pie',
                        radius: '25%',
                        center: ['50%', '15%'],
                        data: datas[4],
                        label: {
                            position: 'outer',
                            alignTo: 'edge',
                            margin: 20
                        },
                        left: '0%',
                        right: '75%',
                        top: '50%',
                        bottom: 0
                    }
                ]
            }
            chartGraphBar.setOption(option)
            chartGraphPie.setOption(optionUni)
        }
    }
}
</script>

<style scoped>
.hover {
    cursor: pointer;
}
.Echarts {
    width: 99%;
    margin: auto;
    height: 650px;
    border: 1px solid #eee;

    /* background: url(../../public/static/bg.png) no-repeat; 背景图设置 */
    background-size: 100% 100%;
}

</style>
