package ex02_interface_quiz;

public class MainEntry {
		public static void main(String[] args) {
			Trans t=new Airplne();
			t.show("비행기");
			t=new Bus();
			t.show("버스");
			
		}
}
