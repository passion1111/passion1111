-- PL/SQL -----------------
-- ���ν��� ���� ��� �ָܼ�忡 ����ϰڴ�
KINGSMILE> set serveroutput on; 
KINGSMILE> Declare     -- �����
  2  vno number(4);
  3  vname varchar2(20);
  4  Begin
  5     select empno, name
  6             into vno, vname
  7     from emp2
  8     where empno = &empno; -- &empno ���ؼ� �� �Է� �ޱ�
  9     DBMS_output.put_line('�Է°� :' || vno || '<--->' || vname);
 10  end;
 11  /  <--- �Ϸ�
 desc emp2;
 select * from emp2;
------------------------------------
BEGIN
  --DBMS_OUTPUT.PUT('UI ȭ�� ���� ���� �ߺ�����!!');
  DBMS_OUTPUT.PUT_LINE('doyeon lee 333');
  /*DBMS_OUTPUT.PUT_LINE('doyeon lee 2222');
  DBMS_OUTPUT.PUT_LINE('doyeon lee 2222'); */
END;
----------------------------- 
drop procedure p_test; 

create PROCEDURE p_test 
is
    Begin
        DBMS_OUTPUT.PUT('UI ȭ�� ���� ���� �ߺ�����!!');
        DBMS_OUTPUT.PUT_LINE('doyeon lee 333');
    end;
------------------------------------------------ 
exec p_test;
---------------------------------------------
create or replace PROCEDURE p_test(name in varchar2) 
is
    Begin
        DBMS_OUTPUT.PUT_line(name || '�� ���� �հ��Դϴ�.');
    end;
-----------------------------------------
exec p_test('�̵���');
exec p_test('�迬��');
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
    name in userlist.name%type default '������' ,
    age in userlist.age%type :=10 ,
    addr in userlist.addr%type := null )
is
    Begin
        insert into userlist values(id, name, age, addr);
        DBMS_OUTPUT.PUT_line('insert ������ '||id||name||age||addr);
    end;
-----------------------------------------------------
exec p_userlist('yuna', '�迬��', 20, '����'); -- ��ü �ʵ� �߰�
exec p_userlist; -- default data input
exec p_userlist(id=>'�ں���', age=> 50); -- ���ϴ� �ʵ尪�� �߰� ���� 
----------------------------------
select * from userlist;
-------------------------------------
select * from c_emp;
select * from emp;

insert into emp
    select * from c_emp; -- ���ڵ� ����
    
DESCRIBE emp; 
-------------------------------------
DECLARE 
    su NUMBER :=90;
BEGIN
    dbms_output.put_line('Program started.' );
    IF( su >= 90 ) THEN
        dbms_output.put_line('a is greater than 100'); 
    else if ( su >= 80) then
        dbms_output.put_line(a || ' is 100���� ũ�� �ʴ�');
    END IF;
    dbms_output.put_line('Program completed.');
END;
------------------------------------------ 
-- ������ �����Ǵ� ���� ����ϱ�
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
    dbms_output.put_line('����� : ' || su ||'�� ==> '||grade ||'�����Դϴ�');
END;
-----------------------------
FOR �����̸� IN ����.. �� loop
    ���๮��;
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
WHILE ���ǽ� LOOP
    ���๮��;
    ������;
END LOOP;
-------------------------------
declare
    su number := 0; --�ʱ�ȭ
begin
    while su < 50 loop
        su := su + 1;  -- ������
        DBMS_OUTPUT.PUT_LINE('���� su ���� ' || su);
    end loop;
end;
-----------------------------------
--1) 1~10 ���� ���
begin
    for i in 1..10 loop
        DBMS_OUTPUT.PUT_LINE(i);
    end loop;
end;
----------------------------------------
-- 2)1~10 ������ ¦���� ���
begin
    for i in 1..10 loop
         -- IF mod(i,2) != 0 THEN
         IF mod(i,2) <> 0 THEN --IF mod(i,2) = 0 THEN   
            DBMS_OUTPUT.PUT_LINE(i);
        end if;
    end loop;
end;
------------------------------------
-- 3)2���� ������ ���
BEGIN
    dbms_output.put_line(2 || '��');
    FOR i IN 1..9 LOOP    
        dbms_output.put_line('=========');
        dbms_output.put_line(2 || ' * ' || i || ' = ' || i * 2);
    END LOOP;
END;
------------------------------------------
-- 4)�Է� �޾Ƽ� ���ϴ� �� ���
DECLARE
 dan NUMBER(1) := &inputDan;      
BEGIN
 FOR i  IN   1..9  LOOP  
    DBMS_OUTPUT.PUT_LINE(dan ||'*' || i || '=' || i*dan );
 END LOOP;
END;
-----------------------------------------
-- 5) ���ϴ� �� ��� - ������ ���
DECLARE
 dan NUMBER(1) := &inputDan;      
BEGIN
 FOR i  IN reverse  1..9  LOOP -- ������ ��� 
    DBMS_OUTPUT.PUT_LINE(dan ||'*' || i || '=' || i*dan );
 END LOOP;
END;
-----------------------------------
 
 