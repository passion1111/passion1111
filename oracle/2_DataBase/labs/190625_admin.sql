alter user "kang" account UNLOCK;

grant connect, resource to "kang";

grant create session, create table, create view,
    create sequence, create procedure
    to "kang";
    
select * from v$database;
--select * from �����ڸ�.���̺��;
select * from "kang".tt;
select * from kingsmile.emp;

select * from SYS.all_tab_columns;

select * from SYS.all_tab_columns where table_name='LOGMNR';

select * from SYS.all_tab_columns where column_name ='BLOCKS';
select * from SYS.all_tab_columns where table_name ='TSQ$';

select * from SYS.all_tab_columns 
    where table_name ='TSQ$' and column_name='BLOCKS';
    
-- Ư�� ���̺��� �÷� Ȯ�� ���?    
select * from KINGSMILE.emp;
    -- where table_name ='TSQ$' and column_name='BLOCKS';    

DESCRIBE kingsmile.emp;

-- grant select on ������.���̺�� to �ٸ������;
grant all on kingsmile.emp to "kang";






    
