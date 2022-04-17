// 请不要直接使用本页代码 本页代码为备份保留
import Layout from '@/layout'
import EmptyLayout from '@/layout/empty'

export default {
    path: '/multilevel_menu_basic',
    component: Layout,
    redirect: '/multilevel_menu_basic/page',
    name: 'multilevelMenuBasic',
    meta: {
        title: '基础功能/still under construction',
        icon: 'sidebar-menu'
    },
    children: [
        {
            path: 'page',
            name: 'multilevelMenuExample1',
            component: () => import('@/views/extra_functions/multilevel_menu/foundation/foundation_sub/bankAccountManagement'),
            meta: {
                title: '银行账户管理'
            }
        },
        {
            path: 'foundation',
            name: 'multilevelMenuExample2',
            component: EmptyLayout,
            redirect: '/multilevel_menu_basic/foundation/page',
            meta: {
                title: '用户账号管理'
            },
            children: [
                {
                    path: 'page',
                    name: 'multilevelMenuExample2-1',
                    component: () => import('@/views/basic_functions/account_management/personal/setting'),
                    meta: {
                        title: '个人设置'
                    }
                },
                {
                    path: 'foundation_sub',
                    name: 'multilevelMenuExample2-2',
                    component: EmptyLayout,
                    redirect: '/multilevel_menu_basic/foundation/foundation_sub',
                    meta: {
                        title: '高级设置'
                    },
                    children: [
                        {
                            path: 'page1',
                            name: 'advancedAlert',
                            component: () => import('@/views/extra_functions/multilevel_menu/foundation/foundation_sub/advancedAlert'),
                            meta: {
                                title: '特殊访问说明'
                            }
                        },
                        {
                            path: 'page2',
                            name: 'advancedSetting',
                            component: () => import('@/views/extra_functions/multilevel_menu/foundation/foundation_sub/advancedSetting'),
                            meta: {
                                title: '高级用户管理'
                            }
                        },
                        {
                            path: 'page3',
                            name: 'forTest',
                            component: () => import('@/views/extra_functions/multilevel_menu/foundation/serial/serial.vue'),
                            meta: {
                                title: '流水测试入口(T)'
                            }
                        },
                        {
                            path: 'page5',
                            name: 'forTest1',
                            component: () => import('@/views/extra_functions/multilevel_menu/foundation/serial/advancedFunc.vue'),
                            meta: {
                                title: '测试入口(T)'
                            }
                        }
                    ]
                }
            ]
        },
        {
            path: 'dept',
            name: 'deptFunction',
            component: () => import('@/views/extra_functions/multilevel_menu/dept'),
            meta: {
                title: '归属部门管理'
            }

        }
    ]
}
