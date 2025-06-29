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

CREATE TABLE IF NOT EXISTS endereco(
    id BIGINT AUTO_INCREMENT NOT NULL,
    estado VARCHAR(30) NOT NULL,
    municipio VARCHAR(30) NOT NULL,
    bairro VARCHAR(30) NOT NULL,
    rua VARCHAR(30) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(70) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS produto(
    id BIGINT AUTO_INCREMENT NOT NULL,
    largura INT NOT NULL,
    altura INT NOT NULL,
    comprimento INT NOT NULL,
    peso DOUBLE NOT NULL,
    descricao VARCHAR(70) NOT NULL,
    numero INT NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS servico(
    id BIGINT AUTO_INCREMENT NOT NULL,
    produto_id BIGINT NOT NULL,
    pagamento VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    remetente_id BIGINT NOT NULL,
    destinatario_id BIGINT NOT NULL,
    endereco_busca_id INT NOT NULL,
    endereco_entrega_id INT NOT NULL,


    PRIMARY KEY(id),
    FOREIGN KEY(endereco_busca_id) REFERENCES endereco(id),
    FOREIGN KEY(endereco_entrega_id) REFERENCES endereco(id),
    FOREIGN KEY(produto_id) REFERENCES produto(id),
    FOREIGN KEY(remetente_id) REFERENCES usuario(id),
    FOREIGN KEY(destinatario_id) REFERENCES usuario(id)
);

CREATE TABLE IF NOT EXISTS orcamento(
  id BIGINT AUTO_INCREMENT NOT NULL,
  custo_embalagem DOUBLE NOT NULL,
  taxa_desistencia DOUBLE NOT NULL,
  valor DOUBLE NOT NULL,
  prazo INT NOT NULL,
  servico_id INT NOT NULL,
  funcionario_orcamento_id INT NOT NULL,
  PRIMARY KEY(id),
  FOREIGN KEY(servico_id) REFERENCES servico(id),
  FOREIGN KEY(funcionario_orcamento_id) REFERENCES usuario(id)
);