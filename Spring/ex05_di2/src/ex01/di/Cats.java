package ex01.di;

public class Cats {
	private Mycats myCats;
	public Cats() {}
	
	//생성자를 통해서 mycats를 인수로 받아와서 mycats를 초기화시킴
	public Cats(Mycats myCats){
		this.myCats=myCats;
	}
	public void setMycats(Mycats myCats) {
		this.myCats = myCats;
	}

	//받아온 mycats값을 세팅해줌
	public void setMyCatsInfo(Mycats myCats) {
		this.myCats=myCats;
	}
	//mycats의 정보값들 출력하기
	public void getMyCatsInfo() {
		System.out.println("==================");
		System.out.println("cats Name : " +myCats.getName());
		System.out.println("cats Age : " +myCats.getAge());
		System.out.println("cats Hobby : " +myCats.getHobbys());
		System.out.println("cats Weight : " +myCats.getWeight());
		System.out.println("cats Color : " +myCats.getColor());
		System.out.println("==================");
		
	}
	
		
	public void catsName(String firstCatname,String secondCatname) {
		System.out.println("캐츠네임");
		System.out.println("첫번쨰 고양이 이름은"+firstCatname);
		System.out.println("두번쨰 고양이 "+secondCatname);
	
	}
	public void catsAge(int firstCatAge,int secondCatAge) {
		
		System.out.println("캐츠네임");
		System.out.println("첫번쨰 고양이 나이는"+firstCatAge);
		System.out.println("두번쨰 고양이 나이  "+secondCatAge);
	
	}
}
