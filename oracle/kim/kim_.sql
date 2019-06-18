create table userlist(id varchar2(10) constraint id_pk primary key, --constraint가 제약조건 id_pk안쓰면 기본키가없는 제약조건을만들어주는것 기본키는 t.n_f.n_성격으로 지어주면 해석하기좋음
name varchar2(10) not null --primary키는 not null안써도 notnull임 왜냐하면 not null이 안되니까.   primary key는 유일성을 가지는것에만 넣어줘야함.
);
--하나의테이블에기본키는반드시한개만존재. 전제조건이지만 2개씩도 걸수있음.
select*from userlist;

insert into userlist VALUES('aa','bb');
insert into userlist(name,id)  VALUES('cc','ddd');  --지금은 하나만 못넣음. 왜냐하면 위에 제약조건으로 notnull로하라고 해있으니까

select *from emp2;
select*from professor;
select*from hakjum;
select min_point,max_point+1000 from hakjum;
select max_point from hakjum where max_point>80;
select name,pay,deptno from professor where name='조인형';
select name,pay,deptno from professor where name like '김%%'; --김으로 시작하는 사람 검색
select name,position,pay,hiredate from professor where pay between 100 and 600;

--null은 정해지지않아서 값을 모른다 0과는 다르다
select name,email from professor where hpage is null;
select name ,position from professor where pay between 100 and 600 and position='정교수'; --정교수이면서 가격은 페이는 100~600사이

--ㅈ이 포함된 사람의 데이터를 뽑아오기
select name from professor where name between '자%' and '차%'; --ㅈ가 포함된 사람들 출력하기

select *from student;
select name, height from student where grade=1 order by height,weight desc;-- 몸무게 많은순 키 작은순
select name,birthday,height from student order by 3; --선언된 컬럼의 위치 name,birthday ,height가 각각 1 2 3
select name "이름",height "키" from student; --이름과 키로 별명을 사용

select name"이름"from student where name between '자' and '차'union all select name"이름"from professor where name between '자' and '차'; --교수와 학생중 ㅈ로 시작하는 사람 모두출력
--union 중복제거후 출력 union 중복 제거안하고 출력 intersect 교집합 minus차집합  그리고 " " 는 별칭떄 사용하고 문자열은 ' ' 식으로 사용함


select*from member;

drop table de_test;
create table de_test(
name varchar2(10) not null,addr VARCHAR2(10) default '서울',tel varchar2(15));  --default 속성을 위해서 하나 만들어줌.  디폴트값조차 안주면 어떻게되는지보는것.
select *from de_test;

insert into de_test(name,addr,tel) VALUES('aa','busan','111');

insert into de_test(name,addr,tel) VALUES('bb',default,'333'); --default이기떄문에 서울이라고 들어감. 

insert into de_test(name,addr,tel) VALUES('cc' ,'jeju', '111');--addr이라고 선언해줬으면 default나 null을 넣고싶으면 무조건 입력해줘야함.

insert into de_test(name,addr) VALUES('aa','busan'); --tel을 비우니 들어감. 즉 usertable(변수명,변수명)을 생략시켜주면됨.
insert into de_test(name,tel) VALUES('aa','111'); --addr을 입력안해줬으니 알아서 default값이 들어감.

insert into de_test(name,addr,tel) VALUES('aa',null,'111'); --이렇게 null이라고 입력시켜줘야함