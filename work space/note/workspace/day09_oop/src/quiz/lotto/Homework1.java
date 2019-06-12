/*
package quiz.lotto;

public class Homework1 {
	public static void main(String[] args) 	{
		int[] num = new int[6]; //로또 담을 1차원 배열
		int i=0; //for
			
		for(i=0;i<num.length;i++){  //로또번호 추출
			num[i] =(int)(Math.random()*45)+1;				
		}
		
		System.out.println("로또번호는 : ");
		//로또 같은 수 인지 판정
		for(int j=0;j<num.length;j++){
			
			for(i=0;i<num.length;i++){
				
				if( num[i]==num[j]  &&  j != i )	{  //같은 수 인지 판정?
					num[i] = (int)(Math.random()*45)+1;
					j=0;
				} // if end
			} // i end
		} // j end
		
		//로또번호 출력
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
			int correct = 0;//로또번호와 입력번호의 위치가 몇개가 같은지 체크하는 정수형 변수
			int ans[] = new int[6];//로또 당첨번호 저장할 크기 6인 int형 배열
			int input[] = new int[6];//사용자에게 입력받을 크기 6인 int형 배열
			int deungsu=0;//등수를 저장하는 int형 변수
			
			System.out.println("*<*<*<*<*<*<*<*<로또>*>*>*>*>*>*>*>*");
			System.out.println("\t숫자 6개(1-45)를 입력해주세요");
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
				
				System.out.print("["+(i+1)+"]번>> ");
				input[i] = sc.nextInt();//사용자에게 1-45 사이의 숫자 6개를 입력받음
				while(input[i]<1||input[i]>45){// 사용자가 범위를 잘못입력한경우 while문반복
					System.out.print("\t1-45사이의 수만 입력가능. 다시입력하세요 >> ");
					input[i] = sc.nextInt();//사용자에게 1-45 사이의 숫자 6개를 다시 입력받음
				}//while end		
			}//i end
			
			for(int i=0;i<ans.length;i++){
				for(int j=0;j<ans.length;j++){
					if(input[j]==ans[i])
						correct++;
				}
			}
			
			System.out.println("\n-----------------------------------------------------------");
			System.out.print("로또 당첨번호!!!! >> ");
			for(int i=0;i<ans.length;i++)
				System.out.printf("%3d",ans[i]);
			System.out.print("\n사용자 입력번호 >> ");
			for(int i=0;i<ans.length;i++)
				System.out.printf("%3d",input[i]);
			deungsu = (correct==6)? 1 :
												(correct==5)? 2 :
																	(correct==4)?3 :
																						(correct==3)?4 :
																											(correct==2)? 5 : 0;
			if(deungsu!=0)
				System.out.println("\n<*<*< "+deungsu+"등에 당첨되셨습니다! >*>*>");//6개일치-1등. 5개일치-2등. 4개일치-3등. 3개일치-4등. 2개일치-5등. 나머지-다음기회에...
			else
				System.out.println("\n\n다음기회에..........");
			System.out.println(correct+"개 일치.");
			System.out.println("-----------------------------------------------------------");
			
		}
}
//*/

//*
package quiz.lotto;

public class Homework1 {
	//로또 프로그램 만들기. 1~45숫자 중에서 6개 추출, 중복수 없게 작성.
		public static void main(String[] args) 	{
			int[] arr = new int[6];
			int lottoNum = 0;
			
			for (int i=0; i<arr.length; i++) {
				lottoNum = (int)(Math.random()*45+1);  // 
				
				for (int j=0; j<i; j++) { // 같은 번호 추출시 처리
					while (lottoNum == arr[j]) {
						lottoNum = (int)(Math.random()*45+1);
						arr[i] = lottoNum;
						j=0; 
					} //while end
				} // j end
				arr[i] = lottoNum;
			} // i end
			
			System.out.print("금주 Lotto 당첨 번호 : ");
			for (int i=0; i<arr.length; i++) {
				System.out.print(arr[i] + " ");	
			}
		}
}
//*/