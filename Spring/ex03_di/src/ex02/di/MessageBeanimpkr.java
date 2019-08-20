package ex02.di;

public class MessageBeanimpkr implements MessageBean {

	@Override
	public void SayHello(String name) {
		System.out.println("안녕하세요 "  +name+ " 입니다.");

	}

}
