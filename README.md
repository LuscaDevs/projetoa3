# Sistema de Gestão de Usuários e Itens

Este projeto é uma aplicação backend desenvolvida em **Spring Boot** que oferece endpoints para gerenciar usuários e tarefas. O sistema suporta autenticação baseada em tokens simples e utiliza **PostgreSQL** como banco de dados.

---

## 🚀 Funcionalidades

- **Gerenciamento de Usuários**:
  - Cadastro, autenticação e gerenciamento de usuários.
- **Autenticação com Token**:
  - Sistema simples de autenticação usando tokens armazenados no banco de dados.
- **Gerenciamento de Itens**:
  - CRUD (Create, Read, Update, Delete) para itens associados aos usuários.
- **Segurança**:
  - Autenticação e autorização configuradas para endpoints específicos.

---

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Java 17
- **Framework**: Spring Boot
- **Banco de Dados**: PostgreSQL
- **Gerenciador de Dependências**: Maven
- **Segurança**: Spring Security
- **Construção e Deploy**: Docker

---

## ⚙️ Configuração do Ambiente

### Pré-requisitos

- **Java 17+**
- **Maven 3.8+**
- **Docker** (opcional, para execução em container)
- **PostgreSQL** configurado localmente ou em um container

### Variáveis de Ambiente

No arquivo `application.properties`, configure as seguintes variáveis:

```properties
spring.application.name=user
spring.datasource.url=jdbc:postgresql://localhost:5432/usersdb
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## 🔧 Como Executar Localmente

### Clone o repositório

```bash
git clone https://github.com/seu-usuario/seu-projeto.git
```

```bash
cd seu-projeto
```

Compile e execute o projeto:

```bash
mvn clean package java -jar target/*.jar
```

Acesse a aplicação no navegador:
URL padrão: <http://localhost:8080>

### Usando Docker

Construa a imagem Docker:

```bash
docker build -t meu-projeto-springboot .
```

Execute o container:

```bash
docker run -p 8080:8080 --name meu-projeto-container meu-projeto-springboot
```

Suba o PostgreSQL em um container (caso necessário):

```bash
docker run -d \
    --name postgres-container \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres \
    -e POSTGRES_DB=usersdb \
    -p 5432:5432 \postgres
```

## 🗂️ Estrutura de Diretórios

```
src
├── main
│   ├── java
│   │   └── br.com.meusprocessos.user
│   │       ├── controller  # Controladores REST
│   │       ├── model       # Modelos de domínio
│   │       ├── repository  # Repositórios JPA
│   │       ├── service     # Lógica de negócios
│   │       └── config      # Configurações do Spring Security
│   └── resources
│       ├── application.properties
```

## 🛡️ Endpoints Principais

### Usuários

```
POST /api/users - Criação de usuário
POST /api/users/login - Login e geração de token
```

### Itens

```
GET /api/tarefas - Listar tarefas
GET /api/tarefas/{id} - Buscar tarefa por ID
POST /api/tarefas - Criar tarefa
PUT /api/tarefas/{id} - Atualizar tarefa
DELETE /api/tarefas/{id} - Deletar tarefa
```

📜 Licença

Este projeto é licenciado sob a MIT [LICENSE](LICENSE)
