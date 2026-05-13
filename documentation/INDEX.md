# Fluxo de Vendas, Ordens de Serviço e Faturamento

## Conceitos

### Venda

Representa o acordo comercial realizado com o cliente.

A venda contém:

- cliente
- serviços vendidos
- valores
- condições comerciais

---

### Ordem de Serviço (OS)

Representa a execução operacional/técnica dos serviços.

A OS contém:

- cliente
- serviços a serem executados
- responsável/equipe
- status operacional
- datas de execução

---

### Fatura / Cobrança

Representa a cobrança financeira gerada para o cliente.

A cobrança pode ter origem:

- em uma venda;
- diretamente em uma OS avulsa.

---

## Regra principal

Uma OS representa uma execução operacional única.

Serviços podem ficar agrupados na mesma OS quando compartilham:

- mesma execução/visita;
- mesma equipe;
- mesmo responsável;
- mesma janela operacional;
- mesmo contexto operacional.

Serviços devem ser separados quando houver:

- execuções independentes;
- equipes diferentes;
- responsáveis diferentes;
- datas diferentes;
- necessidade de acompanhamento separado.

---

## Fluxo padrão de venda

### 1. Criação da venda

O usuário realiza uma venda contendo um ou mais serviços.

Exemplo:

- Instalação
- Configuração
- Treinamento

---

### 2. Geração automática da OS

O sistema gera automaticamente uma OS padrão contendo todos os serviços da venda.

Exemplo:

```text
OS #001
├── Instalação
├── Configuração
└── Treinamento
```

---

### 3. Organização operacional

O responsável operacional/técnico decide como os serviços serão executados.

Ele pode:

- manter todos os serviços na mesma OS;
- remover serviços da OS;
- criar novas OS;
- reorganizar os serviços conforme a operação.

Exemplo:

```text
OS #001
├── Instalação
└── Configuração

OS #002
└── Treinamento
```

---

## Fluxo de OS avulsa

O sistema também permite criação manual de OS sem venda prévia.

Exemplos:

- manutenção corretiva;
- atendimento emergencial;
- serviço interno;
- serviço solicitado diretamente ao setor técnico.

Fluxo:

1. Usuário cria a OS manualmente;
2. Serviço é executado;
3. Usuário pode gerar cobrança posteriormente.

---

## Fluxo de faturamento

### Cobrança originada de venda

Fluxo:

```text
Venda
└── OS
    └── Fatura
```

Nesse cenário:

- a venda representa o acordo comercial;
- a cobrança pode ser gerada a partir da venda.

---

### Cobrança originada de OS avulsa

Fluxo:

```text
OS avulsa
└── Fatura
```

Nesse cenário:

- não existe venda obrigatoriamente;
- a OS pode gerar cobrança diretamente.

O sistema NÃO deve criar vendas automáticas apenas para permitir faturamento.

---

## Responsabilidades

### Sistema

Responsável por:

- gerar automaticamente uma OS padrão ao criar a venda;
- vincular os serviços vendidos à OS;
- permitir reorganização posterior;
- permitir faturamento via venda ou OS.

---

### Comercial

Responsável por:

- realizar a venda;
- definir os serviços vendidos.

O setor comercial não define a estrutura operacional das OS.

---

### Operacional/Técnico

Responsável por:

- decidir como os serviços serão agrupados;
- dividir serviços em múltiplas OS quando necessário;
- organizar a execução operacional;
- criar OS avulsas quando necessário.

---

## Estratégia arquitetural

O sistema NÃO assume:

- 1 serviço = 1 OS;
- toda OS possui venda;
- toda cobrança depende de venda.

O sistema permite:

- múltiplos serviços dentro da mesma OS;
- reorganização operacional posterior;
- OS avulsas;
- faturamento independente de venda.

---

## Objetivo da abordagem

Garantir:

- simplicidade para o MVP;
- flexibilidade operacional;
- aderência ao cenário real das empresas;
- baixa complexidade técnica;
- facilidade de expansão futura.

---

## Estrutura sugerida

```text
Venda
├── Cliente
├── Serviços vendidos
└── Valores

OS
├── Cliente
├── Venda (opcional)
├── Responsável
├── Status
└── Itens da OS

ItemOS
├── OS
├── ItemCatalogo
├── Status
└── ...

ExecucaoServico
├── ItemOS
├── Executor
├── Status
└── ...

Fatura
├── Cliente
├── Origem
│   ├── VENDA
│   └── OS_AVULSA
├── Venda (opcional)
├── OS (opcional)
├── Valor total
└── Status
```

---

## Regras de consistência

### Venda → OS

- Uma venda pode gerar uma ou mais OS;
- Uma OS pode possuir múltiplos serviços.

---

### OS avulsa

- Uma OS pode existir sem venda;
- OS avulsa pode gerar cobrança diretamente.

---

### Faturamento

- Se origem = VENDA:
  - `venda_id` deve existir.

- Se origem = OS_AVULSA:
  - `os_id` deve existir.

---

## Possíveis evoluções futuras

A estrutura permite adicionar futuramente:

- checklists por serviço;
- etapas internas;
- recorrência;
- contratos;
- faturamento parcial;
- automações operacionais;
- geração automática de cobranças;
- integração bancária;
- assinatura eletrônica.
  