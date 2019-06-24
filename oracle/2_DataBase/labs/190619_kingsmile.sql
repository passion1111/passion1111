-- 테이블수정/ 삭제 -----
select * from de_test;
alter table de_test add gender char(2);
alter table de_test add 
        (no number(2), etc varchar2(50));

-- update tableName set 변경될 내용 ;
-- update tableName set 변경될 내용 where 조건 ;
update de_test set gender = 'F';
update de_test set etc='비트캠프' where addr='서울' ;
-- jeju 주소 사람의 성별을 남자로 변경 하세요.
update de_test set gender='m' where addr='jeju' ;
-- 하나의 컬럼 삭제
alter table de_test drop column no; 
-- 여러개 컬럼 삭제
alter table de_test drop(gender, etc);

-- datatype변경
--alter table 테이블이름 modify 컬럼이름 변경자료형
desc de_test;
select * from de_test;
-- 기본 데이터가 있었을 경우 문제 발생 소지 있음
alter table de_test modify tel number; 
alter table de_test modify gender number;  -- 컬럼의 데이터 타입 변경
update de_test set tel='' ;
rollback;  --  commit 명령어는 DML 명령어에만 적용된다.
alter table de_test modify addr number; 
-- delete tableName;  
-- delete tableName where 조건; 
update de_test set addr='' ;
alter table de_test modify tel VARCHAR2(15);
--컬럼이름변경
--alter table 테이블이름 rename column 기존컬럼명 to 변경컬럼명
alter table de_test rename column addr to addres;
alter table de_test rename column tel to phone;
select * from de_test;
-- table 삭제
drop table de_test;
delete de_test;  --레코드 삭제

select * from tab;
-- 삭제 테이블 목록 보기
show recyclebin;
desc recyclebin;
-- 복구(삭제된 테이블)
FLASHBACK table de_test to before drop;
select * from de_test;
purge RECYCLEBIN; -- 휴지통 비우기
select * from userlist;
drop table userlist;
FLASHBACK table userlist to before drop;
drop table userlist PURGE; -- 휴지통에 안남기고 완전 제거

---- 레코드삽입/ 수정/ 삭제 ----
--insert into 테이블이름(컬럼명, 컬럼명,...) values(값, 값, ...)
--insert into 테이블이름 values(값, 값, ...)
-- =>모든컬럼에 모두 값을 넣을때 사용
create table userlist(  --테이블 생성
    id VARCHAR2(10) primary key,  -- 기본키 제약조건
    name VARCHAR2(10),
    address VARCHAR2(30)
);
select * from userlist;
insert into userlist values('aa', 'bb', 'sss');
insert into userlist(id, address) values('kingsmile', 'busan');
insert into userlist(id) values('kang');
-------- update --------------------
update 테이블이름
    set 컬럼명=변경값, 컬럼명=변경값,.....
    [ where 조건식 ];

select * from userlist;
update userlist set name='cc' , address='seoul';
update userlist set name='cc' , address='seoul' where id='happy';
rollback;

delete userlist where name='bb';  
delete userlist where name=null;  --( X )
delete userlist where name is null; -- ( O )

select * from userlist where name is null;
update userlist set name =' ' where id='kang';
select * from userlist where name is null or name =' ';
select * from userlist where address is not null;

-- Delete table이름[ where 조건식]
-- truncate table 테이블이름; => 모든레코드삭제
select * from userlist;
truncate table userlist; -- where name ='cc'; --조건 사용 안됨








