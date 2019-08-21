package ex05.sports;

public class Soccer implements Player {
	
	@Override
	public boolean info(String name,String sports,String position) {
		System.out.println(name+position+sports +"여기는 축구쪽");
		return false;
		
	}
	
}
