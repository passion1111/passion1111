package quiz2;

public class MainEntrty {
	public static void main(String[] args) {
		Trans[] t=new Trans[4];
		t[0]=new Biclycle();
		t[1]=new Train();
		t[2]=new Subway2();
		t[3]=new Bus();
		
		String[] name= {"자전거","기차","지하철","버스"};
		
		for(int i=0;i<t.length;i++) {
			t[i].show(name[i]);
		}
		
		
	}

}
