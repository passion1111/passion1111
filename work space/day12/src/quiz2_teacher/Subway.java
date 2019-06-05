package quiz2_teacher;

public class Subway extends Transport {  // Sub class

	@Override
	public void start(String trpt) {
		start = "역을 출발합니다.";

	}

	@Override
	public void stop(String trpt) {
		stop = "역에 들어옵니다";

	}

	@Override
	public void display(String trpt) {
		System.out.println(trpt + "이 " + start + "\t" + trpt + "이 " + stop);

	}

}






