package ex01.di;

public class Main {
public static void main(String[] args) {
	Calc c=new Calc();
	System.out.println(c.add(5, 6));
	System.out.println(c.minus(3, 2));
	System.out.println(c.mul(3, 2));
	System.out.println(c.na(6, 2));
}
}
