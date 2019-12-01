select * from test22;
create index idx_test22 on test22(numnum,numnum2,namename);
select /* index(idx_test22 testt2) */ * from test22 ;
select /* index_ffs(idx_test22 testt2) */ * from test22 ;

SELECT A.TABLE_NAME
     , A.INDEX_NAME
     , A.COLUMN_NAME
  FROM ALL_IND_COLUMNS A
 WHERE A.TABLE_NAME = 'test22'
 ORDER BY A.INDEX_NAME, A.COLUMN_POSITION;