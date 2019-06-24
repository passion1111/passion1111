-- 집합(그룹)함수 ---------------
select * from gift;
select sum(g_start), sum(g_end) from gift;
select sum(g_start) "시작값합계", sum(g_end) "최대값합계" from gift;

select max(g_start), min(g_start), avg(g_end) from gift;

select count(*) from gift; -- null 포함
select count(gname) from gift;
select count(gno) from gift; -- null 제외
insert into gift(gname, g_end) values('청소기', 3000);

SELECT RANK(600000) within GROUP(ORDER BY g_end desc)
    FROM gift;
select rank(600000) within group(order by g_end desc) 
  from gift
    where g_end is not null ; 
    
select * from student;
-- 키가 168인 사람은 몇 번째로 큰지 확인
SELECT RANK(168) within GROUP(ORDER BY height desc)
    FROM student;
-- 몸무게가 58인 사람은 몇번째인지 등수 구하기?
SELECT RANK(58) within GROUP(ORDER BY weight desc)
    FROM student;
 
--문제]g_end 가 200000, 600000 보다 작은 값 출력 (any 이용하세요)
select * from gift where g_end < any(200000, 600000);
select * from gift where g_end < 600000;
  
--문제]학생들의 키의 합과 평균, 가장 키가 큰 친구, 작은친구 출력하기
select sum(height) 합계, avg(height), max(height), min(height)
    from student;
----------------------------------
SELECT * from student;
SELECT grade, sum(height), avg(height), max(height), min(height)
    from student; -- 그룹(집합)함수와 일반필드는 같이 쓸수 없다.

SELECT grade, sum(height), avg(height), max(height), min(height)
    from student
    group by grade;  -- 부분합(소계)

-- emp_type별로 pay 합, 평균, 최고급여, 최하급여 구하기
select * from emp2;
SELECT emp_type, sum(pay), avg(pay), max(pay), min(pay)
    from emp2
    group by emp_type;  -- 부분합(소계)    

-- 조건 : where , having 절 이용한다

SELECT grade, sum(height), avg(height), max(height), min(height)
    from student
    group by grade
    having avg(height) > 173; -- group by 조건을 사용하는 것은 having 절 조건 사용

select deptno, round(avg(nvl(pay, 0)),0) "평균급여"
    from professor
    group by deptno;

select deptno as "학   과", round(avg(nvl(pay, 0)),2) "평균급여"
    from professor
    group by deptno
    having avg(pay) > 400;

문제] emp2 테이블에서 deptno(부서)별로 pay 합과 평균 구하기
문제] emp2 테이블에서 emp_type별로 pay 합과 평균 구하기
문제] emp2 테이블에서 직급별(position)별로 급여의 합, 평균을 구하기
문제] emp2 테이블에서 직급별(position)별로 급여의 합, 평균을 구하는데,
      직급이 과장인 사람들만 보여주세요

select * from emp2;
    
    