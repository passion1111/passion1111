package edu.kosta;

public class MyApplication {
	
	private MessageService service;
	
	// constructor 
	public MyApplication() { }   
	public MyApplication(MessageService  service) {  // DI
		this.service = service;
	}
	
	// setter method
	public void setService(MessageService service) {
		this.service = service;
	}
	
	public boolean processMessage(String msg, String rec) {
		return this.service.sendMessage(msg, rec);
	}
	
}
