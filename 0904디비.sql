alter table tnotices add(filesrc2 varchar2(400));
commit;
select * from tmember;
desc tmember;
select * from tnotices;
update tmember set point =2 where pwd ='11';

desc tmember;
select *from tmember where pwd='0';
insert into tmember(pwd,name,gender) values(00,'11', '11' );
update tmember set (pwd,name,gender) =(select pwd,name,gender from tmember where pwd='0');