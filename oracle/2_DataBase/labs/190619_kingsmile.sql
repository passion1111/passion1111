-- ���̺����/ ���� -----
select * from de_test;
alter table de_test add gender char(2);
alter table de_test add 
        (no number(2), etc varchar2(50));

-- update tableName set ����� ���� ;
-- update tableName set ����� ���� where ���� ;
update de_test set gender = 'F';
update de_test set etc='��Ʈķ��' where addr='����' ;
-- jeju �ּ� ����� ������ ���ڷ� ���� �ϼ���.
update de_test set gender='m' where addr='jeju' ;
-- �ϳ��� �÷� ����
alter table de_test drop column no; 
-- ������ �÷� ����
alter table de_test drop(gender, etc);

-- datatype����
--alter table ���̺��̸� modify �÷��̸� �����ڷ���
desc de_test;
select * from de_test;
-- �⺻ �����Ͱ� �־��� ��� ���� �߻� ���� ����
alter table de_test modify tel number; 
alter table de_test modify gender number;  -- �÷��� ������ Ÿ�� ����
update de_test set tel='' ;
rollback;  --  commit ��ɾ�� DML ��ɾ�� ����ȴ�.
alter table de_test modify addr number; 
-- delete tableName;  
-- delete tableName where ����; 
update de_test set addr='' ;
alter table de_test modify tel VARCHAR2(15);
--�÷��̸�����
--alter table ���̺��̸� rename column �����÷��� to �����÷���
alter table de_test rename column addr to addres;
alter table de_test rename column tel to phone;
select * from de_test;
-- table ����
drop table de_test;
delete de_test;  --���ڵ� ����

select * from tab;
-- ���� ���̺� ��� ����
show recyclebin;
desc recyclebin;
-- ����(������ ���̺�)
FLASHBACK table de_test to before drop;
select * from de_test;
purge RECYCLEBIN; -- ������ ����
select * from userlist;
drop table userlist;
FLASHBACK table userlist to before drop;
drop table userlist PURGE; -- �����뿡 �ȳ���� ���� ����

---- ���ڵ����/ ����/ ���� ----
--insert into ���̺��̸�(�÷���, �÷���,...) values(��, ��, ...)
--insert into ���̺��̸� values(��, ��, ...)
-- =>����÷��� ��� ���� ������ ���
create table userlist(  --���̺� ����
    id VARCHAR2(10) primary key,  -- �⺻Ű ��������
    name VARCHAR2(10),
    address VARCHAR2(30)
);
select * from userlist;
insert into userlist values('aa', 'bb', 'sss');
insert into userlist(id, address) values('kingsmile', 'busan');
insert into userlist(id) values('kang');
-------- update --------------------
update ���̺��̸�
    set �÷���=���氪, �÷���=���氪,.....
    [ where ���ǽ� ];

select * from userlist;
update userlist set name='cc' , address='seoul';
update userlist set name='cc' , address='seoul' where id='happy';
rollback;

delete userlist where name='bb';  
delete userlist where name=null;  --( X )
delete userlist where name is null; -- ( O )

select * from userlist where name is null;
update userlist set name =' ' where id='kang';
select * from userlist where name is null or name =' ';
select * from userlist where address is not null;

-- Delete table�̸�[ where ���ǽ�]
-- truncate table ���̺��̸�; => ��緹�ڵ����
select * from userlist;
truncate table userlist; -- where name ='cc'; --���� ��� �ȵ�








