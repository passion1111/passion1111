EMP2 테이블을 사용하여 전체 직원 중 과장 직급의 최소 연봉자보다 연봉이 
높은 사람의 이름과 직급,연봉을 출력하세요. 
단 연봉 출력 형식은 아래와 같이 천 단위 구분기호와 원 표시를 하세요
----------------------------------------------------    
  select * from emp2;
  select * from emp2 where position = '과장';
  select  avg(pay) from emp2  where position = '과장';

  
  
  
  select name, position ,to_char(pay, 'L999,999,999') from emp2 where pay  > ( select min(pay) from emp2 where position = '과장');
  

  
  
  
  
  
-------------------------------------------------------------------
student 테이블을 조회하여 전체 학생 중에서 체중이 4학년 학생들의 체중에
서 가장 적게 나가는 학생보다 적은 학생의 이름과 학년과 몸무게를 출력.
-------------------------------------------------------------------------
select * from student;
  

    select name, grade ,weight from student where weight  < ( select min(weight) from student where grade = 4);



--------------------------------------------------
student 테이블을 조회하여 각 학년별로 최대 키를 가진 학생들의 학년과 이
름과 키를 출력.
select * from student;



select grade, name , height 
from student 
where (grade, height) in (select grade, max(height) from student group by 
grade);




  -------------------------------------------------
professor 테이블을 조회하여 각 학과별로 입사일이 가장 오래된 교수의 교
수번호와 이름, 입사일, 학과명을 출력. 
단, 학과명순으로 오름차순 정렬.

----------------------------------------------
Emp2 테이블을 조회하여 직급별로 해당 직급에서 최대 연봉을 받는 직원의 
이름과 직급, 연봉을 출력하세요. 
연봉순으로 오름차순 정렬하세요.

