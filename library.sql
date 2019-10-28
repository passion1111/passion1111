drop table table1;
drop table table2;
drop table table3;

create table table1(
table1 number);
create table table2(
table2 varchar2(30));
create table table3(
table2 varchar2(30));

declare
begin
    for i in 1..20 loop
    insert into table1 values(i);    
    end loop;
end;
/
create or replace procedure proc_table11(table11 out sys_refcursor)
is

begin
    open table11 for select * from table1 where mod(table1,2)=0;
end;
/


create or replace procedure proc_table22(table22 in number)
is

begin
    for table222 in (select * from table1 where    table1<table22) loop
            
            insert into table3 values('번호시작: '||table222.table1);
            
            end loop;
            
            end;
            /
    
    create or replace procedure proc_proctesttest
    is
    table23 sys_refcursor;
    table34 table1%rowtype;
    begin
        proc_table11(table23);
        loop
        fetch table23 into table34;
        exit when  table23%notfound;
        proc_table22(table34.table1);
        
        
        end loop;
        close table23;
                
    end;
    /
    
    exec proc_proctesttest();
select * from table3;
select * from table1;
select * from table1 where table1 in(max(table1));
