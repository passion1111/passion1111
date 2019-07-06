drop table beverage;

CREATE TABLE BEVERAGE (
BVRNO NUMBER NOT NULL,
BVRNAME VARCHAR2(20) NOT NULL,
PRICE NUMBER,
CONSTRAINT PK_BVR PRIMARY KEY(BVRNO)
);


	
col bvrno for 99;
col bvrname for a20;
col price for 99999;

insert into beverage values(01, 'coca', 1000);
insert into beverage values(02, 'sprite', 100);
insert into beverage values(03, 'fanta', 900);
insert into beverage values(04, 'orange', 900);
insert into beverage values(05, 'pocari', 1200);
insert into beverage values(06, 'coffee', 1200);
insert into beverage values(07, 'vita', 700);
insert into beverage values(08, 'milkis', 800);

commit;

commit;
select * from beverage;

drop table stock;
create table stock (bvrno number not null, bvrname varchar(20) not null, amount number);
	
col bvrno for 99;
col bvrname for a20;
col amount for 9999;

insert into stock values(01, 'coca', 10);
insert into stock values(02, 'sprite', 10);
insert into stock values(03, 'fanta', 10);
insert into stock values(04, 'orange', 10);
insert into stock values(05, 'pocari', 10);
insert into stock values(06, 'coffee', 10);
insert into stock values(07, 'vita', 10);
insert into stock values(08, 'milkis', 10);

commit;

commit;
select * from stock;


drop table jumunnum ;

CREATE TABLE jumunnum (
jumunNO NUMBER NOT NULL,
jumunbreakdown VARCHAR2(3000) ,
PRICE NUMBER,
CONSTRAINT PK_jmno PRIMARY KEY(jumunNO)
);
select*From  jumunnum ;


 
	
    insert  into jumunnum (jumunNO) values (100);
    insert  into jumunnum (jumunNO) values (101);
    insert  into jumunnum (jumunNO) values (102);
    insert  into jumunnum (jumunNO) values (103);
    
    commit;
    







