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
		System.out.println("※비만도 데이터베이스 센터에 오신 것을 환영합니다※");
		int select = 0;
		while (true) {
			System.out.println("-----------------------------------------");
			do {
				System.out.print("작업을 선택하세요.\n(1.개인정보 추가 | 2.개인정보 삭제 | 3.파일출력 | 4.종료) : ");
				try {
					select = scan.nextInt();
				} catch (Exception e) {
					System.out.println("숫자만 입력하세요");
				} 
			} while (select !=1 && select !=2 && select !=3 && select !=4);
			
			switch (select) {
			case 1 : addPerson(BMIList, personalData); 	break;
			case 2 : delPerson(BMIList); break;
			case 3 : print2File(BMIList); break;
			case 4 : System.out.println("----------시스템을 종료합니다----------"); System.exit(0);
			default : System.out.println("다시 입력하세요");
			} while(select!=1 && select!=2 && select!=3 && select!=4);
		}
	}

	
	public HashMap addPerson(HashMap bMIList, ArrayList personalData) {
		personalData = new ArrayList();
		System.out.print("이름 : ");		name = scan.next();	
		while(BMIList.containsKey(name)) {
			System.out.print("이미 존재하는 이름이므로 숫자를 붙여주시기 바랍니다(예:park1, kim90) : ");
			name = scan.next();	
		}
		System.out.print("몸무게(kg) : ");		weight = scan.nextInt();	personalData.add(weight);
		System.out.print("키(cm) : ");			height = scan.nextInt();	personalData.add(height);
		System.out.print("비만도 : ");		
		// 비만도 측정 계산식
			BMI= weight/((height/100.0)*(height/100.0));	
			personalData.add(BMI);
			
			if(BMI < 18.5) BMIresult = "저체중";
				else if ((BMI>=18.5) && (BMI<=23) ) BMIresult = "정상"; 
				else BMIresult = "과체중";
			System.out.println("BMI = "+ BMI + " / " + BMIresult);
			
			personalData.add(BMIresult);
		BMIList.put(name,personalData);
		return BMIList;
	}
	
	public HashMap delPerson(HashMap bMIList) {
		System.out.print("지울 이름을 입력하세요 : ");
		String dname = scan.next();
		if (BMIList.containsValue(dname)) {
			BMIList.remove(dname);/////
			System.out.println("삭제가 완료되었습니다.");
		} else {
			System.out.println("해당 이름이 존재하지 않습니다.");
		}
		
		return BMIList;
	}
	
	public void print2File(HashMap bMIList) {

		//Iterator it = BMIList.entrySet().iterator();  ///요기도 변경해봄
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
			//Entry entry = (Entry)it.next();  //Entry 사용해봄...
			Map.Entry entry = (Map.Entry) it.next();
			System.out.println("이름 : " + entry.getKey() );  //+ ", Entry Value: " + entry.getValue());
			 ////////////////////////////////////////////////////////////////////////////   
		    personalData = (ArrayList) it.next();
		    for (int i=0; i<personalData.size();i++) {
		    	
		    	 switch (i) {
		    	 case 0 :  System.out.println("몸무게 : " + personalData.get(i) + "kg" );	break;
		    	 case 1 :  System.out.println("키 : " + personalData.get(i) + "cm" );		break;
		    	 case 2 :  System.out.printf("비만도 : " + personalData.get(i),"%.2f");	break;
		    	 case 3 :  System.out.println("\n판정 : <" + personalData.get(i) + ">" );	
		    	 }
		     }
		     
		 }
	}

}
