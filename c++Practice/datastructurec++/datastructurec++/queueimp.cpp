#include<cstdio>

//������ ���� ť
struct Queue {
    int front;
    int size;
    int* arr;
    Queue(int len) {
        front = -1;
        size = len;
        arr = new int[len];
    };
    void enQueue(int s);
    int deQueue();
    void displayQueue();
};


void Queue::enQueue(int s) {
    if (front == -1 ) {

        front = 0;
        arr[front] = s;
    }
    else if(front !=size-1) {
        front++;
        arr[front] = s;
        printf("%d��ť", front);
    }
    else {
        printf("�����־��");
    }

    
}

int Queue::deQueue() {

    if (front == -1)
        printf("�������");
        return -10000000;
    int data = arr[front--];
    return data;

}

void Queue::displayQueue() {
    printf("%d����Ʈ��ġ", front);
    if (front == -1)
        printf("ť������־");
    for (int i = 0; i <= front; i++)
        printf("%d\n", arr[i]);


}
int main() {

    Queue queimp(5);
    queimp.enQueue(3);
    queimp.enQueue(4);
    queimp.enQueue(5);
    queimp.enQueue(7);
    queimp.enQueue(7);
    queimp.enQueue(7);
    queimp.enQueue(7);

    queimp.enQueue(3);
    queimp.displayQueue();





}