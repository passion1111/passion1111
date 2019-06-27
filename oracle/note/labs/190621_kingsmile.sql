-- http://www.gurubee.net/lecture/1028
-- http://www.nextree.co.kr/p4327/
select *
  from reg_test;

select *
  from reg_test
  where REGEXP_LIKE (text, '([aeiou])\1', 'i')  -- ���ڿ�(�Ǵ� ���ڿ� ���� �ʵ��), ����, i : ��ҹ��ڱ��о��Կɼ�
  --order by text;
-- aabbcc123

select *
  from reg_test
  where REGEXP_LIKE(text, '[abc]' );  -- [ �� ] ���̿� �ִ� ���ڵ� �� �ϳ�

select *
  from reg_test
  where REGEXP_LIKE(text, '[abc|ABC]' );

select *
  from reg_test
  where REGEXP_LIKE(text, '[a-z][0-9]' );   -- �ҹ��� a~z ����

select *
  from reg_test
  where REGEXP_LIKE(text, '[A-Z][0-9]' );
  
select *
  from reg_test
  where REGEXP_LIKE(text, '[a-z] [0-9]' );   -- �ҹ��� a~z ���� ����
 
insert into reg_test values('ppyy');
insert into reg_test values('aa');
insert into reg_test values('AABBCC'); 
insert into reg_test values('789ABC');
insert into reg_test values('789 ABC');
insert into reg_test values('123kbs');
insert into reg_test values('mbc567');
insert into reg_test values('sbs 567');

-- �ҹ��ڳ� �����̳� ���ڰ� ���� �� 
     -- colou?r�� "color"�� "colour"
SELECT * FROM REG_TEST WHERE regexp_like(text, '[a-z]?[0-9]');
SELECT * FROM REG_TEST WHERE regexp_like(text, '[0-9]?[a-z]');
SELECT * FROM REG_TEST WHERE regexp_like(text, '[A-Z]*[0-9]');

-------------------------------------------------------------------------
--����  DECODE������ CASE�Լ��� ��ȯ�� ���̴�. 
select * from student;
SELECT deptno1, 
       CASE deptno1
         WHEN 101 THEN 'ACCOUNTING'
         WHEN 102 THEN 'RESEARCH'
         WHEN 103 THEN 'SALES'
         ELSE 'OPERATIONS'
       END as "Dept Name"
  FROM student;

----------------------------------------------
--�޿����� �λ���� �ٸ��� ����Ͽ���. 
select name, pay from professor;
SELECT name ,
       CASE
          WHEN pay < 250  THEN pay+(pay*0.8)
          WHEN pay BETWEEN 260 AND 320 THEN pay+(pay*0.5)
          WHEN pay BETWEEN 350 AND 450 THEN pay+(pay*0.3)
          ELSE pay+(pay*0.1)
       END pay
  FROM professor; 
  
-- ���� �λ���� �����ϴ� �����Ǹ� ������Ʈ �ϱ�
update professor set pay = 
       CASE
          WHEN pay < 250  THEN pay+(pay*0.8)
          WHEN pay BETWEEN 260 AND 320 THEN pay+(pay*0.5)
          WHEN pay BETWEEN 350 AND 450 THEN pay+(pay*0.3)
          ELSE pay+(pay*0.1)
       END ;
 
 select * from professor;
  
