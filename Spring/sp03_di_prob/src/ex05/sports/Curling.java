package ex05.sports;

public class Curling implements Player {

	
	
	@Override
	public boolean info(String name,String sports,String position) {
 System.out.println(name+position+sports  +"여기는 컬링쪽");
 return false;
	}

}
