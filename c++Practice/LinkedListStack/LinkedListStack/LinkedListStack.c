#include "LinkedListStack.h"

void  LLS_CreateStack(LinkedListStack** Stack) {
	(*Stack) = (LinkedListStack*)malloc(sizeof(LinkedListStack));
	(*Stack)->List = NULL;
	(*Stack)->Top = NULL;


}
void  LLS_DestroyStack(LinkedListStack* Stack) {
	while (!LLS_IsEmpty(Stack))
	{
		Node* Popped = LLS_Pop(Stack);
		LLS_DestroyNode(Popped);
	}

	free(Stack);
}

Node* LLS_CreateNode(char* Data) {
	Node* NewNode = (Node*)malloc(sizeof(Node));
	NewNode->Data = (char*)malloc(strlen(Data) + 1);

	strcpy(NewNode->Data, Data);
	NewNode->NextNode = NULL;

	return NewNode;
}
void  LLS_DestroyNode(Node* _Node) {
	free(_Node->Data);
	free(_Node);
}

void  LLS_Push(LinkedListStack* Stack, Node* NewNode) {

	if (Stack->List == NULL) {
		Stack->List = NewNode;
		
	}
	else {
		Node* tail = Stack->List;
		while (tail->NextNode != NULL) {
			tail = tail->NextNode;
		}
		tail->NextNode = NewNode;


	}
	Stack->Top = NewNode;

	
}
Node* LLS_Pop(LinkedListStack* Stack) {
	
	Node* tail = Stack->Top;
	if (Stack->List == tail) {
		
		Stack->List = NULL;
		Stack->Top = NULL;
		return tail;
	}
	else {


		Node* tail2 = Stack->List;
	while (tail2 != NULL && tail2->NextNode !=tail) {
		tail2 = tail2->NextNode;
	}
	tail2  ->NextNode = NULL;
	Stack->Top = tail2;
	}

	//팝할려면 가장 마지막 
	//tail2가 마지막인건 확실 
	//근데 팝하고나서 tail2는 저장돼있으면 안됨 top위치를 

	return tail;


}

Node* LLS_Top(LinkedListStack* Stack) {
	return Stack->Top;
}
int   LLS_GetSize(LinkedListStack* Stack) {
	int count = 0;
	Node* tail = Stack->List;

	while (tail != NULL) {
		tail=tail->NextNode;
		count++;
	}

	return count;
	
}
int   LLS_IsEmpty(LinkedListStack* Stack) {

	return (Stack->List == NULL);

}

