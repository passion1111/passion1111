select * from rental;
select * from book;
select * from member;
select * from rental;

select * from member;
select * from rental;
                 --대출정지기한 필요
                 --대출가능상태
drop table book;

create table book ( --도서
    book_num number, --도서번호
    book_author varchar2(150), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50), --출판사
    book_pub_date date, --발행일
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --부록여부
    book_ctgr_num varchar2(100), --분류기호
    book_rsrv_status varchar2(50), --예약여부
    book_rent_cnt number, --대출 횟수
    book_input_date date, --입력일
    book_ctgr_num_db varchar2(100) --도서 분류에 넣을 분류기호 값
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);
desc book;
select * from book;
select * from rental;

select * from reservation;
desc member;
ALTER table member modify(DEADLINE_RENT_STOP date,book_loanable varchar2(20) default '대출가능');
select * from member;
update member set deadline_rent_stop=null where mem_id=1;


--매일 자정 해당 사람들  
select * from member;
declare
begin

for rentupdate in  (select * from rental where rent_enddate<sysdate)
loop
     update member set deadline_rent_stop=sysdate+ceil(sysdate-rentupdate.rent_enddate) where mem_id=rentupdate.mem_id;
     
     
    end loop;
    end;
    /
    update member set deadline_rent_stop=sysdate+ceil(sysdate-sysdate) where mem_id=1;
    select * from rental;
    select * from member;
    select sysdate+ceil(sysdate-rent_enddate) from rental;
    select sysdate+sysdate from dual;
    select * from member;
select * from rental where rent_enddate<sysdate;
select * from book;
select * from member where deadline_rent_stop<sysdate;


-- 만약 연체했을시에 mem_rank 


--회원검색했을시 67
select mem_id,mem_name,mem_phone,mem_address,mem_email,mem_rank,book_loanable, deadline_rent_stop ,
                                                                case when deadline_rent_stop>sysdate and book_loanable='대출가능' then 0
                                                                else
                                                                      case when mem_rank=2 then 7  -- 대출불가 판단
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end
                                                                end      LOANABLE_NUMBER ,
                                                                case when deadline_rent_stop>sysdate and book_loanable='대출가능' then 0
                                                                else       
                                                                      case when mem_rank=2 then 7 
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end    -(select count(*) from rental where mem_id='nmj' and rent_status='대여중')
                                                                end     현재대여가능권수 from member;
                                                                
                                                                          select * from reservation;
                                                                
                                                                desc member;
                                                                
 
 
 select * from rental;
 
 
 
 
                        update member set book_loanable='대출가능';                                    
                                    
 select * from member;
 select * from reservation;
 select  * from reservation;
                                    
select * from member;                                   
 
                  --방법 
                
                
                   --부르는것 다르게 할것.   book/rent.do에서 회원검색했을떄 같이 불러올것.  -- 예약순번 1번일떄 insert into rental 에 1번 예약중으로 구현.
                    select  distinct rental.book_num,
                        case when rent_status='대여중' then '대여중'
                             when rent_status='예약중' then case when reservation.mem_id=rental.mem_id then '대여가능'
                                                            else '예약중'  end
                             end 대출여부      --예약자이면 대여가능이라고 변함.                            
                   ,book_name,book_author,book_pub_house
                    ,case when rent_extension='X' then '연장가능'
                        else '연장불가능' end 연장여부
                        --book_rsrv_status중에 내가 예약한 
--                       case when  book_rsrv_status ='예약가능'  then 
--                                                                                    --왜 기본값이 1?
--                                                                    case when   then '예약중입니다'
--                                                                                                    else  case when    (  case when rent_status='대여중' then '대여중'
--                                                                                                                             when rent_status='예약중' then case when reservation.mem_id=rental.mem_id then '대여가능'
--                                                                                                                                                            else '예약중'  end
--                                                                                                                             end)='대여중' then '이미대여중입니다' else '예약가능' end  end
--                           end 예약여부
            ,to_char(rent_enddate,'yyyymmdd') rent_enddate       from book join rental on book.book_num=rental.book_num left  outer join  reservation on reservation.mem_id=rental.mem_id ;
                    -- 앞단에서 extension이 o이면 연장불가능 
                    
                    --이미 예약중이면 ajax로 예약값 체크 
                    
                    
                    
                    --반납 
                    
                    
                    --예약하기 연장하기는 버튼하나로만 판단. 
                    
                    
                    
                    --
                    select * from reservation;
                    
                    select * from rental;
                    select 
                    select * from reservation;
                    
                    select count(*) over(partition by book_num) from reservation;
                    select * from reservation;
        
                    select * from rental;
                    
                    
                    
                    select * from book join rental on book.book_num=rental.book_num ;
                    
                    
                    --reservation에 추가된애들만 확인.
                  select * from reservation;
                  select * from rental;
                  
                  select * from rental full join reservation on reservation.mem_id=rental.mem_id;
                  select * from book;
                                                        100002
                  insert into reservation values(3,'nmj',1,100003);
                insert into rental values(3,100003,'nmj',null,null,'X','X','예약중');
                  select * from rental;
                  select * from rental;
                  
                  select * from book;  
                  
                  
                  
                  
                  
                  
                  
                    
                    select * from rental;
                    select * from reservation;
                    
                                        --예약 완료됐을시에
                                    select * from rental;
                                    rental_status 예약중 =mem_id == 
                                    
                                    
                                                        select * from    rental join book on book.book_num=rental.book_num   join  reservation on reservation.book_num=book.book_num where rental.mem_id=1;         
                                                            select * from reservation;
                                                        select count(*) over(partition by book_num) from reservation;
                                                        select * from rental  where mem_id=1;
                                                        select * from reservation;
                                                        select * from reservation;
                                                        select * from book;
                                                        
                                                        select * from reservation where mem_id;
                                                        select * from rental;
                                                        
                                                       select case when dd2=1 then 2
                                                                   when dd='11' then 1 end from test2;
                                                       desc test2;
                                                       select * from member;
                                                       delete from rental;
                                                       select * from reservation;
                                                       select * from rental;
                                                   
                                                       select * from member;
                                                       select * from  rental where book_num=100001 and rent_num=(select max(rent_num) from rental where book_num=100001)  ;
                                                       select * from member join rental on;
                                                       select  * from rental;
                                                       select  b.book_num,r.*,rental.* from book b 
                                                   join rental on  b.book_num=rental.book_num left outer join (select * from reservation where reservation.rsrv_num=1) r on r.book_num=rental.book_num;                                                                     
                                                 select * from rental;
                                                 -- 반납시 
                                                 
                                                 
                                                    --해당회원 빌린책반납.  rent_enddate not null 
                                                    select * from rental;
                                                 --1. 해당 회원이 빌린 책  반납시  rent_enddate    null  rent_status 반납 
                                                 select * from reservation;
                                                 select * from member join rental on member.mem_id=rental.mem_id  where member.mem_id=1 and rent_status='대여중' or rent_status='예약중'  ;
                                               
                                               select * from reservation;
                                               delete * from 
                                               
                                                    
                                                    --mem_id
                                                       select * from test2;
                                                       select * from rental;
                                                       select * from reservation;
                                                      select * from book;
                                                                      select * from member;
                                                                      select count(*) from rental where mem_id=1 and rent_status='대여중';
ALTER table member modify(DEADLINE_RENT_STOP date,book_loanable varchar2(20));

select * from member;



create table temp_member_book as select * from ;

select * from member;
desc rental;
desc member;
desc book;

select * from reservation;
select * from book;
select * from rental;
select * from member inner join rental on member.mem_id=rental.mem_id ;


select count(book_num) from member inner join rental on member.mem_id=rental.mem_id  where member.mem_id=12  ;




select *from member;
select * from book;
select count(*) over(),book_num from book;
select * from rental;
select * from member;k

--distinct 
select  distinct mem_id ,rank,bookcount
from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent ,r.mem_id  ,c.mem_rank rank  ,count(*) OVER(PARTITION BY r.mem_id) bookcount
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                     and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id  );
select * from book;
select * 
select * from rental;
select * from member;
select * from member;


--  
-- 

 -- 
select * from book;

desc rental;
desc reservation;
select  * from reservation;
select * from rental;

-- 
select * from
 (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent ,r.mem_id  ,c.mem_rank rank  ,count(*) OVER(PARTITION BY r.mem_id) bookcount
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                     and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id  );
       
       
            
 declare           
cursor b_bookstatus is
select *-- distinct mem_id ,rank,bookcount
from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent ,r.mem_id  ,c.mem_rank rank  ,count(*) OVER(PARTITION BY r.mem_id) bookcount
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                     and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id  );

begin
 for book_cursor in b_bookstatus loop
 
--    case 
--        when cc.facin_name='엘레베이터' then 
--             update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_SCHEDULED_INSPECTION_DATE=sysdate+90 where facin_name=cc.facin_name;
--    else
--    end case;
  DBMS_OUTPUT.put_line( '북 아이디'||book_cursor.mem_id ||', 북 회원등급'|| book_cursor.rank||', 북 빌린개수'||book_cursor.bookcount );
  end loop;
  end;
  /
-- 회원등급에따라서  컬럼 7 


  
  
  select* from rental;
  update RENTAL set rent_status='연체',rent_enddate=sysdate-20,rent_startdate=sysdate-100 where rent_num=2;
  
  from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
  select mem_id, rent_enddate,rent_startdate  from rental where rent_enddate in(select min(rent_enddate) from rental group by mem_id) and rent_enddate<  sysdate and rent_status!='반납' ; 
  SELECT * FROM (select min(rent_enddate),mem_id  from rental WHERE rent_enddate< sysdate and rent_status!='반납' group by mem_id) b where ;
  
  
  
  
  select * from rental in (select ;
  alter table rental add rent_status varchar2(30) default '반납';
  alter table rental drop column rent_status;
  select * from rental;
  update 
  SELECT * FROM MEMBER;
SET SERVEROUTPUT ON ;
  
--위와 같지만 특정한값
select * from book;
select * from 
select  distinct mem_id ,랭크,빌린개수
from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent ,r.mem_id  ,c.mem_rank 랭크  ,count(*) OVER(PARTITION BY r.mem_id) 빌린개수
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                  and rental.mem_id = '12'   and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id  )  ;
            
select      
            
    
    select * from member;

--대여 판단 테이블 
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent
            from  (select * from book order by book_num desc) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num));
            
      
      
     
      --if문 for문에 쓸것      
declare 
 aa varchar2(10);
 ab varchar2(30);
 begin
 for i in 1..2 loop
 aa:='트루';
 ab:='트루';
 end loop;
 
  if aa='트루' and ab='트루' then 
  DBMS_OUTPUT.put_line( aa||ab );
  end if;
 end;
 --for문안에 break문
 
 select rent_status from rental;
 /
 declare 
 aa varchar2(10);
 ab varchar2(30);
 cursor temp is select * from rental;
 begin
 for i in temp loop
 aa:='트루';
 ab:='트루';
 DBMS_OUTPUT.put_line( aa||ab );
 if i.rent_status='연체' then 
 DBMS_OUTPUT.put_line( '연체연체' );
 end if;
 exit when i.rent_status='연체';                
 end loop;
 
  if aa='트루' and ab='트루' then 
  DBMS_OUTPUT.put_line( aa||ab );
  end if;
 end;
 /
     
  
--        rank   rental.mem_id = '12'
--        
--        3 대출 상태 불가능 
--        2 대출 상태   0 <5 and     연체일보다 전날인지 
--        1 대출 상태   0 <10 and     연체일보다 전날인지
--        
        desc book;
        desc rental;
        select  
        case  when rent_extension= 'X' then '연장가능 '
        else  '연장불가능'
         end as status     
        from rental;
        
        
        
        select rent_extension from rental;
        select * from book;
        
         
        
            
--  전체 출력 되는거
select * --distinct   r.mem_id
from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
          r.mem_id 회원아이디,c.mem_rank , decode(rent_enddate,'o','대여중','대여가능') rent, '대출불가능' 대출상태
            from  (select * from book order by book_num desc) b  
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                    and  rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id)   ;
            select * from member;
            select * from member ;
    
  -- 예약o   -> rent 대여불가능 
  -- 예약o   rent 예약중   reser주인 o   대출상태-> 대여 가능. 
  -- 예약o   rent 예약중   reser주인 x   대출상태 -> 대여불가능.
    
    
    
    
    
    select count(rental.mem_id)   from rental group by rental.mem_id;
    count(mem_id),~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
    
    select * from rental;
    

            select * from rental;

            
            select count(rent_num) from rental group by mem_)i;
            
            
-- 






--


-- 








--
create table book_category ( --도서분류
    book_ctgr_num varchar2(100) , --분류기호
    book_ctgr_name varchar2(200)  --분류명
    --constraint book_category_num_pk PRIMARY KEY (category_num)
);
drop table book_category;
select * from book_category;


commit;
insert into book VALUES('1a11', 'aa', 'bb', 'abc', sysdate, '11abc111', 'X', '1', '예약가능');
insert into book VALUES('2b22', 'aaa', 'bbb', 'ccc', sysdate, '22abc222', 'X', '2', 'X');
select * from b;
select * from rental;
 (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num));
 
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '예약대기', '예약중') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '대여가능', '대여중') rent 
			from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
			join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num;
delete from book where book_rsrv_status = '선택';
delete from rental where book_num='입력';
commit;
select * from book;
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '예약대기', '예약중') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '대여가능', '대여중') rent 
from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate 
from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate 
from (select * from book where book_name like '%b%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate from 
(select * from book where book_author like '%a%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate from 
(select * from book where book_pub_house like '%c%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;
commit;


select * from book where book_author like '%a%' or book_name like '%a%' or book_pub_house like  '%a%';
select * from book where book_author like 'a' or book_name like 'a' or book_pub_house like 'a' ;
select * from book where book_name like '%b%'; 
select * from book where book_author like '%aa%';
select * from book where book_pub_house like  '%a%'; 
drop table book;
select * from book;
select * from rental;
create table appendix ( --부록
    apdx_code varchar(30),--부록코드
    apdx_book_num varchar2(30), --도서번호
    apdx_name varchar(50) --부록명
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);
drop table appendix;
select * from appendix;
insert into member values('12', '123', '문혜수수','1111111-2222222', '서울', '010-1234-5678', 'aa@aa.com', 2);
create table member( -- 회원
    mem_id varchar2(20), --회원번호
    mem_pw varchar2(30), --회원비밀번호
    mem_name varchar2(20), --회원이름 
    mem_jumin varchar2(30), --주민번호
    mem_address varchar2(200), --회원주소
    mem_phone varchar2(30), --회원폰번호
    mem_email varchar2(30), --회원이메일
    mem_rank number --회원 등급
   --constraint member_pk primary key (m_id)
);
drop table member;
select * from member;

select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '예약가능', '예약중') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '대여가능', '대여중') rent 
			from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
			join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num 
			where rownum > 0 and rownum <= 5;

select * from rental;            
select * from book;
delete from rental;
commit;
delete from rental where mem_id='1';
insert into rental values('1', 100001, '12', sysdate-1, null, 'X', 'X');
insert into rental values('1', 100003, '12', sysdate-1, null, 'X', 'X');
insert into rental values('1', 100002, '1', sysdate-1, sysdate, 'X', 'X');
select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, '대여가능', '대여중') rent
    from book b
    join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id like '1')  r  
    on b.book_num = r.book_num;
    select nvl(max(rent_num)+1,1) from rental where book_num = 100001;
create table rental (
    rent_num number, --대여번호
    book_num number, --도서번호
    mem_id varchar2(20), --회원번호
    rent_startdate date, --대여일
    rent_enddate date, --반납일
    rent_appendix_status varchar2(10), --부록대출여부
    rent_extension varchar2(10) --대여연장
   -- constraint  rent_num_pk PRIMARY KEY (rent_num),
    --constraint rent_book_num_fk foreign key (book_num) 
    --references book (book_num),
    --constraint rent_fk foreign key (mem_id)   
    --references member (mem_id)
);
drop table rental;
select * from rental;
delete rental where rent_num=2;
commit;
drop table reservation;
create table reservation (
    rent_num varchar(30), -- 대여번호
    mem_id varchar2(20), --회원번호
    rsrv_num number(20),   --예약번호
    book_num  number(20)
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);
drop table reservation;
select * from reservation;
select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
		            decode(rent_enddate,'o','대여중','대여가능') rent
		            from  (select * from book order by book_num desc) b
		            join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
		                    and rental.mem_id =12 and rental.rent_enddate is null)  r  
		            on (b.book_num = r.book_num));
 select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
		            decode(rent_enddate,'o','대여중','대여가능') rent
		            from  (select * from book where book_num =100005) b
		            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental  group by book_num)  and rent_num in (select max(rent_num) from rental  group by book_num) ) r  
		            on (b.book_num = r.book_num));                   
select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental  group by book_num) and rent_num in (select max(rent_num) from rental  group by book_num) ;            
select * from rental where rent_startdate in (select max(rent_startdate) from rental  group by book_num);      
select * from rental;
desc rental;

drop table book_category;
select * from book_category;
drop table book;
create table book ( --도서
    book_num number, --도서번호
    book_author varchar2(50), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50), --출판사
    book_pub_date date, --발행일
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --부록여부
    book_ctgr_num varchar2(100), --분류기호
    book_rsrv_status varchar2(50), --예약여부
    book_rent_cnt number, --대출 횟수
    book_input_date date --입력일
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);
select * from book;
update book set book_rent_cnt = (select book_rent_cnt from book where book_num = 100001) + 1 where book_num = 100001  ;
update book set book_rent_cnt = book_rent_cnt+1 where book_num = 100001  ;
drop table new_book;
create table new_book ( --도서 구입 신청 테이블
    new_book_num number, --신간 신청 번호
    book_author varchar2(50), --저자
    book_name varchar2(200), --도서명
    book_pub_house varchar2(50) --출판사
);
create table discard_book ( --도서 폐기 신청 테이블
       dis_book_num number, --폐기 신청 번호
       book_num number --도서번호
);
commit;
rollback;
select * from discard_book;
select book_num, book_author, book_name, book_pub_house, book_input_date from book  where book_num = (select book_num from discard_book where book_num = 100001);
drop table discard_book;
insert into discard_book values ((select nvl(max(dis_book_num)+1,1) from discard_book), 100004);
drop table book;
select * from book;
delete from rental;
select nvl(max(book_num)+1,1000001) from book;
delete from book;
commit;
delete from book where book_num='입력';
insert into book VALUES(100004, 'aa', 'bb', 'abc', sysdate, '11abc111', 'X', '1', '예약가능',2, sysdate);
insert into book VALUES(nextval(book_num), 'aa', 'bb', 'abc', sysdate, '11abc111', 'X', '1', '예약가능');
insert into book VALUES('2b22', 'aaa', 'bbb', 'ccc', sysdate, '22abc222', 'X', '2', '예약가능');
update book set book_rsrv_status='예약가능' where book_rsrv_status='X';
select * from book;
select * from rental;
 (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num));
 ----------------------------------------------------------------------------------------------------------------------------------------
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date,
            decode(rent_enddate,'o','대여중','대여가능') rent
			from  (select * from book where book_name like '%입력%' or book_author like '%입력%' or book_pub_house like '%입력%') b 
			left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num;
------------------------------------------------지금 select--------------------------------------------------------------------------------------------------------------        
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent
            from  (select * from book order by book_num desc) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num))
       where rnum > 2;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------            
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent
			from  (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
			left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num;
-------------------------고객
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name,  book_input_date,
            decode(rent_enddate,'o','대여중','대여가능') rent
            from  (select * from book order by book_num desc) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num))
            where book_input_date<= sysdate and book_input_date >=sysdate-30
            and rnum > 10 and rnum <=20;    
---------------------신간도서--------------------------------------------------------------------------------------------------------               
select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date, book_rent_cnt, 
		            decode(rent_enddate,'o','대여중','대여가능') rent
		            from   (select * from book order by book_input_date desc) b
		            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
		            on (b.book_num = r.book_num) 
                    where rownum<=20)
                     where book_input_date<= sysdate and book_input_date >=sysdate-30 
                        and rnum >20 and rnum <= 25;
---------------------최다대여-----------------------------------------------------------------------------------------------------------------------    
  select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date, book_rent_cnt,
		            decode(rent_enddate,'o','대여중','대여가능') rent
		            from   (select * from book order by book_rent_cnt desc) b
		            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
		            on (b.book_num = r.book_num)  where rownum <= 20 )
                   where book_input_date<= sysdate and book_input_date >=sysdate-30;
                   
---------------- 대여 도서 검색 ----------------------------------------------------------------------------------------------------------------------------------------  
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date,
            decode(rent_enddate,'o','대여중','대여가능') rent
            from  (select * from book where book_num = 1000001) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num));
--rentmemBookcheck
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','대여중','대여가능') rent
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                    and rental.mem_id = '12' and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num));            
            
select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date,
		            decode(rent_enddate,'o','대여중','대여가능') rent
		            from  (select * from book order by book_num desc) b
		            join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
		                    and rental.mem_id = #{ mem_id } and rental.rent_enddate is null)  r  
		            on (b.book_num = r.book_num))
                    
------------------신간요청도서-----------------------------------------------------------------------------------------------------------------------------------------------------         
select * from new_book;


select * from member where mem_id like '12';

select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
		            decode(rent_enddate,'o','대여중','대여가능') rent
		            from  (select * from book where book_num =100005) b
		            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
		            on (b.book_num = r.book_num));
                    
select * from 
    (select rownum r, book_num, book_name, book_author, book_rent_cnt from book order by book_rent_cnt desc)                     
    where r<20;
select b.book_num
        from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
			join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on b.book_num not in ('a');
delete from book where book_rsrv_status = '선택';
delete from rental where book_num='입력';
commit;
select * from rental;
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '예약대기', '예약중') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '대여가능', '대여중') rent 
from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate 
from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate 
from (select * from book where book_name like '%b%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate from 
(select * from book where book_author like '%a%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;

select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, 'n', 'y') rent, rent_startdate from 
(select * from book where book_pub_house like '%c%') b 
join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
on b.book_num = r.book_num;
commit;


select * from book where book_author like '%a%' or book_name like '%a%' or book_pub_house like  '%a%';
select * from book where book_author like 'a' or book_name like 'a' or book_pub_house like 'a' ;
select * from book where book_name like '%b%'; 
select * from book where book_author like '%aa%';
select * from book where book_pub_house like  '%a%'; 
drop table book;
select * from book;
select * from rental;
create table appendix ( --부록
    apdx_code varchar(30),--부록코드
    apdx_book_num varchar2(30), --도서번호
    apdx_name varchar(50) --부록명
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);
drop table appendix;
select * from appendix;

select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '예약가능', '예약중') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '대여가능', '대여중') rent 
			from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
			join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num 
			where rownum > 0 and rownum <= 5;

select * from rental;            
select * from book;
select * from rental;
commit;
delete rental;
commit;
insert into rental values('1', '2b22', 'asdf', sysdate, sysdate-1, 'n', 'n');
update rental set rent_enddate=null where rent_num='1';
update rental set rent_enddate = sysdate where book_num = 100003;
insert into rental values('1', '1a11', 'asdf', sysdate-1, sysdate-1, 'n', 'n');
insert into rental values('입력' , '입력', '입력',null, null, 'n', 'n');
create table rental (
    rent_num varchar(30), --대여번호
    book_num varchar2(30), --도서번호
    mem_id varchar2(20), --회원번호
    rent_startdate date, --대여일
    rent_enddate date, --반납일
    rent_appendix_status varchar2(10), --부록대출여부
    rent_extension varchar2(10) --대여연장
   -- constraint  rent_num_pk PRIMARY KEY (rent_num),
    --constraint rent_book_num_fk foreign key (book_num) 
    --references book (book_num),
    --constraint rent_fk foreign key (mem_id)   
    --references member (mem_id)
);
drop table rental;
select * from rental;
delete rental where rent_num=2;
                    
create table reservation (
    rent_num varchar(30), -- 대여번호
    mem_id varchar2(20), --회원번호
    rsrv_num number(20)   --예약번호
    
    --constraint reservation_rent_num_fk FOREIGN KEY (rent_num)
    --REFERENCES rental (rent_num),
    --constraint reservation_mem_id_fk FOREIGN KEY (mem_id)
    --REFERENCES member (mem_id)
);
drop table reservation;
select * from reservation;


 is null = 0 
--select
select * from rental order by rent_num desc;





select * from new_book ;

select * from salary_management;
