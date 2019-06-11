package ex03_collection_list;
import java.util.*;
public class VectorEx02 {
	public static void main(String[] args) {
		int i;
		Date date=new Date();
		Vector v=new Vector(3,5);
		
		v.addElement("자바"); //String 
		v.addElement(new Double(10.2)); //Double
		v.addElement(date); //객체 object
		System.out.println("========3개 객체 추가");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		
		for (int j = 0; j < 10; j++) {
			v.addElement(new Integer(j));
		}
		System.out.println("------객체 10개 추가-----");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		
		System.out.println("------Vector 내용 출력----");
		Enumeration enu=v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
	
		System.out.println("-------객체 내용 포함 확인");
		if(v.contains("자바"))System.out.println("자바 문자열 있음");  // contains api확인하면 object
//		왜냐하면 모든 데이터타입을 받아들이기 위함 contains는 판별을 위해 주로 사용
		else System.out.println("미포함");
		
		System.out.println("--------10.2객체의 위치값 확인"+v.indexOf(new Double(10.2)));
//		첫번쨰로 확인됨 그러므로 
		System.out.println("입력 시간 :"+date);
		System.out.println(v.get(v.indexOf(date)));//중첩가능 v안에 메소드넣어서 중첩하는것.
		
	//	date 객체 삭제
//		v.remove() 실제 이름으로 삭제 ex)v.remove("자바") <-자바들어간에 삭제
		v.removeElementAt(v.lastIndexOf(date));//뒤에서부터 삭제할것을 확인
		System.out.println("*************************");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());//삭제된것 확인.
		System.out.println(v);
		
		for (int j = 0; j < v.size(); j++) {
			v.removeElementAt(j);
		}
//		v.removeAllElements(); //이건 다 지우는거 이거쓰면 다지워짐
//		v.remove(new Integer(9)); 자료형이 겹친상태(스트링+인트)에서 지울려면 클래스형으로 지워버림. 
		System.out.println("*************************");
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		System.out.println(v); //다 안지워지고 6개가 남아있음 왜냐하면 지워지며 떙겨져서 그럼여
//		                       remove를 해도 똑같음 0번지워지면 1번이 0번으로감.
//		for (int j = 0; j < v.size(); j++) {
//			System.out.println(v.get(j));
//		}//무슨객체남았는지 확인
		
		System.out.println("------------------------");
		v.setElementAt("java", 2);//3번쨰 위치에 java문자열 추가
		enu=v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		v.trimToSize();
		System.out.println("size: "+v.size()+", capacity"+v.capacity());
		
		System.out.println("------------set size----------");
		v.setSize(2);//크기를 강제로 2로 조정.
		enu=v.elements();
		while(enu.hasMoreElements()) {
			System.out.println(enu.nextElement());
		}
		System.out.println("다 지우기");
		v.removeAllElements();
		System.out.println(v);

	}
}
