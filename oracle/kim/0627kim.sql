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
select * from emp where ename='이도연';
-- 월급순으로 내림차순: 많이 받는 사람순으로 정렬
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
-- oracle은 null 값이 상위값이다. (다른 디비는 반대임)

--create or replace procedure p_emp
--is
    declare
        e_name emp.ename%type;
        e_sal emp.sal%type;
    Begin
        select sal, ename into e_sal, e_name from emp where empno='7839';
        dbms_output.put_line('7839님의 이름은 '||e_name||' 급여는 ' ||e_sal);
    end;
    /
-------------------------------------------------
exec p_emp;
------------------------------------------

select*from gift;
UPDATE gift SET  = '변경할값' WHERE [조건]

alter table gift values(











create or replace procedure p_emp
is
--create or replace procedure 가 없으면 화면상으로만 찍어낼것이다.

    declare
        e_name emp.ename%type;
        e_sal emp.sal%type;
    begin
        select sal,ename  into e_sal,e_name from emp where empno='7839';
        dbms_output.put_line('7839님의 이름은'||e_name||'급여는'||e_sal);
        
        end;
