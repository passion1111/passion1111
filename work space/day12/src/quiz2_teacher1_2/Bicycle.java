package quiz2_teacher1_2;

public class Bicycle extends Trans {
	
	// 생성자
	Bicycle(){
		super.name = "자전거";
	}
	
	//
	@Override
	public void start() {
		System.out.println(name + " 출발합니다.");
	}

	@Override
	public void stop() {
		System.out.println(name + " 멈췄습니다.");
	}
}// Bicycle
