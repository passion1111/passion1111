package a;

public class da02_re {
static int[]a;	
static int i;
public static  int[]arr(){
	int a=new int[2];
	for(i=0;i<2;i++) {
		a[i]=i;
		System.out.println(a[i]);
	}
	return a;
}

	public static void main(String[] args) {
		
		arr();
		
	}

}
