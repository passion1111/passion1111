select * from tab;

create table SampleTable (
    num number,
    name varchar2(20),
    phone VARCHAR2(15),
    address VARCHAR2(50)
);

select * from sampletable; -- ��ü ���� 

select name, address from sampletable; -- Ư�� �ʵ常 ����

desc sampletable;  -- �ش� ���̺� ���� ����

---- insert ---
insert into sampletable VALUES(10, 'doyeon', '010-9872-0202', '����');
insert into sampletable VALUES(20, '������', '010-5555-8888', '�λ�');

insert into sampletable(name, phone, address, num) VALUES('����', '999','jeju', 30);
insert into sampletable(name, phone) VALUES('����', '77777');

update sampletable set address = '�뱸' ; -- ��ü �����ȴ�
ROLLBACK;
update sampletable set address = '�뱸' where num = 30; -- ���ǿ� �´°͸� �����ȴ�

update sampletable set address = '����', num = 40 where name = '����';

select * from sampletable;

delete sampletable;  -- ��ü ���ڵ� ����
delete sampletable where address = 'jeju'; -- ���ǿ� �´� ���ڵ� ����
delete sampletable where num between 10 and 20; 

drop table sampletable;
--------------------------------
-- �ּ�
select * from emp2;
select empno, name, emp_type, deptno from emp2;
select * 
    from emp2 
    where emp_type = '�����'
   -- order by name;
    order by name desc;
    
select * from tab;

desc emp2;  -- 
show user;

select sysdate from dual;
select sysdate from emp2;
