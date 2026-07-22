-- Creación de una Base de Datos
CREATE DATABASE bd_formas;

-- Activación de una cierta Base de Datos
USE bd_formas

-- Creación de las tablas

-- Figuras
CREATE TABLE t_circulos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    radio DOUBLE
)

CREATE TABLE t_rectangulos (
   id INT PRIMARY KEY AUTO_INCREMENT,
   largo DOUBLE,
   ancho DOUBLE
)

CREATE TABLE t_cuadrados (
    id INT PRIMARY KEY AUTO_INCREMENT,
    lado DOUBLE
)

CREATE TABLE t_rombos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    lado DOUBLE,
    diagonal_mayor DOUBLE,
    diagonal_menor DOUBLE
)

-- Triángulos
CREATE TABLE t_equilateros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    lado DOUBLE
)

CREATE TABLE t_isosceles (
    id INT PRIMARY KEY AUTO_INCREMENT,
    lado_igual DOUBLE,
    lado_diferente DOUBLE
)

CREATE TABLE t_escalenos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    lado_1 DOUBLE,
    lado_2 DOUBLE,
    lado_3 DOUBLE,
)

-- Cuerpos
CREATE TABLE t_cilindros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    altura DOUBLE,
    id_tapa INT NOT NULL,
    id_costado INT NOT NULL,
    FOREIGN KEY (id_tapa) references t_circulos(id),
    FOREIGN KEY (id_costado) references t_rectangulos(id)
)

CREATE TABLE t_cubos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_cara INT NOT NULL,
    FOREIGN KEY (id_cara) references t_cuadrados(id)
)

CREATE TABLE t_tetraedro (
    id INT PRIMARY KEY AUTO_INCREMENT,
    altura DOUBLE,
    id_cara INT NOT NULL,
    FOREIGN KEY (id_cara) references t_equilateros(id)
)

CREATE TABLE t_esferas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    radio DOUBLE
)

