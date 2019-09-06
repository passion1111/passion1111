
����� 1 �࿡�� �����ϴ� �� ���� �߻� -
[Spring ����� ���� ���� ó��]
���� ���� -
�� �� ���� ���


����� 3 �࿡�� �����ϴ� �� ���� �߻� -
-������ ����
���� ���� -
�� �� ���� ���


����� 4 �࿡�� �����ϴ� �� ���� �߻� -
-���� : �α����ؼ�  �α��� ����
���� ���� -
�� �� ���� ���


����� 5 �࿡�� �����ϴ� �� ���� �߻� -
-���� : ������ ����ڰ� ó���� �� �ִ� ���μ���
���� ���� -
�� �� ���� ���

SP2-0044: Ȯ�ε� ��� ����� ������ HELP�� �Է��ϰ�,
�����Ϸ��� EXIT�� �Է��Ͻʽÿ�.
SP2-0734: "1.Spring.io ����Ʈ �湮..."(��)�� ���۵Ǵ� �� �� ���� ��� - ������ ���� ���õ˴ϴ�.

����� 3 �࿡�� �����ϴ� �� ���� �߻� -
drop table users
���� ���� -
ORA-02449: �ܷ� Ű�� ���� �����Ǵ� ����/�⺻ Ű�� ���̺� �ֽ��ϴ�
02449. 00000 -  "unique/primary keys in table referenced by foreign keys"
*Cause:    An attempt was made to drop a table with unique or
           primary keys referenced by foreign keys in another table.
*Action:   Before performing the above operations the table, drop the
           foreign key constraints in other tables. You can see what
           constraints are referencing a table by issuing the following
           command:
           SELECT * FROM USER_CONSTRAINTS WHERE TABLE_NAME = "tabnam";

����� 5 �࿡�� �����ϴ� �� ���� �߻� -
create table users (
    id number not null primary key,
    name varchar2(50) not null,
    password varchar2(50) not null,
    enabled number(1)        -- boolean Ÿ������ ������ ����(���� ��뿩��)
)
���� ���� -
ORA-00955: ������ ��ü�� �̸��� ����ϰ� �ֽ��ϴ�.
00955. 00000 -  "name is already used by an existing object"
*Cause:    
*Action:

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
create table roll (
    role_id number not null primary key,
    id number not null,
    authority varchar2(50) not null,
    foreign key(id) references users(id)
)
���� ���� -
ORA-00955: ������ ��ü�� �̸��� ����ϰ� �ֽ��ϴ�.
00955. 00000 -  "name is already used by an existing object"
*Cause:    
*Action:

����� 19 �࿡�� �����ϴ� �� ���� �߻� -
insert into users( id, name, password, enabled) values (1, 'kingsmile', '1004', 1)
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.SYS_C007766)�� ����˴ϴ�


����� 20 �࿡�� �����ϴ� �� ���� �߻� -
insert into users( id, name, password, enabled) values (2, 'happy', '11', 1)
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.SYS_C007766)�� ����˴ϴ�


����� 21 �࿡�� �����ϴ� �� ���� �߻� -
insert into users( id, name, password, enabled) values (3, 'aa', 'a', 1)
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.SYS_C007766)�� ����˴ϴ�


����� 23 �࿡�� �����ϴ� �� ���� �߻� -
insert into roll( role_id, id, authority) values (1, 1, 'ROLE_ADMIN')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.SYS_C007770)�� ����˴ϴ�


����� 24 �࿡�� �����ϴ� �� ���� �߻� -
insert into roll( role_id, id, authority) values (2, 2, 'ROLE_USER')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.SYS_C007770)�� ����˴ϴ�


����� 27 �࿡�� �����ϴ� �� ���� �߻� -
- USER SQL
���� ���� -
�� �� ���� ���


����� 28 �࿡�� �����ϴ� �� ���� �߻� -
CREATE USER kingsmile IDENTIFIED BY 1004 
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
���� ���� -
ORA-65096: ���� ����� �Ǵ� �� �̸��� �������մϴ�.
65096. 00000 -  "invalid common user or role name"
*Cause:    An attempt was made to create a common user or role with a name
           that was not valid for common users or roles.  In addition to
           the usual rules for user and role names, common user and role
           names must start with C## or c## and consist only of ASCII
           characters.
*Action:   Specify a valid common user or role name.

����� 35 �࿡�� �����ϴ� �� ���� �߻� -
GRANT "RESOURCE" TO kingsmile WITH ADMIN OPTION
���� ���� -
ORA-01917: ����� �Ǵ� �� 'KINGSMILE'(��)�� �������� �ʽ��ϴ�
01917. 00000 -  "user or role '%s' does not exist"
*Cause:    There is not a user or role by that name.
*Action:   Re-specify the name.

����� 36 �࿡�� �����ϴ� �� ���� �߻� -
GRANT "CONNECT" TO kingsmile WITH ADMIN OPTION
���� ���� -
ORA-01917: ����� �Ǵ� �� 'KINGSMILE'(��)�� �������� �ʽ��ϴ�
01917. 00000 -  "user or role '%s' does not exist"
*Cause:    There is not a user or role by that name.
*Action:   Re-specify the name.

����� 37 �࿡�� �����ϴ� �� ���� �߻� -
ALTER USER kingsmile DEFAULT ROLE "RESOURCE","CONNECT"
���� ���� -
ORA-01918: ����� 'KINGSMILE'(��)�� �������� �ʽ��ϴ�
01918. 00000 -  "user '%s' does not exist"
*Cause:    User does not exist in the system.
*Action:   Verify the user name is correct.

����� 45 �࿡�� �����ϴ� �� ���� �߻� -
CREATE TABLE TNOTICES
(
	"SEQ" VARCHAR2(10 BYTE), 
	"TITLE" VARCHAR2(200 BYTE), 
	"WRITER" VARCHAR2(50 BYTE), 
	"CONTENT" VARCHAR2(4000 BYTE), 
	"REGDATE" TIMESTAMP (6), 
	"HIT" NUMBER, 
	"FILESRC" VARCHAR2(500 BYTE)
)
���� ���� -
ORA-00955: ������ ��ü�� �̸��� ����ϰ� �ֽ��ϴ�.
00955. 00000 -  "name is already used by an existing object"
*Cause:    
*Action:

����� 56 �࿡�� �����ϴ� �� ���� �߻� -
CREATE TABLE "TMEMBER"
(	
    "UID" VARCHAR2(50 BYTE), 
    "PWD" VARCHAR2(50 BYTE), 
    "NAME" VARCHAR2(50 BYTE), 
    "GENDER" VARCHAR2(10 BYTE), 
    "BIRTH" VARCHAR2(10 BYTE), 
    "IS_LUNAR" VARCHAR2(10 BYTE), 
    "CPHONE" VARCHAR2(15 BYTE), 
    "EMAIL" VARCHAR2(200 BYTE), 
    "HABIT" VARCHAR2(200 BYTE), 
    "REGDATE" DATE
)
���� ���� -
ORA-00955: ������ ��ü�� �̸��� ����ϰ� �ֽ��ϴ�.
00955. 00000 -  "name is already used by an existing object"
*Cause:    
*Action:

����� 70 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(1,'title_1','writer_1','content_1',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�


����� 72 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(2,'title_2','writer_2','content_2',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�


����� 74 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(3,'title_3','writer_3','content_3',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�


����� 76 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(4,'title_4','writer_4','content_4',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�


����� 78 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(5,'title_5','writer_5','content_5',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�


����� 80 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(6,'title_6','writer_6','content_6',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�


����� 82 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(7,'title_7','writer_7','content_7',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�


1 �� ��(��) ���ԵǾ����ϴ�.


1 �� ��(��) ���ԵǾ����ϴ�.


����� 88 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO TNOTICES(seq,title,writer,content,regdate,hit,filesrc)
VALUES(10,'title_10','writer_10','content_10',SYSDATE,0,'')
���� ���� -
ORA-00001: ���Ἲ ���� ����(KIM.PK_TNOTICES_SEQ)�� ����˴ϴ�

Ŀ�� �Ϸ�.
>>Query Run In:질의 결과 1

����� 1 �࿡�� �����ϴ� �� ���� �߻� -
[Spring ����� ���� ���� ó��]
���� ���� -
�� �� ���� ���


����� 3 �࿡�� �����ϴ� �� ���� �߻� -
-������ ����
���� ���� -
�� �� ���� ���


����� 4 �࿡�� �����ϴ� �� ���� �߻� -
-���� : �α����ؼ�  �α��� ����
���� ���� -
�� �� ���� ���

SP2-0044: Ȯ�ε� ��� ����� ������ HELP�� �Է��ϰ�,
�����Ϸ��� EXIT�� �Է��Ͻʽÿ�.

����� 5 �࿡�� �����ϴ� �� ���� �߻� -
-���� : ������ ����ڰ� ó���� �� �ִ� ���μ���
���� ���� -
�� �� ���� ���

SP2-0734: "1.Spring.io ����Ʈ �湮..."(��)�� ���۵Ǵ� �� �� ���� ��� - ������ ���� ���õ˴ϴ�.

����� 1 �࿡�� �����ϴ� �� ���� �߻� -
[Spring ����� ���� ���� ó��]
���� ���� -
�� �� ���� ���


����� 3 �࿡�� �����ϴ� �� ���� �߻� -
-������ ����
���� ���� -
�� �� ���� ���


����� 4 �࿡�� �����ϴ� �� ���� �߻� -
-���� : �α����ؼ�  �α��� ����
���� ���� -
�� �� ���� ���

SP2-0044: Ȯ�ε� ��� ����� ������ HELP�� �Է��ϰ�,
�����Ϸ��� EXIT�� �Է��Ͻʽÿ�.

����� 5 �࿡�� �����ϴ� �� ���� �߻� -
-���� : ������ ����ڰ� ó���� �� �ִ� ���μ���
���� ���� -
�� �� ���� ���

SP2-0734: "1.Spring.io ����Ʈ �湮..."(��)�� ���۵Ǵ� �� �� ���� ��� - ������ ���� ���õ˴ϴ�.

����� 2 �࿡�� �����ϴ� �� ���� �߻� -
 user table
���� ���� -
�� �� ���� ���

Rollback complete.

����� 4 �࿡�� �����ϴ� �� ���� �߻� -
 userandroll table ����
���� ���� -
�� �� ���� ���


��ü ���

����� 69 �࿡�� �����ϴ� �� ���� �߻� -
CREATE TABLE roll (
	userid VARCHAR2(20),
  Role_name VARCHAR2(30)
)
���� ���� -
ORA-00955: ������ ��ü�� �̸��� ����ϰ� �ֽ��ϴ�.
00955. 00000 -  "name is already used by an existing object"
*Cause:    
*Action:

����� 74 �࿡�� �����ϴ� �� ���� �߻� -
ROLE_USER , ROLE_ADMIN
���� ���� -
�� �� ���� ���

SP2-0044: Ȯ�ε� ��� ����� ������ HELP�� �Է��ϰ�,
�����Ϸ��� EXIT�� �Է��Ͻʽÿ�.

����� 75 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('admin','ROLE_USER')
���� �߻� �����: 75 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:

����� 76 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('admin','ROLE_ADMIN')
���� �߻� �����: 76 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:

����� 78 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('simson','ROLE_USER')
���� �߻� �����: 78 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:
Ŀ�� �Ϸ�.
>>Query Run In:질의 결과 2
>>Query Run In:질의 결과 3
>>Query Run In:질의 결과 4

1 �� ��(��) ���ԵǾ����ϴ�.

>>Query Run In:질의 결과 5

����� 100 �࿡�� �����ϴ� �� ���� �߻� -
		                                FROM member WHERE id=?"
���� ���� -
�� �� ���� ���


����� 76 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('admin','ROLE_ADMIN')
���� �߻� �����: 76 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:

����� 76 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('admin','ROLE_ADMIN')
���� �߻� �����: 76 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:

����� 77 �࿡�� �����ϴ� �� ���� �߻� -
update roll set 
select * from roll
���� �߻� �����: 78 ��: 1
���� ���� -
SQL ����: ORA-01747: ������ �ùٸ��� ������ �ֽʽÿ�
01747. 00000 -  "invalid user.table.column, table.column, or column specification"
*Cause:    
*Action:

1 �� ��(��) ������Ʈ�Ǿ����ϴ�.

Ŀ�� �Ϸ�.

����� 77 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('simson','ROLE_ADMIN')
���� �߻� �����: 77 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:

����� 77 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('simson','ROLE_ADMIN')
���� �߻� �����: 77 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:

����� 82 �࿡�� �����ϴ� �� ���� �߻� -
INSERT INTO roll VALUES('simson','ROLE_USER')
���� �߻� �����: 82 ��: 13
���� ���� -
SQL ����: ORA-00947: ���� ���� ������� �ʽ��ϴ�
00947. 00000 -  "not enough values"
*Cause:    
*Action:

����� 120 �࿡�� �����ϴ� �� ���� �߻� -
,   1 enabled
���� ���� -
�� �� ���� ���


Table ROLL��(��) �����Ǿ����ϴ�.


Table ROLL��(��) �����Ǿ����ϴ�.


1 �� ��(��) ���ԵǾ����ϴ�.

Ŀ�� �Ϸ�.

1 �� ��(��) ���ԵǾ����ϴ�.

Ŀ�� �Ϸ�.

1 �� ��(��) ���ԵǾ����ϴ�.

Ŀ�� �Ϸ�.

����� 1 �࿡�� �����ϴ� �� ���� �߻� -
CREATE OR REPLACE TRIGGER triger_test
       BEFORE
       UPDATE ON dept
       FOR EACH ROW
	   
	   BEGIN
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : old.dname);
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : new.dname);
     END;
���� ���� -
ORA-00942: ���̺� �Ǵ� �䰡 �������� �ʽ��ϴ�
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:

����� 1 �࿡�� �����ϴ� �� ���� �߻� -
CREATE OR REPLACE TRIGGER triger_test
       BEFORE
       UPDATE ON dept
       FOR EACH ROW
	   
	   BEGIN
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : old.dname);
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : new.dname);
     END;

     select*from dept;
���� ���� -
ORA-00942: ���̺� �Ǵ� �䰡 �������� �ʽ��ϴ�
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:

����� 1 �࿡�� �����ϴ� �� ���� �߻� -
CREATE OR REPLACE TRIGGER triger_test
       BEFORE
       UPDATE ON dept
       FOR EACH ROW
	   
	   BEGIN
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : old.dname);
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : new.dname);
     END;

     CREATE TABLE DEPT

       (DEPTNO NUMBER(2),

        DNAME VARCHAR2(14),

        LOC VARCHAR2(13) );



INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');

INSERT INTO DEPT VALUES (20, 'RESEARCH',   'DALLAS');

INSERT INTO DEPT VALUES (30, 'SALES',      'CHICAGO');

INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');
���� ���� -
ORA-00942: ���̺� �Ǵ� �䰡 �������� �ʽ��ϴ�
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:

����� 1 �࿡�� �����ϴ� �� ���� �߻� -
CREATE OR REPLACE TRIGGER triger_test
       BEFORE
       UPDATE ON dept
       FOR EACH ROW
	   
	   BEGIN
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : old.dname);
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : new.dname);
     END;

     CREATE TABLE DEPT

       (DEPTNO NUMBER(2),

        DNAME VARCHAR2(14),

        LOC VARCHAR2(13) );



INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');

INSERT INTO DEPT VALUES (20, 'RESEARCH',   'DALLAS');

INSERT INTO DEPT VALUES (30, 'SALES',      'CHICAGO');

INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');
���� ���� -
ORA-00942: ���̺� �Ǵ� �䰡 �������� �ʽ��ϴ�
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:

Table DEPT��(��) �����Ǿ����ϴ�.


Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
6/6       PLS-00103: �ɺ� "CREATE"�� �������ϴ� 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

1 �� ��(��) ���ԵǾ����ϴ�.


1 �� ��(��) ���ԵǾ����ϴ�.


1 �� ��(��) ���ԵǾ����ϴ�.


1 �� ��(��) ���ԵǾ����ϴ�.


Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
6/4       PLS-00103: �ɺ� "UPDATE"�� �������ϴ� 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 11 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 11 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
6/6       PLS-00103: �ɺ� "SELECT"�� �������ϴ� 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
5/6       PLS-00103: �ɺ� ";"�� �������ϴ� 
7/4       PLS-00103: �ɺ� "UPDATE"�� �������ϴ� 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

����� 1 �࿡�� �����ϴ� �� ���� �߻� -
CREATE OR REPLACE TRIGGER triger_test
       BEFORE
       UPDATE ON dept
       FOR EACH ROW
	   
	  ( BEGIN
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : old.dname);
        DBMS_OUTPUT.PUT_LINE('���� �� �÷� �� : ' || : new.dname);
     END);

     select *from dept;
   update dept set dname='�ѹ���' where deptno=30;
���� ���� -
ORA-04079: �δ��� Ʈ���� ����
04079. 00000 -  "invalid trigger specification"
*Cause:    The create TRIGGER statement is invalid.
*Action:   Check the statement for correct syntax.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
update dept set dname='�ѹ���' where deptno=30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
6/6       PLS-00103: �ɺ� "SELECT"�� �������ϴ� 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 8
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.


Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
6/6       PLS-00103: �ɺ� "SELECT"�� �������ϴ� 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

����� 12 �࿡�� �����ϴ� �� ���� �߻� -
 UPDATE dept SET dname = '�ѹ���' WHERE deptno = 30
���� �߻� �����: 12 ��: 9
���� ���� -
SQL ����: ORA-04098: 'KIM.TRIGER_TEST' Ʈ���Ű� �������ϸ� ������� �����߽��ϴ�
04098. 00000 -  "trigger '%s.%s' is invalid and failed re-validation"
*Cause:    A trigger was attempted to be retrieved for execution and was
           found to be invalid.  This also means that compilation/authorization
           failed for the trigger.
*Action:   Options are to resolve the compilation/authorization errors,
           disable the trigger, or drop the trigger.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
3/6       PLS-00103: �ɺ� "END"�� �������ϴ� ���� �� �ϳ��� ���� ��:    ( begin case declare exit for goto if loop mod null pragma    raise return select update while with <�ĺ���>    <ū ����ǥ�� ���е� �ĺ���> <���ε� ����> <<    continue close current delete fetch lock insert open rollback    savepoint set sql execute commit forall merge pipe purge    json_exists json_value json_query json_object json_array 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
2/8       PLS-00428: �ش� SELECT ���� INTO ���� �ʿ��մϴ�.
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
3/9       PLS-00103: �ɺ� "end-of-file"�� �������ϴ� ���� �� �ϳ��� ���� ��:    ( begin case declare end exception exit for goto if loop mod    null pragma raise return select update while with <�ĺ���>    <ū ����ǥ�� ���е� �ĺ���> <���ε� ����> <<    continue close current delete fetch lock insert open rollback    savepoint set sql execute commit forall merge pipe purge    json_exists json_value json_query json_object json_array 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
3/9       PLS-00103: �ɺ� "end-of-file"�� �������ϴ� ���� �� �ϳ��� ���� ��:    ( begin case declare end exception exit for goto if loop mod    null pragma raise return select update while with <�ĺ���>    <ū ����ǥ�� ���е� �ĺ���> <���ε� ����> <<    continue close current delete fetch lock insert open rollback    savepoint set sql execute commit forall merge pipe purge    json_exists json_value json_query json_object json_array 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
3/9       PLS-00103: �ɺ� "end-of-file"�� �������ϴ� ���� �� �ϳ��� ���� ��:    ( begin case declare end exception exit for goto if loop mod    null pragma raise return select update while with <�ĺ���>    <ū ����ǥ�� ���е� �ĺ���> <���ε� ����> <<    continue close current delete fetch lock insert open rollback    savepoint set sql execute commit forall merge pipe purge    json_exists json_value json_query json_object json_array 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
3/9       PLS-00103: �ɺ� "end-of-file"�� �������ϴ� ���� �� �ϳ��� ���� ��:    ( begin case declare end exception exit for goto if loop mod    null pragma raise return select update while with <�ĺ���>    <ū ����ǥ�� ���е� �ĺ���> <���ε� ����> <<    continue close current delete fetch lock insert open rollback    savepoint set sql execute commit forall merge pipe purge    json_exists json_value json_query json_object json_array 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.

LINE/COL  ERROR
--------- -------------------------------------------------------------
3/9       PLS-00103: �ɺ� "end-of-file"�� �������ϴ� ���� �� �ϳ��� ���� ��:    ( begin case declare end exception exit for goto if loop mod    null pragma raise return select update while with <�ĺ���>    <ū ����ǥ�� ���е� �ĺ���> <���ε� ����> <<    continue close current delete fetch lock insert open rollback    savepoint set sql execute commit forall merge pipe purge    json_exists json_value json_query json_object json_array 
����: �����Ϸ� �α׸� Ȯ���Ͻʽÿ�.

Trigger TRIGER_TEST��(��) �����ϵǾ����ϴ�.


1 �� ��(��) ������Ʈ�Ǿ����ϴ�.

