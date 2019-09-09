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

select  nvl((case when name='소방' 
                        then case when (sysdate-birth)>0 then (sysdate-birth) end
                                                            end) ,0)   from nowdate where(case when name='소방' 
                        then case when (sysdate-birth)>0 then (sysdate-birth) end
                                                            end )  >0;

select * from nowdate;
select  a ,name from (select name, case when name='소방' 
                        then case when (sysdate-birth)>30 then (sysdate-birth) end
                            when name='전기'                                   
                        then case when (sysdate-birth)>180 then (sysdate-birth)end             
                            when name='전기3'                                
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
    enabled number(1),        -- boolean 타입으로 설정도 가능(계정 사용여부)
    authority varchar(155)
);
commit;
select *from dept;
select dname,deptno,,case 
when deptno > 0 then 200 else 300 end as 'ddd' from dept;
select * from dept full join dept2 on dept.deptno=dept2.dcode;

SELECT
    deptno
    ,CASE deptno WHEN 1 THEN '아르헨티나'
                     WHEN 30 THEN '오스트레일리아'
                     WHEN 50 THEN '벨기에'
                     ELSE '그외' END AS "국가명"
FROM dept;
SELECT
    deptno
    ,CASE deptno WHEN 1 THEN '아르헨티나'
                    
                     ELSE '그외' END AS "국가명"
FROM dept;
select deptno,case deptno when 1 then '아르헨티아' else '그외 ' end as "국가명" from dept;

create table nowdate(
birth date default sysdate,
name varchar2(30)
);

select * from nowdate;
insert into nowdate(name,birth) values('확인1',to_date('1111-01-05'));

select MONTHS_BETWEEN( sysdate,(select birth from nowdate where name='d') )   from dual;

select *from nowdate;
insert into nowdate values(to_date('2019-04-02'),'전기');
select name,case when name='d' then select MONTHS_BETWEEN(SYSDATE,birth)    from nowdate;

select *from nowdate;

select * from nowdate where birth = case birth='name' then birth  end ;

select * from nowdate where   (select months_between(sysdate,birth  180, 60 ,30,15) from nowdate where name='소방')   >20;
                      
                      
                      begin:
                      if name='소방'
                      
                      
                      select~~~~
                      
                      name='전기'
                      
                      ~~~~
                      
                      case name when name='소방' 

select * from nowdate where name when name='d' then birth-30 end;





insert into nowdate values('확인2',


insert into nowdate values('소방',to_date




select( (select birth from nowdate where name='d')-180 )from dual;
select (to_date(select birth from nowdate where name='d')-180) from dual;
select 
select birth from nowdate where name='d';
select birth from nowdate where name='확인1';

avg
max 

(select birth from nowdate where name='d')-(select birth from nowdate where name='확인1');


insert into nowdate(name) values('d');
select (birth-600),name from nowdate;




select *from dept2;

select * from dept;

insert into dept2(dcode,dname) values(1,'2');

create table bank(
   account varchar2(10) primary key, --계좌번호
   balance number --잔액
);--alt+x

 insert into bank values('A01',1000);
 insert into bank values('A02',500);
 
 select * from bank;
 
 commit


--계좌이체.
1. 인출한다.
update bank set balance=balane-인출금액 where account = 출금계좌번호;


2. 인출한 금액만큼 입금한다.
update bank set balance=balance+인출금액 where account =입금계좌번호;

select balance from bank where account='A02';

