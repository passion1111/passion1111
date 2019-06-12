package ex04.Abstract;

public class Airplane extends Transport {

	@Override
	public void start(String trpt) {
		start = "이륙 합니다.";

	}

	@Override
	public void stop(String trpt) {
		stop = "인천공항에 착륙합니다.";

	}

	@Override
	public void display(String trpt) {
		System.out.println(trpt + "가 " + start + "\t" + trpt + "가 " + stop);

	}

}
