CREATE TABLE PERFILES (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    nickname VARCHAR(50),
    avatar_url VARCHAR(255),
    nivel INT DEFAULT 1
);