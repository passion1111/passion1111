-- SubQuery(��������) --------------------
select * from emp2;
select * from emp2 where name ='�����';
select * from emp2 where pay > 60000000;

select * from emp2 where pay > 
            (select pay from emp2 where name ='�����');

--����1]emp2 ��� �޿����� ���� ��� ����ϼ���.
select avg(pay) from emp2;
select * from emp2 where pay < 43100000 ;

select * from emp2 where pay < (select avg(pay) from emp2) ;

--����2]student ���̺��� 1�г�(grade) ��� Ű���� ū ����� ����Ͻÿ�. 
select avg(height) from student where grade = 1;

select * from student where height > 
    (select avg(height) from student where grade = 1);

select * from department; -- deptno
select * from student; -- deptno1
����3]�л����̺�, �а� ���̺��� ����Ͽ� ������ �л��� ����(deptno1)�� 
������ �л����� �̸��� ������ �̸��� ����ϼ���.

select deptno1 from student where name='������';

select name, dname
    from student s , department d
    where  s.deptno1 = d.deptno;

select s.name, d.dname
    from student s , department d
    where s.deptno1 = (select deptno1 from student where name='������') 
    and s.deptno1 = d.deptno;

select * from student;
select * from department;

����4]���� ���̺��� �Ի����� �۵��� �������� ���߿� �Ի��� �����
    �̸�, �Ի���, �а����� ����Ͻÿ�.
select hiredate  from professor where name='�۵���'; 
-- 98/03/22
select p.name, p.hiredate, d.dname
  from professor p , DEPARTMENT d
  where hiredate > ( select hiredate  from professor where name='�۵���' )  -- �Ի��� ����/ ������ �ε�ȣ �����ϸ� ��
  and p.deptno = d.DEPTNO ;
    
����5] �л� ���̺��� 1����(deptno1)�� 101�� �а��� ��� �����Ժ��� 
    �����԰� ���� �л����� �̸��� �����Ը� ����Ͻÿ�
select avg(weight) from student where deptno1 = 101 ;

select name, weight
  from student 
  where weight > 60 ;
------------------------------------
select name, weight
  from student 
  where weight > 
    (select avg(weight) from student where deptno1 = 101) ;

select empno, name, deptno
    from emp2
    where deptno in( 1000, 1001, 1002, 1010, 2000, 2001 );
    
select * from emp2;
select * from dept2;

select empno, name, deptno
    from emp2
    where deptno in( select dcode from dept2 where area='��������');
-----------------------------------
1. ������� �̸�, �μ���ȣ, �μ��̸��� ����϶�. (emp, DEPT table)
2. DALLAS���� �ٹ��ϴ�  ����� �̸�, ����, �μ���ȣ, �μ��̸���
 ����϶�. (emp, dept table)
3. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����϶�. ( emp, dept )
4. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������
    ����ϴµ� ������ 3000�̻��� ����� ����϶�. (emp, dept )
5. ������ 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
    �� ����� ���� �μ� �̸��� ����϶�. (emp, DEPT)

Oracle SQL_PLSQL_PPT  - ppt 5�� 





