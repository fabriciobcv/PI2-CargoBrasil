-- noinspection SqlNoDataSourceInspectionForFile

CREATE TABLE IF NOT EXISTS usuario(
    id BIGINT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(128),
    email VARCHAR(128) UNIQUE,
    telefone VARCHAR(11),
    cpf VARCHAR(11) UNIQUE,
    senha VARCHAR(255),
    tipo VARCHAR(128),
    PRIMARY KEY(id)
);