package method;


	//�ν�ź�� �޼ҵ�:��ü �����ϰ� ����ؾ���
//�޸𸮿� �Ҵ��� �Ǿ��
class B{
	int x,y;
//�ν��Ͻ� �޼ҵ�
public void setData(int xx,int yy) {
	System.out.println(xx+","+yy);
}
}//b class end

public class instancemethod1{
	public static void main(String[] args) {
		
	 B b =new B(); //��ü����,�޸𸮿� �Ҵ�,�������Լ� ȣ��
	 b.x=9;
	 b.setData(10,20);  //��ü �����ؼ� �ҷ����Ѵ�. Ŭ�����̸����� ���θ�.
	}						//B��� �̸����� �θ��� ���Ѵ�.
}
//��κ� �ν��Ͻ� �޼ҵ带 ��.