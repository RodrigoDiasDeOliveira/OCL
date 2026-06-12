// TLP-rfid/frontend/vite.config.ts
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [react()],
  server: {
    host: true,        // Importante para Codespaces
    port: 5173,
  },
  resolve: {
    alias: {
      '@': '/src',
    },
  },
})