package com.domain;

public class EmpDTO {
	int empno;
	String name,deptno;
	int pay ;
	public EmpDTO(){}
	public EmpDTO(int empno, String name, String deptno, int pay) {
		this.empno = empno;
		this.name = name;
		this.deptno = deptno;
		this.pay = pay;

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
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
}
