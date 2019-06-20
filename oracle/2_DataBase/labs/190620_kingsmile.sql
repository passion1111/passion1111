-- 숫자함수 ----
select round(12.45678935, 0), 
    round(12.45678935, 2),round(12.55678935, 0) from dual;
select ceil(12.34),ceil(-12.34) from dual; -- 올림 한 후 정수 반환
select floor(12.34),floor(-12.34) from dual; -- 내림 한 후 정수 반환
select trunc(12.3456, 2), trunc(12.3756, 2),
        trunc(12.7456, 0) from dual;
------------------------------------------------  
-- 문자열함수 -----
select instr('abcd', 'b') from dual; -- 2
select instr('abcdfghijkboy', 'b', -1) from dual;  -- -1이면 뒤에서부터 찾는다.
select instr('abcdfghijkboy234728473swe', 'b', -3) from dual;

select lpad('abcd', 20, '#') from dual;
select rpad('abcd', 20, '@') from dual;

select * from dept2;
select RPAD(dname, 10, '*') "RPAD연습" from dept2;

select LENGTH('CANDIDE') from dual;
select LENGTHb('CANDIDE') from dual;

select dname, LENGTH(dname) from dept2;
select dname, LENGTH(dname), LENGTHb(dname) from dept2;

select substr('1234567890', 3) from dual;
select substr('1234567890', 3, 2) from dual;
select dname, substr(dname, 3) from dept2;
select dname, substr(dname, 2, 3) from dept2;

select RPAD(dname, 10, substr('1234567890', length(dname)+1)) "RPAD연습" from dept2;

select lpad(dname, 10, '1234567890') "LPAD연습"  from dept2;
select rpad(dname, 10, '1234567890') "RPAD연습" from dept2;
select lpad(dname, 10, '1234567890'), rpad(dname, 10, '1234567890') "연습" from dept2;        

select dname, length(dname) from dept2;
select dname, lengthb(dname) from dept2;

select * from student where deptno1 =103;
select name, rtrim(REGEXp_replace(name, '(.)', '\-1'),  '-') "변경후"
    from student
    where deptno1 = 103;

select name, rtrim(REGEXp_replace(birthday, '(/)', '\\'),  '-') "변경후"
    from student
    where deptno1 = 103;
   
select sysdate from dual; 
select to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') from dual;
select to_char(sysdate, 'YY-MM-DD HH:MI') from dual;
select to_char(sysdate , 'YYYY-MM-DD') from dual;
select to_char(sysdate , 'YYYY-MM-DD HH:MI:SS') from dual;
select to_char(sysdate , 'YYYY-MM-DD HH24:MI:SS') from dual;
 
-- Oracle SQL_PLSQL_PPT > 2, 3장 실습  
문자 함수 퀴즈 1)
Student 테이블을 참조해서 아래 화면과 같이 1 전공이(deptno1 컬럼) 
101번인 학생의 이름과 전화번호와 지역번호를 출력하세요. 
단 지역번호는 숫자만 나와야 합니다.

select tel, instr(tel,')') 
    from student  -- index string
    where deptno1 = 101;

--substr(tel, 시작위치, 뽑을갯수);
--substr(tel, 시작위치);

select name, tel, substr(tel, 1, instr(tel,')') -1) "지역번호"
    from student
    where deptno1 =101;

문자 함수 퀴즈 3)
Dept2 테이블을 사용하여 dname 을 오른쪽의 결과가 
나오도록 쿼리를 작성하세요.   -- 오라클 버전에 따라 한글 글자 다름 
select rpad(dname, 10,
        substr('1234567890', lengthb(dname)-2)) "RPAD연습"
    from dept2;

select rpad(dname, 10,
        substr('1234567890', length(dname)+1)) "RPAD연습"
    from dept2;
------------------------------------------------
select Months_between
  ( to_date('06-20-2019', 'MM-DD-YYYY') ,
    to_date('06-20-2018', 'MM-DD-YYYY')   )  "Months"
  from dual;

select Months_between
  ( to_date('07-31-2015', 'MM-DD-YYYY') ,
    to_date('12-20-1988', 'MM-DD-YYYY')   )  "Months"
  from dual;

select *
  from professor
  where name='심슨';
  
select add_months(hiredate, 1)
  from professor
  where name='심슨';
  
select to_char(add_months(hiredate, 1), 'DD-MM-YYYY' ) "Next month"
  from professor
  where name='심슨';
  
select * from professor;
select * from emp2;

select to_char(
              add_months(birthday, 1), 'DD-MM-YYYY' ) "Next month"
  from emp2
  where name='나사장'
-------------------------------------------
select next_day('2019/06/20', 2) "Next Day" from dual;  -- 1 : 일요일  2:월요일,....
select next_day('1988/01/20', 2) "Next Day" from dual;
select next_day('2019/06/20', 6) "Next Day" from dual;  -- 6 : 금요일 
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

select * from products;

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
select * from products;
SELECT product_id,
       DECODE (category_id, 1, 'Southlake',
                             2, 'San Francisco',
                             3, 'New Jersey',
                             4, 'Seattle',
                                'Non domestic')
       "Location of inventory" FROM products
       WHERE product_id < 286;
       
SELECT * FROM inventories ;
select * from dept;

Student 테이블의 tel 컬럼을 사용하여 학생의 이름과 전화번호, ‘)‘ 가
 나오는 위치를 출력하세요.;
 
 select * from student;

select name,instr(tel,')',1),tel from student;
select name,substr(tel,1,instr(tel,')',1)-1),tel from student;
substr(tel,1,instr(tel,')',1))

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

SELECT SUBSTR('한글날', 1, 2) "Substring"  
     FROM DUAL;

SELECT SUBSTRb('한글', 1, 3) "Substring" 
     FROM DUAL;












        