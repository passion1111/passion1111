

package ex01_Switch;
//����5
//  �⵵/�� �Է¹�����  ���ϱ��� �ִ��� ����ϴ� ���α׷� ¥��.
//   2���� ������ �ֱ⋚���� 2�������� �������ִ��� ������� �����̸� 29�ϱ��� ����̸� 28�ϱ����ִٰ� ����ϱ�.
import java.util.Scanner;

public class Controller_Switch_quiz2 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("���ϴ� ���� �Է����ּ���: ");
		int moon=sc.nextInt();
	    String day=null;
	
		
		switch (moon) {
		
		case 1:  case 3:  case 5: case 7: case 8: case 10: 		case 12:
			day="31";
			break;
		case 2: {
			System.out.println("�⵵�� �Է����ּ���");
			  int year=sc.nextInt();
			if(year%4==0&&(year%100!=0)|| (year%400==0)) {
			day="28";
			}
			day="29";
			break;
			
			
		
		}
		case 4:  case 6: case 9:  case 11: day="30"; break;
		
		
	
		
		default :day="�ٽ��Է����ּ���"; break;
		
		}
		
	
		
		System.out.println(moon+"������"+day+"���� �ֽ��ϴ�.");

		}// switch end
	

	}

/*    �ٸ� ���� �����غ��� 
 *    ��ǲ �� �ް�
 *     if(((input%2&&input!=8)==0)){
 *       if(input==2){
 *       	�Է¹ް�
 *           %4==0&& %400 ||�Ǵ� %100!=0�̸�
 *            29��}
 *            else 28��
 *           }
 *           else  30��
 *     day=30�ϱ����Դϴ�.
 *     else if(input%2
 */
 
