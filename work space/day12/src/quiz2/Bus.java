package quiz2;

public class Bus extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"의 출발소리는 부르릉");

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"의 멈추는 소리는 끼이익");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);

	}

}
