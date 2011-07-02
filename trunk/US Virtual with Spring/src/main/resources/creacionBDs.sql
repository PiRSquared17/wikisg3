DROP TABLE if exists Product;

CREATE TABLE Product (
  oid varchar(50) NOT NULL,
  productID varchar(50) NOT NULL,
  description varchar(250),
  price int NOT NULL,
PRIMARY KEY(OID));

INSERT INTO Product (OID, productID, description, price)   VALUES ('1', '1-161899M', 'Monitor', 150);

INSERT INTO Product (OID, productID, description, price)   VALUES ('2', '1-262399T', 'Teclado', 25);

INSERT INTO Product (OID, productID, description, price) 
  VALUES ('3', '1-663297R', 'Raton', 12);

INSERT INTO Product (OID, productID, description, price) 
  VALUES ('4', '1-164889C', 'CPU', 250);

DROP TABLE if exists Address;

CREATE TABLE Address (
  OID varchar(50) NOT NULL,
  city varchar(50) NOT NULL,
  email varchar(50),
  fax varchar(50),
  phone varchar(50),
  name varchar(50) NOT NULL,
  street varchar(50) NOT NULL,
  zipcode int NOT NULL,
PRIMARY KEY(OID));

DROP TABLE if exists CreditCard;

CREATE TABLE CreditCard (
  OID varchar(50) NOT NULL,
  holder varchar(50) NOT NULL,
  number varchar(50) NOT NULL,
  month int NOT NULL,
  year int NOT NULL,
PRIMARY KEY(OID));

DROP TABLE if exists Detail;

CREATE TABLE Detail (
 OID varchar(50) NOT NULL,
 orderOID varchar(50) NOT NULL,
 productOID varchar(50) NOT NULL,
 note varchar(250),
 quantity int NOT NULL,
PRIMARY KEY(OID));

DROP TABLE if exists Orders;

CREATE TABLE Orders (
  OID varchar(50) NOT NULL,
  orderID varchar(50) NOT NULL,
  addressOID varchar(50) NOT NULL,
  creditCardOID varchar(50) NOT NULL,
  timeplaced bigint NOT NULL,
  placedbycustomer varchar(50) NOT NULL,
PRIMARY KEY(OID));
