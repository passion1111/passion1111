package personal;
import java.util.Scanner;

public class PsoP {

	
	 
	
	
	 
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("�� �л� ��: ");
	        int n = sc.nextInt(); // �л���
	        String[] seatarr = new String[n]; // �ڸ�
	        
	        // �̸� �Է�
	        for (int i = 0; i < seatarr.length; i++) {
	            int a = (int) (Math.random() * (n));;
	            for (int j = 0; j < seatarr.length;) {
	                if(seatarr[a] == null) {
	                    System.out.print("�̸�: ");
	                    seatarr[a] = sc.next();
	                    break;
	                } else {
	                    i--;
	                    break;
	                }
	            } // j for end
	            
	        } // i for end
	        
	        // �ڸ� ���
	        for(int i = 0; i < seatarr.length; i++) {
	            System.out.println((i+1) + "�� ��ǻ��: " + seatarr[i]);
	        } // i for end
	        
	        sc.close();
	 
	    }
	}