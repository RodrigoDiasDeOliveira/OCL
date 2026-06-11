// src/pages/Analytics.tsx
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, PieChart, Pie, Cell } from 'recharts'
import { TrendingUp, Clock, Target, Award } from 'lucide-react'

const performanceData = [
  { month: 'Jan', accuracy: 94.2, efficiency: 87 },
  { month: 'Fev', accuracy: 95.1, efficiency: 89 },
  { month: 'Mar', accuracy: 96.8, efficiency: 92 },
  { month: 'Abr', accuracy: 97.3, efficiency: 94 },
  { month: 'Mai', accuracy: 98.1, efficiency: 95 },
  { month: 'Jun', accuracy: 98.7, efficiency: 96 },
]

const zoneData = [
  { name: 'Zona A', value: 35, color: '#3b82f6' },
  { name: 'Zona B', value: 28, color: '#6366f1' },
  { name: 'Zona C', value: 22, color: '#8b5cf6' },
  { name: 'Zona D', value: 15, color: '#ec4899' },
]

const kpis = [
  { label: 'Precisão Geral', value: '98.7%', change: '+2.1%', color: 'text-emerald-600' },
  { label: 'Tempo Médio de Localização', value: '4.2s', change: '-0.8s', color: 'text-emerald-600' },
  { label: 'Taxa de Ocupação', value: '87%', change: '+5%', color: 'text-emerald-600' },
  { label: 'Gargalos Identificados', value: '3', change: '-2', color: 'text-amber-600' },
]

export default function Analytics() {
  return (
    <div className="space-y-8">
      <div>
        <h1 className="text-3xl font-bold text-gray-900">Analytics & Insights</h1>
        <p className="text-gray-600">Inteligência de dados e performance da operação</p>
      </div>

      {/* KPI Cards */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
        {kpis.map((kpi, index) => (
          <div key={index} className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100">
            <p className="text-sm text-gray-500">{kpi.label}</p>
            <p className="text-4xl font-bold text-gray-900 mt-3">{kpi.value}</p>
            <p className={`text-sm mt-2 ${kpi.color}`}>{kpi.change} desde o mês anterior</p>
          </div>
        ))}
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
        {/* Performance Over Time */}
        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100">
          <div className="flex items-center justify-between mb-6">
            <h3 className="font-semibold text-lg flex items-center gap-2">
              <TrendingUp className="text-blue-600" /> Precisão RFID ao Longo do Tempo
            </h3>
          </div>
          <ResponsiveContainer width="100%" height={360}>
            <BarChart data={performanceData}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="month" />
              <YAxis />
              <Tooltip />
              <Bar dataKey="accuracy" fill="#3b82f6" radius={8} />
              <Bar dataKey="efficiency" fill="#6366f1" radius={8} />
            </BarChart>
          </ResponsiveContainer>
        </div>

        {/* Distribution by Zone */}
        <div className="bg-white p-6 rounded-2xl shadow-sm border border-gray-100">
          <h3 className="font-semibold text-lg mb-6">Distribuição de Movimentações por Zona</h3>
          <div className="flex flex-col lg:flex-row items-center gap-8">
            <div className="flex-1">
              <ResponsiveContainer width="100%" height={300}>
                <PieChart>
                  <Pie
                    data={zoneData}
                    cx="50%"
                    cy="50%"
                    innerRadius={70}
                    outerRadius={110}
                    dataKey="value"
                  >
                    {zoneData.map((entry, index) => (
                      <Cell key={`cell-${index}`} fill={entry.color} />
                    ))}
                  </Pie>
                  <Tooltip />
                </PieChart>
              </ResponsiveContainer>
            </div>

            <div className="flex-1 space-y-4">
              {zoneData.map((zone, index) => (
                <div key={index} className="flex items-center justify-between">
                  <div className="flex items-center gap-3">
                    <div className="w-4 h-4 rounded" style={{ backgroundColor: zone.color }}></div>
                    <span className="font-medium">{zone.name}</span>
                  </div>
                  <span className="font-semibold">{zone.value}%</span>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>

      {/* Insights & Recommendations */}
      <div className="bg-white p-8 rounded-2xl shadow-sm border border-gray-100">
        <h3 className="font-semibold text-xl mb-6 flex items-center gap-2">
          <Award className="text-amber-600" /> Principais Insights da IA
        </h3>
        <div className="grid md:grid-cols-2 gap-6">
          <div className="border-l-4 border-blue-600 pl-6">
            <p className="font-medium">Otimização Recomendada</p>
            <p className="text-gray-600 mt-2">
              Realocar 18% dos itens da Zona D para Zona A pode aumentar a eficiência em até 14%.
            </p>
          </div>
          <div className="border-l-4 border-amber-600 pl-6">
            <p className="font-medium">Alerta de Gargalo</p>
            <p className="text-gray-600 mt-2">
              Dock 03 está com 92% de utilização nas últimas 48h. Recomendado abrir Dock 04.
            </p>
          </div>
        </div>
      </div>
    </div>
  )
}