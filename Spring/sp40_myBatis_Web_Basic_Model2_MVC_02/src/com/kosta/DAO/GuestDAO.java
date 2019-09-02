package com.kosta.DAO;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.kosta.Config.SqlSessionFactoryService;
import com.kosta.DTO.GuestDTO;

public class GuestDAO {
	private SqlSessionFactory sqlsessionfactory;
	public GuestDAO(){
		sqlsessionfactory = SqlSessionFactoryService.getSqlSessionFactory();
	}
	//코드구현
	public int insert(GuestDTO guestObj){
		SqlSession session = null;
		
		try {
			session = sqlsessionfactory.openSession();
			int result =session.insert("GUEST.insertGuest", guestObj);
			session.commit();
			return result;
		} catch (Exception e) {
			//session.rollback(); ���� ���� ����� �ǹ̰� ����
			return 0;
		}finally{
			if(session != null){session.close();}
		}
		
	}
	
	public int delete(int num){
		//�ڵ� �ϼ��ϼ��� ******************************
		SqlSession session=null;
		try{
			session = sqlsessionfactory.openSession();
			int rowcount= session.delete("GUEST.deleteGuest", num);
			session.commit();
			return rowcount;
		}catch(Exception e){
			return 0;
		}
		finally{
			if(session != null){session.close();}
		}
	}
	
	public int update(GuestDTO guestObj){
		//�ڵ� �ϼ��ϼ��� ******************************
		SqlSession session=null;
		try{
			session = sqlsessionfactory.openSession();
			int rowcount= session.update("GUEST.updateGuest", guestObj);
			session.commit();
			return rowcount;
		}catch(Exception e){
			return 0;
		}
		finally{
			if(session != null){session.close();}
		}
	}
	//��ü ��ȸ
	public List<GuestDTO> getList(){
		//�ڵ� �ϼ��ϼ��� ******************************
		SqlSession session=null;
		try{
			session = sqlsessionfactory.openSession();
			//Mybatis > selectList (������ Row)
			return session.selectList("GUEST.getAllList");
		}catch(Exception e){
			return null;
		}
		finally{
			if(session != null){session.close();}
		}
	}
	//�Խñ� ����ȸ
	public GuestDTO DetailList(int no){
		//�ڵ� �ϼ��ϼ���
		SqlSession session=null;
		try{
			session = sqlsessionfactory.openSession();
			//�Ѱ� (�ϳ��� ROW) >> selectOne
			GuestDTO dto = session.selectOne("GUEST.getDetailByno",no);
			return dto;
		}catch(Exception e){
			return null;
		}
		finally{
			if(session != null){session.close();}
		}
	}
	//��ü �˻� ��ȸ_1
	public List<GuestDTO> getSearchList(Map<String, String> map){
		SqlSession session=null;
		try{
			 /*for(Map.Entry<String, String> m : map.entrySet()){
				 System.out.println(m.getKey() + "/" + m.getValue() +"-");
			 }*/
			 session = sqlsessionfactory.openSession();
			 return session.selectList("GUEST.selectSearch" ,map);
		}catch(Exception e){
			 return null;
		}finally{
			if(session != null){session.close();}
		}
	}
	//��ü �˻� ��ȸ_2
	public List<GuestDTO> getSearchList2(Map<String, String> map){
		SqlSession session=null;
		try{
			/* for(Map.Entry<String, String> m : map.entrySet()){
				 System.out.println(m.getKey() + "/" + m.getValue() +"-");
			 }*/
			 session = sqlsessionfactory.openSession();
			 return session.selectList("GUEST.selectSearch2",map);
		}catch(Exception e){
			 return null;
		}finally{
			if(session != null){session.close();}
		}
	}
}
		

