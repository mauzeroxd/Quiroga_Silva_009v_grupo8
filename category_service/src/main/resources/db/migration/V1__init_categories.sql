CREATE TABLE CATEGORIAS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    descripcion VARCHAR(255)
);

INSERT INTO CATEGORIAS (nombre, descripcion) VALUES 
('RPG', 'Juegos de rol'),
('ACCION', 'Juegos de mucha actividad y disparos'),
('DEPORTES', 'Simuladores deportivos');