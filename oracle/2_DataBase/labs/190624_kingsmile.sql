-- ���̺� ���� & ���ڵ� ����
select * from emp;
-- ����>
create table ����tableName
    as select �ʵ��, �ʵ��,....from ���̺��̸�;
-- ���������� ������� �ʴ´�.    
create table c_emp
    as select * from emp;

select * from c_emp;

create table c_emp_20
    as select * from emp where deptno=20;
    
select * from c_emp_30;

create table c_emp_30
    as select empno ��ȣ, ename �̸�, job ����, sal �޿� 
    from emp 
    where deptno=30;
    
--����1]���� ���̺��� ���Ӱ��縸 �̾Ƽ� ���̺� �����ϱ�
create table c_professor
    as select * from professor where position='���Ӱ���';

--����2]emp(����)���̺��� mgr(�Ŵ�����ȣ)�� 7566���� ����� �����ؼ�
--    ���ο� ���̺� �����ϱ�
create table c_emp_mgr
    as select *  from emp where mgr=7566;

select * from c_emp_mgr;   
select * from c_professor;

-- ����>
create table ����tableName
    as select �ʵ��, �ʵ��,....from ���̺��̸� where 1=0;

create table c_emp4
    as select * from emp where 1 = 0;

select * from c_emp4;
desc c_emp4;

create table c_emp3
    as select * from emp
    order by ename desc, sal desc, empno asc;
    
select * from emp
    order by ename desc, sal desc, empno asc; -- �ʵ������ ���İ���
�Ǵ�
select * from emp
    order by 2 desc, 6 desc, 1 asc;    -- �ʵ� ������ȣ�ε� ���� ����
------------------------------------------
--����>
insert into ���̺��̸�
    select �÷���, ... from ���̺��̸�

select * from c_emp; -- ��ü����
select * from c_emp_20; -- ����(�μ���ȣ�� 20���� ���ڵ�)�� �°� ���̺� ����
select * from c_emp4; -- �������� ����( ���ڵ� ���� ���� )
select * from c_emp2; -- empno, ename, job, sal ���ϴ� �ʵ常 ����
select * from c_emp_30;
create table c_emp2 
    as select empno, ename, job, sal from emp;
    
-- UNIO --pk - fk �ƴ� ���� ���̺� ��ġ�� -------------------
select * from emp
union   -- �ߺ� ���ڵ� �����ϰ� ��ģ��.
    select * from c_emp;

insert into c_emp(empno, ename, deptno) values(303, '�̵���', 40);

select * from emp
union all  -- �ߺ� ���ڵ� �����ϰ� ��ģ��.
    select * from c_emp;

select * from c_emp2;

select * from emp -- �ʵ� ����, data type ��ġ���Ѿ���
union 
    select * from c_emp2;

select empno, ename, job, sal from emp -- �ʵ� ����, data type ��ġ���Ѿ���
union 
    select * from c_emp2;

select empno, ename, job, sal from emp -- �ʵ� ����, data type ��ġ���Ѿ���
union 
    select * from c_emp2;
    
select empno, ename, job, hiredate from emp -- �ʵ� ����, data type ��ġ���Ѿ���
union 
    select * from c_emp2;
------------------------------------------------    
--����2] c_emp_20, c_emp4 union ���?
select * from c_emp_20
union
    select * from c_emp4;
    
--����4] �����ȣ, �̸�, �޿� �׸��� 15%�λ�� �޿��� ������ ǥ���ϵ�
--    �÷����� New Salary�� �����Ͽ� ����Ͻÿ�.
select empno, ename, sal, round((sal * 1.15),0) "New Salary"
    from emp;

select empno, ename, sal, Cast(sal * 1.15 as int) "New Salary"
    from emp;
    
--����5]�� ����� �̸��� ǥ���ϰ�, �ٹ� �� ���� ����Ͽ� �÷����� 
--     Months_Works�� �����ϰ�, �ٹ� �޼��� �������� ������ �������
--     �����Ͽ� ����Ͻÿ�.
select ename, hiredate, Months_between(sysdate, hiredate) as "Months_Works"
    from emp
    order by hiredate desc;  -- ������ ��Ī���δ� �ȵȴ�
    
select ename, hiredate, 
    round(Months_between(sysdate, hiredate),0) as "[Months_Works]"
    from emp
    order by hiredate desc;

����6]����� �̸��� Ŀ�̼��� ����ϵ�, Ŀ�̼��� å������ ���� 
    ����� Ŀ�̼��� 'no commission'���� ����Ͻÿ�.
select ename, Cast(comm as varchar2(20)) from emp;   

select ename, Cast(comm as varchar2(20)) from emp;  

select ename, Cast(comm as varchar2(20)) 
    from emp where comm is null;  
-- nvl �Լ� ����ؼ� �ٽ� ������ - �ڷ��� Ÿ�� ���ڿ��� �����ؼ� ������
select ename, nvl(to_char(comm),'no commission') as comm
    from emp;
    
select ename, nvl(Cast(comm as varchar2(20)), 'no commission') 
    from emp; 

desc emp; 
-------------------------------
--����>
insert into ���̺��̸�
    select �÷���, ... from ���̺��̸�;
    
select * from c_emp4;    

insert into c_emp4
    select * from emp;
����] emp ���̺��� �̸�, ���, �Ի��� �ʵ常 ���� �������� ����
     c_emp5 ���̺�� ����ÿ�
drop table c_emp5;
create table c_emp5
    as select ename, empno, hiredate from emp where 1=0;
select * from c_emp5;

����] c_emp5���̺��ٰ� emp2 ���̺��� ���ڵ� �����ϱ�
select * from emp2;���� empno, name, hirthday ���ڵ� �����ϱ�
insert into c_emp5
    select empno, name, birthday from emp2;

select * from emp2;
select * from emp;
desc emp2; -- NAME     NOT NULL VARCHAR2(15)
EMPNO    NOT NULL NUMBER       
NAME     NOT NULL VARCHAR2(15) 
BIRTHDAY          DATE         

desc emp;  -- NAME     NOT NULL VARCHAR2(15)
EMPNO       NOT NULL NUMBER(4)    
ENAME             VARCHAR2(10) 
HIREDATE          DATE         

drop table c_emp5;
create table c_emp5
    as select ename, empno, hiredate from emp where 1=0;
select * from c_emp5;
---------------------------------
insert into c_emp5
    select Cast(name varchar2(15)), empno, birthday from emp2;

insert into c_emp5
    select convert(name, varchar2(15)), empno, birthday from emp2;
    