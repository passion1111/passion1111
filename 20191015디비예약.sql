select *from member;
select * from book;
desc book;
select * from rental;
select nvl(max(rent_num)+1,1) aa from rental;
select * from rental;
ALTER table member modify(DEADLINE_RENT_STOP date,book_loanable varchar2(20));
select * from member;
select * from reservation;
desc reservation;

create table reservation (
    book_num varchar2(30), -- 도서번호
    mem_id varchar2(20), --회원번호
    rsrv_num number(20),   --예약번호,
    rsrv_enddate date);
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);
desc reservation;
select * from reservation;



select * from book; -- 
--알아서 넣어줘야 할것 rerv_num   rsrv_enddate는 rsrv_count  rsrv_num이 1일경우 
insert into reservation(book_num,mem_id,rsrv_num,rsrv_enddate)       
values(100001,'1',(select count(rsrv_num)+1 from reservation where book_num=100001),null);

                                                                                --또는 예약할떄 값이 0<5 이면 예약가능하게.
select distinct book.book_num , case when count(reservation.rsrv_num) over(partition by book.book_num)<5 then '예약가능' end from book join reservation on book.book_num=reservation.book_num where book.book_num=100001;
select count(rsrv_num) from reservation where book_num=100001;




-- 이 값이 0일경우 end_date 설정
--
select * from book;
select * from reservation;
select * from reservation where book_num=100003;










select * from reservation;


select * from reservation where rsrv_enddate<=sysdate;
-- rsrv_num이 5이상일시 입력 X  procedure

--매일 실행시켜야할 쿼리
select * from reservation where rsrv_enddate<=sysdate;  --헛 예약자들 지우고나서 






select count(rsrv_num)+1 from reservation where book_num=100002;
select * from reservation;

/

select nvl(max(rent_num)+1,1) from reservation ; 


select * from rental;



select mem_id,mem_name,mem_phone,mem_address,mem_email,mem_rank, case when mem_rank=2 then 7 
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end LOANABLE_NUMBER , DEADLINE_RENT_STOP,book_loanable
                                                                        from member;
                                                                      


select  distinct mem.mem_id,mem.mem_name,mem.mem_phone,mem.mem_address,mem.mem_email,mem.mem_rank, case when mem_rank=2 then 7 
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end LOANABLE_NUMBER , DEADLINE_RENT_STOP,book_loanable,
                                                                      count(*) over(PARTITION by mem.mem_id) 대출권수,
                                                                      (case when mem_rank=2 then 7 
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end -count(*) over(PARTITION by mem.mem_id)) 대출가능권수
                                                                        from member mem join rental on mem.mem_id=rental.mem_id ;
  --대출한 책 대출 권수                                                               
                                                                      

update member set DEADLINE_RENT_STOP=sysdate-10,book_loanable='대출가능';