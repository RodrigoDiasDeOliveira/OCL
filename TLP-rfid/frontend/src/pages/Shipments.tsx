// src/pages/Shipments.tsx
import { Truck, Clock } from 'lucide-react'

const shipments = [
  { id: 'SH-39481', destination: 'São Paulo - CD Distribuição', status: 'In Transit', eta: 'Hoje 18:45', items: 124, progress: 75 },
  { id: 'SH-39480', destination: 'Rio de Janeiro - Loja Centro', status: 'Preparing', eta: 'Amanhã 09:00', items: 87, progress: 30 },
  { id: 'SH-39479', destination: 'Belo Horizonte - Armazém', status: 'Delivered', eta: 'Ontem 14:20', items: 56, progress: 100 },
]

export default function Shipments() {
  return (
    <div className="space-y-6">
      <div>
        <h1 className="text-3xl font-bold text-gray-900">Shipments</h1>
        <p className="text-gray-600">Gestão e rastreamento de envios</p>
      </div>

      <div className="grid gap-6">
        {shipments.map((shipment) => (
          <div key={shipment.id} className="bg-white rounded-2xl p-6 shadow-sm border border-gray-100">
            <div className="flex justify-between items-start">
              <div>
                <p className="font-mono text-sm text-gray-500">{shipment.id}</p>
                <p className="text-lg font-semibold mt-1">{shipment.destination}</p>
              </div>
              <div className={`px-4 py-2 rounded-2xl text-sm font-medium
                ${shipment.status === 'Delivered' ? 'bg-emerald-100 text-emerald-700' : ''}
                ${shipment.status === 'In Transit' ? 'bg-blue-100 text-blue-700' : ''}
                ${shipment.status === 'Preparing' ? 'bg-amber-100 text-amber-700' : ''}
              `}>
                {shipment.status}
              </div>
            </div>

            <div className="mt-6">
              <div className="flex justify-between text-sm mb-2">
                <span>Progresso</span>
                <span>{shipment.progress}%</span>
              </div>
              <div className="h-2 bg-gray-100 rounded-full overflow-hidden">
                <div 
                  className="h-full bg-blue-600 rounded-full transition-all" 
                  style={{ width: `${shipment.progress}%` }}
                />
              </div>
            </div>

            <div className="grid grid-cols-3 gap-6 mt-8 text-sm">
              <div>
                <p className="text-gray-500">Itens</p>
                <p className="font-semibold">{shipment.items}</p>
              </div>
              <div>
                <p className="text-gray-500">ETA</p>
                <p className="font-semibold flex items-center gap-2">
                  <Clock size={16} /> {shipment.eta}
                </p>
              </div>
              <div>
                <button className="text-blue-600 hover:underline font-medium">Ver Detalhes →</button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  )
}