package ex04_enum1;


 enum UserStatus{ //Enum
	Peding,//���������� ������� ������ 
	ACTIVE,  //���������� static final
	INACTIVE,
	DELETE;
}
public class MainEntry {
	
	public static void main(String[] args) {
		//1.
		System.out.println(UserStatus.ACTIVE);
		//2.
		for(UserStatus status : UserStatus.values() ) {
			System.out.println(status);
		}
		
		
	}
}
