package quiz.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class BMImanager extends BMI {

	Scanner scan = new Scanner(System.in);
	
	public BMImanager() {
		System.out.println("�غ񸸵� �����ͺ��̽� ���Ϳ� ���� ���� ȯ���մϴ١�");
		int select = 0;
		while (true) {
			System.out.println("-----------------------------------------");
			do {
				System.out.print("�۾��� �����ϼ���.\n(1.�������� �߰� | 2.�������� ���� | 3.������� | 4.����) : ");
				try {
					select = scan.nextInt();
				} catch (Exception e) {
					System.out.println("���ڸ� �Է��ϼ���");
				} 
			} while (select !=1 && select !=2 && select !=3 && select !=4);
			
			switch (select) {
			case 1 : addPerson(BMIList, personalData); 	break;
			case 2 : delPerson(BMIList); break;
			case 3 : print2File(BMIList); break;
			case 4 : System.out.println("----------�ý����� �����մϴ�----------"); System.exit(0);
			default : System.out.println("�ٽ� �Է��ϼ���");
			} while(select!=1 && select!=2 && select!=3 && select!=4);
		}
	}

	
	public HashMap addPerson(HashMap bMIList, ArrayList personalData) {
		personalData = new ArrayList();
		System.out.print("�̸� : ");		name = scan.next();	
		while(BMIList.containsKey(name)) {
			System.out.print("�̹� �����ϴ� �̸��̹Ƿ� ���ڸ� �ٿ��ֽñ� �ٶ��ϴ�(��:park1, kim90) : ");
			name = scan.next();	
		}
		System.out.print("������(kg) : ");		weight = scan.nextInt();	personalData.add(weight);
		System.out.print("Ű(cm) : ");			height = scan.nextInt();	personalData.add(height);
		System.out.print("�񸸵� : ");		
		// �񸸵� ���� ����
			BMI= weight/((height/100.0)*(height/100.0));	
			personalData.add(BMI);
			
			if(BMI < 18.5) BMIresult = "��ü��";
				else if ((BMI>=18.5) && (BMI<=23) ) BMIresult = "����"; 
				else BMIresult = "��ü��";
			System.out.println("BMI = "+ BMI + " / " + BMIresult);
			
			personalData.add(BMIresult);
		BMIList.put(name,personalData);
		return BMIList;
	}
	
	public HashMap delPerson(HashMap bMIList) {
		System.out.print("���� �̸��� �Է��ϼ��� : ");
		String dname = scan.next();
		if (BMIList.containsValue(dname)) {
			BMIList.remove(dname);/////
			System.out.println("������ �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("�ش� �̸��� �������� �ʽ��ϴ�.");
		}
		
		return BMIList;
	}
	
	public void print2File(HashMap bMIList) {

		//Iterator it = BMIList.entrySet().iterator();  ///��⵵ �����غ�
		//Iterator it = bMIList.entrySet().iterator();
		//Set key = bMIList.keySet();
				
		 Set<Entry<String,String>> entrySet = BMIList.entrySet();
		 Iterator<Entry<String, String>> it = entrySet.iterator();
///////////////////////////////////////////////////////////////
		//Entry entry = (Entry)it.next();
		//Entry entry = (Entry)BMIList.keySet().iterator().next();
		//Entry entry = (Entry)BMIList.keySet();
				
		
		//System.out.println("000000 " + key);
		//for (int i = 0; i < BMIList.keySet().size(); i++) {
				//System.out.println(BMIList.keySet().iterator().next());
				//System.out.println(key);
		//}
		
	/*	for (Object mapkey :  BMIList.keySet()) { //for (Object mapkey :  bMIList.keySet()){
			System.out.println("key:"+mapkey+",value:"+bMIList.get(mapkey));
		}*/
		
		//System.out.println("bMIList.keySet().iterator().next() : " + bMIList.keySet().iterator().next() );
///////////////////////////////////////////////////////////////
	
		while(it.hasNext()) {
			System.out.println("----------------------");
			////////////////////////////////////////////////////////
			//Entry entry = (Entry)it.next();  //Entry ����غ�...
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println("�̸� : " + entry.getKey() );  //+ ", Entry Value: " + entry.getValue());
			 ////////////////////////////////////////////////////////////////////////////   
		    personalData = (ArrayList) it.next();
		    for (int i=0; i<personalData.size();i++) {
		    	
		    	 switch (i) {
		    	 case 0 :  System.out.println("������ : " + personalData.get(i) + "kg" );	break;
		    	 case 1 :  System.out.println("Ű : " + personalData.get(i) + "cm" );		break;
		    	 case 2 :  System.out.printf("�񸸵� : " + personalData.get(i),"%.2f");	break;
		    	 case 3 :  System.out.println("\n���� : <" + personalData.get(i) + ">" );	
		    	 }
		     }
		     
		 }
	}

}
