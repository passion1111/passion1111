select * from test2;
create table test2(
dd varchar2(30),
dd2 number(30)
);

select * from Facilities_inspection;
alter table test2 add dd2 number(30);
drop table test;
insert into test2(dd,dd2) values('dd',(select count(*)+1 from test2));
insert into test(dd,dd2) values(
select count(*)+1 from test2;
select * from test2;
select count(*)from test2 group by dd2;


SET SERVEROUTPUT ON ;

insert into test2 (select 'dd',count(*)+1 from test2);
select count(*) from test2;

create or replace procedure aa
declare 
test33 number:=0;
test11 number:=1;
begin
--test33:=0;
select count(*) into test33 from test2;
dbms_output.put_line(test11 || '��');

 delete from test2 where dd2=test11; --���� ���� 1 
 
 -- �����ߴµ� ������ϴ»��. 
            -- due_date 
        delete from  ����222    where  sysdate-due_date>0 
 
 select (select case
                *from dual) from dual;
 
 
  while test11<test33 loop
  update test2 set dd2=test11 where dd2=test11+1;
  delete from test2 where dd=test11+1;
 -- dbms_output.put_line(test33 || '��');
    test11:=test11+1;
end loop;



dbms_output.put_line(test11 || '��');


--�ӽ� ���̺� to_date 
--insert into �����ٻ�� values �����ٻ��.

end;
/
select * from test2 where dd2=0;

insert into test2 values('11',5);
select count(*) from test2;
drop table test2;
select * from test2 order by dd2 asc;


create table test333(
s_date date,
e_date date,
ex_date date
);


insert into test333 values(sysdate-11,sysdate-4,(sysdate+trunc(sysdate-(sysdate-4),0)));
select * from test333;

select * from test333 where e_date <sysdate;


select trunc(sysdate-e_date,0) as ��ü��, (sysdate+trunc(sysdate-e_date,0)) �뿩�Ұ��� from test333;

select * from 

select * from test333;

status �뿩���� �Ұ��� 


-- range���� 
select * from test333 where  e_date between to_date('20170111 00:00:00','yyyymmdd HH24:MI:SS') and to_date('20191111 23:59:59','yyyymmdd HH24:MI:SS');

select 
--  ������ ���ν��� ���� 
case when  fac_name='������' 
    then   update 
 --  ���ν��� case when ���� �ذ����� mybatis ���������� ������� �����Ұ�.





