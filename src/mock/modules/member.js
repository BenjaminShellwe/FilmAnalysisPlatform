module.exports = [
    {
        url: 'member/login',
        type: 'post',
        result: option => {
            return {
                error: '',
                status: 1,
                data: {
                    account: option.body.account,
                    token: '@string',
                    id: option.body.id,
                    failure_time: Date.parse(new Date()) / 1000 + 24 * 60 * 60
                }
            }
        }
    },
    {
        url: 'member/permission',
        type: 'get',
        result: option => {
            let permissions = []
            if (option.query.account == 'admin') {
                permissions = [
                    'permission.browse',
                    'permission.basic',
                    'permission.create',
                    'permission.edit',
                    'permission.remove',
                    'permission.access',
                    'permission.department'
                ]
            } else if (option.query.account == 'employeeTPT') {
                permissions = [
                    'permission.basic',
                    'permission.access'
                ]
            } else if (option.query.account == 'visitor') {
                permissions = [
                    'permission.basic'
                ]
            }
            return {
                error: '',
                status: 1,
                data: {
                    permissions
                }
            }
        }
    }
]
