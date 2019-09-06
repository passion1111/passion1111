package kr.co.dept.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dept.model.Dept2DAO;
import kr.co.dept.model.Dept2DTO;
import kr.co.dept.model.DeptDAO;
import kr.co.dept.model.DeptDTO;

@Controller
public class DeptsController {

	@Resource
	private DeptDAO deptDAO;
	@Resource
	private Dept2DAO dept2DAO;

	@RequestMapping("/dept_list.do")
	public String list(Model model, @RequestParam(value = "message", required = false) String message) {
		List<DeptDTO> list = deptDAO.getDeptList();
		model.addAttribute("message", message);// 아 이걸 spring에서는 어떻게 했더라
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping("/dept2_list.do")
	public String list2(Model model, @RequestParam(value = "message", required = false) String message) {
		List<Dept2DTO> list = dept2DAO.getDept2List();
		model.addAttribute("message", message);// 아 이걸 spring에서는 어떻게 했더라
		model.addAttribute("list", list);
		return "list2";
	}

	@RequestMapping("/delete_dept.do")
	public ModelAndView delete1(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		int deptno = new Integer(request.getParameter("deptno"));

		deptDAO.deleteDept(deptno);

		mav.addObject("message", deptno + " 가 삭제되었습니다.");

		mav.setViewName("redirect:dept_list.do");
		return mav;
	}

	@RequestMapping("/delete_dept2.do")
	public ModelAndView delete2(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();

		int dcode = new Integer(request.getParameter("dcode"));

		dept2DAO.deleteDept2(dcode);

		mav.addObject("message", dcode + " 가 삭제되었습니다.");

		mav.setViewName("redirect:dept2_list.do");
		return mav;
	}

	@RequestMapping("/multiDelete_dept.do")
	public ModelAndView multiDelete1(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		List deleteTargets = new ArrayList<>();

		for (String item : request.getParameter("deptno").split(",")) {
			deleteTargets.add(item);
		}

		int deletedRownum = deptDAO.multiDeleteDept(deleteTargets);
		System.out.println("삭제된 로우 : " + deletedRownum);

		mav.setViewName("redirect:dept_list.do");
		return mav;
	}

	@RequestMapping("/multiDelete_dept2.do")
	public ModelAndView multiDelete2(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		List deleteTargets = new ArrayList<>();

		for (String item : request.getParameter("dcode").split(",")) {
			deleteTargets.add(item);
		}
		System.out.println(deleteTargets.toString());

		int deletedRownum = dept2DAO.multideleteDept2(deleteTargets);
		System.out.println("삭제된 로우 : " + deletedRownum);

		mav.setViewName("redirect:dept2_list.do");
		return mav;
	}
	// delete

	@RequestMapping("/search_dept.do")
	public ModelAndView search1(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("UTF-8");

		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<>(); // collection
		map.put("deptno", "deptno"); // column : name or email or home
		map.put("dname", "dname"); // column : name or email or home
		map.put("loc", "loc"); // column : name or email or home
		map.put("keyvalue", keyvalue); // column : name or email or home

		List<DeptDTO> searchedList = deptDAO.searchDeptList(map);

		System.out.println("검색된 결과 : " + searchedList.toString());

		mav.addObject("list", searchedList);// 아 이걸 spring에서는 어떻게 했더라

		mav.setViewName("list");
		return mav;
	}

	@RequestMapping("/search_dept2.do")
	public ModelAndView search2(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		request.setCharacterEncoding("UTF-8");

		String keyvalue = request.getParameter("keyvalue");

		Map<String, String> map = new HashMap<>(); // collection
		map.put("dcode", "dcode"); // column : name or email or home
		map.put("dname", "dname"); // column : name or email or home
		map.put("pdept", "pdept"); // column : name or email or home
		map.put("area", "area"); // column : name or email or home
		map.put("keyvalue", keyvalue); // column : name or email or home

		List<Dept2DTO> searchedList = dept2DAO.searchDept2List(map);

		System.out.println("검색된 결과 : " + searchedList.toString());

		mav.addObject("list", searchedList);// 아 이걸 spring에서는 어떻게 했더라

		mav.setViewName("list2");
		return mav;
	}

	@RequestMapping("/updateform_dept.do")
	public ModelAndView updateform1(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		// String cmd = request.getParameter("cmd");// deptno, dcode는 중복되면 안되니까
		// 내가 고정해놔야함
		int deptno = new Integer(request.getParameter("deptno"));

		DeptDTO dto = deptDAO.getDept(deptno);
		mav.addObject("dto", dto);
		mav.setViewName("updateform");
		return mav;
	}

	@RequestMapping("/updateform_dept2.do")
	public ModelAndView updateform2(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		// String cmd = request.getParameter("cmd");// deptno, dcode는 중복되면 안되니까
		// 내가 고정해놔야함
		int dcode = new Integer(request.getParameter("dcode"));
		Dept2DTO dto = dept2DAO.getDept2(dcode);
		mav.addObject("dto", dto);
		mav.setViewName("updateform2");
		return mav;
	}

	@RequestMapping("/update_dept.do")
	public ModelAndView update1(DeptDTO dto) throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println("수정된 레코드 값 : " + dto.toString());

		deptDAO.updateDept(dto);

		mav.setViewName("redirect:dept_list.do");
		return mav;
	}

	@RequestMapping("/update_dept2.do")
	public ModelAndView update2(Dept2DTO dto) throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println("수정된 레코드 값 : " + dto.toString());

		dept2DAO.updateDept2(dto);

		mav.setViewName("redirect:dept2_list.do");
		return mav;
	}

	@RequestMapping("/writeform_dept.do")
	public String writeForm1() {
		return "writeform";
	}

	@RequestMapping("/writeform_dept2.do")
	public String writeForm2() {
		return "writeform2";
	}

	@RequestMapping("/write_dept.do")
	public ModelAndView write1(DeptDTO dto, @RequestParam(value = "over", required = false) String over)
			throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println("넘어온 신규 레코드 값 : " + dto.toString());

		System.out.println("잉여값은 ? " + over);

		deptDAO.insertDept(dto);

		mav.setViewName("redirect:dept_list.do");
		return mav;
	}

	@RequestMapping("/write_dept2.do")
	public ModelAndView write2(Dept2DTO dto) throws Exception {
		ModelAndView mav = new ModelAndView();

		System.out.println("넘어온 신규 레코드 값 : " + dto.toString());

		dept2DAO.insertDept2(dto);

		mav.setViewName("redirect:dept2_list.do");
		return mav;
	}

}
