package quiz4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Professor extends Person {
	private int jicsu;
	private String bun,ha,jic;
	private String[] jic2={"���ӱ���","������","�ܷ�����"};
	
	public Professor() {
		Scanner sc=new Scanner(System.in);
		
		
		System.out.println("������ȣ�� �Է��ϼ���");
		bun=sc.nextLine();
		
		System.out.println("�а��� �Է��ϼ���");
		ha=sc.nextLine();
		
		
		try {
		do {
			System.out.println("���޿� �´� ��ȣ�� �Է��ϼ���");
			System.out.println("1.���ӱ���,2.������,3.�ܷ�����");	
		jicsu=sc.nextInt();
		if(jicsu==1) jic=jic2[0];
		else if(jicsu==2)jic=jic2[1];
		else if(jicsu==3)jic=jic2[2];
		else System.out.println();
		}while(jicsu>3||jicsu<=0);
		}catch(InputMismatchException e)
		{
			System.out.println("���޿� �´� ��ȣ�� �Է��ϼ���.");
			
			System.exit(0);
		}
		
		
	}
	

	@Override
	public String toString() {
		
		return "Professor [������ȣ=" + bun + ", ����=" + jic + ", �а�=" + ha + ", �̸�=" + name + ", Ű=" + height
				+ ", ������=" + weight + "]";
	}


	public String getBun() {		return bun;	}
	public void setBun(String bun) {		this.bun = bun;	}
	public String getJic() {		return jic;	}
	public void setJic(String jic) {		this.jic = jic;	}
	public String getHa() {		return ha;	}
	public void setHa(String ha) {		this.ha = ha;	}
	
	
	
	
}
