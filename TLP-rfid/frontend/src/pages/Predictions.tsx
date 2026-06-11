// src/pages/Predictions.tsx
import { TrendingUp, AlertTriangle, Calendar } from 'lucide-react'
import { LineChart, Line, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer } from 'recharts'

const predictionData = [
  { day: 'Seg', current: 1240, predicted: 1320 },
  { day: 'Ter', current: 980, predicted: 1050 },
  { day: 'Qua', current: 1450, predicted: 1380 },
  { day: 'Qui', current: 760, predicted: 920 },
  { day: 'Sex', current: 1120, predicted: 1180 },
]

export default function Predictions() {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold text-gray-900">AI Predictions</h1>
        <p className="text-gray-600">Previsões inteligentes baseadas em RFID + IA</p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-3 gap-6">
        {/* Card de Previsão Geral */}
        <div className="lg:col-span-2 bg-white p-6 rounded-2xl shadow-sm border">
          <h3 className="font-semibold mb-6 flex items-center gap-2">
            <TrendingUp /> Previsão de Demanda - Próximos 7 Dias
          </h3>
          <ResponsiveContainer width="100%" height={380}>
            <LineChart data={predictionData}>
              <CartesianGrid strokeDasharray="3 3" />
              <XAxis dataKey="day" />
              <YAxis />
              <Tooltip />
              <Line type="monotone" dataKey="current" stroke="#64748b" strokeWidth={2} name="Atual" />
              <Line type="monotone" dataKey="predicted" stroke="#3b82f6" strokeWidth={3} name="Previsto pela IA" />
            </LineChart>
          </ResponsiveContainer>
        </div>

        {/* Alertas de Previsão */}
        <div className="bg-white p-6 rounded-2xl shadow-sm border">
          <h3 className="font-semibold mb-4 flex items-center gap-2 text-amber-600">
            <AlertTriangle /> Alertas de Estoque
          </h3>
          <div className="space-y-4">
            <div className="p-4 bg-amber-50 rounded-xl">
              <p className="font-medium">Monitor Samsung 27"</p>
              <p className="text-sm text-amber-600">Estoque baixo previsto em 3 dias</p>
            </div>
            <div className="p-4 bg-red-50 rounded-xl">
              <p className="font-medium">Caixa de Ferramentas</p>
              <p className="text-sm text-red-600">Risco de ruptura em 48h</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}