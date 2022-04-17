import EmptyLayout from '@/layout/empty'

export default {
    path: '/mock_example',
    component: EmptyLayout,
    redirect: '/mock_example/index',
    name: 'mockExample',
    meta: {
        title: 'Mock',
        icon: 'sidebar-mock',
        badge: 'NEW',
        sidebar: false,
        breadcrumb: false
    },
    children: [
        {
            path: 'index',
            name: 'mockExampleIndex',
            component: () => import(/* webpackChunkName: 'mock_example' */ '@/views/extra_functions/example/mock_example'),
            meta: {
                title: 'Mock',
                sidebar: false,
                breadcrumb: false,
                activeMenu: '/mock_example'
            }
        }
    ]
}
