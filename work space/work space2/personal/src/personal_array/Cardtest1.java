package personal_array;
//클래스와 인스턴스의 이해.
public class Cardtest1 {
	public static void main(String[] args) {
		System.out.println("card.width"+Card.width);
		System.out.println("card.height"+Card.height);
		
		Card c1=new Card();
		c1.kind="Heart";
		c1.number=7;
		
		Card c2=new Card();
		c2.kind="Spade";
		c2.number=4;
		
		System.out.println("c1은"+c1.kind+","+c1.number+"이며,크기는("+c1.width+","+c1.height+")");
		
		
	}
}
class Card{
	String kind;   //카드의 무늬- 인스턴스 변수
	int number; //카드의 숫자-인스턴스 변수
	static int width=100; //카드의 폭 -클래스 변수
	static int height=250; //카드의 높이-클래스 변수
}

