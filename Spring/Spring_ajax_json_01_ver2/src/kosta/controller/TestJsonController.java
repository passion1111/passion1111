package kosta.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kosta.vo.Search;

@Controller
public class TestJsonController {
	
/*	@Autowired
	private View jsonview;
	*/
/*	@RequestMapping(value="/testJson.kosta")
	public View testJson1(String command,String name, String[] arr ,ModelMap map){
		System.out.println("command :"+command);
		System.out.println("name :" +name);
		System.out.println("arr :" +arr);
		System.out.println(Arrays.toString(arr));
		for(String s : arr.split(",")){
			System.out.println(s);
		}
		
		//BeanNameViewResolve에 의해 자동으로 JSON객체로 반환되어 응답됨.
		//ModelAndView ma = new ModelAndView();
		//ma.setViewName("JsonView");
		ArrayList<String> list = new ArrayList<>();
		list.add("치킨맥주");
		list.add("돈까스");
		list.add("치킨피자");
		map.addAttribute("menu", list);
		
		return jsonview;
	
	}
	@RequestMapping(value="/testJson2.kosta")
	public View testJson2(String command,String name,ModelMap map){
		System.out.println("command :"+command);
		System.out.println("name :" +name);
		//BeanNameViewResolve에 의해 자동으로 JSON객체로 반환되어 응답됨.
		//ModelAndView ma = new ModelAndView();
		//ma.setViewName("JsonView");
		ArrayList<TestVO> list = new ArrayList<>();
		TestVO vo = new TestVO();
		vo.setBeer("라거");
		vo.setFood("골뱅이");
		list.add(vo);
		TestVO vo1 = new TestVO();
		vo1.setBeer("카스");
		vo1.setFood("치킨");
		list.add(vo1);
		map.addAttribute("menu", list);
		return jsonview;  //JsonView
	}
	@RequestMapping(value="/testJson3.kosta" ,method = RequestMethod.POST)
	public View add(HttpServletRequest request, HttpServletResponse response, ModelMap map)
			{

		Employee employee = new Employee();
		String firstName = "kg";
		String lastName = "lim";
		String email = "i7027@email";

		employee.setEmail(email);
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(employee);
		Employee employee2 = new Employee();
		employee2.setEmail(email);
		employee2.setFirstName(firstName);
		employee2.setLastName(lastName);
		list.add(employee2);
		
		map.addAttribute("data", list);
		//System.out.println(employee.getFirstName() + "/" + employee2.getFirstName());
		return jsonview;
	}
	*/
	
	//
	
	//@RequestMapping(value = "/testJson6.kosta",method = RequestMethod.POST)
	//public View saveLayout(@RequestParam(value = "deleteWidgetId") String[] deleteWidgetId ,HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception { 
	//public View saveLayout(String[] deleteWidgetId ,HttpServletRequest request, HttpServletResponse response, ModelMap map) throws Exception {   
	//here that if i try to use the deleteWidgetId it is giving null pointer exception
	//	System.out.println(deleteWidgetId);

	//	return null;
	//}

	@RequestMapping(value = "/testJson6.kosta", method = RequestMethod.POST)
	//@RequestMapping(value="/testJson6.kosta",method=RequestMethod.POST ,consumes="application/json")
	//@RequestMapping(value="/testJson6.kosta",method=RequestMethod.POST ,	headers = {"Content-type=application/json"})
	   public @ResponseBody String  getSearchUserProfiles(@RequestBody Search search, HttpServletRequest request) {
	       String pName = search.getPname();
	       String lName = search.getLname();
	       System.out.println(pName + " / " + lName);
	       // your logic next
	       return null;
	   }
	
	@RequestMapping(value="/testJson7.kosta",method=RequestMethod.POST, consumes="application/json")
	public @ResponseBody String getTestMap(@RequestBody Map<String, Object> param) throws Exception{
	  System.out.println(param);
	 // JSONObject  jobj =  testService.getTestList(param);
	  return null;
	 }
	
}
