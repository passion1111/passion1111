package quiz4;
//Person class - super class
// �̸�,Ű,������

import java.util.Scanner;

//����� ��ӹ޴� sub class
//student class-�а�,�й�,�г�
//Professor -��ȣ,����(��,��,�ܷ�),����а�

//Main 
public class Person {
	protected String name;
	protected int height,weight;
	
	
	public Person(){
		Scanner sc=new Scanner(System.in);
		System.out.println("�̸��� �Է��ϼ���");
		name=sc.nextLine();
		System.out.println("Ű�� �Է��ϼ���");
		height=sc.nextInt();
		System.out.println("�����Ը� �Է��ϼ���");
		weight=sc.nextInt();
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHeight() {
		return height;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	

}
