<template>
    <div class="app-container">
        <!-- 搜索栏 -->
        <el-form :inline="true" :model="searchForm" class="search-form">
            <el-form-item label="姓名">
                <el-input v-model="searchForm.name" placeholder="请输入姓名" clearable />
            </el-form-item>
            <el-form-item label="手机号">
                <el-input v-model="searchForm.phone" placeholder="请输入手机号" clearable />
            </el-form-item>
            <el-form-item label="状态">
                <el-select v-model="searchForm.status" placeholder="请选择状态" clearable>
                    <el-option
                            v-for="item in statusOptions"
                            :key="item.value"
                            :label="item.label"
                            :value="item.value"
                    />
                </el-select>
            </el-form-item>
            <el-button type="primary" @click="loadData">查询</el-button>
        </el-form>

        <!-- 操作按钮 -->
        <div class="operation-buttons">
            <el-button type="primary" @click="handleCreate">新增候选人</el-button>
        </div>

        <!-- 数据表格 -->
        <el-table :data="tableData" border stripe style="width: 100%">
            <el-table-column prop="name" label="姓名" width="120" />
            <el-table-column prop="age" label="年龄" width="80" />
            <el-table-column prop="idNumber" label="身份证号" width="180" />
            <el-table-column prop="university" label="毕业院校" width="180" />
            <el-table-column prop="targetPosition" label="目标岗位" width="120" />
            <el-table-column prop="recommender" label="拓源人" width="120" />
            <el-table-column prop="phone" label="手机号" width="130" />
            <el-table-column prop="wechat" label="微信号" width="130" />
            <el-table-column prop="status" label="状态" width="150">
                <template #default="{row}">
                    <el-select
                            v-model="row.status"
                            @change="handleStatusChange(row)"
                            placeholder="选择状态"
                    >
                        <el-option
                                v-for="item in statusOptions"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value"
                        />
                    </el-select>
                </template>
            </el-table-column>
            <el-table-column prop="remark" label="备注" />
            <el-table-column prop="createTime" label="创建时间" width="180" />
            <el-table-column label="操作" width="180" fixed="right">
                <template #default="{row}">
                    <el-button size="small" @click="handleEdit(row)">编辑</el-button>
                    <el-button
                            size="small"
                            type="danger"
                            @click="handleDelete(row.id)"
                    >删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 新增/编辑对话框 -->
        <el-dialog
                v-model="dialogVisible"
                :title="dialogType === 'create' ? '新增候选人' : '编辑候选人'"
                width="600px"
        >
            <el-form
                    ref="formRef"
                    :model="formData"
                    :rules="formRules"
                    label-width="100px"
            >
                <el-form-item label="姓名" prop="name">
                    <el-input v-model="formData.name" />
                </el-form-item>
                <el-form-item label="年龄" prop="age">
                    <el-input-number v-model="formData.age" :min="18" :max="60" />
                </el-form-item>
                <el-form-item label="身份证号" prop="idNumber">
                    <el-input v-model="formData.idNumber" />
                </el-form-item>
                <el-form-item label="毕业院校" prop="university">
                    <el-input v-model="formData.university" />
                </el-form-item>
                <el-form-item label="目标岗位" prop="targetPosition">
                    <el-input v-model="formData.targetPosition" />
                </el-form-item>
                <el-form-item label="拓源人" prop="recommender">
                    <el-input v-model="formData.recommender" />
                </el-form-item>
                <el-form-item label="手机号" prop="phone">
                    <el-input v-model="formData.phone" />
                </el-form-item>
                <el-form-item label="微信号" prop="wechat">
                    <el-input v-model="formData.wechat" />
                </el-form-item>
                <el-form-item label="状态" prop="status">
                    <el-select v-model="formData.status" placeholder="请选择状态">
                        <el-option
                                v-for="item in statusOptions"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value"
                        />
                    </el-select>
                </el-form-item>
                <el-form-item label="备注" prop="remark">
                    <el-input v-model="formData.remark" type="textarea" :rows="3" />
                </el-form-item>
            </el-form>
            <template #footer>
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click="submitForm">确认</el-button>
            </template>
        </el-dialog>
    </div>
</template>

<script setup>
import { ref, reactive, onMounted } from 'vue'
import candidateApi from '@/api/candidate'

// 状态选项（需要与后端枚举值匹配）
const statusOptions = [
    { value: 'LOCKED', label: '锁定简历' },
    { value: 'SEND_TEST', label: '发送机试' },
    // ...其他状态选项
]

// 表格数据
const tableData = ref([])
const searchForm = reactive({
    name: '',
    phone: '',
    status: ''
})

// 对话框相关
const dialogVisible = ref(false)
const dialogType = ref('create')
const formData = reactive({
    id: null,
    name: '',
    age: null,
    idNumber: '',
    university: '',
    targetPosition: '',
    recommender: '',
    phone: '',
    wechat: '',
    status: '',
    remark: ''
})

// 表单验证规则
const formRules = reactive({
    name: [{ required: true, message: '请输入姓名', trigger: 'blur' }],
    age: [{ required: true, message: '请输入年龄', trigger: 'blur' }],
    idNumber: [
        { required: true, message: '请输入身份证号', trigger: 'blur' },
        { pattern: /^\d{17}[\dXx]$/, message: '身份证格式不正确' }
    ],
    phone: [
        { required: true, message: '请输入手机号', trigger: 'blur' },
        { pattern: /^1[3-9]\d{9}$/, message: '手机号格式不正确' }
    ]
})

// 加载数据
const loadData = async () => {
    try {
        const res = await candidateApi.getList(searchForm)
        tableData.value = res.data.pageList
    } catch (error) {
        console.error('加载数据失败:', error)
    }
}

// 打开创建对话框
const handleCreate = () => {
    dialogType.value = 'create'
    Object.keys(formData).forEach(key => {
        if (key === 'id') {
            formData[key] = null
        } else {
            formData[key] = ''
        }
    })
    dialogVisible.value = true
}

// 打开编辑对话框
const handleEdit = (row) => {
    dialogType.value = 'edit'
    Object.assign(formData, row)
    dialogVisible.value = true
}

// 提交表单
const submitForm = async () => {
    try {
        if (dialogType.value === 'create') {
            await candidateApi.create(formData)
        } else {
            await candidateApi.update(formData)
        }
        dialogVisible.value = false
        loadData()
    } catch (error) {
        console.error('提交失败:', error)
    }
}

// 删除操作
const handleDelete = async (id) => {
    try {
        await ElMessageBox.confirm('确认删除该候选人？', '警告', {
            confirmButtonText: '确认',
            cancelButtonText: '取消',
            type: 'warning'
        })
        await candidateApi.delete(id)
        loadData()
    } catch (error) {
        console.log('取消删除')
    }
}

// 状态变更
const handleStatusChange = async (row) => {
    try {
        await candidateApi.update(row)
        ElMessage.success('状态更新成功')
    } catch (error) {
        console.error('状态更新失败:', error)
    }
}

// 初始化加载数据
onMounted(() => {
    loadData()
})
</script>

<style scoped>
.app-container {
    padding: 20px;
}
.search-form {
    margin-bottom: 20px;
}
.operation-buttons {
    margin-bottom: 20px;
}
</style>