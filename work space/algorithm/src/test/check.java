package test;

public class check {

	class c{
		public void aaa() {
			System.out.println("cc");
		}
	}

	public static void main(String[] args) {
		a a=new b();
		System.out.println(a.a());
		check check2=new check();
		check.c c=check2.new c();
		
	}
}




 class a{
	public String a() {
		return "a";
	}
}
 class b extends a{
	public String a() {
		return "b";
	}
}
