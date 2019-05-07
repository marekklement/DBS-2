DROP TABLE IF EXISTS Works;

DROP TABLE IF EXISTS Piece;

DROP TABLE IF EXISTS DVD;

DROP TABLE IF EXISTS Follows;

DROP TABLE IF EXISTS Book_with_pages;

DROP TABLE IF EXISTS Librarian;

DROP TABLE IF EXISTS Item;

DROP TABLE IF EXISTS WorkDay;

DROP TABLE IF EXISTS Library_of;

DROP TABLE IF EXISTS Worker;

CREATE TABLE Worker (
  username VARCHAR(45) PRIMARY KEY ,
  firstName VARCHAR(45)    ,
  lastName VARCHAR(45)    ,
  salary INTEGER    ,
  address_of VARCHAR(45)
);

CREATE TABLE Library_of (
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

CREATE TABLE Librarian (
  workerUsername VARCHAR(45) PRIMARY KEY ,
  seat VARCHAR(45)      ,
  CONSTRAINT IC_workerUsername_FK FOREIGN KEY(workerUsername)
    REFERENCES Worker(username)
);

CREATE UNIQUE INDEX workerUsernameIndex ON Librarian (workerUsername);

CREATE TABLE Book_with_pages (
  itemSerialCode VARCHAR(45) PRIMARY KEY,
  year INTEGER,
  CONSTRAINT IC_itemSerialCodeBook_FK FOREIGN KEY(itemSerialCode)
    REFERENCES Item(serialNumber)
  );

CREATE UNIQUE INDEX itemSerialCodeBookIndex ON Book_with_pages (itemSerialCode);

CREATE TABLE Follows (
  previousBook VARCHAR(45) ,
  nextBook VARCHAR(45) ,
  CONSTRAINT IC_Follows_PK PRIMARY KEY (previousBook, nextBook),
  CONSTRAINT IC_previousBook_FK FOREIGN KEY(previousBook)
    REFERENCES Book_with_pages(itemSerialCode),
  CONSTRAINT IC_nextBook_FK FOREIGN KEY(nextBook)
    REFERENCES Book_with_pages(itemSerialCode)
);

CREATE INDEX previousBookIndex ON Follows (previousBook);
CREATE INDEX nextBookIndex ON Follows (nextBook);

CREATE TABLE DVD (
  itemSerialCode VARCHAR(45) PRIMARY KEY,
  original BOOLEAN,
  CONSTRAINT IC_itemSerialCodeDVD_FK FOREIGN KEY(itemSerialCode)
    REFERENCES Item(serialNumber)
);

CREATE UNIQUE INDEX itemSerialCodeDVDIndex ON DVD (itemSerialCode);

CREATE TABLE Piece (
  pieceNumber INTEGER,
  itemSerialCode VARCHAR(45),
  libraryName VARCHAR(45) CONSTRAINT IC_Piece_libraryName NOT NULL ,
  price INTEGER CONSTRAINT IC_Piece_Price NOT NULL,
  CONSTRAINT IC_Piece_PK PRIMARY KEY (pieceNumber, itemSerialCode),
  CONSTRAINT IC_itemSerialCodePiece_FK FOREIGN KEY(itemSerialCode)
    REFERENCES Item(serialNumber),
  CONSTRAINT IC_libraryNamePiece_FK FOREIGN KEY(libraryName)
    REFERENCES Library_of(name)
);

CREATE INDEX itemSerialCodePieceIndex ON Piece (itemSerialCode);
CREATE INDEX libraryNameIndex ON Piece (libraryName);

CREATE TABLE Works (
  dayDate DATE CHECK (dayDate >= '2019-01-01'),
  libraryName VARCHAR(45),
  librarian VARCHAR(45),
  CONSTRAINT IC_Works_PK PRIMARY KEY (dayDate, libraryName, librarian),
  CONSTRAINT IC_dayDateWorks_FK FOREIGN KEY(dayDate)
    REFERENCES WorkDay(dateWeek),
  CONSTRAINT IC_libraryNameWorks_FK FOREIGN KEY(libraryName)
    REFERENCES Library_of(name),
  CONSTRAINT IC_librarianWorks_FK FOREIGN KEY(librarian)
    REFERENCES Librarian(workerUsername)
);

CREATE INDEX dayDateIndex ON Works (dayDate);
CREATE INDEX libraryNameWorksIndex ON Works (libraryName);
CREATE INDEX librarianWorksIndex ON Works (librarian);