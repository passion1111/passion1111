#include "ArrayStack.h"

void As_CreateStack(ArrayStack** Stack, int Capacity) {
	//������ ��������ҿ� ����
	(*Stack) = (ArrayStack*)malloc(sizeof(ArrayStack));
	(*Stack)->Nodes = (Node*)malloc(sizeof(Node) * Capacity);

	//Capacity�� Top�ʱ�ȭ
	(*Stack)->Capacity = Capacity;
	(*Stack)->Top = 0;
}


void As_DestroyStack(ArrayStack* Stack) {
	
	free(Stack->Nodes);
	free(Stack);

}


void As_Push(ArrayStack* Stack, ElementType Data) {
	int position = Stack->Top;
	Stack->Nodes[position].Data = Data;
	Stack->Top++;

}

ElementType As_Pop(ArrayStack* Stack) {
	int position = --(Stack->Top);

	return Stack->Nodes[position].Data;
}


ElementType As_Top(ArrayStack* Stack) {
	int position = Stack->Top - 1;
	return Stack->Nodes[position].Data;
}


int As_GetSize(ArrayStack* Stack) {
	return Stack->Capacity;
}

int As_IsEmpty(ArrayStack* Stack) {
	return (Stack->Top == 0);
}