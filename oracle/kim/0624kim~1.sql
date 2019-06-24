--���̺� ���� &���ڵ� ����--

SELECT* FROM EMP; --DEMPTNO 50���̻��� �Ұ�����.
SELECT*FROM DEPT;

--����>
create table ������tablename as  select �ʵ��,�ʵ�� from ���̺��̸�;

create table c_emp
    as select *from emp;
    select *from c_emp;  --���̺�ī�Ǵ� �ٺ���Ǵµ� ���������� ��������ʴ´�. 
    
    create table c_emp_20 as select*from emp where deptno=20; --���̺��� ���ǰ���.
    
    create table c_emp_30
    as select empno ��ȣ ,ename �̸�,job ����,sal �޿� from emp where deptno=30;
    select*from c_emp_30;
--    ����] ���� ���̺��� ���Ӱ��縸 �̾Ƽ� ���̺� �����ϱ�
    select*from professor;
    
    create table c_professor 
    as select *from professor where position='���Ӱ���';

    select*from c_professor;
--    ����2]emp���� ���̺��� mgr�Ŵ�����ȣ�� 7934���� ����� �����ؼ� ���ο� ���̺� �ۼ��ϱ�
    select *from emp;
    
    create table emp_7934 
    as select*from emp where mgr=7934;
    
--    ���ڵ� ���� �����⸸ �����ҋ� where 1=0�����ϸ� 
create table c_emp4 
as select *from emp where 1=0;

select*from c_emp4; --�������� ������

insert into c_emp4 select * from emp; --emp���̺���  c_emp4�� ����


create table c_emp3
    as select *from emp
        order by ename desc,sal desc,empno asc; --������ ���·� ����

create table c_emp5
    as select *from emp
        order by 1 desc,2 desc,3 asc; --�ʵ� ������ �ε� ����
        
select *from c_emp5;

select*from c_emp; --��ü����
select*from c_emp_20; --����(�μ���ȣ��20���� ���ڵ�)�� �°� ���̺�

create table c_emp_structure 
as select *from emp where 1=0;
select*from c_emp_structure; --�������� ����

--empno,ename,job,sal
create table three_column_emp
as select empno,ename,job,sal from emp;

select*from three_column_emp;

--unio  --pk ,fk  �ƴ� ���� ���̺� ��ġ��--
select*from emp       
union select *from c_emp; --�ߺ� ���ڵ� �����ϰ� ��ģ��.

insert into c_emp(empno,ename,deptno)values(303,'�谳��',40);

select*from emp
union all select *from c_emp; --�ߺ� ���ڵ� ����.

--�ʵ� ����,data type ��ġ���Ѿ���
--�� ���� varchar2Ÿ�� �Ǵ� intŸ���̸� �׳� ���ٴ� �ǹ�.
select empno,ename,job,sal from emp       
union select *from three_column_emp;

select empno,ename,job,mgr from emp       
union select *from three_column_emp;  --sal�ڸ��ε� mgr�����ϱ� ����. three_column_emp�� 3���� ���̺������ִµ� ������ �װ��� ���ϴ°� �ƴϿ��� Ÿ�Ը� �´� �ٸ� �÷���
--��µɼ��� �ִٴ� �ǹ�.
 -- c_emp_20,c_emp4 union ���?
 select empno,ename,job,sal from emp;
 
--����4]�����ȣ,�̸�,�޿� �׸��� 15%�λ�� �޿��� ������ ǥ���ϵ� �÷����� new Sallary�� �����Ͽ� ����Ͻÿ�.
 select empno,sal ,round((sal*1.5),0) as sallary from emp;
 
 select empno,ename,sal,cast(sal*1.5 as int) "new sallary" from emp;   --as int�� int������.
 
--�� ����� �̸��� ǥ���ϰ� �ٹ� �� ���� ����Ͽ� �÷����� Months works�� �����ϰ� �ٹ��޼��� �������� ������ ������� �����Ͽ� ����Ͻÿ�.


select ename,hiredate ,round(MONTHS_BETWEEN(SYSDATE,hiredate),0 ) as months_works from emp
order by months_works ;

--����6] ����� �̸��� Ŀ�̼��� ����ϵ� Ŀ�̼��� å������ ���� ����� Ŀ�̼��� 'no commission'���� ����ϼ���.
select *from emp;

select ename,cast(comm as varchar2(20)) from emp;

select ename,cast(comm as varchar2(20)) from emp where comm is null;

select ename ,nvl(cast(comm as varchar2(20)),'no commission') from emp;


--------------------------------------------------------------------------

insert into ���̺��̸� select �÷���,...from ���̺� �̸�;

insert into  c_emp_structure select * from emp ;
select*from emp;
--�� 1 emp ���̺��� �̸�,��� ,�Ի��� �ʵ常 ���� �������� ���� c_emp6 ���̺� ����
create table c_emp6 as select ename,empno,hiredate from emp where 1=0;
--�� select*from emp6���ٰ� emp2 ���̺��� ���ڵ� �����ϱ�;
select*from emp2;  --empno,name,birthday���ڵ� �����ϱ�

alter table c_emp6 modify empno number(10); --modify�� �޸���������.

insert into c_emp6 select name,empno,birthday from emp2;



