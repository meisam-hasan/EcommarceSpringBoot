-- Create User table
CREATE TABLE IF NOT EXISTS users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Create Product table
CREATE TABLE IF NOT EXISTS products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

-- Create Order table
CREATE TABLE IF NOT EXISTS orders (
    id SERIAL PRIMARY KEY,
    order_date TIMESTAMP NOT NULL,
    user_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Create OrderProduct table
CREATE TABLE IF NOT EXISTS order_products (
    id SERIAL PRIMARY KEY,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL,
    price_per_unit DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Create Wishlist table
CREATE TABLE IF NOT EXISTS wishlists (
    id SERIAL PRIMARY KEY,
    user_id INT NOT NULL,
    product_id INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (product_id) REFERENCES products(id)
);

-- Insert ten users into the users table
INSERT INTO users (username, email)
VALUES
    ('user1', 'user1@example.com'),
    ('user2', 'user2@example.com'),
    ('user3', 'user3@example.com'),
    ('user4', 'user4@example.com'),
    ('user5', 'user5@example.com'),
    ('user6', 'user6@example.com'),
    ('user7', 'user7@example.com'),
    ('user8', 'user8@example.com'),
    ('user9', 'user9@example.com'),
    ('user10', 'user10@example.com');


-- Insert ten additional products
INSERT INTO products (name, price) VALUES
('Product G', 14.99),
('Product H', 18.49),
('Product I', 7.99),
('Product J', 22.99),
('Product K', 11.49),
('Product L', 16.99),
('Product M', 19.99),
('Product N', 13.49),
('Product O', 8.99),
('Product P', 25.99);

-- Insert orders for the current and previous month, each day has multiple orders
WITH recursive dates AS (
    SELECT CURRENT_DATE - 30 AS date
    UNION ALL
    SELECT date + 1 FROM dates WHERE date < CURRENT_DATE
)
INSERT INTO orders (order_date, user_id)
SELECT 
    d.date + INTERVAL '8 hour' + INTERVAL '30 minute' + INTERVAL '1 hour' * floor(random() * 24) + INTERVAL '1 minute' * floor(random() * 60),
    u.id
FROM dates d
CROSS JOIN LATERAL (SELECT id FROM users ORDER BY random() LIMIT 1) u
CROSS JOIN generate_series(1, 500) s;

-- Insert products for each order
INSERT INTO order_products (order_id, product_id, quantity, price_per_unit)
SELECT
    o.id,
    floor(random() * 10) + 1 as product_id,
    floor(random() * 5) + 1 as quantity,
    (SELECT price FROM products p ORDER BY random() LIMIT 1) as price_per_unit
FROM orders o;

-- Insert 100 wishlist items for 10 users
INSERT INTO wishlists (user_id, product_id)
SELECT
    u.id,
    p.id
FROM (SELECT id FROM products ORDER BY random() LIMIT 100) p
CROSS JOIN LATERAL (SELECT id FROM users ORDER BY random() LIMIT 10) u;
