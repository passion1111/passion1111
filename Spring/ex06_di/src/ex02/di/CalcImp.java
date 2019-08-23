package ex02.di;

public class CalcImp implements Calc {

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

}
