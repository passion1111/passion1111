package ex05.inheritance;

import java.util.Scanner;

public class Draw {  //Super class
	protected int w, h;    
	protected double result ;
	
	//생성자함수
	public Draw() {
		w = h = 0;		result = 0;
	}

	public Draw(int w, int h) {
		this.w = w;
		this.h = h;
	}

	//getter / setter method
	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public double getResult() {
		return result;
	}
	
	public double calc() {
				
		return result;
	}

	@Override
	public String toString() {
		
		return "Draw [w=" + w + ", h=" + h + ", result=" + result + "]";
	} 
	
	public void show() {
		System.out.println(w + ", " + h);
	}
	
	
}






