package ex07_stringbuffer;

public class StringBuffer2 {
	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer("this");
		System.out.println(sb);
		
		sb.append(" is pecil");//append ���ڿ��߰��Լ� �ڿ������� ä����. incert�� �տ��� �߰�
		System.out.println(sb);
		
		sb.insert(7, " my");//���ڿ�����.
		System.out.println(sb);
		
		sb.replace(8, 10, "your");//���ڿ� ���� ��ü
		System.out.println(sb);
		
		sb.setLength(5);//ũ�⸸ ©�������� �����δ� �޸��Ҵ����
		System.out.println(sb);
		System.out.println(sb.capacity());//���� 20��ŭ�ִ°ɷ� Ȯ���Ҽ����־.
	}

}
