package ex05.sports;

public class middle {
 public Player player;
 	middle(){}
 
 	middle(Player player){
	 this.player=player;
	 
 }



	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public boolean porcess(String name,String sports,String position ) {
	return this.player.info(name,sports,position);	
	}
	 
}
