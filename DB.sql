CREATE DATABASE BookDB
  DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci;
USE BookDB;
CREATE TABLE Author
(
AuthorID int NOT NULL AUTO_INCREMENT,
Name varchar(255) NOT NULL,
Age int NOT NULL,
Country varchar(255) NOT NULL,
PRIMARY KEY (AuthorID)
);
CREATE TABLE Book
(
ISBN varchar(255) NOT NULL,
Title varchar(255) NOT NULL,
AuthorID int NOT NULL,
Publisher varchar(255) NOT NULL,
PublishDate varchar(255) NOT NULL,
Price float(4,2) NOT NULL,
PRIMARY KEY (ISBN),
FOREIGN KEY (AuthorID) REFERENCES Author(AuthorID)
);
/* Examples Below */
INSERT INTO Author (Name, Age, Country) VALUES ('卡勒德·胡赛尼', 49, '美国');
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-208-06164-4', '追风筝的人', 1, '上海人民出版社', '2006-05-01', 21.70);
INSERT INTO Author (Name, Age, Country) VALUES ('易中天', 49, '中国');
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-533-93842-0', '易中天中华史第一部：中华根', 2, '浙江文艺出版社', '2013-12-22', 186.00);
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-533-93740-9', '易中天中华史总序：文明的意志与中华的位置', 2, '浙江文艺出版社', '2013-05-16', 12.00);

INSERT INTO Author (Name, Age, Country) VALUES ('东野圭吾', 56, '日本');
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-544-27087-8', '解忧杂货店', 3, '南海出版公司', '2014-05-01', 27.20);
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-122-15384-5', '神探伽利略', 3, '化学工业出版社', '2013-01-01', 16.80);
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-544-26623-9', '幻夜', 3, '南海出版公司', '2013-10-01', 28.90);
INSERT INTO Author (Name, Age, Country) VALUES ('唐纳德·克努特', 75, '美国');
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-111-30334-3', '计算机程序设计艺术', 4, '机械工业出版社', '2010-08-01', 69.00);
INSERT INTO Book (ISBN, Title, AuthorID, Publisher, PublishDate, Price) VALUES ('978-7-121-15553-6', '研究之美', 4, '电子工业出版社', '2012-01-01', 27.10);
SELECT * FROM Book WHERE AuthorID in (SELECT AuthorID FROM Author WHERE name LIKE "%唐纳德%");
SELECT * FROM Book WHERE TiTle LIKE "%计算机%";
