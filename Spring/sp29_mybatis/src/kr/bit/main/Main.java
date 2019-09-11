package kr.bit.main;

import org.apache.ibatis.session.SqlSession;

import kr.bit.dao.Emp2;
import kr.bit.service.SqlMapClient;


public class Main {

	public static void main(String[] args) {
		SqlSession sqlsession=SqlMapClient.getSqlSession();
		
		sqlsession.getConnection();
		
		Emp2 emp=sqlsession.selectOne("emp22","나한라");
		
		
		
		
		
		System.out.println("결과확인");
		System.out.println(emp.getEmpno());
		
	}
}
