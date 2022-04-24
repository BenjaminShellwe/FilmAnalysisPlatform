<template>
    <el-table
        :data="tableData.filter(data => !search || data.id.toLowerCase().includes(search.toLowerCase()))"
        style="width: 100%;"
        border
    >
        <el-table-column
            v-for="(item, index) in pageTableHeader"
            :key="index"
            :prop="index"
            :label="item"
            :fit="true"
            sortable
            min-width="30px"
        />
        <el-table-column
            align="right"
            fixed="right"
            width="160px"
        >
            <template slot="header">
                <input
                    v-model="search"
                    size="mini"
                    placeholder="输入关键字搜索"
                    style="width: 135px;"
                >
            </template>
            <template slot-scope="scope">
                <el-button
                    size="mini"
                    @click="handleEdit(scope.$index, scope.row)"
                >
                    Edit
                </el-button>
                <el-button
                    size="mini"
                    type="danger"
                    @click="handleDelete(scope.$index, scope.row)"
                >
                    Delete
                </el-button>
            </template>
        </el-table-column>
    </el-table>
</template>

<script>
export default {
    data() {
        return {
            pageSearch: '',
            search: '',
            pageTableHeader: {
                id: '事务ID',
                name: '账户姓名',
                sex: '用户性别',
                phone: '电话号码',
                address: '记录地址',
                department: '所属部门',
                position: '所属职位',
                description: '基本描述',
                createdTime: '创建时间',
                estimatedTime: '到期时间',
                positionStatus: '职位状态',
                departmentStatus: '部门状态'
            },
            tableData: [
                {
                    id: '202202081942',
                    name: 'Sebastian',
                    sex: '男',
                    phone: '12300000000',
                    address: '法兰西普罗旺斯',
                    department: '教辅部门',
                    position: '声乐/乐器教辅导师',
                    description: '准备离职',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081943',
                    name: 'Jack',
                    sex: '男',
                    phone: '12300000000',
                    address: '法兰西普罗旺斯',
                    department: '软件部门',
                    position: '测试工程师',
                    description: '准备离职',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081944',
                    name: 'Rose',
                    sex: '女',
                    phone: '12300000000',
                    address: '法兰西普罗旺斯',
                    department: '人事部门',
                    position: '人事主管',
                    description: '准备离职',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081945',
                    position: '开发工程师',
                    positionStatus: '目前空缺',
                    department: '软件部门',
                    director: 'Steven',
                    phoneD: '17600000000',
                    manager: '00',
                    phoneM: '17600000000',
                    departmentStatus: 'full(已达部门标准人数)',
                    description: '梅赛德斯',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081946',
                    position: '辅导员',
                    positionStatus: '正在招聘',
                    department: '教辅部门',
                    director: 'Seven',
                    phoneD: '17600000000',
                    manager: '00',
                    phoneM: '17600000000',
                    departmentStatus: 'insufficiency(未达部门标准人数)',
                    description: '慕尼黑',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                },
                {
                    id: '202202081947',
                    position: '人事主管',
                    positionStatus: '暂停招聘',
                    department: '人事部门',
                    director: 'Seven',
                    phoneD: '17600000000',
                    manager: '00',
                    phoneM: '17600000000',
                    departmentStatus: 'overstaffed(已超部门最大人数)',
                    description: '柏林',
                    createdTime: '2022/02/08',
                    estimatedTime: '2022/03/08'
                }
            ]
        }
    },
    methods: {
        handleEdit(index, row) {
            console.log(index, row)
        },
        handleDelete(index, row) {
            console.log(index, row)
        },
        onInput() {
            this.$forceUpdate()
        }
    }
}
</script>
