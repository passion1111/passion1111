create table userlist(
    id VARCHAR2(10) CONSTRAINT id_pk PRIMARY key,
    name VARCHAR2(10) not null
);

select * from userlist;

insert into userlist values('aa', 'bb');
insert into userlist(name, id) values('cc', 'ddd');
select * from member;
drop table de_test;
create table de_test(
    name VARCHAR2(10) not null,
    addr VARCHAR2(10) default '¼­¿ï',
    tel varchar2(15) 
);
select * from de_test;

insert into de_test(name, addr, tel)
    values('aa', 'busan', '111');
    
insert into de_test(name, addr, tel)
    values('bb', default, '3333');

insert into de_test(name, addr, tel)
    values('cc', 'jeju', '555');
    
insert into de_test(name, addr)
    values('dd', default);
    
insert into de_test(name,tel)
    values('gg', '999');
    
insert into de_test(name,addr, tel)
    values('gg',null,'999');
