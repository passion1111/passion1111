package ex02_interface_quiz;

public class Bus implements Trans {
	String name;


	@Override
	public void start(String name) {
		this.name=name+start+"狼 家府绰 何快旷";
	}


	@Override
	public void stop(String name) {
		this.name=name+stop+"狼 家府绰 尝捞劳";
		
	}

	


	@Override
	public void show(String name) {
		start(name);
		System.out.println(this.name);
		stop(name);
		System.out.println(this.name);
		
	}


}
