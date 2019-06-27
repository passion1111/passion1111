-- http://www.gurubee.net/lecture/1028
-- http://www.nextree.co.kr/p4327/
select *
  from reg_test;

select *
  from reg_test
  where REGEXP_LIKE (text, '([aeiou])\1', 'i')  -- 문자열(또는 문자열 포함 필드명), 패턴, i : 대소문자구분안함옵션
  --order by text;
-- aabbcc123

select *
  from reg_test
  where REGEXP_LIKE(text, '[abc]' );  -- [ 과 ] 사이에 있는 문자들 중 하나

select *
  from reg_test
  where REGEXP_LIKE(text, '[abc|ABC]' );

select *
  from reg_test
  where REGEXP_LIKE(text, '[a-z][0-9]' );   -- 소문자 a~z 숫자

select *
  from reg_test
  where REGEXP_LIKE(text, '[A-Z][0-9]' );
  
select *
  from reg_test
  where REGEXP_LIKE(text, '[a-z] [0-9]' );   -- 소문자 a~z 공백 숫자
 
insert into reg_test values('ppyy');
insert into reg_test values('aa');
insert into reg_test values('AABBCC'); 
insert into reg_test values('789ABC');
insert into reg_test values('789 ABC');
insert into reg_test values('123kbs');
insert into reg_test values('mbc567');
insert into reg_test values('sbs 567');

-- 소문자나 공백이나 숫자가 들어가는 것 
     -- colou?r는 "color"와 "colour"
SELECT * FROM REG_TEST WHERE regexp_like(text, '[a-z]?[0-9]');
SELECT * FROM REG_TEST WHERE regexp_like(text, '[0-9]?[a-z]');
SELECT * FROM REG_TEST WHERE regexp_like(text, '[A-Z]*[0-9]');

-------------------------------------------------------------------------
--위의  DECODE예제를 CASE함수로 변환한 예이다. 
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
--급여별로 인상률을 다르게 계산하였다. 
select name, pay from professor;
SELECT name ,
       CASE
          WHEN pay < 250  THEN pay+(pay*0.8)
          WHEN pay BETWEEN 260 AND 320 THEN pay+(pay*0.5)
          WHEN pay BETWEEN 350 AND 450 THEN pay+(pay*0.3)
          ELSE pay+(pay*0.1)
       END pay
  FROM professor; 
  
-- 적용 인상률이 적당하다 생각되면 업데이트 하기
update professor set pay = 
       CASE
          WHEN pay < 250  THEN pay+(pay*0.8)
          WHEN pay BETWEEN 260 AND 320 THEN pay+(pay*0.5)
          WHEN pay BETWEEN 350 AND 450 THEN pay+(pay*0.3)
          ELSE pay+(pay*0.1)
       END ;
 
 select * from professor;
  
