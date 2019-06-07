package ex05_Apiobject;

class Rect extends Object{ // 자동으로 extends object해주고있었음.
	int x,y;
	public void disp() {//멤버출력함수 따로만들었음.
		System.out.println(x+","+y);
	}
	
//	public String toString() {
//		return x+","+y;
//	}
//}

@Override
	public String toString() {
		return "Rect [x=" + x + ", y=" + y + "]";
	}
	}

public class TostringMain {
	public static void main(String[] args) {
		Rect r=new Rect();
		System.out.println(r);//배열값으로만 나옴 tostring하고싶으면 String toString해줘야함. 
	}
}
