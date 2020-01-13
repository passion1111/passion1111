#include<cstdio>
#include <climits>
using namespace std;

struct Queue
{
	//rear는 꼬리 //front는 앞머리 
	int rear, front;


	//할당할 배열 크기
	int size;
	//동적할당하기위한 포인터 arr
	int* arr;
	Queue(int s) {
		front = rear = -1;
		size = s;
		arr = new int[s];
	}
	//삽입
	void enQueue(int value);
	//삭제 
	int deQueue();
	//출력
	void displayQueue();

};

void Queue::enQueue(int value) {
	        //첫번쨰 조건 front가 0에있고 rear가 마지막(배열이니 size-1)에 있는것은 납득 Ok 
			//두번쨰 조건 rear==(front-1) %(size-1)) 는 왜있는거지 
			//배열 조건내 나머지를구하는데 front -1은 rear가 front-1의 배열위치에 있다는뜻이니 꽉차있다고 판단이 가능
	if ((front == 0 && rear == size - 1) || rear == (front - 1) % (size - 1)) {
		printf("\nQueue is Full");
		return;
	}
	//초기화상태이니까 rear위치를 0으로 셋팅후 값할당 
	else if (front == -1) {
		front = rear = 0;
		arr[rear] = value;
	}

	    //rear가 배열길이만큼들어가있고 front가 0이아니면  rear위치를 다시 0으로 되돌려야함 왜냐하면 환형이니까 
	else if (rear == size - 1 && front != 0) {
		rear = 0;
		arr[rear] = value;
	}
	//rear가 마지막도 아니고 front가0도아니거나 프론트-1/배열길이가 rear도 아니면 
	//꼬리값을 ++시켜주고 값할당
	else
	{
		rear++;
		arr[rear] = value;
	}
}

int Queue::deQueue() {

	//프론트-1이면 비어있다는 의미 
	if (front == -1) {

		printf("\nQueue is Empty");
		return INT_MIN;
	}
	//가장 앞단의 데이터를할당
	//데이터있던곳은 -1넣어서 헷갈리지않게 
		int data = arr[front];
		arr[front] = -1;

	//front==rear이면 데이터 하나 넣은상태에서 deque할려고하는거니까 -1로 초기화 
		if (front == rear)
		{
			front = rear = -1;
		}
		//front가 배열 마지막에 들어가있으면 front를 0으로 
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
	printf("\nElements in 환형큐 : ");
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


	printf("데큐 %d\n", que.deQueue());
	printf("데큐 %d\n", que.deQueue());
	
	que.displayQueue();

	que.enQueue(333);
	que.enQueue(222);

	que.displayQueue();
	printf("\n체크\n");
	printf("데큐 %d\n", que.deQueue());
	printf("데큐 %d\n", que.deQueue());
	printf("데큐 %d\n", que.deQueue());
	printf("데큐 %d\n", que.deQueue());
	printf("데큐 %d\n", que.deQueue());
	printf("데큐 %d\n", que.deQueue());









	return 0;
}
