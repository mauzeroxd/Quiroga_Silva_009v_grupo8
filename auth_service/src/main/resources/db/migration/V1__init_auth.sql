CREATE TABLE tipos_usuario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_tipo VARCHAR(20) NOT NULL,
    descripcion VARCHAR(100)
);

CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    tipo_id INT,
    CONSTRAINT fk_user_tipo FOREIGN KEY (tipo_id) REFERENCES tipos_usuario(id)
);

INSERT INTO tipos_usuario (nombre_tipo, descripcion) VALUES ('ADMIN', 'Administrador'), ('CLIENTE', 'Cliente');