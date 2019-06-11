package quiz;

import java.util.ArrayList;
import java.util.Scanner;
// 국영수를 배열로받으면 리턴값으로 받아야하니 입력하기 편하도록 입력은 일반으로
//추가는 어레이 리스트로 먼저 만들고 난후에 2차 어레이리스트로 지우기 편하게만들기.
class Student2{
	int kor;
	int eng;
	int com;
	int total;
	double avg;
	char grade;
	String name;
	Scanner sc=new Scanner(System.in);
	public Student2(){
	System.out.println("이름을 입력하세요");name=sc.nextLine();
	System.out.println("국어 점수를 입력하세요"); kor=sc.nextInt();
	System.out.println("영어 점수를 입력하세요"); eng=sc.nextInt();
	System.out.println("전산 점수를 입력하세요"); com=sc.nextInt();
	avg=total/3.;
	switch((int)avg/10) {
	case 10: case 9: grade='a'; break;
	case 8: grade='b'; break;
	case 7: grade='c'; break;
	case 6: grade='d'; break;
	default: grade='f';
	}
	
	
}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getCom() {
		return com;
	}
	public void setCom(int com) {
		this.com = com;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [kor=" + kor + ", eng=" + eng + ", com=" + com + ", total=" + total + ", avg=" + avg
				+ ", grade=" + grade + ", name=" + name ;
	}
}



public class quiz3 {
	public static void main(String[] args) {
		ArrayList<Student2> arrlist=new ArrayList<Student2>();
		
		int num = 0;
		int i=0;
		Scanner sc=new Scanner(System.in);
		
		arrlist.add(new Student2());
		arrlist.add(new Student2());
		arrlist.get(0).getKor();
		arrlist.remove(0);
		System.out.println(arrlist.get(0));
//		arrlist.add(new Student());
		
		
		
//		while(true) {
//			System.out.println("1.추가 2.삭제,3.수정,4.종료");
//			num=sc.nextInt();
//			
//			
//			if(num==1) {
//				arrlist.add(new Student2());//더하는 메소드.			
//}
//			else if(num==2) {//삭제 메소드
//				if(!itr.hasNext()) {
//					System.out.println("삭제할 회원이 없습니다");
//					continue;
//				}
//				
//				
//				
//				for (int j = 0; j < arrlist.size(); j++) {
//					System.out.println((i+1)+"번쨰"+arrlist.get(i));
//				}
//				System.out.println("삭제하고싶은 숫자"); i=sc.nextInt();
//				arrlist.get(0).getName().equals("ggg");
//				arrlist.remove(i-1);
//			}
//			else if(num==3) {//수정 메소드
//				for (int j = 0; j < arrlist.size(); j++) {
//					System.out.println((j+1)+"번쨰"+arrlist.get(j));
//				}
//				System.out.println("수정하고싶은 번호"); 
//				i=sc.nextInt();
//				arrlist.set(i-1, new Student2());
//			}
//			else if(num==4) System.exit(0);
//			
//			else if(num==5) {System.out.println("회원 목록");
//				for (int j = 0; j < arrlist.size(); j++) {
//					System.out.println(arrlist.get(j));
//				}
//			
//		}
//		
//	
//		
////		arrlist.remove(num);        삭제 메소드
////		arrlist.set(index, element) //이름 받아서 고치기위한 메소드
////		조회하는 메소드.
////		
//	}
//}
//}
}
}