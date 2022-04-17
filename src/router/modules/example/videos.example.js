import Layout from '@/layout'

export default [
    {
        path: '/other_example/1',
        component: Layout,
        meta: {
            title: '01 - 开发环境配置'
        },
        children: [
            {
                path: '',
                name: 'videosExampleVideo1',
                component: () => import(/* webpackChunkName: 'other_example' */ '@/views/extra_functions/example_other/1'),
                meta: {
                    title: '01 - 开发环境配置',
                    sidebar: false,
                    breadcrumb: false,
                    activeMenu: '/other_example/1'
                }
            }
        ]
    }
]
