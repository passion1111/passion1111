package prob1;
 
public class Prob1 {
	public static void main(String[] args) {
		int seconds = 47567;
		
		System.out.println("<< " + seconds + " �� ��ȯ �ð� >>");
		System.out.println(printTime(seconds));
		
		seconds = 11578;
		System.out.println("<< " + seconds + " �� ��ȯ �ð� >>");
		System.out.println(printTime(seconds));
	}

	private static String printTime(int seconds) {
		int[] time = {3600, 60, 1};
		 String sum=  seconds/time[0]+"��"+seconds%time[0]/time[1]+"��"+seconds%time[0]%time[1]/time[2]+"��";
		return sum;
	}
}