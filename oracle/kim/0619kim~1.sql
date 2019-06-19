-----select --------
select distinct | * | 컬럼명as 별칭, 컬럼명별칭,....
from 테이블이름
[where 조건식]
[order by 컬럼명desc | asc , .. ]

SELECT *from emp2;

--만약 삭제했다면..?
delete from emp2;
--이렇게하고 commit해버리면 복구안됑

select distinct emp_type from emp2;--중복제거

select * from emp2 where position='부장';

select empno as "사원번호", name "성 명" ,pay "급여",position "직급"
    from emp2 where position='부장' order by name;
select * from emp2  order by name desc;

select *from emp2 where name ='일지매'and  position='부장';

select *from emp2 where (name between '가%' and '다%') or position='대리';

select *from emp2 where deptno=1000;

select *from emp2 where name like '김%'; --문자 %:모든 ,_:한문자   그리고 %나 _는 like써줘야함


select *from professor where name like  '허%';
select *from professor where name like  '__';
select *from professor where name like  '_은';
select *from professor where name like  '%현%';

--숫자
select * from professor where pay >500;
select * from professor where pay<300;
select *from professor where 250<pay and pay<=500;
select *from professor where bonus is not null;
select *from professor where pay>=500 and bonus>=60;

select name from emp2 where name like'나%';

select *from emp2 where name='너한라';
update emp2 set name='너한라' where name='나한라';

update emp2  set hobby='수영' where hobby='등산';
select *from emp2 where hobby='수영';


--계약직 직원 찾아서 삭제하기
delete emp2  emp_type where emp_type='계약직';  --delete에서 from 생략가능.
select *from emp2 where emp_type='계약직';

--문제4 pay가 50이상만 출력하기.
select *from professor where pay>=50 or bonus >50;


--문5 ~세트가 아닌 상품들만 출력
select *from gift;
select * from gift where gname not like '%세트';
--문6 qno가 10인 상품의 이름을 null처리 하세요
update gift set gname='' where gno=10; 
--문7 qname 이름이 없고,g_start가 999인 값을 갖는 데이터를 입력하세요.
insert into gift(gname,g_start) values(null,999);
insert into gift(gname) values(' ');
--문8  gname이 null이거나 ''인 데이터를 제외하고 출력하시오
select *from gift where gname is not null and  gname not like '% %';
select *from gift where gname  in('null',' '); --null and ' ' 
select *from gift where gname!=' ' and gname is not null order by gno desc;

--연산자------
select mod(7,3) from dual; --나머지값 구하기
select name,bonus from professor;
--null연산은 무조건 null
select name,bonus+2000 from professor; --null은 더해지지않음
--nvl(값,대치값)
select name ,nvl(bonus,0)+ 2000 from professor; --nvl함수는 함수,값을 넣으면 null에는 해당하는 값이들어간다.

select *from professor;

update professor set bonus=bonus+1000; --안되는 상황임.
update professor set bonus=nvl(bonus,0) ;        --bonus를 0값으로 정해줌. 

select *from gift;

select *from gift where gno=1 or gno=7 or gno=9; --권장 x
select *from gift where gno in(1,7,9); --권장

select *from gift where gno between 6 and 9; --실행됨;
select *from gift where gno between 9 and 6;--아무값도 호출못함.
select *from gift where g_end between 60000 and 800000;

--emp2
--정규직이면서(and) '백원만'

select *from emp2 order by name;
select*from emp2 where emp_type='정규직'and name='백원만';
--정규직 이면서 이씨인 사람들 찾기
select * from emp2 where emp_type='정규직' and name like '이%';
select * from emp2 where emp_type='정규직' and name not like '이%';

--정규직이거나 유도봉찾기
select *from emp2 where emp_type='정규직' or name='유도봉';
--수십직이거나 김씨성을 가진 사람 찾기
select *from emp2 where emp_type='수습직'or name like '김%';
--김씨가 아닌 수습직원 찾기
select*from emp2 where emp_type='수습직' and  name not  like '김%';--between '가' and '나';

-------------------------------

select * from PROFESSOR;
select profno, id, name from PROFESSOR where profno in(3001, 4001, 5001);
select profno, id, name from PROFESSOR where profno not in(3001, 4001, 5001);

desc professor;
select profno, id, name from PROFESSOR where profno between 3000 and 5000;
select * from professor where id like  'j_a%'; 
select * from professor where id like  's_a%';
select * from professor where id not like  's_a%';

select profno, id, name from PROFESSOR where profno < any(1000, 2000, 3000); --any안에 가장 큰값을 찾고 profno가 더 작은지 찾음 필드<any(최댓값)
select profno, id, name from PROFESSOR where profno > any( 2002, 3000 ); --any안에서 가장 작은값을찾고 그것보다 큰지 확인.    필드<any(최솟값)

select profno, id, name from PROFESSOR where profno < all( 2002, 3000 ); --all안의 최소값보다 작냐    필드<all(최솟값)
select profno, id, name from PROFESSOR where profno > all( 3002, 4003 ); --all안의 최대값보다 큰지   필드>all(최댓값)

select * from gift;
SELECT gno, gname, NVL(g_start, 0) + 1000, NVL(g_end, 100) + 3333 FROM gift;
rollback;


--만약 점수를 계산하는데 과목중에 동점이 나올수가 있으니 2차정렬이필요함
select *from gift order by gno,gname;  --gno  orderby해주고 동일하면 gname 