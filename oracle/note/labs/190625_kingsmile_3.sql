-- kingsmile --- 
-- �ٸ� ������ �ִ� ���̺� �����ϱ� -----------
select * from �����ڸ�.���̺��;  -- ������ �־���Ѵ�. ��, �ְ�����ڴ� �ȴ�(sys, system)
select * from kingsmile.emp;

select * from "kang".tt;
delete from "kang".tt;  -- error : select ���Ѹ� ��⶧����
commit;

-- Ư�� ���̺��� �÷� Ȯ�� ���?
select * from kingsmile.tab;
   -- where table_name ='TSQ$' and column_name='BLOCKS';

select * from USER_TABLES
    where table_name = 'KINGSMILE.EMP';

SELECT * FROM COLS WHERE TABLE_NAME = 'EMP2';
SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'EMP2';
SELECT * FROM USER_TAB_COLUMNS;

-- PL/SQL ----------------------
