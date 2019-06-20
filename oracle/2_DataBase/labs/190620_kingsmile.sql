-- �����Լ� ----
select round(12.45678935, 0), 
    round(12.45678935, 2),round(12.55678935, 0) from dual;
select ceil(12.34),ceil(-12.34) from dual; -- �ø� �� �� ���� ��ȯ
select floor(12.34),floor(-12.34) from dual; -- ���� �� �� ���� ��ȯ
select trunc(12.3456, 2), trunc(12.3756, 2),
        trunc(12.7456, 0) from dual;
------------------------------------------------  
-- ���ڿ��Լ� -----
select instr('abcd', 'b') from dual; -- 2
select instr('abcdfghijkboy', 'b', -1) from dual;  -- -1�̸� �ڿ������� ã�´�.
select instr('abcdfghijkboy234728473swe', 'b', -3) from dual;

select lpad('abcd', 20, '#') from dual;
select rpad('abcd', 20, '@') from dual;

select * from dept2;
select RPAD(dname, 10, '*') "RPAD����" from dept2;

select LENGTH('CANDIDE') from dual;
select LENGTHb('CANDIDE') from dual;

select dname, LENGTH(dname) from dept2;
select dname, LENGTH(dname), LENGTHb(dname) from dept2;

select substr('1234567890', 3) from dual;
select substr('1234567890', 3, 2) from dual;
select dname, substr(dname, 3) from dept2;
select dname, substr(dname, 2, 3) from dept2;

select RPAD(dname, 10, substr('1234567890', length(dname)+1)) "RPAD����" from dept2;

select lpad(dname, 10, '1234567890') "LPAD����"  from dept2;
select rpad(dname, 10, '1234567890') "RPAD����" from dept2;
select lpad(dname, 10, '1234567890'), rpad(dname, 10, '1234567890') "����" from dept2;        

select dname, length(dname) from dept2;
select dname, lengthb(dname) from dept2;

select * from student where deptno1 =103;
select name, rtrim(REGEXp_replace(name, '(.)', '\-1'),  '-') "������"
    from student
    where deptno1 = 103;

select name, rtrim(REGEXp_replace(birthday, '(/)', '\\'),  '-') "������"
    from student
    where deptno1 = 103;
   
select sysdate from dual; 
select to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') from dual;
select to_char(sysdate, 'YY-MM-DD HH:MI') from dual;
select to_char(sysdate , 'YYYY-MM-DD') from dual;
select to_char(sysdate , 'YYYY-MM-DD HH:MI:SS') from dual;
select to_char(sysdate , 'YYYY-MM-DD HH24:MI:SS') from dual;
 
-- Oracle SQL_PLSQL_PPT > 2, 3�� �ǽ�  
���� �Լ� ���� 1)
Student ���̺��� �����ؼ� �Ʒ� ȭ��� ���� 1 ������(deptno1 �÷�) 
101���� �л��� �̸��� ��ȭ��ȣ�� ������ȣ�� ����ϼ���. 
�� ������ȣ�� ���ڸ� ���;� �մϴ�.

select tel, instr(tel,')') 
    from student  -- index string
    where deptno1 = 101;

--substr(tel, ������ġ, ��������);
--substr(tel, ������ġ);

select name, tel, substr(tel, 1, instr(tel,')') -1) "������ȣ"
    from student
    where deptno1 =101;

���� �Լ� ���� 3)
Dept2 ���̺��� ����Ͽ� dname �� �������� ����� 
�������� ������ �ۼ��ϼ���.   -- ����Ŭ ������ ���� �ѱ� ���� �ٸ� 
select rpad(dname, 10,
        substr('1234567890', lengthb(dname)-2)) "RPAD����"
    from dept2;

select rpad(dname, 10,
        substr('1234567890', length(dname)+1)) "RPAD����"
    from dept2;
------------------------------------------------
select Months_between
  ( to_date('06-20-2019', 'MM-DD-YYYY') ,
    to_date('06-20-2018', 'MM-DD-YYYY')   )  "Months"
  from dual;

select Months_between
  ( to_date('07-31-2015', 'MM-DD-YYYY') ,
    to_date('12-20-1988', 'MM-DD-YYYY')   )  "Months"
  from dual;

select *
  from professor
  where name='�ɽ�';
  
select add_months(hiredate, 1)
  from professor
  where name='�ɽ�';
  
select to_char(add_months(hiredate, 1), 'DD-MM-YYYY' ) "Next month"
  from professor
  where name='�ɽ�';
  
select * from professor;
select * from emp2;

select to_char(
              add_months(birthday, 1), 'DD-MM-YYYY' ) "Next month"
  from emp2
  where name='������'
-------------------------------------------
select next_day('2019/06/20', 2) "Next Day" from dual;  -- 1 : �Ͽ���  2:������,....
select next_day('1988/01/20', 2) "Next Day" from dual;
select next_day('2019/06/20', 6) "Next Day" from dual;  -- 6 : �ݿ��� 
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

select * from products;

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
select * from products;
SELECT product_id,
       DECODE (category_id, 1, 'Southlake',
                             2, 'San Francisco',
                             3, 'New Jersey',
                             4, 'Seattle',
                                'Non domestic')
       "Location of inventory" FROM products
       WHERE product_id < 286;
       
SELECT * FROM inventories ;
select * from dept;

Student ���̺��� tel �÷��� ����Ͽ� �л��� �̸��� ��ȭ��ȣ, ��)�� ��
 ������ ��ġ�� ����ϼ���.;
 
 select * from student;

select name,instr(tel,')',1),tel from student;
select name,substr(tel,1,instr(tel,')',1)-1),tel from student;
substr(tel,1,instr(tel,')',1))

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

SELECT SUBSTR('�ѱ۳�', 1, 2) "Substring"  
     FROM DUAL;

SELECT SUBSTRb('�ѱ�', 1, 3) "Substring" 
     FROM DUAL;












        