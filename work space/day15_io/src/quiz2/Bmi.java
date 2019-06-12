package quiz2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//비만도 측정 프로그램 작성하기 -collection,file io 이용하기
// 추가 삭제 출력 종료 처리할것
// 몸무게 키를 입력받아서 BMI계산하기
//BMI = 몸무게 / ( (키 / 100.0) * (키 / 100.0) )  ;
// 남 : (신장cm-100) X 0.9
// 여 : (신장cm-100) X 0.85
//판정>
//18.5미만 체중부족
//18.5~22.89 정상
//23.0~24.9 과체중
//
public class Bmi {
	static HashMap<String, Bmi> map=new HashMap<String, Bmi>();
	int height;
	int weight;
	double bmi;
	String sex;
	String name;
	String status;
	
	Bmi(){		
	}
	Bmi(int height,int weight,String name){
		Scanner sc=new Scanner(System.in);
		this.weight=weight;
		this.height=height;
		this.name=name;
		System.out.println("성별을 입력하세요(ex.남/여");
		
		System.out.println("남자면1,여자면2");
		int num=sc.nextInt();
		if(num==1) {
			this.bmi=(weight/((height/100.0)*(height/100.0)))*0.9;//또는 메소드 calcmale 호출
			this.sex="남자";
			
		}else if(num==2) {
			this.bmi=(weight/((height/100.0)*(height/100.0)))*0.85;;
			this.sex="여자";
		}
		
		if(bmi<18.5) {
			status="체중부족";
		}else if(18.5<=bmi&&bmi<=22.9) {
			status="정상";
		}else if(23.0<=bmi&&bmi<=24.9) {
			status="과체중";
		}else if(bmi>=25) {
			status="비만";
		}
		else status="?!";
		
	}
	
	public static void Bmiadd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("이름을 입력해주세요:");
		String name=sc.next();
		System.out.println("몸무게를 입력해주세요");
		int weight=sc.nextInt();
		System.out.println("키를 입력해주세요");
		int height=sc.nextInt();
		map.put(name, new Bmi(height,weight,name));
	}
	 	public static  double Bmiclacmale(int height,int weight) {
	 		double bmi;
	 		bmi=(weight/((height/100.0)*(height/100.0)))*0.9;
	 		return bmi;
	 	}
	 	public static double Bmiclacfemale(int height,int weight) {
	 		double bmi;
	 		bmi=(weight/((height/100.0)*(height/100.0)))*0.85;
	 		return bmi;
	 	}
	 	
		public static void modify(){
			Scanner sc=new Scanner(System.in);
			System.out.println("변경하실 이름을 입력해주세요");
			String name=sc.nextLine();
			int weight,height;
			System.out.println("바뀐 몸무게를 입력해주세요");
			weight=sc.nextInt();
			System.out.println("바뀐 키를 입력해주세요");
			height=sc.nextInt();
			map.put(name, new Bmi(weight,height,name));
		}
		public static void delete() {
			Scanner sc=new Scanner(System.in);
			System.out.println("삭제하실 회원명을 입력해주세요");
			String name=sc.next();
			if(map.containsKey(name)) {
				map.remove(name);
				System.out.println("삭제됐습니다");
			}else {
				System.out.println("해당하는 이름이 없습니다");
			}
		}
		public static void print() {
			System.out.println("회원목록");
			Set<String> set=map.keySet();
			for(String set2:set ) {
				String name=map.get(set2).name;
				String sex=map.get(set2).sex;
				int weight=map.get(set2).weight;
				int height=map.get(set2).height;
				String status=map.get(set2).status;
				double bmi=map.get(set2).bmi;
				
				System.out.println("이름"+name+"bmi지수:"+bmi+"성별"+sex+"몸무게"+weight+"키"+height+"상태"+status);
			}
		}

}
