package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.SearchType;





//public String submit(@ModelAttribute("ArticleData")NewArticleCommand command)
//1.@ModelAttribute 역활 : View 에서 사용하는 Model(객체)의 이름 변경
//ex) jsp 페이지에서 : 제목 : ${ArticleData.title}

//2.@ModelAttribute 함수위에서 선언 : 함수를 객체로 생성할수 있다 

@Controller
public class CodeSearchController {
	
	//@Controller 
	//클래스안에서 사용되는 :  @ModelAttribute("searchTypeList") 
	//함수를 객체형태로 만들게 되면 ... [view] 단에서 사용가능하다
	//return 되는 함수의 view 페이지에서 객체사용 할 수 있다
	
	
	//이렇게 하는 방법은 언제 쓰면 좋을까요 ?
	//메뉴 구성 , 코드성 데이터를 화면에 구성할때 ...
	
	@ModelAttribute("searchTypeList") //함수를 통해서 객체를 생성 이렇게 넣거나 SrarchTypeList(@Modelattribute...)이렇게도 만드는것가능.
	public List<SearchType> SearchTypeList(){
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "LOL"));
		options.add(new SearchType(3, "STAR"));
		options.add(new SearchType(4, "MONEY"));
		options.add(new SearchType(5, "ETC"));
		
		System.out.println("SearchTypeList 함수 실행");
		return options;
	}
	
	@ModelAttribute("queryList")
	public String[] getQueryList(){
		System.out.println("getQueryList");
		return new String[]{"게임","star","city","world"};
	}
	
	@RequestMapping("/search/main.do")
	public String main(){
		return "search/main";
	}
	

}






