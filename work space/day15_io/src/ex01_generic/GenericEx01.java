package ex01_generic;

public class GenericEx01<T> {
	T[] v;//�������
	
	public void set(T[] V) {//����Լ�
		this.v=v;
	}
	public void print() {
		for(T item:v) {
			System.out.println(item);
		}
	}
}
