package ex02_interface_quiz;

public class Airplne implements Trans {
	String name;
	

	@Override
	public void start(String name) {
		this.name=name+start+"�� �Ҹ��� �̷�����";

	}

	@Override
	public void stop(String name) {
		this.name=name+stop+"������������";

	}
	
	

	@Override
	public void show(String name) {
		start(name);
		System.out.println(this.name);
		stop(name);
		System.out.println(this.name);
		
	}

}
