create table testtable(
  ha varchar2(30) not null);
  drop table testtable;
  create index index_testtable on testtable(ha);
  
  
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

  