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
	puntaje_avanzado INT NULL,
	id_usuario_fk INT NOT NULL
);

INSERT INTO tipo_usuario(nombre_tipo_usuario, descripcion_tipo_usuario)
VALUES ('Administrador', 'Usuario que posee el control de la administración de usuarios'),
('Principiante', 'Primer nivel de aprendizaje'),
('Intermedio', 'Segundo nivel de aprendizaje'),
('Avanzado', 'Tercer nivel de aprendizaje');

INSERT INTO usuario(nombre_usuario, apellido_usuario, edad_usuario, usuario_usuario, contrasena_usuario, fecha_ingreso_usuario, id_tipo_usuario_fk)
VALUES ('Elena', 'López', 20, 'admin', 'admin', '2022/06/25', 1);

ALTER TABLE bdjuego.usuario ADD CONSTRAINT FK1
FOREIGN KEY (id_tipo_usuario_fk)
REFERENCES bdjuego.tipo_usuario (id_tipo_usuario);

ALTER TABLE bdjuego.puntajes_usuario ADD CONSTRAINT FK2
FOREIGN KEY (id_usuario_fk)
REFERENCES bdjuego.usuario (id_usuario);

SELECT * FROM usuario;
SELECT * FROM tipo_usuario;
SELECT * FROM puntajes_usuario;



