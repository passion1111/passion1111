package quiz2;

public class Bus extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"�� ��߼Ҹ��� �θ���");

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"�� ���ߴ� �Ҹ��� ������");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);

	}

}
