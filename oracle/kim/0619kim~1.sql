-----select --------
select distinct | * | �÷���as ��Ī, �÷���Ī,....
from ���̺��̸�
[where ���ǽ�]
[order by �÷���desc | asc , .. ]

SELECT *from emp2;

--���� �����ߴٸ�..?
delete from emp2;
--�̷����ϰ� commit�ع����� �����ȉ�

select distinct emp_type from emp2;--�ߺ�����

select * from emp2 where position='����';

select empno as "�����ȣ", name "�� ��" ,pay "�޿�",position "����"
    from emp2 where position='����' order by name;
select * from emp2  order by name desc;

select *from emp2 where name ='������'and  position='����';

select *from emp2 where (name between '��%' and '��%') or position='�븮';

select *from emp2 where deptno=1000;

select *from emp2 where name like '��%'; --���� %:��� ,_:�ѹ���   �׸��� %�� _�� like�������


select *from professor where name like  '��%';
select *from professor where name like  '__';
select *from professor where name like  '_��';
select *from professor where name like  '%��%';

--����
select * from professor where pay >500;
select * from professor where pay<300;
select *from professor where 250<pay and pay<=500;
select *from professor where bonus is not null;
select *from professor where pay>=500 and bonus>=60;

select name from emp2 where name like'��%';

select *from emp2 where name='���Ѷ�';
update emp2 set name='���Ѷ�' where name='���Ѷ�';

update emp2  set hobby='����' where hobby='���';
select *from emp2 where hobby='����';


--����� ���� ã�Ƽ� �����ϱ�
delete emp2  emp_type where emp_type='�����';  --delete���� from ��������.
select *from emp2 where emp_type='�����';

--����4 pay�� 50�̻� ����ϱ�.
select *from professor where pay>=50 or bonus >50;


--��5 ~��Ʈ�� �ƴ� ��ǰ�鸸 ���
select *from gift;
select * from gift where gname not like '%��Ʈ';
--��6 qno�� 10�� ��ǰ�� �̸��� nulló�� �ϼ���
update gift set gname='' where gno=10; 
--��7 qname �̸��� ����,g_start�� 999�� ���� ���� �����͸� �Է��ϼ���.
insert into gift(gname,g_start) values(null,999);
insert into gift(gname) values(' ');
--��8  gname�� null�̰ų� ''�� �����͸� �����ϰ� ����Ͻÿ�
select *from gift where gname is not null and  gname not like '% %';
select *from gift where gname  in('null',' '); --null and ' ' 
select *from gift where gname!=' ' and gname is not null order by gno desc;

--������------
select mod(7,3) from dual; --�������� ���ϱ�
select name,bonus from professor;
--null������ ������ null
select name,bonus+2000 from professor; --null�� ������������
--nvl(��,��ġ��)
select name ,nvl(bonus,0)+ 2000 from professor; --nvl�Լ��� �Լ�,���� ������ null���� �ش��ϴ� ���̵���.

select *from professor;

update professor set bonus=bonus+1000; --�ȵǴ� ��Ȳ��.
update professor set bonus=nvl(bonus,0) ;        --bonus�� 0������ ������. 

select *from gift;

select *from gift where gno=1 or gno=7 or gno=9; --���� x
select *from gift where gno in(1,7,9); --����

select *from gift where gno between 6 and 9; --�����;
select *from gift where gno between 9 and 6;--�ƹ����� ȣ�����.
select *from gift where g_end between 60000 and 800000;

--emp2
--�������̸鼭(and) '�����'

select *from emp2 order by name;
select*from emp2 where emp_type='������'and name='�����';
--������ �̸鼭 �̾��� ����� ã��
select * from emp2 where emp_type='������' and name like '��%';
select * from emp2 where emp_type='������' and name not like '��%';

--�������̰ų� ������ã��
select *from emp2 where emp_type='������' or name='������';
--�������̰ų� �达���� ���� ��� ã��
select *from emp2 where emp_type='������'or name like '��%';
--�达�� �ƴ� �������� ã��
select*from emp2 where emp_type='������' and  name not  like '��%';--between '��' and '��';

-------------------------------

select * from PROFESSOR;
select profno, id, name from PROFESSOR where profno in(3001, 4001, 5001);
select profno, id, name from PROFESSOR where profno not in(3001, 4001, 5001);

desc professor;
select profno, id, name from PROFESSOR where profno between 3000 and 5000;
select * from professor where id like  'j_a%'; 
select * from professor where id like  's_a%';
select * from professor where id not like  's_a%';

select profno, id, name from PROFESSOR where profno < any(1000, 2000, 3000); --any�ȿ� ���� ū���� ã�� profno�� �� ������ ã�� �ʵ�<any(�ִ�)
select profno, id, name from PROFESSOR where profno > any( 2002, 3000 ); --any�ȿ��� ���� ��������ã�� �װͺ��� ū�� Ȯ��.    �ʵ�<any(�ּڰ�)

select profno, id, name from PROFESSOR where profno < all( 2002, 3000 ); --all���� �ּҰ����� �۳�    �ʵ�<all(�ּڰ�)
select profno, id, name from PROFESSOR where profno > all( 3002, 4003 ); --all���� �ִ밪���� ū��   �ʵ�>all(�ִ�)

select * from gift;
SELECT gno, gname, NVL(g_start, 0) + 1000, NVL(g_end, 100) + 3333 FROM gift;
rollback;


--���� ������ ����ϴµ� �����߿� ������ ���ü��� ������ 2���������ʿ���
select *from gift order by gno,gname;  --gno  orderby���ְ� �����ϸ� gname 