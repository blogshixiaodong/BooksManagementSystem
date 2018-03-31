

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
INSERT INTO booksManagementSystem.user(uid,username,PASSWORD,sex,age,balance,is_freeze)VALUES("1","admin","1","男",25,20,0);

INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Tom","123","男",25,20,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Marry","123","女",16,15,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Sxd","123","男",20,12,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Join","123","女",13,5,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Uint","123","女",14,12,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Addy","123","男",29,21,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Josion","123","女",16,2,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Jony","123","女",31,2,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Pxia","123","男",20,12,0);
INSERT INTO booksManagementSystem.user(username,PASSWORD,sex,age,balance,is_freeze)VALUES("Garry","123","女",22,6,0);



#图书表记录
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("C++从菜鸟到大神","M","清华大学出版社","1996-11-14",0);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("Java入门","Aaron","北京大学出版社","1998-11-15",0);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("J2ee开发","Abne","浙江大学出版社","2001-10-15",3);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("数据结构","Benson","fjut出版社","1992-11-16",2);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("编程指南","Emma","电子工业出版社","2006-05-14",7);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("编程指南","Gloria","电子出版社","2001-02-22",7);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("高等数学","Jessie","人民出版社","2003-10-21",7);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("考研英语","Abby","西安出版社","2014-5-14",7);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("物理实验指导","Colin","邮电出版社","2008-08-06",7);
INSERT INTO booksManagementSystem.book(bname,author,press,publishTime,stock)VALUES("编程之美","Bella","XX出版社","2006-03-14",3);


#借阅归还记录`booksmanagementsystem`
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10000,50000,"2018-02-20");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10000,50001,"2018-02-19");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10001,50002,"2018-03-01");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10001,50003,"2018-03-10");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10002,50001,"2018-02-15");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10000,50005,"2018-02-11");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10003,50003,"2018-03-16");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10003,50008,"2018-03-14");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10004,50006,"2018-03-23");
INSERT INTO booksManagementSystem.record(uid,bid,borrowTime)VALUES(10004,50007,"2018-03-24");


###########-----test
SELECT * FROM BOOK
SELECT * FROM booksmanagementsystem.user;
SELECT * FROM record;

DROP TABLE book;
DROP TABLE record;
DROP TABLE USER
TIMESTAMPDIFF(DAY,'2011-09-30','2015-05-04');

SELECT TIMESTAMPDIFF(DAY,BORROWTIME,NOW()) NUM FROM RECORD WHERE UID = 10000 AND BID = 50000

SELECT BNAME,AUTHOR,PRESS,BORROWTIME,TIMESTAMPDIFF(DAY,BORROWTIME,NOW()) DAY FROM RECORD,BOOK WHERE BOOK.BID = RECORD.BID AND UID = 10000 AND RETURNTIME IS NULL

SELECT  COUNT(TIMESTAMPDIFF(DAY,BORROWTIME,NOW()) > 60) NUM FROM RECORD WHERE RETURNTIME IS NULL AND UID = 10000

SELECT  COUNT(*) NUM FROM RECORD WHERE RETURNTIME IS NULL AND UID = 10000 AND TIMESTAMPDIFF(DAY,BORROWTIME,NOW())>60

SELECT  TIMESTAMPDIFF(DAY,BORROWTIME,NOW() ) NUM FROM RECORD WHERE RETURNTIME IS NULL AND UID = 10000

UPDATE BOOK SET STOCK = STOCK  + 1 WHERE BID = 50000

SELECT * FROM book WHERE stock >0 LIMIT 1,3

SELECT * FROM BOOK WHERE 1=1 AND bname = '%C++%' 

SELECT * FROM BOOK WHERE 1=1 AND bname LIKE '%C++%' 
UPDATE BOOK SET STOCK = 0 WHERE BID = 50002
##########------test

 





