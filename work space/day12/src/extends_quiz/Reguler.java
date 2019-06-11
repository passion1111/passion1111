package extends_quiz;

public class Reguler extends Emp {
	int don;
	
	public Reguler(){
		
		switch(jic) {
		case "사장":don=250000;break;
		case "사원":don=100000;break;
		default : don=400;break;
		}
		
	}
	public void display() {
		System.out.println("이름"+name+"사번"+sabun+"직급"+jic+"급여"+don);
	}

	public int getDon() {
		return don;
	}


	public String toString() {
		
		return "Reguler [don=" + don + ", sabun=" + sabun + ", name=" + name + ", jic=" + jic + ", num=" + num + "]";
	}
	

}
