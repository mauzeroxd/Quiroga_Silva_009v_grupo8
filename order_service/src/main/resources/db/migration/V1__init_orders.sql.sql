CREATE TABLE PEDIDOS (
    id INT PRIMARY KEY AUTO_INCREMENT,
    usuario_id INT NOT NULL,
    juego_id INT NOT NULL,
    fecha_pedido DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    estado VARCHAR(20) NOT NULL
);

-- Datos de prueba (opcionales)
-- INSERT INTO PEDIDOS (usuario_id, juego_id, total, estado) VALUES (1, 1, 45000.00, 'COMPLETADO');