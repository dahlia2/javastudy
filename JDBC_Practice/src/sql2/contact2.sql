DROP TABLE CONTACT2TBL;
CREATE TABLE CONTACT2_TBL (
	CONTACT2_NO NUMBER 			 NOT NULL,
	NAME 	   VARCHAR2(20 BYTE) NOT NULL,
	TEL		   VARCHAR2(20 BYTE) NULL,
	EMAIL      VARCHAR2(99 BYTE) NULL,
	ADDRESS	   VARCHAR2(99 BYTE) NULL
);

ALTER TABLE CONTACT2_TBL
	ADD CONSTRAINT PK_CONTACT2 PRIMARY KEY(CONTACT2_NO);


DROP SEQUENCE CONTACT2_SEQ;
CREATE SEQUENCE CONTACT2_SEQ NOCACHE;

SELECT CONTACT2_NO, NAME, TEL, EMAIL, ADDRESS
  FROM CONTACT2_TBL;