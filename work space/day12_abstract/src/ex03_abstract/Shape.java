package ex03_abstract;

public abstract class Shape {
	double result =0;
	public abstract double calc(double x);//�߻� �޼ҵ�
	public abstract double calc(double x,double y);
	public abstract void show(String name);//�߻�޼ҵ�
	public void view() {
		System.out.println("Super class Shape");
	}

}
