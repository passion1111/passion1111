package quiz2;

import java.util.Scanner;

public class MainEntry {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num;
		
		while(true) {
			num=sc.nextInt();
			if(num==1){
				Bmi.Bmiadd();
			}
			else if(num==2) {
				Bmi.modify();
			}else if(num==3) {
				Bmi.print();
			}else if(num==4) {
				Bmi.delete();
			}else if(num==5) {
				System.exit(0);
			}else if(num==6) {
				FileSave a=new FileSave();
			}
			
		}
		
		
	}
}
