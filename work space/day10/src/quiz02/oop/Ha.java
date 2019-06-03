package quiz02.oop;
import java.util.Scanner;


class Han{
	int han;
	String han2;

	public int getHan() {
		
		return han;
	}

	public void setHan(int han) {

		   
		 if(han>=90) han2="A";
		 else if((han>=80)&&(han<89)) han2="B";
		 else if((han>=70)&&(this.han<79)) han2="C";
		 else if((han>=60)&&(han<69)) han2="D";	
		 else if((60>han)) han2="F";	
		this.han2 = han2;
		this.han = han;
		  
	}
	
	
	public void han_score() {
		System.out.println("국어 점수는"+han);
	}
	
	public String getHan2() {
		return han2;
	}


	

	public void han_grade() {
		System.out.println("국어 학점은: "+han2);
	}
	
}

class Eng{
	int eng;
	String eng2;

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		if(eng>=90) eng2="A";
		 else if((eng>=80)&&(eng<89)) eng2="B";
		 else if((eng>=70)&&(this.eng<79)) eng2="C";
		 else if((eng>=60)&&(eng<69)) eng2="D";	
		 else if((60>eng)) eng2="F";	
		this.eng2 = eng2;
		this.eng = eng;
	}
	
	
	public void eng_score() {
		System.out.println("영어 점수는"+eng);
	}
	
	public String getEng2() {
		return eng2;
	}

	

	public void eng_grade() {
		System.out.println("영어 학점은: "+eng2);
	}
	

}
class Com{
	int com;
	String com2;

	public int getcom() {
		return com;
	}

	public void setCom(int com) {
		if(com>=90) com2="A";
		 else if((com>=80)&&(com<89)) com2="B";
		 else if((com>=70)&&(this.com<79)) com2="C";
		 else if((com>=60)&&(com<69)) com2="D";	
		 else if((60>com)) com2="F";	
		this.com2 = com2;
		this.com = com;
	}
	
	
	public void com_score() {
		System.out.println("컴퓨터점수는"+com);
	}
	
	public String getCom2() {
		return com2;
	}

	

	public void com_grade() {
		System.out.println("컴퓨터 학점은: "+com2);
	}
	

}
class Avg{
	
	double avg;
	
	
	
	public void avgOutput(int han,int com,int eng) {
		 this.avg=(han+com+eng)/3.;
		 
		System.out.printf("세과목 평균은 %.2f \n",avg);
	}
}
class Total{
	
	public int totalset(int han,int com,int eng) {
		return total;
		
	}
	
	int total;
	public void totalOutput(int han,int com,int eng) {
		this.total=han+com+eng;
		System.out.println("총점은 : "+total);
	}
	
	
}
class Name{
	
	String name;
	public void setName(String name) {
		
		this.name=name;
		
	}
	public String getName() {
		return name;
		
	}
	public void Nameoutput() {
		System.out.println("이름 :"+name);
	}
}
//
//	public void totalOutput2() {
//		avgOutput();
//		totalOutput();
//		han_score();
//		han_grade();
//		eng_score();
//		eng_grade();
//		com_score();
//		com_grade();
//		
	
	




//class name{
//	
//}


public class Ha {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Han h=new Han();
		Com c=new Com();
		Eng e=new Eng();
		Total t=new Total();
		Avg avg=new Avg();
		Name name=new Name();
		
		System.out.println("이름 입력하세요");
		
		name.setName(sc.nextLine());
		System.out.println("국어점수 입력하세여.");
		h.setHan(sc.nextInt());
		System.out.println("컴퓨터 입력하세요");
		c.setCom(sc.nextInt());
		System.out.println("영어 입력하세요.");
		e.setEng(sc.nextInt());
		
		name.Nameoutput();
		t.totalOutput(h.getHan(),c.getcom(),e.getEng());
		avg.avgOutput(h.getHan(),c.getcom(),e.getEng());
		h.han_grade();
		e.eng_grade();
		c.com_grade();
		
//		t.setCom(t.getcom());
//정리 필요 	
		
		
		
	}

}




