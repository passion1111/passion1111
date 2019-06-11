package ex02_interface_quiz;

public interface Trans {
	String start="의 출발 소리입니다";
	String stop="의 멈추는 소리입니다";
	
	public  void show(String name);
	public void start(String name);
	public void stop(String name);

	
}
