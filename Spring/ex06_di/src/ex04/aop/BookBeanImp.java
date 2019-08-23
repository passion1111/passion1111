package ex04.aop;

public class BookBeanImp implements BookBean {

	@Override
	public void testHello(String str) {
		System.out.println("testhello 호출됨.");
	
	}

	@Override
	public int korHello() {   //여기는 aspect가 적용안됨 왜냐하면 expression에 없기떄문에
		System.out.println("여기는 코헬로 호추추충ㄹ");
		return 5;
	}

}
