select * from tab;
select*from help;

create table SampleTable (
    num number,
    name varchar2(20),
    phone varchar2(15),
    address varchar2(50)
);
select *from Sampletable;   --��ü ����

select name, address from sampletable; --Ư�� �ʵ常 ���°� 

desc sampletable;  --�ش� ���̺� ��������

---insert ---------

insert into sampletable VALUES(10, 'doyeon',  '010-9872-0202',   '����' );                             --�׳� ������ �־��� ������� �־���Ѵ�.
insert into sampletable VALUES(20, '������',  '010-5656-0244',   '���' );   

insert into sampletable(name,phone,address,num) VALUES('����', '010-999-9999', 'jeju',30);
insert into sampletable(name,phone) VALUES('������', '010-555-744');


update sampletable set address ='�뱸';                            --4���� �ٹٲ� ��ü �����ȴ�.
ROLLBACK;                          --�ѹ����� ���ư� �ٵ� �� �ʱ�ȭ��.  ���� insert�κ� �ܾ �����ϸ��ѹ��� �����.
update sampletable set address='�뱸'where num=30;               --where���� �ʿ��� 30���� �ִ°͸� �ٲ�.
update sampletable set phone='010-5555-5555', num=40 ,address='���'where name='������';

--record ������ delete

delete sampletable; --��ü �� ������. ���̺��� ����

delete sampletable where address ='jeju';  --���� ����� ���ǿ� �´°��� ������ٴ°�.
delete sampletable where num between 10 and 20; --�ش��ϴ� ���̰� ����  

drop table sampletable; --���̺� ��ü�� ��������




