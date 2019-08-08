
--거래 댓글 테이블
----------------
drop table trarep;
create table trarep(
    trarep_num number , -- 번호PK
    trarep_tranum number , -- 질문게시판 번호FK
    trarep_date date default sysdate, -- 작성날짜
    trarep_contents varchar2(4000), -- 내용
    trarep_writer varchar2(120) , -- 아이디FK
    trarep_writerrep number , -- 부모작성자 번호
    
    trarep_alive number default 0, -- 삭제유무
    trarep_numref number, -- 대댓글 유무
    trarep_numref_lv number -- 대댓글 순서
);
insert into trarep(trarep_num,trarep_tranum,trarep_date,trarep_contents,trarep_writer,trarep_writerrep,trarep_alive,
trarep_numref,trarep_numref_lv) values(1,1,sysdate,'안녕','qdw',1,0,0,0);  --첫 댓글
rollback;

insert into trarep(trarep_num,trarep_tranum,trarep_date,trarep_contents,trarep_writer,trarep_writerrep,trarep_alive,
trarep_numref,trarep_numref_lv) values(5,1,sysdate,'안녕','첫번쨰',2,0,1,3);
select*from trarep;
                                                --글번호                                       --대댓글유무        --레벨
select *from trarep where trarep_tranum=1 START WITH trarep_writerrep = 0 connect by prior trarep_num=trarep_writerrep order siblings by trarep_num desc;

select *from trarep where  trarep_tranum=1 order by trarep_writerrep desc, trarep_numref asc ,trarep_numref_lv asc;


qarep_num number constraint qarep_num_pk primary key, -- 번호PK
    qarep_qanum number constraint qarep_qanum_fk references qa(qa_num), -- 질문게시판 번호FK
    qarep_date date default sysdate, -- 작성날짜
    qarep_contents varchar2(4000), -- 내용
    qarep_writer varchar2(120) constraint qarep_writer_fk references mem(mem_id), -- 아이디FK
    qarep_writerrep number constraint qarep_writerrep_fk references qa(qa_num), -- 부모작성자 번호 
    qarep_alive number default 0, -- 삭제유무
    qarep_numref number, -- 대댓글 유무
    qarep_numref_lv number -- 대댓글 순서
);
trarep_num number , -- 번호PK
    trarep_tranum number , -- 질문게시판 번호FK
    trarep_date date default sysdate, -- 작성날짜
    trarep_contents varchar2(4000), -- 내용
    trarep_writer varchar2(120) , -- 아이디FK
    trarep_writerrep number , -- 부모작성자 번호
    
    trarep_alive number default 0, -- 삭제유무
    trarep_numref number, -- 대댓글 유무
    trarep_numref_lv number -- 대댓글 순서
commit;
insert into trarep(trarep_num,trarep_tranum,trarep_contents,trarep_writer,trarep_writerrep,trarep_numref,trarep_numref_lv) values(1,1,'1','아이디',1,1,1);
select* from trarep;
select count(*) from trarep where trarep_tranum=1 ;
desc trarep;

select * from trarep;
select count(*) from trarep where trarep_writerrep=2 and trarep_numref=1;

create table mem(
    mem_id varchar2(40) constraint mem_id_pk primary key, -- 아이디
    mem_pwd varchar2(32) not null, -- 비밀번호
    mem_ph varchar2(32), -- 전화번호
    mem_name varchar2(120), -- 이름   
    mem_addr varchar2(200), -- 주소
    mem_filename varchar2(520), -- 파일이름
    mem_point number default 100, -- 포인트
    mem_alive number default 0, -- 탈퇴유무
    mem_cdate date default sysdate, -- 가입날짜
    mem_ddate date -- 탈퇴날짜
);















create table tra(
    tra_num number , -- 번호PK
    tra_subject varchar2(300), -- 제목
    tra_readcount number, -- 조회수
    tra_date date default sysdate, -- 작성날짜
    tra_writer varchar2(120) , -- 아이디FK
    tra_filename varchar2(520), -- 파일이름
    tra_contents varchar2(4000), -- 내용
    tra_alive number, -- 삭제유무
    tra_head varchar2(9) -- 삽니다,팝니다
);
update tra set tra_subject='dd',tra_contents='dddd',tra_filename='dddd' where tra_num=1;
commit;
update tra set tra_readcount=tra_readcount+1 where tra_num=1;
select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,
    tra_head from(select * from tra order by tra_num desc))where 0<rnum ; 
    
    select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,
    tra_head from(select * from tra where tra_subject='22' order by tra_num desc))where 0<rnum ;

order by tra_num desc;
select * from tra;
insert into tra(tra_num,tra_subject,tra_readcount,tra_writer,tra_filename,tra_contents,tra_alive,tra_head) 
values(2,'22',1,'아이디','이름','내용',0,'삼');
select * from tra;



select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,tra_head from(select * from tra order by tra_num desc))where 5>=rnum and rnum>=0;

select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,
	                		   tra_head from(select * from tra order by tra_num desc))where 100>=rnum and rnum>=0;
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               
                               select *  from  (select rownum rnum,tra_num,tra_subject,tra_readcount,tra_date,tra_writer , tra_filename,tra_contents,     tra_head from(select * from tra  order by tra_num desc))where 5>=rnum and rnum>=0