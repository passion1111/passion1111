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


---- ���� 20191021  ���� 
---- �ƿ� ó�� ��� �ִ� �е��� drop �����ϰ� �ϸ�˴ϴ�!
drop table book_category;
drop table book;
drop table appendix;
drop table rental;
drop table new_book;
drop table discard_book;
drop table reservation;

create table book_category ( --�����з�
    book_ctgr_num varchar2(100) , --�з���ȣ
    book_ctgr_name varchar2(200)  --�з���
    --constraint book_category_num_pk PRIMARY KEY (category_num)
);

create table book ( --����
    book_num number, --������ȣ
    book_author varchar2(50), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50), --���ǻ�
    book_pub_date date, --������
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --�ηϿ���
    book_ctgr_num varchar2(100), --�з���ȣ
    book_rsrv_status varchar2(50), --���࿩��
    book_rent_cnt number, --���� Ƚ��
    book_input_date date --�Է���
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);

insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), '������', '������', '������ ���ǻ�', sysdate, '�Է�', 'X', '1', '���డ��', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), '������', '������', '������ ���ǻ�', sysdate, '�Է�', 'X', '1', '���డ��', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), '������', '�ٴٴ�', '�ٴٴ� ���ǻ�', sysdate, '�Է�', 'X', '1', '���డ��', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), '������', '����', '���� ���ǻ�', sysdate, '�Է�', 'X', '1', '���డ��', 0, sysdate );
insert into book VALUES ((select nvl(max(book_num)+1,100001) from book), '������', '���ٶ�', '���ٶ� ���ǻ�', sysdate, '�Է�', 'X', '1', '���డ��', 0, sysdate );

create table appendix ( --�η�
    apdx_code varchar(30),--�η��ڵ�
    apdx_book_num varchar2(30), --������ȣ
    apdx_name varchar(50) --�ηϸ�
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);

create table rental (
    rent_num number, --�뿩��ȣ
    book_num number, --������ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rent_startdate date, --�뿩��
    rent_enddate date, --�ݳ���
    rent_appendix_status varchar2(10), --�ηϴ��⿩��
    rent_extension varchar2(10), --�뿩����
    rent_status varchar2(30)
   -- constraint  rent_num_pk PRIMARY KEY (rent_num),
    --constraint rent_book_num_fk foreign key (book_num) 
    --references book (book_num),
    --constraint rent_fk foreign key (mem_id)   
    --references member (mem_id)
);

create table new_book ( --���� ���� ��û ���̺�
    new_book_num number, --�Ű� ��û ��ȣ
    book_author varchar2(50), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50), --���ǻ�
    book_price number, --���� ����
    new_status varchar2(20), --��û ���� ����
    new_input_date date  --��û��
);

create table discard_book ( --���� ��� ��û ���̺�
       dis_book_num number, --��� ��û ��ȣ
       book_num number, --������ȣ
       dis_input_date date, --��� ��û��
       dis_status varchar2(30) --��û ���� ����
);

create table appendix ( --�η�
    apdx_code varchar(30),--�η��ڵ�
    apdx_book_num varchar2(30), --������ȣ
    apdx_name varchar(50) --�ηϸ�
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);

create table reservation (
    rent_num varchar2(30), -- �뿩��ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rsrv_num number(20)   --�����ȣ
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);

commit;


----����
create table department (
    dept_code varchar2(20),
    dept_name varchar2(30)
    --CONSTRAINT dept_code_pk PRIMARY KEY(department_code)
);
insert into department values('000', '����');
insert into department values('001', '�ѹ���');
insert into department values('002', '������');
insert into department values('003', '������');
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
values(1000001,'������','01068618619',10000000,'koongmom@librain.org','000','����',sysdate-1000);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000002,'�̼ҿ�','01037869424',3000000,'soyount@librain.org','001','����',sysdate-254);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000003,'������','01022574895',3000000,'minjeenam@librain.org','002','����',sysdate-720);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000004,'������','01016852036',2500000,'mhs96@librain.org','002','���',sysdate-300);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000005,'�ڿ���','01088430059',3000000,'yeahwoni@librain.org','003','����',sysdate-772);
insert into employee_management(emp_no,emp_name,emp_telephone,emp_basic_pay,emp_email,emp_dept_code,emp_position,emp_join_date)
values(1000006,'��¼�','01078963225',2500000,'iamseungsu@librain.org','003','���',sysdate-150);
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
    sal_national_pension number, -- ���ο��� 4.5
    sal_health_insurance number, -- �ǰ����� 3.23
    sal_longterm_care_insurance number, -- ����� �Ǻ� 8.51
    sal_employment_insurance number, -- ��뺸�� 0.65
    sal_income_tax number, -- �ҵ漼 0.7375
    sal_local_income_tax number, -- �ҵ漼 10��
    sal_deducted number, -- ������ ��
    sal_basic_pay number, -- 200����
    sal_bonus number,
    sal_food_pay number, -- 15����
    sal_year number,
    sal_month number
    --constraint pay_emp_fk FOREIGN KEY(emp_num) REFERENCES human_resource_management(emp_num)
);
--
--�ڵ�� ���� , ��¥ 
-- 
select * from rental;

select * from rental;


--tax
--
--salary
--
--sal_total
--
--�⺻��
--
--�Ĵ�
--
--���ʽ�
--
--���� 


--�Ⱓ�˻�
-- ���ǰ˻�
--��� �� ��˻�
--�ڵ�
--column
select count(*) weekm,count(*) months from dual;

--����� �Է��̶� �ٸ��� 
--select sum(�ݾ�) as ����, code where ���̤Ѥ��̸� group by code having ��¥�˻���¼��;
select * from test2;
insert into test2 values('12',5);

                          --�μ��ڵ�      --�μ���     --���ο�μ��ڵ��ϰ��                                                  
select sum(dd2) �ΰǺ�,ȸ�� ,case when dd='11' then 'ȸ��' else dd end �Լ�, 1000-sum(dd2) �������� from test2 group by case when dd='11' then 'ȸ��' else dd end;
--ȸ�� 










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



select nvl(sum(book_price),0) from new_book where new_status='����';
