

CREATE DATABASE booksManagementSystem

USE booksManagementSystem

# 图书表
CREATE TABLE book(
		bid INT AUTO_INCREMENT PRIMARY KEY,
		bname VARCHAR(12) NOT NULL,
		author VARCHAR(10) NOT NULL,
		press VARCHAR(10) NOT NULL,
		stock INT NOT NULL,
		publishTime DATE NOT NULL
		);



#用户表
CREATE TABLE booksManagementSystem.user(
		 uid INT AUTO_INCREMENT PRIMARY KEY,
		 username VARCHAR(12) NOT NULL,
		 PASSWORD VARCHAR(12) NOT NULL,
		 sex VARCHAR(10) NOT NULL,
		 age INT NOT NULL,
		 balance FLOAT,
		 is_freeze INT
		 );

#借阅归还记录表
CREATE TABLE record(
		    rid INT AUTO_INCREMENT PRIMARY KEY,
		    uid INT(11) ,
		    bid INT(11) ,
		    borrowTime DATE,
		    returnTime DATE DEFAULT NULL,
		    flag INT DEFAULT 0,  ## 1->归还   0->未归还
		    CONSTRAINT fk_bid FOREIGN KEY(bid) REFERENCES booksManagementSystem.book(bid),
		    CONSTRAINT fk_uid FOREIGN KEY(uid) REFERENCES booksManagementSystem.user(uid)
		    );
		    
		    
#起始记录号		    
ALTER TABLE booksManagementSystem.book AUTO_INCREMENT = 50000;
ALTER TABLE booksManagementSystem.user AUTO_INCREMENT = 10000;
ALTER TABLE booksmanagementsystem.record AUTO_INCREMENT = 80000;


#用户表记录
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Tom","123","男",25,20,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Marry","123","女",16,15,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Sxd","456","男",20,12,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Join","123","女",13,5,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Uint","123","女",16,2,0);


#图书表记录
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("C++从菜鸟到大神","M","清华大学出版社","1996-11-14",15);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("Java入门","Aaron","北京大学出版社","1998-11-15",4);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("J2ee开发","Abne","浙江大学出版社","2001-10-15",3);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("数据结构","Benson","fjut出版社","2002-11-16",5);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("编程指南","Gale","人民邮电出版社","2006-05-14",7);


#借阅归还记录
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10000,50000,"2018-3-28");


###########-----test
SELECT * FROM BOOK
SELECT * FROM booksmanagementsystem.user;
SELECT * FROM record;

DROP TABLE book;
DROP TABLE record;

SELECT * FROM book WHERE publishTime = '2015-01-12'



INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("1111","1111","1111");
INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("2222","2222","2222");
INSERT INTO booksManagementSystem.book(bname,author,press)VALUES("3333","2222","2222");

INSERT INTO booksManagementSystem.book(bname,author)VALUES("","2222");

UPDATE book SET bname = NULL WHERE bid = 1

SELECT * FROM record WHERE returnTime IS NOT NULL;

##########------test

 





