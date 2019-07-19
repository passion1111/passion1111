package edu.bit;

public class Emp {

	private int empno;
	private String name;
	private int pay;
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", name=" + name + ", pay=" + pay + "]";
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
