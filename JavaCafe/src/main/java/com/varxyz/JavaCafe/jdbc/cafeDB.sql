CREATE TABLE Customer(
	cid				BIGINT			PRIMARY KEY AUTO_INCREMENT,
	email			VARCHAR(30)		NOT NULL, 
	passwd			VARCHAR(20)		NOT NULL,
	name			VARCHAR(20)		NOT NULL,
	ssn				VARCHAR(14)		NOT NULL, -- 123456-7890123
	phone			VARCHAR(13)		NOT NULL, -- 010-1234-5678
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP
)AUTO_INCREMENT = 1001;

SELECT * FROM Customer;
SELECT count(*) FROM Customer;
DROP TABLE Customer;

CREATE TABLE MenuCategory (
	cateName 		VARCHAR(20)		NOT NULL,
	cateCode		VARCHAR(20)		PRIMARY KEY,
	cateCodeRef		VARCHAR(20)		DEFAULT NULL,
	FOREIGN KEY (cateCodeRef) REFERENCES MenuCategory(cateCode)
);

SELECT * FROM MenuCategory;
DROP TABLE MenuCategory;

INSERT INTO MenuCategory (cateName, cateCode)
VALUES ('카테고리 1', '커피');
INSERT INTO MenuCategory (cateName, cateCode, cateCodeRef)
VALUES ('카테고리 1-1', '아메리카노', '커피');
INSERT INTO MenuCategory (cateName, cateCode, cateCodeRef)
VALUES ('카테고리 1-2', '라떼', '커피');

INSERT INTO MenuCategory (cateName, cateCode)
VALUES ('카테고리 2', '200');
INSERT INTO MenuCategory (cateName, cateCode, cateCodeRef)
VALUES ('카테고리 2-1', '201', '200');
INSERT INTO MenuCategory (cateName, cateCode, cateCodeRef)
VALUES ('카테고리 2-2', '202', '200');
INSERT INTO MenuCategory (cateName, cateCode)
VALUES ('카테고리 3', '300');

CREATE TABLE MenuItem (
	cateCodeRef		VARCHAR(20)		NOT NULL,
	cateCode		VARCHAR(20)		NOT NULL,
	menuName		VARCHAR(100)	NOT NULL,
	menuPrice		DOUBLE			NOT NULL,
	menuNum			INT				NOT NULL,
	menuStock		INT				DEFAULT NULL,
	menuInfo		VARCHAR(500)	DEFAULT NULL,
	menuImg			VARCHAR(200)	DEFAULT NULL,
	regDate			TIMESTAMP		NOT NULL	DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (cateCode) REFERENCES MenuCategory(cateCode),
	FOREIGN KEY (cateCodeRef) REFERENCES MenuCategory(cateCodeRef)
);

SELECT * FROM MenuItem;
DROP TABLE MenuItem;

SELECT cateName, cateCode, cateCodeRef FROM MenuCategory;
