package quiz4;

import java.util.Scanner;

public class Student extends Person {
	private String ha2,ha3,hac;

	public Student() {
		Scanner sc=new Scanner(System.in);	
		System.out.println("�а����Է��ϼ���");
		ha2=sc.nextLine();
		
		System.out.println("�й��� �Է��ϼ���");
		ha3=sc.nextLine();
		
		System.out.println("�г��� �Է��ϼ���");
		hac=sc.nextLine();
		
	}
	
	
	
	public String getHa2() {
		return ha2;
	}

	@Override
	public String toString() {
		return "Student [�а�=" + ha2 + ", �й�=" + ha3 + ", �г�=" + hac + ", �̸�=" + name + ", Ű=" + height
				+ ", ������=" + weight + "]";
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
