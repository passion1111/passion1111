create table Facilities( --�ü���
Fac_serialnum number  ,          --�Ϸù�ȣ PK
Fac_name varchar2(30),         -- �ü��� 
Fac_address varchar2(30) ,   --��ġ
Fac_status varchar2(30),
Fac_category varchar2(30)
);

create table Facilities_inspection(   --�ü��� ����
FacIn_serialnum  number ,                           --�����Ѱ� Facilities�� fk
FacIn_name varchar2(30), 
FacIn_address varchar2(30),
FacIn_INSPECTION_DATE date default sysdate,    -- ������ 
FacIn_INSPECTION_DUE_DATE date
);
drop table Facilities_inspection;
select * from Facilities_inspection;
select * from Facilities;
commit;
update Facilities set fac_status='�����Ϸ�' ;

--�ø���ѹ�  ��κ� �ø��� �ѹ��� �����ѵ�  �ü��̸� �ֱ� �߰��� ������ ���߿� ��Ͽ� ���°��� �߰������ÿ� ó���ҷ���. ,�ü��̸� ,�ֱ�  
create or replace procedure facin_update( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                          f_address in facilities_inspection.facin_address%type,
                                          f_cycle   in number :=0)
is
begin
 case when f_name='����������' then 
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+90,facin_address=f_address where FacIn_serialnum=f_number;
      when f_name='�跮��' then
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+30,facin_address=f_address where FacIn_serialnum=f_number;
      else
      for  temp_update in (select * from Facilities_inspection where FacIn_serialnum=f_number) --����������� into�� ��ü
      loop
      update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+(temp_update.FacIn_INSPECTION_DUE_DATE-sysdate),facin_address=f_address where FacIn_serialnum=f_number;
      end loop;
 
 end case;
end;
/
select * from facilities_inspection;
desc facilities_inspection;
--insert into �ϱ�����
desc Facilities_inspection;
create or replace procedure facin_insert( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                           f_address in facilities_inspection.facin_address%type,
                                          f_cycle   in number :=0,
                                          )
is
begin
 case when f_name='����������' then 
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FACIN_SCHEDULED_INSPECTION_DATE,FACIN_STATUS,facin_address) 
         values(select count(*)+1 from Facilities_inspection, '����������',sysdate,sysdate+30 ,'����',f_address);
      when f_name='�跮��' then
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FACIN_SCHEDULED_INSPECTION_DATE,FACIN_STATUS,facin_address) 
         values(select count(*)+1 from Facilities_inspection, '�跮��',sysdate,sysdate+90 ,'����',f_address);
      else
     insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FACIN_SCHEDULED_INSPECTION_DATE,FACIN_STATUS,facin_address) 
         values(select count(*)+1 from Facilities_inspection, f_name,sysdate,sysdate+f_cycle,'����',f_address);
 
 end case;
end;
/






        select * from Facilities_inspection;
exec facin_insert(3,'���ν����׽�Ʈ');
desc Facilities_inspection;
insert into Facilities_inspection values(3,'���ν����׽�Ʈ',sysdate,sysdate+5);

select FacIn_serialnum ,                           --�����Ѱ� Facilities�� fk
FacIn_name ,    
FacIn_INSPECTION_DATE ,    -- ������ 
FacIn_INSPECTION_DUE_DATE  , trunc((FacIn_INSPECTION_DUE_DATE-FacIn_INSPECTION_DATE),0) ������ from Facilities_inspection;

select * from Facilities_inspection;

select * from (select (rank() over(order by Fac_serialnum))r , FAC_serialnum, FAC_NAME,FAC_ADDRESS, FAC_STATUS, FAC_CATEGORY from Facilities ) where r>0 and r<=10 and fac_status='������û' 