import EmptyLayout from '@/layout/empty'

export default {
    path: '/permission_example',
    component: EmptyLayout,
    redirect: '/permission_example/index',
    name: 'permissionExample',
    meta: {
        title: '权限验证',
        icon: 'sidebar-permission',
        sidebar: false,
        breadcrumb: false
    },
    children: [
        {
            path: 'index',
            name: 'permissionExampleIndex',
            component: () => import(/* webpackChunkName: 'permission_example' */ '@/views/extra_functions/example/permission_example'),
            meta: {
                title: '权限验证',
                auth: ['permission.browse'],
                sidebar: false,
                breadcrumb: false,
                activeMenu: '/permission_example'
            }
        }
    ]
}
