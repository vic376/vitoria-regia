# Vitória Régia

<div align="center">

![Java](https://img.shields.io/badge/Java_22-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL_9.6-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![MercadoPago](https://img.shields.io/badge/MercadoPago-009EE3?style=for-the-badge&logo=mercadopago&logoColor=white)
![License](https://img.shields.io/badge/MIT-lightgrey?style=for-the-badge)

</div>

> API REST de e-commerce para venda de produtos digitais, desenvolvida com Spring Boot.

---

## 📋 Índice

- [Sobre o Projeto](#-sobre-o-projeto)
- [Tecnologias](#-tecnologias)
- [Arquitetura](#-arquitetura)
- [Funcionalidades](#-funcionalidades)
- [Como Executar](#-como-executar)
- [Endpoints](#-endpoints)
- [Variáveis de Ambiente](#-variáveis-de-ambiente)
- [Roadmap](#-roadmap)

---

## 📦 Sobre o Projeto

O **Vitória Régia** é um sistema backend de e-commerce focado na venda de produtos digitais. A API oferece gerenciamento de produtos, autenticação de usuários e integração com o gateway de pagamento MercadoPago.

---

## 🚀 Tecnologias

| Tecnologia | Versão | Uso |
|---|---|---|
| Java | 22 | Linguagem principal |
| Spring Boot | 3.5.11 | Framework base |
| Spring Security | 6.5 | Autenticação e autorização |
| Spring Data JPA | 3.5.9 | Persistência de dados |
| Hibernate | 6.6.42 | ORM |
| MySQL | 9.6 | Banco de dados produção |
| H2 | 2.3.232 | Banco de dados para testes |
| MercadoPago SDK | 2.1.7 | Gateway de pagamento |
| Lombok | 1.18.42 | Redução de boilerplate |
| Maven | — | Gerenciador de dependências |

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
src/
└── main/
    └── java/
        └── com/nicoladelli/PixelCart/
            ├── application/
            │   ├── dto/
            │   │   ├── request/      # DTOs de entrada
            │   │   └── response/     # DTOs de saída
            │   └── mapper/           # Conversão entidade ↔ DTO
            ├── domain/
            │   ├── model/            # Entidades JPA
            │   └── service/          # Regras de negócio
            ├── infrastructure/
            │   ├── repository/       # Interfaces JPA
            │   ├── security/         # Configurações de segurança
            │   └── strategy/         # Padrão Strategy
            ├── web/
            │   └── controller/
            │       ├── admin/        # Endpoints administrativos
            │       └── cliente/      # Endpoints do cliente
            └── PixelCartApplication.java
```

---

## ✅ Funcionalidades

- [x] CRUD de produtos
- [x] Busca de produtos por nome
- [x] Autenticação e autorização com Spring Security
- [ ] Integração com MercadoPago
- [x] Gestão de pedidos
- [x] Gestão de usuários/clientes
- [ ] Histórico de compras
- [ ] Upload de produtos digitais

---

## ▶️ Como Executar

### Pré-requisitos

- Java 22+
- Maven 3.8+
- MySQL rodando localmente (ou use o H2 para testes)

### Passo a passo

```bash
# 1. Clone o repositório
git clone https://github.com/seu-usuario/vitoria-regia.git
cd vitoria-regia

# 2. Configure as variáveis de ambiente (veja a seção abaixo)

# 3. Execute o projeto
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

## 📡 Endpoints

### Produtos

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/produtos` | Lista todos os produtos |
| `GET` | `/produtos?nome={nome}` | Busca produto por nome |
| `GET` | `/produtos/{id}` | Busca produto por ID |
| `POST` | `/produtos` | Cadastra novo produto |
| `PUT` | `/produtos/{id}` | Atualiza produto |
| `DELETE` | `/produtos/{id}` | Remove produto |

> Mais endpoints serão documentados conforme o desenvolvimento avança.

---

## 🔐 Variáveis de Ambiente

Crie um arquivo `application.properties` ou configure as variáveis:

```properties
# Banco de dados
spring.datasource.url=jdbc:mysql://localhost:3306/vitoria-regia
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

# JPA
spring.jpa.hibernate.ddl-auto=update

# MercadoPago
mercadopago.access.token=SEU_ACCESS_TOKEN
```

> **Nunca** suba credenciais reais para o repositório.

---

## 📍 Roadmap

- [ ] Documentação com Swagger/OpenAPI
- [ ] Testes unitários e de integração
- [ ] Deploy na nuvem (Railway / Render / AWS)
- [ ] Paginação e filtros avançados nos endpoints
- [ ] Sistema de notificações por e-mail

---

## 👩‍💻 Autora

Desenvolvido por **Victoria Nicoladelli** como projeto **Vitória Régia**.
