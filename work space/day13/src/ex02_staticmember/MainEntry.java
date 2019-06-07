package ex02_staticmember;
//static 
class Atm{
	int count;//�ν��Ͻ� ��� <-- ��ü�� �����ž� ��������
	static int total; //<--�޸𸮻� �÷����־.
	
	public Atm(int amount){//������ �Լ�.
		count+=amount;
		total+=amount;
	}
	public static void view() {
		total=total+100;
//		count=count+100;//����ƽ �޼ҵ�(member)���� �Ϲ� �����������Ҽ�����.
	}
	
	public  void show(int count,int total) {
//		this.count=count;
//		this.total = total; //static member�� this����Ҽ����� ������ ������ ��� �����Ǵϱ�.
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
