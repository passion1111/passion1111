package ex05.aop;

public class Salaryman implements Person {

	@Override
	public void info(String name, int age) {
		System.out.println("이름"+name+"나이"+age+"직급은 대리");
		
	}

}
