package quiz2;

public class Biclycle extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"의 출발 소리는 없음");

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"의 멈추는소리는 자전거가 멈춰요");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);

	}

}
