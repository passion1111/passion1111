-- Select -----
select * from emp2;
delete from emp2;
ROLLBACK;

select distinct | * | �÷���as ��Ī, �÷���Ī,....
from ���̺��̸�
[where ���ǽ�]
[order by �÷���desc | asc , .. ];
select * from emp2;
select distinct emp_type from emp2; -- �ߺ� ����

select * 
    from emp2
    where position ='����';
    
select empno, name, pay, position 
    from emp2
    where position ='����';
    
select empno as "�����ȣ", name "�� ��", pay �޿�, position "����"
    from emp2
    where position ='����';
    
select empno as "�����ȣ", name "�� ��", pay �޿�, position "����"
    from emp2
    order by name ;  -- asc
    
select empno as "�����ȣ", name "�� ��", pay �޿�, position "����"
    from emp2
    order by name desc;  -- desc

select empno as "�����ȣ", name "�� ��", pay �޿�, position "����"
    from emp2
    where position ='����' and name ='������';  -- and
    
select empno as "�����ȣ", name "�� ��", pay �޿�, position "����"
    from emp2
    where position ='����' or name = '�蹮ȣ';  -- or 

select * from emp2 where deptno = 1000; -- ����
select * from emp2 where name like '��%'; -- ����  % : ���, _ :�ѹ���

select * from professor where name like '��_';
select * from professor where name like '_��';
select * from professor where name like '__';

select * from professor where name like '%��%';
select * from professor where name like '%��_';
---- ����
select * from professor where pay > 500;
select * from professor where pay <= 300;
select name, pay from professor where pay >= 250 and pay < 500;
select * from professor where bonus is not null;
-- �޿��� 500�̻��̰�, ���ʽ��� 60 �̻� �޴� ������?
select * from professor where pay >= 500 and bonus >= 60;

--����1] �̸��� '���Ѷ�'�� '���Ѷ�'���� ���� 
select * from emp2 where name ='���Ѷ�';
update emp2 set name='���Ѷ�' where name ='���Ѷ�';
    
--����2] ��̰� ����� ����鸸 ã�Ƽ� '����'���� ����
select * from emp2 where hobby='���';
update emp2 set hobby='����' where hobby='���';
select * from emp2 where hobby='����';
   
--����3] ����� ���� ã�Ƽ� ���� �ϱ�
select * from emp2 where emp_type='�����';
delete emp2 where emp_type='�����';  -- delete ���� from ��������
  
--����4] pay( or bonus) �� 50�̻��� ����� ���
select * from professor where bonus >= 50;
delete from professor where bonus >= 50;
---------------------------
--����5] ~��Ʈ �� �ƴ� ��ǰ�鸸 ���
select * from gift where gname not like '%��Ʈ';

--����6] gno�� 10�� ��ǰ�� �̸��� ��ó��(null) �ϼ���
select * from gift where gno = 10;
update gift set gname=null where gno=10;
select * from gift order by gno desc;

--����7] gname �̸��� ����, g_start�� 999�� ���� ���� ������ �Է��ϼ���.
insert into gift(gname, g_start) values(' ', 999);
select * from gift where gname is null or gname = ' ';

--����8] gname�� null�̰ų� ' '�� �����͸� �����ϰ� ����Ͻÿ�.
select * from gift where gname is null or gname = ' ';
select * from gift where gname not in('null', ' ') order by gno desc;
select * from gift where gname !=' ' 
        and gname is not null order by gno desc;
--- ������ -------
select mod(7, 3) from dual;
select name, bonus from professor;
-- null ������ ������ null 
select name, bonus + 2000 from professor;
-- nvl(��, ��ġ��) : null�� ������ ��ġ������ ����
select name, nvl(bonus,0) + 2000 from professor;

update professor set bonus = bonus + 1000; -- �ȵ� ��Ȳ��...
update professor set bonus = nvl(bonus, 0) + 1000; 
select * from professor;
rollback;

select * from gift where gno=1 or gno = 7 or gno =9;  
select * from gift where gno in(1, 7, 9); -- ����
-- between �տ��� ������ and �ڿ��� ū��            
select * from gift where gno between 6 and 9;
select * from gift where gno between 9 and 6;  --�ȵ�. 
select * from gift where g_end between 600000 and 800000;

-- emp2
--������ �̸鼭 '�����' ã��
select * from emp2 where emp_type='������' and name='�����';
--������ �̸鼭 �̾��� ����� ã��
select * from emp2 where emp_type='������' and name like '��%';
select * from emp2 where emp_type='������' and name not like '��%';

--������ �̰ų� '������' ã��
select * from emp2 where emp_type='������' or name='������';
--������ �̰ų� �达���� ���� ��� ã��
select * from emp2 where emp_type='������' or name like '��%';
--�达�� �ƴ� �������� ã��
select * from emp2 where emp_type='������' or name not like '��%';
---------------------------------------------

select * from PROFESSOR;
select profno, id, name 
    from PROFESSOR 
    where profno in(3001, 4001, 5001);
select profno, id, name from PROFESSOR 
    where profno not in(3001, 4001, 5001);

desc professor;
select profno, id, name from PROFESSOR 
    where profno between 3000 and 5000;
    
select id from professor where id like  'j_a%'; 
select * from professor where id like  's_a%';
select * from professor where id not like  's_a%';

select profno, id, name from PROFESSOR 
    where profno < any(1000, 2000, 3000); --  �ʵ� < any(�ִ밪) ���� ����
select profno, id, name from PROFESSOR 
    where profno > any( 2002, 3000 ); -- �ʵ� > any(�ּҰ�) ���� ū ��

select profno, id, name from PROFESSOR 
    where profno < all( 2002, 3000 ); -- �ʵ� < all(�ּҰ�) ���� ���� ��
select profno, id, name from PROFESSOR 
    where profno > all( 3002, 4003 ); -- �ʵ� > all(�ִ밪) ���� ū ��

select * from gift;
SELECT gno, gname, NVL(g_start, 0) + 1000, NVL(g_end, 100) + 3333 FROM gift;
rollback;

--���� 1 **
--Professor ���̺��� �������� �̸��� ��ȸ�Ͽ� �� 
--�κп� ������  �� ���Ե� ����� ����� �Ʒ��� ���� ����ϼ���.
select name from professor
    where name between '��%' and '��%' 
    order by 1;  -- ����?

select * from gift order by gno desc, gname desc;
select * from gift order by 1 desc, 2 desc;




