package ex01.di;

public class NewRecordView {
	
	    //point NewRecordView : record 관계 
		//UML 로 > 집합관계(마름모)
	
		private NewRecord record;
		
		public NewRecordView(int kor, int math, int eng){
			record = new NewRecord(kor, eng, math);
		}
		public void print(){
			System.out.println(record.total() + " / " + record.avg());
		}

}
