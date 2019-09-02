package com.naver.erp;

//import org.springframework.web.multipart.MultipartFile;

//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
// [게시판 글] 정보를 저장할 [BoardDTO 클래스] 선언
//mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
public class BoardDTO{
	//*****************************************************
	// 속성변수 선언
	//*****************************************************
	private String board_no;  // 게시판 번호 저장
	private String subject;   // 제목 저장
	private String writer;	  // 작성자 저장
	private String reg_date;  // 등록일 저장
	private int readcount; 	  // 조회수 저장
	//-----------
	private String content;   // 게시판 번호 저장 	
	private String pwd;       // 수정/삭제 시 필요한 암호 저장
	private String email;	  // 게시판 번호 저장
	//-----------
	private int group_no;	  // 그룹 번호 저장
	private int print_no;	  // 같은 그룹 내 출력 번호 저장
	private int print_level;  // 들여쓰기 레벨 단계 저장

	//*****************************************************
	// 메소드 선언
	//*****************************************************
	public String getBoard_no() {
		return board_no;
	}
	public void setBoard_no(String board_no) {
		this.board_no = board_no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public int getReadcount() {
		return readcount;
	}
	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGroup_no() {
		return group_no;
	}
	public void setGroup_no(int group_no) {
		this.group_no = group_no;
	}
	public int getPrint_no() {
		return print_no;
	}
	public void setPrint_no(int print_no) {
		this.print_no = print_no;
	}
	public int getPrint_level() {
		return print_level;
	}
	public void setPrint_level(int print_level) {
		this.print_level = print_level;
	}
	//*****************************************************
	// BoardDTO 클래스 안의 속성변수값을 도스창에 출력하는 메소드 선언.
	//*****************************************************
	public void print_info(){
		System.out.println("\n---------------------------------");
		System.out.println("BoardDTO 속성변수 데이터");
		System.out.println("---------------------------------");
		System.out.println("board_no=>"+ board_no);
		System.out.println("subject=>"+subject);
		System.out.println("writer=>"+writer);
		System.out.println("reg_date=>"+reg_date);
		System.out.println("readcount=>"+readcount);
		System.out.println("content=>"+content);
		System.out.println("pwd=>"+pwd);
		System.out.println("email=>"+email);
		System.out.println("group_no=>"+group_no);
		System.out.println("print_no=>"+print_no);
		System.out.println("print_level=>"+print_level);
		System.out.println("---------------------------------");
	}
}




















