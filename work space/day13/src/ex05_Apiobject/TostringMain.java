package ex05_Apiobject;

class Rect extends Object{ // �ڵ����� extends object���ְ��־���.
	int x,y;
	public void disp() {//�������Լ� ���θ������.
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
		System.out.println(r);//�迭�����θ� ���� tostring�ϰ������ String toString�������. 
	}
}
