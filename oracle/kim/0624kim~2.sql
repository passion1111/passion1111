--Subquary(��������)--

select*from emp2;

select *from emp2 where name='�����' ;  --������� ���̺��� ū ������� ã�����.
select*from emp2 where pay>6000000; 

select *from emp2 where pay>(select pay from emp2 where name='�����');

--����1 emp2 ��� �޿����� ���� ��� ����ϼ���
select name from emp2  where pay<(select avg(pay) from emp2) ;


--����2 student ���̺��� 1�г� grade ��� Ű���� ū ����� ����ϼ���
select*from student where height>(select avg(height) from student where grade=1);

select *from department;

select*from studnet;

--��3  �л����̺�,�а����̺��� ����Ͽ� ������ �л��� ����(deptno1)�� ������ �л����� �̸��� ����1�� �̸��� ����ϼ���.
select deptno1 from student where name='������';

select name,dname from student s,department d
    where s.deptno1=d.deptno;
    
    
    
    
    select name,dname from student s,department d
    where s.deptno1=(select deptno1 from student where name='������')
    and s.deptno1=d.deptno;

--����4 ���� ���̺��� �Ի����� �۵��Ǳ������� ���߿� �Ի��� ����� �̸�,�Ի��� ,�а��� ����
select *from professor where name='�۵���';
select name,hiredate,deptno from professor where  (select hiredate from professor where name='�۵���')<hiredate;

--����5 �л� ���̺��� 1������ 101�� �а��� ��� ������ ���� �����԰� ���� �л����� �̸��� �����Ը� ���ϼ���.
select avg(weight) from student where deptno1=101;

select name,weight from student where weight>(select avg(weight) from student where deptno1=101);

select empno,name,deptno from emp2
    where deptno in(1000,1001,1002,1010);
    
    
    
    select * from emp;
select * from dept;
select*from department;
-- 1. ������� �̸�, �μ���ȣ, �μ��̸��� ����϶�. (emp, DEPT table)
     select ename,deptno,job from emp ;
     --�μ��̸� ���?
     
     
-- 2. DALLAS���� �ٹ��ϴ�  ����� �̸�, ����, �μ���ȣ, �μ��̸���
-- ����϶�. (dept table)
    select ename, dept.deptno,dname from dept,emp where emp.deptno=dept.deptno;
-- 3. �̸��� 'A'�� ���� ������� �̸��� �μ��̸��� ����϶�. ( emp, dept,emp2 )
select * from emp where ename like '%A%';
-- 4. ����̸��� �� ����� ���� �μ��� �μ���, �׸��� ������
--����ϴµ� ������ 3000�̻��� ����� ����϶�. (emp, dept )
      select * from emp;
select * from dept;

select ename,emp.deptno,dname,sal from emp,dept where emp.deptno=dept.deptno;

-- 5. ������ 'SALESMAN'�� ������� ������ �� ����̸�, �׸���
-- �� ����� ���� �μ� �̸��� ����϶�. (emp, DEPT)
      select dname,job,ename  from emp,dept      where    job='SALESMAN';




-- 6. Ŀ�̼��� å���� ������� �����ȣ, �̸�, ����, ����+Ŀ�̼�,
-- �޿������ ����ϵ�, ������ �÷����� '�����ȣ', '����̸�',
-- '����','�Ǳ޿�', '�޿����'���� �Ͽ� ����϶�. ( emp, SALGRADE )
--(�� ) 1 : 1 ���� ��� �÷��� ����
select*from emp;
select*from salgrade;
select*from dept;
select ename �̸�,sal ����,sal+comm �Ǳ޿�,grade �޿���� from emp,salgrade;

-- 7. �μ���ȣ�� 10���� ������� �μ���ȣ, �μ��̸�, ����̸�,
-- ����, �޿������ ����϶�. ( emp, DEPT, SALGRADE )
select emp.deptno , empno,dname,sal,grade from emp,dept,salgrade;
-- 8. �μ���ȣ�� 10��, 20���� ������� �μ���ȣ, �μ��̸�,
-- ����̸�, ����, �޿������ ����϶�. �׸��� �� ��µ�
-- ������� �μ���ȣ�� ���� ������, ������ ���� ������
-- �����϶�. (emp, dept, SALGRADE )
select emp.deptno,dname,ename,sal,sal+comm from emp,dept,salgrade where emp.deptno=10 or emp.deptno=20 order by emp.deptno ,sal desc ;
-- 9. �����ȣ�� ����̸�, �׸��� �� ����� �����ϴ� ��������
-- �����ȣ�� ����̸��� ����ϵ� ������ �÷����� '�����ȣ',
-- '����̸�', '�����ڹ�ȣ', '�������̸�'���� �Ͽ� ����϶�. ( emp )
--SELF JOIN (�ڱ� �ڽ����̺��� �÷��� ���� �ϴ� ���)

select e.empno �����ȣ,e.ename ���, e.mgr �Ŵ�����ȣ ,m.ename �Ŵ����̸� 
from emp e,emp m where e.mgr=m.empno;

--5��

select *from student;
select *from department;

select name ,dname from student,department where student.deptno1=(select deptno1 from student where name='������') and department.deptno=student.deptno1;

select *from professor where (select hiredate from professor where name='�۵���')<hiredate;

select*from student where weight>(select avg(weight)from student where deptno1=101);

select*from professor;
select name, pay,hiredate from professor where hiredate=(select hiredate from professor where name='�ɽ�') and pay<(select pay from professor where name='������');

select*from dept2;

select empno,name,deptno from emp2 where deptno in (select dcode from dept2 where
area='��������');

select *from emp2;
select name,position,  to_char(pay,'999,999,999,999,999') from emp2 where pay<all (select pay from emp2 where position='����');

select name,grade,weight from student  where weight<all (   select weight from student where grade=4);

select *from student;
select grade �г� ,name �̸� , height "Ű" from student  where (grade,height) -- �л� �ֵ��߿� graden height�� �г⺰��,�ִ��������.
in (select grade,max(height) from student group by grade);

select *from professor;
select profno,name,deptno from professor where (deptno,hiredate) in(select deptno,max(hiredate) from professor group by deptno);
     
     
     select*from emp2;
     select name,position,pay from emp2 where (position,pay) in(select position,max(pay) from emp2 group by position) order by pay desc ;
     
     select *from emp2;
     select *from dept2;   --deptno�� dcode�� ����
     
     select dname,name,pay from emp2,dept2 where dept2.dcode=emp2.deptno  
                                                                and ( 
                                                                      emp2.pay<all( select  avg(pay) from emp2 group by deptno)                                                            
                                                                 --emp2.pay <all (  (deptno, pay) in(select deptno,avg(pay) from emp2 group by deptno ) )
                                                                                                                    
                                                                )  ;
                                                                


select name "����̸�",position "����",pay "�޿�" from emp2 a
            where pay>=(select avg(pay) from emp2 b where a.position=b.position);
                                                                