	/*static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String name() throws IOException {
		System.out.print("�̸��� �Է��ϼ��� : ");
		String name = br.readLine();
		return name;
	}
	static String weight() throws IOException {
		System.out.print("�����Ը� �Է��ϼ��� : ");
		String wei = br.readLine();
		Integer.parseInt(wei);
		return wei;
	}
	static String height() throws NumberFormatException, IOException {
		System.out.print("Ű�� �Է��ϼ��� : ");
		String hei = br.readLine();
		Integer.parseInt(hei);
		return hei;
	}
	public static void main(String[] args) throws Exception {
		System.out.println("�̸� : " + name() + "\t������ : " + weight() + "\tŰ : " + height());
	}*/
package quiz.one;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BMI {
	protected String name , weight , height;
	static int wei , hei;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static BMI input(BMI bmi) throws IOException {
		System.out.println("�̸��� �Է��ϼ��� : ");
		bmi.name = br.readLine();
		System.out.print("�����Ը� �Է��ϼ��� : ");
		/*String strW = br.readLine();
		wei = Integer.parseInt(strW);*/
		wei = Integer.parseInt( br.readLine());
		//bmi.weight = wei;
		System.out.print("Ű�� �Է��ϼ��� : ");
		hei = Integer.parseInt(br.readLine());   //
		
		//BMI = ������ / ( (Ű / 100.0) * (Ű / 100.0) )  ;
		double sum = wei / ( (hei  / 100.0)  * (hei / 100.0) ) ;
		if(sum < 18.5) System.out.println("ü�ߺ����Դϴ�.");
		else if(sum>=18.5 && sum <=22.9) System.out.println("����ü���Դϴ�.");
		else if(sum>=23.0 && sum <=24.9) System.out.println("��ü���Դϴ�.");
		else System.out.println("���Դϴ�!!! ���̾�Ʈ �ʼ��Դϴ�!!!");
		
		return bmi;
	}
}