<template>
    <div>
        <page-header title="满意度分析">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
            </template>
        </page-header>
        <page-main title="各类电影受欢迎程度">
            <el-card id="chartsGraphBar" class="Echarts" shadow="hover" style="margin: 5px; padding: 5px; background-color: rgb(252, 244, 247);" />
        </page-main>
    </div>
</template>

<script>
export default {
    name: 'Satisfaction',
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
            var chartGraphBar = this.$echarts.init(document.getElementById('chartsGraphBar'))
            window.addEventListener('resize', function() {
                chartGraphBar.resize()
            })
            // var app = {}
            const categories = (function() {
                // let now = new Date()
                let res = ['微电影', '悬疑', '纪录', '动画', '动作', '喜剧', '恐怖', '科幻', '爱情']
                // let len = 10
                // while (len--) {
                //     res.unshift(now.toLocaleTimeString().replace(/^\D*/, ''))
                //     now = new Date(+now - 3000)
                // }
                return res
            })()
            const categories2 = (function() {
                let res = []
                let len = 10
                while (len--) {
                    res.push(10 - len - 1)
                }
                return res
            })()
            const data = (function() {
                let res = []
                let len = 10
                while (len--) {
                    res.push(Math.round(Math.random() * 1000))
                }
                return res
            })()
            const data2 = (function() {
                let res = []
                let len = 0
                while (len < 10) {
                    res.push(+(Math.random() * 10 + 5).toFixed(1))
                    len++
                }
                return res
            })()
            var option = {
                title: {
                    text: '各电影受欢迎程度'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#283b56'
                        }
                    }
                },
                legend: {},
                toolbox: {
                    show: true,
                    feature: {
                        dataView: { readOnly: false },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                dataZoom: {
                    show: false,
                    start: 0,
                    end: 100
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: true,
                        data: categories
                    },
                    {
                        type: 'category',
                        boundaryGap: true,
                        data: categories2
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        scale: true,
                        name: '均分',
                        max: 30,
                        min: 0,
                        boundaryGap: [0.2, 0.2]
                    },
                    {
                        type: 'value',
                        scale: true,
                        name: '人数',
                        max: 1200,
                        min: 0,
                        boundaryGap: [0.2, 0.2]
                    }
                ],
                series: [
                    {
                        name: '评价人数',
                        type: 'bar',
                        xAxisIndex: 1,
                        yAxisIndex: 1,
                        data: data
                    },
                    {
                        name: '评价均分',
                        type: 'line',
                        data: data2
                    }
                ]
            }
            chartGraphBar.setOption(option)
            // function f() {
            //     if (Math.random() < 0.1) {
            //         return '微电影'
            //     }
            //     if (Math.random() <= 0.1 && Math.random() <= 0.2) {
            //         return '悬疑'
            //     }
            //     if (Math.random() <= 0.2 && Math.random() <= 0.3) {
            //         return '纪录'
            //     }
            //     if (Math.random() <= 0.3 && Math.random() <= 0.4) {
            //         return '动画'
            //     }
            //     if (Math.random() <= 0.4 && Math.random() <= 0.5) {
            //         return '动作'
            //     }
            //     if (Math.random() <= 0.5 && Math.random() <= 0.6) {
            //         return '喜剧'
            //     }
            //     if (Math.random() <= 0.6 && Math.random() <= 0.7) {
            //         return '恐怖'
            //     }
            //     if (Math.random() <= 0.7 && Math.random() <= 0.8) {
            //         return '科幻'
            //     }
            //     if (Math.random() <= 0.9 && Math.random() <= 1) {
            //         return '爱情'
            //     }
            // }
            // app.count = 11
            // setInterval(function() {
            //     // let axisData = new Date().toLocaleTimeString().replace(/^\D*/, '')
            //     data.shift()
            //     data.push(Math.round(Math.random() * 1000))
            //     data2.shift()
            //     data2.push(+(Math.random() * 10 + 5).toFixed(1))
            //     categories.shift()
            //     categories.push(f())
            //     categories2.shift()
            //     categories2.push(app.count++)
            //     chartGraphBar.setOption({
            //         xAxis: [
            //             {
            //                 data: categories
            //             },
            //             {
            //                 data: categories2
            //             }
            //         ],
            //         series: [
            //             {
            //                 data: data
            //             },
            //             {
            //                 data: data2
            //             }
            //         ]
            //     })
            // }, 3100)
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
