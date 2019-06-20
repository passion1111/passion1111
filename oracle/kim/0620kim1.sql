--숫자 함수 ---
round
ceil실수를 정수변환. 올림 한 후 정수반환
floor 내림 한후 정수 반환
mod(숫자,나눌수) 나머지
trunc(숫자,자릿수) 버림.

select round(12.23423432452342342,0),round(12.25423432452342342,1) from dual;  --첫번쨰 round는 반올림할려고해도 안됐고 두번쨰 round는 반올림됐음.

select ceil(12.34), ceil(-13.94) from dual;  --12.34는 올리면 13, -13.93는 올리면 -13
select floor(12.34),floor(-12.34) from dual; --내림한후 출력 그래서 12, -13출력됨.

select trunc(12.3456,2),trunc(-12.35,1),trunc(12.7456,0) from dual;  --셋쨰짜리가 5인데도 불구하고 그냥 잘라버림.

--문자열 함수--

select instr('abcd','b') from dual; --데이터베이스는 0번부터 아님 1번부터임. 답은 2

select instr('abcdㅈㅇㅂdbwq','b',-1) from dual;  --index번호가나옴 -1이면 뒤에서부터 찾는다 그 후 몇번쨰인지.첫번쨰부터 셈 9

select instr('abcdㅈㅇㅂdbwqㅈㅂㄹㅈㅂㄹㅈㅂㄹ','b',-3) from dual;    --9

select lpad('abcd',20,'#') from dual; --abcd를 20자리로 만드는데 빈 공간은 #으로 왼쪽에 채워라.
select rpad('abcd',20,'#') from dual; --오른쪽에서부터 채워라

select *from dept2;

SELECT rpad(dname,10,substr('123456',length(dname)+-2)) From dept2;  --pptx에 있는그대로하는방법.

SELECT rpad(dname,10,substr('123456',length(dname)+1)) From dept2;

SELECT dname, substr(dname,2,3) from dept2;

select length('candide') from dept2;
select length(dname) from dept2; --dname의 길이를 알수있음.

select lpad(dname,10,'1234567890')"lpad연습" from dept2;
select rpad(dname,10,'1234567890') "rpad연습" from dept2;

select dname,length(dname) from dept2;  --글자하나당 길이하나로 lengthb는 바이트로 쪼개버림.

select name from student; 
select name, rtrim(REGEXp_replace(name,'(.)','\-1' )  ,'-'  )  from student where deptno1=103;          --네임에서 .을 만나면 \-1

select sysdate from dual;   --날자를 뽑아옴.
select to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') FROM DUAL;    --년도 월 일 시간 분 초

select to_char(sysdate , 'YYYY-MM-DD')  from dual;
select to_char(sysdate , 'YYYY-MM-DD HH:MI:SS') from dual;   --최대12시간으로
select to_char(sysdate , 'YYYY-MM-DD HH24:MI:SS') from dual;     --24시간으로

select *from professor;
select concat(name,position) from professor;


select substr('abcdef',-2,4) from dual; --마지막에 도닳면 첫글자부터시작하지않고 그냥 끝
select *from student;
select substr(tel,1,4) from student;

select substr(tel,1, instr(tel,')',1,1)-1 ) from student;

select *from dept2;
select lpad( dname , 10 , '12345' )  from dept2;
select rpad(dname, 10,substr('567890',length(dname))) from dept2;

select ltrim(dname,'영') from dept2; --영이라는 왼쪽에서 시작하는 글자를 지움

select rtrim(dname,'팀') from dept2;  --이런방식은 첫글자와 마지막 글자만 가능.

--replace
select *from student;
select replace(name,substr(name,1,1),'#') from student;  --replace한다 name을   substr 네임의 첫번쨰에서 첫번쨰글자까지 #으로 ex)진수 substr name,1,2,'#' -> (##수) xx, (#)수 o

select replace(name,substr(name,2,1),'#') from student;

select name, replace(jumin,substr(jumin,7,13),'#') from student;

select name, replace(jumin,substr(jumin,7,13),'#######') from student;

select replace(tel,
substr(tel,instr(tel, ')' ,1,1 )+1,
3)
,'###') from student;

--sub str(tel,시작위치,뽑을갯수);
--substr(tel,시작위치);

select name,tel,substr(tel,1, instr(tel,')')-1) from student;





-------------------------------------------------
select Months_between            --몇개월 차이 나는지 계산해주는것.
  ( to_date('02-17-2017', 'MM-DD-YYYY') ,
    to_date('01-01-2016', 'MM-DD-YYYY')   )  "Months"
  from dual;

select Months_between
  ( to_date('07-31-2015', 'MM-DD-YYYY') ,
    to_date('12-20-1988', 'MM-DD-YYYY')   )  "Months"
  from dual;


select* from professor where name='심슨';

select add_months(hiredate,1 )   --입사월수에서 1개월을더함
  from professor
  where name='심슨';

select to_char(add_months(hiredate, 1), 'DD-MM-YYYY' ) "Next month"  --입사월수+1가 언제인지 계산.
  from professor
  where name='심슨';
  
  
  

select * from professor;
select * from emp2;

select to_char(
              add_months(birthday, 1), 'DD-MM-YYYY' ) "Next month"
  from emp2
  where name='나사장';
-------------------------------------------
select next_day('2019/06/20', 2) "Next Day" from dual;  -- 1 : 일요일  2:월요일,....
select next_day('1988/01/20', 2) "Next Day" from dual;
select next_day('2019/06/20', 6) "Next Day" from dual;  -- 6 : 금요일   해당하는주의 날자
-------------------------------------------------------
select sysdate, --오늘날자
    Last_day(sysdate) "Last",   --해당하는 월의 마지막 달
    Last_day(sysdate) - sysdate "Days Left" --남음 날자
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

SELECT SUBSTR('한글날', 1, 2) "Substring"  
     FROM DUAL;

SELECT SUBSTRb('한글', 1, 3) "Substring" 
     FROM DUAL;


