package ex01.di;



public class MessageBeanImpl implements MessageBean {
	
	private String name;
	private String greeting;

//	1.contructor
	public MessageBeanImpl() {	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public MessageBeanImpl(String name, String greeting) {
		this.name = name;
		this.greeting = greeting;
	}
	
	public void sayHello() {
		System.out.println(greeting + " / " + name + ".");
	}

}
