
select *from emp;
select deptno,avg(sal) from emp group by deptno having 2000>avg(sal); 



--������ �ѱ޿��� ���� �� ���̺��� ����� ������ manager�� ������� �����ϰ� �ѱ޿���
--3000�̻��� ����� ����Ͻÿ�              <>�ε�ȣ ���ֺ��°͵� ����

create view v_emp5
as select job,sum(sal) "�ѱ޿�" from emp
where  job<> 'manager'             --!=��� <>���� ��
group by job
having sum(sal)>3000;

select*from emp where ename='KING';
--�������� ��ҹ��� ���� �������� ���ڵ�� ��ҹ��� ����
select*from emp where ename='king'; --�ȳ���

--�������̺��� ���̺� ������ ����� c_professor ���ο����̺����(�̸�,���� �Ի���,�̸���,Ȩ������)�ϰ� ���ڵ庹���ϱ�
select* from professor;
create table c_professor(name,position,hiredate,email,hpage) as select name,position,hiredate,email,hpage from professor where 1=0;
--c_emp2 ���̺��� �������� ���� c_emp22�� ���弼��
create table c_emp2 as select * from emp2 where 1=0;

--emp ���̺��� c_emp22�� ������ 'manager'�� �������� ���ڵ� �����Ͻÿ� 

select *from emp;
create table c_emp22 as select *from emp where job='MANAGER';
select* from c_emp22;

--���ڵ� ���� insert into ���̺� ���� create





















--- View -------------------
create view ���̸�
as
    ���� ����;
    
create or replace view ���̸�
as
    ���ǳ���;
    
select * from professor;
select * from emp;
-------------------------------------------
create view v_emp
as
    select empno, ename, deptno from emp;
-----------------------------------------
select * from v_emp;

-- emp ���̺� �����ϸ� v_emp ?  o
-- v_emp ���̺� �����ϸ� emp ?  x
����1] 30�� �μ� ������� ����, �̸�, ������ ���� view ���̺� �����(emp)
drop view v_emp30;

create view v_emp30
as 
    select job, ename, sal
        from emp
        where deptno=30;

select * from v_emp30;

����2] 30�� �μ� ������� ����, �̸�, ������ ���� 
       view ���̺� �����(emp), �÷����� ����, ����̸�, ��������
       Alias�� �ְ� ������ 2000���� ���� ����鸸 �����ؼ� �� �����

select * from emp;
drop view v_emp30_2;
create view v_emp30_2
as 
    select job "����", ename "����̸�", sal "����"
        from emp
        where sal > 2000 and deptno = 30;
    
select * from v_emp30_2;
-------------------------------
����3] �μ���(�κ���==�Ұ�) �ִ�޿�, �ּұ޿�, ��ձ޿��� ���� �� �����
create view v_emp3
as
    select deptno "�μ�" ,max(sal) "�ִ�޿�",
            min(sal) "�ּұ޿�", round(avg(sal), 3) "��ձ޿�"
        from emp
        group by deptno;
        
select * from v_emp3;
----------------------------
����4] �μ��� ��ձ޿��� ���� �並 �����, ��ձ޿��� 2000 �̻���
      �μ��� ����ϵ��� �Ͻÿ�.
SELECT * FROM emp;

CREATE VIEW v_emp4 
AS
 SELECT deptno, ROUND(AVG(sal),3) "�μ����"
 		FROM emp
 		GROUP BY deptno
 		HAVING AVG(sal) > 2000 ;

 SELECT * FROM v_emp4;
 
����5] ������ �ѱ޿��� ���� �� ���̺� �����, ����(job)�� manager��
      ������� �����ϰ� �ѱ޿��� 3000�̻��� ����� ����Ͻÿ�.
CREATE VIEW v_emp5 
 AS
    SELECT job, SUM(sal) "�ѱ޿�"
  	  FROM emp
        WHERE job <> 'MANAGER' -- WHERE job != 'MANAGER'
        GROUP BY job
        HAVING SUM(sal) > 3000 ;
        
        
 SELECT * FROM v_emp5;     

--------------------------------------
CREATE VIEW v_emp6 
 AS
    SELECT job, SUM(sal) "�ѱ޿�"
  	  FROM emp
        WHERE job <> 'CLERK' -- WHERE job != 'MANAGER'
        GROUP BY job
        HAVING SUM(sal) > 3000 ;

select * from emp where ename='KING';
-- �������� ��ҹ��� ���� ��������, ���ڵ�� ��ҹ��� �����Ѵ�.
select * from emp where ename='king';
-----------------------------------------------------
����7] ���� ���̺��� ���̺� ������ ����� c_professor ���ο� ���̺� 
     ����(�̸�, ����, �Ի���, �̸���, Ȩ������)�ϰ� ���ڵ� ���� �ϱ�
--------------------------------------------------------
drop table c_professor;
create table c_professor
as
  select name, position, hiredate, email, hpage 
    from professor where 1=0 ;  --���ǿ� �������� �ʴ� ���� ����
 ------------------------------------------------------ 
select * from c_professor;
----------------------------------------------------
insert into c_professor 
  select name, position, hiredate, email, hpage from professor;
------------------------------------------------------
����8] c_emp22 ���̺��� �������� ���� c_emp22�� ���弼��
select * from c_emp22;
drop table c_emp22;

create table c_emp22
 as
  select empno, ename, job, sal from emp where 1=0;
  
select * from c_emp22;

------------------------------------------------------
����9] emp ���̺��� c_emp22�� ������ 'manager'�� 
      ����鸸 ���ڵ� �����Ͻÿ�.
      
 insert into c_emp22
  select empno, ename, job, sal from emp where job='MANAGER';
  
 insert into c_emp22
  select * from emp where job='MANAGER';

select * from c_emp22;
      
----------------------------------------------      
      
      