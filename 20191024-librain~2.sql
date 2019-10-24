
   create or replace procedure proc_testtable(
    ha out sys_refcursor)
    is
    
    begin
     open ha for select * from testtable;
     end;
     /
     
         
  DECLARE
  l_cursor  SYS_REFCURSOR;
  l_ename   testtable.ha%TYPE;
 
BEGIN
  proc_testtable (
              l_cursor);
            
  LOOP 
    FETCH l_cursor
    INTO  l_ename;
    EXIT WHEN l_cursor%NOTFOUND;
    --DBMS_OUTPUT.PUT_LINE(l_ename);
    insert into testtable  values(l_ename);
  END LOOP;
  CLOSE l_cursor;
END;
/







 create or replace procedure proc_rentalupdate(
    ha out sys_refcursor)
    is
    
    begin
     open ha for select * from rental where rent_enddate<sysdate ;
     end;
     /
select * from rental;



select * from rental;
declare 
    bbbook_num rental.book_num%type;
    mem_id   rental.mem_id%type;
    ho sys_refcursor;
    countvalues  rental%rowtype;
    hoho number;
begin
    proc_rentalupdate(ho);
    --대여 안한 사람들 목록   out값으로 뿌리기.
loop
 fetch ho into countvalues;  -- 그냥 변수할당해도 괜찮을듯.  ho2.grou로 
  exit when ho%notfound;
  

   -- 새로운 프로시저 하나로 묶을수 있을듯.
    select  count(*) into hoho  from reservation where book_num=countvalues.book_num;   --순번 떙길 사람들
    --update test3 set val=0 where val=1 and varc in('not');   -- varc는 enddate<sysdate인 사람들  
   DBMS_OUTPUT.put_line('3  val '||   'ho프로시저 행 수'||hoho );    --예약했는데 안빌린 사람들.

     --책 안빌린사람이라서 그냥 지워버림.
    delete from rental where book_num=countvalues.book_num;
    --예약 완료되면 순번1에서 지워버림.
    delete from reservation where book_num=countvalues.book_num and rsrv_num=1;
        for i in 1..hoho  loop
        update reservation set rsrv_num=i where rsrv_num=i+1; 
      
            --첫 예약자 빌리게만들기
        if i=1 then  insert into rental(RENT_NUM ,       
BOOK_NUM              ,
MEM_ID               ,
RENT_STARTDATE        ,      
RENT_ENDDATE           ,       
RENT_APPENDIX_STATUS   ,
RENT_EXTENSION          ,
RENT_STATUS    )

        values( (select max(rent_num)from rental) , countvalues.book_num
        ,  (select mem_id from reservation where rsrv_num=1 and  book_num =countvalues.book_num)
        ,sysdate
        ,sysdate+2
        ,'X'
        ,'X'
        ,'예약중'); 
        --아래 위험
        delete from reservation where book_num=countvalues.book_num and rsrv_num=1;
        end if;
    
        
       DBMS_OUTPUT.put_line('결과는 = '||i ||'그리고 ho2의 val= ' );
--     
       end loop;  --foreach end loop
    end loop;
    close ho;
    end;
    /
    --반납하면 한명씩 떙기게만들기.
    create or replace procedure temp_temp_temp( rental_book_num in number)
    is
    cnt number;
    tempcnt number;
    tempchar varchar2(30);
    begin
    select count(*) into cnt from reservation where book_num=rental_book_num and rsrv_num>0;
    select mem_id into tempchar from reservation where book_num=rental_book_num and rsrv_num=1;
    
    if  cnt>0 then insert into rental(RENT_NUM ,       
BOOK_NUM              ,
MEM_ID               ,
RENT_STARTDATE        ,      
RENT_ENDDATE           ,       
RENT_APPENDIX_STATUS   ,
RENT_EXTENSION          ,
RENT_STATUS    )

        values( (select max(rent_num)+1 from rental) ,tempchar
        ,  (select mem_id from reservation where rsrv_num=1 and  book_num =countvalues.book_num)
        ,sysdate
        ,sysdate+2
        ,'X'
        ,'X'
        ,'예약중'); 
    
    end if;
        for temp in (select * from reservation where book_num=rental_book_num) loop
        
     DBMS_OUTPUT.put_line('결과는 = '||tempchar ||'그리고 ho2의 val= '||cnt );
        end loop;
    end;
    /
    exec temp_temp_temp(100003);
    select * from rental;
    
    select count(*) from reservation where book_num=2038921093;
    
    
    select * from reservation;
    select * from rental;
    desc rental;
    insert into rental( RENT_NUM ,       
BOOK_NUM              ,
MEM_ID               ,
RENT_STARTDATE        ,      
RENT_ENDDATE           ,       
RENT_APPENDIX_STATUS   ,
RENT_EXTENSION          ,
RENT_STATUS          )
values(  (select max(rent_num)from rental)  ,  
book_num=1
        (select mem_id from reservation where rsrv_num=1 and  book_num=100001,
    --reservation mem_id값 얻어와야함. 
    select * from rental;
    insert into reservation values(4,'nmj',2,100001);
    select * from reservation;
    select * from rental;
    select * from testtable;
    insert into testtable values(3);
   
end loop;-- ho loop


select * from reservation;

select * from rental;

insert into values