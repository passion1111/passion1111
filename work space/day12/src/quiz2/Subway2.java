package quiz2;

public class Subway2 extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"�� ��� �Ҹ��� ������ ����ϰڽ��ϴ�.");

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"�� ���ߴ¼Ҹ��� ������");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);
		
		// TODO Auto-generated method stub

	}

}
