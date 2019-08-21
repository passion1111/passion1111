package ex01.di;

public class MainEntry {

		public static void main(String[] args) {
			
			//is-a   , has-a
			//상속        포함관계
			//has-a 관계를 통해서 객체를 다루기
			NewRecordView view = new NewRecordView(100, 90, 80);
			view.print();
		}
}
