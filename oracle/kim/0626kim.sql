--select name,deptno,rownum from emp2;
--
----��1 kim ������� ���̺��߿��� 
----emp2,gift,dept2 3���� ���̺��� ����ϱ�
----exp kim/oracle file:~~~/���ϴ����ϸ�.dmp
--
--
----����Ʈ �ϱ����� ����Ʈ�� ������ �ִ����� Ȯ���ؾ��Ѵ�.
----imp kang/oracle file:~~~/���� ���� �ּ�
--
----���ν��� ���� ��� �ָܼ�忡 ����ϰڴ�
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
-- DBMS_output.put_line('�Է°�'||vno||'<-->'||vname);
-- end;
-- /
-- 
-- -------------------------
-- begin
--    DBMs_output.put_line('doyeon lee');
--    end;
--    /
-----------------dbms_output.put('ui ȭ�� ����');
--begin
--   DBMs_output.put_line('doyeon leeddd');
--   DBMs_output.put_line('doyeon leeddd');
--end;
--/
--------------------------
--
--    
--    BEGIN
--  --DBMS_OUTPUT.PUT('UI ȭ�� ���� ���� �ߺ�����!!');
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
--        DBMS_OUTPUT.PUT('UI ȭ�� ���� ���� �ߺ�����!!');
--        DBMS_OUTPUT.PUT_LINE('doyeon lee 333');
--    end;
--    /
-------------------------------------------------- 
--exec p_test;
-----------------------------------------------
--create or replace PROCEDURE p_test(name in varchar2) 
--is
--    Begin
--        DBMS_OUTPUT.PUT_line(name || '�� ���� �հ��Դϴ�.');
--    end;
--    /
--exec p_test('�ƾƾ�');
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
--        name in userlist.name%type default '����',
--        AGE in userlist.age%type:= 20,
--        addr in userlist.addr%type :=null
--        )
--        is
--        begin
--        insert into userlist values(id,name,age,addr);
--        DBMS_OUTPUT.PUT('insert ������ '||id||name||AGE||addr);
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
    name in userlist.name%type default '������' ,
    age in userlist.age%type :=10 ,
    addr in userlist.addr%type := null
  )
is
    Begin
--      insert into userlist values(id, name, age, addr);
        DBMS_OUTPUT.PUT_line('dddd');
 --       DBMS_OUTPUT.PUT_line('insert ������ '||id||name||age||addr);
    end;


-------------------------------------
exec p_userlist100('yuna', '�迬��', 20, '����'); 
exec p_userlist100;
-----------------------------------------------------
exec p_userlist('yuna', '�迬��', 20, '����'); 
exec p_userlist; -- default data input
exec p_userlist(id=>'�ں���', age=> 50); -- ���ϴ� �ʵ尪�� �߰� ���� 
----------------------------------
select * from userlist;
-------------------------------------

 