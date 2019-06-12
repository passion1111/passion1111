package ex07.stringBuffer;

public class StringBufferEx01 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
		System.out.println(sb.hashCode());  //366712642
		
		System.out.println("length    /    capacity");
		int len = sb.length(); 	int size = sb.capacity();
		System.out.println(len +"      /       " + size);
		
		sb.append("bitCamp");
		len = sb.length();		size = sb.capacity();
		System.out.println(len +"      /       " + size);
		
		sb.append("happyvirus");
		len = sb.length();		size = sb.capacity();
		System.out.println(len +"      /       " + size);
		
		sb.append("12345 67890");
		len = sb.length();		size = sb.capacity();
		System.out.println(len +"      /       " + size);
		
		sb.append("sfksjfks 392482954");
		len = sb.length();		size = sb.capacity();
		System.out.println(len +"      /       " + size);
		
		System.out.println(sb.hashCode()); //366712642
		
		sb.trimToSize();  //용량 크기 조정
		len = sb.length();		size = sb.capacity();
		System.out.println(len +"      /       " + size);
		
	}
}










