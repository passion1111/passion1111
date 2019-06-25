--rownum/rowid
select rownum,ename,sal,rowid from emp; --rownum은 순차적으로 부여됨. rowid 시스템이 부여해주는 아이디.
-- 오라클은 어디서부터 어디까지 끊어오라는게 불가능 그래서 rownum을 씀
--게시판 만들었을떄 페이징 처리...


--가상 테이블: dual
select*from dual;
select sysdate from dual;

--sid알아보기-
select*from v$database;

--시퀀스는 최솟값지정하면 어느값정도는 무조건 넣어줘야함.
--사이클  일정사이클을 정할수가 있음.
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
-- sequence 변수 공유돼서 따로 만들어 줘야합니다.

    select *from bit_t2;
    create sequence seq_num;
    insert into bit_t2 values(seq_num.nextval,'aa');
    insert into bit_t2 values(seq_num.nextval,'bb');
    insert into bit_t2 values(seq_num.nextval,'cc');
    
    create table kosta_T(
    num number,
    name varchar2(10)
)segment creation immediate;  --안집어넣으면 첫번째가 2번부터 시작함. 

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
    
    
--    문제 자동증가 스퀀스 명을 seq_test라고 지정하고 100시작해서 100증가하는것 만들고
--테이블 seq_test( num,name,phoe)만들기 레코드 3개 추가해서확인하기
create table seq_testtable(
    num number,
    name varchar2(10),
    phone number
)segment creation immediate;  --안집어넣으면 첫번째가 2번부터 시작함. 

insert into seq_testtable values(seq_kosta2.nextval,'하하하',01044444444);
insert into seq_testtable values(seq_kosta2.nextval,'아하하',01044444444);
insert into seq_testtable values(seq_kosta2.nextval,'캬하하',01044444444);

select*from seq_testtable;















----
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

--create sequence 시퀀스이름--1부터시작
--[start with 시작값]
--[increment by 증가치]
--[maxvalue 최대값]
--[minvalue 최소값]
--[cycle | nocycle ]
--[cache | nocache ]

-------------transaction

select*from tab;
create  table c_emp100
as  select*from emp where 1=0;

select*from c_emp100;
 begin
    for i in 1..10000 loop --for i가  1부터 만까지 루프를 돌려라.   for 변수 in 시작..끝 loop end loop
    insert into c_emp100--as생략가능
        select*from emp;
    end loop;
    end;
/ 
--끝내는것은 슬러쉬로 표시
------------------------트랜잭션
rollback;    --취소 임시.
   select*from c_emp100;
-- commit;   --완료는 commit

create table bitcamp_t(
    no number,
    name varchar2(20)
    );
    select*from bitcamp_t;   
    rollback;   --롤백,commit은 테이블이 만들어져있는것은 되돌리지 못한다. -> dml명령어에만 적용된다.
    drop table bitcamp_t;
    rollback;
    select*from bitcamp_t; --없어진거 복구불가능한거 확인
    
    
-------------
select *from c_emp100 where deptno=20;
update c_emp100 set sal=1000;
rollback; --롤백하면 됨

delete c_emp100 where deptno=20;

rollback;--지운거 복구됨.

------------save point-------
update c_emp100 set sal=100 where deptno=20;

savepoint update_sal;

update c_emp100 set sal=10 where deptno=30;
savepoint update_sal10;

select sum(sal) from c_emp100;

rollback to savepoint update_sal; --여기로 돌아가자

rollback to savepoint update_sal10;

commit;--커밋하면 이제 못바꿈