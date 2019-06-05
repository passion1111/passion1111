package quiz2;

public abstract class Trans {
	//강사님은 start,stop 문자열 변수를 하나 만들어서 설정해뒀음.
	String name;
	public abstract void start(String name);
	public abstract void stop(String name);
	public abstract void show(String name2);

}
