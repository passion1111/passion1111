--���� �Լ� ---
round
ceil�Ǽ��� ������ȯ. �ø� �� �� ������ȯ
floor ���� ���� ���� ��ȯ
mod(����,������) ������
trunc(����,�ڸ���) ����.

select round(12.23423432452342342,0),round(12.25423432452342342,1) from dual;  --ù���� round�� �ݿø��ҷ����ص� �ȵư� �ι��� round�� �ݿø�����.

select ceil(12.34), ceil(-13.94) from dual;  --12.34�� �ø��� 13, -13.93�� �ø��� -13
select floor(12.34),floor(-12.34) from dual; --�������� ��� �׷��� 12, -13��µ�.

select trunc(12.3456,2),trunc(-12.35,1),trunc(12.7456,0) from dual;  --�¤�¥���� 5�ε��� �ұ��ϰ� �׳� �߶����.

--���ڿ� �Լ�--

select instr('abcd','b') from dual; --�����ͺ��̽��� 0������ �ƴ� 1��������. ���� 2

select instr('abcd������dbwq','b',-1) from dual;  --index��ȣ������ -1�̸� �ڿ������� ã�´� �� �� ���������.ù�������� �� 9

select instr('abcd������dbwq������������������','b',-3) from dual;    --9

select lpad('abcd',20,'#') from dual; --abcd�� 20�ڸ��� ����µ� �� ������ #���� ���ʿ� ä����.
select rpad('abcd',20,'#') from dual; --�����ʿ������� ä����

select *from dept2;

SELECT rpad(dname,10,substr('123456',length(dname)+-2)) From dept2;  --pptx�� �ִ±״���ϴ¹��.

SELECT rpad(dname,10,substr('123456',length(dname)+1)) From dept2;

SELECT dname, substr(dname,2,3) from dept2;

select length('candide') from dept2;
select length(dname) from dept2; --dname�� ���̸� �˼�����.

select lpad(dname,10,'1234567890')"lpad����" from dept2;
select rpad(dname,10,'1234567890') "rpad����" from dept2;

select dname,length(dname) from dept2;  --�����ϳ��� �����ϳ��� lengthb�� ����Ʈ�� �ɰ�����.

select name from student; 
select name, rtrim(REGEXp_replace(name,'(.)','\-1' )  ,'-'  )  from student where deptno1=103;          --���ӿ��� .�� ������ \-1

select sysdate from dual;   --���ڸ� �̾ƿ�.
select to_char(sysdate, 'YYYY-MM-DD HH:MI:SS') FROM DUAL;    --�⵵ �� �� �ð� �� ��

select to_char(sysdate , 'YYYY-MM-DD')  from dual;
select to_char(sysdate , 'YYYY-MM-DD HH:MI:SS') from dual;   --�ִ�12�ð�����
select to_char(sysdate , 'YYYY-MM-DD HH24:MI:SS') from dual;     --24�ð�����

select *from professor;
select concat(name,position) from professor;


select substr('abcdef',-2,4) from dual; --�������� ����� ù���ں��ͽ��������ʰ� �׳� ��
select *from student;
select substr(tel,1,4) from student;

select substr(tel,1, instr(tel,')',1,1)-1 ) from student;

select *from dept2;
select lpad( dname , 10 , '12345' )  from dept2;
select rpad(dname, 10,substr('567890',length(dname))) from dept2;

select ltrim(dname,'��') from dept2; --���̶�� ���ʿ��� �����ϴ� ���ڸ� ����

select rtrim(dname,'��') from dept2;  --�̷������ ù���ڿ� ������ ���ڸ� ����.

--replace
select *from student;
select replace(name,substr(name,1,1),'#') from student;  --replace�Ѵ� name��   substr ������ ù�������� ù�������ڱ��� #���� ex)���� substr name,1,2,'#' -> (##��) xx, (#)�� o

select replace(name,substr(name,2,1),'#') from student;

select name, replace(jumin,substr(jumin,7,13),'#') from student;

select name, replace(jumin,substr(jumin,7,13),'#######') from student;

select replace(tel,
substr(tel,instr(tel, ')' ,1,1 )+1,
3)
,'###') from student;

--sub str(tel,������ġ,��������);
--substr(tel,������ġ);

select name,tel,substr(tel,1, instr(tel,')')-1) from student;





-------------------------------------------------
select Months_between            --��� ���� ������ ������ִ°�.
  ( to_date('02-17-2017', 'MM-DD-YYYY') ,
    to_date('01-01-2016', 'MM-DD-YYYY')   )  "Months"
  from dual;

select Months_between
  ( to_date('07-31-2015', 'MM-DD-YYYY') ,
    to_date('12-20-1988', 'MM-DD-YYYY')   )  "Months"
  from dual;


select* from professor where name='�ɽ�';

select add_months(hiredate,1 )   --�Ի�������� 1����������
  from professor
  where name='�ɽ�';

select to_char(add_months(hiredate, 1), 'DD-MM-YYYY' ) "Next month"  --�Ի����+1�� �������� ���.
  from professor
  where name='�ɽ�';
  
  
  

select * from professor;
select * from emp2;

select to_char(
              add_months(birthday, 1), 'DD-MM-YYYY' ) "Next month"
  from emp2
  where name='������';
-------------------------------------------
select next_day('2019/06/20', 2) "Next Day" from dual;  -- 1 : �Ͽ���  2:������,....
select next_day('1988/01/20', 2) "Next Day" from dual;
select next_day('2019/06/20', 6) "Next Day" from dual;  -- 6 : �ݿ���   �ش��ϴ����� ����
-------------------------------------------------------
select sysdate, --���ó���
    Last_day(sysdate) "Last",   --�ش��ϴ� ���� ������ ��
    Last_day(sysdate) - sysdate "Days Left" --���� ����
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

SELECT SUBSTR('�ѱ۳�', 1, 2) "Substring"  
     FROM DUAL;

SELECT SUBSTRb('�ѱ�', 1, 3) "Substring" 
     FROM DUAL;


