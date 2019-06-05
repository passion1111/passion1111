package extends_quiz;

public class Sales extends Reguler{
	
	int commission;
	public Sales() {
		
		switch(jic) {
		case "사장":commission=50000; break;
		case "사원":commission=10000; break;
		}
		don=commission+super.don;
	}

	
	public int getCommission() {		return commission;	}
	@Override
	public String toString() {
	
		
		return "Sales [commission=" + commission + ", don=" + don + ", sabun=" + sabun + ", name=" + name + ", jic="
				+ jic + ", num=" + num + "]";
	}


	public void setCommission(int commission) {		this.commission = commission;	}

	public void display() {
		System.out.println("이름"+name+"사번"+sabun+"직급"+jic+"급여"+don);
	}
}
