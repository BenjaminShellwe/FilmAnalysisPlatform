<!--suppress CommaExpressionJS -->
<template>
    <div>
        <page-header title="企业账户">
            <template #content>
                <div class="inLine">
                    <p class="hover" @click="back">返回上一页</p>
                </div>
                &nbsp;
                <div class="inLine">
                    此页为企业账户的基本设置
                </div>
            </template>
        </page-header>
        <page-main title="企业账户">
            <el-row style="margin-bottom: 5px;">
                <el-col style="display: inline-block;">
                    <Auth :value="'permission.department'" style="display: inline-block; margin-right: 5px;">
                        <el-button type="primary" size="mini" @click="pageLogin('E')">启用企业管理账户</el-button>
                        <template slot="no-auth">
                            <span>请联系管理员<br>没有进入企业管理页面权限</span>
                        </template>
                    </Auth>
                    <el-button type="primary" size="mini" @click="pageLogin('P')">启用企业个人账户</el-button>
                </el-col>
            </el-row>
            <!--     pageRowVisible       -->
            <el-row v-show="true" :gutter="10" style="margin-bottom: 5px;">
                <el-col>
                    <el-card shadow="hover">
                        <el-descriptions class="margin-top" title="企业基本信息" :column="3" :size="size" border>
                            <template slot="extra">
                                <el-button type="primary" size="small" @click="reload(2)">刷 新</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="enterprise" />
                                    名 称
                                </template>
                                {{ pageValue.name }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="enterpriseID" />
                                    企业标识
                                </template>
                                {{ pageValue.id }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <svg-icon name="representative" />
                                    企业法人
                                </template>
                                {{ pageValue.representative }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline" />
                                    地 址
                                </template>
                                {{ pageValue.location }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-tickets" />
                                    类 型
                                </template>
                                <el-tag size="small">{{ pageValue.type }}</el-tag>
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-office-building" />
                                    联系地址
                                </template>
                                {{ pageValue.address }}
                            </el-descriptions-item>
                        </el-descriptions>
                    </el-card>
                    <el-row>
                        <el-row v-show="pageRowVisibleUni" :gutter="10" style="margin-top: 5px;">
                            <el-col>
                                <el-card shadow="hover">
                                    <div slot="header" class="clearfix">
                                        <span>个人信息</span>
                                        <el-button style="float: right; padding: 3px 0;" type="text">操作</el-button>
                                    </div>
                                    <el-descriptions class="margin-top" :column="3" :size="size" border>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-user" />
                                                职员姓名
                                            </template>
                                            {{ pageValueUni.realName }}
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-mobile" />
                                                工作电话
                                            </template>
                                            {{ pageValueUni.phone }}
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <svg-icon name="representative" />
                                                所属职位
                                            </template>
                                            <el-tag size="small">{{ pageValueUni.position }}</el-tag>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-location-outline" />
                                                备注信息
                                            </template>
                                            {{ pageValueUni.remarks }}
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-tickets" />
                                                企业名称
                                            </template>
                                            <el-tag size="small">{{ pageValueUni.enterpriseName }}</el-tag>
                                        </el-descriptions-item>
                                        <el-descriptions-item>
                                            <template slot="label">
                                                <i class="el-icon-office-building" />
                                                账号状态
                                            </template>
                                            {{ pageValueUni.status }}
                                        </el-descriptions-item>
                                    </el-descriptions>
                                </el-card>
                            </el-col>
                        </el-row>
                        <el-col :span="12">
                            <el-card shadow="hover" style="margin-top: 5px; margin-right: 5px;">
                                <div slot="header" class="clearfix">
                                    <span>员工状态</span>
                                    <el-button style="float: right; padding: 3px 0;" type="text">操作</el-button>
                                </div>
                                <el-table
                                    :data="pageTableData.filter(data => !pageSearch || data.userID.toLowerCase().includes(pageSearch.toLowerCase()))"
                                    style="width: 100%; height: 373px;"
                                >
                                    <el-table-column
                                        label="职员ID"
                                        prop="userID"
                                    />
                                    <el-table-column
                                        label="账户状态"
                                        prop="status"
                                    />
                                    <el-table-column
                                        label="职员名称"
                                        prop="realName"
                                    />
                                    <el-table-column
                                        align="right"
                                        fixed="right"
                                    >
                                        <template #header>
                                            <el-input
                                                v-model="pageSearch"
                                                size="mini"
                                                placeholder="输入职员ID字搜索"
                                                style="width: 135px;"
                                            />
                                        </template>
                                    </el-table-column>
                                </el-table>
                            </el-card>
                        </el-col>
                        <el-col :span="12">
                            <el-card shadow="hover" style="margin-top: 5px; margin-left: 5px;">
                                <div slot="header" class="clearfix">
                                    <span>组织树图</span>
                                    <el-button style="float: right; padding: 3px 0;" type="text">操作</el-button>
                                </div>
                                <el-row>
                                    <div class="Echarts">
                                        <div id="chartsUni" style="width: 705px; height: 373px;" />
                                    </div>
                                </el-row>
                            </el-card>
                        </el-col>
                    </el-row>
                </el-col>
            </el-row>
            <el-row v-show="pageRowVisible" style="margin-bottom: 5px;">
                <el-col :span="12">
                    <!--                员工信息录入    -->
                    <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                        <div slot="header" class="clearfix">
                            <span>员工录入 (点击右边进行操作)</span>
                            <el-button style="float: right; padding: 3px 0;" type="text" @click="pageTemplateShowUni = !pageTemplateShowUni">录入操作</el-button>
                        </div>
                        <el-card v-show="pageTemplateShowUni" shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                            <el-form ref="pageEmployeeForm" v-model="pageEmployeeForm" :rules="rules" hide-required-asterisk="hide-required-asterisk" :model="pageEmployeeForm" inline="inline" label-width="75px" size="mini">
                                <el-row>
                                    <el-alert
                                        title="所有信息都是必填 在输入账户后会自动查询姓名 输入部门时企业信息自动加载"
                                        type="error"
                                        style="margin: 5px 0;"
                                    />
                                    <el-col :span="22">
                                        <el-row>
                                            <el-form-item label="员工账户" prop="userID" :fit="true" style="margin: 2px 0 2px 0; width: 220px; height: 25px;">
                                                <el-select
                                                    v-model="pageEmployeeForm.userID"
                                                    filterable
                                                    allow-create
                                                    remote
                                                    reserve-keyword
                                                    placeholder="输入进行查询或者新建"
                                                    :remote-method="handleRemoteMethod"
                                                    :loading="pageLoading"
                                                    style="width: 145px;"
                                                    size="small"
                                                >
                                                    <el-option
                                                        v-for="item in options"
                                                        :key="item.value"
                                                        :label="item.label"
                                                        :value="item.value"
                                                    />
                                                </el-select>
                                            </el-form-item>
                                            <el-form-item label="员工性别" prop="sex" :fit="true" style="margin: 2px 0 2px 0; width: 220px; height: 20px;">
                                                <el-select v-model="pageEmployeeForm.sex" placeholder="请选择" style="width: 145px;">
                                                    <el-option label="先生" value="woman" />
                                                    <el-option label="女士" value="man" />
                                                </el-select>
                                            </el-form-item>
                                            <el-form-item label="隶属部门" prop="department" :fit="true" style="margin: 2px 0 2px 0; width: 220px;">
                                                <el-select
                                                    v-model="pageSelectValueUni"
                                                    filterable
                                                    allow-create
                                                    remote
                                                    reserve-keyword
                                                    placeholder="输入进行部门查询"
                                                    :remote-method="handleRemoteMethodUni"
                                                    :loading="pageLoading"
                                                    style="width: 145px; height: 20px;"
                                                    size="small"
                                                >
                                                    <el-option
                                                        v-for="item in optionsUni"
                                                        :key="item.value"
                                                        :label="item.label"
                                                        :value="item.value"
                                                    />
                                                </el-select>
                                            </el-form-item>
                                        </el-row>
                                        <el-row>
                                            <el-form-item label="员工姓名" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                <el-input v-model="pageEmployeeForm.userRealName" :placeholder="handleGetName(pageEmployeeForm.userID)" style="width: 145px;" disabled />
                                            </el-form-item>
                                            <el-form-item label="企业标识" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                <el-input v-model="pageEmployeeForm.enterpriseID" placeholder="输入账户自动装载" style="width: 145px;" disabled />
                                            </el-form-item>
                                            <el-form-item label="企业名称" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                <el-input v-model="pageEmployeeForm.enterprise" placeholder="输入账户自动装载" style="width: 145px;" disabled />
                                            </el-form-item>
                                        </el-row>
                                        <el-row>
                                            <el-form-item
                                                v-for="(item, index) in pageEmployeeFormHeader"
                                                :key="index"
                                                :prop="index"
                                                :label="item"
                                                :fit="true"
                                                style="margin: 5px 0 5px 0; width: 220px; height: 35px;"
                                            >
                                                <el-input v-model="pageEmployeeForm[index]" :name="index" :placeholder="index" style="width: 145px;" />
                                            </el-form-item>
                                            <el-form-item label="出生日期" prop="birth" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                <el-date-picker v-model="pageEmployeeForm.birth" type="date" style="width: 145px;" :picker-options="pickerOptions" placeholder="请选择日期" />
                                            </el-form-item>
                                            <el-form-item label="入职日期" prop="entry" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                <el-date-picker v-model="pageEmployeeForm.entry" type="date" style="width: 145px;" :picker-options="pickerOptions" placeholder="请选择日期" />
                                            </el-form-item>
                                        </el-row>
                                        <el-row style="height: 50px;">
                                            <el-form-item label="立即审核" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                <el-switch v-model="pageSwitchValue" active-text="立即提交审核" :width="25" />
                                            </el-form-item>
                                            <el-form-item label="录入人员" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                <el-switch v-model="pageSwitchValueUni" active-text="自动读取" :width="25" disabled />
                                            </el-form-item>
                                        </el-row>
                                        <el-row style="display: inline-block; margin: 0 0 0 8px; padding: 0; height: 30px;">
                                            <el-form-item label="基础权限" label-width="75px;" :fit="true">
                                                <el-row>
                                                    <el-col style="width: 80px;">
                                                        <el-checkbox v-model="checkAllUni" :indeterminate="isIndeterminate" border @change="handleCheckAllBasic">全选</el-checkbox>
                                                    </el-col>
                                                    <el-col style="width: 420px;">
                                                        <el-checkbox-group v-model="basicCheckedAuthorities" @change="handleCheckedBasicChange">
                                                            <el-checkbox-button v-for="basic in basicAuthorities" :key="basic" :label="basic">{{ basic }}</el-checkbox-button>
                                                        </el-checkbox-group>
                                                    </el-col>
                                                </el-row>
                                            </el-form-item>
                                        </el-row>
                                        <el-row style="display: inline-block; margin: 0 0 0 8px; padding: 0; height: 30px;">
                                            <el-form-item label="高级权限" label-width="75px;" :fit="true">
                                                <el-row>
                                                    <el-col style="width: 80px;">
                                                        <el-checkbox v-model="checkAllBin" :indeterminate="isIndeterminate" border @change="handleCheckAllAdvance">全选</el-checkbox>
                                                    </el-col>
                                                    <el-col style="width: 420px;">
                                                        <el-checkbox-group v-model="advanceCheckedAuthorities" @change="handleCheckedAdvanceChange">
                                                            <el-checkbox-button v-for="advance in advanceAuthorities" :key="advance" :label="advance">{{ advance }}</el-checkbox-button>
                                                        </el-checkbox-group>
                                                    </el-col>
                                                </el-row>
                                            </el-form-item>
                                        </el-row>
                                    </el-col>
                                    <el-col :span="2">
                                        <el-form-item size="mini">
                                            <el-row>
                                                <!--handleUpdate(pageEmployeeForm)-->
                                                <el-button type="primary" style="margin: 3px 0 3px 2px;" @click="handleConsole(pageEmployeeForm)">完成</el-button>
                                            </el-row>
                                            <el-row>
                                                <el-button style="margin: 5px 0 3px 2px;" @click="pageTemplateShowUni = false, pageEmployeeForm = {}">取消</el-button>
                                            </el-row>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                            </el-form>
                        </el-card>
                    </el-card>
                    <!--  start of 行政部门增添    -->
                    <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                        <div slot="header" class="clearfix">
                            <span>行政部门增添 开发中 (点击右边进行操作)</span>
                            <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                        </div>
                        <el-row>
                            <el-card shadow="hover" body-style="padding: 10px 0 10px 0;">
                                <el-form v-model="pageDataForm" label-width="75px" size="small" inline="inline" label-position="right">
                                    <el-row>
                                        <el-col :span="22">
                                            <el-row>
                                                <el-form-item label="部门ID" style="margin: 2px 0 2px 0; width: 220px; height: 53px;">
                                                    <el-input v-model="pageDepartmentHeader.departmentID" :placeholder="pageDepartmentHeader.departmentID" maxlength="30" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item
                                                    v-for="(item, index) in pageDepartmentHeader"
                                                    :key="index"
                                                    :prop="index"
                                                    :label="item"
                                                    :fit="true"
                                                    style="margin: 2px 0 2px 0; width: 220px; height: 53px;"
                                                >
                                                    <el-input v-model="pageDepartment[index]" :name="index" :placeholder="index" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item label="企业ID" style="margin: 2px 0 2px 0; width: 220px; height: 53px;">
                                                    <el-input v-model="pageDepartmentHeader.enterpriseID" :placeholder="pageDepartmentHeader.enterpriseID" maxlength="30" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item label="企业名称" style="margin: 2px 0 2px 0; width: 220px; height: 53px;">
                                                    <el-input v-model="pageDepartmentHeader.enterprise" :placeholder="pageDepartmentHeader.enterprise" maxlength="30" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item label="立即审核" :fit="true" style="margin: 5px 0 5px 0; width: 220px; height: 53px;">
                                                    <el-switch v-model="pageSwitchValue" active-text="立即提交审核" :width="25" />
                                                </el-form-item>
                                            </el-row>
                                        </el-col>
                                        <el-col :span="2">
                                            <el-form-item size="mini">
                                                <el-row>
                                                    <!--handleUpdate(pageEmployeeForm)-->
                                                    <el-button type="primary" style="margin: 6px 0 3px;">完成</el-button>
                                                </el-row>
                                                <el-row>
                                                    <el-button style="margin: 6px 0 3px;">取消</el-button>
                                                </el-row>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                            </el-card>
                        </el-row>
                    </el-card>
                    <!--  end of 行政部门增添 -->

                    <!-- start of 事务发布  -->
                    <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                        <div slot="header" class="clearfix">
                            <span>部门信息总览 开发中 (点击右边进行操作)</span>
                            <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                        </div>
                        <el-row>
                            <!--   预览 部门信息总览    -->
                            <el-col :span="12">
                                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 5px 2px;">
                                    <el-descriptions title="部门状态" :column="2" size="mini" border>
                                        <template slot="extra">
                                            <el-select
                                                v-model="pageDeptInfo.input"
                                                filterable
                                                allow-create
                                                remote
                                                reserve-keyword
                                                placeholder="输入进行部门查询"
                                                :remote-method="handleRemoteMethodUni"
                                                :loading="pageLoading"
                                                style="width: 150px; height: 20px;"
                                                size="small"
                                                @change="handleDeptInfoValue(pageDeptInfo.input)"
                                            >
                                                <el-option
                                                    v-for="item in optionsUni"
                                                    :key="item.value"
                                                    :label="item.label"
                                                    :value="item.value"
                                                />
                                            </el-select>
                                        </template>
                                        <el-descriptions-item label="部门">{{ pageDeptInfo.name }}</el-descriptions-item>
                                        <el-descriptions-item label="ID">{{ pageDeptInfo.departmentID }}</el-descriptions-item>
                                        <el-descriptions-item label="主管">{{ pageDeptInfo.director }}</el-descriptions-item>
                                        <el-descriptions-item label="经理">{{ pageDeptInfo.manager }}</el-descriptions-item>
                                        <el-descriptions-item label="状态">
                                            <el-tag size="small">{{ pageDeptInfo.departmentStatus }}</el-tag>
                                        </el-descriptions-item>
                                    </el-descriptions>
                                </el-card>
                            </el-col>
                            <el-col :span="12">
                                <el-card shadow="hover" body-style="padding: 5px;" style="margin: 5px 2px;">
                                    <!--      @tab-click=""         -->
                                    <el-tabs v-model="pageDeptInfo.affair" style="margin: 0 15px;">
                                        <el-tab-pane label="事务发布" name="second">
                                            <el-form ref="pageAffairForm" :model="pageAffairForm" label-width="10px;" size="mini" style="display: inline-block;" label-position="left">
                                                <el-row style="height: 25px; margin: 1px; padding: 1px;">
                                                    <el-col :span="12">
                                                        <el-form-item label="名称">
                                                            <el-input v-model="pageAffairForm.name" style="height: 20px; width: 70%;" />
                                                        </el-form-item>
                                                    </el-col>
                                                    <el-col :span="12">
                                                        <el-form-item label="时间">
                                                            <el-date-picker v-model="pageAffairForm.date" type="datetime" placeholder="选择日期" style="height: 20px; width: 70%;" />
                                                        </el-form-item>
                                                    </el-col>
                                                </el-row>
                                                <el-row style="height: 25px; margin: 1px; padding: 1px;">
                                                    <el-form-item label="性质">
                                                        <el-checkbox-group v-model="pageAffairForm.type">
                                                            <el-checkbox-button label="线上" name="type" />
                                                            <el-checkbox-button label="线下" name="type" />
                                                            <el-checkbox-button label="品牌" name="type" />
                                                        </el-checkbox-group>
                                                    </el-form-item>
                                                </el-row>
                                                <el-row style="margin: 2px 0; padding: 1px 0;">
                                                    <el-form-item style="margin: 2px 0; padding: 1px 0;">
                                                        <el-input v-model="pageAffairForm.desc" placeholder="事务内容详情" style="margin: 2px 0; padding: 1px 0;" type="textarea" />
                                                    </el-form-item>
                                                    <el-form-item>
                                                        <el-button type="primary">立即创建</el-button>
                                                        <el-button>取消</el-button>
                                                    </el-form-item>
                                                </el-row>
                                            </el-form>
                                        </el-tab-pane>
                                        <el-tab-pane label="通知发布" name="third">
                                            <el-form ref="pageAffairForm" :model="pageAffairForm" label-width="10px;" size="mini" style="display: inline-block;" label-position="left">
                                                <el-row style="height: 25px; margin: 1px; padding: 1px;">
                                                    <el-col :span="12">
                                                        <el-form-item label="名称">
                                                            <el-input v-model="pageAffairForm.name" style="height: 20px; width: 70%;" />
                                                        </el-form-item>
                                                    </el-col>
                                                    <el-col :span="12">
                                                        <el-form-item label="时间">
                                                            <el-date-picker v-model="pageAffairForm.date" type="datetime" placeholder="选择日期" style="height: 20px; width: 70%;" />
                                                        </el-form-item>
                                                    </el-col>
                                                </el-row>
                                                <el-row style="height: 25px; margin: 1px; padding: 1px;">
                                                    <el-form-item label="类型">
                                                        <el-checkbox-group v-model="pageAffairForm.type">
                                                            <el-checkbox-button label="紧急" name="type" />
                                                            <el-checkbox-button label="常规" name="type" />
                                                            <el-checkbox-button label="通告" name="type" />
                                                        </el-checkbox-group>
                                                    </el-form-item>
                                                </el-row>
                                                <el-row style="margin: 2px 0; padding: 1px 0;">
                                                    <el-form-item style="margin: 2px 0; padding: 1px 0;">
                                                        <el-input v-model="pageAffairForm.desc" placeholder="通知内容详情" style="margin: 2px 0; padding: 1px 0;" type="textarea" />
                                                    </el-form-item>
                                                    <el-form-item>
                                                        <el-button type="primary">立即发布</el-button>
                                                        <el-button>取消</el-button>
                                                    </el-form-item>
                                                </el-row>
                                            </el-form>
                                        </el-tab-pane>
                                        <el-tab-pane label="定时任务" name="fourth">
                                            <el-form ref="pageAffairForm" :model="pageAffairForm" label-width="10px;" size="mini" style="display: inline-block;" label-position="left">
                                                <el-row style="height: 25px; margin: 1px; padding: 1px;">
                                                    <el-col :span="12">
                                                        <el-form-item label="名称">
                                                            <el-input v-model="pageAffairForm.name" style="height: 20px; width: 70%;" />
                                                        </el-form-item>
                                                    </el-col>
                                                    <el-col :span="12">
                                                        <el-form-item label="时间">
                                                            <el-date-picker v-model="pageAffairForm.date" type="datetime" placeholder="选择日期" style="height: 20px; width: 70%;" />
                                                        </el-form-item>
                                                    </el-col>
                                                </el-row>
                                                <el-row style="height: 25px; margin: 1px; padding: 1px;">
                                                    <el-form-item label="性质">
                                                        <el-checkbox-group v-model="pageAffairForm.type">
                                                            <el-checkbox-button label="线上" name="type" />
                                                            <el-checkbox-button label="线下" name="type" />
                                                            <el-checkbox-button label="品牌" name="type" />
                                                        </el-checkbox-group>
                                                    </el-form-item>
                                                </el-row>
                                                <el-row style="margin: 2px 0; padding: 1px 0;">
                                                    <el-form-item style="margin: 2px 0; padding: 1px 0;">
                                                        <el-input v-model="pageAffairForm.desc" placeholder="事务内容详情" style="margin: 2px 0; padding: 1px 0;" type="textarea" />
                                                    </el-form-item>
                                                    <el-form-item>
                                                        <el-button type="primary">立即创建</el-button>
                                                        <el-button>取消</el-button>
                                                    </el-form-item>
                                                </el-row>
                                            </el-form>
                                        </el-tab-pane>
                                    </el-tabs>
                                </el-card>
                            </el-col>
                        </el-row>
                    </el-card>
                    <!-- end of 事务发布    -->
                </el-col>
                <el-col :span="12">
                    <!--                员工信息更改    -->
                    <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                        <div slot="header" class="clearfix">
                            <span>信息更改 (点击右边进行操作)</span>
                            <el-button style="float: right; padding: 3px 0;" type="text" @click="pageTemplateShowBin = !pageTemplateShowBin">修改操作</el-button>
                        </div>
                        <el-row v-show="pageTemplateShowBin">
                            <el-card shadow="hover" body-style="padding: 10px 0 10px 0;">
                                <el-form v-model="pageDataForm" label-width="75px" size="small" inline="inline" label-position="right">
                                    <el-row>
                                        <el-table
                                            :data="pageTableData.filter(data => !pageSearchUni || data.userID.toLowerCase().includes(pageSearchUni.toLowerCase()))"
                                            style="width: 100%; height: 150px;"
                                        >
                                            <el-table-column
                                                label="职员ID"
                                                prop="userID"
                                            />
                                            <el-table-column
                                                label="职员名称"
                                                prop="realName"
                                            />
                                            <el-table-column
                                                align="right"
                                            >
                                                <template #header>
                                                    <el-input
                                                        v-model="pageSearchUni"
                                                        size="mini"
                                                        placeholder="输入关键字搜索"
                                                        style="width: 135px;"
                                                    />
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                    <el-row>
                                        <el-col :span="22">
                                            <el-row>
                                                <el-form-item
                                                    v-for="(item, index) in pageEmployeeChangeFormHeader"
                                                    :key="index"
                                                    :prop="index"
                                                    :label="item"
                                                    :fit="true"
                                                    style="margin: 2px 0 2px 0; width: 220px;"
                                                >
                                                    <el-input v-model="pageEmployeeChangeForm[index]" :name="index" :placeholder="index" style="width: 145px;" />
                                                </el-form-item>
                                            </el-row>
                                            <el-row>
                                                <el-form-item label="用户性别" prop="sex" style="margin: 2px 0 2px 0; width: 220px;">
                                                    <el-select v-model="value" :placeholder="pageDataForm.sex" style="width: 145px;">
                                                        <el-option
                                                            v-for="item in options"
                                                            :key="item.value"
                                                            :label="item.label"
                                                            :value="item.value"
                                                        />
                                                    </el-select>
                                                </el-form-item>
                                                <el-form-item label="所属公司" style="margin: 2px 0 2px 0; width: 220px;">
                                                    <el-input v-model="pageDataForm.enterprise" :placeholder="pageDataForm.enterprise" maxlength="30" style="width: 145px;" />
                                                </el-form-item>
                                            </el-row>
                                            <el-row style="display: inline-block; margin: 0 0 0 8px; padding: 0; height: 30px;">
                                                <el-form-item label="基础权限" label-width="75px;" :fit="true">
                                                    <el-row>
                                                        <el-col style="width: 80px;">
                                                            <el-checkbox v-model="checkAllTer" :indeterminate="isIndeterminate" border @change="handleCheckAllBasicUni">全选</el-checkbox>
                                                        </el-col>
                                                        <el-col style="width: 420px;">
                                                            <el-checkbox-group v-model="basicCheckedAuthoritiesUni" @change="handleCheckedBasicChangeUni">
                                                                <el-checkbox-button v-for="basic in basicAuthorities" :key="basic" :label="basic">{{ basic }}</el-checkbox-button>
                                                            </el-checkbox-group>
                                                        </el-col>
                                                    </el-row>
                                                </el-form-item>
                                            </el-row>
                                            <el-row style="display: inline-block; margin: 0 0 0 8px; padding: 0; height: 30px;">
                                                <el-form-item label="高级权限" label-width="75px;" :fit="true">
                                                    <el-row>
                                                        <el-col style="width: 80px;">
                                                            <el-checkbox v-model="checkAllQua" :indeterminate="isIndeterminate" border @change="handleCheckAllAdvanceUni">全选</el-checkbox>
                                                        </el-col>
                                                        <el-col style="width: 420px;">
                                                            <el-checkbox-group v-model="advanceCheckedAuthoritiesUni" @change="handleCheckedAdvanceChangeUni">
                                                                <el-checkbox-button v-for="advance in advanceAuthorities" :key="advance" :label="advance">{{ advance }}</el-checkbox-button>
                                                            </el-checkbox-group>
                                                        </el-col>
                                                    </el-row>
                                                </el-form-item>
                                            </el-row>
                                        </el-col>
                                        <el-col :span="2">
                                            <el-form-item size="mini">
                                                <el-row>
                                                    <!--handleUpdate(pageEmployeeForm)-->
                                                    <el-button type="primary" style="margin: 6px 0 3px;" @click="handleConsole(pageDataForm)">完成</el-button>
                                                </el-row>
                                                <el-row>
                                                    <el-button style="margin: 6px 0 3px;" @click="pageTemplateShowUni = false, pageEmployeeForm = {}">取消</el-button>
                                                </el-row>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                            </el-card>
                        </el-row>
                    </el-card>
                    <!-- start of 部门信息更改    -->
                    <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                        <div slot="header" class="clearfix">
                            <span>部门信息更改 开发中 (点击右边进行操作)</span>
                            <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                        </div>
                        <el-col>
                            <el-card shadow="hover" body-style="padding: 10px 0 10px 0;" style="margin: 5px 0;">
                                <el-form v-model="pageDepartment" label-width="75px" size="small" inline="inline" label-position="right">
                                    <el-row>
                                        <el-table
                                            :data="pageDepartmentData.filter(data => !pageSearchUni || data.userID.toLowerCase().includes(pageSearchUni.toLowerCase()))"
                                            style="width: 100%; max-height: 150px;"
                                        >
                                            <el-table-column
                                                label="部门ID"
                                                prop="departmentID"
                                            />
                                            <el-table-column
                                                label="部门名称"
                                                prop="name"
                                            />
                                            <el-table-column
                                                label="部门状态"
                                                prop="departmentStatus"
                                            />
                                            <el-table-column
                                                align="right"
                                            >
                                                <template #header>
                                                    <el-input
                                                        v-model="pageSearchUni"
                                                        size="mini"
                                                        placeholder="输入部门ID搜索"
                                                        style="width: 135px;"
                                                    />
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                    <el-row>
                                        <el-col :span="22">
                                            <el-row>
                                                <el-form-item label="部门ID" style="margin: 2px 0 2px 0; width: 220px;">
                                                    <el-input v-model="pageDepartmentHeader.departmentID" :placeholder="pageDepartmentHeader.departmentID" maxlength="30" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item
                                                    v-for="(item, index) in pageDepartmentHeader"
                                                    :key="index"
                                                    :prop="index"
                                                    :label="item"
                                                    :fit="true"
                                                    style="margin: 2px 0 2px 0; width: 220px;"
                                                >
                                                    <el-input v-model="pageDepartment[index]" :name="index" :placeholder="index" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item label="企业ID" style="margin: 2px 0 2px 0; width: 220px;">
                                                    <el-input v-model="pageDepartmentHeader.enterpriseID" :placeholder="pageDepartmentHeader.enterpriseID" maxlength="30" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item label="企业名称" style="margin: 2px 0 2px 0; width: 220px;">
                                                    <el-input v-model="pageDepartmentHeader.enterprise" :placeholder="pageDepartmentHeader.enterprise" maxlength="30" style="width: 145px;" />
                                                </el-form-item>
                                                <el-form-item label="立即审核" :fit="true" style="margin: 5px 0 5px 0; width: 220px;">
                                                    <el-switch v-model="pageSwitchValue" active-text="立即提交审核" :width="25" />
                                                </el-form-item>
                                            </el-row>
                                        </el-col>
                                        <el-col :span="2">
                                            <el-form-item size="mini">
                                                <el-row>
                                                    <!--handleUpdate(pageEmployeeForm)-->
                                                    <el-button type="primary" style="margin: 6px 0 3px;" @click="handleConsole(pageDataForm)">完成</el-button>
                                                </el-row>
                                                <el-row>
                                                    <el-button style="margin: 6px 0 3px;" @click="pageTemplateShowUni = false, pageEmployeeForm = {}">取消</el-button>
                                                </el-row>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                            </el-card>
                        </el-col>
                    </el-card>
                    <!-- end of 部门信息更改 -->

                    <!-- start of 事务处理  -->
                    <el-card shadow="hover" body-style="padding: 5px;" style="margin: 2px;">
                        <div slot="header" class="clearfix">
                            <span>部门事务修改与处理 开发中 (点击右边进行操作)</span>
                            <el-button style="float: right; padding: 3px 0;" type="text">修改操作</el-button>
                        </div>
                        <!--      @tab-click=""         -->
                        <el-tabs v-model="pageDeptInfoChange.affair" style="margin: 5px 15px;">
                            <el-tab-pane label="部门状态修改" name="first">
                                <el-form>
                                    <el-row>
                                        <el-col :span="22">
                                            <el-row>
                                                <el-form-item label="部门状态" style="margin: 2px 0 2px 0;">
                                                    <el-input v-model="pageDeptInfoChange.departmentStatus" :placeholder="pageDeptInfoChange.departmentStatus" maxlength="30" style="width: 135px;" />
                                                </el-form-item>
                                            </el-row>
                                        </el-col>
                                        <el-col :span="2">
                                            <el-form-item size="mini">
                                                <el-row>
                                                    <!--handleUpdate(pageEmployeeForm)-->
                                                    <el-button type="primary" style="margin: 6px 0 3px;">完成</el-button>
                                                </el-row>
                                                <el-row>
                                                    <el-button style="margin: 6px 0 3px;">取消</el-button>
                                                </el-row>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                            </el-tab-pane>
                            <el-tab-pane label="事务修改处理" name="second">
                                <el-form>
                                    <el-row>
                                        <el-col :span="22">
                                            <el-row>
                                                <el-form-item label="事务状态" style="margin: 2px 0 2px 0;">
                                                    <el-input v-model="pageDeptInfoChange.departmentStatus" :placeholder="pageDeptInfoChange.departmentStatus" maxlength="30" style="width: 135px;" />
                                                </el-form-item>
                                            </el-row>
                                        </el-col>
                                        <el-col :span="2">
                                            <el-form-item size="mini">
                                                <el-row>
                                                    <!--handleUpdate(pageEmployeeForm)-->
                                                    <el-button type="primary" style="margin: 6px 0 3px;">完成</el-button>
                                                </el-row>
                                                <el-row>
                                                    <el-button style="margin: 6px 0 3px;">取消</el-button>
                                                </el-row>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                            </el-tab-pane>
                            <el-tab-pane label="通知修改处理" name="third">
                                <el-form>
                                    <el-row>
                                        <el-col :span="22">
                                            <el-row>
                                                <el-form-item label="通知状态" style="margin: 2px 0 2px 0;">
                                                    <el-input v-model="pageDeptInfoChange.departmentStatus" :placeholder="pageDeptInfoChange.departmentStatus" maxlength="30" style="width: 135px;" />
                                                </el-form-item>
                                            </el-row>
                                        </el-col>
                                        <el-col :span="2">
                                            <el-form-item size="mini">
                                                <el-row>
                                                    <!--handleUpdate(pageEmployeeForm)-->
                                                    <el-button type="primary" style="margin: 6px 0 3px;">完成</el-button>
                                                </el-row>
                                                <el-row>
                                                    <el-button style="margin: 6px 0 3px;">取消</el-button>
                                                </el-row>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                            </el-tab-pane>
                            <el-tab-pane label="定时发布修改" name="fourth">
                                <el-form>
                                    <el-row>
                                        <el-col :span="22">
                                            <el-row>
                                                <el-form-item label="定时发布状态" style="margin: 2px 0 2px 0;">
                                                    <el-input v-model="pageDeptInfoChange.departmentStatus" :placeholder="pageDeptInfoChange.departmentStatus" maxlength="30" style="width: 135px;" />
                                                </el-form-item>
                                            </el-row>
                                        </el-col>
                                        <el-col :span="2">
                                            <el-form-item size="mini">
                                                <el-row>
                                                    <!--handleUpdate(pageEmployeeForm)-->
                                                    <el-button type="primary" style="margin: 6px 0 3px;">完成</el-button>
                                                </el-row>
                                                <el-row>
                                                    <el-button style="margin: 6px 0 3px;">取消</el-button>
                                                </el-row>
                                            </el-form-item>
                                        </el-col>
                                    </el-row>
                                </el-form>
                            </el-tab-pane>
                        </el-tabs>
                    </el-card>
                    <!-- end of 事务处理    -->
                </el-col>
            </el-row>
            <!--        员工信息页面    -->
            <el-row v-show="pageRowVisibleUni">
                <el-col>
                    <el-card>
                        <el-row>
                            <el-col :span="7" shadow="hover" style="margin-left: 10px; margin-right: 10px;">
                                <el-card shadow="hover">
                                    <div slot="header" class="clearfix">
                                        <span>工作日程</span>
                                    </div>
                                    <span>企业通知</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template #default="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        移除
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                    <span>部门通知</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template #default="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        移除
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                    <span>今日日程</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template #default="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        已读
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                </el-card>
                            </el-col>
                            <el-col :span="7" shadow="hover" style="margin-left: 10px; margin-right: 10px;">
                                <el-card shadow="hover">
                                    <div slot="header" class="clearfix">
                                        <span>事务申请</span>
                                    </div>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="会议申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('会议')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交会议申请
                                                    </template>
                                                    请申请前阅读注意事项
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">主管级别以上</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="请假申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('请假')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交请假申请
                                                    </template>
                                                    包括所有请假类型
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">合适理由及剩余假期</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="离职申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('离职')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交离职申请
                                                    </template>
                                                    认真思考后填写
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">符合劳务合同解除要求</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                    <el-row style="margin-top: 5px;">
                                        <el-card shadow="hover">
                                            <el-descriptions class="margin-top" title="自定义申请" :column="2" :size="size" border>
                                                <template slot="extra">
                                                    <el-button type="primary" size="small" @click="handleApplication('自定义')">填写申请</el-button>
                                                </template>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        提交自定义申请
                                                    </template>
                                                    提供基本申请模板
                                                </el-descriptions-item>
                                                <el-descriptions-item>
                                                    <template slot="label">
                                                        要求
                                                    </template>
                                                    <el-tag size="small">符合基本制度要求</el-tag>
                                                </el-descriptions-item>
                                            </el-descriptions>
                                        </el-card>
                                    </el-row>
                                </el-card>
                            </el-col>
                            <el-dialog
                                :title="pageDialogTitle + '申请'"
                                :visible.sync="dialogVisibleUni"
                                width="30%"
                                :before-close="handleClose"
                            >
                                <span>条件不满足也可以申请,但审核将会较为严格</span>
                                <div>
                                    申请理由：
                                    <el-input
                                        v-model="pageInput"
                                        placeholder="请填写原由"
                                        style="width: 350px;"
                                        size="mini"
                                    />
                                </div>
                                <div>
                                    附加内容：
                                    <el-input
                                        v-model="pageInputUni"
                                        placeholder="附加说明"
                                        style="width: 350px;"
                                        size="mini"
                                    />
                                </div>
                                <span slot="footer" class="dialog-footer">
                                    <el-button @click="dialogVisibleUni = false">取 消</el-button>
                                    <el-button type="primary" @click="dialogVisibleUni = false">确 定</el-button>
                                </span>
                            </el-dialog>
                            <el-col :span="7" shadow="hover" style="margin-left: 10px; margin-right: 10px;">
                                <el-card shadow="hover">
                                    <span>事务状态</span>
                                    <el-row>
                                        <el-table
                                            :data="pageEnterpriseNotice"
                                            style="width: 100%;"
                                        >
                                            <el-table-column
                                                fixed
                                                prop="date"
                                                label="日期"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="内容"
                                            />
                                            <el-table-column
                                                prop="name"
                                                label="类型"
                                            />
                                            <el-table-column
                                                fixed="right"
                                                label="操作"
                                            >
                                                <template #default="scope">
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                    >
                                                        查看
                                                    </el-button>
                                                    <el-button
                                                        type="text"
                                                        size="small"
                                                        @click.native.prevent="deleteRow(scope.$index, pageEnterpriseNotice)"
                                                    >
                                                        移除
                                                    </el-button>
                                                </template>
                                            </el-table-column>
                                        </el-table>
                                    </el-row>
                                </el-card>
                            </el-col>
                        </el-row>
                    </el-card>
                </el-col>
            </el-row>
            <el-row v-show="true" style="margin-bottom: 5px;">
                <el-col>
                    <el-card shadow="hover">
                        <el-tabs title="行政管理(仅是展示)">
                            <el-tab-pane label="办公空间(建立)" name="first">
                                <el-collapse accordion>
                                    <el-collapse-item title="1.1 选址" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="1.2 租赁" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="1.3 装修" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="1.4 搬迁" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="办公环境(维护)" name="second">
                                <el-collapse accordion>
                                    <el-collapse-item title="2.1 卫生" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="2.2 环境(照明,温湿,空气)" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="2.3 绿植" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="2.4 公共空间" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="2.5 报修" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="2.6 安保" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="采购管理(买进)" name="third">
                                <el-collapse accordion>
                                    <el-collapse-item title="3.1 小额报销采购" name="1">
                                        <el-collapse accordion>
                                            <el-collapse-item title="3.1.1 采购" name="11">
                                                <el-empty description="不实现" />
                                            </el-collapse-item>
                                            <el-collapse-item title="3.1.2 报销" name="22">
                                                <el-empty description="不实现" />
                                            </el-collapse-item>
                                            <el-collapse-item title="3.1.3 记账" name="33">
                                                <el-empty description="不实现" />
                                            </el-collapse-item>
                                        </el-collapse>
                                    </el-collapse-item>
                                    <el-collapse-item title="3.2 合同对公采购(照明,温湿,空气)" name="2">
                                        <el-collapse-item title="3.2.1 采购申请" name="111">
                                            <el-empty description="不实现" />
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.2 供应商登记" name="222">
                                            <el-empty description="不实现" />
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.3 合同审批" name="333">
                                            <el-empty description="不实现" />
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.4 支付与验收" name="444">
                                            <el-empty description="不实现" />
                                        </el-collapse-item>
                                        <el-collapse-item title="3.2.5 入账" name="555">
                                            <el-empty description="不实现" />
                                        </el-collapse-item>
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="资产维护(维护)" name="fourth">
                                <el-collapse accordion>
                                    <el-collapse-item title="4.1 入库出库" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="4.2 维修维护" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="4.3 盘点" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="4.4 报废" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="IT运维(运维)" name="fifth">
                                <el-collapse accordion>
                                    <el-collapse-item title="5.1 计算机调试维修维护" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="5.2 网络设施通信维护" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="5.3 数据维护" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="5.4 企业邮件管理" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="其它事务" name="sixth">
                                <el-collapse accordion>
                                    <el-collapse-item title="6.1 接待" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="6.2 会议" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="6.3 差旅" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="6.4 通知" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="科技项目" name="seventh">
                                <el-collapse accordion>
                                    <el-collapse-item title="7.1 项目规划" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="7.2 项目立项" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="7.3 项目申报" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="7.4 项目验收" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="供应商管理" name="eighth">
                                <el-collapse accordion>
                                    <el-collapse-item title="8.1 按程序" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="8.2 按对象" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="行政费用管理" name="ninth">
                                <el-collapse accordion>
                                    <el-collapse-item title="9.1 预算编制" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="9.2 预算执行项" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="9.3 预算分析" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="9.4 预算控制" name="4">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="制度流程" name="tenth">
                                <el-collapse accordion>
                                    <el-collapse-item title="10.1 制度规定" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="10.2 工作流程" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="10.3 执行标准" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                            <el-tab-pane label="团队建设" name="eleventh">
                                <el-collapse accordion>
                                    <el-collapse-item title="11.1 部门工作职责梳理" name="1">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="11.2 部门工作分配协调" name="2">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                    <el-collapse-item title="11.3 人员规划与指导" name="3">
                                        <el-empty description="不实现" />
                                    </el-collapse-item>
                                </el-collapse>
                            </el-tab-pane>
                        </el-tabs>
                    </el-card>
                </el-col>
            </el-row>
            <div v-show="true">
                <span>statement:double click would closed the window button create.</span>
                <el-row>
                    <el-col>
                        <el-card>
                            <el-button-group style="margin-right: 10px;">
                                <el-button type="success" plain @click="pageValueChange('user')">用户信息总览(用户)</el-button>
                                <el-button type="primary" plain @click="pageValueChange('background')">背调信息总览(背调)</el-button>
                            </el-button-group>
                            <el-button-group style="margin-right: 10px;">
                                <el-button type="success" plain @click="pageValueChange('role')">角色信息总览(角色)</el-button>
                                <el-button type="primary" plain @click="pageValueChange('permission')">权限控制总览(权限)</el-button>
                                <el-button type="warn" plain @click="pageValueChange('performance')">绩效信息总览(绩效)</el-button>
                            </el-button-group>
                        </el-card>
                    </el-col>
                    <el-col v-if="page.subContent.user" :span="4">
                        content of 用户信息总览(用户)
                    </el-col>
                    <el-col v-if="page.subContent.background" :span="4">
                        content of 背调信息总览(背调)
                    </el-col>
                    <el-col v-if="page.subContent.role" :span="4">
                        content of 角色信息总览(角色)
                    </el-col>
                    <el-col v-if="page.subContent.permission" :span="4">
                        content of 权限控制总览(权限)
                    </el-col>
                    <el-col v-if="page.subContent.performance" :span="4">
                        content of 绩效信息总览(绩效)
                    </el-col>
                    <el-col v-if="page.subContent.remain" :span="4">
                        content of 保留内容
                    </el-col>
                </el-row>
            </div>
        </page-main>
        <el-dialog
            title="来自shellwe的警告"
            :visible.sync="dialogVisible"
            width="30%"
        >
            <span>
                开发中 暂时拒绝提交至后台 数据未更改<br>
                此页面将会优先开发企业页面
            </span>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="dialogVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="dialogVisible = false">明 白</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
import PageHeader from '@/components/PageHeader'
import PageMain from '@/components/PageMain'
import axios from 'axios'
const cityOptions = ['上海', '北京', '广州', '深圳']
const basicAuthority = ['基本读取', '基本增加', '基本删除', '基本查询', '基本修改']
const advanceAuthority = ['高级读取', '高级增加', '高级删除', '高级查询', '高级修改']
export default {
    name: 'Basic',
    components: {PageMain, PageHeader},
    inject: ['reload'],
    data() {
        return {
            pageAffair: '',
            pageSwitchValue: false,
            pageSwitchValueUni: true,
            pageTemplateShowUni: true,
            pageTemplateShowBin: true,
            dialogVisible: false,
            dialogVisibleUni: false,
            enterpriseID: '',
            enterprise: '',
            pageInput: '',
            pageInputUni: '',
            pageDialogTitle: '',
            pageRowVisible: false,
            pageRowVisibleUni: false,
            pageSelectValue: [],
            pageSelectValueUni: [],
            size: 'mini',
            pageSearch: '',
            pageSearchUni: '',
            pageLoading: false,
            options: [],
            optionsUni: [],
            pageRemoteValue: [],
            pageRemoteValueUni: [],
            list: [],
            listUni: [],
            value: '',
            checkAll: false,
            checkAllUni: false,
            checkAllBin: false,
            checkAllTer: false,
            checkAllQua: false,
            checkedCities: ['上海', '北京'],
            cities: cityOptions,
            basicCheckedAuthorities: ['基本读取', '基本增加', '基本修改'],
            advanceCheckedAuthorities: [],
            basicCheckedAuthoritiesUni: ['基本读取', '基本增加', '基本修改'],
            advanceCheckedAuthoritiesUni: [],
            basicAuthorities: basicAuthority,
            advanceAuthorities: advanceAuthority,
            basicAuthoritiesUni: basicAuthority,
            advanceAuthoritiesUni: advanceAuthority,
            isIndeterminate: true,
            pageEnterpriseNotice: [{}],
            pickerOptions: {
                disabledDate(time) {
                    return time.getTime() > Date.now()
                },
                shortcuts: [{
                    text: '今天',
                    onClick(picker) {
                        picker.$emit('pick', new Date())
                    }
                }, {
                    text: '昨天',
                    onClick(picker) {
                        const date = new Date()
                        date.setTime(date.getTime() - 3600 * 1000 * 24)
                        picker.$emit('pick', date)
                    }
                }, {
                    text: '一周前',
                    onClick(picker) {
                        const date = new Date()
                        date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
                        picker.$emit('pick', date)
                    }
                }]
            },
            pageTemporaryTransfer: {},
            pageDeptInfo: {
                input: '',
                name: '未检测到数据',
                departmentStatus: '未检测到数据',
                director: '未检测到数据',
                manager: '未检测到数据',
                departmentID: '未检测到数据',
                affair: ''
            },
            pageAffairForm: {
                name: '',
                date: '',
                time: '',
                type: [],
                desc: ''
            },
            pageDeptInfoChange: {
                affair: '',
                affairForm: {
                    name: '',
                    date: '',
                    time: '',
                    type: [],
                    desc: ''
                },
                name: '未检测到数据',
                departmentStatus: '未检测到数据',
                director: '未检测到数据',
                manager: '未检测到数据',
                departmentID: '未检测到数据'
            },
            pageDataForm: {
                realName: 'Benjamin Thomas Shellwe',
                nickName: 'shellwe',
                phone: '176***2321',
                homeUrl: 'http://shellwe.top',
                enterprise: 'TernaryProjectTeam',
                qq: '774****22',
                wechat: '176***2321',
                remarks: '',
                sex: ''
            },
            pageEmployeeForm: {
                userID: '',
                userRealName: '',
                enterprise: '',
                enterpriseID: '',
                position: '',
                department: '',
                phone: '',
                remarks: '',
                political: '',
                status: '',
                birth: '',
                entry: '',
                salary: '',
                type: '',
                sex: ''
            },
            pageEmployeeChangeForm: {
                userID: '',
                userRealName: '',
                enterprise: '',
                enterpriseID: '',
                position: '',
                department: '',
                phone: '',
                remarks: '',
                political: '',
                status: '',
                birth: '',
                entry: '',
                salary: '',
                type: '',
                sex: ''
            },
            pageEmployeeFormHeader: {
                political: '政治面貌',
                phone: '手机号码',
                salary: '入职工资',
                position: '所属职位',
                status: '员工状态',
                type: '入职方式',
                remarks: '员工备注'
            },
            pageEmployeeChangeFormHeader: {
                political: '政治面貌',
                phone: '手机号码',
                salary: '入职工资',
                position: '所属职位',
                status: '员工状态',
                type: '入职方式',
                remarks: '员工备注'
            },
            pageDepartment: {
                name: '',
                departmentStatus: '',
                UIDD: '',
                director: '',
                phoneD: '',
                UIDM: '',
                manager: '',
                phoneM: '',
                departmentID: '',
                enterpriseID: '',
                enterprise: ''
            },
            pageDepartmentHeader: {
                name: '部门名称',
                departmentStatus: '部门状态',
                director: '负责经理',
                UIDD: '经理ID',
                phoneD: '经理电话',
                manager: '负责主管',
                UIDM: '主管ID',
                phoneM: '主管电话'
            },
            rules: {
                userID: [
                    { required: true, message: '请输入员工账户ID', trigger: 'change' }
                ],
                sex: [
                    { required: true, message: '请选择员工性别', trigger: 'change' }
                ],
                department: [
                    { required: true, message: '请输入部门', trigger: 'blur' }
                ],
                phone: [
                    { required: true, message: '请输入电话号码', trigger: 'blur' }
                ],
                type: [
                    { required: true, message: '请输入入职方式', trigger: 'blur' }
                ],
                position: [
                    { required: true, message: '请输入所属职位', trigger: 'blur' }
                ],
                political: [
                    { required: true, message: '请输入政治面貌', trigger: 'blur' }
                ],
                salary: [
                    { required: true, message: '请输入员工工资', trigger: 'blur' }
                ],
                status: [
                    { required: true, message: '请输入员工状态', trigger: 'blur' }
                ],
                entry: [
                    { type: 'date', required: true, message: '请选择日期', trigger: 'blur' }
                ],
                birth: [
                    { type: 'date', required: true, message: '请选择时间', trigger: 'blur' }
                ],
                remarks: [
                    { required: true, message: '请输入员工备注', trigger: 'blur' }
                ]
            },
            pageTableData: [
                {
                    userID: '',
                    status: '',
                    realName: ''
                }
            ],
            pageDepartmentData: [
                {

                    departmentID: '',
                    name: '',
                    departmentStatus: ''
                }
            ],
            pageValue: {
                enterpriseID: '数据脱敏处理Example',
                name: '数据脱敏处理Example',
                id: '数据脱敏处理Example',
                representative: '数据脱敏处理Example',
                location: '数据脱敏处理Example',
                type: '数据脱敏处理Example',
                address: '数据脱敏处理Example'
            },
            pageValueUni: {
                department: '数据脱敏处理Example',
                enterpriseID: '数据脱敏处理Example',
                enterpriseName: '数据脱敏处理Example',
                id: '数据脱敏处理Example',
                phone: '数据脱敏处理Example',
                position: '数据脱敏处理Example',
                realName: '数据脱敏处理Example',
                remarks: '数据脱敏处理Example',
                status: '数据脱敏处理Example',
                userID: '数据脱敏处理Example'
            },
            page: {
                content: false,
                loginButton: true,
                subContent: {
                    user: false,
                    background: false,
                    role: false,
                    permission: false,
                    performance: false,
                    remain: false
                }
            }
        }
    },
    created() {
    },
    mounted() {
        this.echartsUni()
        this.handleGetValue()
    },
    methods: {
        back() {
            history.go(-1)
        },
        pageLogin(val) {
            if (val == 'E') {
                const that = this
                axios({
                    method: 'post',
                    url: '/queryInfo/employee',
                    data: {
                        userID: this.$store.state.user.id
                    }
                }).then(function(response) {
                    that.enterpriseID = response.data.data[0].enterpriseID
                    that.pageValue.enterpriseID = response.data.data[0].enterpriseID
                    // console.log(that.pageValue.enterpriseID)
                    axios({
                        method: 'post',
                        url: '/enterprise/query/Info',
                        data: {
                            userID: that.pageValue.enterpriseID
                            // 测试数据
                            // userID: 123654
                        }
                    }).then(function(response) {
                        // console.log(response.data.data)
                        if (response.data.data == null) {
                            that.$message(response.data.msg)
                        } else {
                            that.pageRowVisible = true
                            that.pageValue = response.data.data[0]
                            // console.log(response.data.data)
                            // console.log(that.pageValue.)
                            // that.page.loginButton = false
                            axios({
                                method: 'post',
                                url: '/queryInfo/enterprise',
                                data: {
                                    enterpriseID: response.data.data[0].id
                                }
                            }).then(function(response) {
                                // console.log(response)
                                that.pageTableData = response.data.data
                                // console.log(that.pageTableData)
                            }).catch(function(error) {
                                console.log(error)
                            })
                        }
                    })
                }).catch(function(error) {
                    console.log(error)
                })
                // this.page.loginButton = false
                // this.page.content = true
            } if (val == 'P') {
                const that = this
                axios({
                    method: 'post',
                    url: '/queryInfo/employee',
                    data: {
                        userID: this.$store.state.user.id
                    }
                }).then(function(response) {
                    if (response.data.data == null) {
                        that.$message(response.data.msg)
                    }
                    that.pageValueUni = response.data.data[0]
                    that.pageRowVisibleUni = true
                }).catch(function(error) {
                    console.log(error)
                })
            }
        },
        pageValueChange(val) {
            let value = new Boolean(value)
            value = this.page.subContent[val]
            this.$set(this.page.subContent, val, !value)
            console.log(this.page.subContent)
        },
        // handleGetValue 获取EID进行查询
        handleGetValue() {
            const that = this
            // 查询没有绑定企业的账户
            axios({
                method: 'post',
                url: '/user/query/EID',
                data: {
                    enterpriseID: 0
                }
            }).then(function(response) {
                // console.log(response)
                let t = {}
                let u = []
                response.data.data.forEach(function(item) {
                    for (let key in item) {
                        if (key == 'id') {
                            t[key] = item[key]
                        }
                        if (key == 'userRealName') {
                            t[key] = item[key]
                        }
                    }
                    u.push(t)
                    t = {}
                    for (let key in u) {
                        if (u[key].id !== '' && u[key].id !== null) {
                            // console.log(u[key].id)
                            that.pageRemoteValue.push(u[key])
                            that.pageRemoteValue = that.pageRemoteValue.sort()
                            var array = [that.pageRemoteValue[0]]
                            for (var i = 1; i < that.pageRemoteValue.length; i++) {
                                if (that.pageRemoteValue[i] !== that.pageRemoteValue[i - 1]) {
                                    array.push(that.pageRemoteValue[i])
                                }
                            }
                            that.pageRemoteValue = array
                        }
                    }
                    t = {}
                    // console.log(that.pageRemoteValue)
                    // that.pageRemoteValue = u
                    // console.log(that.pageRemoteValue)
                    that.list = that.pageRemoteValue.map(item => {
                        return {value: `${item.userRealName}`, label: `${item.id}`}
                    })
                    // console.log(that.pageRemoteValue.map)
                    // console.log(that.list)
                })
            }).catch(function(error) {
                console.log(error)
            })
            // 获取EID
            axios({
                method: 'post',
                url: '/queryInfo/employee',
                data: {
                    userID: this.$store.state.user.id
                }
            }).then(response => {
                // console.log(response)
                this.enterpriseID = response.data.data[0].enterpriseID
                this.enterprise = response.data.data[0].enterprise
                // 查询已知企业的部门
                axios({
                    method: 'post',
                    url: '/queryInfo/enterprise/department',
                    data: {
                        enterpriseID: this.enterpriseID
                    }
                }).then(response => {
                    // console.log(response)
                    let t = {}
                    let u = []
                    response.data.data.forEach(item => {
                        for (let key in item) {
                            if (key == 'name') {
                                t[key] = item[key]
                            }
                        }
                        u.push(t)
                        t = {}
                        for (let key in u) {
                            if (u[key].name !== '' && u[key].name !== null) {
                                // console.log(u[key].id)
                                that.pageRemoteValueUni.push(u[key].name)
                                that.pageRemoteValueUni = that.pageRemoteValueUni.sort()
                                let array = [that.pageRemoteValueUni[0]]
                                for (let i = 1; i < that.pageRemoteValueUni.length; i++) {
                                    if (that.pageRemoteValueUni[i] !== that.pageRemoteValueUni[i - 1]) {
                                        array.push(that.pageRemoteValueUni[i])
                                    }
                                }
                                that.pageRemoteValueUni = array
                            }
                        }
                        t = {}
                        // console.log(that.pageRemoteValue)
                        // that.pageRemoteValue = u
                        // console.log(that.pageRemoteValue)
                        that.listUni = that.pageRemoteValueUni.map(item => {
                            return {value: `${item}`, label: `${item}`}
                        })
                        // console.log(that.pageRemoteValue.map)
                        // console.log(that.listUni)
                    })
                    this.pageTemporaryTransfer = response.data.data
                })
            }).catch(error => {
                this.$notify({
                    message: error,
                    duration: 6055
                })
            })
        },
        handleRemoteMethod(query) {
            if (query !== '') {
                this.pageLoading = true
                setTimeout(() => {
                    this.pageLoading = false
                    this.options = this.list.filter(item => {
                        return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1
                    })
                }, 1000)
                // console.log(this.list)
                // console.log(this.options)
            } else {
                this.options = []
            }
        },
        handleRemoteMethodUni(query) {
            if (query !== '') {
                this.pageLoading = true
                setTimeout(() => {
                    this.pageLoading = false
                    this.optionsUni = this.listUni.filter(item => {
                        return item.label.toLowerCase().indexOf(query.toLowerCase()) > -1
                    })
                }, 1000)
                // console.log(this.listUni)
                // console.log(this.options)
                this.pageEmployeeForm.enterpriseID = this.enterpriseID
                this.pageEmployeeForm.enterprise = this.enterprise
            } else {
                this.options = []
            }
        },
        echartsUni() {
            var chartUni = this.$echarts.init(document.getElementById('chartsUni'))
            const data = {
                name: 'Chief',
                children: [
                    {
                        name: 'Manager',
                        children: [
                            { name: 'Supervisor', value: 8833 },
                            { name: 'Employee', value: 1732 },
                            { name: 'Other', value: 3623 }
                        ]
                    },
                    {
                        name: 'Inspector',
                        children: [{ name: 'Manager', value: 9116 }, { name: 'Other', value: 3623 }]
                    }
                ]
            }
            var data2 = {
                name: 'flare',
                children: [
                    {
                        name: 'flex',
                        children: [{ name: 'FlareVis', value: 4116 }]
                    },
                    {
                        name: 'scale',
                        children: [
                            { name: 'IScaleMap', value: 2105 },
                            { name: 'LinearScale', value: 1316 },
                            { name: 'LogScale', value: 3151 },
                            { name: 'OrdinalScale', value: 3770 },
                            { name: 'QuantileScale', value: 2435 },
                            { name: 'QuantitativeScale', value: 4839 },
                            { name: 'RootScale', value: 1756 },
                            { name: 'Scale', value: 4268 },
                            { name: 'ScaleType', value: 1821 },
                            { name: 'TimeScale', value: 5833 }
                        ]
                    },
                    {
                        name: 'display',
                        children: [{ name: 'DirtySprite', value: 8833 }]
                    }
                ]
            }
            // 配置图表
            var option = {
                tooltip: {
                    trigger: 'item',
                    triggerOn: 'mousemove'
                },
                legend: {
                    top: '2%',
                    left: '3%',
                    orient: 'vertical',
                    data: [
                        {
                            name: 'tree1',
                            icon: 'rectangle'
                        },
                        {
                            name: 'tree2',
                            icon: 'rectangle'
                        }
                    ],
                    borderColor: '#c23531'
                },
                series: [
                    {
                        type: 'tree',
                        name: 'tree1',
                        data: [data],
                        top: '5%',
                        left: '7%',
                        bottom: '2%',
                        right: '60%',
                        symbolSize: 7,
                        label: {
                            position: 'left',
                            verticalAlign: 'middle',
                            align: 'right'
                        },
                        leaves: {
                            label: {
                                position: 'right',
                                verticalAlign: 'middle',
                                align: 'left'
                            }
                        },
                        emphasis: {
                            focus: 'descendant'
                        },
                        expandAndCollapse: true,
                        animationDuration: 550,
                        animationDurationUpdate: 750
                    },
                    {
                        type: 'tree',
                        name: 'tree2',
                        data: [data2],
                        top: '20%',
                        left: '60%',
                        bottom: '22%',
                        right: '18%',
                        symbolSize: 7,
                        label: {
                            position: 'left',
                            verticalAlign: 'middle',
                            align: 'right'
                        },
                        leaves: {
                            label: {
                                position: 'right',
                                verticalAlign: 'middle',
                                align: 'left'
                            }
                        },
                        expandAndCollapse: true,
                        emphasis: {
                            focus: 'descendant'
                        },
                        animationDuration: 550,
                        animationDurationUpdate: 750
                    }
                ]
            }
            chartUni.setOption(option)
        },
        handleUpdate(formName) {
            this.pageLogin('E')
            formName.enterpriseID = this.enterpriseID
            axios({
                method: 'post',
                url: '/queryInfo/insert/personal',
                data: formName
            }).then(response => {
                this.$notify({
                    title: response.data.code,
                    message: response.data.msg,
                    type: response.data.data,
                    duration: 6500
                })
            }).catch(error => {
                this.$notify({
                    message: error.message,
                    duration: 6500
                })
                console.log(error)
            })
        },
        handleResetForm(formName) {
            this.$refs[formName].resetFields()
        },
        handleCheckAllBasic(val) {
            this.basicCheckedAuthorities = val ? basicAuthority : []
            this.isIndeterminate = false
        },
        handleCheckAllBasicUni(val) {
            this.basicCheckedAuthoritiesUni = val ? basicAuthority : []
            this.isIndeterminate = false
        },
        handleCheckedBasicChange(value) {
            let checkedCount1 = value.length
            this.checkAll = checkedCount1 === this.basicAuthorities.length
            this.isIndeterminate = checkedCount1 > 0 && checkedCount1 < this.basicAuthorities.length
        },
        handleCheckedBasicChangeUni(value) {
            let checkedCount1 = value.length
            this.checkAll = checkedCount1 === this.basicAuthorities.length
            this.isIndeterminate = checkedCount1 > 0 && checkedCount1 < this.basicAuthoritiesUni.length
        },
        handleCheckAllAdvance(val) {
            this.advanceCheckedAuthorities = val ? advanceAuthority : []
            this.isIndeterminate = false
        },
        handleCheckAllAdvanceUni(val) {
            this.advanceCheckedAuthoritiesUni = val ? advanceAuthority : []
            this.isIndeterminate = false
        },
        handleCheckedAdvanceChange(value) {
            let checkedCount2 = value.length
            this.checkAll = checkedCount2 === this.advanceAuthorities.length
            this.isIndeterminate = checkedCount2 > 0 && checkedCount2 < this.advanceAuthorities.length
        },
        handleCheckedAdvanceChangeUni(value) {
            let checkedCount2 = value.length
            this.checkAll = checkedCount2 === this.advanceAuthoritiesUni.length
            this.isIndeterminate = checkedCount2 > 0 && checkedCount2 < this.advanceAuthoritiesUni.length
        },
        deleteRow(index, rows) {
            rows.splice(index, 1)
        },
        handleApplication(val) {
            this.pageDialogTitle = val
            this.dialogVisibleUni = true
        },
        handleClose(done) {
            this.$confirm('确认关闭？')
                .then(function() {
                    done()
                })
                .catch(function() {

                })
        },
        handleGetName(val) {
            if (val == '') {
                return '输入后即可自动查询'
            }
            return this.pageEmployeeForm.userRealName = val
        },
        handleConsole(val) {
            console.log(val)
        },
        handleDeptInfoValue(val) {
            this.pageDeptInfo = this.pageTemporaryTransfer.find(item => {
                return item.name = val
            })
        }
    }
}
</script>
<style>
.hover {
    cursor: pointer;
}
.el-select .el-input__inner {
    height: 26px;
    padding: 0 6px;
}
.el-input .el-input__inner {
    height: 26px;
    padding: 0 6px;
}
.el-input .el-input__icon {
    padding: 0 0 0 90px;
}
</style>
