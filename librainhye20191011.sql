select * from rental;
select * from book;
select * from member;
select * from rental;

select * from member;
select * from rental;
                 --������������ �ʿ�
                 --���Ⱑ�ɻ���
drop table book;

create table book ( --����
    book_num number, --������ȣ
    book_author varchar2(150), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50), --���ǻ�
    book_pub_date date, --������
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --�ηϿ���
    book_ctgr_num varchar2(100), --�з���ȣ
    book_rsrv_status varchar2(50), --���࿩��
    book_rent_cnt number, --���� Ƚ��
    book_input_date date, --�Է���
    book_ctgr_num_db varchar2(100) --���� �з��� ���� �з���ȣ ��
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);
desc book;
select * from book;
select * from rental;

select * from reservation;
desc member;
ALTER table member modify(DEADLINE_RENT_STOP date,book_loanable varchar2(20) default '���Ⱑ��');
select * from member;
update member set deadline_rent_stop=null where mem_id=1;


--���� ���� �ش� �����  
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


-- ���� ��ü�����ÿ� mem_rank 


--ȸ���˻������� 67
select mem_id,mem_name,mem_phone,mem_address,mem_email,mem_rank,book_loanable, deadline_rent_stop ,
                                                                case when deadline_rent_stop>sysdate and book_loanable='���Ⱑ��' then 0
                                                                else
                                                                      case when mem_rank=2 then 7  -- ����Ұ� �Ǵ�
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end
                                                                end      LOANABLE_NUMBER ,
                                                                case when deadline_rent_stop>sysdate and book_loanable='���Ⱑ��' then 0
                                                                else       
                                                                      case when mem_rank=2 then 7 
                                                                      when mem_rank=3 then 5
                                                                      when mem_rank=0 then 12
                                                                      else 0 end    -(select count(*) from rental where mem_id='nmj' and rent_status='�뿩��')
                                                                end     ����뿩���ɱǼ� from member;
                                                                
                                                                          select * from reservation;
                                                                
                                                                desc member;
                                                                
 
 
 select * from rental;
 
 
 
 
                        update member set book_loanable='���Ⱑ��';                                    
                                    
 select * from member;
 select * from reservation;
 select  * from reservation;
                                    
select * from member;                                   
 
                  --��� 
                
                
                   --�θ��°� �ٸ��� �Ұ�.   book/rent.do���� ȸ���˻������� ���� �ҷ��ð�.  -- ������� 1���ϋ� insert into rental �� 1�� ���������� ����.
                    select  distinct rental.book_num,
                        case when rent_status='�뿩��' then '�뿩��'
                             when rent_status='������' then case when reservation.mem_id=rental.mem_id then '�뿩����'
                                                            else '������'  end
                             end ���⿩��      --�������̸� �뿩�����̶�� ����.                            
                   ,book_name,book_author,book_pub_house
                    ,case when rent_extension='X' then '���尡��'
                        else '����Ұ���' end ���忩��
                        --book_rsrv_status�߿� ���� ������ 
--                       case when  book_rsrv_status ='���డ��'  then 
--                                                                                    --�� �⺻���� 1?
--                                                                    case when   then '�������Դϴ�'
--                                                                                                    else  case when    (  case when rent_status='�뿩��' then '�뿩��'
--                                                                                                                             when rent_status='������' then case when reservation.mem_id=rental.mem_id then '�뿩����'
--                                                                                                                                                            else '������'  end
--                                                                                                                             end)='�뿩��' then '�̴̹뿩���Դϴ�' else '���డ��' end  end
--                           end ���࿩��
            ,to_char(rent_enddate,'yyyymmdd') rent_enddate       from book join rental on book.book_num=rental.book_num left  outer join  reservation on reservation.mem_id=rental.mem_id ;
                    -- �մܿ��� extension�� o�̸� ����Ұ��� 
                    
                    --�̹� �������̸� ajax�� ���ప üũ 
                    
                    
                    
                    --�ݳ� 
                    
                    
                    --�����ϱ� �����ϱ�� ��ư�ϳ��θ� �Ǵ�. 
                    
                    
                    
                    --
                    select * from reservation;
                    
                    select * from rental;
                    select 
                    select * from reservation;
                    
                    select count(*) over(partition by book_num) from reservation;
                    select * from reservation;
        
                    select * from rental;
                    
                    
                    
                    select * from book join rental on book.book_num=rental.book_num ;
                    
                    
                    --reservation�� �߰��Ⱦֵ鸸 Ȯ��.
                  select * from reservation;
                  select * from rental;
                  
                  select * from rental full join reservation on reservation.mem_id=rental.mem_id;
                  select * from book;
                                                        100002
                  insert into reservation values(3,'nmj',1,100003);
                insert into rental values(3,100003,'nmj',null,null,'X','X','������');
                  select * from rental;
                  select * from rental;
                  
                  select * from book;  
                  
                  
                  
                  
                  
                  
                  
                    
                    select * from rental;
                    select * from reservation;
                    
                                        --���� �Ϸ�����ÿ�
                                    select * from rental;
                                    rental_status ������ =mem_id == 
                                    
                                    
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
                                                 -- �ݳ��� 
                                                 
                                                 
                                                    --�ش�ȸ�� ����å�ݳ�.  rent_enddate not null 
                                                    select * from rental;
                                                 --1. �ش� ȸ���� ���� å  �ݳ���  rent_enddate    null  rent_status �ݳ� 
                                                 select * from reservation;
                                                 select * from member join rental on member.mem_id=rental.mem_id  where member.mem_id=1 and rent_status='�뿩��' or rent_status='������'  ;
                                               
                                               select * from reservation;
                                               delete * from 
                                               
                                                    
                                                    --mem_id
                                                       select * from test2;
                                                       select * from rental;
                                                       select * from reservation;
                                                      select * from book;
                                                                      select * from member;
                                                                      select count(*) from rental where mem_id=1 and rent_status='�뿩��';
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
            decode(rent_enddate,'o','�뿩��','�뿩����') rent ,r.mem_id  ,c.mem_rank rank  ,count(*) OVER(PARTITION BY r.mem_id) bookcount
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
            decode(rent_enddate,'o','�뿩��','�뿩����') rent ,r.mem_id  ,c.mem_rank rank  ,count(*) OVER(PARTITION BY r.mem_id) bookcount
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                     and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id  );
       
       
            
 declare           
cursor b_bookstatus is
select *-- distinct mem_id ,rank,bookcount
from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','�뿩��','�뿩����') rent ,r.mem_id  ,c.mem_rank rank  ,count(*) OVER(PARTITION BY r.mem_id) bookcount
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                     and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id  );

begin
 for book_cursor in b_bookstatus loop
 
--    case 
--        when cc.facin_name='����������' then 
--             update Facilities_inspection set FacIn_INSPECTION_DATE=sysdate,FacIn_SCHEDULED_INSPECTION_DATE=sysdate+90 where facin_name=cc.facin_name;
--    else
--    end case;
  DBMS_OUTPUT.put_line( '�� ���̵�'||book_cursor.mem_id ||', �� ȸ�����'|| book_cursor.rank||', �� ��������'||book_cursor.bookcount );
  end loop;
  end;
  /
-- ȸ����޿�����  �÷� 7 


  
  
  select* from rental;
  update RENTAL set rent_status='��ü',rent_enddate=sysdate-20,rent_startdate=sysdate-100 where rent_num=2;
  
  from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
  select mem_id, rent_enddate,rent_startdate  from rental where rent_enddate in(select min(rent_enddate) from rental group by mem_id) and rent_enddate<  sysdate and rent_status!='�ݳ�' ; 
  SELECT * FROM (select min(rent_enddate),mem_id  from rental WHERE rent_enddate< sysdate and rent_status!='�ݳ�' group by mem_id) b where ;
  
  
  
  
  select * from rental in (select ;
  alter table rental add rent_status varchar2(30) default '�ݳ�';
  alter table rental drop column rent_status;
  select * from rental;
  update 
  SELECT * FROM MEMBER;
SET SERVEROUTPUT ON ;
  
--���� ������ Ư���Ѱ�
select * from book;
select * from 
select  distinct mem_id ,��ũ,��������
from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','�뿩��','�뿩����') rent ,r.mem_id  ,c.mem_rank ��ũ  ,count(*) OVER(PARTITION BY r.mem_id) ��������
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                  and rental.mem_id = '12'   and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id  )  ;
            
select      
            
    
    select * from member;

--�뿩 �Ǵ� ���̺� 
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','�뿩��','�뿩����') rent
            from  (select * from book order by book_num desc) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num));
            
      
      
     
      --if�� for���� ����      
declare 
 aa varchar2(10);
 ab varchar2(30);
 begin
 for i in 1..2 loop
 aa:='Ʈ��';
 ab:='Ʈ��';
 end loop;
 
  if aa='Ʈ��' and ab='Ʈ��' then 
  DBMS_OUTPUT.put_line( aa||ab );
  end if;
 end;
 --for���ȿ� break��
 
 select rent_status from rental;
 /
 declare 
 aa varchar2(10);
 ab varchar2(30);
 cursor temp is select * from rental;
 begin
 for i in temp loop
 aa:='Ʈ��';
 ab:='Ʈ��';
 DBMS_OUTPUT.put_line( aa||ab );
 if i.rent_status='��ü' then 
 DBMS_OUTPUT.put_line( '��ü��ü' );
 end if;
 exit when i.rent_status='��ü';                
 end loop;
 
  if aa='Ʈ��' and ab='Ʈ��' then 
  DBMS_OUTPUT.put_line( aa||ab );
  end if;
 end;
 /
     
  
--        rank   rental.mem_id = '12'
--        
--        3 ���� ���� �Ұ��� 
--        2 ���� ����   0 <5 and     ��ü�Ϻ��� �������� 
--        1 ���� ����   0 <10 and     ��ü�Ϻ��� ��������
--        
        desc book;
        desc rental;
        select  
        case  when rent_extension= 'X' then '���尡�� '
        else  '����Ұ���'
         end as status     
        from rental;
        
        
        
        select rent_extension from rental;
        select * from book;
        
         
        
            
--  ��ü ��� �Ǵ°�
select * --distinct   r.mem_id
from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
          r.mem_id ȸ�����̵�,c.mem_rank , decode(rent_enddate,'o','�뿩��','�뿩����') rent, '����Ұ���' �������
            from  (select * from book order by book_num desc) b  
            join (select book_num, nvl(to_char(rent_enddate),'o' ) rent_enddate,mem_id from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                    and  rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num)  inner join (select mem_id,mem_rank from member) c on r.mem_id=c.mem_id)   ;
            select * from member;
            select * from member ;
    
  -- ����o   -> rent �뿩�Ұ��� 
  -- ����o   rent ������   reser���� o   �������-> �뿩 ����. 
  -- ����o   rent ������   reser���� x   ������� -> �뿩�Ұ���.
    
    
    
    
    
    select count(rental.mem_id)   from rental group by rental.mem_id;
    count(mem_id),~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    
    
    select * from rental;
    

            select * from rental;

            
            select count(rent_num) from rental group by mem_)i;
            
            
-- 






--


-- 








--
create table book_category ( --�����з�
    book_ctgr_num varchar2(100) , --�з���ȣ
    book_ctgr_name varchar2(200)  --�з���
    --constraint book_category_num_pk PRIMARY KEY (category_num)
);
drop table book_category;
select * from book_category;


commit;
insert into book VALUES('1a11', 'aa', 'bb', 'abc', sysdate, '11abc111', 'X', '1', '���డ��');
insert into book VALUES('2b22', 'aaa', 'bbb', 'ccc', sysdate, '22abc222', 'X', '2', 'X');
select * from b;
select * from rental;
 (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num));
 
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '������', '������') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '�뿩����', '�뿩��') rent 
			from (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
			join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num;
delete from book where book_rsrv_status = '����';
delete from rental where book_num='�Է�';
commit;
select * from book;
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '������', '������') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '�뿩����', '�뿩��') rent 
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
create table appendix ( --�η�
    apdx_code varchar(30),--�η��ڵ�
    apdx_book_num varchar2(30), --������ȣ
    apdx_name varchar(50) --�ηϸ�
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);
drop table appendix;
select * from appendix;
insert into member values('12', '123', '��������','1111111-2222222', '����', '010-1234-5678', 'aa@aa.com', 2);
create table member( -- ȸ��
    mem_id varchar2(20), --ȸ����ȣ
    mem_pw varchar2(30), --ȸ����й�ȣ
    mem_name varchar2(20), --ȸ���̸� 
    mem_jumin varchar2(30), --�ֹι�ȣ
    mem_address varchar2(200), --ȸ���ּ�
    mem_phone varchar2(30), --ȸ������ȣ
    mem_email varchar2(30), --ȸ���̸���
    mem_rank number --ȸ�� ���
   --constraint member_pk primary key (m_id)
);
drop table member;
select * from member;

select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '���డ��', '������') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '�뿩����', '�뿩��') rent 
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
select b.book_num, book_author, book_pub_house, book_name, nvl2(rent_enddate, '�뿩����', '�뿩��') rent
    from book b
    join (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) and rental.mem_id like '1')  r  
    on b.book_num = r.book_num;
    select nvl(max(rent_num)+1,1) from rental where book_num = 100001;
create table rental (
    rent_num number, --�뿩��ȣ
    book_num number, --������ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rent_startdate date, --�뿩��
    rent_enddate date, --�ݳ���
    rent_appendix_status varchar2(10), --�ηϴ��⿩��
    rent_extension varchar2(10) --�뿩����
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
    rent_num varchar(30), -- �뿩��ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rsrv_num number(20),   --�����ȣ
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
		            decode(rent_enddate,'o','�뿩��','�뿩����') rent
		            from  (select * from book order by book_num desc) b
		            join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
		                    and rental.mem_id =12 and rental.rent_enddate is null)  r  
		            on (b.book_num = r.book_num));
 select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
		            decode(rent_enddate,'o','�뿩��','�뿩����') rent
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
create table book ( --����
    book_num number, --������ȣ
    book_author varchar2(50), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50), --���ǻ�
    book_pub_date date, --������
    book_ISBN varchar2(50), --ISBN
    book_apdx_status varchar2(10), --�ηϿ���
    book_ctgr_num varchar2(100), --�з���ȣ
    book_rsrv_status varchar2(50), --���࿩��
    book_rent_cnt number, --���� Ƚ��
    book_input_date date --�Է���
    --constraint book_num_pk PRIMARY KEY (book_num) ,
    --constraint book_category_num_fk FOREIGN KEY (category_num)  
    --references book_category (category_num) 
);
select * from book;
update book set book_rent_cnt = (select book_rent_cnt from book where book_num = 100001) + 1 where book_num = 100001  ;
update book set book_rent_cnt = book_rent_cnt+1 where book_num = 100001  ;
drop table new_book;
create table new_book ( --���� ���� ��û ���̺�
    new_book_num number, --�Ű� ��û ��ȣ
    book_author varchar2(50), --����
    book_name varchar2(200), --������
    book_pub_house varchar2(50) --���ǻ�
);
create table discard_book ( --���� ��� ��û ���̺�
       dis_book_num number, --��� ��û ��ȣ
       book_num number --������ȣ
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
delete from book where book_num='�Է�';
insert into book VALUES(100004, 'aa', 'bb', 'abc', sysdate, '11abc111', 'X', '1', '���డ��',2, sysdate);
insert into book VALUES(nextval(book_num), 'aa', 'bb', 'abc', sysdate, '11abc111', 'X', '1', '���డ��');
insert into book VALUES('2b22', 'aaa', 'bbb', 'ccc', sysdate, '22abc222', 'X', '2', '���డ��');
update book set book_rsrv_status='���డ��' where book_rsrv_status='X';
select * from book;
select * from rental;
 (select * from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num));
 ----------------------------------------------------------------------------------------------------------------------------------------
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date,
            decode(rent_enddate,'o','�뿩��','�뿩����') rent
			from  (select * from book where book_name like '%�Է�%' or book_author like '%�Է�%' or book_pub_house like '%�Է�%') b 
			left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num;
------------------------------------------------���� select--------------------------------------------------------------------------------------------------------------        
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','�뿩��','�뿩����') rent
            from  (select * from book order by book_num desc) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num))
       where rnum > 2;
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------            
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','�뿩��','�뿩����') rent
			from  (select * from book where book_name like '%a%' or book_author like '%a%' or book_pub_house like '%a%') b 
			left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
			on b.book_num = r.book_num;
-------------------------��
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name,  book_input_date,
            decode(rent_enddate,'o','�뿩��','�뿩����') rent
            from  (select * from book order by book_num desc) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num))
            where book_input_date<= sysdate and book_input_date >=sysdate-30
            and rnum > 10 and rnum <=20;    
---------------------�Ű�����--------------------------------------------------------------------------------------------------------               
select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date, book_rent_cnt, 
		            decode(rent_enddate,'o','�뿩��','�뿩����') rent
		            from   (select * from book order by book_input_date desc) b
		            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
		            on (b.book_num = r.book_num) 
                    where rownum<=20)
                     where book_input_date<= sysdate and book_input_date >=sysdate-30 
                        and rnum >20 and rnum <= 25;
---------------------�ִٴ뿩-----------------------------------------------------------------------------------------------------------------------    
  select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date, book_rent_cnt,
		            decode(rent_enddate,'o','�뿩��','�뿩����') rent
		            from   (select * from book order by book_rent_cnt desc) b
		            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
		            on (b.book_num = r.book_num)  where rownum <= 20 )
                   where book_input_date<= sysdate and book_input_date >=sysdate-30;
                   
---------------- �뿩 ���� �˻� ----------------------------------------------------------------------------------------------------------------------------------------  
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date,
            decode(rent_enddate,'o','�뿩��','�뿩����') rent
            from  (select * from book where book_num = 1000001) b
            left outer join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num))  r  
            on (b.book_num = r.book_num));
--rentmemBookcheck
select * from
    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
            decode(rent_enddate,'o','�뿩��','�뿩����') rent
            from  (select * from book order by book_num desc) b
            join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
                    and rental.mem_id = '12' and rental.rent_enddate is null)  r  
            on (b.book_num = r.book_num));            
            
select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, book_input_date,
		            decode(rent_enddate,'o','�뿩��','�뿩����') rent
		            from  (select * from book order by book_num desc) b
		            join (select book_num, nvl(to_char(rent_enddate),'o') rent_enddate from rental where rent_startdate in (select max(rent_startdate) from rental group by book_num) 
		                    and rental.mem_id = #{ mem_id } and rental.rent_enddate is null)  r  
		            on (b.book_num = r.book_num))
                    
------------------�Ű���û����-----------------------------------------------------------------------------------------------------------------------------------------------------         
select * from new_book;


select * from member where mem_id like '12';

select * from
		    (select rownum rnum, b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN, book_apdx_status, book_rsrv_status, book_ctgr_num, 
		            decode(rent_enddate,'o','�뿩��','�뿩����') rent
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
delete from book where book_rsrv_status = '����';
delete from rental where book_num='�Է�';
commit;
select * from rental;
select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '������', '������') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '�뿩����', '�뿩��') rent 
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
create table appendix ( --�η�
    apdx_code varchar(30),--�η��ڵ�
    apdx_book_num varchar2(30), --������ȣ
    apdx_name varchar(50) --�ηϸ�
    --constraint apdx_code_pk PRIMARY KEY (apdx_code) ,
    --constraint appendix_book_name_fk foreign key (book_num)
    --REFERENCES book (book_num)
);
drop table appendix;
select * from appendix;

select b.book_num, book_author, book_pub_house, book_name, book_pub_date, book_ISBN,nvl2(book_apdx_status, 'O', 'X') book_apdx_status, nvl2(rent_enddate, '���డ��', '������') book_rsrv_status , book_ctgr_num, nvl2(rent_enddate, '�뿩����', '�뿩��') rent 
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
insert into rental values('�Է�' , '�Է�', '�Է�',null, null, 'n', 'n');
create table rental (
    rent_num varchar(30), --�뿩��ȣ
    book_num varchar2(30), --������ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rent_startdate date, --�뿩��
    rent_enddate date, --�ݳ���
    rent_appendix_status varchar2(10), --�ηϴ��⿩��
    rent_extension varchar2(10) --�뿩����
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
    rent_num varchar(30), -- �뿩��ȣ
    mem_id varchar2(20), --ȸ����ȣ
    rsrv_num number(20)   --�����ȣ
    
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
