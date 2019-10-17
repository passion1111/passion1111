--커서 공부들 

create table test3(
    val number,             --예약 순번.
    varc varchar2(30),   -- varc는 예약했는데 안빌린 사람의 반납 조건에 필요한 쿼리. 
    grou number            -- group  책 
);

insert into test3 values(1,'a',1);
insert into test3 values(2,'a',1);
insert into test3 values(3,'a',1);
insert into test3 values(4,'a',1);
insert into test3 values(1,'not',2);
insert into test3 values(2,'not',2);
insert into test3 values(3,'not',2);
insert into test3 values(4,'not',2);
insert into test3 values(1,'not',3);
insert into test3 values(2,'not',3);
insert into test3 values(3,'not',3);
insert into test3 values(4,'not',3);
insert into test3 values(5,'not',3);


select * from test3;

drop table test3;

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

--예약 로직 조금 짜보기. 미완성시
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

--예약순번1인데 대여안한사람들 목록.
declare 
    hoho number;
    ho sys_refcursor;
    ho2 test3%rowtype;
begin
    
   open ho for select  * from test3 where varc in('not') and val=1; --대여 안한 사람들 목록   out값으로 뿌리기.
loop
 fetch ho into ho2;  -- 그냥 변수할당해도 괜찮을듯.  ho2.grou로 
  exit when ho%notfound;
  
   -- 새로운 프로시저 하나로 묶을수 있을듯.
    select  count(*) into hoho  from test3 where grou=ho2.grou;   --순번 떙길 사람들
    update test3 set val=0 where val=1 and varc in('not');   -- varc는 enddate<sysdate인 사람들  
   DBMS_OUTPUT.put_line('3  val '||ho2.val  || 'ho프로시저 행 수' || hoho);    --예약했는데 안빌린 사람들.

   
        for i in 1..hoho  loop
        update test3 set val=i where val=i+1  and varc in('not');
        DBMS_OUTPUT.put_line('결과는 = '||i ||'그리고 ho2의 val= '||ho2.val );
      -- 확인  insert into test3(val) values(i+1);
        end loop;  --foreach end loop
    
    
end loop;-- ho loop

--반납시
--book상태 대여로 바꾼후에

--reservation 해당 책 count 값이 0보다 클경우에 


declare
hoho number;
begin
    



end;




close ho;
end;
/
-- 위에거는 시간마다 예약자 떙기는거

-- 아래는  예약자에 따라서 예약시간 구현          그루는 책번호   soo가 5이상일시 insert X 
declare 
soo number;
begin
 select count(*) into soo from test3 where grou=4 ;
    if soo<1 then 
                    DBMS_OUTPUT.PUT_LINE(sql%rowcount);
                    --end date sysdate+2정도로 입력
     insert into test3 values(soo+1, 'b',4);
    elsif  soo<5 then
        DBMS_OUTPUT.PUT_LINE(sql%rowcount);

                                    -- end date null 입력
    insert into test3 values(soo+1, 'b',4);
    
       
    end if;
    DBMS_OUTPUT.PUT_LINE(sql%rowcount);
    
    -- 만약 실패메세지 띄울거면 if문 실행하는것에따라 out parameter값을 다르게 구현해서 실패했다는것을 알려줄것.
end;
/

select * from test3;

set serveroutput on;

insert into reservation(book_num,mem_id,rsrv_num,rsrv_enddate)       
values(100001,'1',(select count(rsrv_num)+1 from reservation where book_num=100001),sysdate);
-- 분기 count>1 and count<=5
insert into reservation(book_num,mem_id,rsrv_num,rsrv_enddate)       
values(100001,'1',(select count(rsrv_num)+1 from reservation where book_num=100001),null);



select * from test2;
drop table test3;
alter table test3 add(hoho varchar2(30));
select * from test3;








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


select * from test3 where varc in ('not');
insert into test3 values(5,'not');
delete from test3;
