package quiz2;

public class Subway2 extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"의 출발 소리는 열차를 출발하겠습니다.");

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"의 멈추는소리는 끼이익");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);
		
		// TODO Auto-generated method stub

	}

}
