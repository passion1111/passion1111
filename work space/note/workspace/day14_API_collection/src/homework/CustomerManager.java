package homework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class CustomerManager extends Customer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Customer> list = new ArrayList<Customer>();
		
		int num = 0;
		Iterator itr = list.iterator();

		while (true) {
			System.out.print("���ϴ� �޴��� �����Ͻÿ�"
					+ "\n (1. �� ���� �߰�, 2. �� ���� ����,\n3. �� ���� ����, 4. �� ����Ʈ ���, 5. ���α׷� ����) : ");
			num = sc.nextInt();
			
			if (num == 1) {
				list.add(new Customer());
				System.out.println("==========���� �� ���==========");
				for (int i = 0; i < list.size(); i++) { 
					System.out.println("Customer " + (i+1) + list.get(i));
				}
				System.out.println();
				
			} else if (num == 2) {
				if (!itr.hasNext()) {
					System.out.println("������ �� ������ �����ϴ�.");
					continue; // while, do~while ������ ������ �������� ����. 
				}
				System.out.print("�����ϱ⸦ ���ϴ� ���� ��ȣ�� �Է��Ͻÿ� ( 1 ~ ) : ");
				list.remove(sc.nextInt() - 1);
				System.out.println("==========���� �� ���==========");
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Customer " + (i+1) + list.get(i));
				}
				
			} else if (num == 3) {
				if (!itr.hasNext()) {
					System.out.println("������ �� ������ �����ϴ�.");
					continue;
				}
				
				System.out.print("�����ϱ⸦ ���ϴ� ���� ��ȣ�� �Է��Ͻÿ� ( 1 ~ ): ");
				list.set(sc.nextInt() - 1, new Customer());
				System.out.println("==========���� �� ���==========");
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Customer " + (i+1) + list.get(i));
				}
			} else if (num == 4) {
				System.out.println("==========���� �� ���==========");
				for (int i = 0; i < list.size(); i++) {
					System.out.println("Customer " + (i+1) + list.get(i));
				}
			} else if (num == 5) {
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է��ϼ��� : ");
			}
		}

	}
}
