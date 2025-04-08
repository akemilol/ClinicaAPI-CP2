# 🏥 API REST - Clínica Hospitalar

Este projeto é uma **API RESTful** desenvolvida com **Spring Boot** com o objetivo de gerenciar os dados de uma clínica hospitalar. O sistema oferece funcionalidades completas de cadastro, consulta e remoção de:

- Clientes
- Médicos
- Especialidades
- Consultas

---

## 📚 Tecnologias Utilizadas

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA
- Spring Web
- Spring Validation
- Spring HATEOAS
- H2 Database (memória)
- Gradle
- Swagger (Springdoc OpenAPI)

---

## ⚙️ Funcionalidades

### 🔹 Clientes
- Cadastro de clientes com validação (`nome`, `email`, `cpf`, etc.)
- Listagem completa ou por ID
- Atualização e exclusão
- Validações com mensagens amigáveis

### 🔹 Médicos
- Cadastro de médicos vinculados a múltiplas especialidades
- Listagem, visualização por ID e remoção

### 🔹 Especialidades
- Cadastro e exclusão de especialidades médicas

### 🔹 Consultas
- Marcação de consulta com médico + cliente
- Listagem e cancelamento de consultas

---

## 🧪 Testes via Swagger

A documentação e testes podem ser feitos acessando:
http://localhost:8080/swagger-ui.html

Exemplos de testes estão incluídos para todos os endpoints com:
- Corpo da requisição (`request`)
- Resposta esperada (`response`)
- Status HTTP retornado

---

## 👨‍💻 Equipe

- 💁‍♀️ Mirela Pinheiro Silva Rodrigues - RM: 558191
- 💁‍♀️ Valéria Conceição Dos Santos - RM: 557177


Trabalho em grupo desenvolvido para a disciplina de Java Advanced - FIAP.



