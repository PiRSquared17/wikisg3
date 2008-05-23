DROP DATABASE IF EXISTS isg3;
CREATE DATABASE isg3;


DROP TABLE IF EXISTS isg3.Category;

CREATE TABLE `isg3`.`Category` (
`oid` VARCHAR( 30 ) NOT NULL ,
`name` VARCHAR( 20 ) NOT NULL ,
`description` TEXT NOT NULL ,
PRIMARY KEY ( `oid` ) ,
UNIQUE (`name`)
);

INSERT INTO isg3.Category VALUES('1C','Deportes','Categoria de deportes');
INSERT INTO isg3.Category VALUES('2C','Ciencia','Categoria de cienca');
INSERT INTO isg3.Category VALUES('3C','Cine','Categoria de cine');
INSERT INTO isg3.Category VALUES('4C','Sociedad','Categoria de sociedad');
INSERT INTO isg3.Category VALUES('5C','Tecnologia','Categoria de tecnologia');
INSERT INTO isg3.Category VALUES('6C','Sucesos','Categoria de sucesos');
INSERT INTO isg3.Category VALUES('7C','Historia','Categoria de historia');

DROP TABLE IF EXISTS isg3.Article;

CREATE TABLE isg3.Article (
oid VARCHAR(30) NOT NULL,
title VARCHAR(20) NOT NULL,
content TEXT NOT NULL,
lastRevision DATE NOT NULL,
visits INT(11),
categoryOID VARCHAR(30),
PRIMARY KEY (oid),
UNIQUE (title),
FOREIGN KEY (categoryOID) REFERENCES isg3.Category(oid)
);

INSERT INTO isg3.Article VALUES('8A','Sevilla F. C.','El mejor equipo del mundo', NOW(), 0, '1C');
INSERT INTO isg3.Article VALUES('9A','El padrino','Gran película sobre la cosa nostra', NOW(), 0, '3C');
INSERT INTO isg3.Article VALUES('10A','Tabla periodica','El conjunto de elementos', NOW(), 0, '2C');
INSERT INTO isg3.Article VALUES('11A','F. C. Barcelona','Tot el camp es un clam', NOW(), 0, '1C');

DROP TABLE IF EXISTS isg3.User;

CREATE TABLE isg3.User(
oid VARCHAR(30) NOT NULL,
nick VARCHAR(20) NOT NULL,
pass VARCHAR(20) NOT NULL,
mail VARCHAR(30) NOT NULL,
registeredDate DATE NOT NULL,
PRIMARY KEY (oid),
UNIQUE (nick)
);

INSERT INTO isg3.User VALUES('1U','practica','practica','practica@us.es',NOW());
INSERT INTO isg3.User VALUES('2U','jesus','practica','jesus@us.es',NOW());
INSERT INTO isg3.User VALUES('3U','alberto','practica','alberto@us.es',NOW());


DROP TABLE IF EXISTS isg.UserArticle;

CREATE TABLE isg3.UserArticle(
oid VARCHAR(30) NOT NULL,
userOID VARCHAR(30) NOT NULL,
articleOID VARCHAR(30) NOT NULL,
PRIMARY KEY (oid),
FOREIGN KEY (userOID) REFERENCES isg3.User(oid),
FOREIGN KEY (articleOID) REFERENCES isg3.Article(oid)
);

INSERT INTO isg3.UserArticle VALUES('1UA','1U','8A');
INSERT INTO isg3.UserArticle VALUES('2UA','2U','8A');
INSERT INTO isg3.UserArticle VALUES('3UA','3U','9A');
INSERT INTO isg3.UserArticle VALUES('4UA','1U','10A');
INSERT INTO isg3.UserArticle VALUES('5UA','1U','11A');



DROP TABLE IF EXISTS isg3.Rate;

CREATE TABLE isg3.Rate(
oid VARCHAR(30) NOT NULL,
articleOID VARCHAR(30) NOT NULL,
userOID VARCHAR(30) NOT NULL,
rate INT(2),
reason VARCHAR(100),
PRIMARY KEY (oid),
UNIQUE (articleOID,userOID),
FOREIGN KEY(articleOID) REFERENCES isg3.Article(oid),
FOREIGN KEY(userOID) REFERENCES isg3.User(oid)
);


DROP TABLE IF EXISTS isg3.Message;

CREATE TABLE isg3.Message(
oid VARCHAR(30) NOT NULL,
senderUserOID VARCHAR(30) NOT NULL,
receiverUserOID VARCHAR(30) NOT NULL,
subject VARCHAR(50) NOT NULL,
content TEXT NOT NULL,
dateSend DATE,
PRIMARY KEY (oid),
FOREIGN KEY(senderUserOID) REFERENCES isg3.User(oid),
FOREIGN KEY(receiverUserOID) REFERENCES isg3.User(oid)
);