package persnonal_teamproject;


import java.util.Scanner;
import java.util.Vector;



	

public class BergerMain {
	
	public static void main(String[] args) {
		Vector<Product> ProductVector=new Vector<Product>();
		Vector<Product> TempVector=new Vector<Product>();
		ProductVector.add(new Product(1,"¥���",6000,1));
		ProductVector.add(new Product(2,"«��",6000,1));
		ProductVector.add(new Product(3,"������",15000,1));
		
		
		Scanner sc=new Scanner(System.in);
		int ServiceSelect;
		int MenuSelect = 0;
		int AmountSelect;
		int TotalPrice = 0;
		int Racecard=1;
		
		//�� �Ʒ� select���� ���߿� DB���������� �׳� ������.
		int ExtraSelect=0;
		int DeliverySelect=0;
		
		
		
		do {
		    System.out.println("���Ͻô� ������ ���ڸ� �Է����ּ���."); //admin�� ���� ���븸.
		    while (!sc.hasNextInt()) {
		        System.out.println("���ڸ� �Էº�Ź�帳�ϴ�.");
		        sc.next(); 
		    }
		   ServiceSelect= sc.nextInt(); 
		 
		} while (ServiceSelect <= 0||ServiceSelect>4);  // ��ȿ�� �˻� �޼ҵ�� ��������. 
		
		while(true) { //��ü �ݺ�
			
		while(true) {//1�޴���ȣ���� 2.�������� ��Ų�� Ȯ��.
			
		for (int i = 0; i < ProductVector.size(); i++) {
			System.out.println("�޴� ��ȣ"+ProductVector.get(i).getPnum()
					+"\t�޴�"+ ProductVector.get(i).getProductName()
					+"\t����"+ProductVector.get(i).getPrice()					
					); //��� �޼ҵ�
		}
			
		//�޼ҵ�� ����� while�����鼭 break��� �ְ�.
			//
		  do {
			    System.out.println("���Ͻô� �޴��� ��ȣ�� �Է����ּ���.,���� ������ ���Ͻø� 4���� �Է����ּ���.");
			    while (!sc.hasNextInt()  ||  MenuSelect>ProductVector.size() || MenuSelect<0) {
			        System.out.println("�޴��� �ִ� ��ȣ�� ���ùٶ��ϴ�.");
			        sc.next(); 
			    }//Exception��Ż���ϴ� ��ȿ���˻�.
			MenuSelect=sc.nextInt();	
			
		}while(MenuSelect <= 0||MenuSelect>ProductVector.size());
		  
		 
	
			  do {
				    System.out.println("������ �������ּ���.");
				    while (!sc.hasNextInt()) {
//				    ���� �Է����ּ���.�Ǵ� ��� �����մϴ�. 
				        sc.next(); 
				    }
				AmountSelect=sc.nextInt();	
			}while(MenuSelect <= 0||MenuSelect>ProductVector.size());
			  
			  TempVector.add(ProductVector.get(MenuSelect-1)); //�����Ѱ��� ���
			 System.out.println("�ι�°"+TempVector.get(TempVector.size()-1
					 ).getAmount());
			  if(TempVector.size()>=2) {
				  for (int i = 0; i < TempVector.size(); i++) {
					 for (int j = 0; j < TempVector.size(); j++) {
						 if( TempVector.get(i).getPnum()==TempVector.get(j).getPnum()	& (!(i==j))  )
						 {
							 int TotalAmount=TempVector.get(i).getAmount()
		 								+AmountSelect;  //�ߺ��Ǵ� amount�� ����� 				 
							 TempVector.get(i).setAmount (TotalAmount ) ; 
							 TempVector.remove(j);
						 }else if(TempVector.get(i).getPnum()!=TempVector.get(j).getPnum()	) {
							 TempVector.get(TempVector.size()-1).setAmount(AmountSelect);
						 }
						 
					}
					 
				}
			  }else {TempVector.get(TempVector.size()-1).setAmount(AmountSelect);//������ ������. 
				  
			  }
			  
				 
//				�ߺ����Ÿ� ���� ������ 2�� for���̱⋚���� ���ɹ����� ����.
//			  ���� �޴� 2�� �Է��ϸ� ���� ǥ��� ��) ¥��� ¥��� �Է��ϸ� 2�� ǥ�� 
//			  �����ͺ��̽��� �ذ��ϸ� ����. �㳪 �����ͺ��̽� �Ⱦ��� size>=2����
//			  sort���ϴ°�ó�� ���ϰ� �ߺ� �޴� remove���� ���� Amount�� ������+�ؼ� ����ϸ��.
//			  �ƴϸ� set���ϸ� �Ǵµ� ����ڰ� �����Ѱ��� ������κ����������ϰ� �������� �����ְԵ�.
//			  Hashmap�� ���� vector�� ���°ź��� �� ���������ٰ� �����մϴ�.
			  
			  System.out.println("�ֹ��Ͻ� �޴�"); //������ �޴� Ȯ�ν�����.
			  TotalPrice=0;
			  for (int j = 0; j < TempVector.size(); j++) {
				  
				  System.out.println("�޴� :"+TempVector.get(j).getProductName()+
						  "\t����"+TempVector.get(j).getAmount());
				  TotalPrice+=TempVector.get(j).getAmount()*TempVector.get(j).getPrice();
				 
			  }
			  System.out.println("����"+TotalPrice);
			  
	  System.out.println("�߰��ֹ� �Ͻðڽ��ϱ�?  1.�� 2.�ƴϿ�");
			  ExtraSelect=sc.nextInt();
			  if(ExtraSelect==2)break;
			  
		}		  
			

		  //select�� �ϳ� �� ���� ���� Ȯ��
		
		  
		  System.out.println("�� �ֹ��Ͻ� �޴�"); //������ �޴� Ȯ�ν�����.
		  for (int j = 0; j < TempVector.size(); j++) {
			  System.out.println("�޴� :"+TempVector.get(j).getProductName()+
					  "\t����"+TempVector.get(j).getAmount());
			  
		  }
		 System.out.println("���� :"+TotalPrice);
		 
		 
		 //while��
//		 
//		 System.out.println("����Ͻ� �޴��� �����Ű���?");
//		 //���� �޾ƾ��� 1,2
////		 TempVector.remove(�Է¹�����-1);
//			System.out.println("�߰��ֹ� �Ͻðڽ��ϱ�?");
//		if(MenuSelect==7)	break;
//		}��ȿ���˻��ϰ� �ٲ����.
//	
//		
//		
//		
////		  
		 do { 
		 System.out.println("1.����Ļ� 2.���");
		 while(!sc.hasNextInt()) {
			System.out.println("1�Ǵ� 2�� �Է����ּ���");
		 }
		  DeliverySelect=sc.nextInt();
		 } while(DeliverySelect<0||DeliverySelect>3);
		  
		  //		  
		  
		 int CouponSelect=0;
		 int Coupon[]= {30,40,50,0};
		 do {
			 System.out.println("� ���� �������־? \n 1.30%���� ���� , 2.40%�������� , 3.50%�������� 4.����");
			 
			while(!sc.hasNextInt()) {
				System.out.println("���ڸ� �Է����ּ���");
				sc.next();
			}
		 CouponSelect=sc.nextInt();
			 
		 }while(CouponSelect>4||CouponSelect<=0);
		 

		  TotalPrice=TotalPrice*(100-Coupon[CouponSelect-1])/100;//���� Ŭ���� ���� �����ϱ� if������ 1��Ŭ���ϸ����� ��ü
		  System.out.println("������ �������� ���͵帱���? 1. ���� , 2. ī��");
		  int Select;
		  Select=sc.nextInt();
		  if(Select==2) {
			  System.out.println("ī�带 �Է����ּ���");
//		  �Է¹ޱ�
		  }

//		  Ŭ�������� �ϳ������ �����ͺ��̽��� ���̺��ϳ������
//		  ���ǥ.
		  String Bills ="";
//		  int Racecard=1;
		  for (int i = 0; i < TempVector.size(); i++) {
			Bills+=  TempVector.get(i).getProductName()+TempVector.get(i).getPrice()+"\t"+TempVector.get(i).getAmount()+"��"+
					"\n";

			  
		}
		  TempVector.removeAllElements(); //������ �Ϸ��ϰ� ��꼭�� ���������� 
		   Bills+="����  :"+TotalPrice+"\n����ȣ"+Racecard;
		   Racecard++;
		  System.out.println("��꼭\n"+Bills);
//		  �Ϸ� �Ż����� split���� �������� �迭�� ���� ��  ¦���� �����ֱ�.
//        DB�� �Ұ��̸� ���̺��ϳ� ���� �߰��߰�.
		}
		 	
	}
}

