package sua.sua.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import sua.sua.model.SuaDAO;
import sua.sua.model.SuaVO;

@Controller
public class Controller2 {
	@Autowired
	private SuaDAO suadao;

	@GetMapping
	public String gogo() {
		return "join";
	}

	@PostMapping("join.do")
	public String insert(SuaVO vo, HttpSession session) {

		suadao.insert(vo);
		session.setAttribute("id", vo.getId());

		return "come";
	}

	@PostMapping("logout.do")
	public String logout(HttpSession session) {
		session.invalidate();

		return "redirect:join.do";
	}

	@GetMapping("idcheck.do")
	public void check(HttpServletRequest request, HttpServletResponse response) {
		org.json.simple.parser.JSONParser json = new org.json.simple.parser.JSONParser();
		String jsoninfo = request.getParameter("data");
		try {
			org.json.simple.JSONObject jsonObject = (org.json.simple.JSONObject) json.parse(jsoninfo);
			String id = (String) jsonObject.get("id");
			boolean result = suadao.suacheck(id);
			JSONObject totalobject = new JSONObject();

			if (result) {
				totalobject.put("id", id);
			} else {
				totalobject.put("id", "null");
			}
			String jsoninfo2 = totalobject.toJSONString();
			PrintWriter writer = response.getWriter();
			writer.print(jsoninfo2);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
