package day03.operator;

public class Ex01_operator_example_teacher {
	public static void main(String[] args) {
//		      1.변수선언
		int pay=567890;
		int man,chun,back,sip;//몫 저장 변수
		int m_na,ch_na,b_na; //나머지 저장변수
//		      2.메세지 출력 및 입력받기
//		 	  3.처리(계산)
		man=pay/10000;
		m_na=pay%10000;
		chun=m_na/1000;
		ch_na=m_na%1000;
		back=ch_na/100;
		b_na=ch_na%100;
		sip=b_na/10;
		
		System.out.println("만원:"+man+""
				             + "장\n천원:"+chun+
				                 "장\n백원:"+back+
				                "개\n십원:"+sip+"개");
		
		System.out.println("====================");
		
		System.out.println("만원:"+pay/10000+""
	             + "장\n천원:"+(pay%10000)/1000+
	                 "장\n백원:"+((pay%10000)%1000/100)+
	                "개\n십원:"+(((pay%10000)%1000%100)/10)+"개");
//		      4.결과출력(화면
		
		
	}

}
