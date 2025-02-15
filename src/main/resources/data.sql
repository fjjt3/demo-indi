-- Insert sample data into the "prices" table
INSERT INTO prices (brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES
(1, '2023-10-01 00:00:00', '2023-10-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),  -- Tarifa 1 para Zara, producto 35455
(1, '2023-10-01 00:00:00', '2023-10-14 23:59:59', 2, 35455, 1, 25.45, 'EUR'),  -- Tarifa 2 para Zara, producto 35455 (mayor prioridad)
(1, '2023-10-15 00:00:00', '2023-10-31 23:59:59', 3, 35455, 1, 30.50, 'EUR'),  -- Tarifa 3 para Zara, producto 35455 (mayor prioridad)
(1, '2023-10-01 00:00:00', '2023-10-31 23:59:59', 4, 35455, 0, 38.95, 'EUR'),  -- Tarifa 4 para Zara, producto 35455
(1, '2023-10-01 00:00:00', '2023-10-31 23:59:59', 1, 35456, 0, 50.00, 'EUR'),  -- Tarifa 1 para Zara, producto 35456
(1, '2023-10-15 00:00:00', '2023-10-25 23:59:59', 2, 35456, 1, 45.00, 'EUR'),  -- Tarifa 2 para Zara, producto 35456 (mayor prioridad)
(2, '2023-10-01 00:00:00', '2023-10-31 23:59:59', 1, 35455, 0, 40.00, 'EUR');  -- Tarifa 1 para otra cadena (brand_id = 2), producto 35455
