package ex04_multiimplements;
//�ٸ���Ű���������� ����Ʈ�ؾ���.
public class MainEntry {
	public static void main(String[] args) {
		Shape s=new Multiclass();
		s.show("����");
		s.shview();//Shape�� �θ𿡰Ը� �ҷ��� �Ἥ �޼ҵ����� ����
		            
		
		
		System.out.println("==========");
		Multiclass mc=new Multiclass();
		mc.draw();
		System.out.println(mc.num);
		System.out.println(mc.su);
		System.out.println("===============");
		TEst t=new Multiclass();
		t.view();
		System.out.println(t.str);
		
	}
}
