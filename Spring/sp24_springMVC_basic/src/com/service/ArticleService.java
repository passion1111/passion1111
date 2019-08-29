package com.service;

import com.model.NewArticleCommand;

//service(요청에 대한 처리 함수)
// model(dto, dao) 처리
public class ArticleService {
	
	//글쓰기, 글목록보기 등등 처리 가지고 있다
	public void writeArticle(NewArticleCommand command) {
		//DAO 객체 만들기
		//DAO 객체가 가지는 함수 호출(write())
		System.out.println("신규 글쓰기 등록 처리 : " + command.toString());
	}

}
