package ex07_stringbuffer;

public class Stringbuffer {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		
		System.out.println(sb.hashCode());
		System.out.println("length  / capacity");
		int len=sb.length();
		int size=sb.capacity();
		System.out.println(len+"    /        "+size); //StringBuffer default 16����
		
		sb.append("bitcamp");
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size); //7/16
		
		sb.append("bitcampbitbitcampcamp"); //   32����Ʈ+\n���� \n���ڴ� ĳ���� 2����Ʈ �׷��� 34����Ʈ
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size);
	
	
		sb.append("32232332"); // 34�� ����� �þ �׷��� 70 
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size);


		sb.trimToSize();//�뷮ũ�� ����.
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size);
		
		System.out.println(sb.hashCode());//�ؽ��� ����.�׷��Ƿ� ���ڿ��߰��ϸ� ���� �������� ���� �߰���.
							//��Ʈ�� Ŭ�������������ִ� �������� �ذ���.
		
	}

}
