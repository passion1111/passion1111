package ex03.di;


public class MainEntry {
	public static void main(String[] args) {
		
		NewRecordImpl record = new NewRecordImpl();
		NewRecordViewImpl view = new NewRecordViewImpl();
		
		//조립
		view.setRecord(record);
		view.input();
		view.print();
	}
}
