package ex06.string;

public class MainEntry {
	public static void main(String[] args) {
		int x = 999;
		String str = "abc";
		System.out.println("str : " + str);
		
		char[] data = {'k', 'b', 's'};
		str = new String(data);
		System.out.println("str : " + str);
		System.out.println("kbs");
		
		String msg = "cdefghij 231314";
		System.out.println("korea " + msg); //korea cdefghij
		System.out.println(msg);  // cdefghij
		
		msg = msg.concat(" korea"); // ���ڿ� ����
		System.out.println(msg);
		
		String str2 = "abcdef".substring(2); // �߰� ���ڿ� ����
		System.out.println(str2); //cdef
		
		str2 = "abcdefg1237814krjkwej".substring(2, 5); // ���۰� ����, ���� ������
		System.out.println(str2); //cde
		
		System.out.println(msg + " : " + str2);
	}
}










