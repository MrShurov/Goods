/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 13.0 		*/
/*  Created On : 10-���-2018 16:39:03 				*/
/*  DBMS       : PostgreSQL 						*/
/* ---------------------------------------------------- */

/* Drop Tables */

DROP TABLE IF EXISTS Goods CASCADE
;

DROP TABLE IF EXISTS GoodsList CASCADE
;

DROP TABLE IF EXISTS Materials CASCADE
;

DROP TABLE IF EXISTS Measures CASCADE
;

DROP TABLE IF EXISTS OrderMaterials CASCADE
;

DROP TABLE IF EXISTS Orders CASCADE
;

DROP TABLE IF EXISTS Users CASCADE
;

DROP TABLE IF EXISTS Works CASCADE
;

/* Drop Sequences */

DROP SEQUENCE  IF EXISTS  SEQ_GoodList  CASCADE
;

DROP SEQUENCE  IF EXISTS  SEQ_Goods  CASCADE
;

DROP SEQUENCE  IF EXISTS  SEQ_Materials  CASCADE
;

DROP SEQUENCE  IF EXISTS  SEQ_Measures  CASCADE
;

DROP SEQUENCE  IF EXISTS  SEQ_OrderMaterials  CASCADE
;

DROP SEQUENCE  IF EXISTS  SEQ_Orders  CASCADE
;

DROP SEQUENCE  IF EXISTS  SEQ_User  CASCADE
;

DROP SEQUENCE  IF EXISTS  SEQ_Works  CASCADE
;

/* Create Sequences */

CREATE SEQUENCE SEQ_GoodList
INCREMENT 1
START 1;
;
;

CREATE SEQUENCE SEQ_Goods
INCREMENT 1
START 1;
;
;

CREATE SEQUENCE SEQ_Materials
INCREMENT 1
START 1;
;
;

CREATE SEQUENCE SEQ_Measures
INCREMENT 1
START 1;
;
;

CREATE SEQUENCE SEQ_OrderMaterials
INCREMENT 1
START 1;
;
;

CREATE SEQUENCE SEQ_Orders
INCREMENT 1
START 1;
;
;

CREATE SEQUENCE SEQ_User
INCREMENT 1
START 1;
;
;

CREATE SEQUENCE SEQ_Works
INCREMENT 1
START 1;
;
;

/* Create Tables */

CREATE TABLE Goods
(
	GoodId integer NOT NULL,
	GoodName varchar(100) NOT NULL
)
;

CREATE TABLE GoodsList
(
	GoodsListId integer NOT NULL,
	OrderId integer NULL,
	GoodId integer NULL,
	Count integer NOT NULL,
	Length varchar(50) NULL,
	Width varchar(50) NULL,
	Height varchar(50) NULL,
	Depth varchar(50) NULL
)
;

CREATE TABLE Materials
(
	MaterialId integer NOT NULL,
	GoodId integer NOT NULL,
	MeasureId integer NOT NULL,
	MaterialName varchar(100) NOT NULL,
	Mandatory boolean NOT NULL,
	Formula varchar(500) NULL,
	Price double precision NOT NULL
)
;

CREATE TABLE Measures
(
	MeasureId integer NOT NULL,
	MeasureName varchar(50) NOT NULL
)
;

CREATE TABLE OrderMaterials
(
	OrderMaterialsId integer NOT NULL,
	GoodsListId integer NULL,
	MaterialId integer NULL,
	Koefficient double precision NOT NULL,
	Price double precision NOT NULL,
	Total double precision NOT NULL
)
;

CREATE TABLE Orders
(
	OrderId integer NOT NULL,
	CreateDate timestamp without time zone NULL,
	CreateBy integer NULL
)
;

CREATE TABLE Users
(
	UserId integer NOT NULL,
	UserName varchar(50) NOT NULL,
	Password varchar(20) NOT NULL
)
;

CREATE TABLE Works
(
	WorkId integer NOT NULL,
	WorkName varchar(50) NOT NULL,
	Norma double precision NOT NULL,
	Count integer NOT NULL,
	GoodId integer NULL
)
;

/* Create Primary Keys, Indexes, Uniques, Checks */

ALTER TABLE Goods ADD CONSTRAINT PK_Goods
	PRIMARY KEY (GoodId)
;

ALTER TABLE GoodsList ADD CONSTRAINT PK_GoodsList
	PRIMARY KEY (GoodsListId)
;

CREATE INDEX IXFK_GoodsList_Goods ON GoodsList (GoodId ASC)
;

CREATE INDEX IXFK_GoodsList_Orders ON GoodsList (OrderId ASC)
;

ALTER TABLE Materials ADD CONSTRAINT PK_Materials
	PRIMARY KEY (MaterialId)
;

CREATE INDEX IXFK_Materials_Goods ON Materials (GoodId ASC)
;

CREATE INDEX IXFK_Materials_Measures ON Materials (MeasureId ASC)
;

ALTER TABLE Measures ADD CONSTRAINT PK_Measures
	PRIMARY KEY (MeasureId)
;

ALTER TABLE OrderMaterials ADD CONSTRAINT PK_OrderMaterials
	PRIMARY KEY (OrderMaterialsId)
;

CREATE INDEX IXFK_OrderMaterials_GoodsList ON OrderMaterials (GoodsListId ASC)
;

CREATE INDEX IXFK_OrderMaterials_Materials ON OrderMaterials (MaterialId ASC)
;

ALTER TABLE Orders ADD CONSTRAINT PK_Orders
	PRIMARY KEY (OrderId)
;

CREATE INDEX IXFK_Orders_Users ON Orders (CreateBy ASC)
;

ALTER TABLE Users ADD CONSTRAINT PK_Users
	PRIMARY KEY (UserId)
;

ALTER TABLE Works ADD CONSTRAINT PK_Works
	PRIMARY KEY (WorkId)
;

CREATE INDEX IXFK_Works_Goods ON Works (GoodId ASC)
;

/* Create Foreign Key Constraints */

ALTER TABLE GoodsList ADD CONSTRAINT FK_GoodsList_Goods
	FOREIGN KEY (GoodId) REFERENCES Goods (GoodId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE GoodsList ADD CONSTRAINT FK_GoodsList_Orders
	FOREIGN KEY (OrderId) REFERENCES Orders (OrderId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Materials ADD CONSTRAINT FK_Materials_Goods
	FOREIGN KEY (GoodId) REFERENCES Goods (GoodId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Materials ADD CONSTRAINT FK_Materials_Measures
	FOREIGN KEY (MeasureId) REFERENCES Measures (MeasureId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE OrderMaterials ADD CONSTRAINT FK_OrderMaterials_GoodsList
	FOREIGN KEY (GoodsListId) REFERENCES GoodsList (GoodsListId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE OrderMaterials ADD CONSTRAINT FK_OrderMaterials_Materials
	FOREIGN KEY (MaterialId) REFERENCES Materials (MaterialId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Orders ADD CONSTRAINT FK_Orders_Users
	FOREIGN KEY (CreateBy) REFERENCES Users (UserId) ON DELETE No Action ON UPDATE No Action
;

ALTER TABLE Works ADD CONSTRAINT FK_Works_Goods
	FOREIGN KEY (GoodId) REFERENCES Goods (GoodId) ON DELETE No Action ON UPDATE No Action
;
