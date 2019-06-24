--테이블 복사 &레코드 복사--

SELECT* FROM EMP; --DEMPTNO 50번이상은 불가능함.
SELECT*FROM DEPT;

--형식>
create table 복사할tablename as  select 필드명,필드명 from 테이블이름;

create table c_emp
    as select *from emp;
    select *from c_emp;  --테이블카피는 다복사되는데 제약조건은 복사되지않는다. 
    
    create table c_emp_20 as select*from emp where deptno=20; --테이블에도 조건가능.
    
    create table c_emp_30
    as select empno 번호 ,ename 이름,job 직업,sal 급여 from emp where deptno=30;
    select*from c_emp_30;
--    문제] 교수 테이블에서 전임강사만 뽑아서 테이블 생성하기
    select*from professor;
    
    create table c_professor 
    as select *from professor where position='전임강사';

    select*from c_professor;
--    문제2]emp직원 테이블에서 mgr매니저번호가 7934번인 사람만 추출해서 새로운 테이블 작성하기
    select *from emp;
    
    create table emp_7934 
    as select*from emp where mgr=7934;
    
--    레코드 복사 껍데기만 복사할떄 where 1=0으로하면 
create table c_emp4 
as select *from emp where 1=0;

select*from c_emp4; --구조물만 복사함

insert into c_emp4 select * from emp; --emp테이블을  c_emp4로 삽입


create table c_emp3
    as select *from emp
        order by ename desc,sal desc,empno asc; --정렬한 상태로 복사

create table c_emp5
    as select *from emp
        order by 1 desc,2 desc,3 asc; --필드 순서로 로도 가능
        
select *from c_emp5;

select*from c_emp; --전체복사
select*from c_emp_20; --조건(부서번호가20번인 레코드)에 맞게 테이블

create table c_emp_structure 
as select *from emp where 1=0;
select*from c_emp_structure; --구조물만 복사

--empno,ename,job,sal
create table three_column_emp
as select empno,ename,job,sal from emp;

select*from three_column_emp;

--unio  --pk ,fk  아닌 상태 테이블 합치기--
select*from emp       
union select *from c_emp; --중복 레코드 제거하고 합친다.

insert into c_emp(empno,ename,deptno)values(303,'김개똥',40);

select*from emp
union all select *from c_emp; --중복 레코드 포함.

--필드 개수,data type 일치시켜야함
--즉 같은 varchar2타입 또는 int타입이면 그냥 들어간다는 의미.
select empno,ename,job,sal from emp       
union select *from three_column_emp;

select empno,ename,job,mgr from emp       
union select *from three_column_emp;  --sal자리인데 mgr넣으니까 나옴. three_column_emp는 3개의 테이블가지고있는데 원래는 그것을 원하는게 아니여도 타입만 맞는 다른 컬럼이
--출력될수도 있다느 의미.
 -- c_emp_20,c_emp4 union 결과?
 select empno,ename,job,sal from emp;
 
--문제4]사원번호,이름,급여 그리고 15%인상된 급여를 정수로 표시하되 컬럼명을 new Sallary로 지정하여 출력하시오.
 select empno,sal ,round((sal*1.5),0) as sallary from emp;
 
 select empno,ename,sal,cast(sal*1.5 as int) "new sallary" from emp;   --as int는 int형으로.
 
--각 사원의 이름을 표시하고 근무 달 수를 계산하여 컬럼명을 Months works로 지정하고 근무달수를 기준으로 오래된 사람부터 정렬하여 출력하시오.


select ename,hiredate ,round(MONTHS_BETWEEN(SYSDATE,hiredate),0 ) as months_works from emp
order by months_works ;

--문제6] 사원의 이름과 커미션을 출력하되 커미션이 책정되지 않은 사원의 커미션은 'no commission'으로 출력하세요.
select *from emp;

select ename,cast(comm as varchar2(20)) from emp;

select ename,cast(comm as varchar2(20)) from emp where comm is null;

select ename ,nvl(cast(comm as varchar2(20)),'no commission') from emp;


--------------------------------------------------------------------------

insert into 테이블이름 select 컬럼명,...from 테이블 이름;

insert into  c_emp_structure select * from emp ;
select*from emp;
--문 1 emp 테이블에서 이름,사번 ,입사일 필드만 갖는 구조물만 복사 c_emp6 테이블 만듬
create table c_emp6 as select ename,empno,hiredate from emp where 1=0;
--문 select*from emp6에다가 emp2 테이블에서 레코드 복사하기;
select*from emp2;  --empno,name,birthday레코드 복사하기

alter table c_emp6 modify empno number(10); --modify에 콤마하지말것.

insert into c_emp6 select name,empno,birthday from emp2;



