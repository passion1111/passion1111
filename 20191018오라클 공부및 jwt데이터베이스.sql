CREATE TABLE tbl_account_data (
  ta_idx number(10) NOT NULL ,
  ta_id varchar2(60) ,
  ta_pw varchar2(300) ,
  ta_create_date date NOT NULL,
  ta_secret_key varchar2(300) NOT NULL
 
) ;
select * from tbl_account_data;
desc tbl_account_data;
  	SELECT count(ta_idx) as ta_idx from tbl_account_data;

commit;