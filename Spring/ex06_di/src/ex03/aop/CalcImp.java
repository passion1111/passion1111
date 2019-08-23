package ex03.aop;

public class CalcImp implements Calc {

	
	
	
	//주관심사.
	@Override
	public int add(int x, int y) {
		int result=x+y;
		return result;
	}

	@Override
	public int mul(int x, int y) {
		int result=x*y;
		return result;
	}

	@Override
	public int minus(int x, int y) {
		int result=x-y;
		return result;
	}

	@Override
	public int na(int x, int y) {
		int result=x/y;
		return result;
	}

}
