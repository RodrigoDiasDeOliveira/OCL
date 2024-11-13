import React, { useEffect, useState } from 'react';
import axios from 'axios';
import logo from './assets/logotype.jpg'; // Importando a imagem

function App() {
  const [tags, setTags] = useState([]);

  // Função para buscar as tags do backend
  const fetchTags = async () => {
    try {
      const response = await axios.get('/api/rfid');
      setTags(response.data);
    } catch (error) {
      console.error("Erro ao buscar tags:", error);
    }
  };

  // Chamada inicial para carregar as tags ao montar o componente
  useEffect(() => {
    fetchTags();
  }, []);

  // Função para atualizar a localização da tag
  const handleUpdate = async (tag) => {
    try {
      await axios.post('/api/rfid/update', tag);
      fetchTags(); // Recarrega a lista após a atualização
    } catch (error) {
      console.error("Erro ao atualizar tag:", error);
    }
  };

  return (
    <div className="App">
      {/* Exibindo a imagem logo */}
      <img src={logo} alt="Logo do Projeto" style={{ width: '200px', marginBottom: '20px' }} />
      <h1>Rastreamento RFID</h1>
      <ul>
        {tags.map(tag => (
          <li key={tag.id}>
            {tag.productName} - {tag.location}
            <button onClick={() => handleUpdate({ ...tag, location: "Novo Local" })}>
              Atualizar Local
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
