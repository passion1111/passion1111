package ncontrollers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.Member;
import dao.MemberDao;


@Controller
@RequestMapping("/joinus/")
public class JoinController {

	@Autowired
	private MemberDao memberDao;
	
	
	
	//로그인 요청 처리
	@RequestMapping(value="login.htm" , method=RequestMethod.GET)
	public String login(){
		
		//Tiles 변경 전
		//return "login.jsp";
		
		//Tiles 변경 후
		return "joinus.login";
	}
	
	
	@RequestMapping(value="join.htm" ,method=RequestMethod.GET)
	public String join(){
		
	
		//Tiles 변경 후
		return "joinus.join";
		//Tiles 변경 전
		//return "join.jsp";
	}
	
	@RequestMapping(value="join.htm" ,method=RequestMethod.POST)
	public String join(Member member) throws ClassNotFoundException, SQLException{
		memberDao.insert(member);
		return "redirect:../index.htm";
	
	}
}
