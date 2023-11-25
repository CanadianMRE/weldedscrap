DROP DATABASE IF EXISTS welded_scrap;
CREATE DATABASE welded_scrap;

USE welded_scrap;

DROP TABLE IF EXISTS ORDERS;
DROP TABLE IF EXISTS PRODUCTS_USERS_LINK;
DROP TABLE IF EXISTS PRODUCTS;
DROP TABLE IF EXISTS USERS;
DROP TABLE IF EXISTS ROLES;

CREATE TABLE ROLES (
  roleId INT(8) NOT NULL,
  name VARCHAR(20) NOT NULL,
  PRIMARY KEY (roleId)
);

CREATE TABLE USERS (
    userId INT AUTO_INCREMENT NOT NULL,
    firstName VARCHAR(45) DEFAULT NULL,
    lastName VARCHAR(45) DEFAULT NULL,
    email VARCHAR(45) DEFAULT NULL,
    password VARCHAR(45) DEFAULT NULL,
    address VARCHAR(45) DEFAULT NULL,
    roleId INT DEFAULT NULL,
    PRIMARY KEY (userid),
    FOREIGN KEY (roleId) REFERENCES ROLES(roleId)
);

CREATE TABLE PRODUCTS (
    productId VARCHAR(50) NOT NULL,
    PRIMARY KEY (productId)
);

CREATE TABLE PRODUCTS_USERS_LINK (
    productId VARCHAR(50) NOT NULL,
    userId INT AUTO_INCREMENT NOT NULL,
    PRIMARY KEY (productId, userId),
    FOREIGN KEY (productId) REFERENCES PRODUCTS(productId),
    FOREIGN KEY (userId) REFERENCES USERS(userId)
);

CREATE TABLE ORDERS (
    orderId INT NOT NULL,
    completed INT(1) NOT NULL,
    orderDate DATE NOT NULL,
    paymentId VARCHAR(50) NOT NULL,
    userId INT NOT NULL,
    PRIMARY KEY (orderId),
    FOREIGN KEY (userId) REFERENCES USERS(userId)
);


INSERT INTO ROLES VALUES (1, 'System Admin');
INSERT INTO ROLES VALUES (2, 'Regular User');

INSERT INTO USERS
VALUES
    (1, 'Gurshaan', 'Gill', 'gurshaan-gill@hotmail.com','password','123 up your street',1),
    (2, 'John', 'Doe', 'johndoe@example.com', 'password', '123 Main St', 2),
    (3, 'Alice', 'Smith', 'alicesmith@example.com', 'password', '456 Elm St', 2),
    (4, 'Bob', 'Johnson', 'bj@example.com', 'password', '789 Oak St', 2),
    (5, 'John', 'Madden', 'johnmadden@example.com', 'password', '69 Football Ave', 2),
    (6, 'Walter', 'White', 'notheisenberg@example.com', 'password', '208 Negra Arroya Lane', 2);