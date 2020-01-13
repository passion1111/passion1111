#include<cstdio>
#include <climits>
using namespace std;

struct Queue
{
	//rear�� ���� //front�� �ոӸ� 
	int rear, front;


	//�Ҵ��� �迭 ũ��
	int size;
	//�����Ҵ��ϱ����� ������ arr
	int* arr;
	Queue(int s) {
		front = rear = -1;
		size = s;
		arr = new int[s];
	}
	//����
	void enQueue(int value);
	//���� 
	int deQueue();
	//���
	void displayQueue();

};

void Queue::enQueue(int value) {
	        //ù���� ���� front�� 0���ְ� rear�� ������(�迭�̴� size-1)�� �ִ°��� ���� Ok 
			//�ι��� ���� rear==(front-1) %(size-1)) �� ���ִ°��� 
			//�迭 ���ǳ� �����������ϴµ� front -1�� rear�� front-1�� �迭��ġ�� �ִٴ¶��̴� �����ִٰ� �Ǵ��� ����
	if ((front == 0 && rear == size - 1) || rear == (front - 1) % (size - 1)) {
		printf("\nQueue is Full");
		return;
	}
	//�ʱ�ȭ�����̴ϱ� rear��ġ�� 0���� ������ ���Ҵ� 
	else if (front == -1) {
		front = rear = 0;
		arr[rear] = value;
	}

	    //rear�� �迭���̸�ŭ���ְ� front�� 0�̾ƴϸ�  rear��ġ�� �ٽ� 0���� �ǵ������� �ֳ��ϸ� ȯ���̴ϱ� 
	else if (rear == size - 1 && front != 0) {
		rear = 0;
		arr[rear] = value;
	}
	//rear�� �������� �ƴϰ� front��0���ƴϰų� ����Ʈ-1/�迭���̰� rear�� �ƴϸ� 
	//�������� ++�����ְ� ���Ҵ�
	else
	{
		rear++;
		arr[rear] = value;
	}
}

int Queue::deQueue() {

	//����Ʈ-1�̸� ����ִٴ� �ǹ� 
	if (front == -1) {

		printf("\nQueue is Empty");
		return INT_MIN;
	}
	//���� �մ��� �����͸��Ҵ�
	//�������ִ����� -1�־ �򰥸����ʰ� 
		int data = arr[front];
		arr[front] = -1;

	//front==rear�̸� ������ �ϳ� �������¿��� deque�ҷ����ϴ°Ŵϱ� -1�� �ʱ�ȭ 
		if (front == rear)
		{
			front = rear = -1;
		}
		//front�� �迭 �������� �������� front�� 0���� 
		else if (front == size - 1)
			front = 0;
		else
			front++;

		return data;
}
void Queue::displayQueue() {
	if (front == -1) {
		printf("\nQueue is Empty");
		return;
	}
	printf("\nElements in ȯ��ť : ");
	if (rear >= front)
	{
		for (int i = front; i <= rear; i++)
			printf("%d ", arr[i]);
	}
	else
	{
		for (int i = front; i <size; i++)
		{
			printf("%d ", arr[i]);
		}
		for (int i = 0; i <= rear; i++)
		{
			printf("%d ", arr[i]);
		}
	}
  }
int main() {
	Queue que(5);

	que.enQueue(15);
	que.enQueue(22);
	que.enQueue(2);
	que.enQueue(-11);
	que.enQueue(100);

	que.displayQueue();


	printf("��ť %d\n", que.deQueue());
	printf("��ť %d\n", que.deQueue());
	
	que.displayQueue();

	que.enQueue(333);
	que.enQueue(222);

	que.displayQueue();
	printf("\nüũ\n");
	printf("��ť %d\n", que.deQueue());
	printf("��ť %d\n", que.deQueue());
	printf("��ť %d\n", que.deQueue());
	printf("��ť %d\n", que.deQueue());
	printf("��ť %d\n", que.deQueue());
	printf("��ť %d\n", que.deQueue());









	return 0;
}
