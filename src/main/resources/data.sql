-- Insert predefined products
INSERT INTO products (code, name, price_eur, price_usd, description)
VALUES ('SMSGALAXYS23001', 'Samsung Galaxy S23', 899.99, 980.00, 'The latest Samsung flagship smartphone with advanced camera system');

INSERT INTO products (code, name, price_eur, price_usd, description)
VALUES ('APPLEIPHONE1500', 'iPhone 15', 999.99, 1090.00, 'Apple''s premium smartphone with iOS and powerful A16 chip');

INSERT INTO products (code, name, price_eur, price_usd, description)
VALUES ('XIAOMI13PRO003', 'Xiaomi 13 Pro', 799.99, 870.00, 'Xiaomi flagship with Leica optics and Snapdragon processor');

INSERT INTO products (code, name, price_eur, price_usd, description)
VALUES ('APPLIPHONESE004', 'iPhone SE', 499.99, 545.00, 'Compact and affordable iPhone with powerful performance');

INSERT INTO products (code, name, price_eur, price_usd, description)
VALUES ('GOOGLEPIXEL005', 'Google Pixel 7', 699.99, 760.00, 'Google''s smartphone with excellent camera and pure Android experience');

-- Insert predefined reviews
-- Samsung Galaxy S23 reviews
INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (1, 'John Doe', 'Great phone with excellent camera quality!', 5);

INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (1, 'Jane Smith', 'Good battery life, but a bit expensive.', 4);

INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (1, 'Logan Smith', 'Good battery life, but a bit expensive.', 5);

-- iPhone 15 reviews
INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (2, 'Michael Brown', 'Excellent build quality and performance.', 5);

INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (2, 'Emily Wilson', 'iOS is smooth, but I miss some Android features.', 4);

-- Xiaomi 13 Pro reviews
INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (3, 'David Johnson', 'Great value for the features offered.', 5);

INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (3, 'Sarah Thompson', 'Camera quality could be better for the price.', 4);

-- iPhone SE reviews
INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (4, 'Robert Clark', 'Perfect size with great performance!', 5);

INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (4, 'Lisa Martinez', 'Excellent value for an iPhone.', 5);

-- Google Pixel 7 reviews
INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (5, 'James Anderson', 'Best camera on a smartphone!', 5);

INSERT INTO reviews (product_id, reviewer, text, rating)
VALUES (5, 'Patricia Thomas', 'Clean Android experience but battery life could be better.', 4);