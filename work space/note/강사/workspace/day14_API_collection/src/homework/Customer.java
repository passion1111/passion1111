package homework;

import java.util.Scanner;

public class Customer {
	public static int cnum = 0;
	private String name;
	private String address;
	private String tel;
	Scanner sc = new Scanner(System.in);

	public Customer() {  // ����Ʈ �������Լ�
		System.out.print("�̸��� �Է��Ͻÿ� : ");		name = sc.next();
		System.out.print("�ּҸ� �Է��Ͻÿ� : ");		address = sc.next();
		System.out.print("��ȭ��ȣ�� �Է��Ͻÿ� : ");	tel = sc.next();
	}

	// setter/getter method
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return " [name=" + name + ", address=" + address + ", tel=" + tel + "]";
	}

}
