// src/pages/Integration.tsx
import { useState } from 'react';
import { Upload, RefreshCw, FileText, Database } from 'lucide-react';
import axios from 'axios';

export default function Integration() {
  const [file, setFile] = useState<File | null>(null);
  const [type, setType] = useState('csv');
  const [erp, setErp] = useState('oracle');
  const [entity, setEntity] = useState('inventory');
  const [loading, setLoading] = useState(false);
  const [result, setResult] = useState<string>('');

  const handleFileUpload = async () => {
    if (!file) return;
    setLoading(true);

    const formData = new FormData();
    formData.append('file', file);
    formData.append('type', type);

    try {
      const res = await axios.post('/api/integration/files/upload', formData, {
        headers: { 'Content-Type': 'multipart/form-data' }
      });
      setResult(res.data);
    } catch (err: any) {
      setResult('Erro: ' + (err.response?.data || err.message));
    }
    setLoading(false);
  };

  const handleErpSync = async () => {
    setLoading(true);
    try {
      const res = await axios.post('/api/integration/erp/sync', { erp, entity });
      setResult(res.data);
    } catch (err: any) {
      setResult('Erro na sincronização: ' + (err.response?.data || err.message));
    }
    setLoading(false);
  };

  return (
    <div className="space-y-8">
      <h1 className="text-3xl font-bold">Integrações</h1>
      <p className="text-gray-600">Central de importação e sincronização de dados</p>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
        {/* Upload de Arquivos */}
        <div className="bg-white p-8 rounded-2xl shadow-sm border">
          <h2 className="text-xl font-semibold mb-6 flex items-center gap-3">
            <Upload /> Upload de Arquivos
          </h2>

          <div className="border-2 border-dashed border-gray-300 rounded-2xl p-8 text-center">
            <input
              type="file"
              onChange={(e) => setFile(e.target.files?.[0] || null)}
              className="hidden"
              id="file-upload"
            />
            <label htmlFor="file-upload" className="cursor-pointer">
              <FileText className="mx-auto h-12 w-12 text-gray-400" />
              <p className="mt-4 text-lg font-medium">{file ? file.name : "Arraste ou clique para selecionar"}</p>
            </label>
          </div>

          <div className="mt-6 grid grid-cols-2 gap-4">
            <select value={type} onChange={(e) => setType(e.target.value)} className="border rounded-xl p-3">
              <option value="csv">CSV</option>
              <option value="json">JSON</option>
              <option value="xml">XML</option>
            </select>

            <button
              onClick={handleFileUpload}
              disabled={!file || loading}
              className="bg-blue-600 text-white py-3 rounded-xl hover:bg-blue-700 disabled:opacity-50"
            >
              {loading ? 'Importando...' : 'Importar Arquivo'}
            </button>
          </div>
        </div>

        {/* Sincronização ERP */}
        <div className="bg-white p-8 rounded-2xl shadow-sm border">
          <h2 className="text-xl font-semibold mb-6 flex items-center gap-3">
            <Database /> Sincronização com ERP
          </h2>

          <div className="space-y-5">
            <div>
              <label className="block text-sm font-medium mb-2">Sistema ERP</label>
              <select value={erp} onChange={(e) => setErp(e.target.value)} className="w-full border rounded-xl p-3">
                <option value="oracle">Oracle ERP</option>
                <option value="sap">SAP S/4HANA</option>
                <option value="totvs">TOTVS</option>
              </select>
            </div>

            <div>
              <label className="block text-sm font-medium mb-2">Entidade</label>
              <select value={entity} onChange={(e) => setEntity(e.target.value)} className="w-full border rounded-xl p-3">
                <option value="inventory">Inventário</option>
                <option value="sales">Vendas</option>
                <option value="orders">Pedidos</option>
                <option value="shipments">Envios</option>
              </select>
            </div>

            <button
              onClick={handleErpSync}
              disabled={loading}
              className="w-full bg-emerald-600 text-white py-4 rounded-xl hover:bg-emerald-700 flex items-center justify-center gap-2"
            >
              <RefreshCw size={20} />
              Sincronizar com ERP
            </button>
          </div>
        </div>
      </div>

      {result && (
        <div className="bg-gray-900 text-white p-6 rounded-2xl font-mono text-sm">
          {result}
        </div>
      )}
    </div>
  );
}