CREATE DATABASE bdjuego;
USE bdjuego;

CREATE TABLE usuario(
	id_usuario INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre_usuario VARCHAR(50) NOT NULL,
	apellido_usuario VARCHAR(50) NOT NULL,
	edad_usuario INT NOT NULL,
	usuario_usuario VARCHAR(30) NOT NULL,
	contrasena_usuario VARCHAR(30) NOT NULL,
	fecha_ingreso_usuario DATE NOT NULL,
	fecha_actualizacion_usuario DATE NULL,
	id_tipo_usuario_fk INT NOT NULL
);

CREATE TABLE tipo_usuario(
	id_tipo_usuario INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	nombre_tipo_usuario VARCHAR(20) NOT NULL,
	descripcion_tipo_usuario VARCHAR(80) NULL
);

CREATE TABLE puntajes_usuario(
	id_puntaje INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	puntaje_principiante INT NULL,
	puntaje_intermedio INT NULL,
	puntaje_avanzado INT NULL
	id_usuario_fk INT NOT NULL
);

INSERT INTO tipo_usuario(nombre_tipo_usuario, descripcion_tipo_usuario)
VALUES ('Administrador', 'Usuario que posee el control de la administración de usuarios'),
('Principiante', 'Primer nivel de aprendizaje'),
('Intermedio', 'Segundo nivel de aprendizaje'),
('Avanzado', 'Tercer nivel de aprendizaje');

INSERT INTO usuario(nombre_usuario, apellido_usuario, edad_usuario, usuario_usuario, contrasena_usuario, fecha_ingreso_usuario, id_tipo_usuario_fk)
VALUES ('Ana', 'Fletes', 20, 'admin', 'admin', '2022/06/15', 1);
INSERT INTO usuario(nombre_usuario, apellido_usuario, edad_usuario, usuario_usuario, contrasena_usuario, fecha_ingreso_usuario, id_tipo_usuario_fk)
VALUES ('Carmen', 'Lucila', 30, 'carmenLucila452', 'carmen123', '2022/06/16', 2);

ALTER TABLE bdjuego.usuario ADD CONSTRAINT FK1
FOREIGN KEY (id_tipo_usuario_fk)
REFERENCES bdjuego.tipo_usuario (id_tipo_usuario);

ALTER TABLE bdjuego.puntajes_usuario ADD CONSTRAINT FK2
FOREIGN KEY (id_usuario_fk)
REFERENCES bdjuego.usuario (id_usuario);

DROP TABLE usuario;

SELECT * FROM usuario;
SELECT * FROM tipo_usuario;
SELECT * FROM puntajes_usuario;

SELECT u.id_usuario, u.nombre_usuario, p.puntaje_principiante
FROM bdjuego.usuario u
INNER JOIN bdjuego.puntajes_usuario p 
ON p.id_usuario_fk = u.id_usuario;

SELECT t.id_tipo_usuario, t.nombre_tipo_usuario, t.descripcion_tipo_usuario 
FROM bdjuego.tipo_usuario t 
INNER JOIN bdjuego.usuario u 
ON u.id_tipo_usuario_fk = t.id_tipo_usuario


SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.edad_usuario, u.usuario_usuario, u.contrasena_usuario, u.fecha_ingreso_usuario, u.fecha_actualizacion_usuario, u.id_tipo_usuario_fk
FROM bdjuego.usuario u

SELECT u.id_usuario, u.nombre_usuario, u.apellido_usuario, u.edad_usuario, u.usuario_usuario, p.id_usuario_fk, p.id_puntaje
FROM bdjuego.usuario u
INNER JOIN bdjuego.puntajes_usuario p 
ON u.id_usuario = p.id_usuario_fk;


WHERE u.id_tipo_usuario_fk <> 1;

id_usuario_fk

INSERT INTO puntajes_usuario(id_usuario_fk)
VALUES (1);

UPDATE bdjuego.puntajes_usuario p
SET p.puntaje_principiante = 6, p.puntaje_intermedio = 5, p.puntaje_avanzado = 10, p.puntaje_promedio = SUM(p.puntaje_principiante, p.puntaje_intermedio, p.puntaje_avanzado)
WHERE p.id_usuario_fk = 

CREATE TABLE puntajes_usuario(
	id_puntaje INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
	puntaje_principiante INT NULL,
	puntaje_intermedio INT NULL,
	puntaje_avanzado INT NULL,
	puntaje_promedio INT NULL,
	id_usuario_fk INT NOT NULL
);

SELECT t.id_tipo_usuario, t.nombre_tipo_usuario, t.descripcion_tipo_usuario 
FROM bdjuego.tipo_usuario t 
INNER JOIN bdjuego.usuario u 
ON u.id_tipo_usuario_fk = t.id_tipo_usuario;


SELECT p.id_usuario_fk, p.puntaje_principiante, p.puntaje_intermedio, p.puntaje_avanzado, p.puntaje_promedio
FROM bdjuego.puntajes_usuario p;


