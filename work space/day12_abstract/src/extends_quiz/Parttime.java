package extends_quiz;

import java.util.Scanner;

public class Parttime extends Emp{
	double don2;
	int time;
	int day;
	public Parttime() {
		Scanner sc=new Scanner(System.in);
		System.out.println("���� �ð��� �Է����ּ���");
		time=sc.nextInt();
		System.out.println("���� �ϼ��� �Է����ּ���");
		day=sc.nextInt();
		don2=time*8350*day;
		this.sabun="T"+super.sabun;
		
	}
	public void display() {
		System.out.println("�ñ�"+8350+"���� �ð�"+time+"�ϼ�"+day+"�޿�"+don2+"���"+sabun);
	}
	
	
	@Override
	public String toString() {
		
		return "Parttime [don2=" + don2 + ", time=" + time + ", day=" + day + "]";
	}



	public double getDon2() {		return don2;	}
	public int getTime() {		return time;	}
	public void setTime(int time) {		this.time = time;	}
	public int getDay() {		return day;	}
	public void setDay(int day) {		this.day = day;	}
	public void setDon2(int don2) {		this.don2 = don2;	}
	

}
