package kr.or.kosta.Ncontrollers;

import java.sql.SQLException;

import kr.or.kosta.dao.MemberDao;
import kr.or.kosta.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/joinus/")
public class JoinController {

	@Autowired
	private MemberDao memberDao;
		
	//로그인 페이지 구성
	@RequestMapping(value={"login.htm"},method=RequestMethod.GET)
	public String login(){
		//return "login.jsp";
	      return "joinus.login";
	}
	//필요한 method (@RequestMapping ) 한 형태로
	//회원가입 화면 /joinus/join.htm 요청이 오면
	@RequestMapping(value={"join.htm"},method=RequestMethod.GET)
	public String join(){
		//Tiles이전코드
		//return "join.jsp";
		
		//Tiles 적용코드
		return "joinus.join";
	}
	
	//회원가입 처리 
	@RequestMapping(value={"join.htm"} , method=RequestMethod.POST)
	public String join(Member member) throws ClassNotFoundException, SQLException{
		memberDao.insert(member);
		return "redirect:../index.htm";
	}
}







