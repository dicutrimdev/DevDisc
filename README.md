# 🎸 DevDisc

**DevDisc** é uma API que simula uma clássica loja de discos de vinil focada em gêneros de rock, como Heavy Metal, Grunge, Punk e Rock Nacional.  
O projeto foi desenvolvido com **Java + Spring Boot**, com uma estrutura limpa e dividida em camadas. Os dados de discos são obtidos diretamente da **API do Spotify**, enquanto os dados de clientes e transações são armazenados localmente no banco de dados.

---

## ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok
- RestTemplate
- API Spotify (Client Credentials Flow)
- MySQL
- Postman (para testes)

---

## 🧠 Estrutura do Projeto

A aplicação foi organizada nas seguintes camadas:

- `controller` → Camada de controle com endpoints REST
- `service` → Regras de negócio e integração com Spotify
- `repository` → Interface com o banco de dados (Spring Data)
- `dto` → Data Transfer Objects para evitar acoplamento
- `mapper` → Conversores entre entidades e DTOs
- `model/entity` → Entidades JPA
- `exception` → Exceções personalizadas com tratamento global

---

## 🎧 Integração com o Spotify

A busca de discos é feita usando a API do Spotify. Ao buscar por um artista, a aplicação retorna seus álbuns disponíveis.

**Exemplo de endpoint:**

```http
GET /spotify/discos?artista=Elvis Presley
```

**Retorno:**

```json
[
  {
    "nome": "Blue Hawaii",
    "dataLancamento": "1961-10-20",
    "imagemUrl": "https://i.scdn.co/image/abc123"
  }
]
```

A autenticação com a API do Spotify é feita via `Client Credentials Flow`, utilizando `client_id` e `client_secret` configurados nas variáveis de ambiente.

---

## 💾 Dados Salvos no Banco

As seguintes entidades são persistidas:

- **Clientes** (`Cliente`)
- **Transações** (`Transacao`)

---

## 🛠️ Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/devdisc.git
   cd devdisc
   ```

2. Configure o `application.properties` com suas credenciais e dados do banco:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/devdisc
   spring.datasource.username=SEU_USUARIO
   spring.datasource.password=SUA_SENHA

   devdisc.spotify.client.id=SEU_CLIENT_ID_AQUI
   devdisc.spotify.client.secret=SEU_CLIENT_SECRET_AQUI
   ```

3. Execute a aplicação via sua IDE ou terminal:
   ```bash
   ./mvnw spring-boot:run
   ```

---

## 📌 Observações

- O "estoque" de discos da DevDisc é simulado usando a API do Spotify.
- Apenas dados de clientes e transações são persistidos no banco de dados.
- A aplicação está em desenvolvimento e aberta para melhorias futuras.
