-- kang 접속자 ---
create table tt (
    id number
);

select * from "kang".tt;
insert into tt values(1);
insert into tt values(2);
commit;

select * from kingsmile.emp;
delete from kingsmile.emp;

-- 일반사용자는 자신이 부여 받은 권한에 한해서만 전파할수 있다.
grant select on "kang".tt to kingsmile;
grant delete on "kang".tt to kingsmile;



