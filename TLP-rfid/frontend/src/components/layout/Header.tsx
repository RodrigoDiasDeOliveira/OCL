// src/components/layout/Header.tsx
import { Bell, User } from 'lucide-react'

export default function Header() {
  return (
    <header className="h-16 bg-white border-b flex items-center justify-between px-6">
      <div className="flex items-center gap-4">
        <h2 className="text-xl font-semibold text-gray-800">Welcome back, Rodrigo</h2>
      </div>

      <div className="flex items-center gap-4">
        <button className="p-2 hover:bg-gray-100 rounded-xl">
          <Bell size={20} />
        </button>
        <div className="flex items-center gap-3 pl-4 border-l">
          <div className="w-8 h-8 bg-blue-600 rounded-full flex items-center justify-center text-white font-medium">
            RD
          </div>
          <div>
            <p className="text-sm font-medium">Rodrigo Dias</p>
            <p className="text-xs text-gray-500 -mt-1">Admin</p>
          </div>
        </div>
      </div>
    </header>
  )
}