--테이블 수정/삭제----
--컬럼추가 alter table 테이블이름add  (컬럼명자료형[제약조건] , 컬럼명자료형[제약조건] , ....)
--컬럼삭제 alter table 테이블이름drop column 컬럼이름
--datatype변경 alter table 테이블이름modify 컬럼이름변경자료형
--컬럼이름변경 alter table 테이블이름rename column 기존컬럼명to 변경컬럼명
--테이블삭제 drop table 테이블이름

select *from de_test;  
alter table de_test add gender char(2);   --성별 추가해주기위해적는것    add뒤에 추가할 변수명이 한가지일떄는괄호 안적어줘도됨.
--테이블의 위치 name옆에 gender삽입을 원한다. 근데 그렇게는 안돼여

alter table de_test add (no number(2),etc varchar(50) ); --값이 여러개가 들어가야 할떄는 괄호로 묶어줘야함 no와 varchar2개 들어가니까.

--update tablename set 변경할 내용;   이렇게 쓰면 전체가 다바뀜.
--update tablename set 변경할 내용 where 조건;  이렇게 쓰면 조건에 맞는것만 바뀜.

update de_test set gender='F';  -- 한글로 적어주면 글자당 3바이트인식함.  이렇게 적으면 모든테이블 gender값이 f로 변함.
update de_test set etc='비트캠프'where addr='서울';  --서울인사람을 비트캠프로 변경 
update de_test set etc='비트별관' where addr not in('서울');  --서울이 아닌  사람들을 비트별관으로

--jeju 주소 사람의 성별을 남자로 변경하세요
update de_test set gender='M' where addr='jeju';  

--삭제할것임
alter table de_test  drop column no  ;      
--de_test의 drop테이블의 no열을 삭제하는것
alter table de_test  drop(gender,etc); --컬럼안적어도됨

--datatype 변경
--alter table 테이블이름 modify 컬럼이름 변경자료형

desc de_test;
select *from de_test;
-- 기본 데이터가 있었을 경우 문제 발생 소지있음.
alter table de_test modify tel number;  --null이 아니여서 바꿀수가 없음.
alter table de_test modify gender number; --컬럼의 데이터 타입 변경

update de_test set tel='';  --null값을 넣어버림 자료형변경을위해
rollback;          --commit, rollback 명령어는 dml명령어에만 적용된다.insert select update delete에만 적용

alter table de_test modify addr number;

select*from de_test;
--delete tableName field;           --전체 삭제
--delete de_test addr where 조건; 
delete  de_test addr where addr='서울' ;  --서울들어간애들 삭제
alter table de_test modify tel varchar2(15);
desc de_test;       --tel이 varchar타입으로 바뀌었음.
--truncate table 테이블이름; ->모든 레코드 삭제
select*from userlist;
TRUNCATE table userlist where name='cc';  -- 조건 사용할수 없음 에러뜨는게 정상.
TRUNCATE TABLE userlist;       --이렇게만 써야함



--컬럼 이름 변경
--alter table tablename rename column 기존컬럼명to변경 컬럼명
alter table  de_test rename column addr to address;
alter table de_test rename column tel to phone;

--table 삭제
drop table de_test ; -- 구조물 자체를 삭제
delete de_test; --레코드 삭제

select *from tab; --구조물 자체를 삭제하고 보면 파일찌꺼기는 남아있음여
--drop으로 삭제하고 확인하면 찌꺼기확인하는과정
show recyclebin;       
--찌꺼기들 보기.
desc recyclebin;

FLASHBACK TABLE de_test to before drop; --복구할건데 de_test를 drop하기전으로 복구하는것
select*from de_test;
purge RECYCLEBIN;--찌꺼기 지우기
select *from userlist;
drop table userlist;  --이방식은 휴지통에 남음
FLASHBACK table userlist to before drop; 
drop table userlist PURGE; --찌꺼기에도 없음.

--레코드 삽입/수정/삭제--
insert into 테이블이름(컬럼명, 컬럼명,...) values(값, 값, ...)  --컬럼 선언된 순서대로 values값 넣어주면 됨.
insert into 테이블이름values(값, 값, ...)      --순서 꼭 지켜서 넣어야함
=>모든컬럼에모두값을넣을때사용


create table userlist(  --테이블 생성
    id VARCHAR2(10) primary key, 
    -- 기본키 제약조건 
--varchar와 primary key사이에 ket값이름 정할수있음
    name VARCHAR2(10),
    address VARCHAR2(30)
);

insert into userlist values('aa','bb','cc');
select *from userlist;
insert into userlist(id,address) values('king','buss');
insert into userlist(id) values('happy');  --primary key때문에 userlist 괄호사이에 id로 적어줘야함


--------------update----------------
update 테이블이름
    set 컬럼명=변경값,컬럼명=값,....x
    [where 조건];
    
select *from userlist;
update userlist set name='cc',address='seoul';
rollback;

delete userlist where name='bb';
delete userlist where address=null;     -- ''  null로 해도 안됨 null값을 지울려면 어떻게해야할지 생각해봄
delete userlist where address is null;-- null인애들 삭제시킴

select * from userlist where name is null;
update userlist set name ='' where id='king';
select *from userlist where name is null or name=' ';
select*from userlist where name is not null;

