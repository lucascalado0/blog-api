# API RESTful - Blog Pessoal

Esta API foi desenvolvida para gerenciar um **blog pessoal**, permitindo operações de **CRUD** (Criar, Ler, Atualizar e Excluir) sobre artigos.  
Ela foi construída utilizando **Java** e diversas bibliotecas/frameworks para garantir organização, performance e facilidade de manutenção.

---

## Funcionalidades

A API oferece os seguintes endpoints:

- **Listar artigos**  
  - Retorna uma lista de artigos publicados.
  - Possibilidade de filtrar por **data de publicação** e **tags**.

- **Obter um único artigo**  
  - Busca um artigo específico pelo **ID**.

- **Criar um artigo**  
  - Adiciona um novo artigo para publicação.

- **Atualizar um artigo**  
  - Atualiza os dados de um artigo existente usando seu **ID**.

- **Excluir um artigo**  
  - Remove permanentemente um artigo pelo **ID**.

---

## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot** - Framework para construção da API REST.
- **JPA (Java Persistence API)** - Mapeamento objeto-relacional.
- **Hibernate** - Implementação do JPA.
- **H2 Database** - Banco de dados em memória para testes.
- **PostgreSQL** - Banco de dados relacional em produção.
- **Lombok** - Reduz código boilerplate (getters, setters, construtores, etc.).
- **Jakarta Validation API** - Validação de dados recebidos.

---

## Como Executar o Projeto

### Pré-requisitos
- **Java 21**
- **Maven**
- **PostgreSQL** instalado e configurado

### Clonar o repositório
  bash
- git clone https://github.com/seu-usuario/blog-pessoal-api.git
- cd blog-pessoal-api

## Banco de dados H2 e JPA

spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=
spring.datasource.password=
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Configurações JPA e Hibernate
spring.jpa.hibernate.ddl-auto=create
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.datasource.hikari.maximum-pool-size=10
spring.datasource.hikari.minimum-pool-size=5

## Exemplos de Endpoints

- GET /api/artigos → Lista todos os artigos

- GET /api/artigos/{id} → Retorna um artigo pelo ID

- POST /api/artigos → Cria um novo artigo

- PUT /api/artigos/{id} → Atualiza um artigo existente

- DELETE /api/artigos/{id} → Remove um artigo


