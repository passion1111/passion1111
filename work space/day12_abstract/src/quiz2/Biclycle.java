package quiz2;

public class Biclycle extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"�� ��� �Ҹ��� ����");

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"�� ���ߴ¼Ҹ��� �����Ű� �����");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);

	}

}
