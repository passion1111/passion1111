package ex02_staticmember;
//static 
class Atm{
	int count;//인스턴스 멤버 <-- 객체가 생성돼야 쓸수있음
	static int total; //<--메모리상에 올려져있어여.
	
	public Atm(int amount){//생성자 함수.
		count+=amount;
		total+=amount;
	}
	public static void view() {
		total=total+100;
//		count=count+100;//스태틱 메소드(member)에서 일반 멤버변수사용할수없음.
	}
	
	public  void show(int count,int total) {
//		this.count=count;
//		this.total = total; //static member는 this사용할수없음 어차피 변수는 계속 공유되니까.
	}
	
	public void display() {
		System.out.println("count ="+count);
		System.out.println("total ="+total);
	
	}
		
	
	
	
}//atm end

public class MainEntry {
	public static void main(String[] args) {
		System.out.println(Atm.total);
		Atm at=new Atm(1000);//c:1000,t:1000
		at.display();
		System.out.println("=============");
		Atm at2=new Atm(1000);
		at2.display();
		System.out.println("==============");
		Atm at3=new Atm(1000);
		at3.display();
	}
}//end mainentry
