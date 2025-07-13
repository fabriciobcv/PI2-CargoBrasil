-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO usuario(nome, email, telefone, cpf, senha, tipo) values ('Fulano da Silva', 'fulano.silva@cargobrasil.com', '219XXXXXXXX', '06236714096', '1234', 'FUNCIONARIO_TRANSPORTE');
INSERT INTO usuario(nome, email, telefone, cpf, senha, tipo) values ('Ciclano da Silva', 'ciclano.silva@cargobrasil.com', '219XXXXXXXX', '06236714097', '1234', 'FUNCIONARIO_ORCAMENTO');
INSERT INTO usuario(nome, email, telefone, cpf, senha, tipo) values ('João Carvalho', 'joao.carvalho@gmail.com', '219XXXXXXXX', '23945166071', '12345', 'CLIENTE');
INSERT INTO usuario(nome, email, telefone, cpf, senha, tipo) values ('Maria Torres', 'mariatorres@gmail.com', '219XXXXXXXX', '85122502080', '12345', 'CLIENTE');
INSERT INTO endereco(estado, municipio, bairro, rua, numero, complemento, cep) values ('Rio de Janeiro', 'Rio de Janeiro', 'Urca', 'Av. Pasteur', 458, 'CCET UNIRIO', '22290250');
INSERT INTO endereco(estado, municipio, bairro, rua, numero, complemento, cep) VALUES ('São Paulo', 'São Paulo', 'Butantã', 'Rua do Matão', 1010, 'Instituto de Matemática e Estatística - USP', '05508090');
INSERT INTO produto(largura, altura, comprimento, peso, descricao, numero) VALUES (10, 25, 10, 2.5, 'coisa fragil', 1);
INSERT INTO servico(produto_id, pagamento, status, remetente_id, destinatario_id, endereco_busca_id, endereco_entrega_id) VALUES (1, 'PIX', 'AGUARDANDO_ORCAMENTO', 3, 4, 1, 2);
INSERT INTO orcamento(custo_embalagem, taxa_desistencia, valor, prazo, servico_id, funcionario_orcamento_id) VALUES (5.40, 15.10, 30.20, 10, 1, 2);