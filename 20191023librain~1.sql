create table test22(
honumber number);

commit;
select * from test22;
declare

begin
    for i in 1..2000 loop
    
    insert into test22 values(i);
    end loop;

end;
/
select * from employee_management;
update employee_management set emp_password=1;
commit;
drop table employee_management;




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
insert into employee_management
values(1000001,'강수아','01068618619','서울시,이문동','02451','000','9501072222222','F',sysdate-3000,null,'koongmom@librain.org','관장',10000000,'하나','111111111111','950107');



select * from employee_management;