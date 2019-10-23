create table Facilities( --시설물
Fac_serialnum number  ,          --일련번호 PK
Fac_name varchar2(30),         -- 시설물 
Fac_address varchar2(30) ,   --위치
Fac_status varchar2(30),
Fac_category varchar2(30)
);
create table Facilities_inspection(   --시설물 점검
FacIn_serialnum  number ,                           --점검한것 Facilities의 fk
FacIn_name varchar2(30),                --시설물 이름
FacIn_address varchar2(30),               --시설물 장소                 --시설물 상태
FacIn_Inspection_Date date default sysdate,    -- 점검일 
FacIn_Inspection_Due_Date date                 --점검예정일 
);
drop table Facilities_inspection;
commit;
drop table  Facilities_inspection;
desc Facilities_inspection;
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(1,'엘레베이터','1관',sysdate,sysdate+90);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(2,'에스컬레이터','1관',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'에스컬레이터','2관',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'에스컬레이터','3관',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(4,'엘레베이터','2관',sysdate,sysdate+90);
desc Facilities_inspection;
commit;
select * from Facilities_inspection;
 select FacIn_serialnum, FacIn_name,FacIn_address, FacIn_Inspection_Date,FacIn_Inspection_Due_Date,
ceil(FacIn_Inspection_Due_Date-FacIn_Inspection_Date) RemainingTime
from Facilities_inspection ;
select * from  Facilities_inspection; 

drop table Facilities_inspection;
select * from Facilities_inspection;
select * from Facilities;
commit;
update Facilities set fac_status='접수완료' ;

--update 처리 시리얼넘버  대부분 시리얼 넘버로 가능한데  시설이름 주기 추가한 이유는 나중에 목록에 없는것을 추가했을시에 처리할려고. ,시설이름 ,주기 
select * from Facilities_inspection;
exec facin_update(1,'엘레베이터','1관');
create or replace procedure facin_update( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                          f_address in facilities_inspection.facin_address%type) --점검주기.
is
begin
 case when f_name='엘레베이터' then 
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+90,facin_address=f_address where FacIn_serialnum=f_number;
      when f_name='계량기' then
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+30,facin_address=f_address where FacIn_serialnum=f_number;
      else
      --temp_update변수여러개를 사용하기위해서
      for  temp_update in (select * from Facilities_inspection where FacIn_serialnum=f_number) --보기안좋으면 into로 대체
      loop
      update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+(temp_update.FacIn_INSPECTION_DUE_DATE-sysdate),facin_address=f_address where FacIn_serialnum=f_number;
      end loop;
 
 end case;
end;
/




select FacIn_serialnum from Facilities_inspection;
select * from facilities_inspection;
desc facilities_inspection;
--insert into 하기위해
desc Facilities_inspection;
--  
commit;
select * from Facilities_inspection;
exec facin_insert('엘레베이터','5관',180);
create or replace procedure facin_insert( f_name   in facilities_inspection.facin_name%type,
                                           f_address in facilities_inspection.facin_address%type,
                                          f_cycle   in number :=0
                                          )
is
begin
 case when f_name='엘레베이터' then 
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '엘레베이터',sysdate,sysdate+180 ,f_address);
      when f_name='계량기' then
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '계량기',sysdate,sysdate+30 ,f_address);
      else
     insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date ,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), f_name,sysdate,sysdate+f_cycle,f_address);
 
 end case;
end;
/



select 


        select * from Facilities_inspection;
exec facin_insert(3,'프로시저테스트');
desc Facilities_inspection;
insert into Facilities_inspection values(3,'프로시저테스트',sysdate,sysdate+5);



-- 보여줄것.
select FacIn_serialnum ,                           --점검한것 Facilities의 fk
FacIn_name ,    
to_char(FacIn_INSPECTION_DATE,'yyyy"년"mm"월"DD"일"') FacIn_INSPECTION_DATE ,    -- 점검일 
facin_address,
to_char(FacIn_INSPECTION_DUE_DATE,'yyyy"년"MM"월"DD"일"') FacIn_INSPECTION_DUE_DATE , trunc((FacIn_INSPECTION_DUE_DATE-FacIn_INSPECTION_DATE),0) RemainingTime from Facilities_inspection;

select * from Facilities_inspection where  facin_name='엘레베이터'  and facin_inspection_date between to_char(sysdate-9,'YYYYMMDD') and to_char(sysdate,'YYYYMMDD') ;
select facin_inspection_date ,sysdate-3000 xfrom Facilities_inspection; 




select * from Facilities_inspection;

select * from (select (rank() over(order by Fac_serialnum))r , FAC_serialnum, FAC_NAME,FAC_ADDRESS, FAC_STATUS, FAC_CATEGORY from Facilities ) where r>0 and r<=10 and fac_status='수리신청' ;



select * from Facilities_inspection;
select * from Facilities_inspection where facin_inspection_due_date>sysdate;
