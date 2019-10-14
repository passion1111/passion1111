create table Facilities( --시설물
Fac_serialnum number  ,          --일련번호 PK
Fac_name varchar2(30),         -- 시설물 
Fac_address varchar2(30) ,   --위치
Fac_status varchar2(30),
Fac_category varchar2(30)
);

create table Facilities_inspection(   --시설물 점검
FacIn_serialnum  number ,                           --점검한것 Facilities의 fk
FacIn_name varchar2(30),    
FacIn_INSPECTION_DATE date default sysdate,    -- 점검일 
FacIn_INSPECTION_DUE_DATE date
);
select * from Facilities_inspection;

create or replace procedure facin_insert( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                          f_cycle   in number :=0)
is
begin
 case when f_name='엘레베이터' then 
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+90 where FacIn_serialnum=f_number;
      when f_name='계량기' then
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+30 where FacIn_serialnum=f_number;
      else
      for  temp_update in (select * from Facilities_inspection where FacIn_serialnum=f_number) --보기안좋으면 into로 대체
      loop
      update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+(temp_update.FacIn_INSPECTION_DUE_DATE-sysdate) where FacIn_serialnum=f_number;
      end loop;
 
 end case;
end;
/
        select * from Facilities_inspection;
exec facin_insert(3,'프로시저테스트');
desc Facilities_inspection;
insert into Facilities_inspection values(3,'프로시저테스트',sysdate,sysdate+5);

select FacIn_serialnum ,                           --점검한것 Facilities의 fk
FacIn_name ,    
FacIn_INSPECTION_DATE ,    -- 점검일 
FacIn_INSPECTION_DUE_DATE  , trunc((FacIn_INSPECTION_DUE_DATE-FacIn_INSPECTION_DATE),0) 남은일 from Facilities_inspection;

select * from Facilities_inspection;

select * from (select (rank() over(order by Fac_serialnum))r , FAC_serialnum, FAC_NAME,FAC_ADDRESS, FAC_STATUS, FAC_CATEGORY from Facilities ) where r>0 and r<=10 and fac_status='수리신청' 