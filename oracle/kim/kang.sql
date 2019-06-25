--kang--
create  table tt(
id number
);
--데이터 확인.

select*from tt;
insert into tt values(1);

--select*from kim.emp2; --grant줬기떄문에 emp2는 불가능 emp는 가능.
select*from kim.emp;
delete from kim.emp;  --됨.
grant select on kang.tt  to kim;