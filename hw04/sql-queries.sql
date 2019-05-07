DROP TABLE IF EXISTS Works;

DROP TABLE IF EXISTS Piece;

DROP TABLE IF EXISTS DVD;

DROP TABLE IF EXISTS FollowsAnother;

DROP TABLE IF EXISTS Book_with_pages;

DROP TABLE IF EXISTS LibrarianPerson;

DROP TABLE IF EXISTS Item;

DROP TABLE IF EXISTS WorkDay;

DROP TABLE IF EXISTS LibraryBulding;

DROP TABLE IF EXISTS WorkerPerson;

CREATE TABLE WorkerPerson (
  username VARCHAR(45) PRIMARY KEY ,
  firstName VARCHAR(45)    ,
  lastName VARCHAR(45)    ,
  salary INTEGER    ,
  address_of VARCHAR(45)
);

CREATE TABLE LibraryBulding (
  name VARCHAR(45) PRIMARY KEY,
  houseNumber INTEGER,
  street VARCHAR(45),
  city VARCHAR(45)
);

CREATE TABLE WorkDay (
  dateWeek DATE PRIMARY KEY ,
  name VARCHAR(45)
);

CREATE TABLE Item (
  serialNumber VARCHAR(45) PRIMARY KEY ,
  title VARCHAR(45),
  authorOfBook VARCHAR(45)
);

CREATE TABLE LibrarianPerson (
  workerUsername VARCHAR(45) PRIMARY KEY ,
  seat VARCHAR(45)      ,
  CONSTRAINT IC_workerUsername_FK FOREIGN KEY(workerUsername)
    REFERENCES WorkerPerson(username)
);

CREATE INDEX workerUsernameIndex ON LibrarianPerson (workerUsername);

CREATE TABLE Book_with_pages (
  itemSerialCode VARCHAR(45) PRIMARY KEY,
  year INTEGER,
  CONSTRAINT IC_itemSerialCodeBook_FK FOREIGN KEY(itemSerialCode)
    REFERENCES Item(serialNumber)
  );

CREATE INDEX itemSerialCodeBookIndex ON Book_with_pages (itemSerialCode);

CREATE TABLE FollowsAnother (
  previousBook VARCHAR(45) ,
  nextBook VARCHAR(45) ,
  CONSTRAINT IC_Follows_PK PRIMARY KEY (previousBook, nextBook),
  CONSTRAINT IC_previousBook_FK FOREIGN KEY(previousBook)
    REFERENCES Book_with_pages(itemSerialCode),
  CONSTRAINT IC_nextBook_FK FOREIGN KEY(nextBook)
    REFERENCES Book_with_pages(itemSerialCode)
);

CREATE INDEX previousBookIndex ON FollowsAnother (previousBook);
CREATE INDEX nextBookIndex ON FollowsAnother (nextBook);

CREATE TABLE DVD (
  itemSerialCode VARCHAR(45) PRIMARY KEY,
  original BOOLEAN,
  CONSTRAINT IC_itemSerialCodeDVD_FK FOREIGN KEY(itemSerialCode)
    REFERENCES Item(serialNumber)
);

CREATE INDEX itemSerialCodeDVDIndex ON DVD (itemSerialCode);

CREATE TABLE Piece (
  pieceNumber INTEGER,
  itemSerialCode VARCHAR(45),
  libraryName VARCHAR(45)   NOT NULL ,
  price INTEGER      ,
  CONSTRAINT IC_Piece_PK PRIMARY KEY (pieceNumber, itemSerialCode),
  CONSTRAINT IC_itemSerialCodePiece_FK FOREIGN KEY(itemSerialCode)
    REFERENCES Item(serialNumber),
  CONSTRAINT IC_libraryNamePiece_FK FOREIGN KEY(libraryName)
    REFERENCES LibraryBulding(name)
);

CREATE INDEX itemSerialCodePieceIndex ON Piece (itemSerialCode);
CREATE INDEX libraryNameIndex ON Piece (libraryName);

CREATE TABLE Works (
  dayDate DATE,
  libraryName VARCHAR(45),
  librarian VARCHAR(45),
  CONSTRAINT IC_Works_PK PRIMARY KEY (dayDate, libraryName, librarian),
  CONSTRAINT IC_dayDateWorks_FK FOREIGN KEY(dayDate)
    REFERENCES WorkDay(dateWeek),
  CONSTRAINT IC_libraryNameWorks_FK FOREIGN KEY(libraryName)
    REFERENCES LibraryBulding(name),
  CONSTRAINT IC_librarianWorks_FK FOREIGN KEY(librarian)
    REFERENCES LibrarianPerson(workerUsername)
);

CREATE INDEX dayDateIndex ON Works (dayDate);
CREATE INDEX libraryNameWorksIndex ON Works (libraryName);
CREATE INDEX librarianWorksIndex ON Works (librarian);

--
--  JUST HELPFUL INSERTS FOR MY PERSONAL TESTING
--
INSERT INTO Item (serialNumber, title, authorOfBook)
    VALUES ('E25879','Bajecna leta pod psa', 'Michal Viewegh'),
      ('E25878','Jaromir Jagr a his life', 'Jaromir Jagr'),
      ('E6987','Behejme slusne', 'Jaromir Jagr'),
      ('A23','Bible', 'Pan Buh'),
      ('E89898','Kamasutra', 'Velky Spatny'),
      ('DVD0001','Incredibles', 'Studio Pixar'),
      ('DVD0002','Incredibles 2', 'Studio Pixar');


INSERT INTO WorkDay (dateWeek, name)
    VALUES ('2018-09-11','w'),
      ('2018-09-12','w'),
      ('2018-09-13','w'),
      ('2018-09-14','w'),
      ('2018-09-15','w'),
      ('2018-09-16','n'),
      ('2018-09-10','n'),
      ('2018-09-17','n');

INSERT INTO  WorkerPerson (username, firstName, lastName, salary, address_of)
    VALUES ('klemema4', 'Marek', 'Klement',5865,'Nad Borislavkou 42, Praha 6'),
    ('krabak001', 'Petr', 'Krabsky',6000,'Pod Borislavkou 42, Praha 6'),
    ('arnold55', 'Arnold', 'Tyz',7000,'U Borislavkou 42, Praha 6'),
    ('stepan564', 'Petr', 'Stepan',8000,'V Borislavkou 42, Praha 6'),
    ('kulian478', 'Alexander', 'Kulianovic',7000,'Nad Borislavkou 42, Praha 6'),
    ('kanabra26', 'Katrin', 'Nabravska',6500,'Nad Borislavkou 42, Praha 6'),
    ('paruka29', 'Pavel', 'Ruka',2200,'Nad Borislavkou 42, Praha 6'),
    ('kluzka233', 'Vojtech', 'Kluzka',8796,'V Borislavkou 42, Praha 6'),
    ('maruska2255', 'Marie', 'Hezka',500,'U Neapole 6, Praha 6'),
    ('milada001', 'Milada', 'Nevdecna',600,'V Bani 88, Praha 6');

INSERT INTO  LibrarianPerson (workerUsername, seat)
     VALUES ('klemema4', 'Kopirka 55'),
     ('krabak001', 'kancl001'),
     ('arnold55',  'kancl001'),
     ('stepan564',  'kancl002'),
     ('kulian478',  'kancl003'),
     ('kanabra26',  'kancl004'),
     ('paruka29',  'kancl005'),
     ('kluzka233',  'kancl006');

INSERT INTO  Book_with_pages (itemSerialCode, year)
    VALUES ('E25879', 1999),
      ('E25878', 1999),
      ('E6987', 2005),
      ('A23', 2018),
      ('E89898', 956);

INSERT INTO  FollowsAnother (previousBook, nextBook)
    VALUES ('E25878', 'E6987');

INSERT INTO  DVD (itemSerialCode, original)
    VALUES ('DVD0001', true),
      ('DVD0002', false);

INSERT INTO  LibraryBulding (name, houseNumber, street, city)
    VALUES ('Velka', 25, 'Prazska', 'Praha'),
      ('Mala', 12, 'Obchodni', 'Jicin'),
      ('Stredni', 25, 'Borivojova', 'Decin'),
      ('Mestska', 25, 'Prazska', 'Praha'),
      ('Narodni', 25, 'Prazska', 'Praha');

INSERT INTO  Piece (pieceNumber, itemSerialCode, libraryName, price)
    VALUES (1,'E25879', 'Velka', 100),
      (2,'E25879', 'Velka', 200),
      (3,'E25879', 'Velka', 100),
      (1,'A23', 'Velka', 350),
      (1,'E89898', 'Velka', 850),
      (1,'DVD0001', 'Velka', 850),
      (1,'DVD0002', 'Velka', 850);



INSERT INTO Works (dayDate, libraryName, librarian)
VALUES ('2018-09-12','Velka','krabak001'),
      ('2018-09-13','Velka','arnold55'),
      ('2018-09-14','Velka','stepan564'),
      ('2018-09-15','Velka','kulian478'),
      ('2018-09-16','Velka','kanabra26'),
      ('2018-09-17','Velka','paruka29'),
      ('2018-09-10','Velka','kluzka233');

--
--  DATA QUERYING (HW04)
--

-- This will count all prints of each book and than show all books which have year release greater than 1900. It is gouped by title first and than year. Ordered by year.
SELECT count(P) as Number_of_pieces, Item.title, Bwp.year
FROM Item
JOIN Piece P ON P.itemSerialCode = Item.serialNumber
JOIN Book_with_pages Bwp on Item.serialNumber = Bwp.itemSerialCode
WHERE Bwp.year>1900
GROUP BY title, year
ORDER BY year;

-- Shows all librarians that works this week
SELECT W.username
FROM WorkerPerson W
WHERE W.username IN (SELECT wks.librarian
                FROM Works wks
                WHERE wks.dayDate >= '2018-09-11' AND  wks.dayDate <='2018-09-17');

-- Shows all items except those DVDs which are not original
SELECT Item.title, Piece.libraryName, Piece.price
FROM Piece
JOIN Item ON Item.serialNumber = Piece.itemSerialCode
EXCEPT
SELECT Item.title, Piece.libraryName, Piece.price
FROM Piece
JOIN Item ON Item.serialNumber = Piece.itemSerialCode
NATURAL JOIN DVD
WHERE NOT DVD.original;

-- Shows all workers when they work, even when they don't
SELECT LibrarianPerson.workerUsername, Works.dayDate, LibraryBulding.name, LibraryBulding.houseNumber, LibraryBulding.street, LibraryBulding.city
FROM LibrarianPerson
LEFT OUTER JOIN Works ON Works.librarian = LibrarianPerson.workerUsername
LEFT OUTER JOIN LibraryBulding ON Works.libraryName = LibraryBulding.name;

-- Shows all items not written by Jaromir Jagr where there are more pieces available
SELECT Item.title
FROM Item
WHERE Item.authorOfBook NOT IN ('Jaromir Jagr')
INTERSECT
SELECT Item.title
FROM Item
JOIN Piece P on P.itemSerialCode = Item.serialNumber
GROUP BY Item.title
HAVING count(P) > 1;