package quiz;

public class StringChange {
	public static void main(String[] args) {
		String str = "abcDEFGHeijwEMPYmnpw";
		String result = "";
		
		short sh = 32;
		int num = 45000;
		Object ob = "object";
		String msg = "string";
		
		//num = sh; // ����������ȯ
		sh = (short)num;   // ���������ȯ
		
		//ob = msg;
		msg = (String)ob;
		
		System.out.println(sh + ", " + num);
		System.out.println(ob + ", " + msg);
		
		System.out.println("==========================");

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i); //

			//if (ch >= 65 && ch <= 90) {
			if (ch >= 'A' && ch <= 'Z') { // �빮�ڳ�?
				result += String.valueOf(ch).toLowerCase();
				
			} else if (ch >= 'a' && ch <= 'z') { // �ҹ��ڳ�?
				result += String.valueOf(ch).toUpperCase();
				//result +=  -32;
			} else {
				result += ch;
			} // if end
		} // for end

		System.out.println(result);

	}
}
