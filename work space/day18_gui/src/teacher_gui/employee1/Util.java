package teacher_gui.employee1;

public class Util {
	public static String tokor(String str) {
		try {
			byte[] b = str.getBytes("euc-kr"); // "utf-8"
			return new String(b);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static String toLatin(String str) {
		try {
			byte[] b = str.getBytes(); 
			return new String(b, "euc-kr");
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
