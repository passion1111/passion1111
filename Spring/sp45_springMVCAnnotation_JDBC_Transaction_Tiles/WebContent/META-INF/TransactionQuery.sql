
CREATE TABLE TNOTICES (
  SEQ        VARCHAR2(10 BYTE)           NULL,
  TITLE      VARCHAR2(200 BYTE)          NULL,
  WRITER     VARCHAR2(50 BYTE)           NULL,
  CONTENT    VARCHAR2(4000 BYTE)         NULL,
  REGDATE    TIMESTAMP(6)                NULL,
  HIT        NUMBER                      NULL,
  FILESRC    VARCHAR2(500 BYTE)          NULL
);
COMMIT;

CREATE TABLE TMEMBER (
  ID         VARCHAR2(50 BYTE)          NULL,
  PWD         VARCHAR2(50 BYTE)          NULL,
  NAME        VARCHAR2(50 BYTE)          NULL,
  GENDER      VARCHAR2(10 BYTE)          NULL,
  BIRTH       VARCHAR2(10 BYTE)          NULL,
  IS_LUNAR    VARCHAR2(10 BYTE)          NULL,
  CPHONE      VARCHAR2(15 BYTE)          NULL,
  EMAIL       VARCHAR2(200 BYTE)         NULL,
  HABIT       VARCHAR2(200 BYTE)         NULL,
  REGDATE     DATE                       NULL
);

SELECT * FROM TNOTICES;
SELECT * FROM TMEMBER;

ALTER TABLE TMEMBER ADD(POINT number(10) DEFAULT(0));
ALTER TABLE TMEMBER ADD CONSTRAINT ck_TMEMBER_point check(point < 3);
ALTER TABLE TNOTICES ADD CONSTRAINT pk_TNOTICES_seq PRIMARY KEY(SEQ);
ALTER TABLE TNOTICES ADD CONSTRAINT uk_TONTICES_title UNIQUE(title);
--게시글 insert .... 회원 point update 하나의 논리적인 작업 단위
--TMEMBER UID -> ID
--TMEMBER 추가 컬럼 : point (DTO 또는 VO추가) 

