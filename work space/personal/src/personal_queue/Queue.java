package personal_queue;


public class Queue {

	private int[] array;
	private int head;
	private int tail;

	public Queue(int size) {
		array = new int[size];
		head = -1;
		tail = -1;
	}

	/**
	 * ������ �Է� 
	 * 
	 * @param number
	 */
	public void enQueue(int number) {

		if (tail == array.length - 1)
			throw new RuntimeException("ť�� �� á���ϴ�.");

		// �Է½ÿ� tail�� ���� 
		array[++tail] = number;
	}

	/**
	 * ������ ��ȯ 
	 * 
	 * @return
	 */
	public int deQueue() {

		if (tail == -1)
			throw new RuntimeException("ť�� �����Ͱ� �����ϴ�.");

		// �޸� ��ȯ�� ���� �ʱ�ȭ 
		int temp = array[++head];
		array[head] = -1;

		// head, tail�� ���ٸ� �ε��� �ʱ�ȭ 
		if (head == tail) {
			head = -1;
			tail = -1;
		}

		return temp;
	}

	public static void main(String[] args) {
		Queue queue = new Queue(5);

		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);

		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}