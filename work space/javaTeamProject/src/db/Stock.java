package db;

public class Stock {
	private int coca; //코카콜라
	private int sprite;//스프라이트
	private int fanta;//환타
	private int orange;//오렌지주스
	private int pocari;//포카리
	private int coffee;//커피
	private int vita;//비타500
	private int milkis;//밀키스
	
	public Stock (){}

	public int getCoca() {
		return coca;
	}

	public void setCoca(int coca) {
		this.coca = coca;
	}

	public int getSprite() {
		return sprite;
	}

	public void setSprite(int sprite) {
		this.sprite = sprite;
	}

	public int getFanta() {
		return fanta;
	}

	public void setFanta(int fanta) {
		this.fanta = fanta;
	}

	public int getOrange() {
		return orange;
	}

	public void setOrange(int orange) {
		this.orange = orange;
	}

	public int getPocari() {
		return pocari;
	}

	public void setPocari(int pocari) {
		this.pocari = pocari;
	}

	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public int getVita() {
		return vita;
	}

	public void setVita(int vita) {
		this.vita = vita;
	}

	public int getMilkis() {
		return milkis;
	}

	public void setMilkis(int milkis) {
		this.milkis = milkis;
	}

	@Override
	public String toString() {
		return "재고현황 [coca=" + coca + "개, sprite=" + sprite + "개, fanta=" + fanta + "개, orange=" + orange + ", pocari="
				+ pocari + "개, coffee=" + coffee + "개, vita=" + vita + "개, milkis=" + milkis + "]";
	}
	
	
	
	
	
}


