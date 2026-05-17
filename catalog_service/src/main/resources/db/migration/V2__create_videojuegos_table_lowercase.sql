CREATE TABLE IF NOT EXISTS videojuegos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    genero VARCHAR(50),
    precio DECIMAL(10, 2),
    plataforma VARCHAR(50)
);
