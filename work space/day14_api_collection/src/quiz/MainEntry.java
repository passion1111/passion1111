package quiz;

import java.util.ArrayList;
import java.util.Scanner;

//�� �߰� /����/������Ʈ ���/����/���α׷� ���� ����ϴ� ���α׷� �ۼ�
class Customer{
	ArrayList name=new ArrayList();
	ArrayList address=new ArrayList();
	ArrayList tel=new ArrayList();
	Scanner sc=new Scanner(System.in);
	int confirm;
	public void input(int total) {
		
		for (int i = 0; i < total; i++) {
			
			name.add(sc.next());
			address.add(sc.next());
			tel.add(sc.next());
		}						
	}
	
	
	
	public ArrayList getName() {
		return name;
	}
	public void setName(ArrayList name) {
		this.name = name;
	}
	public ArrayList getAddress() {
		return address;
	}
	public void setAddress(ArrayList address) {
		this.address = address;
	}
	public ArrayList getTel() {
		return tel;
	}
	public void setTel(ArrayList tel) {
		this.tel = tel;
	}
	
	
	public void i(int confirm){
		switch(confirm) {
		case 1:
			
			this.name.set(this.name.indexOf("����"), "����");
			
			break;
			
		case 2:  
			
			this.address.remove(sc.next());
			
			break;
			
		case 3: 
			this.tel.remove(sc.next());
			break;
			
		}
		
		
	}
	
	
	public void delete(int confirm){  //���� �޼ҵ�
		switch(confirm) {
		case 1:
			this.name.remove(sc.next());
			
			break;
			
		case 2:  
			
			this.address.remove(sc.next());
			
			break;
			
		case 3: 
			this.tel.remove(sc.next());
			break;
			
		}		
		
	}
	
	
}
public class MainEntry {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Customer c=new Customer();
		c.input(3);
		System.out.println(c.name.get(c.name.indexOf("d")));
		
		
		
		
		
		
	}
}
