--����(�׷�)�Լ�

select *from gift;

select sum(g_start) ,sum(g_end) from gift;
select sum(g_start) "���۰��հ�" ,sum(g_end) "�ִ� �հ�" from gift;            --��Ī��������
select max(g_start) "�ƽ���", min(g_end) "�ּڰ�" ,avg(g_end)"���" from gift;

select count(*) from gift; --null�� �ֵ� ���� ���� �������.
select count(gname) from gift; --��ü������ �ʵ� �����ϸ� null�� ������.
insert into gift(gname,g_end) VALUES('û�ұ�',3000);

--rank���ϱ� 
select rank(6000) within group(order by g_end desc) from gift;--�ΰ��� ���� ũ������ ��ġ�ǰ� �״������� ī���õǴ°Ű��� ����2���� 3����ͽ���.

select*from student;
--,Ű�� 168�� ����� ���°�� ū�� Ȯ��
select count(height) from student;
select rank(168) within group(order by height desc)from student;
--�����԰� 58�� ����� ��ŷ�� ��ԵǴ���
select rank(58) within group(order by weight desc)from student;   --(asc)�ڿ�������  desc1������Ͱ��.   

--��1 g_end�� 2000000,600000���� ������ ��� any �̿��ϼ��� gift
select*from gift;
select *from gift where g_end<any(200000,600000) ;--any �ִ� any�� �� �������� ���Խ�Ű�°��̶�� �����ϸ��.
--��2 �л����� Ű�� �հ� ��� ���� Ű�� ū ģ�� ����ģ�� ����ϱ�

select sum(height),avg(height),max(height),min(height)from student;

---------------------------------------------------------��
select *from student;
select grade, sum(height),avg(height),max(height),min(height) from student --�׷��ʵ�� �Ϲ��ʵ�� ���� ������ ���� grade����� �����ȶ� grade ��������� group by�� �׷�ȭ���Ѿ���.
 group by grade; --�κ��� (�Ұ�)
 
 select grade, sum(height),avg(height),max(height),min(height) from student --�׷��ʵ�� �Ϲ��ʵ�� ���� ������ ���� grade����� �����ȶ� grade ��������� group by�� �׷�ȭ���Ѿ���.
 group by grade having grade>2;--avg(height)>173;

--����:where ,having �� �̿��Ѵ�. group by�� �������� having���� �����  

select *from emp2;
select position, trunc(avg(pay),3) ,sum(pay),max(pay),min(pay) from emp2 group by position; --avg �Ҽ����� �ʹ��� trunc�Լ��� 3�ڸ����ڿ��� ������.

select deptno as"�� ��", trunc(avg(nvl(pay,0)),1) "��ձ޿�" from professor group by deptno having avg(pay)>400;  --round�� �߶󵵵� round �ø� trunc ����

--����1 emp2���̺��� delptno(�μ�)���� pay �հ� ��� ���ϱ�
select deptno as "�μ�",sum(pay),avg(pay) from emp2 group by deptno;

--��2 emp2 ���̺��� ���޺� ���� �޿��� �� ����� ���ϴµ� ������ ������ ����鸸 �����ּ���.
select position as"����",sum(pay),avg(pay) from emp2 group by position having position='����';