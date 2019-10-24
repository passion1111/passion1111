
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






select * from reservation;
select * from rental;

 create or replace procedure proc_reservationdelayed(
    ha out sys_refcursor)
    is
    
    begin
     open ha for select * from rental where rent_enddate<sysdate and rent_status ='예약중' ; -- 예약했는데 안빌린 사람들
   
     end;
     
     /
     
     
     create or replace procedure proc_rentaldelayed
    is
    
    begin
    
     for delayedlist in (select * from rental where rent_enddate<sysdate) loop -- 예약했는데 안빌려가는사람들
    update member set deadline_rent_stop=nvl(deadline_rent_stop,sysdate)+1 where mem_id=delayedlist.mem_id;
    
    end loop;
     end; 
     /
     select * from member;
    update member set deadline_rent_stop=deadline_rent_stop+1 where mem_id='nmj';
    exec proc_rentaldelayed();
     
     
select * from rental where rent_enddate<sysdate;

select * from member;

select * from rental;
select * from member where mem_id='pyw';
update rental set rent_enddate=sysdate-20 where mem_id='pyw';

select * from rental;


select * from reservation;

declare 
    bbbook_num rental.book_num%type;
    mem_id   rental.mem_id%type;
    ho sys_refcursor;
    countvalues  rental%rowtype;
    hoho number;
    onecheck number;
begin
    proc_reservationdelayed(ho); 
    --대여 안한 사람들 목록   out값으로 뿌리기.
loop
 fetch ho into countvalues;  -- 
  exit when ho%notfound;
  

   -- 새로운 프로시저 하나로 묶을수 있을듯.
    select  count(*) into hoho  from reservation where book_num=countvalues.book_num;   --순번 떙길 사람들
    select count(*) into onecheck from reservation where rsrv_num=1 and book_num= countvalues.book_num;
    --update test3 set val=0 where val=1 and varc in('not');   -- varc는 enddate<sysdate인 사람들  
   DBMS_OUTPUT.put_line('3  val '||   'ho프로시저 행 수'||hoho );    --해당책 예약중인 사람 목록

     --책 안빌린사람이라서 그냥 지워버림.
     --reservation 테이블에만 있고 rental에는 없음. 또는 rental도 넣어버림
    delete from reservation where book_num=countvalues.book_num and rsrv_num=1;
   delete from reservation where book_num=countvalues.book_num;
   --1번인사람 판단하기
   
    if 1=onecheck then
         insert into rental(RENT_NUM ,       
BOOK_NUM              ,
MEM_ID               ,
RENT_STARTDATE        ,      
RENT_ENDDATE           ,       
RENT_APPENDIX_STATUS   ,
RENT_EXTENSION          ,
RENT_STATUS    )

        values( (select max(rent_num)+1 from rental) , countvalues.book_num
        ,  (select mem_id from reservation where rsrv_num=1 and  book_num =countvalues.book_num)
        ,sysdate
        ,sysdate+2
        ,'X'
        ,'X'
        ,'예약중'); 
        --아래 위험
        delete from reservation where book_num=countvalues.book_num and rsrv_num=1;
        end if;
    
  
    
    --예약 완료되면 순번1에서 지워버림.
        for i in 1..hoho  loop
        update reservation set rsrv_num=i where rsrv_num=i+1; 
      
            --첫 예약자 빌리게만들기
       
       
    
        
       DBMS_OUTPUT.put_line('결과는 = '||i ||'그리고 ho2의 val= ' );
--     
       end loop;  --foreach end loop
    end loop;
    close ho;
    end;
    /
    select * from rental;
    select * from rental;
    update rental set rent_status='예약중' ,rent_enddate=sysdate-50 where rent_num=6;
    select * from reservation;
    insert into reservation values(1,'nmj',1,sysdate+30,100005);
    select * from member;
    desc reservation;
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

        values( (select max(rent_num)+1 from rental) 
        ,(select mem_id from reservation where rsrv_num=1 and  book_num =countvalues.book_num)
        ,tempchar
    
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
    insert into reservation values(4,'nmj',1 , sysdate+30,100054);
    select * from reservation;
    select * from rental;
    update rental set  rent_status ='예약중' ,rent_enddate=sysdate-30 where  book_num=100001;
    update 
    select * from testtable;
    insert into testtable values(3);
   desc reservation;
end loop;-- ho loop


select * from reservation;

select * from rental;

insert into values