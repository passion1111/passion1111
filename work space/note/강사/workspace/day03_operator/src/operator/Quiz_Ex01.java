package operator;

/*
����1] int pay = 567890;

result> ���� : 56��
	 õ�� :  7��
	 ��� :  8��
	 �ʿ� :  9�� 
*/
public class Quiz_Ex01 {
	public static void main(String[] args) {
		//1.���� ����
		int pay = 567890;
		int man, chun, back, sip; //�� ���� ����
		int m_na, ch_na, b_na;  //������ ���庯��
		
		//2.�޼��� ��� �� �Է¹ޱ�
		//3.ó��(���)
		man = pay / 10000; 		m_na = pay % 10000;
		chun = m_na / 1000;		ch_na = m_na % 1000;
		back = ch_na / 100;		b_na = ch_na % 100;
		sip = b_na / 10;
				
		//4.������(ȭ��)
		System.out.println("\n\n���� : " + man 
							+"��\nõ�� : " + chun
							+"��\n��� : " + back
							+"��\n�ʿ� : " + sip + "��");	
		
		System.out.println("============================");
		System.out.println("10000 ��: " + (pay / 10000) 
				+"��\n1000 ��: " + (pay % 10000) /1000
				+"��\n100 ��: " + ((pay % 10000) %1000) / 100
				+"��\n10 �� : " + ((pay % 10000) %1000) % 100 / 10 + "��");	
		
	}
}







