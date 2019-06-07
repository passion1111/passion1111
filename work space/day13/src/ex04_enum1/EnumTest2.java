package ex04_enum1;

enum Operation {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE;

    double calculate(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
            default:
                throw new AssertionError("Unknown operations " + this);
        }
    }

}

public class EnumTest2 {
	 public static void main(String[] args) {

	        double result = Operation.PLUS.calculate(1, 2);
	        System.out.println(result); //3.0
	    }

}
