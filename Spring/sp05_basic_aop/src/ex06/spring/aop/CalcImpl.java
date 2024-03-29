package ex06.spring.aop;

public class CalcImpl implements ICalc {

	@Override
	public int ADD(int x, int y) {
		//보조관심(cross-cutting-concern)
		int sum = x + y;
		//보조관심(cross-cutting-concern)
		System.out.println("ADD 주관심사");
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
		if(y > x){
			throw new IllegalArgumentException("y값이 x보다 큽니다");
		}
		int sub = x - y;
		//보조관심
		return sub;
	}

}
