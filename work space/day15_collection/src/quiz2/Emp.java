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
		Emp(String name){//전체 입력
			Scanner sc=new Scanner(System.in);
			
			this.name = name;
			System.out.print("부서를 입력하세요 : ");
			department = sc.next();
			System.out.println("급여를 입력해주세요");
			sales=sc.nextInt();
			System.out.println("직급을 입력해주세요");
			jobgrade=sc.next();
			System.out.println("전화번호를 입력해주세요");
			tel=sc.nextInt();
		}
		
		public static void insert(String name) {
			Scanner sc=new Scanner(System.in);
			
			map.put(name,new Emp(name));
			
		}
		public static void delete(String name) {
			Scanner sc=new Scanner(System.in);
			System.out.print("이름을 입력해주세요: ");
				name = sc.next();
			if(map.containsKey(name)){
				map.remove(name);
				System.out.println("삭제되었습니다.");
			}else{
				System.out.println("이름을 잘못입력하셨습니다.");
			}
//		}
			
		}
		public static void modify() {
			Scanner sc=new Scanner(System.in);
			
			System.out.print("변경하실 사원 이름을 입력해주세요 : ");
			String name = sc.next();
			
			
			if(map.containsKey(name)){
				map.put(name, new Emp(name));
				System.out.println("변경되었습니다.");
			}else{
				System.out.println("비디오 제목을 잘못입력하셨습니다. 해당 정보가 없습니다.");
			}
		}
		public static void display() {
//			protected  String name; //
//			protected String department;
//			protected int sales;
//			protected String jobgrade;
//			protected int tel;
				System.out.println("전체 회원수 : " + map.size());
				System.out.println("이름---직급---부서---월급---전화번호");
				Set<String> set = map.keySet();
				for(String name : set){
					String name1 = map.get(name).name;
					String department = map.get(name).department;
					String jobgrade=map.get(name).jobgrade;
					int sales = map.get(name).sales;
					int tel=map.get(name).tel;
				
//					String lendName = map.get(video).lendName;
					if(name==null){
						name = "정보 없음";
					}
					
					System.out.println(name1 + "\t" + jobgrade + "\t"+department+"\t"+sales+"\t"+tel);
				}
			}
			
		}
		

		
		
