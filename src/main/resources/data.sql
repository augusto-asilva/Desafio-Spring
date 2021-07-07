DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS USERFOLLOWER;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS POSTS;

CREATE TABLE USERS
(
    id   INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250)
);

INSERT INTO USERS (id, name)
VALUES (0, 'Bill Gates'),
       (1, 'Mark Zuckerberg'),
       (2, 'Angelina Jolie');

CREATE TABLE USERFOLLOWER
(
    user_id      INT,
    following_id INT,
    PRIMARY KEY (user_id, following_id),
    FOREIGN KEY (user_id) REFERENCES USERS (id),
    FOREIGN KEY (following_id) REFERENCES USERS (id)
);

-- INSERT INTO USERFOLLOWER (user_id, following_id) VALUES
--   (1, 0),
--   (1, 2),
--   (0, 2),
--   (2, 0);

CREATE TABLE PRODUCTS
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(250),
    type  VARCHAR(250),
    brand VARCHAR(250),
    color VARCHAR(250),
    notes VARCHAR(250)
);

INSERT INTO PRODUCTS (id, name, type, brand, color, notes)
VALUES (0, 'Bicicleta', 'Corrida', 'Caloi', 'Red', 'Bicicleta para Corrida'),
       (1, 'Headset RGB Inalámbrico', 'Gamer', 'Razer', 'Green with RGB', 'Sin Bateria'),
       (2, 'Cadeira Gamer', 'Gamer', 'Racer', 'Red & Black', 'Special Edition'),
       (3, 'MacBook Pro', 'Computing', 'Apple', 'Silver', 'touch screen');


CREATE TABLE POSTS
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    date       date,
    product_id INT,
    user_id    INT,
    FOREIGN KEY (user_id) REFERENCES USERS (id),
    FOREIGN KEY (product_id) REFERENCES PRODUCTS (id)
);


INSERT INTO POSTS (id, date, product_id, user_id)
VALUES (0, '2021-07-05', 0, 1),
       (1, '2021-07-06', 1, 0);
    