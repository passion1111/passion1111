--집계(그룹)함수

select *from gift;

select sum(g_start) ,sum(g_end) from gift;
select sum(g_start) "시작값합계" ,sum(g_end) "최댓값 합계" from gift;            --별칭을지어줌
select max(g_start) "맥스값", min(g_end) "최솟값" ,avg(g_end)"평균" from gift;

select count(*) from gift; --null이 있든 없든 전부 세어버림.
select count(gname) from gift; --구체적으로 필드 지정하면 null을 제외함.
insert into gift(gname,g_end) VALUES('청소기',3000);

--rank구하기 
select rank(6000) within group(order by g_end desc) from gift;--널값이 가장 크게위에 위치되고 그다음부터 카운팅되는거같음 널이2개면 3등부터시작.

select*from student;
--,키가 168인 사람은 몇번째로 큰지 확인
select count(height) from student;
select rank(168) within group(order by height desc)from student;
--몸무게가 58인 사람은 랭킹이 어떻게되는지
select rank(58) within group(order by weight desc)from student;   --(asc)뒤에서부터  desc1등에서부터계산.   

--문1 g_end가 2000000,600000보다 작은값 출력 any 이용하세여 gift
select*from gift;
select *from gift where g_end<any(200000,600000) ;--any 최댓값 any는 더 많은값을 포함시키는것이라고 생각하면됨.
--문2 학생들의 키의 합과 평균 가장 키가 큰 친구 작은친구 출력하기

select sum(height),avg(height),max(height),min(height)from student;

---------------------------------------------------------ㅈ
select *from student;
select grade, sum(height),avg(height),max(height),min(height) from student --그룹필드와 일반필드는 같이 쓸수가 없다 grade지우면 에러안뜸 grade 안지울려면 group by로 그룹화시켜야함.
 group by grade; --부분합 (소계)
 
 select grade, sum(height),avg(height),max(height),min(height) from student --그룹필드와 일반필드는 같이 쓸수가 없다 grade지우면 에러안뜸 grade 안지울려면 group by로 그룹화시켜야함.
 group by grade having grade>2;--avg(height)>173;

--조건:where ,having 절 이용한다. group by가 들어가있으면 having절로 사용함  

select *from emp2;
select position, trunc(avg(pay),3) ,sum(pay),max(pay),min(pay) from emp2 group by position; --avg 소수점이 너무길어서 trunc함수로 3자리숫자에서 끊어줌.

select deptno as"학 과", trunc(avg(nvl(pay,0)),1) "평균급여" from professor group by deptno having avg(pay)>400;  --round로 잘라도됨 round 올림 trunc 내림

--문제1 emp2테이블에서 delptno(부서)별로 pay 합과 평균 구하기
select deptno as "부서",sum(pay),avg(pay) from emp2 group by deptno;

--문2 emp2 테이블에서 직급별 별로 급여의 합 평균을 구하는데 직급이 과장인 사람들만 보여주세요.
select position as"직급",sum(pay),avg(pay) from emp2 group by position having position='과장';