package ex05.Abstract;

public class Airplane extends Trans {
	
	// 생성자
	Airplane(){
		super.name = "비행기";
	}

	//
	@Override
	public void start() {
		System.out.println(name + " 이륙합니다.");
	}

	@Override
	public void stop() {
		System.out.println(name + " 착륙합니다.");
	}

}// Airplane
