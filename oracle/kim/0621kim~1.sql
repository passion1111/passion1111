--http:gurubee.net
--

select *
  from reg_test;

select *
  from reg_test
  where REGEXP_LIKE (text, '([aeiou])\1', 'i')  -- ���ڿ�(�Ǵ� ���ڿ� ���� �ʵ��), ����, i : ��ҹ��ڱ��о��Կɼ�
  order by text;

select *
  from reg_test
  where REGEXP_LIKE(text, '[abc]' );  -- [ �� ] ���̿� �ִ� ���ڵ� �� �ϳ�

select *
  from reg_test
  where REGEXP_LIKE(text, '[a-z][0-9]' );   -- �ҹ��� a~z ����

select *
  from reg_test
  where REGEXP_LIKE(text, '[a-z] [0-9]' );   -- �ҹ��� a~z ���� ����
  
insert into reg_test values('789AaaBC');
insert into reg_test values('789 ABC');
insert into reg_test values('123ks');
insert into reg_test values('mbc567');
insert into reg_test values('sbs 567');

-- �ҹ��ڳ� �����̳� ���ڰ� ���� �� 
SELECT * FROM REG_TEST WHERE regexp_like(text, '[a-z]?[0-9]');  --a-z�� �ȳ����ų� �ѹ��̻� ���;��Ѵ�. 
SELECT * FROM REG_TEST WHERE regexp_like(text, '[0-9]?[a-z]');  --a-z
SELECT * FROM REG_TEST WHERE regexp_like(text, '[A-Z]*[0-9]');

-------------------------------------------------------------------------
--����  DECODE������ CASE�Լ��� ��ȯ�� ���̴�. 
SELECT deptno, 
       CASE deptno
         WHEN 10 THEN 'ACCOUNTING'
         WHEN 20 THEN 'RESEARCH'
         WHEN 30 THEN 'SALES'
         ELSE 'OPERATIONS'
       END as "Dept Name"
  FROM dept;

----------------------------------------------
--�޿����� �λ���� �ٸ��� ����Ͽ���. 
select * from emp;
SELECT ename ,
       CASE
          WHEN sal < 1000  THEN sal+(sal*0.8)
          WHEN sal BETWEEN 1000 AND 2000 THEN sal+(sal*0.5)
          WHEN sal BETWEEN 2001 AND 3000 THEN sal+(sal*0.3)
          ELSE sal+(sal*0.1)
       END sal
  FROM emp; 


select name,
        case
                when pay<250 then pay+(pay*0.8)
                when pay between 260 and 320 then pay+(pay*0.5)
                when pay between 350 and 450 then pay+(pay*0.3)
                else pay+(pay*0.1)
                end pay
                from professor;

update professor set pay=
         case
                when pay<250 then pay+(pay*0.8)
                when pay between 260 and 320 then pay+(pay*0.5)
                when pay between 350 and 450 then pay+(pay*0.3)
                else pay+(pay*0.1)
                end ;  --where�� ������ ���ǿ� �´°͸� ��� �����Կ�.
    select *from professor;
    
    
    
    
    
    
    
    
    
    
    --���̺� �߰� ����.
    
    CREATE TABLE dept(
  deptno NUMBER(2,0),
  dname  VARCHAR2(14),
  loc    VARCHAR2(13),
  CONSTRAINT pk_dept PRIMARY KEY (deptno)); --deptno�� 
  
  
 CREATE TABLE emp(
  empno    NUMBER(4,0),          --pk
  ename    VARCHAR2(10),
  job      VARCHAR2(9),
  mgr      NUMBER(4,0),
  hiredate DATE,
  sal      NUMBER(7,2),
  comm     NUMBER(7,2),
  deptno   NUMBER(2,0),            --fk
  CONSTRAINT pk_emp PRIMARY KEY (empno),
  CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES dept (deptno)
);


INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO dept VALUES(40, 'OPERATIONS', 'BOSTON');

INSERT INTO emp VALUES(
 7839, 'KING', 'PRESIDENT', null,
 to_date('17-11-1981','dd-mm-yyyy'),
 5000, null, 10 );

INSERT INTO emp VALUES(
 7698, 'BLAKE', 'MANAGER', 7839,
 to_date('1-5-1981','dd-mm-yyyy'),
 2850, null, 30);

INSERT INTO emp VALUES(
 7782, 'CLARK', 'MANAGER', 7839,
 to_date('9-6-1981','dd-mm-yyyy'),
 2450, null, 10);

INSERT INTO emp VALUES(
 7566, 'JONES', 'MANAGER', 7839,
 to_date('2-4-1981','dd-mm-yyyy'),
 2975, null, 20);

INSERT INTO emp VALUES(
 7788, 'SCOTT', 'ANALYST', 7566,
 to_date('13-JUL-87','dd-mm-rr') - 85,
 3000, null, 20);

INSERT INTO emp VALUES(
 7902, 'FORD', 'ANALYST', 7566,
 to_date('3-12-1981','dd-mm-yyyy'),
 3000, null, 20 );

INSERT INTO emp VALUES(
 7369, 'SMITH', 'CLERK', 7902,
 to_date('17-12-1980','dd-mm-yyyy'),
 800, null, 20 );

INSERT INTO emp VALUES(
 7499, 'ALLEN', 'SALESMAN', 7698,
 to_date('20-2-1981','dd-mm-yyyy'),
 1600, 300, 30);

INSERT INTO emp VALUES(
 7521, 'WARD', 'SALESMAN', 7698,
 to_date('22-2-1981','dd-mm-yyyy'),
 1250, 500, 30 );

INSERT INTO emp VALUES(
 7654, 'MARTIN', 'SALESMAN', 7698,
 to_date('28-9-1981','dd-mm-yyyy'),
 1250, 1400, 30 );

INSERT INTO emp VALUES(
 7844, 'TURNER', 'SALESMAN', 7698,
 to_date('8-9-1981','dd-mm-yyyy'),
 1500, 0, 30);

INSERT INTO emp VALUES(
 7876, 'ADAMS', 'CLERK', 7788,
 to_date('13-JUL-87', 'dd-mm-rr') - 51,
 1100, null, 20 );

INSERT INTO emp VALUES(
 7900, 'JAMES', 'CLERK', 7698,
 to_date('3-12-1981','dd-mm-yyyy'),
 950, null, 30 );

INSERT INTO emp VALUES(
 7934, 'MILLER', 'CLERK', 7782,
 to_date('23-1-1982','dd-mm-yyyy'),
 1300, null, 10 );

-----------------------------------------------------
select *from emp;
select * from dept;