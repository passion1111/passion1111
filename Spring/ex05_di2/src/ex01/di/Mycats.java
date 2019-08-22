package ex01.di;

import java.util.ArrayList;

public class Mycats {

	private String name;
	private int age;
	private ArrayList<String> hobbys;
	private double weight;
	private String color;

	
	public Mycats(String name, int age, double weight, String color,ArrayList<String> hobbys) {
		super();
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.color = color;
		this.hobbys=hobbys;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public ArrayList<String> getHobbys() {
		return hobbys;
	}


	public void setHobbys(ArrayList<String> hobbys) {
		this.hobbys = hobbys;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
}
