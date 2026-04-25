# 📦 API de Pedidos - Checkpoint 2

API REST desenvolvida com Spring Boot para gerenciamento de pedidos, utilizando **MySQL**, **Flyway** para versionamento de banco de dados e documentação com **Swagger (OpenAPI)**.

---
### Disciplina: Arquitetura SOA e Web Services
## RM 564068
## LARISSA PEREIRA BIUSSE
## TURMA:3ESS

## 🚀 Tecnologias Utilizadas

- Java 17+ (recomendado)
- Spring Boot
- Spring Web
- Spring Data JPA
- Validation (Bean Validation)
- MySQL
- Flyway Migrations
- Lombok
- Swagger (Springdoc OpenAPI)

---

## 📁 Estrutura do Projeto
 br.com.fiap3ess.checkpoint2<br>
 |<br>
 ├── controller → Endpoints REST<br>
 ├── service → Regras de negócio<br>
 ├── repository → Acesso ao banco (JPA)<br>
 ├── model → Entidades<br>
 ├── config → Configurações (Swagger)<br>


---

## ⚙️ Configuração do Ambiente

### 1. Criar banco de dados

```sql
CREATE DATABASE checkpoint2restapi;
```

### 2. Configurar application.properties

spring.application.name=checkpoint2
server.port=8085

# MYSQL
spring.datasource.url=jdbc:mysql://localhost:3306/checkpoint2restapi?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA
spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.open-in-view=false

# FLYWAY
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migration
spring.flyway.baseline-on-migrate=true

# SWAGGER
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.path=/swagger-ui.html


## Endpoints da API

http://localhost:8085/pedidos

# 🔹 Criar pedido
### POST /pedidos
```
 {
   "clienteNome": "João Silva",
    "valorTotal": 1554.90
 }
```

# 🔹 Listar pedidos
### GET /pedidos

# 🔹 Buscar por ID
### GET /pedidos/{id}

# 🔹 Atualizar pedido
### PUT /pedidos/{id}
```
 {
   "clienteNome": "Ms.Rudolph Waters",
   "valorTotal": 3599.99
 }
```

# 🔹 Deletar pedido
### DELETE /pedidos/{id}
---

## Swagger (Documentação da API)

Acesse no navegador:

```
 http://localhost:8085/swagger-ui/index.html
```


