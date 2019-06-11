package quiz2_teacher1_2;

public class Subway extends Trans{
	
	// 생성자
	Subway(){
		super.name = "지하철";
	}
	
	//
	@Override
	public void start(){
		System.out.println(name + " 역을 출발합니다.");
	}
	@Override
	public void stop(){
		System.out.println(name + " 역에 도착했습니다.");
	}
}// Subway
