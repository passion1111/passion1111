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

--���� ���� ���� ¥����. �̿ϼ���
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

--�������1�ε� �뿩���ѻ���� ���.
declare 
    hoho number;
    ho sys_refcursor;
    ho2 test3%rowtype;
begin
    
   open ho for select  * from test3 where varc in('not') and val=1; --�뿩 ���� ����� ���   out������ �Ѹ���.
loop
 fetch ho into ho2;  -- �׳� �����Ҵ��ص� ��������.  ho2.grou�� 
  exit when ho%notfound;
  
   -- ���ο� ���ν��� �ϳ��� ������ ������.
    select  count(*) into hoho  from test3 where grou=ho2.grou;   --���� ���� �����
    update test3 set val=0 where val=1 and varc in('not');   -- varc�� enddate<sysdate�� �����  
   DBMS_OUTPUT.put_line('3  val '||ho2.val  || 'ho���ν��� �� ��' || hoho);    --�����ߴµ� �Ⱥ��� �����.

   
        for i in 1..hoho  loop
        update test3 set val=i where val=i+1  and varc in('not');
        DBMS_OUTPUT.put_line('����� = '||i ||'�׸��� ho2�� val= '||ho2.val );
      -- Ȯ��  insert into test3(val) values(i+1);
        end loop;  --foreach end loop
    
    
end loop;-- ho loop

--�ݳ���
--book���� �뿩�� �ٲ��Ŀ�

--reservation �ش� å count ���� 0���� Ŭ��쿡 


declare
hoho number;
begin
    



end;




close ho;
end;
/
-- �����Ŵ� �ð����� ������ ����°�

-- �Ʒ���  �����ڿ� ���� ����ð� ����          �׷�� å��ȣ   soo�� 5�̻��Ͻ� insert X 
declare 
soo number;
begin
 select count(*) into soo from test3 where grou=4 ;
    if soo<1 then 
                    DBMS_OUTPUT.PUT_LINE(sql%rowcount);
                    --end date sysdate+2������ �Է�
     insert into test3 values(soo+1, 'b',4);
    elsif  soo<5 then
        DBMS_OUTPUT.PUT_LINE(sql%rowcount);

                                    -- end date null �Է�
    insert into test3 values(soo+1, 'b',4);
    
       
    end if;
    DBMS_OUTPUT.PUT_LINE(sql%rowcount);
    
    -- ���� ���и޼��� ���Ÿ� if�� �����ϴ°Ϳ����� out parameter���� �ٸ��� �����ؼ� �����ߴٴ°��� �˷��ٰ�.
end;
/

select * from test3;

set serveroutput on;

insert into reservation(book_num,mem_id,rsrv_num,rsrv_enddate)       
values(100001,'1',(select count(rsrv_num)+1 from reservation where book_num=100001),sysdate);
-- �б� count>1 and count<=5
insert into reservation(book_num,mem_id,rsrv_num,rsrv_enddate)       
values(100001,'1',(select count(rsrv_num)+1 from reservation where book_num=100001),null);



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
