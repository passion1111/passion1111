package quiz1;
//���� video class
// title ���� ���� 
// category �帣
// lend �뿩����
// lendname �뿩��(����)
// lendDate �뿩����(���ó�¥ �Է�)
// map�� key���ְ� value��  videos�� �־��ָ� ��.
// video �߰�/����/video ����Ʈ���/����/���α׷� ���� ����ϴ� ���α׷� �ۼ�

import java.text.SimpleDateFormat;
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
		ArrayList<Im> arrlist=new ArrayList<Im>();
		arrlist.add(new Im());
			
		Scanner sc=new Scanner(System.in);
		System.out.println("Ÿ��Ʋ�� �Է����ּ���");
		this.title=sc.nextLine();
//		this.category=sc.nextLine();
//		this.lend=sc.nextInt(); ���߿� ����
//		map.put(title, category);
		map.put(title, arrlist.get(0)); //Ÿ��Ʋ������ arrlist��Ȯ��.
		
		
		//�ߺ�Ȯ�� �޼ҵ�
		Set set=map.entrySet();
		Iterator it=set.iterator();
//		while(it.hasNext()) { //lental Ŭ������ �̵�
//			Map.Entry e;
//		}
	
		while(it.hasNext()) {//
			Map.Entry e =(Map.Entry)it.next();//������ƮŸ���� Map.entryŸ�Կ� ���������ϴϱ� ������ ����ȯ�ʼ�
			System.out.println("��ȭ"+e.getKey()+",2���迭 ���Ͷ�:"+e.getValue());//Ű�� ��Ÿ���̱⋚���� ������ ������
			
		}
		
	
	}
	
	public void aa() {
		
	}
	
//	static void Category(String categoty) {
//		HashMap<String, String> category1=new HashMap<String, String>();
//		category1.put(sc.nextLine(),sc.nextLine() );
//		
//	}
//	
}

class Im {
	protected boolean lend;
	protected String lendname;
	protected String category;
	protected String formattedDate;
	
	
	
//	protected int lendDate;
	Im(){
		arrlist.set
		Calendar lendtalday=Calendar.getInstance();
		Calendar lendtaldate = Calendar.getInstance();
		Scanner sc=new Scanner(System.in);
		System.out.println("�̸��� �Է����ּ���");
		this.lendname=sc.nextLine();
		System.out.println("ī�װ��� �Է����ּ���");
		this.category=sc.nextLine();
		lendtaldate.add(Calendar.DATE, 1);//������� 1��
		SimpleDateFormat myDateFormat = new SimpleDateFormat("MM.dd.yyyy"); 
		this.formattedDate = myDateFormat.format(lendtaldate.getTime());
//		System.out.println(lendtaldate);
//		System.out.println(lendtalday);
		if(lendtalday.before(lendtaldate)) {
			lend=false;
			
		}
		else { lend=true; //��Ż ���� �Ұ��� ���޼ҵ�
		
		}
	}
	public boolean isLend() {
		return lend;
	}
	public void setLend(boolean lend) {
		this.lend = lend;
	}
	public String getLendname() {
		return lendname;
	}
	public void setLendname(String lendname) {
		this.lendname = lendname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getFormattedDate() {
		return formattedDate;
	}
	public void setFormattedDate(String formattedDate) {
		this.formattedDate = formattedDate;
	}
	@Override
	public String toString() {
		return "Im [�ݳ�����=" + lend + ", lendname=" + lendname + ", category=" + category + ", �ݳ�������="
				+ formattedDate + "]";
	}
	
}

public class quiz {
	public static void main(String[] args) {
		Video v;
		Im i;
		int num=0;
		Scanner sc=new Scanner(System.in);
		num=sc.nextInt();
		
		
		if(num==1) {
//			if(i.ha)
			
			
			
		}else if(num==2) {
			
			
			
		}else if(num==3) {
			
			
			
		}else if(num==4) {
			
			
			
		}else if(num==5) {
			System.out.println("�ý����� �����մϴ�.");
			System.exit(0);
		}
	
		

		
		
		}//���� end
	}//Ŭ���� end


