package ex03.di;

import java.util.Scanner;

public class ScoreShowImp implements ScoreShow {
	private ScoreImp record;
	

	public void setRecord(ScoreImp record) { //DI
		this.record = record;
	}

//	public ScoreShowImp(ScoreImp record) { //DI
//		super();
//		this.record = record;
//	}

	@Override
	public void print() {
		System.out.printf("\n\nKor :%d\n",record.getKor());
		System.out.printf("\n\nEng :%d\n",record.getEng());
		System.out.printf("\n\nCOM :%d\n",record.getCom());
		System.out.printf("\n\nTotal :%d\n",record.total());
		System.out.printf("\n\nTotal :%f\n",record.avg());
	}

	@Override
	public void input() {
	Scanner sc=new Scanner(System.in);
	System.out.println("국어점수 입력하세여");
	record.setKor(sc.nextInt());
	System.out.println("영어점수 입력하세여");
	record.setEng(sc.nextInt());
	System.out.println("컴퓨터점수 입력하세여");
	record.setCom(sc.nextInt());
	}

}
