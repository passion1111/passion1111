create table Facilities( --�ü���
Fac_serialnum number  ,          --�Ϸù�ȣ PK
Fac_name varchar2(30),         -- �ü��� 
Fac_address varchar2(30)    --��ġ

);
create table Facilities_inspection(   --�ü��� ����
FacIn_INSPECTION_DATE date default sysdate,    -- ������ 
FacIn_serialnum  number                            --�����Ѱ� Facilities�� fk
);

select * from Facilities_inspection;
select * from Facilities join Facilities_inspection  on Facilities.Fac_serialnum=Facilities_inspection.FacIn_serialnum;

select Fac_serialnum,Fac_name,Fac_address,FacIn_INSPECTION_DATE from Facilities,Facilities_inspection;  --FKȮ���ϰ� �������� natural join���� �ذ��Ұ�.


select * from Facilities natural join Facilities_inspection  on Facilities.Fac_serialnum=Facilities_inspection.FacIn_serialnum;



select * from Facilities join (select FacIn_INSPECTION_DATE,FacIn_serialnum Fac_serialnum from Facilities_inspection) Facilities_inspection 
on Facilities.Fac_serialnum=Facilities_inspection.Fac_serialnum;



select * from Facilities join on Facilities.Fac_serialnum=Facilities_inspection.FacIn_serialnum;

insert into Facilities values(1,'��ȭ��','1��ȭ��');
insert into Facilities values(2,'��ȭ��','1��������');
insert into Facilities values(3,'��ȭ��','1�������ǹ���');
insert into Facilities values(4,'������','1��');
insert into Facilities values(5,'������','1��');
insert into Facilities values(6,'������','2��');

create or replace trigger facilities_trigger
after insert on  Facilities for each row
begin
 insert into Facilities_inspection(FacIn_serialnum) values(:new.Fac_serialnum);
 end;
 /
 insert into Facilities values(7,'������','3��');
 select * from Facilities_inspection;
 select * from Facilities_inspection;
  select * from Facilities;

select *from  Facilities natural join (select  FacIn_serialnum Fac_serialnum ,case when Fac_serialnum=111 then 111 end
   , FacIn_INSPECTION_DATE from Facilities_inspection);
 select Fac_serialnum,Fac_name,Fac_address,FacIn_INSPECTION_DATE,case when Fac_name='�ҹ�'
                                                                                        case when (sysdate-FacIn_INSPECTION_DATE)>150 then FacIn_INSPECTION_DATE+180 end
                                                                      when Fac_name='������'
                                                                                       case when (sysdate-FacIn_INSPECTION_DATE)>60 then FacIn_INSPECTION_DATE+180
                                                                                             
 then 13 end aa from Facilities,Facilities_inspection;  --FKȮ���ϰ� �������� natural join���� �ذ��Ұ�.

 select 
 
 


insert into Facilities_inspection(FacIn_serialnum) values(1);
insert into Facilities_inspection(FacIn_serialnum) values(2);