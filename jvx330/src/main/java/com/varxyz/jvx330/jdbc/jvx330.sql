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

