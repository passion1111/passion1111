--rownum/rowid
select rownum,ename,sal,rowid from emp; --rownum�� ���������� �ο���. rowid �ý����� �ο����ִ� ���̵�.
-- ����Ŭ�� ��𼭺��� ������ �������°� �Ұ��� �׷��� rownum�� ��
--�Խ��� ��������� ����¡ ó��...


--���� ���̺�: dual
select*from dual;
select sysdate from dual;

--sid�˾ƺ���-
select*from v$database;

--�������� �ּڰ������ϸ� ����������� ������ �־������.
--����Ŭ  ��������Ŭ�� ���Ҽ��� ����.
--

create SEQUENCE autonum;
select autonum.currval from dual; --currentnum
    
    drop table bit_t;
create table bit_T(
    no number,
    name varchar2(10)
    );
    
    create table bit_T2(
    no number,
    name varchar2(10)
    )segment creation immediate;
    
    select*from bit_t;
drop sequence autonum;
    insert into bit_t values(autonum.nextval,'aa');
    insert into bit_t values(autonum.nextval,'bb');
    insert into bit_t values(autonum.nextval,'cc');
-- sequence ���� �����ż� ���� ����� ����մϴ�.

    select *from bit_t2;
    create sequence seq_num;
    insert into bit_t2 values(seq_num.nextval,'aa');
    insert into bit_t2 values(seq_num.nextval,'bb');
    insert into bit_t2 values(seq_num.nextval,'cc');
    
    create table kosta_T(
    num number,
    name varchar2(10)
)segment creation immediate;  --����������� ù��°�� 2������ ������. 

select*from kosta_t;
drop table kosta_t;
drop sequence seq_kosta;
create  sequence seq_kosta
    INCREMENT by 100;
    
create sequence seq_kosta2
start with 100
INCREMENT by 100;
    
    insert into kosta_t values(seq_kosta.nextval,'kk');
    
    select*from kosta_t;
    
    
--    ���� �ڵ����� ������ ���� seq_test��� �����ϰ� 100�����ؼ� 100�����ϴ°� �����
--���̺� seq_test( num,name,phoe)����� ���ڵ� 3�� �߰��ؼ�Ȯ���ϱ�
create table seq_testtable(
    num number,
    name varchar2(10),
    phone number
)segment creation immediate;  --����������� ù��°�� 2������ ������. 

insert into seq_testtable values(seq_kosta2.nextval,'������',01044444444);
insert into seq_testtable values(seq_kosta2.nextval,'������',01044444444);
insert into seq_testtable values(seq_kosta2.nextval,'ļ����',01044444444);

select*from seq_testtable;















----
--- rownum / rowid --------------------
select rownum, ename, sal, rowid from emp;

SELECT ROWNUM, ename, sal
    FROM (SELECT * FROM EMP ORDER BY sal);

 -- �Խ��� ��������� ����¡ ó��....
-- 1 limit 7 : mySQL 

-- ���� ���̺� : dual 
select * from dual;
select sysdate from dual;

-- SID Ȯ���ϱ� ---
SELECT * from v$database;
-- Sequence -------------------------
create sequence autonum;  -- 1���� �����ؼ� 1�� �����Ѵ�
drop SEQUENCE autonum;

select autonum.nextval from dual;
select autonum.currval from dual;

drop table bit_T;
create table bit_T (
    no number,
    name VARCHAR2(10)
);

drop table bit_T2;
create table bit_T2 (
    no number,
    name VARCHAR2(10)
)SEGMENT CREATION IMMEDIATE;

select * from bit_t2;
drop SEQUENCE seq_num;
create sequence seq_num;

insert into bit_t2 values(seq_num.nextval, 'aa');
insert into bit_t values(autonum.nextval, 'bb');
insert into bit_t values(autonum.nextval, 'cc');
------------------------------------------------------
create table kosta_T (
    num number,
    name VARCHAR2(10)
)segment creation immediate;

select * from kosta_t;
create sequence seq_kosta
    INCREMENT by 100;

insert into kosta_t values(seq_kosta.nextVal, 'kk');
insert into kosta_t values(seq_kosta.nextVal, 'pp');
insert into kosta_t values(seq_kosta.nextVal, 'dd');

alter sequence seq_kosta
    INCREMENT by 1;

����]�ڵ����� ���������� seq_test ��� �����ϰ� 100 
    �����ؼ� 100 �����ϴ� �� �����,
    ���̺� seq_test ���̺�(num , name, phone)  �����. 
    ���ڵ� 3�� �߰��ؼ� Ȯ���ϱ�

--create sequence �������̸�--1���ͽ���
--[start with ���۰�]
--[increment by ����ġ]
--[maxvalue �ִ밪]
--[minvalue �ּҰ�]
--[cycle | nocycle ]
--[cache | nocache ]

-------------transaction

select*from tab;
create  table c_emp100
as  select*from emp where 1=0;

select*from c_emp100;
 begin
    for i in 1..10000 loop --for i��  1���� ������ ������ ������.   for ���� in ����..�� loop end loop
    insert into c_emp100--as��������
        select*from emp;
    end loop;
    end;
/ 
--�����°��� �������� ǥ��
------------------------Ʈ�����
rollback;    --��� �ӽ�.
   select*from c_emp100;
-- commit;   --�Ϸ�� commit

create table bitcamp_t(
    no number,
    name varchar2(20)
    );
    select*from bitcamp_t;   
    rollback;   --�ѹ�,commit�� ���̺��� ��������ִ°��� �ǵ����� ���Ѵ�. -> dml��ɾ�� ����ȴ�.
    drop table bitcamp_t;
    rollback;
    select*from bitcamp_t; --�������� �����Ұ����Ѱ� Ȯ��
    
    
-------------
select *from c_emp100 where deptno=20;
update c_emp100 set sal=1000;
rollback; --�ѹ��ϸ� ��

delete c_emp100 where deptno=20;

rollback;--����� ������.

------------save point-------
update c_emp100 set sal=100 where deptno=20;

savepoint update_sal;

update c_emp100 set sal=10 where deptno=30;
savepoint update_sal10;

select sum(sal) from c_emp100;

rollback to savepoint update_sal; --����� ���ư���

rollback to savepoint update_sal10;

commit;--Ŀ���ϸ� ���� ���ٲ�