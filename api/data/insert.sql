INSERT INTO passageiro (nome, data_nascimento, cpf, score, saldo) VALUES
('Diêison', '1992-05-31', '33743131595', 5, 1000),
('Maria', '1965-07-20', '34380561356', 4.7, 2000),
('Lucas', '2000-11-26', '28584385444', 4.2, 1150),
('Carla', '1988-04-05', '17348184766', 4.8, 2500);

INSERT INTO motorista (nome, data_nascimento, cpf, score, saldo) VALUES
('Matheus', '1998-03-11', '83127138164', 5, 1000),
('Ana', '2002-03-12', '51247621871', 4.8, 640),
('Jose', '1979-10-06', '25168037887', 4.6, 1150),
('Carlos', '1995-11-29', '17348184766', 4.87, 2300);

INSERT INTO licenca_motorista (numero, categoria, data_vencimento, motorista_id) VALUES
('52096194630', 'A', '2025-10-22', 1),
('53386058458', 'B', '2023-12-29', 2),
('63202760052', 'C', '2024-06-24', 3),
('45202894826', 'B', '2025-09-30', 4);

INSERT INTO veiculo (placa, modelo, cor, foto, categoria, motorista_id) VALUES
('MUV-7548', 'CG 160 Titan', 'vermelho', 'https://cabralmotor.fbitsstatic.net/img/p/cg-160-titan-70286/257004-3.jpg?w=1000&h=1000&v=no-change&qs=ignore', 'A', 1),
('MNL-3684', 'Audi a3', 'preto', 'https://i.imgur.com/HlNs3Sq.png', 'B', 2),
('IAB-3767', 'kombi', 'branco', 'https://i.imgur.com/5aSA7JB.png', 'C', 3),
('MPQ-6958', 'fiesta', 'azul', 'https://s2.glbimg.com/HEMrUrYpAPg5vNpe4_h_28yGvB4=/0x0:620x413/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2020/w/2/TYxKZnR0m6EJ5iXsPXnA/2017-11-24-ford-fiesta-titanium-01.jpg', 'B', 4);
