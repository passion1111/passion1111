package array3;
//1���� �迭 String[] str={'a','k','P','D','y'}

public class Mainentry_quiz {
	public static void main(String[] args) {
		 String[] str={"a","kbs","Park","D","you"};
		 char[] str2={'a','k','P','D','y'};
	
			for(int i=0;i<str.length;i++) {
				System.out.print(str[i]+"\t");
				System.out.print("\n"+str[i].charAt(0)+"\n");
				
			}
			System.out.println("\n=================");
			for(int i=0;i<str2.length;i++) System.out.print(str2[i]+"\t");
			
		
		}
	}
	