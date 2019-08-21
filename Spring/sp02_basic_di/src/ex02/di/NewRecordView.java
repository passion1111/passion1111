package ex02.di;

public class NewRecordView {
	
	private NewRecord record;
	//setter 로 주입받기
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	public void print(){
		System.out.printf("kor: %d\n",record.getKor());
		System.out.printf("math: %d\n",record.getMath());
		System.out.printf("eng: %d\n",record.getEng());
		System.out.printf("total: %d\n",record.total());
		System.out.printf("avg: %f\n",record.avg());
	}

}
