drop table guestBook;

create table guestBook (
	num number,
	name varchar2(50) not null,
	email varchar2(50),
	home varchar2(50),
	contents varchar2(2000) not null
) SEGMENT creation IMMEDIATE;  

select * from guestBook;

drop sequence book_num;
create sequence book_num; 

insert into guestBook(num, name, email, home, contents)
     values(book_num.nextval, 'dd', 'aa@kosta.or.kr', 'homeaa', 'hello');
    
--------------------------------------------------
 select name, email, home, contents from GUESTBOOK 
 				where num > 6 and num <= 23 
 				order by num desc;


 select count(num) from GUESTBOOK; --null값 제외,count(*)

-----------------------------------------------

update guestBook set email='ii@i.kr', home='http://', contents='hi' where num = 1;

update guestBook set email= ? , home= ? , contents= ? where num = ?;


select ceil(3.3) from dual;  --올림

select name, email, home, contents from GUESTBOOK 
 				where num > 6 and num <= 23 ;
                commit;
--------------------------------------------



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
	
commit;
-------------------------------------------------------------



                