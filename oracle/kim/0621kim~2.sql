-------join---------------- pk i- fk �����ϋ� ���-------

--join - pk/fk   (o)

--union pk/fk  (x)

select* from dept;           

select*from emp;

--������ ��� �μ��ȿ� �����־���Ѵ�. 

select* from dept,emp;

select �÷���,...
from ���̺� �̸���Ī[inner] join ���̺� �̸� ��Ī
on ��Ī. �÷���=��Ī.�÷���;

select ename , job,sal, deptno, dname from emp inner join dept where emp.deptno=dept.deptno;  --where�� ���°� �ƴ϶� on���� ����ϰ� on���� ������ deptno�÷��� ��ġ�⋚����.
                                                                                --������ ���� ������� �մϴ�.

select ename , job,sal, emp.deptno, dname from emp inner join dept on emp.deptno=dept.deptno;  --on���� �ٲ�� emp.deptno�� emp�� �˼��ְ� ����.
--��Ī���� �����ϸ� ���� ��ĭ��� ��Ī


select ename , job,sal, d.deptno, dname from emp inner join dept d on emp.deptno=d.deptno;   --d�� ��Ī ����.

select ename, loc, job, sal ,d.deptno,dname from emp e inner join dept d on e.deptno=d.deptno;

select *from emp;
INSERT INTO emp VALUES(
  7935, 'kingsmile', 'MANAGER', 7777,
 to_date('1-5-1981','dd-mm-yyyy'),
 2850, null, 10);
 
 
--�ܷ�Ű�� ������ ����.


select ename, loc, job, sal ,d.deptno,dname from emp e inner join dept d on e.deptno=d.deptno;

--left outer join :  ���ʿ��ִ� ������ ���,�����ʿ� �ִ� ���̺��� ��ġ�ϴ� �����͸� ���
select ename, loc, job, sal ,d.deptno,dname 
--from emp e left join dept d  --����,�����ʿ� ������ ���̺��� ��Ī�� Ȯ��.
from dept d left join emp e
--on e.deptno=d.deptno;
on d.deptno=e.deptno;   --�ϳ��� �� ����. on�� ��ġ�ϴ� �����͸�.

insert into dept(deptno,loc) values(50, 'SEOUL');  --emp�� dept50�� ����. �׷��� �ٷ� �� �����ϸ� 
SELECT* FROM DEPT;


--right outer join: �����ʿ� �ִ� �����ʹ� ��� ���ʿ��ִµ����ʹ� ��ġ
select ename, loc, job, sal ,d.deptno,dname 

from dept d right join emp e

on d.deptno=e.deptno;   

inner join   ==
left outer join *=

left outer join =*

-- ���� ���̺�(3���̻�)�� �����ϴ¹��.
select �÷���, .....
from ���̺��̸�1 ��Ī 
outer left join ���̺��̸�2 ��Ī outer right join ���̺��̸�3 ��Ī
on ��Ī.�÷��� = ��Ī.�÷��� , on ��Ī.�÷���=��Ī.�÷���;

--��1 emp,dept inner join �ϱ�
select *from emp;
select *from dept;
��� �ʵ�� ����̸�(ename),�μ��̸�(deptno),��å(job),�Ŵ�����ȣ(mgr) ����
select  ename, emp.deptno, job ,mgr from emp inner join dept on emp.deptno=dept.deptno;