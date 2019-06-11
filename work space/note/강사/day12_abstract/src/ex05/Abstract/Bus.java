package ex05.Abstract;

public class Bus extends Trans{
	
	// 생성자
	Bus(){
		super.name = "버스";
	}
	
	//
	@Override
	public void start(){
		System.out.println("정류장을 출발합니다.");
	}
	@Override
	public void stop(){
		System.out.println("정류장에 도착했습니다.");
	}
}// Bus
