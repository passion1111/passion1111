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

create sequence �������̸�--1���ͽ���
[start with ���۰�]
[increment by ����ġ]
[maxvalue �ִ밪]
[minvalue �ּҰ�]
[cycle | nocycle ]
[cache | nocache ]
------------------------------------
create sequence seq_jumin_no
  increment by 10
  start with 100
  maxvalue 150
  minvalue  90
  cycle
  cache 2
 --------------------------------------------- 
create table jumin_T (
    seq  number,
    name  varchar2(10),
    phone  varchar2(15)
  ) segment creation immediate ;
    
insert into jumin_T values(seq_jumin_no.nextVal, 'aa', '111' );
insert into jumin_T values(seq_jumin_no.nextVal, 'bb', '222' );
insert into jumin_T values(seq_jumin_no.nextVal, 'cc', '333' );
insert into jumin_T values(seq_jumin_no.nextVal, 'dd', '444' );
insert into jumin_T values(seq_jumin_no.nextVal, 'ee', '555' );

select * from JUMIN_T;
------ Transaction ----------------------------------------
select * from tab;
create table c_emp100
as  
    select * from emp where 1 = 2;  -- ���ǿ� ���� ���� ����

select * from c_emp100;
----------------------
begin 
    for i in 1..10000 loop
        insert into c_emp100
            select * from emp;
    end loop;
end;
-------------------------------
select * from c_emp100;
rollback; -- ��� 
commit;   -- �Ϸ�

create table bitCamp_T (
    no number,
    name varchar2(20)
);
select * from bitcamp_T;
-- rollback / commit ;  -- DML ��ɾ�� ����ȴ�.

