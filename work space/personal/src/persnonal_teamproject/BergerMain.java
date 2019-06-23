package persnonal_teamproject;


import java.util.Scanner;
import java.util.Vector;



	

public class BergerMain {
	public static void main(String[] args) {
		Vector<Product> ProductVector=new Vector<Product>();
		Vector<Product> TempVector=new Vector<Product>();
		ProductVector.add(new Product(1,"짜장면",6000,1));
		ProductVector.add(new Product(2,"짬뽕",6000,1));
		ProductVector.add(new Product(3,"탕수육",15000,1));
		
		
		Scanner sc=new Scanner(System.in);
		int ServiceSelect;
		int MenuSelect = 0;
		int AmountSelect;
		int TotalPrice = 0;
		int ExtraSelect=0;
		int DeliverySelect=0;
		do {
		    System.out.println("원하시는 서비스의 숫자를 입력해주세요.");
		    while (!sc.hasNextInt()) {
		        System.out.println("숫자를 입력부탁드립니다.");
		        sc.next(); 
		    }
		   ServiceSelect= sc.nextInt(); // 유효서 검사 메소드로 만들어야함.
		} while (ServiceSelect <= 0||ServiceSelect>4);
		
		
		while(true) {//1메뉴번호선택 2.수량선택 시킨것 확인.
			
		for (int i = 0; i < ProductVector.size(); i++) {
			System.out.println("메뉴 번호"+ProductVector.get(i).getPnum()
					+"\t메뉴"+ ProductVector.get(i).getProductName()
					+"\t가격"+ProductVector.get(i).getPrice()					
					); //출력 메소드
		}
			
		//메소드로 만들고 while돌리면서 break기능 있게.
			
		  do {
			    System.out.println("원하시는 메뉴를 번호를 입력해주세요.");
			    while (!sc.hasNextInt()  ||  MenuSelect>ProductVector.size() || MenuSelect<0) {
			        System.out.println("메뉴에 있는 번호를 선택바랍니다.");
			        sc.next(); 
			    }//setter메소드
			MenuSelect=sc.nextInt();	

		}while(MenuSelect <= 0||MenuSelect>ProductVector.size());
		  
		  
	
			  do {
				    System.out.println("수량을 선택해주세요.");
				    while (!sc.hasNextInt()) {
//				    숫자 입력해주세요.또는 재고가 부족합니다. 
				        sc.next(); 
				    }
				AmountSelect=sc.nextInt();	
			}while(MenuSelect <= 0||MenuSelect>ProductVector.size());
			  
			  TempVector.add(ProductVector.get(MenuSelect-1)); //선택한것을 담고
			  TempVector.get(MenuSelect-1).setAmount(AmountSelect);//수량도 정해줌.
//			  데이터베이스로 해결하면 간단. 허나 데이터베이스 안쓸시 size>=이상부터
//			  sort비교하는것처럼 비교하고 중복 remove한후 기존 setAmount에 기존값+해서 계산하면됨.
			  
			  System.out.println("주문하신 메뉴"); //수량과 메뉴 확인시켜줌.
			  for (int j = 0; j < TempVector.size(); j++) {
				  System.out.println("메뉴 :"+TempVector.get(j).getProductName()+
						  "\t수량"+TempVector.get(j).getAmount());
				  TotalPrice=TempVector.get(j).getAmount()*TempVector.get(j).getPrice();
			  }
			 System.out.println("총합 :"+TotalPrice);
			 
			  
			  
			  System.out.println("추가주문 하시겠습니까?  1.예 2.아니오");
			  if(ExtraSelect==2)break;
			  
		}		  
			
			  
			
		  
		  
		  
		
		  //select문 하나 더 만들어서 담긴것 확인
		
		  
		  System.out.println("총 주문하신 메뉴"); //수량과 메뉴 확인시켜줌.
		  for (int j = 0; j < TempVector.size(); j++) {
			  System.out.println("메뉴 :"+TempVector.get(j).getProductName()+
					  "\t수량"+TempVector.get(j).getAmount());
			  TotalPrice=TempVector.get(j).getAmount()*TempVector.get(j).getPrice();
		  }
		 System.out.println("총합 :"+TotalPrice);
		 
		 
		 //while문
//		 
//		 System.out.println("취소하실 메뉴가 있으신가요?");
//		 //선택 받아야함 1,2
////		 TempVector.remove(입력받은수-1);
//			System.out.println("추가주문 하시겠습니까?");
//		if(MenuSelect==7)	break;
//		}
//	
//		
//		
//		
////		  
		 do { 
		 System.out.println("1.매장식사 2.배달");
		 while(!sc.hasNextInt()) {
			System.out.println("1또는 2를 입력해주세요");
		 }
		  DeliverySelect=sc.nextInt();
		 } while(DeliverySelect<0||DeliverySelect>3);
		  
		  //		  
		  
		 int CouponSelect=0;
		 int Coupon[]= {30,40,50};
		 do {
			 System.out.println("어떤 쿠폰 가지고있어여? \n 1.30%할인 쿠폰 , 2.40%할인쿠폰 , 3.50%할인쿠폰");
			 
			while(!sc.hasNextInt()) {
				System.out.println("숫자를 입력해주세요");
				sc.next();
			}
		 CouponSelect=sc.nextInt();
			 
		 }while(CouponSelect>4||CouponSelect<=0);
		 

		  TotalPrice+=TotalPrice*Coupon[CouponSelect];;//쿠폰 클래스 만들어서 적용하기 if문으로 1번클릭하면으로 대체
		  System.out.println("결제는 무엇으로 도와드릴까요? 1. 현금 , 2. 카드");
		  int Select;
		  Select=sc.nextInt();
		  
////		  
////		  
//		  
////		  이 전체과정을 while문으로 적용하기.
//		
//	

		 
	}
}

