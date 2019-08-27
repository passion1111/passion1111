package springbook.user.view;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMakerImpl;
import springbook.user.dao.NConnectionMakerImpl;
import springbook.user.dao.UserDAO;
import springbook.user.domain.UserVO;

public class MainEntry {  // View
	public static void main(String[] args) throws Exception {  //예외처리 위임
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("ctx.xml");
		
		Scanner sc = new Scanner(System.in);
		UserDAO dao = ctx.getBean("dao", UserDAO.class);
		
		System.out.println("선택하세요: 1.insert / 2.select / 3.selectAll"
				+ " / 4. update / 5.delete");
		switch (sc.nextInt()) {
			case 1:
				UserVO user = new UserVO();
				System.out.print("user id = ");		user.setId(sc.next());
				System.out.print("user name = ");	user.setName(sc.next());
				System.out.print("user pwd = ");	user.setPassword(sc.next());
				
				dao.insert(user);
				System.out.println(user.getId() + " 추가 성공!!");
				System.out.println("======================");				
				break;
			case 2 : 
				System.out.println("보고자하는 id = ? ");
				String id = sc.next();
				UserVO u2 = dao.select(id);
				System.out.println("\n\n");
				System.out.println(u2.getId() + " / " + u2.getName() + " / " + u2.getPassword());
				break;
			case 3 :
				dao.selectAll();
				break; 
	
			default: System.out.println("잘못된 번호 선택했습니다.");
				break;
		}// switch end
		
		
		
		
		
		//공통
//		ConnectionMaker conn = new DConnectionMakerImpl();
//		UserDAO dao = new UserDAO(conn);
	
//		UserDAO dao = new UserDAO(new NConnectionMakerImpl());
//		UserVO vo = new UserVO();
//		
//		dao.selectAll();
		
//		vo.setId("park");
//		vo.setName("박태환");
//		vo.setPassword("9876");
//		
//		dao.add(vo);
//		System.out.println(vo.getId() + " 등록 성공");
		
	} 
}









