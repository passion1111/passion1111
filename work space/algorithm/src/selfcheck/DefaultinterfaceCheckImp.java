package selfcheck;

public class DefaultinterfaceCheckImp implements DefaultInterfaceCheck{

	public void check() {
		System.out.println("hoho!!");
	}
	public static void main(String[] args) {
		DefaultInterfaceCheck checkinterface=new DefaultinterfaceCheckImp();
		checkinterface.check();
		checkinterface.check2();
	}
}
