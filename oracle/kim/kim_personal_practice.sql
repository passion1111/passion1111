create table userlist(id varchar2(10) constraint id_pk primary key, --constraint�� �������� id_pk�Ⱦ��� �⺻Ű������ ����������������ִ°� �⺻Ű�� t.n_f.n_�������� �����ָ� �ؼ��ϱ�����
name varchar2(10) not null --primaryŰ�� not null�Ƚᵵ notnull�� �ֳ��ϸ� not null�� �ȵǴϱ�.   primary key�� ���ϼ��� �����°Ϳ��� �־������.
);
--�ϳ������̺��⺻Ű�¹ݵ���Ѱ�������. �������������� 2������ �ɼ�����.
select*from userlist;

insert into userlist VALUES('aa','bb');
insert into userlist(name,id)  VALUES('cc','ddd');  --������ �ϳ��� ������. �ֳ��ϸ� ���� ������������ notnull���϶�� �������ϱ�

select *from emp2;
select*from professor;
select*from hakjum;
select min_point,max_point+1000 from hakjum;
select max_point from hakjum where max_point>80;
select name,pay,deptno from professor where name='������';
select name,pay,deptno from professor where name like '��%%'; --������ �����ϴ� ��� �˻�
select name,position,pay,hiredate from professor where pay between 100 and 600;

--null�� ���������ʾƼ� ���� �𸥴� 0���� �ٸ���
select name,email from professor where hpage is null;
select name ,position from professor where pay between 100 and 600 and position='������'; --�������̸鼭 ������ ���̴� 100~600����

--���� ���Ե� ����� �����͸� �̾ƿ���
select name from professor where name between '��%' and '��%'; --���� ���Ե� ����� ����ϱ�

select *from student;
select name, height from student where grade=1 order by height,weight desc;-- ������ ������ Ű ������
select name,birthday,height from student order by 3; --����� �÷��� ��ġ name,birthday ,height�� ���� 1 2 3
select name "�̸�",height "Ű" from student; --�̸��� Ű�� ������ ���

select name"�̸�"from student where name between '��' and '��'union all select name"�̸�"from professor where name between '��' and '��'; --������ �л��� ���� �����ϴ� ��� ������
--union �ߺ������� ��� union �ߺ� ���ž��ϰ� ��� intersect ������ minus������  �׸��� " " �� ��Ī�� ����ϰ� ���ڿ��� ' ' ������ �����


select*from member;q
