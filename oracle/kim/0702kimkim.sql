
      
     alter table emp add seq_Pno number(12);
     update emp set seq_Pno=rownum;
     
     update ���̺�� set ��ǰ�÷�=rownum;
     insert into emp(empno) values(1);
     select*from emp;