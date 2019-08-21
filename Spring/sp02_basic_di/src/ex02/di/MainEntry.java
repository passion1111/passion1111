package ex02.di;

public class MainEntry {
	public static void main(String[] args) {
			   //is-a   , has-a
				//상속        포함관계
				//has-a 관계를 통해서 객체를 다루기
				
				//객체의 생성이 서로 독립적
				//필요시 객체의 주소만 주입
				NewRecordView view = new NewRecordView();
				NewRecord record = new NewRecord(50,90,70);
				view.setRecord(record);
				view.print();
	}

}
