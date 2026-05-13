CREATE TABLE tenant (
    id BINARY(16)  PRIMARY KEY,
    nome_fantasia VARCHAR(255) NOT NULL,
    razao_social VARCHAR(255) NOT NULL,
    tipo_documento VARCHAR(10) NOT NULL, -- CPF ou CNPJ
    documento VARCHAR(20) NOT NULL,
    inscricao_estadual VARCHAR(50),
    email VARCHAR(255),
    telefone VARCHAR(20),
    ativo BOOLEAN DEFAULT TRUE,
    cep VARCHAR(10),
    estado VARCHAR(50),
    cidade VARCHAR(100),
    bairro VARCHAR(100),
    rua VARCHAR(150),
    numero VARCHAR(20),
    criado_em DATETIME DEFAULT CURRENT_TIMESTAMP,
    atualizado_em DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;