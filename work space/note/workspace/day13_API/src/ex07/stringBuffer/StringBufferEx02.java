package ex07.stringBuffer;

public class StringBufferEx02 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("This");
		System.out.println(sb);
		
		sb.append(" is pencil"); //���ڿ� �߰�
		System.out.println(sb);
		
		sb.insert(7, " my");  //���ڿ� ���� 
		System.out.println(sb);
		
		sb.replace(8, 10, "your");  //���ڿ� ����(��ü)
		System.out.println(sb);
		
		sb.setLength(5);
		System.out.println(sb);
		System.out.println(sb.capacity());
		
		sb.setLength(20); // ??!!
		System.out.println(sb);
		
	}
}










