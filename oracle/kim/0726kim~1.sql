select *from emp2;
--����¡ó�� 5�� ���̰� ,�ϴ� ����¡ 3���� ��� �����ֱ�

--�ʼ� ���� �ʵ�(3�� ����) +2~3�� �ʵ�
--2.vo,dao
--3.context ,web ,source code
--4.
select rownum from emp2;
desc emp2;
select * from(select EMPNO, NAME, DEPTNO, TEL, PAY,
			rownum r from(select  EMPNO, NAME, DEPTNO, TEL, PAY from emp2)
			order by pay desc) where r>=2 and r<=5
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            --------------------------------
            
            
-- ��ȣ ������ ����


--1. ȸ�� ���̺� ------------------------------------------------
select *from jsp_member;
create table jsp_member
(
  id 		varchar2(50) 	not null primary KEY
  ,password 	varchar2(50) 	not null
  ,name 		varchar2(50)
  ,gender 		varchar2(10)
  ,birth 		date
  ,mail 		varchar2(100)
  ,phone 		varchar2(50)
  ,address 	varchar2(200)
  ,reg date 	default sysdate
);

-----------------------------------------------------------------

--2. �Խ��� ���̺� ----------------------------------------------
select *from member_board;
CREATE TABLE Member_Board 
(
  board_num 		NUMBER 		NOT NULL,
  board_id 		VARCHAR2(50),
  board_subject 		VARCHAR2(100),
  board_content 		VARCHAR2(2000),
  board_file 		VARCHAR2(100),
  Board_re_ref 		NUMBER,
  Board_re_lev 		NUMBER,
  Board_re_seq 		NUMBER,
  Board_count 		NUMBER,
  Board_date		DATE,
  BOARD_PARENT     	NUMBER,              
  CONSTRAINT PK_Member_Board PRIMARY KEY(board_num)
);


-- 3. �Խ��� ���̺� �������� �߰�
 
alter table MEMBER_BOARD
add constraint pk_board_id foreign key(board_id)
REFERENCES JSP_MEMBER(id);

-----------------------------------------------------------------


-- 4. �湮�� �� ���̺� -------------------------------------------

CREATE TABLE VISIT (V_DATE DATE NOT NULL);

-----------------------------------------------------------------

-- 5. ���� ���̺� ----------------------------------------------

 CREATE TABLE GUESTBOOK 
(
  guestbook_no 		NUMBER(15)	NOT NULL,
  guestbook_id 		VARCHAR2(15) 	NOT NULL,
  guestbook_password 	VARCHAR2(15) 	NOT NULL,
  guestbook_content 	VARCHAR2(1000),
  guestbook_group 	NUMBER(15),
  guestbook_parent 	NUMBER(15),
  guestbook_date 		DATE,
  CONSTRAINT PK_GUESTBOOK PRIMARY KEY(guestbook_no)
);
 
-----------------------------------------------------------------

-- 6. ��� ���̺� ------------------------------------------------

CREATE TABLE BOARD_COMMENT 
(
  COMMENT_NUM 		NUMBER 		NOT NULL,
  COMMENT_BOARD 	NUMBER 		NOT NULL,
  COMMENT_ID 		VARCHAR2(15),
  COMMENT_DATE 		DATE,
  COMMENT_PARENT 	NUMBER,
  COMMENT_CONTENT 	VARCHAR2(1000) 	NOT NULL,
  CONSTRAINT PK_comment PRIMARY KEY(COMMENT_NUM),
  CONSTRAINT FK_comment FOREIGN KEY(COMMENT_BOARD) REFERENCES MEMBER_BOARD(BOARD_NUM)
);
 
-- 7. ��� ���̺� ���� �������� ����

ALTER TABLE BOARD_COMMENT DROP CONSTRAINT "COMMENT_BOARD"
 
-- 8. �������� ON DELETE CASCADE �߰�

ALTER TABLE BOARD_COMMENT ADD CONSTRAINT COMMENT_BOARD
         FOREIGN KEY(COMMENT_BOARD) REFERENCES MEMBER_BOARD(BOARD_NUM) ON DELETE CASCADE ;

-----------------------------------------------------------------

-- 9. �Խ��� ������

create sequence BOARD_NUM; 

-- 10. ���� ������

CREATE SEQUENCE guestbook_no_seq;

-- 11. ��� ������ 

create sequence COMMENT_SEQ; 
select *from MEMBER_BOARD;



