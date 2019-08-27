package spring;

import java.util.Date;

public class Member { //모델역할을함.
	private Long id;
	private String email,password,name;
	private Date registDate;
	public Member(Long id, String email, String password, String name, Date registDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.registDate = registDate;
	}
	
	public void chagePassword(String oldPassword,String newPassword) {
		if(!password.equals(oldPassword)) {
			throw new IdPasswordNotMatchingException();
		}
		this.password=newPassword;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	
	
}
