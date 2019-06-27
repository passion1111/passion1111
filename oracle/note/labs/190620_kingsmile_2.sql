select * from gift;
select sum(g_start) "���۰��հ�", sum(g_end) as "�ִ밪�հ�" from gift;

select max(g_start), min(g_start) , avg(g_end)
  from gift;
  
select count(*) from gift;  -- null ����
select count(gname) from gift;   -- null ����

select rank(600000) within group(order by g_end desc) from gift;

select rank(600000) within group(order by g_end desc) 
  from gift
    where g_end is not null ;  
    
--����] g_end �� 200000, 600000 ���� ���� �� ��� (any �̿��ϼ���)
 --select * from gift where g_end >= 200000 and g_end <= 600000 ;
 select * from gift where g_end < any(200000, 600000) ;
 cf)  select * from gift where g_end > any(200000, 600000) ;

select * from student;
--����] �л����� Ű�� �հ� ���, ���� Ű�� ū ģ��, ����ģ�� ����ϱ�
 select sum(height) �հ�, avg(height), max(height) , min(height) from student;
---------------------------------------------------------  ���⼭���� ������~~
select sum(height) �հ�, avg(height), max(height) , min(height) 
  from student   -- ��ü�� ����....
  --where ������
  group by grade ;  -- �κ���(�Ұ�) 

select grade, sum(height) �հ�, avg(height), max(height) , min(height) 
  from student   -- ��ü�� ����....  ,  �׷�(����)�Լ��� �Ϲ��ʵ�� ���� ����� �� ����.
  --where ������
  group by grade ;  -- �κ���(�Ұ�) 
--------------------------------------------
-- ���� : where , having �� �̿��Ѵ�.
select grade, max(height) , min(height) , avg(height)
  from student   -- ��ü�� ����....  ,  �׷�(����)�Լ��� �Ϲ��ʵ�� ���� ����� �� ����.
  group by grade   -- �κ���(�Ұ�) 
  having avg(height) > 173 ;  -- group by ������ ����ϴ°��� having�� ����

select deptno, avg(nvl(pay, 0)) "��ձ޿�"
  from professor
  group by deptno;
  
select deptno as "��   ��", avg(nvl(pay, 0)) "��ձ޿�"
  from professor
  group by deptno;  


select deptno as "��   ��", avg(nvl(pay, 0)) "��ձ޿�"
  from professor
  group by deptno
  having avg(pay) > 450 ;  -- group by ���� ���� ��� ������ having ���� ����Ѵ�.
 -----------------------------------------------------------------------  
--����7] emp2 ���̺��� deptno(�μ���)�� pay  �հ� ����� ���Ͻÿ�
  select deptno, sum(pay), avg(pay) from emp2 group by deptno;
  
--����8] emp2 ���̺��� emp_type ���� pay �հ� ����� ���Ͻÿ�
 select emp_type, sum(pay), avg(pay) from emp2 group by emp_type;

--����9] emp2 ���̺��� emp_type ���� �ְ� �޿�, ���� �޿� ���Ͻÿ�.
 
--����10] emp2 ���̺��� ���޺�(position)�� �޿��� ���� ���ϰ�, �޿� ����� ���Ͻÿ�.

select round(12.45678935, 0), round(12.45678935, 2) , round(12.55678935, 0)  from dual;

select ceil(12.34), ceil(-12.34) from dual;  -- �ø� �� �� ���� ��ȯ

select floor(12.34), floor(-12.34) from dual;  -- ���� �� �� ���� ��ȯ

select trunc(12.3456, 2), trunc(12.3756, 2),  trunc(12.3756, 0),  trunc(12.7756, 0) from dual; 
--------------------------------------------------------------------

select instr('abcd', 'b') from dual;  -- 2
select instr('abcdfghijkbop', 'b', -1 ) from dual;    -- -1�̸� �ڿ������� ã�´�...
select instr('abcdfghijkbopgjkjtertw9494 b993', 'b', -3 ) from dual;

select lpad('abcd' , 20, '#') from dual;
select rpad('abcd' , 20, '@') from dual;

select * from dept2;
select RPAD(dname, 10, '*' ) "RPAD����" from dept2 ;
select RPAD(dname, 10, substr('1234567890', length(dname)+1) ) "RPAD����" from dept2 ;

select lpad(dname, 10, '1234567890') "LPAD����" from dept2;
select rpad(dname, 10, '1234567890') "RPAD����" from dept2;

select dname,  length(dname) from dept2;

select * from student;

select name, rtrim(regexp_replace(name, '(.)', '\-1' ), '-' ) "������" 
    from student
    where deptno1 = 103; 

select to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') from dual;
select sysdate from dual;

-- Oracle SQL_PLSQL_PPT > 2, 3�� �ǽ� 
-----------------------------------------------------------------
select Months_between
  ( to_date('02-17-2017', 'MM-DD-YYYY') ,
    to_date('01-01-2016', 'MM-DD-YYYY')   )  "Months"
  from dual;

select Months_between
  ( to_date('07-31-2015', 'MM-DD-YYYY') ,
    to_date('12-20-1988', 'MM-DD-YYYY')   )  "Months"
  from dual;

select to_char(add_months(hiredate, 1), 'DD-MM-YYYY' ) "Next month"
  from professor
  where name='�ɽ�'
  
select * from professor;
select * from emp2;

select to_char(
              add_months(birthday, 1), 'DD-MM-YYYY' ) "Next month"
  from emp2
  where name='������'
-------------------------------------------
select next_day('2001/01/20', 2) "Next Day" from dual;  -- 1 : �Ͽ���  2:������,....
select next_day('1988/01/20', 2) "Next Day" from dual;
select next_day('2017/02/03', 6) "Next Day" from dual;  -- 6 : �ݿ��� 
-------------------------------------------------------
select sysdate,
    Last_day(sysdate) "Last",
    Last_day(sysdate) - sysdate "Days Left"
    from dual ;
----------------------------------------------------------
select birthday,
    Last_Day(birthday) "Days Left"
    from emp2;
-----------------------------------------------
select * from department;
select * from tab;
select * from product;

select p_code, 
          DECODE( p_code ,  100 , 'NEW YORK' ,
                                   101 , 'DALLAS' ,
                                   102 , 'BOSTON' ,
                                   105 , 'CHICAGO' ,
                                          '������ �����' )
          "Location of inventory"
      from product 
      where p_code < 103 ;

-------------------------------------------------------------------------------
SELECT product_id,
       DECODE (warehouse_id, 1, 'Southlake',
                             2, 'San Francisco',
                             3, 'New Jersey',
                             4, 'Seattle',
                                'Non domestic')
       "Location of inventory" FROM inventories
       WHERE product_id < 1775;
       
SELECT * FROM inventories ;
select * from dept;

SELECT deptno, DECODE(deptno, 10 , 'ACCOUNTING' ,
                              20 , 'RESEARCH' ,
                              30 , 'SALES', 'OPERATIONS') name
  FROM dept;
 
-- 10�μ��� �޿��հ踦, 20�μ��� �ִ밪��, 30�μ��� �ּҰ��� ����ϴ� ����
select * from emp order by deptno;
SELECT deptno, DECODE(deptno, 10 , SUM(sal),   --8750
                              20 , MAX(sal),    --3000
                              30 , MIN(sal)) sal  --950
  FROM emp
 GROUP BY deptno; 
 
 -- �μ����� �޿� �հ踦 ����Ѵ�. 
SELECT deptno, NVL(SUM(DECODE(deptno, 10, sal)),0) deptno10, 
               NVL(SUM(DECODE(deptno, 20, sal)),0) deptno20,
               NVL(SUM(DECODE(deptno, 30, sal)),0) deptno30,
               NVL(SUM(DECODE(deptno, 40, sal)),0) deptno40
  FROM emp
 GROUP BY deptno; 
-------------------------------------------------------------

SUBSTR(��ABC��,1,2) -> AB

SELECT SUBSTR('ABC', 1 , 2) FROM dual;

SELECT SUBSTR('ABCDEFG',3,4) "Substring"
     FROM DUAL;

SELECT SUBSTR('ABCDEFG',-5,4) "Substring"
     FROM DUAL;

SELECT SUBSTRB('ABCDEFGipo', 5, 4.2 ) "Substring with bytes"
     FROM DUAL;

SELECT SUBSTRB('ABCDEFGipo', 5, 4.6 ) "Substring with bytes"
     FROM DUAL;

SELECT SUBSTR('�ѱ۳�', 1, 2) "Substring"  
     FROM DUAL;
-- ����Ŭ ������ ���� �ѱ� ũ�� �ٸ���.
-- �ͽ������� ������ �ѱ� �ѱ��ڰ� 3����Ʈ��
SELECT SUBSTRb('�ѱ�', 1, 3) "Substring" 
     FROM DUAL;



