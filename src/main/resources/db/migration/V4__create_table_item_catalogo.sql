CREATE TABLE item_catalogo (
    id BINARY(16) PRIMARY KEY,
    tenant_id BINARY(16) NOT NULL,
    catalogo_id BINARY(16) NOT NULL,
    codigo VARCHAR(16) NOT NULL,
    nome VARCHAR(255),
    descricao VARCHAR(255),
    valor_base DECIMAL(19, 2),
    tempo_estimado_horas INT,
    FOREIGN KEY (catalogo_id) REFERENCES catalogo(id),
    FOREIGN KEY (tenant_id) REFERENCES tenant(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;