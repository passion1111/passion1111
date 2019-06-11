package quiz.three;

import java.util.Scanner;

public class Employee { // Super class
	protected int empNo;
	protected String name, dept, phone;
	
	Scanner sc = new Scanner(System.in);
	
	public Employee() {
//		int num;
//		System.out.print("empNo = ");
//		this.empNo = sc.nextInt();
//		System.out.print("name = ");
//		this.name = sc.next();
//		System.out.print("dept = ");
//		this.dept = sc.next();
//		System.out.print("phone = ");
//		this.phone = sc.next();
	}
	
	public void input() { //�Է� �޼ҵ�
		System.out.print("empNo = ");
		this.empNo = sc.nextInt();
		System.out.print("name = ");
		this.name = sc.next();
		System.out.print("dept = ");
		this.dept = sc.next();
		System.out.print("phone = ");
		this.phone = sc.next();
	}

	public Employee(int empNo, String name, String dept, String phone) {
		this.empNo = empNo;
		this.name = name;
		this.dept = dept;
		this.phone = phone;
	}
	
	public Employee(int empNo) {
		this(empNo, null, null, null);
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void display() {
		System.out.println("�����ȣ : " + empNo + "\n�̸� : " + name);
		System.out.println("�μ� : " + dept + "\n����ó : " + phone);
	}
	
}











