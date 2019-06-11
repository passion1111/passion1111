/*
package quiz.lotto;

public class Homework1 {
	public static void main(String[] args) 	{
		int[] num = new int[6]; //�ζ� ���� 1���� �迭
		int i=0; //for
			
		for(i=0;i<num.length;i++){  //�ζǹ�ȣ ����
			num[i] =(int)(Math.random()*45)+1;				
		}
		
		System.out.println("�ζǹ�ȣ�� : ");
		//�ζ� ���� �� ���� ����
		for(int j=0;j<num.length;j++){
			
			for(i=0;i<num.length;i++){
				
				if( num[i]==num[j]  &&  j != i )	{  //���� �� ���� ����?
					num[i] = (int)(Math.random()*45)+1;
					j=0;
				} // if end
			} // i end
		} // j end
		
		//�ζǹ�ȣ ���
		for(i=0;i<num.length;i++){ 
			System.out.print(num[i]+"\t");
		}
	}
}
//*/

/*
package quiz.lotto;

import java.util.Scanner;

public class Homework1 {
		public static void main(String[] args) 	{
			Scanner sc = new Scanner(System.in);
			int correct = 0;//�ζǹ�ȣ�� �Է¹�ȣ�� ��ġ�� ��� ������ üũ�ϴ� ������ ����
			int ans[] = new int[6];//�ζ� ��÷��ȣ ������ ũ�� 6�� int�� �迭
			int input[] = new int[6];//����ڿ��� �Է¹��� ũ�� 6�� int�� �迭
			int deungsu=0;//����� �����ϴ� int�� ����
			
			System.out.println("*<*<*<*<*<*<*<*<�ζ�>*>*>*>*>*>*>*>*");
			System.out.println("\t���� 6��(1-45)�� �Է����ּ���");
			System.out.println("------------------------------------------------------");
			for(int i=0;i<ans.length;i++){
				ans[i] = (int)((Math.random()*45)+1);
				
				for(int j=i; j >=0 ; j--){
					if( i != j ) 	{
						while(ans[i]==ans[j]){
							ans[i] = (int)((Math.random()*45)+1);
						}//while end
					}//if end
				}//j end
				
				System.out.print("["+(i+1)+"]��>> ");
				input[i] = sc.nextInt();//����ڿ��� 1-45 ������ ���� 6���� �Է¹���
				while(input[i]<1||input[i]>45){// ����ڰ� ������ �߸��Է��Ѱ�� while���ݺ�
					System.out.print("\t1-45������ ���� �Է°���. �ٽ��Է��ϼ��� >> ");
					input[i] = sc.nextInt();//����ڿ��� 1-45 ������ ���� 6���� �ٽ� �Է¹���
				}//while end		
			}//i end
			
			for(int i=0;i<ans.length;i++){
				for(int j=0;j<ans.length;j++){
					if(input[j]==ans[i])
						correct++;
				}
			}
			
			System.out.println("\n-----------------------------------------------------------");
			System.out.print("�ζ� ��÷��ȣ!!!! >> ");
			for(int i=0;i<ans.length;i++)
				System.out.printf("%3d",ans[i]);
			System.out.print("\n����� �Է¹�ȣ >> ");
			for(int i=0;i<ans.length;i++)
				System.out.printf("%3d",input[i]);
			deungsu = (correct==6)? 1 :
												(correct==5)? 2 :
																	(correct==4)?3 :
																						(correct==3)?4 :
																											(correct==2)? 5 : 0;
			if(deungsu!=0)
				System.out.println("\n<*<*< "+deungsu+"� ��÷�Ǽ̽��ϴ�! >*>*>");//6����ġ-1��. 5����ġ-2��. 4����ġ-3��. 3����ġ-4��. 2����ġ-5��. ������-������ȸ��...
			else
				System.out.println("\n\n������ȸ��..........");
			System.out.println(correct+"�� ��ġ.");
			System.out.println("-----------------------------------------------------------");
			
		}
}
//*/

//*
package quiz.lotto;

public class Homework1 {
	//�ζ� ���α׷� �����. 1~45���� �߿��� 6�� ����, �ߺ��� ���� �ۼ�.
		public static void main(String[] args) 	{
			int[] arr = new int[6];
			int lottoNum = 0;
			
			for (int i=0; i<arr.length; i++) {
				lottoNum = (int)(Math.random()*45+1);  // 
				
				for (int j=0; j<i; j++) { // ���� ��ȣ ����� ó��
					while (lottoNum == arr[j]) {
						lottoNum = (int)(Math.random()*45+1);
						arr[i] = lottoNum;
						j=0; 
					} //while end
				} // j end
				arr[i] = lottoNum;
			} // i end
			
			System.out.print("���� Lotto ��÷ ��ȣ : ");
			for (int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");	
			}
		}
}
//*/