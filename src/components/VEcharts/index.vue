<template>
    <div class="Echarts">
        <div id="charts" style="width: 400px; height: 400px;" />
    </div>
</template>

<script>
export default {
    name: 'VEcharts',
    mounted() {
        this.echarts()
    },
    methods: {
        echarts() {
            var chart = this.$echarts.init(document.getElementById('charts'))
            // 配置图表
            var option = {
                tooltip: {},
                angleAxis: {
                    type: 'category',
                    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                },
                radiusAxis: {},
                polar: {},
                series: [
                    {
                        type: 'bar',
                        data: [1, 2, 3, 4, 3, 5, 1],
                        coordinateSystem: 'polar',
                        name: 'A',
                        stack: 'a',
                        emphasis: {
                            focus: 'series'
                        }
                    },
                    {
                        type: 'bar',
                        data: [2, 4, 6, 1, 3, 2, 1],
                        coordinateSystem: 'polar',
                        name: 'B',
                        stack: 'a',
                        emphasis: {
                            focus: 'series'
                        }
                    },
                    {
                        type: 'bar',
                        data: [1, 2, 3, 4, 1, 2, 5],
                        coordinateSystem: 'polar',
                        name: 'C',
                        stack: 'a',
                        emphasis: {
                            focus: 'series'
                        }
                    }
                ],
                legend: {
                    show: true,
                    data: ['A', 'B', 'C']
                }
            }
            chart.setOption(option)
        }
    }
}
</script>

