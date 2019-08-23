package ex05.aop;

public class Student implements Person {

	@Override
	public void info(String name, int age) {
		System.out.println("이름"+name+"나이"+age+"3학년 2반");
		
	}

}
