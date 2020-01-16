#include "ArrayStack.h"

void As_CreateStack(ArrayStack** Stack, int Capacity) {
	//스택을 자유저장소에 저장
	(*Stack) = (ArrayStack*)malloc(sizeof(ArrayStack));
	(*Stack)->Nodes = (Node*)malloc(sizeof(Node) * Capacity);

	//Capacity및 Top초기화
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