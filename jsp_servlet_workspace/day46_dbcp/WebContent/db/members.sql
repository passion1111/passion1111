select * from tab;
select * from members;

drop table members;

create table Members (
	id varchar2(12) not null primary key,
	passwd varchar2(12) not null,
	name varchar2(20) not null,
	jumin1 varchar2(6) not null,
	jumin2 varchar2(7) not null,
	email  varchar2(30),
	blog varchar2(50),
	reg_date date not null	
) SEGMENT creation immediate;

select * from members;

delete from members;
insert into Members(id, passwd, name, jumin1, jumin2, email, blog, reg_date)
	values ('aa', '1004', 'doyeon', '11', '11', 'aa@kosta.or.kr', 'aaa',  '2015/12/20');
	

-------------------------------------------------------------


