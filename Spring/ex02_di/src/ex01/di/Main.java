package ex01.di;

public class Main {
	public static void main(String[] args) {
		
		MessageBean bean=new MessageBean();
		bean.sayHello("하이");
	//스프링은 처음코드는 바꾸지않겠다는 철학을 가지고있었음.
//	그래서 바꾸는게 필요하면 주입하라.가 제작자의 의도임.
		
	}
}
