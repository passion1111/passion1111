package extends_quiz;

public class Reguler extends Emp {
	int don;
	
	public Reguler(){
		
		switch(jic) {
		case "����":don=250000;break;
		case "���":don=100000;break;
		default : don=400;break;
		}
		
	}
	public void display() {
		System.out.println("�̸�"+name+"���"+sabun+"����"+jic+"�޿�"+don);
	}

	public int getDon() {
		return don;
	}


	public String toString() {
		
		return "Reguler [don=" + don + ", sabun=" + sabun + ", name=" + name + ", jic=" + jic + ", num=" + num + "]";
	}
	

}
