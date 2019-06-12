package ex03.Abstract;

public abstract class Shape { //Super class
	
	double result = 0;
	public abstract double calc(double x); //abstract mehtod
	public abstract void show(String name); //abstract mehtod
	public void shview()	{
		System.out.println("Super class Shape");
	}

}
