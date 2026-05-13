# Diagrama de Classes

## Visão Geral

Este documento descreve as principais entidades do sistema e seus respectivos atributos.

As entidades atualmente mapeadas são:

- [x] TENANT
- [ ] USUARIO
- [ ] PERMISSAO
- [x] CLIENTE
- [x] CATALOGO
- [x] ITEM_CATALOGO
- [ ] VENDA
- [ ] ITEM_VENDA
- [ ] OS
- [ ] ITEM_OS
- [ ] EXECUCAO_ITEM_OS
- [ ] COBRANCA

---

## TENANT

| Campo | Tipo | Descrição |
| --- | --- | --- |
| id | UUID | Identificador único do tenant |
| nomeFantasia | String | Nome fantasia da empresa |
| razaoSocial | String | Razão social da empresa |
| tipoDocumento | String | Tipo do documento (`CPF` ou `CNPJ`) |
| documento | String | Documento da empresa |
| inscricaoEstadual | String? | Inscrição estadual |
| email | String | Email principal |
| telefone | String | Telefone principal |
| ativo | Boolean | Indica se o tenant está ativo |
| cep | String | CEP do endereço |
| estado | String | Estado |
| cidade | String | Cidade |
| bairro | String | Bairro |
| rua | String | Rua |
| numero | String | Número do endereço |
| criadoEm | LocalDateTime | Data de criação do registro |
| atualizadoEm | LocalDateTime | Data da última atualização |

## CLIENTE

| Campo | Tipo | Descrição |
| --- | --- | --- |
| id | UUID | Identificador único do cliente |
| tenantId | UUID | Tenant ao qual o cliente pertence |
| nomeFantasia | String | Nome fantasia do cliente |
| razaoSocial | String | Razão social do cliente |
| tipoDocumento | String | Tipo do documento (`CPF` ou `CNPJ`) |
| documento | String | Documento do cliente |
| inscricaoEstadual | String? | Inscrição estadual |
| email | String | Email principal |
| telefone | String | Telefone principal |
| nomeContato | String? | Nome do contato principal |
| ativo | Boolean | Indica se o cliente está ativo |
| cep | String | CEP do endereço |
| estado | String | Estado |
| cidade | String | Cidade |
| bairro | String | Bairro |
| rua | String | Rua |
| numero | String | Número do endereço |
| complemento | String? | Complemento do endereço |
| criadoEm | LocalDateTime | Data de criação do registro |
| atualizadoEm | LocalDateTime | Data da última atualização |

## Catalogo

| Campo | Tipo | Descrição |
| --- | --- | --- |
| id | UUID | Identificador único do catálogo |
| tenantId | UUID | Tenant proprietário do catálogo |
| nome | String | Nome do catálogo |
| descricao | String? | Descrição do catálogo |
| ativo | Boolean | Indica se o catálogo está ativo |
| criadoEm | LocalDateTime | Data de criação do registro |
| atualizadoEm | LocalDateTime | Data da última atualização |

## ItemCatalogo

| Campo | Tipo | Descrição |
| --- | --- | --- |
| id | UUID | Identificador único do item do catálogo |
| catalogoId | UUID | Catálogo ao qual o item pertence |
| codigo | String | Código interno do item |
| nome | String | Nome do serviço/produto |
| descricao | String? | Descrição detalhada do item |
| valorBase | BigDecimal | Valor padrão do item |
| tempoEstimadoHoras | Integer? | Tempo estimado de execução em horas |
| ativo | Boolean | Indica se o item está ativo |
| criadoEm | LocalDateTime | Data de criação do registro |
| atualizadoEm | LocalDateTime | Data da última atualização |

##

---

## Diagrama ER

```mermaid
erDiagram

    TENANT {
        uuid id
        string nome
        string documento
        boolean ativo
    }

    USUARIO {
        uuid id
        string nome
        string email
        boolean ativo
    }

    PERMISSAO {
        uuid id
        string nome
        string codigo
    }

    CLIENTE {
        uuid id
        uuid tenant_id
        string nome
        string documento
        string telefone
        string email
        boolean ativo
    }

    CATALOGO {
        uuid id
        uuid tenant_id
        string nome
        string descricao
        boolean ativo
    }

    ITEM_CATALOGO {
        uuid id
        uuid catalogo_id
        string nome
        string descricao
        decimal valor_base
        boolean ativo
    }

    VENDA {
        uuid id
        uuid tenant_id
        uuid cliente_id
        string codigo
        decimal valor_total
        string status
        datetime criada_em
    }

    ITEM_VENDA {
        uuid id
        uuid venda_id
        uuid item_catalogo_id
        string descricao
        int quantidade
        decimal valor_unitario
        decimal valor_total
    }

    OS {
        uuid id
        uuid tenant_id
        uuid cliente_id
        uuid venda_id
        string codigo
        string status
        datetime criada_em
        datetime agendada_em
    }

    ITEM_OS {
        uuid id
        uuid os_id
        uuid item_catalogo_id
        string descricao
        int quantidade
        decimal valor_unitario
    }

    EXECUCAO_ITEM_OS {
        uuid id
        uuid item_os_id
        datetime iniciado_em
        datetime finalizado_em
        string status
        string observacoes
    }

    COBRANCA {
        uuid id
        uuid tenant_id
        uuid cliente_id
        uuid venda_id
        uuid os_id
        string numero
        decimal valor_total
        string status
        date data_vencimento
    }

    TENANT ||--o{ USUARIO : possui
    USUARIO o{--o{ PERMISSAO : possui

    TENANT ||--o{ CLIENTE : possui

    TENANT ||--o{ CATALOGO : possui
    CATALOGO ||--o{ ITEM_CATALOGO : contem

    TENANT ||--o{ VENDA : registra
    CLIENTE ||--o{ VENDA : realiza
    VENDA ||--o{ ITEM_VENDA : contem
    ITEM_CATALOGO ||--o{ ITEM_VENDA : referencia

    TENANT ||--o{ OS : registra
    CLIENTE ||--o{ OS : recebe
    VENDA ||--o{ OS : gera
    OS ||--o{ ITEM_OS : contem
    ITEM_CATALOGO ||--o{ ITEM_OS : referencia

    ITEM_OS ||--o{ EXECUCAO_ITEM_OS : possui

    TENANT ||--o{ COBRANCA : emite
    CLIENTE ||--o{ COBRANCA : recebe
    VENDA ||--o{ COBRANCA : gera
    OS ||--o{ COBRANCA : gera
```
