package personal_array;
//Ŭ������ �ν��Ͻ��� ����.
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
		
		System.out.println("c1��"+c1.kind+","+c1.number+"�̸�,ũ���("+c1.width+","+c1.height+")");
		
		
	}
}
class Card{
	String kind;   //ī���� ����- �ν��Ͻ� ����
	int number; //ī���� ����-�ν��Ͻ� ����
	static int width=100; //ī���� �� -Ŭ���� ����
	static int height=250; //ī���� ����-Ŭ���� ����
}
