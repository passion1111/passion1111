package quiz2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import quiz.video.one.Video;

public class Emp {
	
	
	static HashMap<String, Emp> map = new HashMap<String, Emp>();
	
		protected  String name; //
		protected String department;
		protected int sales;
		protected String jobgrade;
		protected int tel;
		
		Emp(){			};
		Emp(String name){//��ü �Է�
			Scanner sc=new Scanner(System.in);
			
			this.name = name;
			System.out.print("�μ��� �Է��ϼ��� : ");
			department = sc.next();
			System.out.println("�޿��� �Է����ּ���");
			sales=sc.nextInt();
			System.out.println("������ �Է����ּ���");
			jobgrade=sc.next();
			System.out.println("��ȭ��ȣ�� �Է����ּ���");
			tel=sc.nextInt();
		}
		
		public static void insert(String name) {
			Scanner sc=new Scanner(System.in);
			
			map.put(name,new Emp(name));
			
		}
		public static void delete(String name) {
			Scanner sc=new Scanner(System.in);
			System.out.print("�̸��� �Է����ּ���: ");
				name = sc.next();
			if(map.containsKey(name)){
				map.remove(name);
				System.out.println("�����Ǿ����ϴ�.");
			}else{
				System.out.println("�̸��� �߸��Է��ϼ̽��ϴ�.");
			}
//		}
			
		}
		public static void modify() {
			Scanner sc=new Scanner(System.in);
			
			System.out.print("�����Ͻ� ��� �̸��� �Է����ּ��� : ");
			String name = sc.next();
			
			
			if(map.containsKey(name)){
				map.put(name, new Emp(name));
				System.out.println("����Ǿ����ϴ�.");
			}else{
				System.out.println("���� ������ �߸��Է��ϼ̽��ϴ�. �ش� ������ �����ϴ�.");
			}
		}
		public static void display() {
//			protected  String name; //
//			protected String department;
//			protected int sales;
//			protected String jobgrade;
//			protected int tel;
				System.out.println("��ü ȸ���� : " + map.size());
				System.out.println("�̸�---����---�μ�---����---��ȭ��ȣ");
				Set<String> set = map.keySet();
				for(String name : set){
					String name1 = map.get(name).name;
					String department = map.get(name).department;
					String jobgrade=map.get(name).jobgrade;
					int sales = map.get(name).sales;
					int tel=map.get(name).tel;
				
//					String lendName = map.get(video).lendName;
					if(name==null){
						name = "���� ����";
					}
					
					System.out.println(name1 + "\t" + jobgrade + "\t"+department+"\t"+sales+"\t"+tel);
				}
			}
			
		}
		

		
		
