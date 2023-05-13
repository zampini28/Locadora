# DROP SCHEMA IF EXISTS locadora;
CREATE SCHEMA IF NOT EXISTS locadora;

CREATE TABLE IF NOT EXISTS locadora.categoria (
    id      SERIAL,
    nome    VARCHAR(50) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS locadora.produto (
    id              SERIAL,
    nome            VARCHAR(50) NOT NULL,
    categoria_id    BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(categoria_id) REFERENCES categoria(id)
);

INSERT INTO categoria (nome) VALUES ('Ação'), ('Aventura'), ('Comédia'), ('Drama'), ('Ficção'), ('Romance'), ('Terror');

INSERT INTO produto VALUES 
(DEFAULT, "Filme de ação", (SELECT id FROM categoria WHERE nome = "Ação")),
(DEFAULT, "Filme de aventura", (SELECT id FROM categoria WHERE nome = "Aventura")),
(DEFAULT, "Filme de comédia", (SELECT id FROM categoria WHERE nome = "Comédia")),
(DEFAULT, "Filme de drama", (SELECT id FROM categoria WHERE nome = "Drama")),
(DEFAULT, "Filme de ficção", (SELECT id FROM categoria WHERE nome = "Ficção")),
(DEFAULT, "Filme de romance", (SELECT id FROM categoria WHERE nome = "Romance")),
(DEFAULT, "Filme de terror", (SELECT id FROM categoria WHERE nome = "Terror"));