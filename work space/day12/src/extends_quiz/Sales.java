package extends_quiz;

public class Sales extends Reguler{
	
	int commission;
	public Sales() {
		
		switch(jic) {
		case "����":commission=50000; break;
		case "���":commission=10000; break;
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
		System.out.println("�̸�"+name+"���"+sabun+"����"+jic+"�޿�"+don);
	}
}
