package array2;


// 3�� 4��¥�� 2���� �迭�� �����Ŀ� ���� ������
//      1  2 10 5
//      9  7 3 20
//      0  0 0  0

//    10  9  13 25
public class Mainentry_quiz2 {
	public static void main(String[] args) {
		int[][] arr= {{1,2,10,5},{9,7,3,20},{0,0,0,0}};
		int i=0,sum1,sum2;
		
			for(int  j=0;j<arr[0].length;j++) {
				sum1=(arr[arr.length-3][j]);//1�� ��
				sum2=arr[arr.length-2][j];//2�� ��
			arr[arr.length-1][j]=sum1+sum2; //1��+2�� ��
			}
		
		for(i=0;i<arr.length;i++) {//i=0;i<2;i++
			for(int  j=0;j<arr[0].length;j++) {
				System.out.print("arr["+i+"]["+j+"]="+arr[i][j]+"\t");
				
				
			}
			
			System.out.println("");
		}
	}
	}

