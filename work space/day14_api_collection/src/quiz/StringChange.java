package quiz;

public class StringChange {
	public static void main(String[] args) {
		/*String str="abcDEFGHeijwEMPYmnpw";
		String result="";
		char[] result2=str.toCharArray();
		for(int i=0;i<result2.length;i++) {
			if(result2[i]>=65&&result2[i]<90) {
				result2[i]=(char) (result2[i]+32);
				result+=result2[i];
			}
			else if(result2[i]>=97&&result2[i]<=122) {
				result2[i]=(char) (result2[i]-32);
				result+=result2[i];
			}
		System.out.println(result);	
		}
	
		
		str.ap
		*/
	
		String str="abcDEFGHeijwEMPYmnpw";
		String result="";
		 for (int i = 0; i < str.length(); i++) {
		      char temp;
		      if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
		        temp = (char)(str.charAt(i) - 32);
		      }
		      else if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
		        temp = (char)(str.charAt(i) + 32);
		      }
		      else {
		        temp = str.charAt(i);
		      }

		      result+=temp;
		    }
		   System.out.println(result);
		   
		  //또는 String.valueof메소드를 이용하여 char하나를 더 만들어서\
//		  비교하는것을 만들면 String.valueof(ch).touppercase , to lowercase로 비교하면 된다.
		   
		  }
	
}

