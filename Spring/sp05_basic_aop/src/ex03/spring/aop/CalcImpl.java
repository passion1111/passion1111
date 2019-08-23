package ex03.spring.aop;

public class CalcImpl implements ICalc {

	@Override
	public int ADD(int x, int y) {
		//보조관심(cross-cutting-concern)
		int sum = x + y;
		//보조관심(cross-cutting-concern)
		return sum;
	}

	@Override
	public int MUL(int x, int y) {
		//보조관심
		int mul = x * y;
		//보조관심
		return mul;
	}

	@Override
	public int SUB(int x, int y) {
		//보조관심
		int sub = x - y;
		//보조관심
		return sub;
	}

}
