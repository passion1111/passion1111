select * from nowdate order by name;
select * from facilcheck;

--Ķ���� ����ҋ� #{}���� �� ������      ��Żó��
select * from nowdate where birth between to_date('20171111','YYYYMMDD') and to_date('20191111','YYYYMMDD');   

insert into nowdate(birth,name) (select birth,name from nowdate);


select * from(select rownum r,birth,name from nowdate) where r>10;
select /*+ index_asc(nowdate nowdate_name) */ name,rownum from nowdate where rownum>0;