--���̺� ����/����----
--�÷��߰� alter table ���̺��̸�add  (�÷����ڷ���[��������] , �÷����ڷ���[��������] , ....)
--�÷����� alter table ���̺��̸�drop column �÷��̸�
--datatype���� alter table ���̺��̸�modify �÷��̸������ڷ���
--�÷��̸����� alter table ���̺��̸�rename column �����÷���to �����÷���
--���̺���� drop table ���̺��̸�

select *from de_test;  
alter table de_test add gender char(2);   --���� �߰����ֱ��������°�    add�ڿ� �߰��� �������� �Ѱ����ϋ��°�ȣ �������൵��.
--���̺��� ��ġ name���� gender������ ���Ѵ�. �ٵ� �׷��Դ� �ȵſ�

alter table de_test add (no number(2),etc varchar(50) ); --���� �������� ���� �ҋ��� ��ȣ�� ��������� no�� varchar2�� ���ϱ�.

--update tablename set ������ ����;   �̷��� ���� ��ü�� �ٹٲ�.
--update tablename set ������ ���� where ����;  �̷��� ���� ���ǿ� �´°͸� �ٲ�.

update de_test set gender='F';  -- �ѱ۷� �����ָ� ���ڴ� 3����Ʈ�ν���.  �̷��� ������ ������̺� gender���� f�� ����.
update de_test set etc='��Ʈķ��'where addr='����';  --�����λ���� ��Ʈķ���� ���� 
update de_test set etc='��Ʈ����' where addr not in('����');  --������ �ƴ�  ������� ��Ʈ��������

--jeju �ּ� ����� ������ ���ڷ� �����ϼ���
update de_test set gender='M' where addr='jeju';  

--�����Ұ���
alter table de_test  drop column no  ;      
--de_test�� drop���̺��� no���� �����ϴ°�
alter table de_test  drop(gender,etc); --�÷��������

--datatype ����
--alter table ���̺��̸� modify �÷��̸� �����ڷ���

desc de_test;
select *from de_test;
-- �⺻ �����Ͱ� �־��� ��� ���� �߻� ��������.
alter table de_test modify tel number;  --null�� �ƴϿ��� �ٲܼ��� ����.
alter table de_test modify gender number; --�÷��� ������ Ÿ�� ����

update de_test set tel='';  --null���� �־���� �ڷ�������������
rollback;          --commit, rollback ��ɾ�� dml��ɾ�� ����ȴ�.insert select update delete���� ����

alter table de_test modify addr number;

select*from de_test;
--delete tableName field;           --��ü ����
--delete de_test addr where ����; 
delete  de_test addr where addr='����' ;  --������ֵ� ����
alter table de_test modify tel varchar2(15);
desc de_test;       --tel�� varcharŸ������ �ٲ����.
--truncate table ���̺��̸�; ->��� ���ڵ� ����
select*from userlist;
TRUNCATE table userlist where name='cc';  -- ���� ����Ҽ� ���� �����ߴ°� ����.
TRUNCATE TABLE userlist;       --�̷��Ը� �����



--�÷� �̸� ����
--alter table tablename rename column �����÷���to���� �÷���
alter table  de_test rename column addr to address;
alter table de_test rename column tel to phone;

--table ����
drop table de_test ; -- ������ ��ü�� ����
delete de_test; --���ڵ� ����

select *from tab; --������ ��ü�� �����ϰ� ���� �������� ����������
--drop���� �����ϰ� Ȯ���ϸ� ���Ȯ���ϴ°���
show recyclebin;       
--���� ����.
desc recyclebin;

FLASHBACK TABLE de_test to before drop; --�����Ұǵ� de_test�� drop�ϱ������� �����ϴ°�
select*from de_test;
purge RECYCLEBIN;--��� �����
select *from userlist;
drop table userlist;  --�̹���� �����뿡 ����
FLASHBACK table userlist to before drop; 
drop table userlist PURGE; --��⿡�� ����.

--���ڵ� ����/����/����--
insert into ���̺��̸�(�÷���, �÷���,...) values(��, ��, ...)  --�÷� ����� ������� values�� �־��ָ� ��.
insert into ���̺��̸�values(��, ��, ...)      --���� �� ���Ѽ� �־����
=>����÷�����ΰ������������


create table userlist(  --���̺� ����
    id VARCHAR2(10) primary key, 
    -- �⺻Ű �������� 
--varchar�� primary key���̿� ket���̸� ���Ҽ�����
    name VARCHAR2(10),
    address VARCHAR2(30)
);

insert into userlist values('aa','bb','cc');
select *from userlist;
insert into userlist(id,address) values('king','buss');
insert into userlist(id) values('happy');  --primary key������ userlist ��ȣ���̿� id�� ���������


--------------update----------------
update ���̺��̸�
    set �÷���=���氪,�÷���=��,....x
    [where ����];
    
select *from userlist;
update userlist set name='cc',address='seoul';
rollback;

delete userlist where name='bb';
delete userlist where address=null;     -- ''  null�� �ص� �ȵ� null���� ������� ����ؾ����� �����غ�
delete userlist where address is null;-- null�ξֵ� ������Ŵ

select * from userlist where name is null;
update userlist set name ='' where id='king';
select *from userlist where name is null or name=' ';
select*from userlist where name is not null;

