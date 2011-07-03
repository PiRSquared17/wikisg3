DROP TABLE if exists Product;

CREATE TABLE Product (
  id int NOT NULL AUTO_INCREMENT,
  description varchar(250),
  price int NOT NULL,
PRIMARY KEY(id));

INSERT INTO Product (description, price) VALUES ('Monitor', 150);

INSERT INTO Product (description, price) VALUES ('Teclado', 25);

INSERT INTO Product (description, price) VALUES ('Raton', 12);

INSERT INTO Product (description, price) VALUES ('CPU', 250);

DROP TABLE if exists Address;

CREATE TABLE Address (
  id int NOT NULL AUTO_INCREMENT,
  city varchar(50) NOT NULL,
  email varchar(50),
  fax varchar(50),
  phone varchar(50),
  name varchar(50) NOT NULL,
  street varchar(50) NOT NULL,
  zipcode int NOT NULL,
PRIMARY KEY(id));

DROP TABLE if exists CreditCard;

CREATE TABLE CreditCard (
  id int NOT NULL AUTO_INCREMENT,
  holder varchar(50) NOT NULL,
  number varchar(50) NOT NULL,
  month int NOT NULL,
  year int NOT NULL,
PRIMARY KEY(id));

DROP TABLE if exists Detail;

CREATE TABLE Detail (
 id int NOT NULL AUTO_INCREMENT,
 orderId int NOT NULL,
 productId int NOT NULL,
 note varchar(250),
 quantity int NOT NULL,
PRIMARY KEY(id));

DROP TABLE if exists Orders;

CREATE TABLE Orders (
  id int NOT NULL AUTO_INCREMENT,
  addressId int NOT NULL,
  cardId int NOT NULL,
  timeplaced bigint NOT NULL,
  placedbycustomer varchar(50) NOT NULL,
PRIMARY KEY(id));
