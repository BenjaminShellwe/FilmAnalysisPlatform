<!--suppress CommaExpressionJS -->
<template>
    <div>
        <FullCalendar slot="reference" :options="calendarOptions" />
        <el-dialog
            title="即将创建..."
            :visible.sync="pageDialogVisible"
            width="10%"
        >
            <el-row style="padding: 0 0 20px;">
                <span>请四选一 进行创建</span>
            </el-row>
            <el-row>
                <el-col :span="10" style="margin-top: 6px;">
                    <span>目标</span>
                </el-col>
                <el-col :span="14">
                    <el-button type="success" icon="el-icon-s-flag" circle style="margin-bottom: 10px;" @click="pageDialogActivateVisible=true, pageEventType='目标'" />
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10" style="margin-top: 6px;">
                    <span>提醒</span>
                </el-col>
                <el-col :span="14">
                    <el-button type="warning" icon="el-icon-thumb" circle style="margin-bottom: 10px;" @click="pageDialogActivateVisible=true, pageEventType='提醒'" />
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10" style="margin-top: 6px;">
                    <span>任务</span>
                </el-col>
                <el-col :span="14">
                    <el-button type="danger" icon="el-icon-finished" circle style="margin-bottom: 10px;" @click="pageDialogActivateVisible=true, pageEventType='任务'" />
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="10" style="margin-top: 6px;">
                    <span>活动</span>
                </el-col>
                <el-col :span="14">
                    <el-button type="primary" icon="el-icon-date" circle style="margin-bottom: 10px;" @click="pageDialogActivateVisible=true, pageEventType='活动'" />
                </el-col>
            </el-row>
        </el-dialog>
        <el-dialog
            :title="'创建一个'+pageEventType"
            width="30%"
            :visible.sync="pageDialogActivateVisible"
            @close="form.type=pageEventType, handleClearValue()"
        >
            <el-form :model="form">
                <el-row>
                    <el-col :span="14">
                        <el-form-item :label="pageEventType + '标题'" label-width="70px">
                            <el-input v-model="form.title" style="width: 220px;" auto-complete="off" :placeholder="'请输入'+pageEventType+'名称'" />
                        </el-form-item>
                    </el-col>
                    <el-col :span="10" style="margin-left: 20px; margin-top: 6px; width: 150px;">
                        <el-switch
                            v-model="switchDateTimePicker"
                            active-text="全天"
                            inactive-text="精确"
                            active-color="#13ce66"
                            inactive-color="#0000FF"
                        />
                    </el-col>
                </el-row>
                <el-row>
                    <el-col>
                        <el-form-item label="选择时间" label-width="70px">
                            <el-date-picker
                                v-show="!switchDateTimePicker"
                                v-model="form.timePickerValue"
                                type="datetimerange"
                                :picker-options="pickerOptions"
                                range-separator="至"
                                start-placeholder="开始时间"
                                end-placeholder="结束时间"
                                placeholder="选择时间范围"
                                size="medium"
                                style="width: 380px;"
                            />
                            <el-date-picker
                                v-show="switchDateTimePicker"
                                v-model="form.datePickerValue"
                                type="daterange"
                                :picker-options="pickerOptions"
                                range-separator="至"
                                start-placeholder="开始日期"
                                end-placeholder="结束日期"
                                size="medium"
                                style="width: 380px;"
                            />
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="14">
                        <el-form-item label="选择人员" label-width="70px">
                            <el-select v-model="form.selectCompanion" multiple placeholder="请选择将邀请参与人员" style="width: 220px;" :disabled="!switchSelectCompanion">
                                <el-option
                                    v-for="item in selectCompanions"
                                    :key="item.selectValue"
                                    :label="item.selectLabel"
                                    :value="item.selectValue"
                                    size="medium"
                                />
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="10" style="margin-left: 20px; margin-top: 6px; width: 150px;">
                        <el-switch
                            v-model="switchSelectCompanion"
                            active-text="公开"
                            inactive-text="私有"
                            active-color="#13ce66"
                            inactive-color="#0000FF"
                            @change="handleSwitch(3)"
                        />
                    </el-col>
                </el-row>
                <el-row>
                    <el-form-item :label="pageEventType+'内容'" label-width="70px">
                        <el-input
                            v-model="form.inputText"
                            type="textarea"
                            autosize
                            :placeholder="'请输入'+pageEventType+'说明内容'"
                            style="width: auto; min-width: 220px;"
                        />
                    </el-form-item>
                </el-row>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="pageDialogActivateVisible = false">取 消</el-button>
                <el-button type="primary" @click="handleButtonConfirm('pageDialogActivateVisible')">创建</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
import '@fullcalendar/core/vdom' // solves problem with Vite
import FullCalendar from '@fullcalendar/vue'
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from '@fullcalendar/interaction'
import timeGridPlugin from '@fullcalendar/timegrid'
import { INITIAL_EVENTS, createEventId } from './event-utils'
import axios from 'axios'

const dateOptions = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
export default {
    name: 'VCalendar',
    components: {
        FullCalendar // make the <FullCalendar> tag available
    },
    data: function() {
        return {
            calendarOptions: {
                plugins: [
                    dayGridPlugin,
                    timeGridPlugin,
                    interactionPlugin // needed for dateClick
                ],
                headerToolbar: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'dayGridMonth,timeGridWeek,timeGridDay'
                },
                buttonText: {
                    today: '今天',
                    month: '月',
                    week: '周',
                    day: '日'
                },
                locale: 'zh-cn', // 设置语言
                weekNumberCalculation: 'ISO', // 周数
                initialView: 'dayGridMonth',
                initialEvents: INITIAL_EVENTS, // alternatively, use the `events` setting to fetch from a feed
                editable: true,
                selectable: true,
                selectMirror: true,
                dayMaxEvents: true,
                weekends: true,
                select: this.handleDateSelect,
                eventClick: this.handleEventClick,
                eventsSet: this.handleEvents
                /* you can update a remote database when these fire:
                eventAdd:
                eventChange:
                eventRemove:
                */
            },
            eventTime: {
                hour: 'numeric',
                minute: '2-digit',
                hour12: false
            },
            calendarEvents: [],
            calendarEventDrop: info => {
                this.dropEvent(info)
            },
            handleDatesRender: arg => {
                this.getEventsList(arg.view)
            },

            dialogFormVisible: false,
            form: {
                id: null,
                type: null,
                title: null,
                timePickerValue: null,
                datePickerValue: null,
                selectCompanion: null,
                inputText: null,
                start: null,
                end: null
            },
            pageEventType: '',
            pickerOptions: {
                shortcuts: [{
                    text: '最近一周',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
                        picker.$emit('pick', [start, end])
                    }
                }, {
                    text: '最近一个月',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
                        picker.$emit('pick', [start, end])
                    }
                }, {
                    text: '最近三个月',
                    onClick(picker) {
                        const end = new Date()
                        const start = new Date()
                        start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
                        picker.$emit('pick', [start, end])
                    }
                }]
            },
            selectCompanions: [{
                selectValue: 'Opt1',
                selectLabel: 'benjamin'
            }, {
                selectValue: 'Opt2',
                selectLabel: 'thomas'
            }, {
                selectValue: 'Opt3',
                selectLabel: 'shellwe'
            }, {
                selectValue: 'Opt4',
                selectLabel: 'yufeng'
            }, {
                selectValue: 'Opt5',
                selectLabel: 'admin'
            }],
            currentEvents: [],
            checkAllWeek: false,
            checkDates: [''],
            checkMonth: '',
            checkYear: '',
            dates: dateOptions,
            isIndeterminateWeek: true,
            outerVisible: false,
            pageCheckboxVisible: false,
            pageDialogVisible: false,
            pageDialogActivateVisible: false,
            pageDivVisible: false,
            pageDateShow: false,
            pageTimeShow: true,
            pageInputTitle: '',
            pageInputContext: '',
            pageInputContextUni: '',
            inputText: '',
            pagePopoverVisible: false,
            switchDateTimePicker: true,
            switchSelectCompanion: true,
            selectValue: []
        }
    },
    watch: {

    },
    mounted() {

    },
    methods: {
        handleButtonConfirm(dialog) {
            this.pageDialogVisible = false
            this[dialog] = false
            // console.log(this.form)
            let pageSelectDateArray = this.selectValue
            let title = this.form.title
            let fullCalendarApi = pageSelectDateArray.view.calendar
            fullCalendarApi.unselect() // clear date selection
            if (title) {
                fullCalendarApi.addEvent({
                    // need to store in array 'from'
                    id: createEventId(),
                    title,
                    start: pageSelectDateArray.startStr,
                    end: pageSelectDateArray.endStr,
                    allDay: pageSelectDateArray.allDay
                })
            }
            this.form.title = null
            // console.log(createEventId())
        },
        handleCheckAllWeek(val) {
            this.checkDates = val ? dateOptions : []
            this.isIndeterminateWeek = false
            this.pageCheckboxVisible = !this.isIndeterminateWeek

        },
        handleClose(done) {
            this.$confirm('close?')
                .then(() => {
                    done()
                })
                .catch(() => {})
        },
        handleDateSelect(pageSelectDateArray) {
            this.selectValue = pageSelectDateArray
            // let title = prompt('Please enter a new title for your event')
            this.pageDialogVisible = true
        },
        handleEventClick(clickInfo) {
            // if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
            //     clickInfo.event.remove()
            // }
            // 通过clickInfo获取事件数据进行修改
            // this.pageDialogActivateVisible = true
            console.log(clickInfo)
            // this.form = {
            // }
        },
        handleEvents(events) {
            this.currentEvents = events
        },
        getEventsList(info) {
            let params = {
                start: info.activeStart,
                end: info.activeEnd
            }
            axios({
                method: 'post',
                url: 'url',
                data: params
            }).then(res => {
                this.calendarEvents = res
            })
            console.log(info)
        },
        handleSwitch(val) {
            if (val == 0) {
                if (this.pageSwitchValue == 0) {
                    this.pageTimeShow = true
                    this.pageDateShow = false
                } if (this.pageSwitchValue == 1) {
                    this.pageTimeShow = false
                    this.pageDateShow = true
                }
            }
            if (val == 1) {
                if (this.pageSwitchValue == 0) {
                    console.log()
                } if (this.pageSwitchValue == 1) {
                    console.log()
                }
            }
            if (val == 3) {
                console.log(this.switchSelectCompanion)
            }

        },
        handleWeekendsToggle() {
            this.calendarOptions.weekends = !this.calendarOptions.weekends // update a property
        },
        handleClearValue() {
            this.form = this.$options.data().form
            console.log(this.form)
        },
        // 保存事件
        saveEvent() {

        },
        // 删除事件
        delEvent() {

        },
        // 拖动事件
        dropEvent(info) {
            console.log(info)
        }
    }
}
</script>
<style>
.inLine {
    display: inline-block;
    margin-top: 10px;
    margin-bottom: 10px;
    margin-right: 10px;
}
.el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
}
.el-range-separator {
    width: 23px !important;
}
</style>

