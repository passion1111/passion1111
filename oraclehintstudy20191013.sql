create table test(
teststring varchar2(20),
teststring2 varchar2(30)
);
insert into test values('5','6');
select * from test;
commit;

create or replace procedure test_selectproc
(result out sys_refcursor)
is
begin
 open result for
 select * from test;
 end;
 /
 VAR X REFCURSOR;
 EXEC TEST_SELECTPROC();
 
 create table test22(
 nono number,
 string2 varchar2(40)
 );
 
 
 declare
 begin
    for i in 1..20000 loop
    insert into test22 values(i,'var2'||2);
    end loop;
 end;
 /
 select * from test22  where string='var1' order by string;
 delete from test22;
 drop table test22;
drop index test22_index;
 create index test22_index on test22(nono desc);
select /*+INDEX_ASC(test22 test22_index) */ *  from test22 where nono>0;
