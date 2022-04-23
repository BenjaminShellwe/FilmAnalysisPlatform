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
                    电影数据筛选(不实现)
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(84, 183, 254, 0.3);" shadow="hover">
                    特别关注电影(功能已足够)
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px; padding: 10px; background-color: rgba(130, 243, 195, 0.3);" shadow="hover">
                    自建数据列表(不实现)
                </el-card>
            </el-col>
            <el-col :span="4">
                <el-card body-style="padding: 5px;" style="margin: 10px 20px 10px; padding: 10px 20px 10px; background-color: rgba(56, 205, 236, 0.3);" shadow="hover">
                    颜色自行更改
                </el-card>
            </el-col>
        </el-row>
        <page-main>
            <el-row class="Echarts">
                <el-col :span="16">
                    <el-tabs v-model="pageTabs">
                        <el-tab-pane label="不同年份电影数量" name="first">
                            <el-card id="chartsGraph" shadow="hover" style="margin: 4px; padding: 4px; background-color: rgb(244, 251, 252);" />
                        </el-tab-pane>
                        <el-tab-pane label="不同评分电影数量" name="second">
                            <el-card id="chartsGraphUni" shadow="hover" style="margin: 4px; padding: 4px; background-color: rgb(253, 234, 225);" />
                        </el-tab-pane>
                        <el-tab-pane label="不同时长电影数量" name="third">
                            <el-card id="chartsGraphBin" shadow="hover" style="margin: 4px; padding: 4px; background-color: rgb(239, 253, 225);" />
                        </el-tab-pane>
                        <el-tab-pane label="不同票房电影数量" name="fourth">
                            <el-card id="chartsGraphTer" shadow="hover" style="margin: 4px; padding: 4px; background-color: rgb(240, 225, 253);" />
                        </el-tab-pane>
                    </el-tabs>

                </el-col>
                <el-col :span="8">
                    <el-card body-style="padding: 2px;" style="margin: 5px; padding: 5px; background-color: rgb(246, 252, 244);" shadow="hover">
                        <div slot="header" class="clearfix">
                            <span>随机任意电影好评度</span>
                            <el-button style="float: right; padding: 3px 0;" type="text" @click="refreshPercentage">立即刷新</el-button>
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
            :title="dialogTitle"
            width="50%"
            :visible.sync="pageVisible"
            :before-close="handleResetValue"
        >
            <el-row>
                <el-col v-show="descVisible">
                    <el-descriptions :title="descTitle" direction="vertical" :column="3" border>
                        <el-descriptions-item label="名称">{{ film.Title }}</el-descriptions-item>
                        <el-descriptions-item label="主演">{{ film.Star }}</el-descriptions-item>
                        <el-descriptions-item label="类型">{{ film.Type }}</el-descriptions-item>
                        <el-descriptions-item label="语言">
                            <el-tag size="small">{{ film.Language }}</el-tag>
                        </el-descriptions-item>
                        <el-descriptions-item label="地区">{{ film.Country }}</el-descriptions-item>
                        <el-descriptions-item label="导演">{{ film.Director }}</el-descriptions-item>
                        <el-descriptions-item label="关键词">{{ film.Key }}</el-descriptions-item>
                    </el-descriptions>
                </el-col>
                <el-col v-show="descVisible2">
                    <el-input-number v-model="num" :min="1" :max="4798" label="起始" />
                    <el-input-number v-model="num1" :min="1" :max="4798" label="结尾" />
                    <el-button type="primary" @click="handleCounting">确 认</el-button>
                </el-col>
            </el-row>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="pageVisible = false">已 阅</el-button>
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
            num: 1,
            num1: 20,
            dialogTitle: '',
            descTitle: '',
            descVisible: false,
            descVisible2: false,
            film: {
                Title: '',
                Star: [],
                Type: [],
                Language: [],
                Country: [],
                Director: [],
                Key: []
            },
            pageTabs: 'first',
            pageTransfer: {},
            pageVisible: false,
            pageCountAll: 0,
            pageDate: 0,
            pageScore: [],
            pageYears: [],
            pageFilm: {}
        }
    },
    mounted() {
        this.echartsGraph()
    },
    methods: {
        back() {
            history.go(-1)
        },
        handleWakeUpDialog(val, desc) {
            if (desc === 1) {
                this.descVisible = true
                this.film.Title = val.title
                this.film.Star = val.star
                this.film.Type = val.type
                this.film.Language = val.language
                this.film.Country = val.country
                this.film.Director = val.director
                this.film.Key = val.keyword
                this.dialogTitle = '电影详情'
            }
            if (desc === 2) {
                this.descVisible2 = true
                this.dialogTitle = val
                this.descVisible = false

            }
            this.pageVisible = true
        },
        handleCounting() {
            if ((this.num1 - 1) - (this.num - 1) <= 20) {
                axios({
                    method: 'post',
                    url: '/film/budgetFilm',
                    data: {i: (this.num - 1), j: (this.num1 - 1)}
                }).then(response => {
                    var chartHistogram = this.$echarts.init(document.getElementById('chartsMultiRadar'), null, {width: 995, height: 485})
                    var chartTransparent = this.$echarts.init(document.getElementById('chartsTransparent'), null, {width: 1500, height: 485})
                    let xAxisData = []
                    let data6 = []
                    let data7 = []
                    let data8 = []
                    for (let i = 0; i < 20; i++) {
                        xAxisData.push(response.data.data[i].title)
                        data6.push(response.data.data[i].boxoffice)
                        data7.push(response.data.data[i].budget)
                        data8.push([
                            Math.round(response.data.data[i].boxoffice / 100000000), Math.round(response.data.data[i].budget / 100000000), Math.round(response.data.data[i].boxoffice / 100000000)
                        ])

                    }
                    chartHistogram.setOption({
                        xAxis: {
                            data: xAxisData
                        },
                        series: [
                            {
                                name: '票房',
                                type: 'bar',
                                data: data6,
                                emphasis: {
                                    focus: 'series'
                                },
                                animationDelay: function(idx) {
                                    return idx * 800 + 250
                                }
                            },
                            {
                                name: '预算',
                                type: 'bar',
                                data: data7,
                                emphasis: {
                                    focus: 'series'
                                },
                                animationDelay: function(idx) {
                                    return idx * 800 + 250
                                }
                            }
                        ]
                    })
                    chartTransparent.setOption({
                        series: [
                            {
                                name: '区间一',
                                type: 'bar3D',
                                data: data8,
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
                    })
                })
            } else {
                this.$message('年限区间最大为20')
            }
        },
        handleResetValue() {
            this.film = {}
            this.descVisible = false
            this.descVisible2 = false
        },
        refreshPercentage() {
            var chartPercentage = this.$echarts.init(document.getElementById('chartsPercentage'), null, {width: 480, height: 485})
            axios({method: 'get', url: '/film/randomFilm'}).then(response => {
                let nextTitle = response.data.data[0].title
                let nextSource = [[1, Math.round(response.data.data[0].score / 10 * 200)]]
                chartPercentage.setOption({
                    title: {
                        text: nextTitle
                    },
                    dataset: {
                        source: nextSource
                    }
                })
            })
        },
        // 此函数对应动态图形，修改前请查阅echarts官方文档
        // 如果对vue生命周期不熟悉,请不要变更函数执行顺序,不然图表将无法正常获取数据
        echartsGraph() {
            this.$echarts.use([
                TooltipComponent,
                VisualMapComponent,
                Grid3DComponent,
                Bar3DChart,
                CanvasRenderer
            ])
            // chartGraph 数据
            let date2 = []
            let data2 = []
            // chartGraphUni 数据
            let date3 = []
            let data6 = []
            // chartGraphBin 数据
            let date4 = []
            let data7 = []
            // chartGraphTer 数据
            let date5 = []
            let data8 = []
            // chartHistogram 数据
            let xAxisData = []
            let data3 = []
            let data4 = []
            // 3D 数据
            let data5 = []
            // 请求数据
            axios.all([
                axios({method: 'get', url: '/film/count'}),
                axios({method: 'post', url: '/user/updateTime'}),
                axios({method: 'post', url: '/film/setCount', data: {obj: 'release'}}),
                axios({method: 'post', url: '/film/budgetFilm', data: {i: 0, j: 19}}),
                axios({method: 'post', url: '/film/setCount', data: {obj: 'score'}}),
                axios({method: 'post', url: '/film/durationCount'}),
                axios({method: 'post', url: '/film/boxofficeCount'})
            ]).then(response => {
                // console.log(response)
                this.pageCountAll = response[0].data.data
                this.pageDate = formatDate(response[1].data.data)
                this.pageYears = response[2].data.data
                for (let i = 0; i < this.pageYears.length; i++) {
                    date2.push(this.pageYears[i].release)
                    data2.push(this.pageYears[i].total + 0)
                }
                for (let i = 0; i < 20; i++) {
                    xAxisData.push(response[3].data.data[i].title)
                    data3.push(response[3].data.data[i].boxoffice)
                    data4.push(response[3].data.data[i].budget)
                    data5.push([
                        Math.round(response[3].data.data[i].boxoffice / 100000000), Math.round(response[3].data.data[i].budget / 100000000), Math.round(response[3].data.data[i].boxoffice / 100000000)
                    ])

                }
                for (let i = 0; i < response[4].data.data.length; i++) {
                    date3.push(response[4].data.data[i].score)
                    data6.push(response[4].data.data[i].total + 0)
                }
                for (let i = 0; i < response[5].data.data.length; i++) {
                    date4.push(response[5].data.data[i].duration)
                    data7.push(response[5].data.data[i].total + 0)
                }
                for (let i = 0; i < response[6].data.data.length; i++) {
                    date5.push(response[6].data.data[i].boxoffice)
                    data8.push(response[6].data.data[i].total + 0)
                }

                chartGraph.setOption(option)
                chartPercentage.setOption(optionUni)
                chartHistogram.setOption(optionBin)
                chartSingleRadar.setOption(optionTer)
                chartTransparent.setOption(optionQua)
                chartGraphUni.setOption(optionSen)
                chartGraphBin.setOption(optionSep)
                chartGraphTer.setOption(optionOct)
                chartSingleRadar.setOption({
                    series: (function() {
                        var series = []
                        for (var i = 0; i < 20; i++) {
                            series.push({
                                data: [
                                    {
                                        value: [
                                            response[3].data.data[i].boxoffice,
                                            response[3].data.data[i].popularity,
                                            response[3].data.data[i].duration,
                                            response[3].data.data[i].score,
                                            response[3].data.data[i].evaluators
                                        ],
                                        name: response[3].data.data[i].title + ''
                                    }
                                ]
                            })
                        }
                        return series
                    })()
                })

                setInterval(() => {
                    axios({method: 'get', url: '/film/randomFilm'}).then(response => {
                        this.pageTransfer = response.data.data[0]
                        let nextTitle = response.data.data[0].title
                        let nextSubtext = response.data.data[0].director
                        let nextSource = [[1, Math.round(response.data.data[0].score / 10 * _valOnRadianMax)]]
                        // console.log(response)
                        // var nextSource = [[1, Math.round(Math.random() * _valOnRadianMax)]]
                        chartPercentage.setOption({
                            title: {
                                text: nextTitle,
                                subtext: nextSubtext
                            },
                            dataset: {
                                source: nextSource
                            }
                        })
                    })
                }, 10000)

                // chartGraph.getZr().on('click', params => {
                //     this.$notify.warning({
                //         title: '提示 执行动作' + params.type,
                //         message: '由于拖拽事件覆盖,本图形无法提供鼠标点击事件',
                //         duration: 3500
                //     })
                // })
                // 我累了不想再复写点击事件了
                chartPercentage.on('click',  () => {
                    // console.log()
                    this.$notify.info({
                        title: '提示',
                        message: '触发事件,开启详情页面',
                        duration: 3000
                    })
                    setTimeout(() => {
                        this.handleWakeUpDialog(this.pageTransfer, 1)
                    }, 800)

                })
                chartHistogram.on('click',  params => {
                    console.log(params)
                    this.$notify.info({
                        title: '提示',
                        message: '触发事件,将进行年份范围选择',
                        duration: 3000
                    })
                    setTimeout(() => {
                        this.handleWakeUpDialog('年份范围选择', 2)
                    }, 800)
                })
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

            // 不同年份上映电影数量
            var chartGraph = this.$echarts.init(document.getElementById('chartsGraph'), null, {width: 990, height: 500})
            var option = {
                tooltip: {
                    trigger: 'axis',
                    position: function(pt) {
                        return [pt[0], '10%']
                    }
                },
                title: {
                    left: 'center',
                    text: '不同年份上映电影数量'
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
                    data: date2
                },
                yAxis: {
                    type: 'value',
                    boundaryGap: [0, '100%']
                },
                dataZoom: [
                    {
                        type: 'inside',
                        start: 0,
                        end: 5
                    },
                    {
                        start: 0,
                        end: 5
                    }
                ],
                series: [
                    {
                        name: '上映数',
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
                        data: data2
                    }
                ]
            }

            // 不同评分电影数量
            var chartGraphUni = this.$echarts.init(document.getElementById('chartsGraphUni'), null, {width: 990, height: 500})
            var optionSen = {
                tooltip: {
                    trigger: 'axis',
                    position: function(pt) {
                        return [pt[0], '10%']
                    }
                },
                title: {
                    left: 'center',
                    text: '不同评分已知电影数量'
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
                    data: date3
                },
                yAxis: {
                    type: 'value',
                    boundaryGap: [0, '100%']
                },
                dataZoom: [
                    {
                        type: 'inside',
                        start: 0,
                        end: 5
                    },
                    {
                        start: 0,
                        end: 5
                    }
                ],
                series: [
                    {
                        name: '电影数',
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
                        data: data6
                    }
                ]
            }

            // 不同时长电影数量
            var chartGraphBin = this.$echarts.init(document.getElementById('chartsGraphBin'), null, {width: 990, height: 500})
            var optionSep = {
                tooltip: {
                    trigger: 'axis',
                    position: function(pt) {
                        return [pt[0], '10%']
                    }
                },
                title: {
                    left: 'center',
                    text: '不同评分电影数量'
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
                    data: date4
                },
                yAxis: {
                    type: 'value',
                    boundaryGap: [0, '100%']
                },
                dataZoom: [
                    {
                        type: 'inside',
                        start: 0,
                        end: 5
                    },
                    {
                        start: 0,
                        end: 5
                    }
                ],
                series: [
                    {
                        name: '电影数',
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
                        data: data7
                    }
                ]
            }

            // 不同时长电影数量
            var chartGraphTer = this.$echarts.init(document.getElementById('chartsGraphTer'), null, {width: 990, height: 500})
            var optionOct = {
                tooltip: {
                    trigger: 'axis',
                    position: function(pt) {
                        return [pt[0], '10%']
                    }
                },
                title: {
                    left: 'center',
                    text: '不同票房电影数量'
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
                    data: date5.sort((New, old) => {
                        return New - old
                    })
                },
                yAxis: {
                    type: 'value',
                    boundaryGap: [0, '100%']
                },
                dataZoom: [
                    {
                        type: 'inside',
                        start: 0,
                        end: 50
                    },
                    {
                        start: 0,
                        end: 5
                    }
                ],
                series: [
                    {
                        name: '电影数',
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
                        data: data8
                    }
                ]
            }

            // 随机任意电影好评度
            // 请勿随意修改动画加载函数
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
            // 图形加载函数
            var chartPercentage = this.$echarts.init(document.getElementById('chartsPercentage'), null, {width: 480, height: 485})
            var optionUni = {
                animationEasing: _animationEasingUpdate,
                animationDuration: _animationDuration,
                animationDurationUpdate: _animationDurationUpdate,
                animationEasingUpdate: _animationEasingUpdate,
                title: {
                    text: '正在等待后台处理数据',
                    subtext: ''
                },
                dataset: {
                    source: [[1, 0]]
                },
                tooltip: {
                    trigger: 'axis'
                },
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

            var chartHistogram = this.$echarts.init(document.getElementById('chartsMultiRadar'), null, {width: 995, height: 485})
            var optionBin = {
                title: {
                    text: '票房预算柱状图'
                },
                legend: {
                    data: ['票房', '预算']
                },
                toolbox: {
                    // y: 'bottom',
                    feature: {
                        magicType: {
                            type: ['stack']
                        },
                        dataView: {},
                        saveAsImage: {
                            pixelRatio: 2
                        }
                    }
                },
                tooltip: {},
                xAxis: {
                    data: xAxisData,
                    nameTextStyle: {
                        align: 'right'
                    },
                    position: 'bottom',
                    offset: 10,
                    nameLocation: 'middle',
                    splitLine: {
                        show: false
                    },
                    axisLabel: {
                        interval: 0,
                        rotate: 60,
                        align: 'right'
                    }
                },
                yAxis: {},
                series: [
                    {
                        name: '票房',
                        type: 'bar',
                        data: data3,
                        emphasis: {
                            focus: 'series'
                        },
                        animationDelay: function(idx) {
                            return idx * 800 + 2500
                        }
                    },
                    {
                        name: '预算',
                        type: 'bar',
                        data: data4,
                        emphasis: {
                            focus: 'series'
                        },
                        animationDelay: function(idx) {
                            return idx * 800 + 2500
                        }
                    }
                ],
                animationEasing: 'elasticOut',
                animationDelayUpdate: function(idx) {
                    return idx * 5
                }
            }
            // 雷达图
            var chartSingleRadar = this.$echarts.init(document.getElementById('chartsSingleRadar'), null, {width: 480, height: 485})
            var optionTer = {
                title: {
                    text: '综合信息雷达图',
                    subtext: '左侧预算图中电影数据',
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
                        for (var i = 0; i < 20; i++) {
                            list.push(i + '')
                        }
                        return list
                    })()
                },
                visualMap: {
                    min: 0,
                    max: 11800,
                    top: 'top',
                    right: 10,
                    color: ['red', 'yellow'],
                    calculable: true
                },
                radar: {
                    indicator: [
                        { text: '票房', max: 2000000000 },
                        { text: '受欢迎度', max: 200 },
                        { text: '时长', max: 200 },
                        { text: '评分', max: 10 },
                        { text: '评价人数', max: 12000 }
                    ]
                },
                series: (function() {
                    var series = []
                    for (var i = 0; i < 20; i++) {
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
                                        i,
                                        i,
                                        i,
                                        i - 5,
                                        i
                                    ],
                                    name: i + ''
                                }
                            ]
                        })
                    }
                    return series
                })()
            }

            // 3D表格图控制代码
            var chartTransparent = this.$echarts.init(document.getElementById('chartsTransparent'), null, {width: 1500, height: 485})
            var optionQua = {
                title: {
                    text: '票房柱 单位: 亿元'
                },
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
                    type: 'category'
                },
                yAxis3D: {
                    type: 'category'
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
                            intensity: 0.6
                        }
                    }
                },
                series: [
                    {
                        name: '区间一',
                        type: 'bar3D',
                        data: data5,
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

        }
    }
}
</script>

<style scoped>
.hover {
    cursor: pointer;
}
</style>
