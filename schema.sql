CREATE DATABASE IF NOT EXISTS inventry_db;

USE inventry_db;

CREATE TABLE IF NOT EXISTS products(
    product_id INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DECIMAL(10,2),
    quantity INT
    );
