import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import path from 'path'
export default defineConfig({
    plugins: [vue()],
    resolve: {
        alias: {
            '@': path.resolve(__dirname, 'src')
        }
    },
    server: {
        server: {
            port: 5175
        },
        proxy: {
            '/candidate': {
                target: 'http://localhost:8091',
                changeOrigin: true
            }
        }
    }
})