INSERT INTO products (name, description, price, quantity, image_url)
SELECT 'Bàn phím cơ AKKO 5075B', 'Bàn phím cơ layout gọn, gõ êm, hợp dev và gaming.', 1890000, 12, 'https://images.unsplash.com/photo-1587829741301-dc798b83add3?q=80&w=1200&auto=format&fit=crop'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Bàn phím cơ AKKO 5075B');

INSERT INTO products (name, description, price, quantity, image_url)
SELECT 'Chuột Logitech G Pro', 'Chuột không dây nhẹ, cảm biến tốt, pin khỏe.', 2490000, 8, 'https://images.unsplash.com/photo-1615663245857-ac93bb7c39e7?q=80&w=1200&auto=format&fit=crop'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Chuột Logitech G Pro');

INSERT INTO products (name, description, price, quantity, image_url)
SELECT 'Tai nghe HyperX Cloud', 'Tai nghe gaming âm thanh rõ, mic ổn, đeo thoải mái.', 1590000, 15, 'https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=1200&auto=format&fit=crop'
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Tai nghe HyperX Cloud');
