
      
     alter table emp add seq_Pno number(12);
     update emp set seq_Pno=rownum;
     
     update 테이블명 set 상품컬럼=rownum;
     insert into emp(empno) values(1);
     select*from emp;