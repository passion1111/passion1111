CREATE OR REPLACE TRIGGER triger_test
       BEFORE
       UPDATE  or delete ON dept
       FOR EACH ROW
	   
	   BEGIN
        insert into roll(userid) values(1);

     END;
     select *from dept;
     select *from roll;
   UPDATE dept SET dname = 'ÃÑdd¹«ºÎ' WHERE deptno = 30;
   
  CREATE OR REPLACE TRIGGER abc
    before
  INSERT OR UPDATE or delete ON dept
    FOR EACH ROW
begin
    insert into dept(deptno) values(1);
end;
    /
    drop trigger abc;
    select* from dept;
    insert into dept(deptno) values(2);
