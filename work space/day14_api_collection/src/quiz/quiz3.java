package quiz;

import java.util.ArrayList;
import java.util.Scanner;
// �������� �迭�ι����� ���ϰ����� �޾ƾ��ϴ� �Է��ϱ� ���ϵ��� �Է��� �Ϲ�����
//�߰��� ��� ����Ʈ�� ���� ����� ���Ŀ� 2�� ��̸���Ʈ�� ����� ���ϰԸ����.
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
	System.out.println("�̸��� �Է��ϼ���");name=sc.nextLine();
	System.out.println("���� ������ �Է��ϼ���"); kor=sc.nextInt();
	System.out.println("���� ������ �Է��ϼ���"); eng=sc.nextInt();
	System.out.println("���� ������ �Է��ϼ���"); com=sc.nextInt();
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
//			System.out.println("1.�߰� 2.����,3.����,4.����");
//			num=sc.nextInt();
//			
//			
//			if(num==1) {
//				arrlist.add(new Student2());//���ϴ� �޼ҵ�.			
//}
//			else if(num==2) {//���� �޼ҵ�
//				if(!itr.hasNext()) {
//					System.out.println("������ ȸ���� �����ϴ�");
//					continue;
//				}
//				
//				
//				
//				for (int j = 0; j < arrlist.size(); j++) {
//					System.out.println((i+1)+"����"+arrlist.get(i));
//				}
//				System.out.println("�����ϰ���� ����"); i=sc.nextInt();
//				arrlist.get(0).getName().equals("ggg");
//				arrlist.remove(i-1);
//			}
//			else if(num==3) {//���� �޼ҵ�
//				for (int j = 0; j < arrlist.size(); j++) {
//					System.out.println((j+1)+"����"+arrlist.get(j));
//				}
//				System.out.println("�����ϰ���� ��ȣ"); 
//				i=sc.nextInt();
//				arrlist.set(i-1, new Student2());
//			}
//			else if(num==4) System.exit(0);
//			
//			else if(num==5) {System.out.println("ȸ�� ���");
//				for (int j = 0; j < arrlist.size(); j++) {
//					System.out.println(arrlist.get(j));
//				}
//			
//		}
//		
//	
//		
////		arrlist.remove(num);        ���� �޼ҵ�
////		arrlist.set(index, element) //�̸� �޾Ƽ� ��ġ������ �޼ҵ�
////		��ȸ�ϴ� �޼ҵ�.
////		
//	}
//}
//}
}
}