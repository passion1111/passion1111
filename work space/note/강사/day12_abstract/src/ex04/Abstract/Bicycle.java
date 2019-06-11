package ex04.Abstract;

public class Bicycle extends Transport {

	@Override
	public void start(String trpt) {
		start = "달리기 시작합니다.";

	}

	@Override
	public void stop(String trpt) {
		stop = "끼익 하고 멈춥니다.";

	}

	@Override
	public void display(String trpt) {
		System.out.println(trpt + "가 " + start + "\t" + trpt + "가 " + stop);

	}


}
