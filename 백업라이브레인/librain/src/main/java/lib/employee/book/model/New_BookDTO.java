package lib.employee.book.model;

import java.sql.Timestamp;

public class New_BookDTO {
	private int new_book_num; //신청 번호
	private int new_book_num_sub; //신청 하위 번호
	private String book_author; //저자
	private String book_name; //도서명
	private String book_pub_house; //출판사
	private Timestamp book_pub_date; // 발행일
	private String book_ISBN; // ISBN
	private int book_price; //도서가격
	private String new_status; //승인상태 
	private Timestamp new_input_date; //신청일
	
	public int getNew_book_num() {
		return new_book_num;
	}
	public void setNew_book_num(int new_book_num) {
		this.new_book_num = new_book_num;
	}
	public int getNew_book_num_sub() {
		return new_book_num_sub;
	}
	public void setNew_book_num_sub(int new_book_num_sub) {
		this.new_book_num_sub = new_book_num_sub;
	}
	public String getBook_author() {
		return book_author;
	}
	public void setBook_author(String book_author) {
		this.book_author = book_author;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_pub_house() {
		return book_pub_house;
	}
	public void setBook_pub_house(String book_pub_house) {
		this.book_pub_house = book_pub_house;
	}
	public Timestamp getBook_pub_date() {
		return book_pub_date;
	}
	public void setBook_pub_date(Timestamp book_pub_date) {
		this.book_pub_date = book_pub_date;
	}
	public String getBook_ISBN() {
		return book_ISBN;
	}
	public void setBook_ISBN(String book_ISBN) {
		this.book_ISBN = book_ISBN;
	}
	public int getBook_price() {
		return book_price;
	}
	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}
	public String getNew_status() {
		return new_status;
	}
	public void setNew_status(String new_status) {
		this.new_status = new_status;
	}
	public Timestamp getNew_input_date() {
		return new_input_date;
	}
	public void setNew_input_date(Timestamp new_input_date) {
		this.new_input_date = new_input_date;
	}
	
	
}
