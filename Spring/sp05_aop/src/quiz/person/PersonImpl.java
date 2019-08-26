package quiz.person;

public class PersonImpl implements Person {

	@Override
	public void student(String name, int age, int grade, String ban) {
		System.out.println("학생");
		System.out.println("이름: "+ name +", 나이: "+ age +", 학년: "+ grade +", 반: "+ ban );
	}

//	@Override
//	public void employee(String name, int age, String job) {
//		System.out.println("직장인");
//		System.out.println("이름: "+ name +", 나이: "+ age +", 직업: "+ job );
//	}

}
