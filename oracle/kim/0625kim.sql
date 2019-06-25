
select *from emp;
select deptno,avg(sal) from emp group by deptno having 2000>avg(sal); 



--직위별 총급여를 갖는 뷰 테이블을 만들되 직위가 manager인 사원들은 제외하고 총급여가
--3000이상인 사원들 출력하시오              <>부등호 마주보는것도 먹힘

create view v_emp5
as select job,sum(sal) "총급여" from emp
where  job<> 'manager'             --!=대신 <>으로 씀
group by job
having sum(sal)>3000;

select*from emp where ename='KING';
--쿼리문은 대소문자 구분 안하지만 레코드는 대소문자 구분
select*from emp where ename='king'; --안나옴

--교수테이블에서 테이블 구조만 복사된 c_professor 새로운테이블생성(이름,직위 입사일,이메일,홈페이지)하고 레코드복사하기
select* from professor;
create table c_professor(name,position,hiredate,email,hpage) as select name,position,hiredate,email,hpage from professor where 1=0;
--c_emp2 테이블의 구조물만 복사 c_emp22로 만드세요
create table c_emp2 as select * from emp2 where 1=0;

--emp 테이블에서 c_emp22에 직위가 'manager'인 사람들과만 레코드 복사하시오 

select *from emp;
create table c_emp22 as select *from emp where job='MANAGER';
select* from c_emp22;

--레코드 복사 insert into 테이블 복사 create





















--- View -------------------
create view 뷰이름
as
    뷰의 내용;
    
create or replace view 뷰이름
as
    뷰의내용;
    
select * from professor;
select * from emp;
-------------------------------------------
create view v_emp
as
    select empno, ename, deptno from emp;
-----------------------------------------
select * from v_emp;

-- emp 테이블 제거하면 v_emp ?  o
-- v_emp 테이블 제거하면 emp ?  x
문제1] 30번 부서 사원들의 직위, 이름, 월급을 담은 view 테이블 만들기(emp)
drop view v_emp30;

create view v_emp30
as 
    select job, ename, sal
        from emp
        where deptno=30;

select * from v_emp30;

문제2] 30번 부서 사원들의 직위, 이름, 월급을 담은 
       view 테이블 만들기(emp), 컬럼명을 직위, 사원이름, 월급으로
       Alias를 주고 월급이 2000보다 많은 사원들만 추출해서 뷰 만들기

select * from emp;
drop view v_emp30_2;
create view v_emp30_2
as 
    select job "직위", ename "사원이름", sal "월급"
        from emp
        where sal > 2000 and deptno = 30;
    
select * from v_emp30_2;
-------------------------------
문제3] 부서별(부분합==소계) 최대급여, 최소급여, 평균급여를 갖는 뷰 만들기
create view v_emp3
as
    select deptno "부서" ,max(sal) "최대급여",
            min(sal) "최소급여", round(avg(sal), 3) "평균급여"
        from emp
        group by deptno;
        
select * from v_emp3;
----------------------------
문제4] 부서별 평균급여를 갖는 뷰를 만들되, 평균급여가 2000 이상인
      부서만 출력하도록 하시오.
SELECT * FROM emp;

CREATE VIEW v_emp4 
AS
 SELECT deptno, ROUND(AVG(sal),3) "부서평균"
 		FROM emp
 		GROUP BY deptno
 		HAVING AVG(sal) > 2000 ;

 SELECT * FROM v_emp4;
 
문제5] 직위별 총급여를 갖는 뷰 테이블 만들되, 직위(job)가 manager인
      사원들은 제외하고 총급여가 3000이상인 사원들 출력하시오.
CREATE VIEW v_emp5 
 AS
    SELECT job, SUM(sal) "총급여"
  	  FROM emp
        WHERE job <> 'MANAGER' -- WHERE job != 'MANAGER'
        GROUP BY job
        HAVING SUM(sal) > 3000 ;
        
        
 SELECT * FROM v_emp5;     

--------------------------------------
CREATE VIEW v_emp6 
 AS
    SELECT job, SUM(sal) "총급여"
  	  FROM emp
        WHERE job <> 'CLERK' -- WHERE job != 'MANAGER'
        GROUP BY job
        HAVING SUM(sal) > 3000 ;

select * from emp where ename='KING';
-- 쿼리문은 대소문자 구분 안하지만, 레코드는 대소문자 구분한다.
select * from emp where ename='king';
-----------------------------------------------------
문제7] 교수 테이블에서 테이블 구조만 복사된 c_professor 새로운 테이블 
     생성(이름, 직위, 입사일, 이메일, 홈페이지)하고 레코드 복사 하기
--------------------------------------------------------
drop table c_professor;
create table c_professor
as
  select name, position, hiredate, email, hpage 
    from professor where 1=0 ;  --조건에 만족하지 않는 상태 만듬
 ------------------------------------------------------ 
select * from c_professor;
----------------------------------------------------
insert into c_professor 
  select name, position, hiredate, email, hpage from professor;
------------------------------------------------------
문제8] c_emp22 테이블의 구조물만 복사 c_emp22로 만드세요
select * from c_emp22;
drop table c_emp22;

create table c_emp22
 as
  select empno, ename, job, sal from emp where 1=0;
  
select * from c_emp22;

------------------------------------------------------
문제9] emp 테이블에서 c_emp22에 직위가 'manager'인 
      사람들만 레코드 복사하시오.
      
 insert into c_emp22
  select empno, ename, job, sal from emp where job='MANAGER';
  
 insert into c_emp22
  select * from emp where job='MANAGER';

select * from c_emp22;
      
----------------------------------------------      
      
      