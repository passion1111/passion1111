package homework.ex2;

public class Customer {  //model
	//
	protected String name;
	protected String add;
	protected String tel;
	
	//
	Customer(){
	}
	Customer(String name, String add, String tel){
		this.name = name;
		this.add = add;
		this.tel = tel;
	}
	
	//
	public void display(){
		System.out.println("�̸�    : " + name);
		System.out.println("�ּ�    : " + add);
		System.out.println("����ó : " + tel);
	}// display()
	
}// Customer
