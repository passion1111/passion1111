package ex03_abstract;

public class Circle extends Shape {

	@Override
	public double calc(double x) {
		
		result=x*x*Math.PI;
		return result;
	}

	@Override
	public void show(String name) {
		calc(5);
		System.out.println(name+"ÀÇ ³ÐÀÌ´Â"+result);
		

	}

	@Override
	public double calc(double x, double y) {
		// TODO Auto-generated method stub
		return 0;
	}

}
