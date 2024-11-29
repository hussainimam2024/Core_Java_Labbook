-- Drop the customer table if it exists
DROP TABLE IF EXISTS book;

-- Recreate the customer table with the correct columns
CREATE TABLE IF NOT EXISTS customer (
                                        id SERIAL PRIMARY KEY,
                                        name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL CHECK (role IN ('CUSTOMER', 'ADMIN')),
    address TEXT,
    phone VARCHAR(15)
    );
CREATE TABLE categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

DROP TABLE IF EXISTS book;
CREATE TABLE IF NOT EXISTS book (
                                    id SERIAL PRIMARY KEY,
                                    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    category VARCHAR(255),
    price NUMERIC(10, 2) NOT NULL,
    stock_quantity INT NOT NULL
    );

CREATE TABLE IF NOT EXISTS cart (
                                    id SERIAL PRIMARY KEY,
                                    customer_id BIGINT NOT NULL,
                                    book_id BIGINT NOT NULL,
                                    quantity INT NOT NULL,
                                    FOREIGN KEY (customer_id) REFERENCES customer(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
    );

CREATE TABLE IF NOT EXISTS "order" (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY,
    delivery_address VARCHAR(255),
    order_date TIMESTAMP(6),
    status VARCHAR(255),
    customer_id BIGINT NOT NULL,
    PRIMARY KEY (id)
    );


CREATE TABLE IF NOT EXISTS order_item (
                                          id SERIAL PRIMARY KEY,
                                          order_id BIGINT NOT NULL,
                                          book_id BIGINT NOT NULL,
                                          quantity INT NOT NULL,
                                          FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
    );

CREATE TABLE IF NOT EXISTS categories (
                            id SERIAL PRIMARY KEY,
                            name VARCHAR(255) UNIQUE NOT NULL
);