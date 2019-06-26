select *from emp;
select*from emp;

declare e_name EMP.ENAME%type;
        e_sal EMP.SAL%type;
        
     BEGIN
        DBMS_OUTPUT.PUT_line('dkjfsddfj');
        select ename,sal into e_name,e_sal from emp where empno='7369';
        DBMS_OUTPUT.PUT_line('7782님의 이름은'||e_name||'급여는'||e_sal );
        
    end;
        /
        select*from emp;
        DECLARE NAME VARCHAR2(20) := '이효리';
         BEGIN
            DBMS_OUTPUT.put_Line('이효리'|| NAME); -- 출력
         END;
        
        
        create or replace procedure proc1
 is
  v_sal number;
 begin
   select sal into v_sal
   from emp
   where empno = 7788;

  dbms_output.put_line(v_sal);
 end;
  /
exec proc1;
declare 
   v_sal number;
 begin
   select sal into v_sal
   from emp
   where empno = 7788;
  
   dbms_output.put_line(v_sal);
  end;
  /

declare
    a NUMBER := 90 ;
    begin
        
        if(a>=90)then
             dbms_output.put_line('a is greater than 100');
            elsif(a>=80) then
              dbms_output.put_line('b is ');
    end if ;
    end ;
    
    DECLARE
      vn_num1 NUMBER := 1;
      vn_num2 NUMBER := 2 ;
    BEGIN
      IF vn_num1 >= vn_num2 THEN
         DBMS_OUTPUT.PUT_LINE(vn_num1 ||'이 큰 수');
      ELSE
         DBMS_OUTPUT.PUT_LINE(vn_num2 ||'이 큰 수');
      END IF;
    END;
    -----------------------------------
    for 변수이름 in 시작.. 끝 loop
    실행문장;
    end loop;
    /
    
    create table bit(
        num number(3),
        name varchar2(10)
        );
        select*from  bit;
        
-----
begin
for i in 1..10 loop
    insert into bit VALUES(i,sysdate);
    end loop;
    end;
    /
select*from bit;
-------------------
while 조건식 loop
    실행문장;
    증ㄱㅁ식;
end loop;
------------------------------
declare
    su number:=0;
begin
    while su<50 loop
        su:=su+1;
        dbms_output.put_line('현재 su값은'||su);
        end loop;
        end;
        /
        
declare 
    su number:=1;
    begin
    while su<=10 loop
    dbms_output.put_line(su);
     su:=su+1;
    end loop;
    end;
    /
    
    declare
        su number:=0;
    begin
        while su<=10 loop
         su:=su+1;
        if( mod(su,2) =0) then
        dbms_output.put_line(su);
       
        end if;
        end loop;
    end;
    /
    
    declare
        su number:=2;
        dan number:=1;
        begin
        while dan<10 loop
        dbms_output.put_line(su*dan);
        dan:=dan+1;
        end loop;
        end;
        /
        
         declare
        su number:=&dan;  --&뒤에 아무글자나 상관없는듯보임. number하나만 입력바고싶으면 number(1)이런식으로 만들면됨.
        dan number:=1;
        begin
        while dan<10 loop
        dbms_output.put_line(su*dan);
        dan:=dan+1;
        end loop;
        end;
        /
        for i in 1..10 loop
        
        declare
        dan number:=2;
        su number:=1;
        begin
            for i in 2..9 loop
                for j in 1..9 loop
                dbms_output.put_line(dan*su);
                su:=su+1;
                end loop;
                dan:=dan+1;
                su:=1;
                end loop;
                end;
                /
    
declare 
    su number:=1;
    sum1 number:=0;  
begin 
    while su<=10 loop
    sum1:=sum1+su;
    su:=su+1;
    end loop;
    DBMS_OUTPUT.PUT_line(sum1);
    end;
    /
    
--for i in reverse 1..9 loop --역으로 출력