package ex4.coolection.map;
//���� video class
// title ���� ���� 
// category �帣
// lend �뿩����
// lendname �뿩��(����)
// lendDate �뿩����(���ó�¥ �Է�)
// map�� key���ְ� value��  videos�� �־��ָ� ��.
// video �߰�/����/video ����Ʈ���/����/���α׷� ���� ����ϴ� ���α׷� �ۼ�

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

//ūƲ ������ ��ü����Ȯ���ϰ� 
class Video{
	protected String title;
//	protected String category;
//	protected int lend;
//	protected String lendname;
//	protected int lendDate;
	Video(){
		HashMap map=new HashMap();
		HashMap map2=new HashMap();
		ArrayList<Lental> arrlist=new ArrayList<Lental>();
		arrlist.add(new Lental());
			
		Scanner sc=new Scanner(System.in);
		System.out.println("Ÿ��Ʋ�� �Է����ּ���");
		this.title=sc.nextLine();
//		this.category=sc.nextLine();
//		this.lend=sc.nextInt(); ���߿� ����
//		map.put(title, category);
		map.put(title, arrlist); //Ÿ��Ʋ������ arrlist��Ȯ��.
		
		
		//�ߺ�Ȯ�� �޼ҵ�
		Set set=map.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()) {
			Map.Entry e;
		}
		
//		while(it.hasNext()) {
//			
//		}
				
	}
	
	
//	static void Category(String categoty) {
//		HashMap<String, String> category1=new HashMap<String, String>();
//		category1.put(sc.nextLine(),sc.nextLine() );
//		
//	}
//	
}
class Lental{
	protected boolean lend;
	protected String lendname;
	protected String category;
//	protected int lendDate;
	Lental(){
		Calendar lendtalday=Calendar.getInstance();
		Calendar lendtaldate = Calendar.getInstance();
		Scanner sc=new Scanner(System.in);
		System.out.println("�̸��� �Է����ּ���");
		this.lendname=sc.nextLine();
		System.out.println("ī�װ��� �Է����ּ���");
		this.category=sc.nextLine();
		lendtaldate.add(Calendar.DATE, 1);//������� 1��
		
		if(lendtaldate.before(lendtalday)) {
			lend=false;
		}
		else lend=true;  //��Ż ���� �Ұ��� ���޼ҵ�
	}
	
}

public class quiz {
	public static void main(String[] args) {
		Video v=new Video();
		
	   
		}
	}

