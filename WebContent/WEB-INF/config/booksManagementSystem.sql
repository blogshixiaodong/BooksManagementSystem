`student``message`

CREATE DATABASE booksManagementSystem

USE booksManagementSystem

CREATE TABLE book(bid INT AUTO_INCREMENT
	PRIMARY KEY,
	bname VARCHAR(12),author VARCHAR(10),press VARCHAR(10),
	publicTime DATE );




CREATE TABLE booksManagementSystem.user(uid INT AUTO_INCREMENT
		 PRIMARY KEY,
		 username VARCHAR(12),
		 PASSWORD VARCHAR(12)
		 );

CREATE TABLE record(rid INT AUTO_INCREMENT
		    PRIMARY KEY,
		    uid INT(11) ,
		    bid INT(11) ,
		    borrowTime DATE,
		    returnTime DATE,
		    CONSTRAINT fk_bid FOREIGN KEY(bid) REFERENCES booksManagementSystem.book(bid),
		    CONSTRAINT fk_uid FOREIGN KEY(uid) REFERENCES booksManagementSystem.user(uid)
		    );

ALTER TABLE booksManagementSystem.book AUTO_INCREMENT = 50000
ALTER TABLE booksManagementSystem.user AUTO_INCREMENT = 10000



INSERT INTO booksManagementSystem.user(username,PASSWORD)VALUES("Tom","123");
INSERT INTO booksManagementSystem.user(username,PASSWORD)VALUES("Marry","123");
INSERT INTO booksManagementSystem.user(username,PASSWORD)VALUES("Sxd","456");
INSERT INTO booksManagementSystem.user(username,PASSWORD)VALUES("Join","123");
INSERT INTO booksManagementSystem.user(username,PASSWORD)VALUES("Uint","123");

#DELETE FROM book;
INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("C++从菜鸟到大神","M","清华大学出版社");
INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("Java入门","Aaron","北京大学出版社");
INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("J2ee开发","Abne","浙江大学出版社");
INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("数据结构","Benson","fjut出版社");
INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("编程指南","Gale","人民邮电出版社");






