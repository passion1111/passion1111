package quiz4;

import java.util.Scanner;

public class Student extends Person {
	private String ha2,ha3,hac;

	public Student() {
		Scanner sc=new Scanner(System.in);	
		System.out.println("학과를입력하세요");
		ha2=sc.nextLine();
		
		System.out.println("학번을 입력하세요");
		ha3=sc.nextLine();
		
		System.out.println("학년을 입력하세요");
		hac=sc.nextLine();
		
	}
	
	
	
	public String getHa2() {
		return ha2;
	}

	@Override
	public String toString() {
		return "Student [학과=" + ha2 + ", 학번=" + ha3 + ", 학년=" + hac + ", 이름=" + name + ", 키=" + height
				+ ", 몸무게=" + weight + "]";
	}



	public void setHa2(String ha2) {
		this.ha2 = ha2;
	}

	public String getHa3() {
		return ha3;
	}

	public void setHa3(String ha3) {
		this.ha3 = ha3;
	}

	public String getHac() {
		return hac;
	}

	public void setHac(String hac) {
		this.hac = hac;
	}
	
	
	
	
}
