--Ŀ�� ���ε� 

create table test3(
    val number,             --���� ����.
    varc varchar2(30),   -- varc�� �����ߴµ� �Ⱥ��� ����� �ݳ� ���ǿ� �ʿ��� ����. 
    grou number            -- group  å 
);

insert into test3 values(1,'a',1);
insert into test3 values(2,'a',1);
insert into test3 values(3,'a',1);
insert into test3 values(4,'a',1);
insert into test3 values(1,'not',2);
insert into test3 values(2,'not',2);
insert into test3 values(3,'not',2);
insert into test3 values(4,'not',2);
insert into test3 values(1,'not',3);
insert into test3 values(2,'not',3);
insert into test3 values(3,'not',3);
insert into test3 values(4,'not',3);
insert into test3 values(5,'not',3);


select * from test3;

drop table test3;

declare


begin
    for ho in (select * from test3)
    loop
    DBMS_OUTPUT.put_line('���� ?   '||ho.val);
    
    end loop;
   
end;
/


declare
 cursor ho is select * from test3;
   ho2 test3%rowtype;
begin
    open ho;
    loop
    fetch ho into ho2;
 exit when  ho%notfound;

   DBMS_OUTPUT.put_line('�ο� ī��Ʈ : '||ho%rowcount );
--    
--    end loop;
 
end loop;
   DBMS_OUTPUT.put_line('�������ο� : '||ho%rowcount );

 close ho;   
end;
/

--���� ���� ���� ¥����.
declare 
    hoho number;

begin

for ho in (select  * from test3) loop
   DBMS_OUTPUT.put_line('3  val '||ho.val  );    --�ݳ� ���� ����� 
    select count(*) into hoho  from test3           where val=ho.val;   --���� ���� �����
        for i in 1..hoho  loop
        DBMS_OUTPUT.put_line('4' );
        end loop;
    
    
end loop;
end;
/
--Ŀ���� ������� ¥��.

--�ݳ� ó�� �Ǵ� 
declare 
    hoho number;
    ho sys_refcursor;
    ho2 test3%rowtype;
begin
    
   open ho for select  * from test3 where varc in('not') and val=1; --�ݳ� ���� ����� ���   out������ �Ѹ���.
loop
 fetch ho into ho2;  -- �׳� �����Ҵ��ص� ��������.  ho2.grou�� 
  exit when ho%notfound;
  
   -- ���ο� ���ν��� �ϳ��� ������ ������.
    select  count(*) into hoho  from test3 where grou=ho2.grou;   --���� ���� �����
    update test3 set val=0 where val=1 and varc in('not'); 
   DBMS_OUTPUT.put_line('3  val '||ho2.val  || 'ho���ν��� �� ��' || hoho);    --�����ߴµ� �Ⱥ��� �����.

   
        for i in 1..hoho  loop
        update test3 set val=i where val=i+1  and varc in('not');
        DBMS_OUTPUT.put_line('����� = '||i ||'�׸��� ho2�� val= '||ho2.val );
      -- Ȯ��  insert into test3(val) values(i+1);
        end loop;
    
    
end loop;
close ho;
end;
/


select * from test2;
drop table test3;
alter table test3 add(hoho varchar2(30));
select * from test3;








--
CREATE OR REPLACE PROCEDURE MY_PROC(  V_NUMBER IN NUMBER,P_RC OUT SYS_REFCURSOR )  
AS  
BEGIN  
    OPEN P_RC  
    FOR SELECT *  
         FROM test3;  
END;  
  /
-- Ȯ�� ���ν���  
CREATE OR REPLACE FUNCTION MY_PROC_TEST(V_NUMBER IN NUMBER) RETURN SYS_REFCURSOR  
AS  
    P_RC SYS_REFCURSOR;  
BEGIN  
    MY_PROC(V_NUMBER,P_RC);  
    RETURN P_RC;  
END;  
/

--�Լ� ��ȹ���
select my_proc_test(2) from dual;


select * from test3 where varc in ('not');
insert into test3 values(5,'not');
delete from test3;
