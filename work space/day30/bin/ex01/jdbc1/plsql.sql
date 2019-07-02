select * from emp;
---------------------------------------------------------
 CREATE OR REPLACE PROCEDURE usp_EmpList
(
	p_sal IN number,
    p_cursor OUT SYS_REFCURSOR --APP 사용하기 위한 타입
)
IS
	BEGIN
  			OPEN p_cursor
        FOR
        		 SELECT empno, ename, sal FROM EMP WHERE sal > p_sal;

  END; 
  
  exec usp_EmpList
  ----------------------------------------------------------------------------
   CREATE OR REPLACE PROCEDURE usp_delete_emp
  (
  	vempno IN emp.empno%TYPE,
    p_outmsg OUT VARCHAR2
   )
   IS
   		BEGIN
      		DELETE FROM EMP WHERE empno=vempno;
          COMMIT;
      	  p_outmsg := 'success';
         -- EXCEPTION WHEN OTHERS THEN
          --p_outmsg := SQLERRM;	
          --ROLLBACK;
      END;
  -------------------------------------------------------------------------------
  
  select * from dept;
  
  
  
 