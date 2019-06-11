package quiz4;
//Person class - super class
// 이름,키,몸무게

import java.util.Scanner;

//사람을 상속받는 sub class
//student class-학과,학번,학년
//Professor -번호,직급(전,조,외래),담당학과

//Main 
public class Person {
	protected String name;
	protected int height,weight;
	
	
	public Person(){
		Scanner sc=new Scanner(System.in);
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		System.out.println("키를 입력하세요");
		height=sc.nextInt();
		System.out.println("몸무게를 입력하세요");
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
