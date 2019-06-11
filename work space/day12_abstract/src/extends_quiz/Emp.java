package extends_quiz;

import java.util.Scanner;

 class Emp {
	 String sabun;
	 String name;
	 String jic;
	 int num;
	 
	 public Emp() {
		 Scanner sc=new Scanner(System.in);
		 System.out.println("이름을 입력해주세요");
		 name=sc.nextLine();
		 System.out.println("사번을 입력해주세요.");
		 sabun=sc.nextLine();
		 System.out.println("직급을 입력해주세요");
		 jic=sc.next();
		 System.out.println("연락처를 입력해주세요");
		 num=sc.nextInt();
		 
	 }
	 
	 
	 
	 
	 
	 
	public String getSabun() {		return sabun;	}
	public void setSabun(String sabun) {		this.sabun = sabun;	}
	public String getName() {		return name;	}
	public void setName(String name) {		this.name = name;	}
	public String getJic() {		return jic;	}
	public void setJic(String jic) {		this.jic = jic;	}
	public int getNum() {		return num;	}
	public void setNum(int num) {		this.num = num;	}
	

}
