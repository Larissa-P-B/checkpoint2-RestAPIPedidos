CREATE TABLE pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    client_name VARCHAR(255) NOT NULL,
    order_date DATE,
    total_value DECIMAL(10,2) NOT NULL
);

INSERT INTO pedidos (client_name, order_date, total_value)
VALUES ('Primeiro Pedido', CURRENT_DATE, 100.00);