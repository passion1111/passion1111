package ex02_interface_quiz;

public class Bus implements Trans {
	String name;


	@Override
	public void start(String name) {
		this.name=name+start+"�� �Ҹ��� �ο��";
	}


	@Override
	public void stop(String name) {
		this.name=name+stop+"�� �Ҹ��� ������";
		
	}

	


	@Override
	public void show(String name) {
		start(name);
		System.out.println(this.name);
		stop(name);
		System.out.println(this.name);
		
	}


}
