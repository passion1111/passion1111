package quiz2_teacher1_2;

public class Subway extends Trans{
	
	// ������
	Subway(){
		super.name = "����ö";
	}
	
	//
	@Override
	public void start(){
		System.out.println(name + " ���� ����մϴ�.");
	}
	@Override
	public void stop(){
		System.out.println(name + " ���� �����߽��ϴ�.");
	}
}// Subway
