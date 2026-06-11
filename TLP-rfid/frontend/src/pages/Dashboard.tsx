// src/pages/Dashboard.tsx
import { Package, Truck, TrendingUp, AlertTriangle, Clock } from 'lucide-react'
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, BarChart, Bar } from 'recharts'

const movementData = [
  { hour: '08h', count: 124 },
  { hour: '09h', count: 198 },
  { hour: '10h', count: 245 },
  { hour: '11h', count: 312 },
  { hour: '12h', count: 278 },
  { hour: '13h', count: 189 },
  { hour: '14h', count: 256 },
]

const stockData = [
  { name: 'Zona A', stock: 1240 },
  { name: 'Zona B', stock: 980 },
  { name: 'Zona C', stock: 1450 },
  { name: 'Zona D', stock: 760 },
]

export default function Dashboard() {
  return (
    <div className="space-y-8">
      <div>
        <h1 className="text-3xl font-bold text-gray-900">Dashboard</h1>
        <p className="text-gray-600">Visão geral em tempo real • Triminds Logistics Platform</p>
      </div>

      {/* KPI Cards */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 hover:shadow-md transition-shadow">
          <div className="flex justify-between items-start">
            <div>
              <p className="text-sm text-gray-500">Itens Rastreados</p>
              <p className="text-4xl font-bold text-gray-900 mt-3">24,892</p>
            </div>
            <Package className="w-12 h-12 text-blue-600" />
          </div>
          <p className="text-emerald-600 text-sm flex items-center gap-1 mt-4">
            ↑ 12.4% <span className="text-gray-400">desde ontem</span>
          </p>
        </div>

        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 hover:shadow-md transition-shadow">
          <div className="flex justify-between items-start">
            <div>
              <p className="text-sm text-gray-500">Movimentações Hoje</p>
              <p className="text-4xl font-bold text-gray-900 mt-3">1,458</p>
            </div>
            <Truck className="w-12 h-12 text-emerald-600" />
          </div>
          <p className="text-emerald-600 text-sm flex items-center gap-1 mt-4">
            ↑ 8.7% <span className="text-gray-400">desde ontem</span>
          </p>
        </div>

        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 hover:shadow-md transition-shadow">
          <div className="flex justify-between items-start">
            <div>
              <p className="text-sm text-gray-500">Precisão RFID</p>
              <p className="text-4xl font-bold text-gray-900 mt-3">98.7%</p>
            </div>
            <TrendingUp className="w-12 h-12 text-violet-600" />
          </div>
          <p className="text-emerald-600 text-sm mt-4">+0.3% esta semana</p>
        </div>

        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100 hover:shadow-md transition-shadow">
          <div className="flex justify-between items-start">
            <div>
              <p className="text-sm text-gray-500">Alertas Ativos</p>
              <p className="text-4xl font-bold text-amber-600 mt-3">7</p>
            </div>
            <AlertTriangle className="w-12 h-12 text-amber-600" />
          </div>
          <p className="text-red-600 text-sm mt-4">2 críticos • 5 atenção</p>
        </div>
      </div>

      {/* Gráficos */}
      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {/* Movimentações por Hora */}
        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100">
          <div className="flex items-center justify-between mb-6">
            <h3 className="font-semibold text-lg">Movimentações por Hora</h3>
            <Clock className="text-gray-400" />
          </div>
          <ResponsiveContainer width="100%" height={320}>
            <LineChart data={movementData}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="hour" />
              <YAxis />
              <Tooltip />
              <Line type="natural" dataKey="count" stroke="#3b82f6" strokeWidth={3} dot={{ r: 5 }} />
            </LineChart>
          </ResponsiveContainer>
        </div>

        {/* Estoque por Zona */}
        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100">
          <h3 className="font-semibold text-lg mb-6">Estoque por Zona do Armazém</h3>
          <ResponsiveContainer width="100%" height={320}>
            <BarChart data={stockData}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="name" />
              <YAxis />
              <Tooltip />
              <Bar dataKey="stock" fill="#6366f1" radius={8} />
            </BarChart>
          </ResponsiveContainer>
        </div>
      </div>
    </div>
  )
}