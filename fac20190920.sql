select * from Facilities;
select * from (select (rank() over(order by Fac_serialnum))r ,FAC_NAME,FAC_ADDRESS,FAC_STATUS,FAC_CATEGORY from Facilities ) where r>=1 and r<=7;
select * from 
(select (rank() over(order by Fac_serialnum))r ,
				FAC_serialnum,
				FAC_NAME,FAC_ADDRESS,
				FAC_STATUS,
				FAC_CATEGORY from Facilities ) 
				where r>0 and r<=7;
select * from (select (rank() over(order by Fac_serialnum))r ,FAC_NAME,FAC_ADDRESS,FAC_STATUS,FAC_CATEGORY from Facilities ) where r>0 and r<=7;
      delete from  Facilities where  fac_serialnum =7;                                                                                                        


select * from  facilities join facilities_inspection on facilities.fac_serialnum=facilities_inspection.facin_serialnum;

select fac_serialnum ,rank() over(order by fac_serialnum) from  facilities join facilities_inspection on facilities.fac_serialnum=facilities_inspection.facin_serialnum;



begin
    insert into facilities_inspection values(:fac_period,:fac_name,fac_inspectiondate,


select * 

desc Facilities;
insert into Facilities values((select count(Fac_serialnum)+1 from Facilities),'��ȭ��','1�����','����','�ҹ�');

insert into Facilities values((select count(Fac_serialnum)+1 from Facilities),'��ȭ��','1�����','����','�ҹ�');
  
update Facilities set FAC_NAME='��ȭ��',FAC_ADDRESS='1��ȭ��',FAC_STATUS='����',FAC_CATEGORY='�ҹ�' where Fac_serialnum=1;


