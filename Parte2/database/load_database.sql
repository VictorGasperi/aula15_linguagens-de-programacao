CREATE DATABASE IF NOT EXISTS aula14;

USE aula14;

CREATE TABLE IF NOT EXISTS alunos (
    id_aluno INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    senha VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS materias (
    id_materia INT PRIMARY KEY AUTO_INCREMENT,
    nome_materia VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS notas (
    id_nota INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT,
    id_materia INT,
    bimestre INT,
    nota DECIMAL(5, 2),
    faltas INT,
    data_modificacao DATETIME,
    FOREIGN KEY (id_aluno) REFERENCES alunos(id_aluno),
    FOREIGN KEY (id_materia) REFERENCES materias(id_materia)
);

INSERT IGNORE INTO alunos VALUES (1, "teste", "teste");

INSERT IGNORE INTO materias VALUES (1, "Calculo");
INSERT IGNORE INTO materias VALUES (2, "Programacao");
INSERT IGNORE INTO materias VALUES (3, "Sistemas de Controle");

INSERT IGNORE INTO notas VALUES (1, 1, 1, 1, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (2, 1, 1, 2, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (3, 1, 1, 3, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (4, 1, 1, 4, 0, 0, NOW());

INSERT IGNORE INTO notas VALUES (5, 1, 2, 1, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (6, 1, 2, 2, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (7, 1, 2, 3, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (8, 1, 2, 4, 0, 0, NOW());

INSERT IGNORE INTO notas VALUES (9, 1, 3, 1, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (10, 1, 3, 2, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (11, 1, 3, 3, 0, 0, NOW());
INSERT IGNORE INTO notas VALUES (12, 1, 3, 4, 0, 0, NOW());

