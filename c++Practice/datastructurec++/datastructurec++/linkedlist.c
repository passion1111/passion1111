#include "LinkedList.h"

Node* SLL_CreateNode(ElementType NewData)
{
	Node* NewNode = (Node*)malloc(sizeof(Node));

	NewNode->Data = NewData;//데이터를 저장
	NewNode->NextNode = NULL;//다음노드에 대한포이넡 null 
	
	return NewNode;//노드주소 반환

}

void SLL_DestoryNode(Node* Node) {
	free(Node);
}

void SLL_AppendNode(Node** Head, Node* NewNode) {
	//Head노드가 NULL이면 새로운 노드가 HEad 
	if ((*Head) == NULL) {
		 *Head=NewNode;
	}
	else {
		//테일을 찾아 NewNode와 연결
		Node* Tail = (*Head);
		
		while (Tail->NextNode != NULL) {
			Tail = Tail->NextNode;
		}
		Tail->NextNode = NewNode;
	}
}

void SLL_InsertAfter(Node* Current, Node* NewNode) {
	NewNode->NextNode = Current->NextNode;
	Current->NextNode = NewNode;
}

void SLL_InsertNewHead(Node** Head, Node* NewHead) {

	if (Head == NULL) {
		(*Head) = NewHead;

	}
	else {
		NewHead->NextNode = (*Head);
		(*Head) = NewHead;
	}
}

//노드제거
void SLL_RemoveNode(Node** Head, Node* Remove) {
	if (*Head == Remove) {
		*Head = Remove->NextNode;
	}
	else {
		Node* Current = *Head;
		while (Current->NextNode != Remove && Current->NextNode!=NULL) {
			Current = Current->NextNode;
		}
		Current->NextNode = Remove->NextNode;


	}
}
//노드탐색
Node* SLL_GetNodeAt(Node* Head, int Location) {
	Node* Current = Head;
	
	while (Current != NULL && (--Location) >= 0) {
		Current = Current->NextNode;
	}
	

	return Current;
}

//노드 Count 

int SLL_GEtNodeCount(Node* Head) {
	int count = 0;
	Node* Current = Head; 
	while (Current != NULL) {
		Current = Current->NextNode;
		count++;
	}
	return count;
 }