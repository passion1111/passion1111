package ex02_collection_set;
//hashset�� ��� �ʱ�뷮�� 16
//iterator�� ���ؼ� �ϳ��� ���
import java.util.HashSet;
import java.util.Iterator;


//set;�������� �ߺ����x
public class HashSetEx1 {
	public static void main(String[] args) {
	HashSet<String> hs=new HashSet<String>();//�ڿ��ٰ��� <String>�����൵ ��.
	hs.add("ddd");
//	hs.add(1);//������ ����־��⋚���� ������ �߻�.
	hs.add("Ű����");	hs.add("ddd");
	hs.add("��");	hs.add("����");
	
	HashSet<Integer> hs2=new HashSet();//Ÿ�� �Ķ���� ���� �������� ����Ŭ���� Ÿ�Ը� ����. int�Ұ���
	hs2.add(100);
	hs2.add(300);
	hs2.add(1);
	hs2.add(1);
	
	
	System.out.println("��� ����: "+hs.size());//�ߺ��������ʴ°� Ȯ���Ҽ����� 4 ddd�ߺ��ǹǷ�.
	
	Iterator it=hs.iterator();
	while(it.hasNext()) {//������Ұ� �ִٸ�.
		System.out.println(it.next());//��Ҹ� ������. �������� �������� ddd �� ���� Ű����� �������̵�.
	}//while�� ���� for���̿��
	System.out.println("====================");
	for(Object item:hs ) {//for each�̿�
		System.out.println(item);
	}
	
	System.out.println("====================");
//	for(int i=0;i<hs.size();i++) {
		System.out.println(hs);//�迭�ε� ����̵� �������̹迭�̴ϱ�.
//	}
		System.out.println("====================");
		Iterator it2=hs2.iterator();
		while(it2.hasNext()) {//������Ұ� �ִٸ�.
			System.out.println(it2.next());//��Ҹ� ������. �������� �������� ddd �� ���� Ű����� �������̵�.
		}
	
	}
}




/*	Object[] obArr = {"1", new Integer(1), "2","3","3", "4","4","4"};
//Hashset<E> <- <E>�� Ÿ�� param �Ķ���Ͷ�� �θ�. �Է��� ������.
//���� E�����ٸ� ����ҋ� ����ȯ�� �����������.
Set set=new HashSet();

for (int i = 0; i < obArr.length; i++) {
	set.add(obArr[i]); //1,1������ ������ Ÿ���� ������ ������ �ٸ��⋚���̴�.
}
System.out.println(set);
*/