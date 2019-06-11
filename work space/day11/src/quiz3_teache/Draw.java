package quiz3_teache;

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
	//결과값 반환 calc라기보다는 getter
	public double calc() {
				
		return result;
	}

	@Override
	public String toString() {
		//바로 오버라이드할시 result값이 초기화값으로 나갈가능성이 있으므로 result값을 재정의해준코드가있나
		//확인해보는것이 좋다.
		return "Draw [w=" + w + ", h=" + h + ", result=" + result + "]";
	} 
	
	public void show() {
		System.out.println(w + ", " + h);
	}
	
	
}






