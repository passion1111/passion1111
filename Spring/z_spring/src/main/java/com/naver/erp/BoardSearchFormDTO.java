package com.naver.erp;

import java.util.Calendar;

//import org.springframework.web.multipart.MultipartFile;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// 게시판 검색 관련 정보 저장 [BoardSearchFormDTO 클래스] 선언
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
public class BoardSearchFormDTO{
	//*****************************************************
	// 속성변수 선언
	//*****************************************************
	private String keyword;         // 검색 키워드 저장
	private String keywordContent;  // 검색 키워드가 검색할 대상 저장
	//-------------------
	private int rowCntPerPage=15;   // 한 화면에 보여지는 검색 결과 최대행 개수 저장. <주의>반드시 초기값 입력할 것.
	private int selectPageNo=1;     // 현재 선택된 페이지 번호 저장.  <주의>반드시 초기값 입력할 것. 
	private int startRowNo;         // 게시판 검색 시 [선택한 페이지번호]에 해당하는 시작행 번호 저장

	//*****************************************************
	// 메소드 선언
	//*****************************************************
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getKeywordContent() {
		return keywordContent;
	}
	public void setKeywordContent(String keywordContent) {
		this.keywordContent = keywordContent;
	}
	public int getRowCntPerPage() {
		return rowCntPerPage;
	}
	public void setRowCntPerPage(int rowCntPerPage) {
		this.rowCntPerPage = rowCntPerPage;
	}

	public int getSelectPageNo() {
		return selectPageNo;
	}
	public void setSelectPageNo(int selectPageNo) {
		this.selectPageNo = selectPageNo;
	}

	public int getStartRowNo() {
		return startRowNo;
	}
	public void setStartRowNo(int startRowNo) {
		this.startRowNo = startRowNo;
	}

	//*****************************************************
	// [검색 총 개수]에 따른 속성변수 selectPageNo 안의 데이터를 보정하는 메소드 선언
	//*****************************************************
	public void updateDTO( int searchListCnt ) {
		if(searchListCnt>0) {
			int lastPageNo = searchListCnt/this.rowCntPerPage;
			if( searchListCnt%this.rowCntPerPage>0 ){ lastPageNo++; }
			if( lastPageNo<this.selectPageNo ){ 
				this.selectPageNo = 1;
			} 
			this.startRowNo = this.selectPageNo*this.rowCntPerPage-this.rowCntPerPage+1;
		}
	}

	//*****************************************************
	// boardSearchFormDTO 클래스 안의 속성변수값을 도스창에 출력하는 메소드 선언.
	//*****************************************************
	public void print_info(){
		Calendar calender = Calendar.getInstance();
		String date = calender.get(Calendar.YEAR)+"-"+(calender.get(Calendar.MONTH)+1)+"-"+calender.get(Calendar.DATE)
						+"__"+ calender.get(Calendar.HOUR_OF_DAY)+":"+ calender.get(Calendar.MINUTE)+":"+ calender.get(Calendar.SECOND);
		System.out.println("\n---------------------------------");
		System.out.println(date);
		System.out.println("boardSearchFormDTO 속성변수 데이터");
		System.out.println("---------------------------------");
		System.out.println("keyword => "+ keyword);
		System.out.println("keywordContent => "+ keywordContent);
		System.out.println("rowCntPerPage => "+rowCntPerPage);
		System.out.println("selectPageNo => "+selectPageNo);
		System.out.println("---------------------------------");
	}
	
}

















