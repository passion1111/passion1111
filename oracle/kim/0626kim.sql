--select name,deptno,rownum from emp2;
--
----문1 kim 사용자의 테이블중에서 
----emp2,gift,dept2 3개의 테이블을 백업하기
----exp kim/oracle file:~~~/원하는파일명.dmp
--
--
----임포트 하기전이 임포트할 권한이 있는지도 확인해야한다.
----imp kang/oracle file:~~~/위와 같은 주소
--
----프로시저 실행 결과 콘솔모드에 출력하겠다
--select*from emp;
--set serveroutput on;
--
--
--
-- declare
-- vno number;
-- vname varchar2(20);
-- Begin
--    select empno,ename
--                    into vno,vname
--                    from emp
--                    where empno=&empno;
-- DBMS_output.put_line('입력값'||vno||'<-->'||vname);
-- end;
-- /
-- 
-- -------------------------
-- begin
--    DBMs_output.put_line('doyeon lee');
--    end;
--    /
-----------------dbms_output.put('ui 화면 설계');
--begin
--   DBMs_output.put_line('doyeon leeddd');
--   DBMs_output.put_line('doyeon leeddd');
--end;
--/
--------------------------
--
--    
--    BEGIN
--  --DBMS_OUTPUT.PUT('UI 화면 설계 시험 잘보세요!!');
--  DBMS_OUTPUT.PUT_LINE('doyeon lee 333');
--  /*DBMS_OUTPUT.PUT_LINE('doyeon lee 2222');
--  DBMS_OUTPUT.PUT_LINE('doyeon lee 2222'); */
--END;
--/
------------------------------- 
--drop procedure p_test; 
--
--create PROCEDURE p_test 
--is
--    Begin
--        DBMS_OUTPUT.PUT('UI 화면 설계 시험 잘보세요!!');
--        DBMS_OUTPUT.PUT_LINE('doyeon lee 333');
--    end;
--    /
-------------------------------------------------- 
--exec p_test;
-----------------------------------------------
--create or replace PROCEDURE p_test(name in varchar2) 
--is
--    Begin
--        DBMS_OUTPUT.PUT_line(name || '님 시험 합격입니다.');
--    end;
--    /
--exec p_test('아아아');
-- /
--create table userlist2(
--    id varchar2(10),
--    name varchar2(20),
--    age number,
--    addr varchar2(50)
--    );
--    desc userlist;
--    
--    select*from userlist2;
--    
--    create or replace  procedure p_userlist2(
--        id in userlist.id%type:='doyeon',
--        name in userlist.name%type default '도연',
--        AGE in userlist.age%type:= 20,
--        addr in userlist.addr%type :=null
--        )
--        is
--        begin
--        insert into userlist values(id,name,age,addr);
--        DBMS_OUTPUT.PUT('insert 정보는 '||id||name||AGE||addr);
--    end;
    
    select * from userlist;
drop table userlist;
create table userlist (
    id varchar2(10),
    name varchar2(20),
    age number,
    addr varchar2(50)
);
desc userlist;
    
create or replace procedure p_userlist100(
    id in userlist.id%TYPE := 'doyeon' ,
    name in userlist.name%type default '도연이' ,
    age in userlist.age%type :=10 ,
    addr in userlist.addr%type := null
  )
is
    Begin
--      insert into userlist values(id, name, age, addr);
        DBMS_OUTPUT.PUT_line('dddd');
 --       DBMS_OUTPUT.PUT_line('insert 정보는 '||id||name||age||addr);
    end;


-------------------------------------
exec p_userlist100('yuna', '김연아', 20, '서울'); 
exec p_userlist100;
-----------------------------------------------------
exec p_userlist('yuna', '김연아', 20, '서울'); 
exec p_userlist; -- default data input
exec p_userlist(id=>'박보검', age=> 50); -- 원하는 필드값만 추가 가능 
----------------------------------
select * from userlist;
-------------------------------------

 