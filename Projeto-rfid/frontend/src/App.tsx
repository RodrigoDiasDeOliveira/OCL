import { useState, useEffect } from 'react';
import axios from 'axios';

interface RfidTag {
  id: number;
  tagId: string;
  productName: string;
  location: string;
  timeSinceLastScan: number;
}

const API_URL = 'http://localhost:8080/api/rfid';

function App() {
  const [tags, setTags] = useState<RfidTag[]>([]);
  const [loading, setLoading] = useState(true);
  const [newTag, setNewTag] = useState({ tagId: '', productName: '', location: '' });

  const fetchTags = async () => {
    try {
      setLoading(true);
      const res = await axios.get(API_URL);
      setTags(res.data);
    } catch (err) {
      console.error(err);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => { fetchTags(); }, []);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await axios.post(`${API_URL}/update`, newTag);
      setNewTag({ tagId: '', productName: '', location: '' });
      fetchTags();
      alert("✅ Tag registrada com sucesso!");
    } catch (error) {
      alert("❌ Erro ao registrar tag");
    }
  };

  const updateLocation = async (tag: RfidTag) => {
    const newLoc = prompt("Nova localização:", tag.location);
    if (!newLoc || newLoc === tag.location) return;

    try {
      await axios.post(`${API_URL}/update-location?productName=${encodeURIComponent(tag.productName)}&newLocation=${encodeURIComponent(newLoc)}`);
      fetchTags();
    } catch (err) {
      alert("Erro ao atualizar localização");
    }
  };

  const removeObsolete = async () => {
    if (!confirm("Remover tags obsoletas?")) return;
    try {
      await axios.delete(`${API_URL}/remove-obsolete`);
      fetchTags();
    } catch (err) {
      alert("Erro ao remover tags");
    }
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-slate-950 to-gray-900 text-white">
      <div className="max-w-6xl mx-auto px-6 py-12">
        <div className="text-center mb-12">
          <h1 className="text-6xl font-bold mb-3 tracking-tight">OCL</h1>
          <p className="text-2xl text-gray-400">RFID Intelligent Tracking</p>
        </div>

        {/* Formulário */}
        <div className="bg-white/10 backdrop-blur-xl border border-white/10 rounded-3xl p-8 mb-10">
          <h2 className="text-2xl font-semibold mb-6 text-center">Nova Tag RFID</h2>
          <form onSubmit={handleSubmit} className="grid grid-cols-1 md:grid-cols-4 gap-4">
            <input type="text" placeholder="Tag ID" value={newTag.tagId}
              onChange={e => setNewTag({...newTag, tagId: e.target.value})}
              className="bg-white/10 border border-white/20 rounded-2xl px-5 py-4 focus:outline-none focus:border-blue-500" required />

            <input type="text" placeholder="Produto" value={newTag.productName}
              onChange={e => setNewTag({...newTag, productName: e.target.value})}
              className="bg-white/10 border border-white/20 rounded-2xl px-5 py-4 focus:outline-none focus:border-blue-500" required />

            <input type="text" placeholder="Localização" value={newTag.location}
              onChange={e => setNewTag({...newTag, location: e.target.value})}
              className="bg-white/10 border border-white/20 rounded-2xl px-5 py-4 focus:outline-none focus:border-blue-500" required />

            <button type="submit" className="bg-blue-600 hover:bg-blue-700 font-semibold rounded-2xl py-4 transition">
              Registrar
            </button>
          </form>
        </div>

        {/* Tabela */}
        <div className="bg-white/10 backdrop-blur-xl border border-white/10 rounded-3xl overflow-hidden">
          <div className="px-8 py-6 border-b border-white/10 flex justify-between items-center">
            <h2 className="text-2xl font-semibold">Tags Ativas ({tags.length})</h2>
            <button onClick={removeObsolete} className="bg-red-600/80 hover:bg-red-700 px-6 py-2 rounded-2xl text-sm">
              Remover Obsoletas
            </button>
          </div>

          {loading ? (
            <p className="text-center py-20 text-gray-400">Carregando...</p>
          ) : tags.length === 0 ? (
            <p className="text-center py-20 text-gray-400">Nenhuma tag registrada ainda.</p>
          ) : (
            <table className="w-full">
              <thead>
                <tr className="border-b border-white/10 text-gray-400">
                  <th className="px-8 py-5 text-left">Tag ID</th>
                  <th className="px-8 py-5 text-left">Produto</th>
                  <th className="px-8 py-5 text-left">Localização</th>
                  <th className="px-8 py-5 text-left">Última Leitura</th>
                  <th className="px-8 py-5 text-center">Ação</th>
                </tr>
              </thead>
              <tbody className="divide-y divide-white/10">
                {tags.map(tag => (
                  <tr key={tag.id} className="hover:bg-white/5">
                    <td className="px-8 py-5 font-mono">{tag.tagId}</td>
                    <td className="px-8 py-5">{tag.productName}</td>
                    <td className="px-8 py-5">{tag.location}</td>
                    <td className="px-8 py-5 text-gray-400">{tag.timeSinceLastScan} min</td>
                    <td className="px-8 py-5 text-center">
                      <button onClick={() => updateLocation(tag)} className="bg-blue-600 hover:bg-blue-700 px-5 py-2 rounded-xl text-sm">
                        Alterar Local
                      </button>
                    </td>
                  </tr>
                ))}
              </tbody>
            </table>
          )}
        </div>
      </div>
    </div>
  );
}

export default App;