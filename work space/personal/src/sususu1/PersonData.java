package sususu1;

import java.util.ArrayList;

public class PersonData {
	static ArrayList<Customer> customerList = new ArrayList<Customer>();
	static int customernumber = 6;
	
	
	public static void CreatePerson() {
		Customer cust1 = new Customer(1, "������", "������", "010-1111-1111");
		Customer cust2 = new Customer(2, "������", "�Ⱦ��", "010-2222-2222");
		Customer cust3 = new Customer(3, "������", "ȣ�赿", "010-3333-3333");
		Customer cust4 = new Customer(4, "������", "������", "010-4444-4444");
		Customer cust5 = new Customer(5, "������", "�Ǳ���", "010-5555-5555");
		Vip vipCust1 = new Vip(9, 6, "�Ӱ��", "�Ǳ���", "010-8888-5555");

		customerList.add(cust1);
		customerList.add(cust2);
		customerList.add(cust3);
		customerList.add(cust4);
		customerList.add(cust5);
		customerList.add(vipCust1);
	}
	
	public static void PersonAdd(String name,String address ,String phoneno){
		PersonData.customerList.add(new Customer(++customernumber, name, address, phoneno));
	}
}
