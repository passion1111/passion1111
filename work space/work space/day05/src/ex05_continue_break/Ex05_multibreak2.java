package ex05_continue_break;
//break,continue22

//�ĺ���:{      }
//	�ĺ���:{   } �ĺ��ڴ� ��������� ��Ģ�� �Ȱ���.
public class Ex05_multibreak2 {
		public static void main(String[] args) {
			boolean flag=true;
			
			
			first:{
					second: {
						third:{
							int k=100;
							System.out.println("Before the break;");
							if(flag)  break first;//break����� ���������� ���ϴ� �ĺ��ڱ��� �����ָ� �ش��ϴ�
//															������ ��������.
							System.out.println("This won't execute ");
		}//third
			System.out.println("ȭ����");
		}//se
		System.out.println("This is after second block");
		}//fir
			System.out.println("������");

			
			
			
}
}

