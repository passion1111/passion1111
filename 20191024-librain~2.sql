
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

 



select * from rental;
select * from rental;
select * from rental where rent_enddate ;
update rental set rent_enddate=sysdate-20;
insert into values
create or replace procedure proc_rentalupdate(
    ha out sys_refcursor)
    is
    
    begin
     open ha for select * from rental where rent_enddate<sysdate and rent_status ='������' ; -- �����ߴµ� �Ⱥ��� �����
   
     end;
     
     /
declare 
    bbbook_num rental.book_num%type;
    mem_id   rental.mem_id%type;
    ho sys_refcursor;
    countvalues  rental%rowtype;
    hoho number;
    onecheck number;
begin
    proc_reservationdelayed(ho); 
    --�뿩 ���� ����� ���   out������ �Ѹ���.
loop
 fetch ho into countvalues;  -- 
  exit when ho%notfound;
   -- ���ο� ���ν��� �ϳ��� ������ ������.
    select  count(*) into hoho  from reservation where book_num=countvalues.book_num;   --���� ���� �����

     --å �Ⱥ�������̶� �׳� ��������.
     --reservation ���̺����� �ְ� rental���� ����. �Ǵ� rental�� �־����
    delete from reservation where book_num=countvalues.book_num and rsrv_num=1;
   delete from reservation where book_num=countvalues.book_num;
   --1���λ�� �Ǵ��ϱ�
   
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
        ,'������'); 
        --�Ʒ� ����
        delete from reservation where book_num=countvalues.book_num and rsrv_num=1;
        end if;
    
  
    
    --���� �Ϸ�Ǹ� ����1���� ��������.
        for i in 1..hoho  loop
        update reservation set rsrv_num=i where rsrv_num=i+1; 
      
            --ù ������ �����Ը����
       
       
    
        
       DBMS_OUTPUT.put_line('����� = '||i ||'�׸��� ho2�� val= ' );
--     
       end loop;  --foreach end loop
    end loop;
    close ho;
    end;
    /
    
    
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
        ,'������'); 
    
    end if;
        for temp in (select * from reservation where book_num=rental_book_num) loop
        
     DBMS_OUTPUT.put_line('����� = '||tempchar ||'�׸��� ho2�� val= '||cnt );
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
    --reservation mem_id�� ���;���. 
    select * from rental;
    insert into reservation values(4,'nmj',1 , sysdate+30,100054);
    select * from reservation;
    select * from rental;
    update rental set  rent_status ='������' ,rent_enddate=sysdate-30 where  book_num=100001;
    update 
    select * from testtable;
    insert into testtable values(3);
   desc reservation;
end loop;-- ho loop


select * from reservation;

select * from rental;

insert into values