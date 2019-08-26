package springbook.user.view;

import springbook.user.dao.NConnectionMakerImpl;
import springbook.user.dao.UserDAO;
import springbook.user.domain.UserVO;

public class MainEntry {
	public static void main(String[] args) throws Exception {  //예외처리 위임
		
		//공통
		UserDAO dao = new UserDAO(new NConnectionMakerImpl());
		
		UserVO vo = new UserVO();
		vo.setId("park");
		vo.setName("박태환");
		vo.setPassword("9876");
		
		dao.add(vo);
		System.out.println(vo.getId() + " 등록 성공");
		
	} 
}









