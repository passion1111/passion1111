package method;


	//인스탄스 메소드:객체 생성하고 사용해야함
//메모리에 할당이 되어야
class B{
	int x,y;
//인스턴스 메소드
public void setData(int xx,int yy) {
	System.out.println(xx+","+yy);
}
}//b class end

public class instancemethod1{
	public static void main(String[] args) {
		
	 B b =new B(); //객체생성,메모리에 할당,생성자함수 호출
	 b.x=9;
	 b.setData(10,20);  //객체 생성해서 불러야한다. 클래스이름으로 못부름.
	}						//B라는 이름으로 부르지 못한다.
}
//대부분 인스턴스 메소드를 씀.