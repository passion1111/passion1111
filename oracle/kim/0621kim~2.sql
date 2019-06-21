-------join---------------- pk i- fk 관계일떄 사용-------

--join - pk/fk   (o)

--union pk/fk  (x)

select* from dept;           

select*from emp;

--직원은 모두 부서안에 속해있어야한다. 

select* from dept,emp;

select 컬럼명,...
from 테이블 이름별칭[inner] join 테이블 이름 별칭
on 별칭. 컬럼명=별칭.컬럼명;

select ename , job,sal, deptno, dname from emp inner join dept where emp.deptno=dept.deptno;  --where로 쓰는게 아니라 on으로 써야하고 on으로 쓰더라도 deptno컬럼이 겹치기떄문에.
                                                                                --무엇을 쓸지 정해줘야 합니다.

select ename , job,sal, emp.deptno, dname from emp inner join dept on emp.deptno=dept.deptno;  --on으로 바꿨고 emp.deptno로 emp로 알수있게 만듬.
--별칭으로 지정하면 간단 한칸띄고 별칭


select ename , job,sal, d.deptno, dname from emp inner join dept d on emp.deptno=d.deptno;   --d로 별칭 지정.

select ename, loc, job, sal ,d.deptno,dname from emp e inner join dept d on e.deptno=d.deptno;

select *from emp;
INSERT INTO emp VALUES(
  7935, 'kingsmile', 'MANAGER', 7777,
 to_date('1-5-1981','dd-mm-yyyy'),
 2850, null, 10);
 
 
--외래키는 참조의 느낌.


select ename, loc, job, sal ,d.deptno,dname from emp e inner join dept d on e.deptno=d.deptno;

--left outer join :  왼쪽에있는 데이터 모두,오른쪽에 있는 테이블은 일치하는 데이터만 출력
select ename, loc, job, sal ,d.deptno,dname 
--from emp e left join dept d  --왼쪽,오른쪽에 기재한 테이블명과 별칭을 확인.
from dept d left join emp e
--on e.deptno=d.deptno;
on d.deptno=e.deptno;   --하나가 더 나옴. on에 일치하는 데이터만.

insert into dept(deptno,loc) values(50, 'SEOUL');  --emp는 dept50이 없음. 그래서 바로 위 실행하면 
SELECT* FROM DEPT;


--right outer join: 오른쪽에 있는 데이터는 모두 왼쪽에있는데이터는 일치
select ename, loc, job, sal ,d.deptno,dname 

from dept d right join emp e

on d.deptno=e.deptno;   

inner join   ==
left outer join *=

left outer join =*

-- 여러 테이블(3개이상)을 조인하는방법.
select 컬럼명, .....
from 테이블이름1 별칭 
outer left join 테이블이름2 별칭 outer right join 테이블이름3 별칭
on 별칭.컬럼명 = 별칭.컬럼명 , on 별칭.컬럼명=별칭.컬럼명;

--문1 emp,dept inner join 하기
select *from emp;
select *from dept;
출력 필드는 사원이름(ename),부서이름(deptno),직책(job),매니저번호(mgr) 보기
select  ename, emp.deptno, job ,mgr from emp inner join dept on emp.deptno=dept.deptno;