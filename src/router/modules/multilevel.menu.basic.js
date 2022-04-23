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
            path: 'data_manage',
            name: 'DataManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/monitor_manage',
            meta: {
                title: '数据管理'
            },
            children: [
                {
                    path: 'source',
                    name: 'Source',
                    component: () => import('@/views/basic_functions/data_manage/source'),
                    meta: {
                        title: '数据来源',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'statistic',
                    name: 'Statistics',
                    component: () => import('@/views/basic_functions/data_manage/statistic'),
                    meta: {
                        title: '数据统计',
                        sidebar: false,
                        breadcrumb: false
                    }
                }
            ]
        },
        {
            path: 'function_manage',
            name: 'FunctionManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/management/global_dic',
            meta: {
                title: '功能管理'
            },
            children: [
                {
                    path: 'graphsettings',
                    name: 'Graphsettings',
                    component: () => import('@/views/basic_functions/function_manage/graphsettings'),
                    meta: {
                        title: '图表设置',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'basic',
                    name: 'Basic',
                    component: () => import('@/views/basic_functions/function_manage/basic'),
                    meta: {
                        title: '基础设置',
                        sidebar: true,
                        breadcrumb: true
                    }
                }
            ]
        },
        {
            path: 'substance_management',
            name: 'SubstanceManagement',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/account_management/substance_management',
            meta: {
                title: '内容管理',
                sidebar: true,
                breadcrumb: true
            },
            children: [
                {
                    path: 'graphic',
                    name: 'Graphic',
                    component: () => import('@/views/basic_functions/substance_management/graphic'),
                    meta: {
                        title: '图形数据',
                        sidebar: true,
                        breadcrumb: true
                    }
                },
                {
                    path: 'table',
                    name: 'Table',
                    component: () => import('@/views/basic_functions/substance_management/table'),
                    meta: {
                        title: '表格数据',
                        sidebar: true,
                        breadcrumb: true,
                        auth: ['permission.access']
                    }
                }
            ]
        }
    ]
}
