package quiz2;

public class Train extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"�� ��߼Ҹ��� ĢĢ����");
		

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"�� ���ߴ� �Ҹ��� ĢĢ����");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);

	}

}
