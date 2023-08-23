CREATE TABLE CK_BOARD(
	SEQ NUMBER PRIMARY KEY,
	CONTENT CLOB
);

SELECT NVL(MAX(SEQ),0)+1
	FROM CK_BOARD;

INSERT INTO HR.CK_BOARD(SEQ, CONTENT)
		VALUES((SELECT NVL(MAX(SEQ),0)+1 FROM CK_BOARD), 'content');

SELECT SEQ, CONTENT
	FROM CK_BOARD cb ;

CREATE TABLE FILEBOARD(
	F_SEQ NUMBER PRIMARY KEY,
	B_SEQ NUMBER NOT NULL,
	ORIGIN_FNAME VARCHAR2(1000) NOT NULL,
	STORED_FNAME VARCHAR2(1000) NOT NULL,
	FILE_SIZE NUMBER NOT NULL
);