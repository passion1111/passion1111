package quiz2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//�񸸵� ���� ���α׷� �ۼ��ϱ� -collection,file io �̿��ϱ�
// �߰� ���� ��� ���� ó���Ұ�
// ������ Ű�� �Է¹޾Ƽ� BMI����ϱ�
//BMI = ������ / ( (Ű / 100.0) * (Ű / 100.0) )  ;
// �� : (����cm-100) X 0.9
// �� : (����cm-100) X 0.85
//����>
//18.5�̸� ü�ߺ���
//18.5~22.89 ����
//23.0~24.9 ��ü��
//
public class Bmi {
	static HashMap<String, Bmi> map=new HashMap<String, Bmi>();
	int height;
	int weight;
	double bmi;
	String sex;
	String name;
	String status;
	
	Bmi(){		
	}
	Bmi(int height,int weight,String name){
		Scanner sc=new Scanner(System.in);
		this.weight=weight;
		this.height=height;
		this.name=name;
		System.out.println("������ �Է��ϼ���(ex.��/��");
		
		System.out.println("���ڸ�1,���ڸ�2");
		int num=sc.nextInt();
		if(num==1) {
			this.bmi=(weight/((height/100.0)*(height/100.0)))*0.9;//�Ǵ� �޼ҵ� calcmale ȣ��
			this.sex="����";
			
		}else if(num==2) {
			this.bmi=(weight/((height/100.0)*(height/100.0)))*0.85;;
			this.sex="����";
		}
		
		if(bmi<18.5) {
			status="ü�ߺ���";
		}else if(18.5<=bmi&&bmi<=22.9) {
			status="����";
		}else if(23.0<=bmi&&bmi<=24.9) {
			status="��ü��";
		}else if(bmi>=25) {
			status="��";
		}
		else status="?!";
		
	}
	
	public static void Bmiadd() {
		Scanner sc=new Scanner(System.in);
		System.out.println("�̸��� �Է����ּ���:");
		String name=sc.next();
		System.out.println("�����Ը� �Է����ּ���");
		int weight=sc.nextInt();
		System.out.println("Ű�� �Է����ּ���");
		int height=sc.nextInt();
		map.put(name, new Bmi(height,weight,name));
	}
	 	public static  double Bmiclacmale(int height,int weight) {
	 		double bmi;
	 		bmi=(weight/((height/100.0)*(height/100.0)))*0.9;
	 		return bmi;
	 	}
	 	public static double Bmiclacfemale(int height,int weight) {
	 		double bmi;
	 		bmi=(weight/((height/100.0)*(height/100.0)))*0.85;
	 		return bmi;
	 	}
	 	
		public static void modify(){
			Scanner sc=new Scanner(System.in);
			System.out.println("�����Ͻ� �̸��� �Է����ּ���");
			String name=sc.nextLine();
			int weight,height;
			System.out.println("�ٲ� �����Ը� �Է����ּ���");
			weight=sc.nextInt();
			System.out.println("�ٲ� Ű�� �Է����ּ���");
			height=sc.nextInt();
			map.put(name, new Bmi(weight,height,name));
		}
		public static void delete() {
			Scanner sc=new Scanner(System.in);
			System.out.println("�����Ͻ� ȸ������ �Է����ּ���");
			String name=sc.next();
			if(map.containsKey(name)) {
				map.remove(name);
				System.out.println("�����ƽ��ϴ�");
			}else {
				System.out.println("�ش��ϴ� �̸��� �����ϴ�");
			}
		}
		public static void print() {
			System.out.println("ȸ�����");
			Set<String> set=map.keySet();
			for(String set2:set ) {
				String name=map.get(set2).name;
				String sex=map.get(set2).sex;
				int weight=map.get(set2).weight;
				int height=map.get(set2).height;
				String status=map.get(set2).status;
				double bmi=map.get(set2).bmi;
				
				System.out.println("�̸�"+name+"bmi����:"+bmi+"����"+sex+"������"+weight+"Ű"+height+"����"+status);
			}
		}

}
