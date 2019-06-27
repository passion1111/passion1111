--- rownum / rowid --------------------
select rownum, ename, sal, rowid from emp;

SELECT ROWNUM, ename, sal
    FROM (SELECT * FROM EMP ORDER BY sal);

 -- 게시판 만들었을때 페이징 처리....
-- 1 limit 7 : mySQL 

-- 가상 테이블 : dual 
select * from dual;
select sysdate from dual;

-- SID 확인하기 ---
SELECT * from v$database;
-- Sequence -------------------------
create sequence autonum;  -- 1부터 시작해서 1씩 증가한다
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

문제]자동증가 시퀀스명을 seq_test 라고 지정하고 100 
    시작해서 100 증가하는 것 만들고,
    테이블 seq_test 테이블(num , name, phone)  만들기. 
    레코드 3개 추가해서 확인하기

create sequence 시퀀스이름--1부터시작
[start with 시작값]
[increment by 증가치]
[maxvalue 최대값]
[minvalue 최소값]
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
    select * from emp where 1 = 2;  -- 조건에 맞지 않은 상탬

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
rollback; -- 취소 
commit;   -- 완료

create table bitCamp_T (
    no number,
    name varchar2(20)
);
select * from bitcamp_T;
-- rollback / commit ;  -- DML 명령어에만 적용된다.

