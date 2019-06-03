package quiz01.oop;


	
class Departmetn {
	private String department;

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {

		this.department = department;
	}
	
	
	public void output() {
		System.out.println("부서: "+department);
	}	

}

class Don {
	private int don;

	public int getDon() {		return don;	}

	public void setDon(int don) {		this.don = don;	}
	
	public void output() {

		System.out.println("급여: "+don);

	}

}//돈

class Name{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void output() {
		System.out.println("이름 :"+name);

	}
}//이름

class Sajang {
	private String boo;

	public String getBoo() {
		return boo;
	}

	public void setBoo(String boo) {
		this.boo = boo;
	}
		public void output() {
			System.out.println("부서: "+boo);
		}	
	}
	
	

//직급

class Number {
	private String number;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number=number;
	}
	public void output() {
		System.out.println("연락처: "+number);
	}	
}	
	


	




public class Sawn{
	public static void main(String[] args) {
		Number n=new Number();
		Sajang s=new Sajang();
		Name na=new Name();
		Don d=new Don();
		Departmetn de=new Departmetn();
		n.setNumber("010-34-34");
		s.setBoo("직위는직위");
		na.setName("이름");
		d.setDon(10000);
		de.setDepartment("옆집부서");
		
		na.output();
		s.output();
		n.output();
		d.output();
		de.output();
		
	}
		
	}

