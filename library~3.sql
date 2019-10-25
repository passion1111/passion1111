create table Facilities( --�ü���
Fac_serialnum number  ,          --�Ϸù�ȣ PK
Fac_name varchar2(30),         -- �ü��� 
Fac_address varchar2(30) ,   --��ġ
Fac_status varchar2(30),
Fac_category varchar2(30)
);
create table Facilities_inspection(   --�ü��� ����
FacIn_serialnum  number ,                           --�����Ѱ� Facilities�� fk
FacIn_name varchar2(30),                --�ü��� �̸�
FacIn_address varchar2(30),               --�ü��� ���                 --�ü��� ����
FacIn_Inspection_Date date default sysdate,    -- ������ 
FacIn_Inspection_Due_Date date                 --���˿����� 
);

drop table Facilities;
drop table Facilities_inspection;
commit;


insert into  Facilities values(1,'å��','1��������','����','����');
insert into  Facilities values(2 ,'å��','1��������','���� ','����');
insert into  Facilities values(3,'å��','1��������','���� ','����');
insert into  Facilities values(4,'�ѽ�','1��������','���� ','������ǰ');
insert into  Facilities values(5,'������','1��������','���� ','������ǰ');
insert into  Facilities values(6,'��ǻ��','2���ü���','���� ','������ǰ');
insert into  Facilities values(7,'��ǻ��','3��2��','���� ','������ǰ');
insert into  Facilities values(8,'��ǻ��','1��������','���� ','������ǰ');
insert into  Facilities values(9,'����','1��������','���� ','����');
insert into  Facilities values(9,'','1��������','���� ','����');



--�ü����� 
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(1,'����������','1��',sysdate,sysdate+90);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(2,'�����÷�����','1��',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'�����÷�����','2��',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(3,'�����÷�����','3��',sysdate,sysdate+30);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(4,'����������','2��',sysdate,sysdate+90);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(5,'��ȭ��','2��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(6,'��ȭ��','2��1��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(7,'��ȭ��','2��2��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(8,'��ȭ��','2��3��',sysdate,sysdate+20);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(9,'��ȭ��','2��4��',sysdate,sysdate+3);
insert into Facilities_inspection(FacIn_serialnum,FacIn_name,FacIn_address,FacIn_Inspection_Date,FacIn_Inspection_Due_Date) values(10,'��ȭ��','2��5��',sysdate,sysdate+5);


commit;


create or replace procedure facin_update( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                          f_address in facilities_inspection.facin_address%type) 
is
begin
 case when f_name='����������' then 
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+90,facin_address=f_address where FacIn_serialnum=f_number;
      when f_name='�跮��' then
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+30,facin_address=f_address where FacIn_serialnum=f_number;
        
      when f_name='��ȭ��' then
                 update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+20,facin_address=f_address where FacIn_serialnum=f_number;
        when f_name='������' then
                 update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+180,facin_address=f_address where FacIn_serialnum=f_number;
      
        else
      for  temp_update in (select * from Facilities_inspection where FacIn_serialnum=f_number)
      loop
      update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+(temp_update.FacIn_INSPECTION_DUE_DATE-sysdate),facin_address=f_address where FacIn_serialnum=f_number;
      end loop;
 
 end case;
end;
/

create or replace procedure facin_insert( f_name   in facilities_inspection.facin_name%type,
                                           f_address in facilities_inspection.facin_address%type,
                                          f_cycle   in number :=0
                                          )
is
begin
 case when f_name='����������' then 
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '����������',sysdate,sysdate+180 ,f_address);
      when f_name='�跮��' then
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '�跮��',sysdate,sysdate+30 ,f_address);
      else
     insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date ,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), f_name,sysdate,sysdate+f_cycle,f_address);
 
 end case;
end;
/

commit;

select * fro msal 






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
update Facilities set fac_status='�����Ϸ�' ;

--update ó�� �ø���ѹ�  ��κ� �ø��� �ѹ��� �����ѵ�  �ü��̸� �ֱ� �߰��� ������ ���߿� ��Ͽ� ���°��� �߰������ÿ� ó���ҷ���. ,�ü��̸� ,�ֱ� 
select * from Facilities_inspection;
exec facin_update(1,'����������','1��');
create or replace procedure facin_update( f_number IN Facilities_inspection.Facin_serialnum%TYPE,
                                          f_name   in facilities_inspection.facin_name%type,
                                          f_address in facilities_inspection.facin_address%type) 
is
begin
 case when f_name='����������' then 
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+90,facin_address=f_address where FacIn_serialnum=f_number;
      when f_name='�跮��' then
         update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+30,facin_address=f_address where FacIn_serialnum=f_number;
        
      when f_name='��ȭ��' then
                 update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+20,facin_address=f_address where FacIn_serialnum=f_number;
        when f_name='������' then
                 update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+180,facin_address=f_address where FacIn_serialnum=f_number;
      
        else
      for  temp_update in (select * from Facilities_inspection where FacIn_serialnum=f_number)
      loop
      update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_INSPECTION_DUE_DATE=sysdate+(temp_update.FacIn_INSPECTION_DUE_DATE-FACIN_INSPECTION_DATE),facin_address=f_address where FacIn_serialnum=f_number;
      end loop;
 
 end case;
end;
/
desc Facilities_inspection;
select * from Facilities_inspection;
commit;


select FacIn_serialnum from Facilities_inspection;
select * from facilities;
desc facilities_inspection;
--insert into �ϱ�����
desc Facilities_inspection;
--  
commit;
select * from Facilities_inspection;
exec facin_insert('����������','5��',180);
create or replace procedure facin_insert( f_name   in facilities_inspection.facin_name%type,
                                           f_address in facilities_inspection.facin_address%type,
                                          f_cycle   in number :=0
                                          )
is
begin
 case when f_name='����������' then 
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '����������',sysdate,sysdate+180 ,f_address);
      when f_name='�跮��' then
         insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), '�跮��',sysdate,sysdate+30 ,f_address);
      else
     insert into  Facilities_inspection(FACIN_SERIALNUM,FACIN_NAME,FACIN_INSPECTION_DATE,FacIn_Inspection_Due_Date ,facin_address) 
         values( (select max(FACIN_SERIALNUM)+1 from Facilities_inspection), f_name,sysdate,sysdate+f_cycle,f_address);
 
 end case;
end;
/



select 


        select * from Facilities_inspection;
exec facin_insert(3,'���ν����׽�Ʈ');
desc Facilities_inspection;
insert into Facilities_inspection values(3,'���ν����׽�Ʈ',sysdate,sysdate+5);



-- �����ٰ�.
select FacIn_serialnum ,                           --�����Ѱ� Facilities�� fk
FacIn_name ,    
to_char(FacIn_INSPECTION_DATE,'yyyy"��"mm"��"DD"��"') FacIn_INSPECTION_DATE ,    -- ������ 
facin_address,
to_char(FacIn_INSPECTION_DUE_DATE,'yyyy"��"MM"��"DD"��"') FacIn_INSPECTION_DUE_DATE , trunc((FacIn_INSPECTION_DUE_DATE-FacIn_INSPECTION_DATE),0) RemainingTime from Facilities_inspection;

select * from Facilities_inspection where  facin_name='����������'  and facin_inspection_date between to_char(sysdate-9,'YYYYMMDD') and to_char(sysdate,'YYYYMMDD') ;
select facin_inspection_date ,sysdate-3000 xfrom Facilities_inspection; 




select * from Facilities_inspection;

select * from (select (rank() over(order by Fac_serialnum))r , FAC_serialnum, FAC_NAME,FAC_ADDRESS, FAC_STATUS, FAC_CATEGORY from Facilities ) where r>0 and r<=10 and fac_status='������û' ;



select * from Facilities_inspection;
select * from Facilities_inspection where facin_inspection_due_date>sysdate;
