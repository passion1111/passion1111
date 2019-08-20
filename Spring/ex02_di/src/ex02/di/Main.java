package ex02.di;

public class Main {
	public static void main(String[] args) {
		MessageBean bean=new MessageBeanimpkr();
		bean.SayHello("스프링");
		bean =new MessageBeanImp();
		bean.SayHello("sese");
	}
}
