package db;

public class Stock {
	private int coca; //��ī�ݶ�
	private int sprite;//��������Ʈ
	private int fanta;//ȯŸ
	private int orange;//�������ֽ�
	private int pocari;//��ī��
	private int coffee;//Ŀ��
	private int vita;//��Ÿ500
	private int milkis;//��Ű��
	
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
		return "�����Ȳ [coca=" + coca + "��, sprite=" + sprite + "��, fanta=" + fanta + "��, orange=" + orange + ", pocari="
				+ pocari + "��, coffee=" + coffee + "��, vita=" + vita + "��, milkis=" + milkis + "]";
	}
	
	
	
	
	
}


