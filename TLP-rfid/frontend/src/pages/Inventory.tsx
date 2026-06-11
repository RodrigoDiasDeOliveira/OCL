// src/pages/Inventory.tsx
import { useState } from 'react'
import { Package, Search, AlertTriangle, Plus } from 'lucide-react'

interface InventoryItem {
  id: string
  name: string
  tagId: string
  location: string
  quantity: number
  status: 'In Stock' | 'Low Stock' | 'Out of Stock'
  lastRead: string
}

const mockInventory: InventoryItem[] = [
  { id: 'INV-78491', name: 'Notebook Dell XPS 15', tagId: 'RFID-78491', location: 'Zona A - Prateleira 12', quantity: 45, status: 'In Stock', lastRead: 'Há 2 min' },
  { id: 'INV-39284', name: 'Caixa de Ferramentas Profissional', tagId: 'RFID-39284', location: 'Zona B - Dock 03', quantity: 12, status: 'Low Stock', lastRead: 'Há 15 min' },
  { id: 'INV-11923', name: 'Monitor Samsung 27"', tagId: 'RFID-11923', location: 'Zona C - Corredor 05', quantity: 0, status: 'Out of Stock', lastRead: 'Há 1 hora' },
  { id: 'INV-55672', name: 'Teclado Mecânico Logitech', tagId: 'RFID-55672', location: 'Zona A - Prateleira 08', quantity: 78, status: 'In Stock', lastRead: 'Há 3 min' },
]

export default function Inventory() {
  const [items, setItems] = useState(mockInventory)
  const [searchTerm, setSearchTerm] = useState('')

  const filteredItems = items.filter(item =>
    item.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
    item.tagId.toLowerCase().includes(searchTerm.toLowerCase()) ||
    item.location.toLowerCase().includes(searchTerm.toLowerCase())
  )

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <div>
          <h1 className="text-3xl font-bold text-gray-900">Inventory</h1>
          <p className="text-gray-600">Controle de estoque com RFID</p>
        </div>
        <button className="flex items-center gap-2 bg-blue-600 text-white px-5 py-3 rounded-2xl hover:bg-blue-700">
          <Plus size={20} />
          Novo Item
        </button>
      </div>

      <div className="relative">
        <Search className="absolute left-4 top-4 text-gray-400" size={20} />
        <input
          type="text"
          placeholder="Buscar por nome, Tag ID ou localização..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
          className="w-full pl-12 pr-4 py-4 bg-white border border-gray-200 rounded-2xl focus:outline-none focus:border-blue-500"
        />
      </div>

      <div className="bg-white rounded-2xl shadow-sm border border-gray-100 overflow-hidden">
        <table className="w-full">
          <thead>
            <tr className="bg-gray-50 border-b">
              <th className="px-6 py-4 text-left">ITEM</th>
              <th className="px-6 py-4 text-left">TAG ID</th>
              <th className="px-6 py-4 text-left">LOCALIZAÇÃO</th>
              <th className="px-6 py-4 text-left">QUANTIDADE</th>
              <th className="px-6 py-4 text-left">STATUS</th>
              <th className="px-6 py-4 text-left">ÚLTIMA LEITURA</th>
            </tr>
          </thead>
          <tbody className="divide-y">
            {filteredItems.map((item) => (
              <tr key={item.id} className="hover:bg-gray-50">
                <td className="px-6 py-5 font-medium">{item.name}</td>
                <td className="px-6 py-5 font-mono text-sm">{item.tagId}</td>
                <td className="px-6 py-5 text-gray-600">{item.location}</td>
                <td className="px-6 py-5 font-semibold">{item.quantity}</td>
                <td className="px-6 py-5">
                  <span className={`px-4 py-1.5 rounded-full text-xs font-medium
                    ${item.status === 'In Stock' ? 'bg-emerald-100 text-emerald-700' : ''}
                    ${item.status === 'Low Stock' ? 'bg-amber-100 text-amber-700' : ''}
                    ${item.status === 'Out of Stock' ? 'bg-red-100 text-red-700' : ''}
                  `}>
                    {item.status}
                  </span>
                </td>
                <td className="px-6 py-5 text-sm text-gray-500">{item.lastRead}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}