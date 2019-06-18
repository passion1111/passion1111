select * from tab;
select*from help;

create table SampleTable (
    num number,
    name varchar2(20),
    phone varchar2(15),
    address varchar2(50)
);
select *from Sampletable;   --전체 보기

select name, address from sampletable; --특정 필드만 보는것 

desc sampletable;  --해당 테이블 구조보기

---insert ---------

insert into sampletable VALUES(10, 'doyeon',  '010-9872-0202',   '서울' );                             --그냥 쓸떄는 넣었던 순서대로 넣어야한다.
insert into sampletable VALUES(20, '강감찬',  '010-5656-0244',   '경기' );   

insert into sampletable(name,phone,address,num) VALUES('영희', '010-999-9999', 'jeju',30);
insert into sampletable(name,phone) VALUES('하하하', '010-555-744');


update sampletable set address ='대구';                            --4개행 다바뀜 전체 수정된다.
ROLLBACK;                          --롤백으로 돌아감 근데 다 초기화됨.  위에 insert부분 긁어서 실행하면한번에 실행됨.
update sampletable set address='대구'where num=30;               --where절로 필요한 30번에 있는것만 바꿈.
update sampletable set phone='010-5555-5555', num=40 ,address='경기'where name='하하하';

--record 삭제는 delete

delete sampletable; --전체 다 삭제됨. 테이블은 남음

delete sampletable where address ='jeju';  --제주 사라짐 조건에 맞는것이 사라진다는것.
delete sampletable where num between 10 and 20; --해당하는 사이값 지움  

drop table sampletable; --테이블 자체를 지워버림




