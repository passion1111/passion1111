--kang--
create  table tt(
id number
);
--������ Ȯ��.

select*from tt;
insert into tt values(1);

--select*from kim.emp2; --grant��⋚���� emp2�� �Ұ��� emp�� ����.
select*from kim.emp;
delete from kim.emp;  --��.
grant select on kang.tt  to kim;