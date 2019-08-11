------------
--회원 테이블
------------
select * from mem;
create table mem(
    mem_id varchar2(40) constraint mem_id_pk primary key, -- 아이디
    mem_pwd varchar2(32) not null, -- 비밀번호
    mem_ph varchar2(32), -- 전화번호
    mem_name varchar2(120), -- 이름   
    mem_addr varchar2(200), -- 주소
    mem_filename varchar2(520), -- 파일이름
    mem_point number default 100, -- 포인트
    mem_alive number default 1, -- 탈퇴유무(탈퇴:0)
    mem_cdate date default sysdate, -- 가입날짜
    mem_ddate date -- 탈퇴날짜
);