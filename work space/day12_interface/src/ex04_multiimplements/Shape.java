package ex04_multiimplements;

public abstract class Shape {
	double result =0;
	public abstract double calc(double x);//추상 메소드
	public abstract double calc(double x,double y);
	public abstract void show(String name);//추상메소드
	public void shview() {
		System.out.println("Super class Shape");
	}

}
