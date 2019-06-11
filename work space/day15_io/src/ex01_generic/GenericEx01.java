package ex01_generic;

public class GenericEx01<T> {
	T[] v;//¸â¹öº¯¼ö
	
	public void set(T[] V) {//¸â¹öÇÔ¼ö
		this.v=v;
	}
	public void print() {
		for(T item:v) {
			System.out.println(item);
		}
	}
}
