package foreach;
//foreach,Ȯ��for��= for(�ڷ��� ������:�迭�� �Ǵ� �÷��Ǹ�){ �ݺ����๮ }
// ex)for(int e:arr) 
public class Foreach {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7};
		
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + " "); //��������
			if( i == 3 ) break;
		}
		System.out.println("\n==============");
		
		for(int e:a) { //�߰��� ��������� ,������ ��������
			System.out.println(e);
		}
		for(int i=0; i < a.length; i++) {
			System.out.print(a[i] + " ");
	}
		System.out.println("\n�������� ���");
		for(int i= a.length-1 ; i >= 0 ; i--) {
			System.out.print(a[i] + " ");
		}

		
		
}
}
