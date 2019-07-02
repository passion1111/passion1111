
      
     alter table emp add seq_Pno number(12);
     update emp set seq_Pno=rownum;
     select*from gift;
     create table gift(
        ga number,
        ga2 number,
        constraint g_key primary(ga,ga2);
        
        alter table gift add (ga2 number,ga3 number);
        update  gift set ga2=nvl(ga2,0);
        select *from gift;
        alter table gift drop primary key ;
        
        CREATE TABLE kimkim(
            ga number,
            ga2 number,
            constraint ga_key primary key(ga,ga2));
        
        
        alter table gift add constraint D primary key(ga2);
     update 테이블명 set 상품컬럼=rownum;
     insert into emp(empno) values(1);
     select*from emp;
     
     create table w