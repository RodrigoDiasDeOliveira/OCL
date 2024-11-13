 Frontend em React
No frontend, criaremos uma interface simples para exibir as tags RFID e atualizar as informações de localização de cada tag. Esse componente consome as APIs criadas no backend para listar e atualizar as tags.


Geral backend
Entidade RfidTag: Define a estrutura dos dados RFID, com identificador (id), nome do produto (productName) e localização (location).

Repositório RfidTagRepository: Interface que facilita a manipulação dos dados no banco.

Serviço RfidTagService: Contém a lógica de negócio, permitindo listar todas as tags e atualizar dados de uma tag específica.

Controlador RfidTagController: Exposição dos endpoints REST para o frontend, com métodos GET (listar) e POST (atualizar).

Serviço PredictionService: Realiza uma previsão de localização. Aqui, implementei uma simulação, mas essa lógica poderia ser expandida para uma análise preditiva com machine learning.

Controlador PredictionController: Cria o endpoint para receber dados de uma tag e retornar a previsão de localização.

Configuração de Segurança SecurityConfig: Permite acesso irrestrito aos endpoints para simplificar o desenvolvimento.

application.properties: Configurações de conexão ao banco de dados, que devem ser ajustadas com suas credenciais.

Com essa estrutura, o backend está preparado para lidar com operações de CRUD das tags RFID e realizar previsões de localização que poderão ser acessadas no frontend. Para rodar o projeto backend, basta entrar na pasta do backend e executar mvn spring-boot:run.

