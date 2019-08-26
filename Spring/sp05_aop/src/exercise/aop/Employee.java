package exercise.aop;

public class Employee implements Print {
	
	private String name,job ;
	private int age;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub		
		System.out.println("?ù¥Î¶? :"+name+" ?Çò?ù¥ : "+age+" ÏßÅÏóÖ : "+job);
	}

}
