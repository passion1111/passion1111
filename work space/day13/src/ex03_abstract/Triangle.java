package ex03_abstract;

public class Triangle extends Shape {

	@Override
	public double calc(double x) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public void show(String name) {
		calc(5.5,5.4);
		System.out.println(name+"ÀÇ ³ÐÀÌ´Â"+result);

	}


	@Override
	public double calc(double x, double y) {
			result=x*y/2;
		return result;
	}

}
