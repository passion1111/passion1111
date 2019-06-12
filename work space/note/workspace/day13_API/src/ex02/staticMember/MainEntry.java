package ex02.staticMember;

class Atm {
	int count; // instance member
	static int total;  // static member
	
	public Atm(int amount) { //constructor method
		count += amount; //count = count + amount;
		total += amount;  // total = total + amount;
	}
	// static member���� �Ϲݸ�������� ����� �� ����.
	public static void view() {
		total = total + 100;
		//count = count + 100;
	}
	
	// static member���� this ��� �� �� ����.
	public static void show(int count, int total) {
//		this.count = count;
//		this.total = total;
	}
		
	public void display() {
		System.out.println("count = " + count);
		System.out.println("total = " + total);
	}
	
} // Atm end

public class MainEntry {
	public static void main(String[] args) {
		System.out.println(Atm.total);
		Atm at = new Atm(1000);
		at.display();    // c: 1000, t: 1000
		System.out.println("------------------------");
		Atm at2 = new Atm(1000);
		at2.display();
		System.out.println("------------------------");
		Atm at3 = new Atm(1000);
		at3.display();
		
	}
}











