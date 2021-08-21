CREATE TABLE ocorrencia (
    id SERIAL PRIMARY KEY,
    entrega_id BIGINT NOT NULL,
    descricao TEXT NOT NULL,
    data_registro TIMESTAMP NOT NULL
);
