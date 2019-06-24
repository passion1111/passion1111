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
        