CREATE TABLE materias (
id integer auto_increment not null,
nombre varchar(64) not null,
);

CREATE TABLE preguntas (
id integer auto_increment not null,
pregunta varchar(64) not null,
respuestas varchar(500) not null,
materia varchar(64) not null,
correcta varchar(64) not null
);
INSERT INTO materias (nombre) VALUES ('Español');
INSERT INTO materias (nombre) VALUES ('Matemáticas');
INSERT INTO materias (nombre) VALUES ('Historia');
INSERT INTO materias (nombre) VALUES ('Igeniería de Software');
INSERT INTO materias (nombre) VALUES ('Álgebra');
INSERT INTO materias (nombre) VALUES ('Cálculo');

