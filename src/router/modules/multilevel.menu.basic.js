import Layout from '@/layout'
import EmptyLayout from '@/layout/empty'
// still under construction

export default {
    path: '/multilevel_menu_basic',
    component: Layout,
    redirect: '/multilevel_menu_basic/overview',
    name: 'multilevelMenuBasic',
    meta: {
        title: '功能菜单',
        icon: 'sidebar-menu',
        auth: ['permission.basic']
    },
    children: [
        {
            path: 'overview',
            name: 'InformationChartOverview',
            component: () => import('@/views/index'),
            redirect: '',
            meta: {
                title: '信息总览',
                sidebar: false,
                breadcrumb: false
            }
        },
        {
            path: 'management',
            name: 'SystemFeaturesManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/management/global_dic',
            meta: {
                title: '功能管理'
            },
            children: [
                {
                    path: 'global_dic',
                    name: 'Dictionary_G',
                    component: () => import('@/views/basic_functions/global_func_manage/data_dic/global_dic'),
                    meta: {
                        title: '数据字典',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'personal_dic',
                    name: 'Dictionary_P',
                    component: () => import('@/views/basic_functions/global_func_manage/data_dic/personal_dic'),
                    meta: {
                        title: '个人字典',
                        sidebar: false,
                        breadcrumb: false,
                        auth: ['permission.access', 'permission.edit']
                    }
                },
                {
                    path: 'notice',
                    name: 'Notification',
                    component: () => import('@/views/basic_functions/global_func_manage/message/global_message'),
                    meta: {
                        title: '系统通知',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'basic',
                    name: 'Basic',
                    component: () => import('@/views/basic_functions/global_func_manage/basic_settings/basic'),
                    meta: {
                        title: '基础设置',
                        sidebar: true,
                        breadcrumb: true
                    }
                }
            ]
        },
        {
            path: 'account_management',
            name: 'AccountContentManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/account_management/personal',
            meta: {
                title: '内容管理',
                sidebar: true,
                breadcrumb: true
            },
            children: [
                {
                    path: 'personal',
                    name: 'Personal',
                    component: () => import('@/views/basic_functions/account_management/personal/setting'),
                    meta: {
                        title: '个人设置',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'enterprises',
                    name: 'Enterprises',
                    component: () => import('@/views/basic_functions/account_management/enterprises/enterprises'),
                    meta: {
                        title: '企业账户',
                        sidebar: true,
                        breadcrumb: true,
                        auth: ['permission.access']
                    }
                },
                {
                    path: 'security',
                    name: 'Security',
                    component: () => import('@/views/basic_functions/account_management/security/security'),
                    meta: {
                        title: '安全设置',
                        sidebar: true,
                        breadcrumb: true,
                        auth: ['permission.edit']

                    }
                }
            ]
        },
        {
            path: 'monitor_manage',
            name: 'MonitoringManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/monitor_manage/log',
            meta: {
                title: '数据管理'
            },
            children: [
                {
                    path: 'log',
                    name: 'Logging',
                    component: () => import('@/views/basic_functions/monitor_manage/log/log'),
                    meta: {
                        title: '系统日志',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'monitor',
                    name: 'Monitoring',
                    component: () => import('@/views/basic_functions/monitor_manage/monitor/monitor'),
                    meta: {
                        title: '监控设置',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'statistic',
                    name: 'Statistics',
                    component: () => import('@/views/basic_functions/monitor_manage/statistic/statistic'),
                    meta: {
                        title: '数据统计',
                        sidebar: true,
                        breadcrumb: true
                    }
                }
            ]
        }
    ]
}
