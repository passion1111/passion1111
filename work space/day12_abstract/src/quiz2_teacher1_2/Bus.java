package quiz2_teacher1_2;

public class Bus extends Trans{
	
	// ������
	Bus(){
		super.name = "����";
	}
	
	//
	@Override
	public void start(){
		System.out.println("�������� ����մϴ�.");
	}
	@Override
	public void stop(){
		System.out.println("�����忡 �����߽��ϴ�.");
	}
}// Bus
