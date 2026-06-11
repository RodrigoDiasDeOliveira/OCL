// src/pages/RfidEvents.tsx
import { useState } from 'react'
import { Search, Filter, RefreshCw, Clock, Tag } from 'lucide-react'

interface RfidEvent {
  id: string
  timestamp: string
  tagId: string
  location: string
  action: string
  status: 'success' | 'warning' | 'error'
  item?: string
}

const mockEvents: RfidEvent[] = [
  { id: 'EVT-8921', timestamp: '2026-06-11 11:32:45', tagId: 'RFID-78491', location: 'Zona A - Prateleira 12', action: 'Entrada', status: 'success', item: 'Notebook Dell XPS' },
  { id: 'EVT-8920', timestamp: '2026-06-11 11:31:12', tagId: 'RFID-39284', location: 'Zona B - Dock 03', action: 'Saída', status: 'success', item: 'Caixa de Ferramentas' },
  { id: 'EVT-8919', timestamp: '2026-06-11 11:30:05', tagId: 'RFID-11923', location: 'Zona C - Corredor 05', action: 'Movimentação', status: 'warning', item: 'Monitor Samsung' },
  { id: 'EVT-8918', timestamp: '2026-06-11 11:28:47', tagId: 'RFID-78491', location: 'Zona A - Prateleira 12', action: 'Leitura', status: 'success' },
  { id: 'EVT-8917', timestamp: '2026-06-11 11:27:19', tagId: 'RFID-55672', location: 'Expedição', action: 'Saída', status: 'error', item: 'Produto Danificado' },
]

export default function RfidEvents() {
  const [events, setEvents] = useState(mockEvents)
  const [searchTerm, setSearchTerm] = useState('')
  const [filterStatus, setFilterStatus] = useState<'all' | 'success' | 'warning' | 'error'>('all')

  const filteredEvents = events.filter(event => {
    const matchesSearch = 
      event.tagId.toLowerCase().includes(searchTerm.toLowerCase()) ||
      event.location.toLowerCase().includes(searchTerm.toLowerCase()) ||
      (event.item && event.item.toLowerCase().includes(searchTerm.toLowerCase()))
    
    const matchesFilter = filterStatus === 'all' || event.status === filterStatus
    
    return matchesSearch && matchesFilter
  })

  return (
    <div className="space-y-6">
      <div className="flex justify-between items-center">
        <div>
          <h1 className="text-3xl font-bold text-gray-900">RFID Events</h1>
          <p className="text-gray-600">Rastreamento em tempo real de movimentações</p>
        </div>
        <button 
          onClick={() => window.location.reload()}
          className="flex items-center gap-2 bg-blue-600 text-white px-4 py-2 rounded-xl hover:bg-blue-700 transition"
        >
          <RefreshCw size={18} />
          Atualizar
        </button>
      </div>

      {/* Filters */}
      <div className="flex flex-col md:flex-row gap-4">
        <div className="flex-1 relative">
          <Search className="absolute left-3 top-3 text-gray-400" size={20} />
          <input
            type="text"
            placeholder="Buscar por Tag ID, Localização ou Item..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
            className="w-full pl-10 pr-4 py-3 bg-white border border-gray-200 rounded-2xl focus:outline-none focus:border-blue-500"
          />
        </div>

        <div className="flex gap-3">
          <select 
            value={filterStatus}
            onChange={(e) => setFilterStatus(e.target.value as any)}
            className="bg-white border border-gray-200 rounded-2xl px-4 py-3 focus:outline-none"
          >
            <option value="all">Todos os Status</option>
            <option value="success">Sucesso</option>
            <option value="warning">Atenção</option>
            <option value="error">Erro</option>
          </select>
        </div>
      </div>

      {/* Events Table */}
      <div className="bg-white rounded-2xl shadow-sm border border-gray-100 overflow-hidden">
        <div className="overflow-x-auto">
          <table className="w-full">
            <thead>
              <tr className="border-b bg-gray-50">
                <th className="px-6 py-4 text-left text-sm font-medium text-gray-500">EVENT ID</th>
                <th className="px-6 py-4 text-left text-sm font-medium text-gray-500">TIMESTAMP</th>
                <th className="px-6 py-4 text-left text-sm font-medium text-gray-500">TAG ID</th>
                <th className="px-6 py-4 text-left text-sm font-medium text-gray-500">LOCALIZAÇÃO</th>
                <th className="px-6 py-4 text-left text-sm font-medium text-gray-500">AÇÃO</th>
                <th className="px-6 py-4 text-left text-sm font-medium text-gray-500">ITEM</th>
                <th className="px-6 py-4 text-left text-sm font-medium text-gray-500">STATUS</th>
              </tr>
            </thead>
            <tbody className="divide-y">
              {filteredEvents.map((event) => (
                <tr key={event.id} className="hover:bg-gray-50 transition">
                  <td className="px-6 py-4 font-mono text-sm">{event.id}</td>
                  <td className="px-6 py-4 text-sm text-gray-600">
                    <div className="flex items-center gap-2">
                      <Clock size={16} />
                      {event.timestamp}
                    </div>
                  </td>
                  <td className="px-6 py-4 font-mono text-sm">{event.tagId}</td>
                  <td className="px-6 py-4 text-sm">{event.location}</td>
                  <td className="px-6 py-4">
                    <span className="inline-block px-3 py-1 bg-blue-100 text-blue-700 text-xs font-medium rounded-full">
                      {event.action}
                    </span>
                  </td>
                  <td className="px-6 py-4 text-sm text-gray-700">{event.item || '-'}</td>
                  <td className="px-6 py-4">
                    <span className={`inline-flex items-center px-3 py-1 rounded-full text-xs font-medium
                      ${event.status === 'success' ? 'bg-emerald-100 text-emerald-700' : ''}
                      ${event.status === 'warning' ? 'bg-amber-100 text-amber-700' : ''}
                      ${event.status === 'error' ? 'bg-red-100 text-red-700' : ''}
                    `}>
                      {event.status === 'success' && '✅ Sucesso'}
                      {event.status === 'warning' && '⚠️ Atenção'}
                      {event.status === 'error' && '❌ Erro'}
                    </span>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        {filteredEvents.length === 0 && (
          <div className="p-12 text-center text-gray-500">
            Nenhum evento encontrado
          </div>
        )}
      </div>

      <p className="text-xs text-gray-500 text-center">
        Simulação de eventos em tempo real • Última atualização: agora
      </p>
    </div>
  )
}