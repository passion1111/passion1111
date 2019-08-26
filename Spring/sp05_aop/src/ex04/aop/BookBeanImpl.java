package ex04.aop;

public class BookBeanImpl implements BookBean {

	@Override
	public void testHello(String str) {
		System.out.println("public void testHello(String str) »£√‚µ  ");

	}

	@Override
	public int korHello() {
		System.out.println("public int korHello() »£√‚µ ");
		return 5;
	}

}
