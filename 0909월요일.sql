create table Facilities(
serialnum number ,  
name varchar2(30),
address varchar2(30)


);
create table Facilities_Inspection(
INSPECTION_DATE date default sysdate,
serialnum  number 
);


select * from nowdate;

select  nvl((case when name='�ҹ�' 
                        then case when (sysdate-birth)>0 then (sysdate-birth) end
                                                            end) ,0)   from nowdate where(case when name='�ҹ�' 
                        then case when (sysdate-birth)>0 then (sysdate-birth) end
                                                            end )  >0;

select * from nowdate;
select  a ,name from (select name, case when name='�ҹ�' 
                        then case when (sysdate-birth)>30 then (sysdate-birth) end
                            when name='����'                                   
                        then case when (sysdate-birth)>180 then (sysdate-birth)end             
                            when name='����3'                                
                        then case when (sysdate-birth)>365 then (sysdate-birth)end                                   
                                                            end a from nowdate)  where a>0;
                                                            
                                                            
                                                        
    
    select 10 ,a from dual where 10 as a >0;                                                       
select 10 as "a" from dual where "a">0;

select * from users;
drop  table users;
create table dd(
date date
);
create table users (
    userid number not null primary key,
    passwd varchar2(155) not null,
    name varchar2(155) not null,
    enabled number(1),        -- boolean Ÿ������ ������ ����(���� ��뿩��)
    authority varchar(155)
);
commit;
select *from dept;
select dname,deptno,,case 
when deptno > 0 then 200 else 300 end as 'ddd' from dept;
select * from dept full join dept2 on dept.deptno=dept2.dcode;

SELECT
    deptno
    ,CASE deptno WHEN 1 THEN '�Ƹ���Ƽ��'
                     WHEN 30 THEN '����Ʈ���ϸ���'
                     WHEN 50 THEN '���⿡'
                     ELSE '�׿�' END AS "������"
FROM dept;
SELECT
    deptno
    ,CASE deptno WHEN 1 THEN '�Ƹ���Ƽ��'
                    
                     ELSE '�׿�' END AS "������"
FROM dept;
select deptno,case deptno when 1 then '�Ƹ���Ƽ��' else '�׿� ' end as "������" from dept;

create table nowdate(
birth date default sysdate,
name varchar2(30)
);

select * from nowdate;
insert into nowdate(name,birth) values('Ȯ��1',to_date('1111-01-05'));

select MONTHS_BETWEEN( sysdate,(select birth from nowdate where name='d') )   from dual;

select *from nowdate;
insert into nowdate values(to_date('2019-04-02'),'����');
select name,case when name='d' then select MONTHS_BETWEEN(SYSDATE,birth)    from nowdate;

select *from nowdate;

select * from nowdate where birth = case birth='name' then birth  end ;

select * from nowdate where   (select months_between(sysdate,birth  180, 60 ,30,15) from nowdate where name='�ҹ�')   >20;
                      
                      
                      begin:
                      if name='�ҹ�'
                      
                      
                      select~~~~
                      
                      name='����'
                      
                      ~~~~
                      
                      case name when name='�ҹ�' 

select * from nowdate where name when name='d' then birth-30 end;





insert into nowdate values('Ȯ��2',


insert into nowdate values('�ҹ�',to_date




select( (select birth from nowdate where name='d')-180 )from dual;
select (to_date(select birth from nowdate where name='d')-180) from dual;
select 
select birth from nowdate where name='d';
select birth from nowdate where name='Ȯ��1';

avg
max 

(select birth from nowdate where name='d')-(select birth from nowdate where name='Ȯ��1');


insert into nowdate(name) values('d');
select (birth-600),name from nowdate;




select *from dept2;

select * from dept;

insert into dept2(dcode,dname) values(1,'2');

create table bank(
   account varchar2(10) primary key, --���¹�ȣ
   balance number --�ܾ�
);--alt+x

 insert into bank values('A01',1000);
 insert into bank values('A02',500);
 
 select * from bank;
 
 commit


--������ü.
1. �����Ѵ�.
update bank set balance=balane-����ݾ� where account = ��ݰ��¹�ȣ;


2. ������ �ݾ׸�ŭ �Ա��Ѵ�.
update bank set balance=balance+����ݾ� where account =�Աݰ��¹�ȣ;

select balance from bank where account='A02';

