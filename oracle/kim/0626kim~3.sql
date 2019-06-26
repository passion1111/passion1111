select*from user_objects
where lower(object_type)='procedure';  --프로시저가 뭐뭐있는지 불러오는것.

select text
    from user_source
        where lower(name)='p_test';  --


create or replace procedure p_output(
    name out varchar2,age out number)
is
    begin
        name:='이나영';
        age:=20;
        DBMS_output.put_Line('out을 이용한 프로시져 완료');
    end;
        /
        --exec p_output;
        
        variable v_name varchar2;
        variable v_age number;
        
        exec p_output(:v_name, :v_age);
        print v_name;
        print v_age;
        print p_output;
        
        
        select ename from emp where job='CLERK';
        
        create or replace procedure p_job_emp5(e_job in emp.job%type)
        is
            name emp.ename%type;
        begin
            select ename into name from emp where job=e_job;
            DBMS_OUTPUT.PUT_line(name||'님 담당 업무는 '||e_job);
        end;
            /
            
        select*from emp ;
        EXECUTE p_job_emp5('CLERK');
        select ename  from emp where job='SALESMAN';
        
            
            
            
 -------------------------------------------------------------------------------           
            create or replace procedure p_job_emp2(e_job in emp.job%type)
            is
                name emp.ename%type;
            
            cursor c_name is select ename from emp where job=e_job;
            begin
                open c_name;
                DBMS_OUTPUT.PUT_LINE('=================');
                loop
                    fetch c_name into name;
                    exit when c_name%notfound;
                    dbms_output.put_line(name||'님의 담당 업무는'||e_job);
                end loop;
                DBMS_OUTPUT.PUT_line('결과 레코드수=>'||c_name%rowcount);
                close c_name;
            end;
            /
            select *from emp;
            exec p_job_emp2('MANAGER');
            exec p_job_emp2('SALESMAN');
            
            
 -----------------------------------------------------------------   
 select*from professor;
  create or replace procedure p_name_professor(p_deptno in professor.deptno%type)
            is
                p_name professor.name%type;
            
            cursor c_name is select name from professor where deptno=p_deptno;
            begin
                open c_name;
                DBMS_OUTPUT.PUT_LINE('=================');
                loop
                    fetch c_name into name;
                    exit when c_name%notfound;
                    dbms_output.put_line(p_deptno||'님의 담당 업무는'||name);
                end loop;
                DBMS_OUTPUT.PUT_line('결과 레코드수=>'||c_name%rowcount);
                close c_name;
            end;
            /
            