-- 테이블 복사 & 레코드 복사
select * from emp;
-- 형식>
create table 복사tableName
    as select 필드명, 필드명,....from 테이블이름;
-- 제약조건은 복사되지 않는다.    
create table c_emp
    as select * from emp;

select * from c_emp;

create table c_emp_20
    as select * from emp where deptno=20;
    
select * from c_emp_30;

create table c_emp_30
    as select empno 번호, ename 이름, job 직업, sal 급여 
    from emp 
    where deptno=30;
    
--문제1]교수 테이블에서 전임강사만 뽑아서 테이블 생성하기
create table c_professor
    as select * from professor where position='전임강사';

--문제2]emp(직원)테이블에서 mgr(매니저번호)가 7566번인 사람만 추출해서
--    새로운 테이블 생성하기
create table c_emp_mgr
    as select *  from emp where mgr=7566;

select * from c_emp_mgr;   
select * from c_professor;

-- 형식>
create table 복사tableName
    as select 필드명, 필드명,....from 테이블이름 where 1=0;

create table c_emp4
    as select * from emp where 1 = 0;

select * from c_emp4;
desc c_emp4;

create table c_emp3
    as select * from emp
    order by ename desc, sal desc, empno asc;
    
select * from emp
    order by ename desc, sal desc, empno asc; -- 필드명으로 정렬가능
또는
select * from emp
    order by 2 desc, 6 desc, 1 asc;    -- 필드 순서번호로도 정렬 가능
------------------------------------------
--형식>
insert into 테이블이름
    select 컬럼명, ... from 테이블이름

select * from c_emp; -- 전체복사
select * from c_emp_20; -- 조건(부서번호가 20번인 레코드)에 맞게 테이블 생성
select * from c_emp4; -- 구조물만 복사( 레코드 복사 제외 )
select * from c_emp2; -- empno, ename, job, sal 원하는 필드만 복사
select * from c_emp_30;
create table c_emp2 
    as select empno, ename, job, sal from emp;
    
-- UNIO --pk - fk 아닌 상태 테이블 합치기 -------------------
select * from emp
union   -- 중복 레코드 제거하고 합친다.
    select * from c_emp;

insert into c_emp(empno, ename, deptno) values(303, '이도연', 40);

select * from emp
union all  -- 중복 레코드 포함하고 합친다.
    select * from c_emp;

select * from c_emp2;

select * from emp -- 필드 개수, data type 일치시켜야함
union 
    select * from c_emp2;

select empno, ename, job, sal from emp -- 필드 개수, data type 일치시켜야함
union 
    select * from c_emp2;

select empno, ename, job, sal from emp -- 필드 개수, data type 일치시켜야함
union 
    select * from c_emp2;
    
select empno, ename, job, hiredate from emp -- 필드 개수, data type 일치시켜야함
union 
    select * from c_emp2;
------------------------------------------------    
--문제2] c_emp_20, c_emp4 union 결과?
select * from c_emp_20
union
    select * from c_emp4;
    
--문제4] 사원번호, 이름, 급여 그리고 15%인상된 급여를 정수로 표시하되
--    컬럼명을 New Salary로 지정하여 출력하시오.
select empno, ename, sal, round((sal * 1.15),0) "New Salary"
    from emp;

select empno, ename, sal, Cast(sal * 1.15 as int) "New Salary"
    from emp;
    
--문제5]각 사원의 이름을 표시하고, 근무 달 수를 계산하여 컬럼명을 
--     Months_Works로 지정하고, 근무 달수를 기준으로 오래된 사람부터
--     정렬하여 출력하시오.
select ename, hiredate, Months_between(sysdate, hiredate) as "Months_Works"
    from emp
    order by hiredate desc;  -- 정렬은 별칭으로는 안된다
    
select ename, hiredate, 
    round(Months_between(sysdate, hiredate),0) as "[Months_Works]"
    from emp
    order by hiredate desc;

문제6]사원의 이름과 커미션을 출력하되, 커미션이 책정되지 않은 
    사원의 커미션은 'no commission'으로 출력하시오.
select ename, Cast(comm as varchar2(20)) from emp;   

select ename, Cast(comm as varchar2(20)) from emp;  

select ename, Cast(comm as varchar2(20)) 
    from emp where comm is null;  
-- nvl 함수 사용해서 다시 설정함 - 자료형 타입 문자열로 변경해서 설정함
select ename, nvl(to_char(comm),'no commission') as comm
    from emp;
    
select ename, nvl(Cast(comm as varchar2(20)), 'no commission') 
    from emp; 

desc emp; 
-------------------------------
--형식>
insert into 테이블이름
    select 컬럼명, ... from 테이블이름;
    
select * from c_emp4;    

insert into c_emp4
    select * from emp;
문제] emp 테이블에서 이름, 사번, 입사일 필드만 갖는 구조물만 복사
     c_emp5 테이블로 만드시오
drop table c_emp5;
create table c_emp5
    as select ename, empno, hiredate from emp where 1=0;
select * from c_emp5;

문제] c_emp5테이블에다가 emp2 테이블에서 레코드 복사하기
select * from emp2;에서 empno, name, hirthday 레코드 복사하기
insert into c_emp5
    select empno, name, birthday from emp2;

select * from emp2;
select * from emp;
desc emp2; -- NAME     NOT NULL VARCHAR2(15)
EMPNO    NOT NULL NUMBER       
NAME     NOT NULL VARCHAR2(15) 
BIRTHDAY          DATE         

desc emp;  -- NAME     NOT NULL VARCHAR2(15)
EMPNO       NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
HIREDATE          DATE         

drop table c_emp5;
create table c_emp5
    as select ename, empno, hiredate from emp where 1=0;
select * from c_emp5;
---------------------------------
insert into c_emp5
    select Cast(name varchar2(15)), empno, birthday from emp2;

insert into c_emp5
    select convert(name, varchar2(15)), empno, birthday from emp2;
    