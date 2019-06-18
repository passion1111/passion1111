select * from tab;

create table SampleTable (
    num number,
    name varchar2(20),
    phone VARCHAR2(15),
    address VARCHAR2(50)
);

select * from sampletable; -- 전체 보기 

select name, address from sampletable; -- 특정 필드만 보기

desc sampletable;  -- 해당 테이블 구조 보기



