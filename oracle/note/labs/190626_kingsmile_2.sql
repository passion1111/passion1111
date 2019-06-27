-- PL/SQL -----------------
-- 프로시저 실행 결과 콘솔모드에 출력하겠다
KINGSMILE> set serveroutput on; 
KINGSMILE> Declare     -- 선언부
  2  vno number(4);
  3  vname varchar2(20);
  4  Begin
  5     select empno, name
  6             into vno, vname
  7     from emp2
  8     where empno = &empno; -- &empno 통해서 값 입력 받기
  9     DBMS_output.put_line('입력값 :' || vno || '<--->' || vname);
 10  end;
 11  /  <--- 완료
 desc emp2;
 select * from emp2;
------------------------------------
BEGIN
  --DBMS_OUTPUT.PUT('UI 화면 설계 시험 잘보세요!!');
  DBMS_OUTPUT.PUT_LINE('doyeon lee 333');
  /*DBMS_OUTPUT.PUT_LINE('doyeon lee 2222');
  DBMS_OUTPUT.PUT_LINE('doyeon lee 2222'); */
END;
----------------------------- 
drop procedure p_test; 

create PROCEDURE p_test 
is
    Begin
        DBMS_OUTPUT.PUT('UI 화면 설계 시험 잘보세요!!');
        DBMS_OUTPUT.PUT_LINE('doyeon lee 333');
    end;
------------------------------------------------ 
exec p_test;
---------------------------------------------
create or replace PROCEDURE p_test(name in varchar2) 
is
    Begin
        DBMS_OUTPUT.PUT_line(name || '님 시험 합격입니다.');
    end;
-----------------------------------------
exec p_test('이도연');
exec p_test('김연아');
-----------------------------------------
select * from userlist;
drop table userlist;
create table userlist (
    id varchar2(10),
    name varchar2(20),
    age number,
    addr varchar2(50)
);
desc userlist;
------------------------------------
create or replace procedure p_userlist(
    id in userlist.id%TYPE := 'doyeon' ,
    name in userlist.name%type default '도연이' ,
    age in userlist.age%type :=10 ,
    addr in userlist.addr%type := null )
is
    Begin
        insert into userlist values(id, name, age, addr);
        DBMS_OUTPUT.PUT_line('insert 정보는 '||id||name||age||addr);
    end;
-----------------------------------------------------
exec p_userlist('yuna', '김연아', 20, '서울'); -- 전체 필드 추가
exec p_userlist; -- default data input
exec p_userlist(id=>'박보검', age=> 50); -- 원하는 필드값만 추가 가능 
----------------------------------
select * from userlist;
-------------------------------------
select * from c_emp;
select * from emp;

insert into emp
    select * from c_emp; -- 레코드 복사
    
DESCRIBE emp; 
-------------------------------------
DECLARE 
    su NUMBER :=90;
BEGIN
    dbms_output.put_line('Program started.' );
    IF( su >= 90 ) THEN
        dbms_output.put_line('a is greater than 100'); 
    else if ( su >= 80) then
        dbms_output.put_line(a || ' is 100보다 크지 않다');
    END IF;
    dbms_output.put_line('Program completed.');
END;
------------------------------------------ 
-- 점수에 대응되는 학점 출력하기
DECLARE 
    su NUMBER := 90;
    grade varchar2(2);
BEGIN
    IF( su >= 90 ) THEN grade :='A';
    elsif ( su >= 80) then grade :='B';
    elsif ( su >= 70) then grade :='C';
    elsif ( su >= 60) then grade :='C';
    else grade :='F';
    END IF;
    dbms_output.put_line('당신의 : ' || su ||'점 ==> '||grade ||'학점입니다');
END;
-----------------------------
FOR 변수이름 IN 시작.. 끝 loop
    실행문장;
END LOOP;
-------------------
create table bit (
    num number(3),
    name varchar2(10)
);
select * from bit;
------------------------
begin
    for i in 1..10 loop
        insert into bit values(i, sysdate);
    end loop;
end;
----------------------------------------
WHILE 조건식 LOOP
    실행문장;
    증감식;
END LOOP;
-------------------------------
declare
    su number := 0; --초기화
begin
    while su < 50 loop
        su := su + 1;  -- 증감식
        DBMS_OUTPUT.PUT_LINE('현재 su 값은 ' || su);
    end loop;
end;
-----------------------------------
--1) 1~10 까지 출력
begin
    for i in 1..10 loop
        DBMS_OUTPUT.PUT_LINE(i);
    end loop;
end;
----------------------------------------
-- 2)1~10 사이의 짝수만 출력
begin
    for i in 1..10 loop
         -- IF mod(i,2) != 0 THEN
         IF mod(i,2) <> 0 THEN --IF mod(i,2) = 0 THEN   
            DBMS_OUTPUT.PUT_LINE(i);
        end if;
    end loop;
end;
------------------------------------
-- 3)2단의 구구단 출력
BEGIN
    dbms_output.put_line(2 || '단');
    FOR i IN 1..9 LOOP    
        dbms_output.put_line('=========');
        dbms_output.put_line(2 || ' * ' || i || ' = ' || i * 2);
    END LOOP;
END;
------------------------------------------
-- 4)입력 받아서 원하는 단 출력
DECLARE
 dan NUMBER(1) := &inputDan;      
BEGIN
 FOR i  IN   1..9  LOOP  
    DBMS_OUTPUT.PUT_LINE(dan ||'*' || i || '=' || i*dan );
 END LOOP;
END;
-----------------------------------------
-- 5) 원하는 단 출력 - 역으로 출력
DECLARE
 dan NUMBER(1) := &inputDan;      
BEGIN
 FOR i  IN reverse  1..9  LOOP -- 역으로 출력 
    DBMS_OUTPUT.PUT_LINE(dan ||'*' || i || '=' || i*dan );
 END LOOP;
END;
-----------------------------------
 
 