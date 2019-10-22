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



select * from Facilities_inspection;





----


---- 혜수 20191021  수정 
---- 아예 처음 디비 넣는 분들은 drop 제외하고 하면됩니다!
drop table book_category;
drop table book;
drop table appendix;
drop table rental;
drop table new_book;
drop table discard_book;
drop table reservation;

create table book_category ( --도서분류
    book_ctgr_num varchar2(100) , --분류기호
    book_ctgr_name varchar2(200)  --분류명
    --constraint book_category_num_pk PRIMARY KEY (category_num)
);

create table book ( --도서
    book_num number, --도서번호
    book_author varchar2(50), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50), --출판사
    book_pub_date date, --발행일
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --부록여부
    book_ctgr_num varchar2(100), --분류기호
    book_rsrv_status varchar2(50), --예약여부
    book_rent_cnt number, --대출 횟수
    book_input_date date --입력일
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);

insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), 'ㄱㄴㄷ', '가나다', '가나다 출판사', sysdate, '입력', 'X', '1', '예약가능', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), 'ㄴㄴㄴ', '나나나', '나나나 출판사', sysdate, '입력', 'X', '1', '예약가능', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), 'ㄷㄷㄷ', '다다다', '다다다 출판사', sysdate, '입력', 'X', '1', '예약가능', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), 'ㄹㄹㄹ', '라라라', '라라라 출판사', sysdate, '입력', 'X', '1', '예약가능', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), 'ㄴㄷㄹ', '나다라', '나다라 출판사', sysdate, '입력', 'X', '1', '예약가능', 0, sysdate );

create table appendix ( --부록
    apdx_code varchar(30),--부록코드
    apdx_book_num varchar2(30), --도서번호
    apdx_name varchar(50) --부록명
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);

create table rental (
    rent_num number, --대여번호
    book_num number, --도서번호
    mem_id varchar2(20), --회원번호
    rent_startdate date, --대여일
    rent_enddate date, --반납일
    rent_appendix_status varchar2(10), --부록대출여부
    rent_extension varchar2(10), --대여연장
    rent_status varchar2(30)
   -- constraint  rent_num_pk PRIMARY KEY (rent_num),
    --constraint rent_book_num_fk foreign key (book_num) 
    --references book (book_num),
    --constraint rent_fk foreign key (mem_id)   
    --references member (mem_id)
);

create table new_book ( --도서 구입 신청 테이블
    new_book_num number, --신간 신청 번호
    book_author varchar2(50), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50), --출판사
    book_price number, --도서 가격
    new_status varchar2(20), --신청 승인 상태
    new_input_date date  --신청일
);

create table discard_book ( --도서 폐기 신청 테이블
       dis_book_num number, --폐기 신청 번호
       book_num number, --도서번호
       dis_input_date date, --폐기 신청일
       dis_status varchar2(30) --신청 승인 상태
);

create table appendix ( --부록
    apdx_code varchar(30),--부록코드
    apdx_book_num varchar2(30), --도서번호
    apdx_name varchar(50) --부록명
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);

create table reservation (
    rent_num varchar2(30), -- 대여번호
    mem_id varchar2(20), --회원번호
    rsrv_num number(20)   --예약번호
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);

commit;


----수아
create table department (
    dept_code varchar2(20),
    dept_name varchar2(30)
    --CONSTRAINT dept_code_pk PRIMARY KEY(department_code)
);
insert into department values('000', '관장');
insert into department values('001', '총무부');
insert into department values('002', '교육부');
insert into department values('003', '정보부');
commit;

create table sal_check (
    sal_ck_no number,
    emp_no number,
    sal_ck_year varchar2(20),
    sal_ck_month varchar2(20),
    sal_ck_check varchar2(20)
    --constraint pay_no_pk primary key(pay_check_no)
);

create table employee_management(
    emp_no number,
    emp_name varchar2(15),
    emp_telephone varchar2(30),
    emp_address varchar2(200),
    emp_address_number varchar2(20),
    emp_dept_code varchar2(20),
    emp_jumin varchar2(25),
    emp_gender varchar2(10),
    emp_join_date date,
    emp_retire_date date,
    emp_email varchar2(30),
    emp_position varchar2(30),
    emp_basic_pay number,
    emp_bank_name varchar2(50),
    emp_account_number varchar2(30),
    emp_password varchar2(100)
    --CONSTRAINT emp_num_pk PRIMARY KEY(emp_num),
    --constraint emp_dept_fk FOREIGN KEY(department_code) REFERENCES department_table(department_code)
);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date) 
values(1000001,'강수아','01068618619',10000000,'koongmom@librain.org','000','관장',sysdate-1000);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000002,'이소영','01037869424',3000000,'soyount@librain.org','001','팀장',sysdate-254);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000003,'남민지','01022574895',3000000,'minjeenam@librain.org','002','팀장',sysdate-720);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000004,'문혜수','01016852036',2500000,'mhs96@librain.org','002','사원',sysdate-300);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000005,'박예원','01088430059',3000000,'yeahwoni@librain.org','003','팀장',sysdate-772);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000006,'김승수','01078963225',2500000,'iamseungsu@librain.org','003','사원',sysdate-150);
commit;



select * from employee_management;

create table commute_management(
    cmt_no number,
    emp_no number,
    cmt_status varchar2(100),
    cmt_year number,
    cmt_month number,
    cmt_DAY number,
    cmt_hour number,
    cmt_minute number,
    cmt_second number
    --CONSTRAINT cmt_no_pk PRIMARY KEY(commute_no)
);


create table salary_management(
    sal_no number,
    emp_no number,
    sal_total number,
    sal_real number,
    sal_national_pension number, -- 국민연금 4.5
    sal_health_insurance number, -- 건강보험 3.23
    sal_longterm_care_insurance number, -- 장기요양 건보 8.51
    sal_employment_insurance number, -- 고용보험 0.65
    sal_income_tax number, -- 소득세 0.7375
    sal_local_income_tax number, -- 소득세 10퍼
    sal_deducted number, -- 공제액 합
    sal_basic_pay number, -- 200만원
    sal_bonus number,
    sal_food_pay number, -- 15만원
    sal_year number,
    sal_month number
    --constraint pay_emp_fk FOREIGN KEY(emp_num) REFERENCES human_resource_management(emp_num)
);
--
--코드명 지출 , 날짜 
-- 
select * from rental;

select * from rental;


--tax
--
--salary
--
--sal_total
--
--기본급
--
--식대
--
--보너스
--
--승인 


--기간검색
-- 조건검색
--결과 내 재검색
--코드
--column
select count(*) weekm,count(*) months from dual;

--보기랑 입력이랑 다르게 
--select sum(금액) as 지출, code where 테이ㅡㄹ이름 group by code having 날짜검색어쩌구;
select * from test2;
insert into test2 values('12',5);

                          --부서코드      --부서명     --새로운부서코드일경우                                                  
select sum(dd2) 인건비,회사 ,case when dd='11' then '회계' else dd end 함수, 1000-sum(dd2) 남은예산 from test2 group by case when dd='11' then '회계' else dd end;
--회계 










--

--

--
--

select * from salary_management;
select * from pay_management;
create table pay_management(
    pay_no number,
    pay_emp_no varchar2(10),
    pay_division varchar2(20),
    pay_total_pay number,
    pay_real_pay number,
    pay_income_tax number,
    pay_residence_tax number,
    pay_health_insurance number,
    pay_unemployment_insurance number,
    pay_nation_pension number,
    pay_etx_pay number,
    pay_basic_pay number,
    pay_bonus number,
    pay_incentive_pay number,
    pay_food_pay number,
    pay_transportation_pay number
    --constraint pay_emp_fk FOREIGN KEY(emp_num) REFERENCES human_resource_management(emp_num)
);



select nvl(sum(book_price),0) from new_book where new_status='승인';
