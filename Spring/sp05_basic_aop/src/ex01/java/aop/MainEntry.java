package ex01.java.aop;

public class MainEntry {

	public static void main(String[] args) {
		Cal cal = new Cal();
		System.out.println(cal.Add(10000, 10000));
		System.out.println(cal.Mul(10000, 10000));
	}

}
