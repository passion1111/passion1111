-- Join ----pk - fk �����϶� ��� ----------------------
select * from dept;  -- 4 row
select * from emp;   -- 12 row
select * from dept, emp;

select �÷���, .....
from ���̺��̸���Ī[Inner] join ���̺��̸���Ī
on ��Ī.�÷���= ��Ī.�÷���;

select ename, job, sal, emp.deptno, dname
    from emp inner join dept
    on emp.deptno = dept.deptno;
    
select ename, loc, job, sal, d.deptno, dname
    from emp e inner join dept d
    on e.deptno = d.deptno;
    
INSERT INTO emp VALUES(
 0202, 'kingsmile', 'MANAGER', 7777,
 to_date('1-5-2012','dd-mm-yyyy'),
 2850, null, 20);
 
-- left outer join : ���ʿ� �ִ� ������ ���, ������ ��ġ�ϴ� �����͸�..
 select ename, loc, job, sal, d.deptno, dname
    from emp e left join dept d -- ����, �����ʿ� ������ ���̺��� ��Ī
    --from dept d left join emp e -- ����, �����ʿ� ������ ���̺��� ��Ī
    on e.deptno = d.deptno;
    --on d.deptno = e.deptno; 

insert into dept(deptno, loc) values(50, 'SEOUL');
select * from dept;

-- right outer join : �����ʿ� �ִ� ������ ���, ���� ��ġ�ϴ� �����͸�..
 select ename, loc, job, sal, d.deptno, dname
    --from emp e right join dept d -- ����, �����ʿ� ������ ���̺��� ��Ī
    from dept d left join emp e 
    --on e.deptno = d.deptno;
    on d.deptno = e.deptno; 

 inner join  =
 left outer join  *=
 right outer join  =*
 
 -- ���� ���̺�(3���̻�) ���� ���
 select �÷���, .....
    from ���̺��̸�1 ��Ī1 outer left join 
        ���̺��̸�2 ��Ī1 outer right join ���̺��̸�3 ��Ī3
    on ��Ī1.�÷���= ��Ī2.�÷���,
    on ��Ī2.�÷���= ��Ī3.�÷���
 
����] emp, dept inner join �ϱ� 
 ��� �ʵ�� ����̸�, �μ��̸�, ��å, �Ŵ�����ȣ ����
 

