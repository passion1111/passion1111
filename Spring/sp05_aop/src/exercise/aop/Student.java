package exercise.aop;

public class Student implements Print {
	
	private String name,grade,group ;
	private int age;
	
	public Student() {	}
	
	
	public Student(String name, int age, String grade, String group) {  // DI
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.group = group;
	}


	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("?ù¥Î¶? :"+name+" ?Çò?ù¥ : "+age+" ?ïô?ÖÑ : "+grade+" Î∞?: "+group);
	}

}
