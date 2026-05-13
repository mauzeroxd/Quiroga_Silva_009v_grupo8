CREATE TABLE STOCK_KEYS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    juego_id INT NOT NULL,
    codigo_key VARCHAR(100) UNIQUE NOT NULL,
    vendido TINYINT(1) DEFAULT 0
);

-- Insertar llaves de prueba (asumiendo que el juego 1 existe)
INSERT INTO STOCK_KEYS (juego_id, codigo_key, vendido) VALUES (1, 'ABCD-1234-EFGH', 0);
INSERT INTO STOCK_KEYS (juego_id, codigo_key, vendido) VALUES (1, 'XYZZ-9999-WXYZ', 0);