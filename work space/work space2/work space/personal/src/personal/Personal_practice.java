package personal;


public class Personal_practice {
			public static void main(String[] args) {

				String str1=new String("wqdwq@dwqdwq.cdlr.dw");
				String str2="322-221";
				String str3=new String("");
				
				str3=str1.concat(str2);
				
				System.out.println(str3);
				System.out.println(str1.substring(0,5));
				int strlength=str2.length();
				System.out.println(strlength);
				System.out.println(str1.toUpperCase());
				System.out.println(str1.matches("\\w+@(^\\s]*)"));
				System.out.println(str2.matches("\\d{3}+-([^\\s]*)"));
			}
}			

//�빮�ڰ� �ִ��� �빮�ڰ� �߰��� @�� �ִ��� ���ڰ� 3�ڸ��� �̷�����ִ���.
