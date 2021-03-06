
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
trarep_numref,trarep_numref_lv) values(7,1,sysdate,'안녕','첫번쨰',6,0,1,0);
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