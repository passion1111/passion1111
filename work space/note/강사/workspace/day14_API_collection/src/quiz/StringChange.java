package quiz;

public class StringChange {
	public static void main(String[] args) {
		String str = "abcDEFGHeijwEMPYmnpw";
		String result = "";
		
		short sh = 32;
		int num = 45000;
		Object ob = "object";
		String msg = "string";
		
		//num = sh; // 묵시적형변환
		sh = (short)num;   // 명시적형변환
		
		//ob = msg;
		msg = (String)ob;
		
		System.out.println(sh + ", " + num);
		System.out.println(ob + ", " + msg);
		
		System.out.println("==========================");

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i); //

			//if (ch >= 65 && ch <= 90) {
			if (ch >= 'A' && ch <= 'Z') { // 대문자냐?
				result += String.valueOf(ch).toLowerCase();
				
			} else if (ch >= 'a' && ch <= 'z') { // 소문자냐?
				result += String.valueOf(ch).toUpperCase();
				//result +=  -32;
			} else {
				result += ch;
			} // if end
		} // for end

		System.out.println(result);

	}
}
