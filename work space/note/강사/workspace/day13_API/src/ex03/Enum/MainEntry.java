package ex03.Enum;

/*enum ������ - ���ο� Ŭ���� Ÿ���� �����ϴ°�
- Ư���� ������ ���� �� �ִ� ������ Ÿ���� ���� �Ҷ� �ʿ��ϴ�.
����>
[����������] enum �������̸� {  �ʿ��� ����� ����,..... }*/


	enum UserStatus {
		PENDING,
		ACTIVE,
		INACTIVE,
		DELETE ;
	}

public class MainEntry {
	public static void main(String[] args) {
		//1.
		System.out.println(UserStatus.DELETE);
		System.out.println("----------------");
		//2.
		for(UserStatus status : UserStatus.values() ) {
			System.out.println(status);
		}
	}
}









