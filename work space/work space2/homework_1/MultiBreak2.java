package ex05_break_continue;

public class MultiBreak2 {
	public static void main(String[] args) {
		
		boolean flag = true;
	
		firust:{
			second : {
		
				third : {
		
					int k = 100;
					System.out.println("Before the break");
					
					if( flag ) break second;  // break �ĺ���;   �ĺ��� ��ġ���� Ż��
					
					System.out.println("This won't execute ");
		
				} // third end
				System.out.println("�츮�� ȱ��!!!");
				
			}// second end
			System.out.println("This is after second block");
			
		} // firust end
		System.out.println("1842384 sdfjksfj");
	}
	
	
//	�ĺ��� : {
//		�ĺ��� : {
	
	
//			 break �ĺ���;
//		}
//	}
}






