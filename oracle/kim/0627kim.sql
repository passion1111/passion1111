--------------------------------
create or replace procedure p_empMaxSal 
is
  v_emprow emp%ROWTYPE;
  Begin
    for i in 1..5 loop
      select * into v_emprow from 
        ( SELECT *
            FROM ( select * from emp order by sal desc ) 
              WHERE ROWNUM <= i ) where rownum <= 5 ;
        dbms_output.put_line(v_emprow.empno || ' ' || v_emprow.ename || ' ' 
|| v_emprow.sal);
    end loop;
  end;
--------------------------------
exec p_empMaxSal;
-----------------------
select max(sal) from emp;
select * from emp where ename='�̵���';
-- ���޼����� ��������: ���� �޴� ��������� ����
select sal, ename from emp order by sal desc; 

select sal, rownum from 
        ( SELECT *
            FROM ( select * from emp order by sal desc ) 
              WHERE ROWNUM <= i ) where rownum <= 5 ;
-------------------------------------------
create or replace procedure p_empMaxSal
is
    v_emprow emp%ROWTYPE;
    Begin
        for i in 1..5 loop
            select * into v_emprow from
                (select * from (select * from emp order by sal desc)
                where rownum <=i order by sal, ename) 
                where rownum=1 order by sal asc;
            dbms_output.put_line(v_emprow.empno || ' ' || v_emprow.ename || ' ' || v_emprow.sal);
        end loop;
    end;
------------------------------------------------            
-- oracle�� null ���� �������̴�. (�ٸ� ���� �ݴ���)

--create or replace procedure p_emp
--is
    declare
        e_name emp.ename%type;
        e_sal emp.sal%type;
    Begin
        select sal, ename into e_sal, e_name from emp where empno='7839';
        dbms_output.put_line('7839���� �̸��� '||e_name||' �޿��� ' ||e_sal);
    end;
    /
-------------------------------------------------
exec p_emp;
------------------------------------------

select*from gift;
UPDATE gift SET  = '�����Ұ�' WHERE [����]

alter table gift values(











create or replace procedure p_emp
is
--create or replace procedure �� ������ ȭ������θ� �����̴�.

    declare
        e_name emp.ename%type;
        e_sal emp.sal%type;
    begin
        select sal,ename  into e_sal,e_name from emp where empno='7839';
        dbms_output.put_line('7839���� �̸���'||e_name||'�޿���'||e_sal);
        
        end;
