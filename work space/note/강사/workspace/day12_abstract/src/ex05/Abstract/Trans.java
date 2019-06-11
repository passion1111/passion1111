package ex05.Abstract;

public abstract class Trans {  //추상클래스 , 수퍼클래스
	protected String name;
	
	abstract void start();
	abstract void stop();
	
	public String name(){
		return name;
	}// name
}// Trans
