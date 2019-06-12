package ex03.Enum;

/*enum 열거형 - 새로운 클래스 타입을 정의하는것
- 특정한 값만을 가질 수 있는 데이터 타입을 정의 할때 필요하다.
형식>
[접근지정자] enum 열거형이름 {  필요한 상수들 나열,..... }*/


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









