-- SubQuery(서브쿼리) --------------------
select * from emp2;
select * from emp2 where name ='백원만';
select * from emp2 where pay > 60000000;

select * from emp2 where pay > 
            (select pay from emp2 where name ='백원만');

--문제1]emp2 평균 급여보다 작은 사람 출력하세요.
select avg(pay) from emp2;
select * from emp2 where pay < 43100000 ;

select * from emp2 where pay < (select avg(pay) from emp2) ;

--문제2]student 테이블에서 1학년(grade) 평균 키보다 큰 사람들 출력하시오. 
select avg(height) from student where grade = 1;

select * from student where height > 
    (select avg(height) from student where grade = 1);

select * from department; -- deptno
select * from student; -- deptno1
문제3]학생테이블, 학과 테이블을 사용하여 이윤나 학생과 전공(deptno1)이 
동일한 학생들의 이름과 전공의 이름을 출력하세요.

select deptno1 from student where name='이윤나';

select name, dname
    from student s , department d
    where  s.deptno1 = d.deptno;

select s.name, d.dname
    from student s , department d
    where s.deptno1 = (select deptno1 from student where name='이윤나') 
    and s.deptno1 = d.deptno;

select * from student;
select * from department;

문제4]교수 테이블에서 입사일이 송도권 교수보다 나중에 입사한 사람의
    이름, 입사일, 학과명을 출력하시오.
select hiredate  from professor where name='송도권'; 
-- 98/03/22
select p.name, p.hiredate, d.dname
  from professor p , DEPARTMENT d
  where hiredate > ( select hiredate  from professor where name='송도권' )  -- 입사일 이후/ 이전은 부등호 변경하면 됨
  and p.deptno = d.DEPTNO ;
    
문제5] 학생 테이블에서 1전공(deptno1)이 101인 학과의 평균 몸무게보다 
    몸무게가 많은 학생들의 이름과 몸무게를 출력하시오
select avg(weight) from student where deptno1 = 101 ;

select name, weight
  from student 
  where weight > 60 ;
------------------------------------
select name, weight
  from student 
  where weight > 
    (select avg(weight) from student where deptno1 = 101) ;

select empno, name, deptno
    from emp2
    where deptno in( 1000, 1001, 1002, 1010, 2000, 2001 );
    
select * from emp2;
select * from dept2;

select empno, name, deptno
    from emp2
    where deptno in( select dcode from dept2 where area='서울지사');
-----------------------------------
1. 사원들의 이름, 부서번호, 부서이름을 출력하라. (emp, DEPT table)
2. DALLAS에서 근무하는  사원의 이름, 직위, 부서번호, 부서이름을
 출력하라. (emp, dept table)
3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라. ( emp, dept )
4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
    출력하는데 월급이 3000이상인 사원을 출력하라. (emp, dept )
5. 직위가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
    그 사원이 속한 부서 이름을 출력하라. (emp, DEPT)

Oracle SQL_PLSQL_PPT  - ppt 5장 





