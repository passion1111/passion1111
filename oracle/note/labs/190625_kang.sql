-- kang ������ ---
create table tt (
    id number
);

select * from "kang".tt;
insert into tt values(1);
insert into tt values(2);
commit;

select * from kingsmile.emp;
delete from kingsmile.emp;

-- �Ϲݻ���ڴ� �ڽ��� �ο� ���� ���ѿ� ���ؼ��� �����Ҽ� �ִ�.
grant select on "kang".tt to kingsmile;
grant delete on "kang".tt to kingsmile;



