select * from gift;
select sum(g_start) "시작값합계", sum(g_end) as "최대값합계" from gift;

select max(g_start), min(g_start) , avg(g_end)
  from gift;
  
select count(*) from gift;  -- null 포함
select count(gname) from gift;   -- null 제외

select rank(600000) within group(order by g_end desc) from gift;

select rank(600000) within group(order by g_end desc) 
  from gift
    where g_end is not null ;  
    
--문제] g_end 가 200000, 600000 보다 작은 값 출력 (any 이용하세요)
 --select * from gift where g_end >= 200000 and g_end <= 600000 ;
 select * from gift where g_end < any(200000, 600000) ;
 cf)  select * from gift where g_end > any(200000, 600000) ;

select * from student;
--문제] 학생들의 키의 합과 평균, 가장 키가 큰 친구, 작은친구 출력하기
 select sum(height) 합계, avg(height), max(height) , min(height) from student;
---------------------------------------------------------  여기서부터 할차례~~
select sum(height) 합계, avg(height), max(height) , min(height) 
  from student   -- 전체에 대한....
  --where 조건절
  group by grade ;  -- 부분합(소계) 

select grade, sum(height) 합계, avg(height), max(height) , min(height) 
  from student   -- 전체에 대한....  ,  그룹(집계)함수는 일반필드와 같이 사용할 수 없다.
  --where 조건절
  group by grade ;  -- 부분합(소계) 
--------------------------------------------
-- 조건 : where , having 절 이용한다.
select grade, max(height) , min(height) , avg(height)
  from student   -- 전체에 대한....  ,  그룹(집계)함수는 일반필드와 같이 사용할 수 없다.
  group by grade   -- 부분합(소계) 
  having avg(height) > 173 ;  -- group by 조건을 사용하는것은 having절 조건

select deptno, avg(nvl(pay, 0)) "평균급여"
  from professor
  group by deptno;
  
select deptno as "학   과", avg(nvl(pay, 0)) "평균급여"
  from professor
  group by deptno;  


select deptno as "학   과", avg(nvl(pay, 0)) "평균급여"
  from professor
  group by deptno
  having avg(pay) > 450 ;  -- group by 절이 있을 경우 조건은 having 절을 사용한다.
 -----------------------------------------------------------------------  
--문제7] emp2 테이블에서 deptno(부서별)로 pay  합과 평균을 구하시오
  select deptno, sum(pay), avg(pay) from emp2 group by deptno;
  
--문제8] emp2 테이블에서 emp_type 별로 pay 합과 평균을 구하시오
 select emp_type, sum(pay), avg(pay) from emp2 group by emp_type;

--문제9] emp2 테이블에서 emp_type 별로 최고 급여, 최하 급여 구하시오.
 
--문제10] emp2 테이블에서 직급별(position)로 급여의 합을 구하고, 급여 평균을 구하시오.

select round(12.45678935, 0), round(12.45678935, 2) , round(12.55678935, 0)  from dual;

select ceil(12.34), ceil(-12.34) from dual;  -- 올림 한 후 정수 반환

select floor(12.34), floor(-12.34) from dual;  -- 내림 한 후 정수 반환

select trunc(12.3456, 2), trunc(12.3756, 2),  trunc(12.3756, 0),  trunc(12.7756, 0) from dual; 
--------------------------------------------------------------------

select instr('abcd', 'b') from dual;  -- 2
select instr('abcdfghijkbop', 'b', -1 ) from dual;    -- -1이면 뒤에서부터 찾는다...
select instr('abcdfghijkbopgjkjtertw9494 b993', 'b', -3 ) from dual;

select lpad('abcd' , 20, '#') from dual;
select rpad('abcd' , 20, '@') from dual;

select * from dept2;
select RPAD(dname, 10, '*' ) "RPAD연습" from dept2 ;
select RPAD(dname, 10, substr('1234567890', length(dname)+1) ) "RPAD연습" from dept2 ;

select lpad(dname, 10, '1234567890') "LPAD연습" from dept2;
select rpad(dname, 10, '1234567890') "RPAD연습" from dept2;

select dname,  length(dname) from dept2;

select * from student;

select name, rtrim(regexp_replace(name, '(.)', '\-1' ), '-' ) "변경후" 
    from student
    where deptno1 = 103; 

select to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') from dual;
select sysdate from dual;

-- Oracle SQL_PLSQL_PPT > 2, 3장 실습 
-----------------------------------------------------------------
select Months_between
  ( to_date('02-17-2017', 'MM-DD-YYYY') ,
    to_date('01-01-2016', 'MM-DD-YYYY')   )  "Months"
  from dual;

select Months_between
  ( to_date('07-31-2015', 'MM-DD-YYYY') ,
    to_date('12-20-1988', 'MM-DD-YYYY')   )  "Months"
  from dual;

select to_char(add_months(hiredate, 1), 'DD-MM-YYYY' ) "Next month"
  from professor
  where name='심슨'
  
select * from professor;
select * from emp2;

select to_char(
              add_months(birthday, 1), 'DD-MM-YYYY' ) "Next month"
  from emp2
  where name='나사장'
-------------------------------------------
select next_day('2001/01/20', 2) "Next Day" from dual;  -- 1 : 일요일  2:월요일,....
select next_day('1988/01/20', 2) "Next Day" from dual;
select next_day('2017/02/03', 6) "Next Day" from dual;  -- 6 : 금요일 
-------------------------------------------------------
select sysdate,
    Last_day(sysdate) "Last",
    Last_day(sysdate) - sysdate "Days Left"
    from dual ;
----------------------------------------------------------
select birthday,
    Last_Day(birthday) "Days Left"
    from emp2;
-----------------------------------------------
select * from department;
select * from tab;
select * from product;

select p_code, 
          DECODE( p_code ,  100 , 'NEW YORK' ,
                                   101 , 'DALLAS' ,
                                   102 , 'BOSTON' ,
                                   105 , 'CHICAGO' ,
                                          '지역을 몰라요' )
          "Location of inventory"
      from product 
      where p_code < 103 ;

-------------------------------------------------------------------------------
SELECT product_id,
       DECODE (warehouse_id, 1, 'Southlake',
                             2, 'San Francisco',
                             3, 'New Jersey',
                             4, 'Seattle',
                                'Non domestic')
       "Location of inventory" FROM inventories
       WHERE product_id < 1775;
       
SELECT * FROM inventories ;
select * from dept;

SELECT deptno, DECODE(deptno, 10 , 'ACCOUNTING' ,
                              20 , 'RESEARCH' ,
                              30 , 'SALES', 'OPERATIONS') name
  FROM dept;
 
-- 10부서는 급여합계를, 20부서는 최대값을, 30부서는 최소값을 출력하는 예제
select * from emp order by deptno;
SELECT deptno, DECODE(deptno, 10 , SUM(sal),   --8750
                              20 , MAX(sal),    --3000
                              30 , MIN(sal)) sal  --950
  FROM emp
 GROUP BY deptno; 
 
 -- 부서별로 급여 합계를 출력한다. 
SELECT deptno, NVL(SUM(DECODE(deptno, 10, sal)),0) deptno10, 
               NVL(SUM(DECODE(deptno, 20, sal)),0) deptno20,
               NVL(SUM(DECODE(deptno, 30, sal)),0) deptno30,
               NVL(SUM(DECODE(deptno, 40, sal)),0) deptno40
  FROM emp
 GROUP BY deptno; 
-------------------------------------------------------------

SUBSTR(‘ABC’,1,2) -> AB

SELECT SUBSTR('ABC', 1 , 2) FROM dual;

SELECT SUBSTR('ABCDEFG',3,4) "Substring"
     FROM DUAL;

SELECT SUBSTR('ABCDEFG',-5,4) "Substring"
     FROM DUAL;

SELECT SUBSTRB('ABCDEFGipo', 5, 4.2 ) "Substring with bytes"
     FROM DUAL;

SELECT SUBSTRB('ABCDEFGipo', 5, 4.6 ) "Substring with bytes"
     FROM DUAL;

SELECT SUBSTR('한글날', 1, 2) "Substring"  
     FROM DUAL;
-- 오라클 버전에 따라서 한글 크기 다르다.
-- 익스프레스 버전은 한글 한글자가 3바이트임
SELECT SUBSTRb('한글', 1, 3) "Substring" 
     FROM DUAL;



