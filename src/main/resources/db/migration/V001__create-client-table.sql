CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(20)
);