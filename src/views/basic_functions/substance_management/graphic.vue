<template>
    <div>
        <page-header title="图形数据">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                <el-row>
                    <el-col :span="8">
                        1
                    </el-col>
                    <el-col :span="8">
                        |
                    </el-col>
                    <el-col :span="8">
                        2
                    </el-col>
                </el-row>
            </template>
        </page-header>
        <el-row>
            <el-col :span="4">
                <el-tooltip class="item" effect="dark" content="此数字随数据库变更" placement="top">
                    <el-card body-style="padding: 5px;" style="margin: 10px 20px 10px; padding: 10px 20px 10px; background-color: rgba(249, 187, 62, 0.3);" shadow="hover">
                        库内电影总数 {{ pageCountAll }}
                    </el-card>
                </el-tooltip>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(230, 52, 163, 0.3);" shadow="hover">
                    最近更新日期 {{ pageDate }}
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(118, 125, 240, 0.3);" shadow="hover">
                    电影数据筛选(控制入口)
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
                    颜色可自行更改
                </el-card>
            </el-col>
        </el-row>
        <page-main>
            <el-row class="Echarts">
                <el-col :span="16">
                    <el-card id="chartsGraph" shadow="hover" style="margin: 5px; padding: 5px; background-color: rgb(244, 251, 252);" />
                </el-col>
                <el-col :span="8">
                    <el-card body-style="padding: 2px;" style="margin: 5px; padding: 5px; background-color: rgb(246, 252, 244);" shadow="hover">
                        <div slot="header" class="clearfix">
                            <span>各数据图占比</span>
                            <el-button style="float: right; padding: 3px 0;" type="text">placeholder</el-button>
                        </div>
                        <div id="chartsPercentage" />
                    </el-card>
                </el-col>
            </el-row>
            <el-row class="Echarts">
                <el-col :span="16">
                    <el-card id="chartsMultiRadar" shadow="hover" style="margin: 5px; padding: 5px; background-color: rgb(251, 244, 252);" />
                </el-col>
                <el-col :span="8">
                    <el-card body-style="padding: 2px;" style="margin: 5px; padding: 5px; background-color: rgb(251, 252, 244);" shadow="hover">
                        <div id="chartsSingleRadar" />
                    </el-card>
                </el-col>
            </el-row>
            <el-row class="Echarts">
                <el-col>
                    <el-card id="chartsTransparent" shadow="hover" style="margin: 5px; padding: 5px;" />
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
                <el-button type="primary">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageMain from '@/components/PageMain'
import { TooltipComponent, VisualMapComponent } from 'echarts/components'
import { CanvasRenderer } from 'echarts/renderers'
import { Bar3DChart } from 'echarts-gl/charts'
import { Grid3DComponent } from 'echarts-gl/components'
import axios from 'axios'

export default {
    name: 'Graphic',
    components: {PageMain},
    data() {
        return {
            pageCountAll: 0,
            pageDate: 0
        }
    },
    mounted() {
        this.echartsGraph()
        this.countAll()
    },
    methods: {
        back() {
            history.go(-1)
        },
        countAll() {
            axios({
                method: 'get',
                url: '/film/count'
            }).then(response => {
                // console.log(response.data)
                this.pageCountAll = response.data.data
            }).catch(error => {
                console.log(error)
            })
            axios({
                method: 'post',
                url: '/user/updateTime'
            }).then(response => {
                // console.log(response.data)
                this.pageDate = formatDate(response.data.data)
            }).catch(error => {
                console.log(error)
            })
            function formatDate(date) {
                date = new Date(date)
                var YY = date.getFullYear() + '-'
                var MM = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-'
                var DD = (date.getDate() < 10 ? '0' + (date.getDate()) : date.getDate())
                // var hh = (date.getHours() < 10 ? '0' + date.getHours() : date.getHours()) + ':'
                // var mm = (date.getMinutes() < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':'
                // var ss = (date.getSeconds() < 10 ? '0' + date.getSeconds() : date.getSeconds())
                return YY + MM + DD
                // return YY + MM + DD + ' ' + hh + mm + ss
            }
        },
        // 此函数对应动态图形，修改前请查阅echarts官方文档
        echartsGraph() {
            this.$echarts.use([
                TooltipComponent,
                VisualMapComponent,
                Grid3DComponent,
                Bar3DChart,
                CanvasRenderer
            ])
            let base = +new Date(1968, 9, 3)
            let oneDay = 24 * 3600 * 1000
            let date1 = []
            let data1 = [Math.random() * 300]
            for (let i = 1; i < 20000; i++) {
                var now = new Date((base += oneDay))
                date1.push([now.getFullYear(), now.getMonth() + 1, now.getDate()].join('/'))
                data1.push(Math.round((Math.random() - 0.5) * 20 + data1[i - 1]))
            }
            var chartGraph = this.$echarts.init(document.getElementById('chartsGraph'), null, {width: 990, height: 550})
            var option = {
                tooltip: {
                    trigger: 'axis',
                    position: function(pt) {
                        return [pt[0], '10%']
                    }
                },
                title: {
                    left: 'center',
                    text: 'Large Area Chart'
                },
                toolbox: {
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                xAxis: {
                    type: 'category',
                    boundaryGap: false,
                    data: date1
                },
                yAxis: {
                    type: 'value',
                    boundaryGap: [0, '100%']
                },
                dataZoom: [
                    {
                        type: 'inside',
                        start: 0,
                        end: 10
                    },
                    {
                        start: 0,
                        end: 10
                    }
                ],
                series: [
                    {
                        name: 'Fake Data',
                        type: 'line',
                        symbol: 'none',
                        sampling: 'lttb',
                        itemStyle: {
                            color: 'rgb(255, 70, 131)'
                        },
                        areaStyle: {
                            color: new this.$echarts.graphic.LinearGradient(0, 0, 0, 1, [
                                {
                                    offset: 0,
                                    color: 'rgb(255, 158, 68)'
                                },
                                {
                                    offset: 1,
                                    color: 'rgb(255, 70, 131)'
                                }
                            ])
                        },
                        data: data1
                    }
                ]
            }

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

            var chartPercentage = this.$echarts.init(document.getElementById('chartsPercentage'), null, {width: 480, height: 485})
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

            var chartRadar = this.$echarts.init(document.getElementById('chartsMultiRadar'), null, {width: 900, height: 485})
            var optionBin = {
                title: {
                    text: 'Multiple Radar'
                },
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    left: 'center',
                    data: [
                        'A Software',
                        'A Phone',
                        'Another Phone',
                        'Precipitation',
                        'Evaporation'
                    ]
                },
                radar: [
                    {
                        indicator: [
                            { text: 'Brand', max: 100 },
                            { text: 'Content', max: 100 },
                            { text: 'Usability', max: 100 },
                            { text: 'Function', max: 100 },
                            { text: 'placeholder', max: 100 }
                        ],
                        center: ['18%', '50%'],
                        radius: 100
                    },
                    {
                        indicator: [
                            { text: 'Look', max: 100 },
                            { text: 'Photo', max: 100 },
                            { text: 'System', max: 100 },
                            { text: 'Performance', max: 100 },
                            { text: 'Screen', max: 100 }
                        ],
                        center: ['55%', '50%'],
                        radius: 100
                    },
                    {
                        indicator: (function() {
                            var res = []
                            for (var i = 1; i <= 12; i++) {
                                res.push({ text: i + '月', max: 100 })
                            }
                            return res
                        })(),
                        center: ['85%', '50%'],
                        radius: 100
                    }
                ],
                series: [
                    {
                        type: 'radar',
                        tooltip: {
                            trigger: 'item'
                        },
                        areaStyle: {},
                        data: [
                            {
                                value: [60, 73, 85, 40],
                                name: 'A Software'
                            }
                        ]
                    },
                    {
                        type: 'radar',
                        radarIndex: 1,
                        areaStyle: {},
                        data: [
                            {
                                value: [85, 90, 90, 95, 95],
                                name: 'A Phone'
                            },
                            {
                                value: [95, 80, 95, 90, 93],
                                name: 'Another Phone'
                            }
                        ]
                    },
                    {
                        type: 'radar',
                        radarIndex: 2,
                        areaStyle: {},
                        data: [
                            {
                                name: 'Precipitation',
                                value: [
                                    2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 75.6, 82.2, 48.7, 18.8, 6.0, 2.3
                                ]
                            },
                            {
                                name: 'Evaporation',
                                value: [
                                    2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 35.6, 62.2, 32.6, 20.0, 6.4, 3.3
                                ]
                            }
                        ]
                    }
                ]
            }

            var chartSingleRadar = this.$echarts.init(document.getElementById('chartsSingleRadar'), null, {width: 480, height: 485})
            var optionTer = {
                title: {
                    text: 'Proportion of Browsers',
                    subtext: 'Fake Data',
                    top: 10,
                    left: 10
                },
                tooltip: {
                    trigger: 'item'
                },
                legend: {
                    type: 'scroll',
                    bottom: 10,
                    data: (function() {
                        var list = []
                        for (var i = 1; i <= 28; i++) {
                            list.push(i + 2000 + '')
                        }
                        return list
                    })()
                },
                visualMap: {
                    top: 'top',
                    right: 10,
                    color: ['red', 'yellow'],
                    calculable: true
                },
                radar: {
                    indicator: [
                        { text: 'IE8-', max: 400 },
                        { text: 'IE9+', max: 400 },
                        { text: 'Safari', max: 400 },
                        { text: 'Firefox', max: 400 },
                        { text: 'Chrome', max: 400 }
                    ]
                },
                series: (function() {
                    var series = []
                    for (var i = 1; i <= 28; i++) {
                        series.push({
                            type: 'radar',
                            symbol: 'none',
                            lineStyle: {
                                width: 1
                            },
                            emphasis: {
                                areaStyle: {
                                    color: 'rgba(0,250,0,0.3)'
                                }
                            },
                            data: [
                                {
                                    value: [
                                        (40 - i) * 10,
                                        (38 - i) * 4 + 60,
                                        i * 5 + 10,
                                        i * 9,
                                        (i * i) / 2
                                    ],
                                    name: i + 2000 + ''
                                }
                            ]
                        })
                    }
                    return series
                })()
            }

            // prettier-ignore
            var hours = ['12a', '1a', '2a', '3a', '4a', '5a', '6a', '7a', '8a', '9a', '10a', '11a', '12p', '1p', '2p', '3p', '4p', '5p', '6p', '7p', '8p', '9p', '10p', '11p']
            // prettier-ignore
            var days = ['Saturday', 'Friday', 'Thursday', 'Wednesday', 'Tuesday', 'Monday', 'Sunday']
            // prettier-ignore
            var data = [[0, 0, 5], [0, 1, 1], [0, 2, 0], [0, 3, 0], [0, 4, 0], [0, 5, 0], [0, 6, 0], [0, 7, 0], [0, 8, 0], [0, 9, 0], [0, 10, 0], [0, 11, 2], [0, 12, 4], [0, 13, 1], [0, 14, 1], [0, 15, 3], [0, 16, 4], [0, 17, 6], [0, 18, 4], [0, 19, 4], [0, 20, 3], [0, 21, 3], [0, 22, 2], [0, 23, 5], [1, 0, 7], [1, 1, 0], [1, 2, 0], [1, 3, 0], [1, 4, 0], [1, 5, 0], [1, 6, 0], [1, 7, 0], [1, 8, 0], [1, 9, 0], [1, 10, 5], [1, 11, 2], [1, 12, 2], [1, 13, 6], [1, 14, 9], [1, 15, 11], [1, 16, 6], [1, 17, 7], [1, 18, 8], [1, 19, 12], [1, 20, 5], [1, 21, 5], [1, 22, 7], [1, 23, 2], [2, 0, 1], [2, 1, 1], [2, 2, 0], [2, 3, 0], [2, 4, 0], [2, 5, 0], [2, 6, 0], [2, 7, 0], [2, 8, 0], [2, 9, 0], [2, 10, 3], [2, 11, 2], [2, 12, 1], [2, 13, 9], [2, 14, 8], [2, 15, 10], [2, 16, 6], [2, 17, 5], [2, 18, 5], [2, 19, 5], [2, 20, 7], [2, 21, 4], [2, 22, 2], [2, 23, 4], [3, 0, 7], [3, 1, 3], [3, 2, 0], [3, 3, 0], [3, 4, 0], [3, 5, 0], [3, 6, 0], [3, 7, 0], [3, 8, 1], [3, 9, 0], [3, 10, 5], [3, 11, 4], [3, 12, 7], [3, 13, 14], [3, 14, 13], [3, 15, 12], [3, 16, 9], [3, 17, 5], [3, 18, 5], [3, 19, 10], [3, 20, 6], [3, 21, 4], [3, 22, 4], [3, 23, 1], [4, 0, 1], [4, 1, 3], [4, 2, 0], [4, 3, 0], [4, 4, 0], [4, 5, 1], [4, 6, 0], [4, 7, 0], [4, 8, 0], [4, 9, 2], [4, 10, 4], [4, 11, 4], [4, 12, 2], [4, 13, 4], [4, 14, 4], [4, 15, 14], [4, 16, 12], [4, 17, 1], [4, 18, 8], [4, 19, 5], [4, 20, 3], [4, 21, 7], [4, 22, 3], [4, 23, 0], [5, 0, 2], [5, 1, 1], [5, 2, 0], [5, 3, 3], [5, 4, 0], [5, 5, 0], [5, 6, 0], [5, 7, 0], [5, 8, 2], [5, 9, 0], [5, 10, 4], [5, 11, 1], [5, 12, 5], [5, 13, 10], [5, 14, 5], [5, 15, 7], [5, 16, 11], [5, 17, 6], [5, 18, 0], [5, 19, 5], [5, 20, 3], [5, 21, 4], [5, 22, 2], [5, 23, 0], [6, 0, 1], [6, 1, 0], [6, 2, 0], [6, 3, 0], [6, 4, 0], [6, 5, 0], [6, 6, 0], [6, 7, 0], [6, 8, 0], [6, 9, 0], [6, 10, 1], [6, 11, 0], [6, 12, 2], [6, 13, 1], [6, 14, 3], [6, 15, 4], [6, 16, 0], [6, 17, 0], [6, 18, 0], [6, 19, 0], [6, 20, 1], [6, 21, 2], [6, 22, 2], [6, 23, 6]]

            var chartTransparent = this.$echarts.init(document.getElementById('chartsTransparent'), null, {width: 1500, height: 485})
            var optionQua = {
                tooltip: {},
                visualMap: {
                    max: 20,
                    inRange: {
                        color: [
                            '#313695',
                            '#4575b4',
                            '#74add1',
                            '#abd9e9',
                            '#e0f3f8',
                            '#ffffbf',
                            '#fee090',
                            '#fdae61',
                            '#f46d43',
                            '#d73027',
                            '#a50026'
                        ]
                    }
                },
                xAxis3D: {
                    type: 'category',
                    data: hours
                },
                yAxis3D: {
                    type: 'category',
                    data: days
                },
                zAxis3D: {
                    type: 'value'
                },
                grid3D: {
                    boxWidth: 200,
                    boxDepth: 80,
                    light: {
                        main: {
                            intensity: 1.2
                        },
                        ambient: {
                            intensity: 0.3
                        }
                    }
                },
                series: [
                    {
                        type: 'bar3D',
                        data: data.map(function(item) {
                            return {
                                value: [item[1], item[0], item[2]]
                            }
                        }),
                        shading: 'color',
                        label: {
                            show: true,
                            fontSize: 16,
                            borderWidth: 1
                        },
                        itemStyle: {
                            opacity: 0.8
                        },
                        emphasis: {
                            label: {
                                fontSize: 20,
                                color: '#900'
                            },
                            itemStyle: {
                                color: '#900'
                            }
                        }
                    }
                ]
            }

            // 配置图表
            chartGraph.setOption(option)
            chartPercentage.setOption(optionUni)
            chartRadar.setOption(optionBin)
            chartSingleRadar.setOption(optionTer)
            chartTransparent.setOption(optionQua)
        }
    }
}
</script>

<style scoped>
.hover {
    cursor: pointer;
}
</style>
