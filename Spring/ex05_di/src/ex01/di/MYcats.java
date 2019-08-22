package ex01.di;

public class MYcats {
	Cats cats;
	private String firstCatname;
	private int firstCatAge;
	private String secondCatname;
	private int secondCatAge;

	public void catsNameInfo() {
		cats.catsName(firstCatname, secondCatname);
	}
	public void catAgeInfo() {
		cats.catsAge(firstCatAge, secondCatAge);
	}
	
	
	
	
	
	
	
	
	
	public Cats getCats() {
		return cats;
	}
	public void setCats(Cats cats) {
		this.cats = cats;
	}
	public String getFirstCatname() {
		return firstCatname;
	}
	public void setFirstCatname(String firstCatname) {
		this.firstCatname = firstCatname;
	}
	public int getFirstCatAge() {
		return firstCatAge;
	}
	public void setFirstCatAge(int firstCatAge) {
		this.firstCatAge = firstCatAge;
	}
	public String getSecondCatname() {
		return secondCatname;
	}
	public void setSecondCatname(String secondCatname) {
		this.secondCatname = secondCatname;
	}
	public int getSecondCatAge() {
		return secondCatAge;
	}
	public void setSecondCatAge(int secondCatAge) {
		this.secondCatAge = secondCatAge;
	}

}
