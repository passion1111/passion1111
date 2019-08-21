package ex02.di;

public class Student implements Person {
	String name;
	String gender;
	int age;
	
	@Override
	public void info() {

		System.out.println(name+ gender+age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
