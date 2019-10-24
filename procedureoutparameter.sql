create table testtable(
  ha varchar2(30) not null);
  insert into testtable values('2');
  commit;
  select * from testtable;
  drop table testtable;
  create index index_testtable on testtable(ha);
  alter table facilities_inspection add(facin_address varchar2(30));
  
  select facin_serialnum,facin_name,facin_inspection_date,facilities_inspection.facin_inspection_due_date
        ,trunc(facilities_inspection.facin_inspection_due_date-sysdate,0) REMAINING_DAYS from facilities_inspection;
  select * from facilities_inspection;
select * from test22 where 'a'='a';  
SELECT A.TABLE_NAME
     , A.INDEX_NAME
     , A.COLUMN_NAME
  FROM ALL_IND_COLUMNS A
 WHERE A.TABLE_NAME = 'testtable'
 ORDER BY A.INDEX_NAME, A.COLUMN_POSITION;
 
 SELECT A.uniqueness,
       b.*
  FROM ALL_INDEXES a,
       ALL_IND_COLUMNS b
 WHERE a.index_name = b.index_name
   AND a.table_name=upper('testtable'); --인덱스조회
   
   begin 
   for i in 1..3000 loop
   insert into testtable values('a'||i);
   end loop;
   end;
   /
   
   select * from(select /*+ index_asc(testtable index_testtable)  */* from testtable);
   drop index index_testtable;
select  * from testtable;
   select /*+ index_ffs(testtable index_testtable)  */* from testtable;
   
   
   
   
   
   create or replace procedure proc_testtable(
    ha out sys_refcursor)
    is
    
    begin
     open ha for select * from testtable;
     end;
     /
     
         
  DECLARE
  l_cursor  SYS_REFCURSOR;
  l_ename   testtable.ha%TYPE;
 
BEGIN
  proc_testtable (
              l_cursor);
            
  LOOP 
    FETCH l_cursor
    INTO  l_ename;
    EXIT WHEN l_cursor%NOTFOUND;
    --DBMS_OUTPUT.PUT_LINE(l_ename);
    insert into testtable  values(l_ename);
  END LOOP;
  CLOSE l_cursor;
END;
/

desc testtable;
--위 완성본

 create or replace test2929292929292929292929
 is
  l_cursor  testtable%type;
  l_ename   testtable.ha%TYPE;
 
BEGIN
  proc_testtable (l_cursor);
            
  LOOP 
    FETCH l_cursor
    INTO  l_ename;
    EXIT WHEN l_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(l_ename);
  END LOOP;
  CLOSE l_cursor;
END;
/


--fetch안쓰고 사용

DECLARE
  l_cursor  SYS_REFCURSOR;
  l_ename   testtable.ha%TYPE;
 
BEGIN
  proc_testtable (
              l_cursor);
            
  LOOP 
    FETCH l_cursor   INTO  l_ename;
    EXIT WHEN l_cursor%NOTFOUND;
   
  END LOOP;
  CLOSE l_cursor;
END;
/

declare 
hoho sys_refcursor;
hola varchar2(30);
begin
 proc_testtable(hoho);
  loop
  fetch hoho into hola;
  exit when hoho%notfound;
    end loop;
    close hoho;
 end;
/
---open안시키고 cursorprocedure만들기
 create or replace procedure proc_testtable2(
    ha out sys_refcursor)
    is
    
 cursor  haha is select * from testtable;
 begin
   open haha;
   open ha for haha;
   close haha;
  DBMS_OUTPUT.PUT_LINE('1');
   
 
   
     end;
 /   
 
 select case when ha='a1' then 3
             when ha='a2' then 7
    else 5
    end 대출횟수,ha from testtable;
 insert into testtable values('33333');
 
 declare
 checkvalue number;
 begin
 delete from testtable where ha='1';
  checkvalue:=sql%rowcount;
    DBMS_OUTPUT.PUT_LINE('3'||sql%rowcount);
    select count(*) into checkvalue from testtable;
     DBMS_OUTPUT.PUT_LINE('3'||checkvalue);
 end;
 /
 set serveroutput on;
 from testtable;
  