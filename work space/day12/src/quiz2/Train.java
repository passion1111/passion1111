package quiz2;

public class Train extends Trans {

	@Override
	public void start(String name) {
		System.out.println(name+"狼 免惯家府绰 蘑蘑气气");
		

	}

	@Override
	public void stop(String name) {
		System.out.println(name+"狼 肛眠绰 家府档 蘑蘑气气");

	}

	@Override
	public void show(String name) {
		start(name);
		stop(name);

	}

}
