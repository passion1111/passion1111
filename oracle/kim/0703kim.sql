--하나의 테이블에 대해 하나의 기본키만 지정 가능함.
--관리자 모드에서 같은 메뉴를 두 번 추가하면 안 되기 때문에 메뉴이름에 기본키 속성을 줬음
--메뉴번호가 필요할까?? 필요 없다면 지우겠음

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
create table stock(
coca number,
sprite number,
fanta number,
orange number,
pocari number,
coffee number,
vita number,
milkis number
);

col coca for 999;
col sprite for 999;
col fanta for 999;
col orange for 999;
col pocari for 999;
col coffee for 999;
col vita for 999;
col milkis for 999;

insert into stock(coca, sprite, fanta, orange, pocari, coffee,vita, milkis)
values(10,10,10,10,10,10,10,10);


commit;
select * from stock;


select* from beverage;
select*from stock;
SELECT * FROM BEVERAGE,stock where column_coca=BEVERAGE.BVRNAME ORDER BY BVRNO;



--하나의 테이블에 대해 하나의 기본키만 지정 가능함.
--관리자 모드에서 같은 메뉴를 두 번 추가하면 안 되기 때문에 메뉴이름에 기본키 속성을 줬음
--메뉴번호가 필요할까?? 필요 없다면 지우겠음

drop table beverage;

CREATE TABLE BEVERAGE (
BVRNO NUMBER NOT NULL,
BVRNAME VARCHAR2(20) NOT NULL,
PRICE NUMBER,
CONSTRAINT PK_BVR PRIMARY KEY(BVRNO, BVRNAME)
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
create table stock(
coca number,
sprite number,
fanta number,
orange number,
pocari number,
coffee number,
vita number,
milkis number
);

col coca for 999;
col sprite for 999;
col fanta for 999;
col orange for 999;
col pocari for 999;
col coffee for 999;
col vita for 999;
col milkis for 999;

insert into stock(coca, sprite, fanta, orange, pocari, coffee,vita, milkis)
values(10,10,10,10,10,10,10,10);


commit;
select * from stock;
select*from BEVERAGE;


drop table BEVERAGE_Orderlist;
CREATE TABLE BEVERAGE_Orderlist (
OrderNum NUMBER NOT NULL,
OrderAmount Number not null,
BVRNAME VARCHAR2(20) NOT NULL,
PRICE NUMBER,
CONSTRAINT PK_BVR_oderlist PRIMARY KEY(OrderNum)
);
create sequence BEVERAGE_Orderlist_seq;
select*from BEVERAGE_ORDERLIST;
insert into BEVERAGE_ORDERLIST values(BEVERAGE_Orderlist_seq.nextval,'cada',6000,5);













