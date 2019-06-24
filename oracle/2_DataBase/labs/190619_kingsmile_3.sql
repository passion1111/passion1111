-- ����(�׷�)�Լ� ---------------
select * from gift;
select sum(g_start), sum(g_end) from gift;
select sum(g_start) "���۰��հ�", sum(g_end) "�ִ밪�հ�" from gift;

select max(g_start), min(g_start), avg(g_end) from gift;

select count(*) from gift; -- null ����
select count(gname) from gift;
select count(gno) from gift; -- null ����
insert into gift(gname, g_end) values('û�ұ�', 3000);

SELECT RANK(600000) within GROUP(ORDER BY g_end desc)
    FROM gift;
select rank(600000) within group(order by g_end desc) 
  from gift
    where g_end is not null ; 
    
select * from student;
-- Ű�� 168�� ����� �� ��°�� ū�� Ȯ��
SELECT RANK(168) within GROUP(ORDER BY height desc)
    FROM student;
-- �����԰� 58�� ����� ���°���� ��� ���ϱ�?
SELECT RANK(58) within GROUP(ORDER BY weight desc)
    FROM student;
 
--����]g_end �� 200000, 600000 ���� ���� �� ��� (any �̿��ϼ���)
select * from gift where g_end < any(200000, 600000);
select * from gift where g_end < 600000;
  
--����]�л����� Ű�� �հ� ���, ���� Ű�� ū ģ��, ����ģ�� ����ϱ�
select sum(height) �հ�, avg(height), max(height), min(height)
    from student;
----------------------------------
SELECT * from student;
SELECT grade, sum(height), avg(height), max(height), min(height)
    from student; -- �׷�(����)�Լ��� �Ϲ��ʵ�� ���� ���� ����.

SELECT grade, sum(height), avg(height), max(height), min(height)
    from student
    group by grade;  -- �κ���(�Ұ�)

-- emp_type���� pay ��, ���, �ְ�޿�, ���ϱ޿� ���ϱ�
select * from emp2;
SELECT emp_type, sum(pay), avg(pay), max(pay), min(pay)
    from emp2
    group by emp_type;  -- �κ���(�Ұ�)    

-- ���� : where , having �� �̿��Ѵ�

SELECT grade, sum(height), avg(height), max(height), min(height)
    from student
    group by grade
    having avg(height) > 173; -- group by ������ ����ϴ� ���� having �� ���� ���

select deptno, round(avg(nvl(pay, 0)),0) "��ձ޿�"
    from professor
    group by deptno;

select deptno as "��   ��", round(avg(nvl(pay, 0)),2) "��ձ޿�"
    from professor
    group by deptno
    having avg(pay) > 400;

����] emp2 ���̺��� deptno(�μ�)���� pay �հ� ��� ���ϱ�
����] emp2 ���̺��� emp_type���� pay �հ� ��� ���ϱ�
����] emp2 ���̺��� ���޺�(position)���� �޿��� ��, ����� ���ϱ�
����] emp2 ���̺��� ���޺�(position)���� �޿��� ��, ����� ���ϴµ�,
      ������ ������ ����鸸 �����ּ���

select * from emp2;
    
    