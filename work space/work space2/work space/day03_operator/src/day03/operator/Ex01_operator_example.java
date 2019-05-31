package day03.operator;
/* pay=567890;         팁 추가팁 한줄주소 컨트롤 슬러쉬,여러줄은 여러줄긁고 컨트롤+쉬프트+슬러쉬
   만원:5장                             해제는 컨트롤슬러쉬              해제는 컨+쉬+역슬러쉬
   천원:6장
   백원:7장
   십원:8장         
 */

public class Ex01_operator_example {
			public static void main(String[] args) {
				//int pay=567890;
				//만원:56장
				//천원:7장
			    //백원8개
				//십원9개
			int pay=567890;
			int Ma,Ch,Bac,Si;
			Ma=pay/10000;
			pay=pay%10000;
			Ch=pay/1000;
			pay=pay%1000;
			Bac=pay/100;
			pay=pay%100;
			Si=pay/10;
//코딩수 줄이기 Ma=pay/10000
			        //Ch=pay%10000/1000 ...으로적기 이렇게하면 pay값 안변함. 아니면 변수하나더.
			System.out.println("만원 :"+Ma+"장");
			System.out.println("천원 :"+Ch+"장");
			System.out.println("백원 :"+Bac+"개");
			System.out.println("십원 :"+Si+"개");
			
			
			}

}
