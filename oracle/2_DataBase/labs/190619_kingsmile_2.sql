-- Select -----
select * from emp2;
delete from emp2;
ROLLBACK;

select distinct | * | 컬럼명as 별칭, 컬럼명별칭,....
from 테이블이름
[where 조건식]
[order by 컬럼명desc | asc , .. ];
select * from emp2;
select distinct emp_type from emp2; -- 중복 제거

select * 
    from emp2
    where position ='부장';
    
select empno, name, pay, position 
    from emp2
    where position ='부장';
    
select empno as "사원번호", name "성 명", pay 급여, position "직급"
    from emp2
    where position ='부장';
    
select empno as "사원번호", name "성 명", pay 급여, position "직급"
    from emp2
    order by name ;  -- asc
    
select empno as "사원번호", name "성 명", pay 급여, position "직급"
    from emp2
    order by name desc;  -- desc

select empno as "사원번호", name "성 명", pay 급여, position "직급"
    from emp2
    where position ='부장' and name ='일지매';  -- and
    
select empno as "사원번호", name "성 명", pay 급여, position "직급"
    from emp2
    where position ='과장' or name = '김문호';  -- or 

select * from emp2 where deptno = 1000; -- 숫자
select * from emp2 where name like '김%'; -- 문자  % : 모든, _ :한문자

select * from professor where name like '허_';
select * from professor where name like '_은';
select * from professor where name like '__';

select * from professor where name like '%현%';
select * from professor where name like '%원_';
---- 숫자
select * from professor where pay > 500;
select * from professor where pay <= 300;
select name, pay from professor where pay >= 250 and pay < 500;
select * from professor where bonus is not null;
-- 급여가 500이상이고, 보너스가 60 이상 받는 교수는?
select * from professor where pay >= 500 and bonus >= 60;

--문제1] 이름이 '나한라'을 '너한라'으로 변경 
select * from emp2 where name ='나한라';
update emp2 set name='너한라' where name ='나한라';
    
--문제2] 취미가 등산인 사람들만 찾아서 '수영'으로 변경
select * from emp2 where hobby='등산';
update emp2 set hobby='수영' where hobby='등산';
select * from emp2 where hobby='수영';
   
--문제3] 계약직 직원 찾아서 삭제 하기
select * from emp2 where emp_type='계약직';
delete emp2 where emp_type='계약직';  -- delete 에서 from 생략가능
  
--문제4] pay( or bonus) 가 50이상인 사람만 출력
select * from professor where bonus >= 50;
delete from professor where bonus >= 50;
---------------------------
--문제5] ~세트 가 아닌 상품들만 출력
select * from gift where gname not like '%세트';

--문제6] gno가 10인 상품의 이름을 널처리(null) 하세요
select * from gift where gno = 10;
update gift set gname=null where gno=10;
select * from gift order by gno desc;

--문제7] gname 이름이 없고, g_start가 999인 값을 갖는 데이터 입력하세요.
insert into gift(gname, g_start) values(' ', 999);
select * from gift where gname is null or gname = ' ';

--문제8] gname이 null이거나 ' '인 데이터를 제외하고 출력하시오.
select * from gift where gname is null or gname = ' ';
select * from gift where gname not in('null', ' ') order by gno desc;
select * from gift where gname !=' ' 
        and gname is not null order by gno desc;
--- 연산자 -------
select mod(7, 3) from dual;
select name, bonus from professor;
-- null 연산은 무조건 null 
select name, bonus + 2000 from professor;
-- nvl(값, 대치값) : null이 있으면 대치값으로 변경
select name, nvl(bonus,0) + 2000 from professor;

update professor set bonus = bonus + 1000; -- 안된 상황임...
update professor set bonus = nvl(bonus, 0) + 1000; 
select * from professor;
rollback;

select * from gift where gno=1 or gno = 7 or gno =9;  
select * from gift where gno in(1, 7, 9); -- 권장
-- between 앞에값 작은값 and 뒤에값 큰값            
select * from gift where gno between 6 and 9;
select * from gift where gno between 9 and 6;  --안됨. 
select * from gift where g_end between 600000 and 800000;

-- emp2
--정규직 이면서 '백원만' 찾기
select * from emp2 where emp_type='정규직' and name='백원만';
--정규직 이면서 이씨인 사람들 찾기
select * from emp2 where emp_type='정규직' and name like '이%';
select * from emp2 where emp_type='정규직' and name not like '이%';

--정규직 이거나 '유도봉' 찾기
select * from emp2 where emp_type='정규직' or name='유도봉';
--수습직 이거나 김씨성을 가진 사람 찾기
select * from emp2 where emp_type='수습직' or name like '김%';
--김씨가 아닌 수습직원 찾기
select * from emp2 where emp_type='수습직' or name not like '김%';
---------------------------------------------

select * from PROFESSOR;
select profno, id, name 
    from PROFESSOR 
    where profno in(3001, 4001, 5001);
select profno, id, name from PROFESSOR 
    where profno not in(3001, 4001, 5001);

desc professor;
select profno, id, name from PROFESSOR 
    where profno between 3000 and 5000;
    
select id from professor where id like  'j_a%'; 
select * from professor where id like  's_a%';
select * from professor where id not like  's_a%';

select profno, id, name from PROFESSOR 
    where profno < any(1000, 2000, 3000); --  필드 < any(최대값) 보다 작은
select profno, id, name from PROFESSOR 
    where profno > any( 2002, 3000 ); -- 필드 > any(최소값) 보다 큰 값

select profno, id, name from PROFESSOR 
    where profno < all( 2002, 3000 ); -- 필드 < all(최소값) 보다 작은 값
select profno, id, name from PROFESSOR 
    where profno > all( 3002, 4003 ); -- 필드 > all(최대값) 보다 큰 값

select * from gift;
SELECT gno, gname, NVL(g_start, 0) + 1000, NVL(g_end, 100) + 3333 FROM gift;
rollback;

--퀴즈 1 **
--Professor 테이블에서 교수들의 이름을 조회하여 성 
--부분에 ‘ㅈ’  이 포함된 사람의 명단을 아래와 같이 출력하세요.
select name from professor
    where name between '자%' and '차%' 
    order by 1;  -- 정렬?

select * from gift order by gno desc, gname desc;
select * from gift order by 1 desc, 2 desc;




