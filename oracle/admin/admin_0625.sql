--���̺� �����ϱ� -- 


select * from tab;

select * from emp;
select * from kim.emp;

select * from col where TABLE_NAME = 'help';
DESCRIBE kim.emp;

--grant select on ������.���̺�� to �ٸ� ����ڸ�; �ٸ� ����ڿ��� ������ �ټ��ִ��ڴ� �ý��۰�����  ������ �������ִ��ڰ� ����.
--�Ϲݻ���ڴ� �ڽ��� ������ �������ִ��ڸ� ����.
grant all on kim.emp to kang; --���̶�� ����� ���� kim�� emp�� ������ �����ϴ�.
select* from kim.emp;