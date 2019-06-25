-- kingsmile --- 
-- 다른 계정에 있는 테이블에 접근하기 -----------
select * from 소유자명.테이블명;  -- 권한이 있어야한다. 단, 최고권한자는 된다(sys, system)
select * from kingsmile.emp;

select * from "kang".tt;
delete from "kang".tt;  -- error : select 권한만 줬기때문에
commit;

-- 특정 테이블의 컬럼 확인 방법?
select * from kingsmile.tab;
   -- where table_name ='TSQ$' and column_name='BLOCKS';

-- PL/SQL ----------------------
