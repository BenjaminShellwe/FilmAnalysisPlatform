<template>
    <div>
        <page-header title="图形数据">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                <div class="inLine">
                    此页为可视化图形页面
                </div>
            </template>
            <el-row>
                <el-col :span="12">
                    1
                </el-col>
                <el-col :span="12">
                    11
                </el-col>
            </el-row>
        </page-header>
        <el-row>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px 20px 10px; padding: 10px 20px 10px; background-color: rgba(249, 187, 62, 0.3);" shadow="hover">
                    库内电影总数
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(230, 52, 163, 0.3);" shadow="hover">
                    最近更新日期
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(118, 125, 240, 0.3);" shadow="hover">
                    电影数据筛选
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(84, 183, 254, 0.3);" shadow="hover">
                    特别关注电影
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(130, 243, 195, 0.3);" shadow="hover">
                    自建数据列表
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px 20px 10px; padding: 10px 20px 10px; background-color: rgba(56, 205, 236, 0.3);" shadow="hover">
                    placeholder1
                </el-card>
            </el-col>
        </el-row>
        <page-main>
            <el-row>
                <el-col :span="16" class="Echarts">
                    <el-card id="chartsGraph" shadow="hover" style="margin: 10px; padding: 25px; background-color: rgb(244, 251, 252);" />
                </el-col>
                <el-col :span="8" class="Echarts">
                    <el-card body-style="padding: 2px;" style="margin: 5px; padding: 5px; background-color: rgb(246, 252, 244);" shadow="hover">
                        <div slot="header" class="clearfix">
                            <span>各数据图占比</span>
                            <el-button style="float: right; padding: 3px 0;" type="text">placeholder</el-button>
                        </div>
                        <div id="chartsPercentage" />
                    </el-card>
                </el-col>
            </el-row>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            width="30%"
        >
            <span>
                开发中 暂时拒绝提交至后台 数据未更改<br>
                此页面将会优先开发placeholder
            </span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" >明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
export default {
    name: 'Graphic',
    components: {PageMain},
    mounted() {
        this.echartsGraph()
    },
    methods: {
        back() {
            history.go(-1)
        },
        // 此函数对应左边动态图形，修改前请查阅echarts官方文档
        echartsGraph() {
            var ROOT_PATH = 'https://cdn.jsdelivr.net/gh/apache/echarts-website@asf-site/examples'
            var _panelImageURL = ROOT_PATH + '/data/asset/img/custom-gauge-panel.png'
            var _animationDuration = 1000
            var _animationDurationUpdate = 1000
            var _animationEasingUpdate = 'quarticInOut'
            var _valOnRadianMax = 200
            var _outerRadius = 200
            var _innerRadius = 170
            var _pointerInnerRadius = 40
            var _insidePanelRadius = 140
            // var _currentDataIndex = 0
            function renderItem(params, api) {
                var valOnRadian = api.value(1)
                var coords = api.coord([api.value(0), valOnRadian])
                var polarEndRadian = coords[3]
                var imageStyle = {
                    image: _panelImageURL,
                    x: params.coordSys.cx - _outerRadius,
                    y: params.coordSys.cy - _outerRadius,
                    width: _outerRadius * 2,
                    height: _outerRadius * 2
                }
                return {
                    type: 'group',
                    children: [
                        {
                            type: 'image',
                            style: imageStyle,
                            clipPath: {
                                type: 'sector',
                                shape: {
                                    cx: params.coordSys.cx,
                                    cy: params.coordSys.cy,
                                    r: _outerRadius,
                                    r0: _innerRadius,
                                    startAngle: 0,
                                    endAngle: -polarEndRadian,
                                    transition: 'endAngle',
                                    enterFrom: { endAngle: 0 }
                                }
                            }
                        },
                        {
                            type: 'image',
                            style: imageStyle,
                            clipPath: {
                                type: 'polygon',
                                shape: {
                                    points: makePionterPoints(params, polarEndRadian)
                                },
                                extra: {
                                    polarEndRadian: polarEndRadian,
                                    transition: 'polarEndRadian',
                                    enterFrom: { polarEndRadian: 0 }
                                },
                                during: function(apiDuring) {
                                    apiDuring.setShape(
                                        'points',
                                        makePionterPoints(params, apiDuring.getExtra('polarEndRadian'))
                                    )
                                }
                            }
                        },
                        {
                            type: 'circle',
                            shape: {
                                cx: params.coordSys.cx,
                                cy: params.coordSys.cy,
                                r: _insidePanelRadius
                            },
                            style: {
                                fill: '#fff',
                                shadowBlur: 25,
                                shadowOffsetX: 0,
                                shadowOffsetY: 0,
                                shadowColor: 'rgba(76,107,167,0.4)'
                            }
                        },
                        {
                            type: 'text',
                            extra: {
                                valOnRadian: valOnRadian,
                                transition: 'valOnRadian',
                                enterFrom: { valOnRadian: 0 }
                            },
                            style: {
                                text: makeText(valOnRadian),
                                fontSize: 50,
                                fontWeight: 700,
                                x: params.coordSys.cx,
                                y: params.coordSys.cy,
                                fill: 'rgb(0,50,190)',
                                align: 'center',
                                verticalAlign: 'middle',
                                enterFrom: { opacity: 0 }
                            },
                            during: function(apiDuring) {
                                apiDuring.setStyle(
                                    'text',
                                    makeText(apiDuring.getExtra('valOnRadian'))
                                )
                            }
                        }
                    ]
                }
            }
            function convertToPolarPoint(renderItemParams, radius, radian) {
                return [
                    Math.cos(radian) * radius + renderItemParams.coordSys.cx,
                    -Math.sin(radian) * radius + renderItemParams.coordSys.cy
                ]
            }
            function makePionterPoints(renderItemParams, polarEndRadian) {
                return [
                    convertToPolarPoint(renderItemParams, _outerRadius, polarEndRadian),
                    convertToPolarPoint(
                        renderItemParams,
                        _outerRadius,
                        polarEndRadian + Math.PI * 0.03
                    ),
                    convertToPolarPoint(renderItemParams, _pointerInnerRadius, polarEndRadian)
                ]
            }
            function makeText(valOnRadian) {
                // Validate additive animation calc.
                if (valOnRadian < -10) {
                    alert('illegal during val: ' + valOnRadian)
                }
                return ((valOnRadian / _valOnRadianMax) * 100).toFixed(0) + '%'
            }
            var chartPercentage = this.$echarts.init(document.getElementById('chartsPercentage'), null, {width: 480, height: 550})

            var optionUni = {
                animationEasing: _animationEasingUpdate,
                animationDuration: _animationDuration,
                animationDurationUpdate: _animationDurationUpdate,
                animationEasingUpdate: _animationEasingUpdate,
                dataset: {
                    source: [[1, 156]]
                },
                tooltip: {},
                angleAxis: {
                    type: 'value',
                    startAngle: 0,
                    show: false,
                    min: 0,
                    max: _valOnRadianMax
                },
                radiusAxis: {
                    type: 'value',
                    show: false
                },
                polar: {},
                series: [
                    {
                        type: 'custom',
                        coordinateSystem: 'polar',
                        renderItem: renderItem
                    }
                ]
            }
            setInterval(function() {
                var nextSource = [[1, Math.round(Math.random() * _valOnRadianMax)]]
                chartPercentage.setOption({
                    dataset: {
                        source: nextSource
                    }
                })
            }, 3000)

            var chartGraph = this.$echarts.init(document.getElementById('chartsGraph'), null, {width: 900, height: 550})
            var option = {
                color: ['#80FFA5', '#00DDFF', '#37A2FF', '#FF0087', '#FFBF00'],
                title: {
                    text: 'Gradient Stacked Area Chart'
                },
                tooltip: {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        label: {
                            backgroundColor: '#6a7985'
                        }
                    }
                },
                legend: {
                    data: ['Line 1', 'Line 2', 'Line 3', 'Line 4', 'Line 5']
                },
                toolbox: {
                    feature: {
                        saveAsImage: {}
                    }
                },
                grid: {
                    left: '3%',
                    right: '4%',
                    bottom: '3%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
                    }
                ],
                yAxis: [
                    {
                        type: 'value'
                    }
                ],
                series: [
                    {
                        name: 'Line 1',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(128, 255, 165)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(1, 191, 236)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [140, 232, 101, 264, 90, 340, 250]
                    },
                    {
                        name: 'Line 2',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(0, 221, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(77, 119, 255)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [120, 282, 111, 234, 220, 340, 310]
                    },
                    {
                        name: 'Line 3',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(55, 162, 255)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(116, 21, 219)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [320, 132, 201, 334, 190, 130, 220]
                    },
                    {
                        name: 'Line 4',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        areaStyle: {
                            opacity: 0.8,
                            color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(255, 0, 135)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(135, 0, 157)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [220, 402, 231, 134, 190, 230, 120]
                    },
                    {
                        name: 'Line 5',
                        type: 'line',
                        stack: 'Total',
                        smooth: true,
                        lineStyle: {
                            width: 0
                        },
                        showSymbol: false,
                        label: {
                            show: true,
                            position: 'top'
                        },
                        areaStyle: {
                            opacity: 0.8,
                            color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(255, 191, 0)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(224, 62, 76)'
                                }
                            ])
                        },
                        emphasis: {
                            focus: 'series'
                        },
                        data: [220, 302, 181, 234, 210, 290, 150]
                    }
                ]
            }
            // 配置图表
            chartGraph.setOption(option)
            chartPercentage.setOption(optionUni)
        }
    }
}
</script>

<style scoped>
.hover {
    cursor: pointer;
}
</style>
