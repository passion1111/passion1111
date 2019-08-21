package ex03.di;

import java.util.Scanner;


public class NewRecordViewImpl implements IRecordView {

	private NewRecordImpl record;
	
	//setter 로 주입받기
	public void setRecord(NewRecordImpl record) {
		this.record = record;
	}
	
	@Override
	public void print(){
		System.out.printf("\n\nkor : %d\n",record.getKor());
		System.out.printf("math : %d\n",record.getMath());
		System.out.printf("eng : %d\n",record.getEng());
		System.out.printf("total : %d\n",record.total());
		System.out.printf("avg : %.2f\n",record.avg());
	}
	
	@Override
	public void input() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("kor :  " );
		record.setKor(scan.nextInt());
		
		System.out.print("math :  ");
		record.setMath(scan.nextInt());
		
		System.out.print("eng :  ");
		record.setEng(scan.nextInt());
		
		
	}

}
