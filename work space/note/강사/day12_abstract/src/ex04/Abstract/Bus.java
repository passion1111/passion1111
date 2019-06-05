package ex04.Abstract;

public class Bus extends Transport {

	@Override
	public void start(String trpt) {
		start = "정류장을 출발합니다.";

	}

	@Override
	public void stop(String trpt) {
		stop = "정류장에 들어옵니다";

	}

	@Override
	public void display(String trpt) {
		System.out.println(trpt + "가 " + start + "\t" + trpt + "가 " + stop);

	}


}
