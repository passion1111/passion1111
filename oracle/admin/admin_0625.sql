--테이블에 접근하기 -- 


select * from tab;

select * from emp;
select * from kim.emp;

select * from col where TABLE_NAME = 'help';
DESCRIBE kim.emp;

--grant select on 소유자.테이블명 to 다른 사용자명; 다른 사용자에게 권한을 줄수있는자는 시스템계정과  권한을 가지고있는자가 유일.
--일반사용자는 자신의 권한을 가지고있는자만 가능.
grant all on kim.emp to kang; --강이라는 사람은 이제 kim의 emp에 접근이 가능하다.
select* from kim.emp;