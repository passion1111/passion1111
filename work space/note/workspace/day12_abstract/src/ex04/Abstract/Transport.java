package ex04.Abstract;

public abstract class Transport { //abstract  class
	String start, stop;
	
	public abstract void start(String trpt);
	public abstract void stop(String trpt);
	public abstract void display(String trpt);
	 
}
