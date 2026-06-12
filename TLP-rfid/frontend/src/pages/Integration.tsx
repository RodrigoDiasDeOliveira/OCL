// src/pages/Integration.tsx
import { useState } from 'react';
import { Upload, RefreshCw, FileText, Database, CheckCircle, AlertCircle } from 'lucide-react';
import axios from 'axios';

type FileType = 'csv' | 'json' | 'xml';
type ErpType = 'oracle' | 'sap' | 'totvs';

interface ResultMessage {
  type: 'success' | 'error';
  message: string;
}

export default function Integration() {
  const [file, setFile] = useState<File | null>(null);
  const [fileType, setFileType] = useState<FileType>('csv');
  const [erpSystem, setErpSystem] = useState<ErpType>('oracle');
  const [entityType, setEntityType] = useState<string>('inventory');
  const [loading, setLoading] = useState<boolean>(false);
  const [result, setResult] = useState<ResultMessage | null>(null);

  const handleFileUpload = async () => {
    if (!file) return;

    setLoading(true);
    setResult(null);

    const formData = new FormData();
    formData.append('file', file);
    formData.append('type', fileType);

    try {
      const response = await axios.post('/api/integration/files/upload', formData, {
        headers: { 'Content-Type': 'multipart/form-data' },
      });
      
      setResult({ type: 'success', message: response.data });
    } catch (error: unknown) {
      const message = error instanceof Error 
        ? error.message 
        : (axios.isAxiosError(error) && error.response?.data) 
          ? error.response.data 
          : 'Erro desconhecido ao importar arquivo';
      
      setResult({ type: 'error', message });
    } finally {
      setLoading(false);
    }
  };

  const handleErpSync = async () => {
    setLoading(true);
    setResult(null);

    try {
      const response = await axios.post('/api/integration/erp/sync', {
        erp: erpSystem,
        entity: entityType
      });
      
      setResult({ type: 'success', message: response.data });
    } catch (error: unknown) {
      const message = error instanceof Error 
        ? error.message 
        : (axios.isAxiosError(error) && error.response?.data) 
          ? error.response.data 
          : 'Erro na sincronização com ERP';
      
      setResult({ type: 'error', message });
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="space-y-8">
      <div>
        <h1 className="text-3xl font-bold text-gray-900">Integrações</h1>
        <p className="text-gray-600 mt-1">Central de ingestão e sincronização de dados</p>
      </div>

      <div className="grid grid-cols-1 lg:grid-cols-2 gap-8">
        {/* Upload de Arquivos */}
        <div className="bg-white rounded-3xl shadow-sm border border-gray-100 p-8">
          <h2 className="text-2xl font-semibold mb-6 flex items-center gap-3">
            <Upload className="text-blue-600" /> Upload de Arquivos
          </h2>

          <div 
            className="border-2 border-dashed border-gray-300 rounded-2xl p-10 text-center hover:border-blue-400 transition cursor-pointer"
            onClick={() => document.getElementById('file-input')?.click()}
          >
            <input
              type="file"
              id="file-input"
              className="hidden"
              onChange={(e) => setFile(e.target.files?.[0] || null)}
            />
            <FileText className="mx-auto h-16 w-16 text-gray-400 mb-4" />
            <p className="text-lg font-medium text-gray-700">
              {file ? file.name : "Clique ou arraste um arquivo"}
            </p>
            <p className="text-sm text-gray-500 mt-1">CSV, JSON ou XML</p>
          </div>

          <div className="mt-6 flex gap-4">
            <select 
              value={fileType} 
              onChange={(e) => setFileType(e.target.value as FileType)}
              className="flex-1 border border-gray-300 rounded-2xl px-4 py-3 focus:outline-none focus:border-blue-500"
            >
              <option value="csv">CSV</option>
              <option value="json">JSON</option>
              <option value="xml">XML</option>
            </select>

            <button
              onClick={handleFileUpload}
              disabled={!file || loading}
              className="flex-1 bg-blue-600 hover:bg-blue-700 disabled:bg-gray-400 text-white font-semibold py-3 rounded-2xl transition"
            >
              {loading ? 'Importando...' : 'Importar Arquivo'}
            </button>
          </div>
        </div>

        {/* Sincronização ERP */}
        <div className="bg-white rounded-3xl shadow-sm border border-gray-100 p-8">
          <h2 className="text-2xl font-semibold mb-6 flex items-center gap-3">
            <Database className="text-emerald-600" /> Sincronização com ERP
          </h2>

          <div className="space-y-6">
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-2">Sistema ERP</label>
              <select 
                value={erpSystem} 
                onChange={(e) => setErpSystem(e.target.value as ErpType)}
                className="w-full border border-gray-300 rounded-2xl px-4 py-3 focus:outline-none focus:border-emerald-500"
              >
                <option value="oracle">Oracle ERP</option>
                <option value="sap">SAP S/4HANA</option>
                <option value="totvs">TOTVS</option>
              </select>
            </div>

            <div>
              <label className="block text-sm font-medium text-gray-700 mb-2">Entidade / Módulo</label>
              <select 
                value={entityType} 
                onChange={(e) => setEntityType(e.target.value)}
                className="w-full border border-gray-300 rounded-2xl px-4 py-3 focus:outline-none focus:border-emerald-500"
              >
                <option value="inventory">Inventário</option>
                <option value="sales">Vendas</option>
                <option value="orders">Pedidos</option>
                <option value="shipments">Envios</option>
              </select>
            </div>

            <button
              onClick={handleErpSync}
              disabled={loading}
              className="w-full bg-emerald-600 hover:bg-emerald-700 disabled:bg-gray-400 text-white font-semibold py-4 rounded-2xl flex items-center justify-center gap-3 transition"
            >
              <RefreshCw size={22} className={loading ? 'animate-spin' : ''} />
              Sincronizar com ERP
            </button>
          </div>
        </div>
      </div>

      {/* Resultado */}
      {result && (
        <div className={`p-6 rounded-2xl flex items-start gap-4 ${
          result.type === 'success' 
            ? 'bg-emerald-50 border border-emerald-200' 
            : 'bg-red-50 border border-red-200'
        }`}>
          {result.type === 'success' ? 
            <CheckCircle className="text-emerald-600 mt-1 flex-shrink-0" size={28} /> : 
            <AlertCircle className="text-red-600 mt-1 flex-shrink-0" size={28} />
          }
          <p className={`font-medium ${result.type === 'success' ? 'text-emerald-700' : 'text-red-700'}`}>
            {result.message}
          </p>
        </div>
      )}
    </div>
  );
}