package ex03.di;

public class MessageBeanImp implements MessageBean {

	@Override
	public void SayHello(String name) {
		System.out.println("Hello "+name+" sir!");
		
	}

}
