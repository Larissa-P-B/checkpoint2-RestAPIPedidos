CREATE TABLE pedidos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cliente_nome VARCHAR(255) NOT NULL,
    pedido_data DATE,
    valor_total DECIMAL(10,2) NOT NULL
);

INSERT INTO pedidos (cliente_nome, pedido_data, valor_total)
VALUES ('Primeiro Pedido', CURRENT_DATE, 100.00);



