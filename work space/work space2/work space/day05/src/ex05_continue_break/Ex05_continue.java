package ex05_continue_break;

import java.util.Scanner;

public class Ex05_continue {
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char ch=' ';
		String str=null;
		int count=0;
		System.out.println("�ƹ� ���̳� �Է��ϼ���. '!'�� ������ Ż��");
		//���ٸ� �ޱ⋚���� �� ���ٵ��� ��� ����,esc �ƽ�Ű �ڵ尪 27
		
		while(true){
			str=sc.next();
			//ch= str.charAt(0);
		//	ch=sc.next().charAt(0);  //�̰� ������ break�� �ȵ�. equals�Լ������ʴ��̻�.
			if(ch=='q')break;
			count=str.length();
			
			
    }
		System.out.println("�Է� ���� ���� ������ : "+count );
		
		
	}
}