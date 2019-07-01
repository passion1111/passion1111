select *from kostat able;

drop table KOSTATABLE;
select*from kostatable;
select* from Customers;
create table Customers(
    code number(4) primary key,
    name varchar2(30) not null,
    email varchar2(50),
    phone varchar2(20)
    );
    
    create table board(
    idx number primary key,
    title varchar2(200),
    writer varchar2(200),
    regdate  varchar2(200),
    count varchar2(200),
    content clob);
    drop table board;
    commit;
    select*from dept2;
    insert into dept2 values(1111,1,1,1);
    commit;
    
    
    INSERT INTO DEPT2 VALUEs( 3211,1 , 1, 1 );
    select*from gift;
    
    update gift set gno=55 where gno=1;
    delete gift where gno=55;
    SELECT * FROM COLS WHERE TABLE_NAME = 'gift';
    SELECT * FROM COLS WHERE TABLE_NAME = 'EMP2';
    alter table gift add(gnno number);
    
    update gift set gnno=nvl(gnno,0);
    insert into gift values(1,2,3,4,5);
    select*from gift;
    insert into gift(g_start) values(100);
    select*from gift;
    delete gift where gno is null;
    delete gift where gno=1;
    commit;
    update gift set gno=1 where gno=1;
    alter table gift drop column gnno;
    
    create table board(
    userid varchar2(50) ,
    firstname varchar2(50),
    lastname varchar2(50),
    dob date,
    email varchar2(100),
    content clob
    );
    drop table users;
    select*from users;
    update users set dob='01-01-1111';
    create sequence user_sequence;  
    commit;
    insert into users values(1,'sss','aaa',sysdate,'dasod@naver.com','dasdas');
    select *from users;
    drop table board;
    select*from board;
    
    create sequence board_sequence; 
    drop sequence board_sequence;
    
    select BOARD_SEQUENCE.nextval from dual;
    select *from board;
    
    commit;
    select idx,title,writer,content,regdate,count from board where idx=190;
    create sequence board_seq;