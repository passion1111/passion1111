package quiz2_teacher;

public class Subway extends Transport {  // Sub class

	@Override
	public void start(String trpt) {
		start = "���� ����մϴ�.";

	}

	@Override
	public void stop(String trpt) {
		stop = "���� ���ɴϴ�";

	}

	@Override
	public void display(String trpt) {
		System.out.println(trpt + "�� " + start + "\t" + trpt + "�� " + stop);

	}

}






