package personal;


public class Personal_practice2 {
			public static void main(String[] args) {

				int[][]arr=new int[6][];
						arr[0]=new int[1];
						arr[1]=new int[2];
						arr[2]=new int[3];
						arr[3]=new int[4];
						arr[4]=new int[1];
						arr[5]=new int[1];
						int value=0;
						for(int i=0; i<arr.length;i++) {
								for(int j=0;j<arr[i].length;j++) {
										arr[i][j]=value;
										value++;
								}
						}
						for(int i=0; i<arr.length;i++) {
							for(int j=0;j<arr[i].length;j++) {
								System.out.println(arr[i][j]);
							}
							System.out.println("---------");
						}
			}
}			

//자바 배열에 대한 개념 2차원배열에 값을 저장하고 묶음마다 보는방식
//이해도가 낮은거같으니 더욱 집중해서 봐야겠다.
