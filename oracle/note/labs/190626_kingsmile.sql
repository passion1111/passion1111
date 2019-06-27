select name,rowid, deptno, rownum from emp2;

문제] kingsmile 사용자의 테이블중에서
emp2, gift, dept2 3개의 테이블을 백업하기
kang 사용자의 테이블에 임포트 하시오.

C:\Users\class4-teacher>exp kingsmile/oracle tables=(emp2, dept2, gift) file=C:\
th129_java_web_app_developer\2_Oracle\Data\aaa.dmp


C:\Users\class4-teacher>imp "kang"/oracle ignore=y full=y file=C:\th129_java_web
_app_developer\2_Oracle\Data\aaa.dmp

18c 버전에서는 임포트시에 아이디/비번 재확인하면됨.
----------------------------------




