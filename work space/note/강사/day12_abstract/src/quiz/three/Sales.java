package quiz.three;

public class Sales extends Reqular { // Sub class
	
	private double commision, result;
	
	public Sales() {
		super.input();
		System.out.print("commision = ");
		commision = sc.nextDouble();
	}

	public Sales(int empNo, String name, String dept, String phone, int pay, double commision) {
		super(empNo, name, dept, phone, pay);
		this.commision = commision;
	}
	
	public Sales(double commision) {
		this.commision = commision;
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	public double getResult() {  // setter method X
		return result;
	}

	public double getResult(int pay, double commision) { 
		
		return pay * commision;
	}
	
	public void display() {
		double result2 = getResult(super.pay, commision);
		super.display();
		System.out.println("commision : " + (commision) 
				 + "%, ½Ç±Þ¿© : " + (super.pay + result2) );
	}
}














