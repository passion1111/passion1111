-- Join ----pk - fk 관계일때 사용 ----------------------
select * from dept;  -- 4 row
select * from emp;   -- 12 row
select * from dept, emp;

select 컬럼명, .....
from 테이블이름별칭[Inner] join 테이블이름별칭
on 별칭.컬럼명= 별칭.컬럼명;

select ename, job, sal, emp.deptno, dname
    from emp inner join dept
    on emp.deptno = dept.deptno;
    
select ename, loc, job, sal, d.deptno, dname
    from emp e inner join dept d
    on e.deptno = d.deptno;
    
INSERT INTO emp VALUES(
 0202, 'kingsmile', 'MANAGER', 7777,
 to_date('1-5-2012','dd-mm-yyyy'),
 2850, null, 20);
 
-- left outer join : 왼쪽에 있는 데이터 모두, 오른쪽 일치하는 데이터만..
 select ename, loc, job, sal, d.deptno, dname
    from emp e left join dept d -- 왼쪽, 오른쪽에 기재한 테이블명과 별칭
    --from dept d left join emp e -- 왼쪽, 오른쪽에 기재한 테이블명과 별칭
    on e.deptno = d.deptno;
    --on d.deptno = e.deptno; 

insert into dept(deptno, loc) values(50, 'SEOUL');
select * from dept;

-- right outer join : 오른쪽에 있는 데이터 모두, 왼쪽 일치하는 데이터만..
 select ename, loc, job, sal, d.deptno, dname
    --from emp e right join dept d -- 왼쪽, 오른쪽에 기재한 테이블명과 별칭
    from dept d left join emp e 
    --on e.deptno = d.deptno;
    on d.deptno = e.deptno; 

 inner join  =
 left outer join  *=
 right outer join  =*
 
 -- 여러 테이블(3개이상) 조인 방법
 select 컬럼명, .....
    from 테이블이름1 별칭1 outer left join 
        테이블이름2 별칭1 outer right join 테이블이름3 별칭3
    on 별칭1.컬럼명= 별칭2.컬럼명,
    on 별칭2.컬럼명= 별칭3.컬럼명
 
문제] emp, dept inner join 하기 
 출력 필드는 사원이름, 부서이름, 직책, 매니저번호 보기
 

