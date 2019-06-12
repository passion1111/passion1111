package quiz.three;

public class Reqular extends Employee {  //Sub class
	protected int pay;
	
	public Reqular() {
//		super.input();
//		System.out.print("pay = ");
//		pay = sc.nextInt();
	}
	
	public void input() {
		super.input();
		System.out.print("pay = ");
		pay = sc.nextInt();
	}

	public Reqular(int empNo, String name, String dept, String phone, int pay) {
		super(empNo, name, dept, phone);
		this.pay = pay;
	}
	
	public Reqular(int pay) {
		this.pay = pay;
	}
	
	public void display() {
		super.display();
		System.out.println("±Þ¿© : " + pay);
	}
	
}









