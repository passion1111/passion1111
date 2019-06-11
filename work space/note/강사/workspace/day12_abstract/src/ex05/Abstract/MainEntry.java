package ex05.Abstract;

import java.util.*;
public class MainEntry {
	public static void main(String[] args){
		
		//
		/*
		Trans[] tr = new Trans[4];
		tr[0] = new Subway();
		tr[1] = new Bus();
		tr[2] = new Bicycle();
		tr[3] = new Airplane();
		*/
		Trans[] tr = { new Subway(), new Bus(), new Bicycle(), new Airplane()};
		
		//
		Scanner sc = new Scanner(System.in);
		int inNum = 1;
		
		//
		while(true) {  //무한루프
			System.out.println("*-*-*-*-* 교통수단 *-*-*-*-*");
			System.out.println("1. 지하철\n2. 버스\n3. 자전거\n4. 비행기\n5. 종료");
			System.out.print(">> ");
			inNum = sc.nextInt();
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*");
			
			// 종료 선택
			if(inNum==5){  
				System.out.println("* 종료합니다.");
				break;  //탈출구문
			}// if
			
			// 1~4 메뉴 선택
			System.out.println("* " + tr[inNum-1].name);
			System.out.print("Start : ");
			tr[inNum-1].start();
			System.out.print("Stop  : ");
			tr[inNum-1].stop();
			System.out.println();
			System.out.println();
		}// while
		
	}// main
}// class
