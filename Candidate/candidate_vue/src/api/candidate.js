import axios from 'axios'

const api = axios.create({
    baseURL: import.meta.env.VITE_API_BASE_URL,
    timeout: 10000
})

export default {
    // 获取候选人列表
    getList(params) {
        return api.post('/candidate/pageList', params)
    },

    // 新增候选人
    create(data) {
        return api.post('/candidate/insert', data)
    },

    // 更新候选人
    update(data) {
        return api.post('/candidate/update', data)
    },

    // 删除候选人
    delete(id) {
        return api.post('http://localhost:8091/api/candidate/delete', { id })
    }
}