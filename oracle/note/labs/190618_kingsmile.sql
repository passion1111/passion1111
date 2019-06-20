select * from tab;

create table SampleTable (
    num number,
    name varchar2(20),
    phone VARCHAR2(15),
    address VARCHAR2(50)
);

select * from sampletable; -- 전체 보기 

select name, address from sampletable; -- 특정 필드만 보기

desc sampletable;  -- 해당 테이블 구조 보기

---- insert ---
insert into sampletable VALUES(10, 'doyeon', '010-9872-0202', '서울');
insert into sampletable VALUES(20, '강감찬', '010-5555-8888', '부산');

insert into sampletable(name, phone, address, num) VALUES('영학', '999','jeju', 30);
insert into sampletable(name, phone) VALUES('세종', '77777');

update sampletable set address = '대구' ; -- 전체 수정된다
ROLLBACK;
update sampletable set address = '대구' where num = 30; -- 조건에 맞는것만 수정된다

update sampletable set address = '전주', num = 40 where name = '세종';

select * from sampletable;

delete sampletable;  -- 전체 레코드 삭제
delete sampletable where address = 'jeju'; -- 조건에 맞는 레코드 삭제
delete sampletable where num between 10 and 20; 

drop table sampletable;
--------------------------------
-- 주석
select * from emp2;
select empno, name, emp_type, deptno from emp2;
select * 
    from emp2 
    where emp_type = '계약직'
   -- order by name;
    order by name desc;
    
select * from tab;

desc emp2;  -- 
show user;

select sysdate from dual;
select sysdate from emp2;
