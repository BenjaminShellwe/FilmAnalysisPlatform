import Layout from '@/layout'
import EmptyLayout from '@/layout/empty'
import KeepAliveExample from './example/keep.alive.example'
import ComponentBasicExample from './example/component.basic.example'
import ComponentExtendExample from './example/component.extend.example'
import PermissionExample from './example/permission.example'
import MockExample from './example/mock.example'

export default {
    path: '/multilevel_menu_advanced',
    component: Layout,
    redirect: '/multilevel_menu_advanced',
    name: 'breadcrumbExample',
    meta: {
        title: '测试功能',
        icon: 'test-tube',
        sidebar: false,
        breadcrumb: false
    },
    children: [
        {
            path: 'chat',
            name: 'ChatRoom',
            component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/basic_functions/global_func_manage/chat/chat'),
            meta: {
                title: '即时通信',
                sidebar: false,
                breadcrumb: false,
                auth: ['permission.access', 'permission.edit']
            }
        },
        {
            path: 'message',
            name: 'Message',
            component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/basic_functions/global_func_manage/message/message'),
            meta: {
                title: '站内通知',
                sidebar: false,
                breadcrumb: false
            }
        },
        {
            path: 'list',
            name: 'List',
            component: EmptyLayout,
            redirect: '/multilevel_menu_advanced/list',
            meta: {
                title: '列表样式',
                icon: 'bullet-list'
            },
            children: [
                {
                    path: 'list1',
                    name: 'ExampleList1',
                    component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/extra_functions/example/breadcrumb_example/list1'),
                    meta: {
                        title: '列表1（平级模式）'
                    }
                },
                {
                    path: 'detail1',
                    name: 'ExampleDetail1',
                    component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/extra_functions/example/breadcrumb_example/detail1'),
                    meta: {
                        title: '详情1',
                        sidebar: false,
                        activeMenu: 'multilevel_menu_advanced/list/list1'
                    }
                },
                {
                    path: 'list2',
                    name: 'ExampleList2',
                    component: EmptyLayout,
                    redirect: 'multilevel_menu_advanced/list/list2',
                    meta: {
                        title: '列表2（层级模式）'
                    },
                    children: [
                        {
                            path: '',
                            component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/extra_functions/example/breadcrumb_example/list2'),
                            meta: {
                                title: '列表2（层级模式）',
                                sidebar: false,
                                breadcrumb: false
                            }
                        },
                        {
                            path: 'detail2',
                            name: 'ExampleDetail2',
                            component: () => import(/* webpackChunkName: 'breadcrumb_example' */ '@/views/extra_functions/example/breadcrumb_example/detail2'),
                            meta: {
                                title: '详情2',
                                sidebar: false,
                                activeMenu: 'multilevel_menu_advanced/list/list2'
                            }
                        }
                    ]
                }
            ]
        },
        KeepAliveExample,
        ComponentBasicExample,
        ComponentExtendExample,
        PermissionExample,
        MockExample
    ]
}
