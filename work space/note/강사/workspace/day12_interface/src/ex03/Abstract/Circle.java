package ex03.Abstract;

public class Circle extends Shape {  // Sub class

	@Override
	public double calc(double x) {
		result = x * x * Math.PI;
		return result;
	}

	@Override
	public void show(String name) {
		calc(5.5);
		System.out.println(result + " �������� " + name + "�� �׷������ϴ�.");

	}

}
