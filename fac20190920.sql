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
insert into Facilities values((select count(Fac_serialnum)+1 from Facilities),'소화기','1층계단','정상','소방');

insert into Facilities values((select count(Fac_serialnum)+1 from Facilities),'소화기','1층계단','정상','소방');
  
update Facilities set FAC_NAME='소화기',FAC_ADDRESS='1층화단',FAC_STATUS='정상',FAC_CATEGORY='소방' where Fac_serialnum=1;
