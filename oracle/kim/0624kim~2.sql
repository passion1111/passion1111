--Subquary(서브쿼리)--

select*from emp2;

select *from emp2 where name='백원만' ;  --백원만의 페이보다 큰 사람들을 찾고싶음.
select*from emp2 where pay>6000000; 

select *from emp2 where pay>(select pay from emp2 where name='백원만');

--문제1 emp2 평균 급여보다 작은 사람 출력하세요
select name from emp2  where pay<(select avg(pay) from emp2) ;


--문제2 student 테이블에서 1학년 grade 평균 키보다 큰 사람들 출력하세요
select*from student where height>(select avg(height) from student where grade=1);

select *from department;

select*from studnet;

--문3  학생테이블,학과테이블을 사용하여 이윤나 학생과 전공(deptno1)이 동일한 학생들의 이름과 전공1의 이름을 출력하세요.
select deptno1 from student where name='이윤나';

select name,dname from student s,department d
    where s.deptno1=d.deptno;
    
    
    
    
    select name,dname from student s,department d
    where s.deptno1=(select deptno1 from student where name='이윤나')
    and s.deptno1=d.deptno;

--문제4 교수 테이블에서 입사일이 송도권교수보다 나중에 입사한 사람의 이름,입사일 ,학과명 기재
select *from professor where name='송도권';
select name,hiredate,deptno from professor where  (select hiredate from professor where name='송도권')<hiredate;

--문제5 학생 테이블에서 1전공이 101인 학과의 평균 몸무게 보다 몸무게가 많은 학생들의 이름과 몸무게를 구하세요.
select avg(weight) from student where deptno1=101;

select name,weight from student where weight>(select avg(weight) from student where deptno1=101);

select empno,name,deptno from emp2
    where deptno in(1000,1001,1002,1010);
    
    
    
    select * from emp;
select * from dept;
select*from department;
-- 1. 사원들의 이름, 부서번호, 부서이름을 출력하라. (emp, DEPT table)
     select ename,deptno,job from emp ;
     --부서이름 어디?
     
     
-- 2. DALLAS에서 근무하는  사원의 이름, 직위, 부서번호, 부서이름을
-- 출력하라. (dept table)
    select ename, dept.deptno,dname from dept,emp where emp.deptno=dept.deptno;
-- 3. 이름에 'A'가 들어가는 사원들의 이름과 부서이름을 출력하라. ( emp, dept,emp2 )
select * from emp where ename like '%A%';
-- 4. 사원이름과 그 사원이 속한 부서의 부서명, 그리고 월급을
--출력하는데 월급이 3000이상인 사원을 출력하라. (emp, dept )
      select * from emp;
select * from dept;

select ename,emp.deptno,dname,sal from emp,dept where emp.deptno=dept.deptno;

-- 5. 직위가 'SALESMAN'인 사원들의 직위와 그 사원이름, 그리고
-- 그 사원이 속한 부서 이름을 출력하라. (emp, DEPT)
      select dname,job,ename  from emp,dept      where    job='SALESMAN';




-- 6. 커미션이 책정된 사원들의 사원번호, 이름, 연봉, 연봉+커미션,
-- 급여등급을 출력하되, 각각의 컬럼명을 '사원번호', '사원이름',
-- '연봉','실급여', '급여등급'으로 하여 출력하라. ( emp, SALGRADE )
--(비등가 ) 1 : 1 매핑 대는 컬럼이 없다
select*from emp;
select*from salgrade;
select*from dept;
select ename 이름,sal 연봉,sal+comm 실급여,grade 급여등급 from emp,salgrade;

-- 7. 부서번호가 10번인 사원들의 부서번호, 부서이름, 사원이름,
-- 월급, 급여등급을 출력하라. ( emp, DEPT, SALGRADE )
select emp.deptno , empno,dname,sal,grade from emp,dept,salgrade;
-- 8. 부서번호가 10번, 20번인 사원들의 부서번호, 부서이름,
-- 사원이름, 월급, 급여등급을 출력하라. 그리고 그 출력된
-- 결과물을 부서번호가 낮은 순으로, 월급이 높은 순으로
-- 정렬하라. (emp, dept, SALGRADE )
select emp.deptno,dname,ename,sal,sal+comm from emp,dept,salgrade where emp.deptno=10 or emp.deptno=20 order by emp.deptno ,sal desc ;
-- 9. 사원번호와 사원이름, 그리고 그 사원을 관리하는 관리자의
-- 사원번호와 사원이름을 출력하되 각각의 컬럼명을 '사원번호',
-- '사원이름', '관리자번호', '관리자이름'으로 하여 출력하라. ( emp )
--SELF JOIN (자기 자신테이블의 컬럼을 참조 하는 경우)

select e.empno 사원번호,e.ename 사원, e.mgr 매니저번호 ,m.ename 매니저이름 
from emp e,emp m where e.mgr=m.empno;

--5장

select *from student;
select *from department;

select name ,dname from student,department where student.deptno1=(select deptno1 from student where name='이윤나') and department.deptno=student.deptno1;

select *from professor where (select hiredate from professor where name='송도권')<hiredate;

select*from student where weight>(select avg(weight)from student where deptno1=101);

select*from professor;
select name, pay,hiredate from professor where hiredate=(select hiredate from professor where name='심슨') and pay<(select pay from professor where name='조인형');

select*from dept2;

select empno,name,deptno from emp2 where deptno in (select dcode from dept2 where
area='서울지사');

select *from emp2;
select name,position,  to_char(pay,'999,999,999,999,999') from emp2 where pay<all (select pay from emp2 where position='과장');

select name,grade,weight from student  where weight<all (   select weight from student where grade=4);

select *from student;
select grade 학년 ,name 이름 , height "키" from student  where (grade,height) -- 학생 애들중에 graden height가 학년별로,최대몸무게의.
in (select grade,max(height) from student group by grade);

select *from professor;
select profno,name,deptno from professor where (deptno,hiredate) in(select deptno,max(hiredate) from professor group by deptno);
     
     
     select*from emp2;
     select name,position,pay from emp2 where (position,pay) in(select position,max(pay) from emp2 group by position) order by pay desc ;
     
     select *from emp2;
     select *from dept2;   --deptno랑 dcode랑 같음
     
     select dname,name,pay from emp2,dept2 where dept2.dcode=emp2.deptno  
                                                                and ( 
                                                                      emp2.pay<all( select  avg(pay) from emp2 group by deptno)                                                            
                                                                 --emp2.pay <all (  (deptno, pay) in(select deptno,avg(pay) from emp2 group by deptno ) )
                                                                                                                    
                                                                )  ;
                                                                


select name "사원이름",position "직급",pay "급여" from emp2 a
            where pay>=(select avg(pay) from emp2 b where a.position=b.position);
                                                                