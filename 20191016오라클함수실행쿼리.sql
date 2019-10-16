--커서 공부들 

create table test3(
    val number
);
select * from test3;

declare

begin
    for ho in (select * from test3)
    loop
    DBMS_OUTPUT.put_line('값은 ?   '||ho.val);
    
    end loop;
   
end;
/


declare
 cursor ho is select * from test3;
   ho2 test3%rowtype;
begin
    open ho;
    loop
    fetch ho into ho2;
 exit when  ho%notfound;

   DBMS_OUTPUT.put_line('로우 카운트 : '||ho%rowcount );
--    
--    end loop;
 
end loop;
   DBMS_OUTPUT.put_line('마지막로우 : '||ho%rowcount );

 close ho;   
end;
/

--예약 로직 조금 짜보기.
declare 
    hoho number;

begin

for ho in (select  * from test3) loop
   DBMS_OUTPUT.put_line('3  val '||ho.val  );    --반납 안한 사람들 
    select count(*) into hoho  from test3           where val=ho.val;   --순번 떙길 사람들
        for i in 1..hoho  loop
        DBMS_OUTPUT.put_line('4' );
        end loop;
    
    
end loop;
end;
/
--커서로 예약로직 짜기.
declare 
    hoho number;

begin

for ho in (select  * from test3) loop
   DBMS_OUTPUT.put_line('3  val '||ho.val  );    --반납 안한 사람들 
    select count(*) into hoho  from test3           where val=ho.val;   --순번 떙길 사람들
        for i in 1..hoho  loop
        DBMS_OUTPUT.put_line('4' );
        end loop;
    
    
end loop;
end;
/


--
CREATE OR REPLACE PROCEDURE MY_PROC(  V_NUMBER IN NUMBER,P_RC OUT SYS_REFCURSOR )  
AS  
BEGIN  
    OPEN P_RC  
    FOR SELECT *  
         FROM test3;  
END;  
  /
-- 확인 프로시져  
CREATE OR REPLACE FUNCTION MY_PROC_TEST(V_NUMBER IN NUMBER) RETURN SYS_REFCURSOR  
AS  
    P_RC SYS_REFCURSOR;  
BEGIN  
    MY_PROC(V_NUMBER,P_RC);  
    RETURN P_RC;  
END;  
/

--함수 계획방법
select my_proc_test(2) from dual;


select * from test3;
insert into test3 values(2);
delete from test3;
