package Ncontrollers;

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

	private MemberDao memberDao;

	@Autowired
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@RequestMapping(value={"login.htm"} , method=RequestMethod.GET)
	public String login(){
		 return "joinus.login";
		//return "login.jsp";
	}
		
	@RequestMapping(value={"join.htm"} , method=RequestMethod.GET)
	public String join(){
		 return "joinus.join";
		//return "join.jsp";
	}
	
	@RequestMapping(value={"join.htm"} , method=RequestMethod.POST)
	public String join(Member member) throws ClassNotFoundException, SQLException{
		memberDao.insert(member);
		return "redirect:../index.htm";
	}
	
	
	
}
