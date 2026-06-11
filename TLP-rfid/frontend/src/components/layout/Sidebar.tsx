// src/components/layout/Sidebar.tsx
import { NavLink } from 'react-router-dom'
import { 
  LayoutDashboard, 
  Tag, 
  Package, 
  Truck, 
  TrendingUp, 
  BarChart3 
} from 'lucide-react'

const menuItems = [
  { path: '/dashboard', icon: LayoutDashboard, label: 'Dashboard' },
  { path: '/rfid', icon: Tag, label: 'RFID Events' },
  { path: '/inventory', icon: Package, label: 'Inventory' },
  { path: '/shipments', icon: Truck, label: 'Shipments' },
  { path: '/predictions', icon: TrendingUp, label: 'Predictions' },
  { path: '/analytics', icon: BarChart3, label: 'Analytics' },
]

export default function Sidebar() {
  return (
    <div className="w-64 bg-white border-r border-gray-200 flex flex-col">
      <div className="p-6 border-b">
        <h1 className="text-2xl font-bold text-blue-600">Triminds</h1>
        <p className="text-sm text-gray-500">Logistics Platform</p>
      </div>

      <nav className="flex-1 p-4">
        {menuItems.map((item) => (
          <NavLink
            key={item.path}
            to={item.path}
            className={({ isActive }) =>
              `flex items-center gap-3 px-4 py-3 rounded-xl mb-1 transition-colors ${
                isActive 
                  ? 'bg-blue-50 text-blue-600 font-medium' 
                  : 'hover:bg-gray-100 text-gray-700'
              }`
            }
          >
            <item.icon size={20} />
            {item.label}
          </NavLink>
        ))}
      </nav>
    </div>
  )
}