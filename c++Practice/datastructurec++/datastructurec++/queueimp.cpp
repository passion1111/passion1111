#include<cstdio>

//간단한 연습 큐
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
        printf("%d엔큐", front);
    }
    else {
        printf("다차있어요");
    }

    
}

int Queue::deQueue() {

    if (front == -1)
        printf("비어있음");
        return -10000000;
    int data = arr[front--];
    return data;

}

void Queue::displayQueue() {
    printf("%d프론트위치", front);
    if (front == -1)
        printf("큐가비어있어여");
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