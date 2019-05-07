DROP TABLE IF EXISTS LIBRARIES_WORKERS;

DROP TABLE IF EXISTS PIECE;

DROP TABLE IF EXISTS DVD;

DROP TABLE IF EXISTS BOOK_ITEM;

DROP TABLE IF EXISTS LIBRARIAN_WRKR;

DROP TABLE IF EXISTS ITEM;

DROP TABLE IF EXISTS LIBRARY_BLDNG;

DROP TABLE IF EXISTS WORKER_P;

CREATE TABLE WORKER_P (
                          ID SERIAL PRIMARY KEY,
                          USERNAME VARCHAR(45),
                          FIRST_NAME VARCHAR(45)    ,
                          LAST_NAME VARCHAR(45)    ,
                          SALARY INTEGER    ,
                          ADDRESS VARCHAR(45)
);

CREATE TABLE LIBRARY_BLDNG (
                               ID SERIAL PRIMARY KEY,
                               NAME VARCHAR(45),
                               HOUSE_NUMBER INTEGER,
                               STREET VARCHAR(45),
                               CITY VARCHAR(45),
                               POSTAL_CODE INTEGER
);

CREATE TABLE ITEM (
                      ID SERIAL PRIMARY KEY,
                      SERIAL_NUMBER VARCHAR(45),
                      TITLE VARCHAR(45),
                      AUTHOR VARCHAR(45)
);

CREATE TABLE LIBRARIAN_WRKR (
                                ID SERIAL PRIMARY KEY,
                                SEAT VARCHAR(45)      ,
                                CONSTRAINT IC_workerUsername_FK FOREIGN KEY(ID)
                                    REFERENCES WORKER_P(ID)
);

CREATE UNIQUE INDEX workerUsernameIndex ON LIBRARIAN_WRKR (ID);

CREATE TABLE BOOK_ITEM (
                           ID SERIAL PRIMARY KEY,
                           YEAR INTEGER,
                           CONSTRAINT IC_itemSerialCodeBook_FK FOREIGN KEY(ID)
                               REFERENCES ITEM(ID)
);

CREATE UNIQUE INDEX itemSerialCodeBookIndex ON BOOK_ITEM (ID);

CREATE TABLE DVD (
                     ID SERIAL PRIMARY KEY,
                     ORIGINAL BOOLEAN,
                     CONSTRAINT IC_itemSerialCodeDVD_FK FOREIGN KEY(ID)
                         REFERENCES ITEM(ID)
);

CREATE UNIQUE INDEX itemSerialCodeDVDIndex ON DVD (ID);

CREATE TABLE PIECE (
                       ID SERIAL PRIMARY KEY,
                       PIECE_NUMBER INTEGER,
                       ITEM_ID SERIAL,
                       LIBRARY_ID SERIAL CONSTRAINT IC_Piece_libraryName NOT NULL ,
                       PRICE INTEGER CONSTRAINT IC_Piece_Price NOT NULL,
                       CONSTRAINT IC_itemSerialCodePiece_FK FOREIGN KEY(ITEM_ID)
                           REFERENCES ITEM(ID),
                       CONSTRAINT IC_libraryNamePiece_FK FOREIGN KEY(LIBRARY_ID)
                           REFERENCES LIBRARY_BLDNG(ID)
);

CREATE INDEX itemSerialCodePieceIndex ON PIECE (ITEM_ID);
CREATE INDEX libraryNameIndex ON PIECE (LIBRARY_ID);

CREATE TABLE LIBRARIES_WORKERS (
                                   LIBRARY_ID SERIAL,
                                   WORKER_ID SERIAL,
                                   CONSTRAINT IC_Works_PK PRIMARY KEY (LIBRARY_ID, WORKER_ID),
                                   CONSTRAINT IC_libraryNameWorks_FK FOREIGN KEY(LIBRARY_ID)
                                       REFERENCES LIBRARY_BLDNG(ID),
                                   CONSTRAINT IC_librarianWorks_FK FOREIGN KEY(WORKER_ID)
                                       REFERENCES WORKER_P(ID)
);

CREATE INDEX libraryNameWorksIndex ON LIBRARIES_WORKERS (LIBRARY_ID);
CREATE INDEX librarianWorksIndex ON LIBRARIES_WORKERS (WORKER_ID);