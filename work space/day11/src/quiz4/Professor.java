package quiz4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Professor extends Person {
	private int jicsu;
	private String bun,ha,jic;
	private String[] jic2={"전임교수","조교수","외래교수"};
	
	public Professor() {
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("교수번호를 입력하세요");
		bun=sc.nextLine();
		
		System.out.println("학과를 입력하세요");
		ha=sc.nextLine();
		
		
		try {
		do {
			System.out.println("직급에 맞는 번호를 입력하세요");
			System.out.println("1.전임교수,2.조교수,3.외래교수");	
		jicsu=sc.nextInt();
		if(jicsu==1) jic=jic2[0];
		else if(jicsu==2)jic=jic2[1];
		else if(jicsu==3)jic=jic2[2];
		else System.out.println();
		}while(jicsu>3||jicsu<=0);
		}catch(InputMismatchException e)
		{
			System.out.println("직급에 맞는 번호로 입력하세요.");
			
			System.exit(0);
		}
		
		
	}
	

	@Override
	public String toString() {
		
		return "Professor [교수번호=" + bun + ", 직급=" + jic + ", 학과=" + ha + ", 이름=" + name + ", 키=" + height
				+ ", 몸무게=" + weight + "]";
	}


	public String getBun() {		return bun;	}
	public void setBun(String bun) {		this.bun = bun;	}
	public String getJic() {		return jic;	}
	public void setJic(String jic) {		this.jic = jic;	}
	public String getHa() {		return ha;	}
	public void setHa(String ha) {		this.ha = ha;	}
	
	
	
	
}
