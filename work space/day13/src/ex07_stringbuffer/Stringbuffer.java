package ex07_stringbuffer;

public class Stringbuffer {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		
		System.out.println(sb.hashCode());
		System.out.println("length  / capacity");
		int len=sb.length();
		int size=sb.capacity();
		System.out.println(len+"    /        "+size); //StringBuffer default 16글자
		
		sb.append("bitcamp");
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size); //7/16
		
		sb.append("bitcampbitbitcampcamp"); //   32바이트+\n문자 \n문자는 캐릭터 2바이트 그래서 34바이트
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size);
	
	
		sb.append("32232332"); // 34의 배수로 늘어남 그래서 70 
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size);


		sb.trimToSize();//용량크기 조정.
		len=sb.length();		size=sb.capacity();
		System.out.println(len+"    /        "+size);
		
		System.out.println(sb.hashCode());//해쉬값 같음.그러므로 문자열추가하면 원래 힙영역의 값에 추가함.
							//스트링 클래스가가지고있는 문제점을 해결함.
		
	}

}
