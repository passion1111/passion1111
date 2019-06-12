package quiz.two;

import java.util.ArrayList;
import java.util.HashMap;

public class BMI {
	String name, BMIresult;
	int weight, height;
	double BMI;
	ArrayList personalData = new ArrayList();
	HashMap BMIList = new HashMap<>();
	

	public BMI() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getBMI() {
		return BMI;
	}

	public void setBMI(int bMI) {
		BMI = bMI;
	}
	
	
}
