package ex03_abstract;

public class Rect extends Shape {
	
	@Override
	public double calc(double x,double y) {
		result=x*y;
		return result;
	}

	@Override
	public void show(String name) {
		calc(5,4);
		System.out.println(name+"�� ���̴�"+result+"�Դϴ�.");

	}

	@Override
	public double calc(double x) {
		// TODO Auto-generated method stub
		return 0;
	}


}
