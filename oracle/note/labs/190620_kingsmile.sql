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
        