package ex02_interface_quiz;

public class Airplne implements Trans {
	String name;
	

	@Override
	public void start(String name) {
		this.name=name+start+"의 소리는 이류우우욱";

	}

	@Override
	public void stop(String name) {
		this.name=name+stop+"끼이이이이익";

	}
	
	

	@Override
	public void show(String name) {
		start(name);
		System.out.println(this.name);
		stop(name);
		System.out.println(this.name);
		
	}

}
