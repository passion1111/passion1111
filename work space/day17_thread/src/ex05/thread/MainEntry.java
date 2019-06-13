package ex05.thread;
//synchronized할려면
// 형식
// public synchronized void 메소드명(데이터타입 변수,데이터타입 변수){
//       임계영역
//}
//형식2 
// public  void 메소드명(데이터타입 변수,데이터타입 변수){
//  synchronized(this){
//            임계영역..
//}
//}

class Atm {
	private int moneny;
	
	public Atm(int money) {
		this.moneny = money;
	}
	
	//입금함수 
	public synchronized void deposit(int amount, String name) {
		moneny += amount;
		System.out.println(name + " : 입금금액 " + amount);
	}
	
	//출금함수
	public void withdraw(int amount, String name) {
		
		synchronized(this) {
			if((moneny - amount) > 0) {
				
//				Thread.yield();  //
				
				moneny -= amount;
				System.out.println(name + " : 출금금액 " + amount);
			} else {
				System.out.println(name + " : 출금못함(잔액 부족~~~)");
			}
		}//end synchronized
	}
	
	//통장잔고 함수
	public void getMoney() {
		System.out.println("         잔액은 : " + moneny);
	}
	
}// Atm end

class UserAtm extends Thread {
	Atm obj;
	boolean flag = false;
	
	public UserAtm(Atm obj, String name) {
		super(name);
		this.obj = obj;
	}

	@Override
	public void run() { //스레드 실행부
		for(int i=0; i < 2; i++) {
			
			try {
				sleep(50);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if( flag ) {
				obj.deposit((int)(Math.random() * 10 + 2) * 100, getName());
				obj.getMoney();
			} else {
				obj.withdraw((int)(Math.random() * 10 + 2) * 100, getName());
				obj.getMoney();
			} // if end
			flag = true;
			
		} // for end
	}
	
} // UserAtm end


public class MainEntry {
	public static void main(String[] args) {
		Atm at = new Atm(1000);//같은 ATM이기떄문에 문제생김.
		
		UserAtm user1 = new UserAtm(at, "박정희");
		UserAtm user2 = new UserAtm(at, "전두환");//다 같은 불법복제
		UserAtm user3 = new UserAtm(at, "노태우");
		
		user1.start();
		user2.start();
		user3.start();
	}
}







