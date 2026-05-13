# Estrutura Inicial do Projeto Java Spring

## Objetivo

Definir uma estrutura simples, organizada e escalável para o sistema utilizando Java + Spring Boot.

A arquitetura deve:

- facilitar manutenção;
- separar responsabilidades;
- manter o domínio organizado;
- ser simples para início do projeto;
- evitar complexidade desnecessária.

---

## Estratégia arquitetural

O projeto será organizado por domínio/feature.

Exemplo:

```text
clientes
vendas
os
faturamento
catalogo
usuarios
```

Cada domínio possui suas próprias classes:

- entidades;
- services;
- repositories;
- controllers;
- DTOs.

---

## Estrutura inicial de pacotes

```text
src/main/java/com/suaempresa/fieldops
├── FieldOpsApplication.java
│
├── clientes
│   ├── Cliente.java
│   ├── ClienteRepository.java
│   ├── ClienteService.java
│   ├── ClienteController.java
│   └── dto
│
├── catalogo
│   ├── ItemCatalogo.java
│   ├── ItemCatalogoRepository.java
│   ├── ItemCatalogoService.java
│   ├── ItemCatalogoController.java
│   └── dto
│
├── vendas
│   ├── Venda.java
│   ├── ItemVenda.java
│   ├── VendaRepository.java
│   ├── VendaService.java
│   ├── VendaController.java
│   └── dto
│
├── os
│   ├── OS.java
│   ├── ItemOS.java
│   ├── ExecucaoServico.java
│   ├── OSRepository.java
│   ├── ItemOSRepository.java
│   ├── ExecucaoServicoRepository.java
│   ├── OSService.java
│   ├── OSController.java
│   └── dto
│
├── faturamento
│   ├── Fatura.java
│   ├── FaturaRepository.java
│   ├── FaturaService.java
│   ├── FaturaController.java
│   └── dto
│
└── usuarios
    ├── Usuario.java
    ├── UsuarioRepository.java
    ├── UsuarioService.java
    ├── UsuarioController.java
    └── dto
```

---

## Organização das camadas

### Entity

Representa a entidade persistida no banco de dados.

Exemplo:

```text
Venda
OS
Cliente
Fatura
```

Responsabilidades:

- mapear tabelas;
- mapear relacionamentos;
- representar o domínio persistido.

---

### Repository

Responsável pelo acesso ao banco de dados.

Exemplo:

```text
VendaRepository
OSRepository
```

Responsabilidades:

- salvar;
- buscar;
- atualizar;
- remover;
- executar consultas.

---

### Service

Responsável pelas regras de negócio.

Exemplo:

```text
VendaService
OSService
```

Responsabilidades:

- criar venda;
- gerar OS automaticamente;
- reorganizar serviços;
- gerar cobrança;
- validar regras de negócio.

---

### Controller

Responsável pela camada HTTP/API.

Exemplo:

```text
VendaController
OSController
```

Responsabilidades:

- receber requisições;
- validar entrada;
- retornar respostas;
- acionar services.

---

### DTO

Objetos de entrada e saída da API.

Exemplo:

```text
CriarVendaRequest
VendaResponse
```

Objetivos:

- evitar exposição direta das entidades;
- controlar payloads;
- separar API da persistência.

---

## Fluxo arquitetural

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Banco de dados
```

---

## Exemplo de fluxo

### Criação de venda

```text
VendaController
    ↓
VendaService
    ↓
VendaRepository
    ↓
OSService
    ↓
OSRepository
```

Fluxo:

1. Controller recebe requisição;
2. Service cria a venda;
3. Itens da venda são criados;
4. Sistema gera automaticamente uma OS padrão;
5. Dados são persistidos.

---

## Convenções recomendadas

### Nome de entidades

Usar nomes claros e explícitos.

Exemplo:

```text
OS
ItemOS
ExecucaoServico
Venda
ItemVenda
Fatura
Cliente
```

Evitar:

- nomes genéricos;
- abreviações excessivas;
- termos ambíguos.

---

## Estratégia recomendada para início

Começar simples.

Evitar inicialmente:

- Clean Architecture completa;
- arquitetura hexagonal;
- event-driven;
- microservices;
- CQRS;
- DDD complexo.

---

## Arquitetura recomendada para MVP

Arquitetura em camadas:

```text
Controller
→ Service
→ Repository
→ Database
```

Objetivos:

- rapidez de desenvolvimento;
- facilidade de manutenção;
- clareza estrutural;
- menor complexidade inicial.

---

## Ordem recomendada de implementação

```text
1. Cliente
2. ItemCatalogo
3. Venda + ItemVenda
4. OS + ItemOS
5. ExecucaoServico
6. Fatura
7. Usuários e permissões
```

---

## Objetivo da estrutura

Garantir:

- organização;
- separação de responsabilidades;
- facilidade de manutenção;
- escalabilidade futura;
- simplicidade para evolução do sistema.
