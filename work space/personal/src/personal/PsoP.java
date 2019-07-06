package personal;
import java.util.Scanner;

public class PsoP {

	
	 
	
	
	 
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("총 학생 수: ");
	        int n = sc.nextInt(); // 학생수
	        String[] seatarr = new String[n]; // 자리
	        
	        // 이름 입력
	        for (int i = 0; i < seatarr.length; i++) {
	            int a = (int) (Math.random() * (n));;
	            for (int j = 0; j < seatarr.length;) {
	                if(seatarr[a] == null) {
	                    System.out.print("이름: ");
	                    seatarr[a] = sc.next();
	                    break;
	                } else {
	                    i--;
	                    break;
	                }
	            } // j for end
	            
	        } // i for end
	        
	        // 자리 출력
	        for(int i = 0; i < seatarr.length; i++) {
	            System.out.println((i+1) + "번 컴퓨터: " + seatarr[i]);
	        } // i for end
	        
	        sc.close();
	 
	    }
	}