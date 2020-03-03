#include "Çì´õ.h"

Node* SLL_CreateNode(ElementType NewData) {
	Node* NewNode = (Node*)malloc(sizeof(Node));
	NewNode->Data = NewData;
	NewNode->NextNode = NULL;


	return NewNode;

}
void  SLL_DestroyNode(Node* Node) {
	free(Node);
	

}
void  SLL_AppendNode(Node** Head, Node* NewNode)
{

	if ((*Head) == NULL) {
		*Head = NewNode;
	}
	else {

	Node* tail = *Head;

	while (tail->NextNode != NULL) {
		tail = tail->NextNode;
	}
	tail->NextNode = NewNode;

	}
}




void  SLL_InsertAfter(Node* Current, Node* NewNode) {
	NewNode->NextNode = Current->NextNode;
	Current->NextNode = NewNode;



}
void  SLL_InsertNewHead(Node** Head, Node* newNode) {
	if ( Head == NULL) {
		*Head = newNode;
	}
	else {
		newNode->NextNode = *Head;
		*Head = newNode;
	}





}
void  SLL_RemoveNode(Node** Head, Node* Remove) {
	if ((*Head) == Remove) {
		(*Head) = Remove->NextNode;
	}
	else {
		Node* tail = *Head;


		while (tail != NULL && tail->NextNode != Remove) {
			tail = tail->NextNode;
		}


		if (tail != NULL) {
			tail->NextNode = Remove->NextNode;
		}
	}





}
Node* SLL_GetNodeAt(Node* Head, int Location) {

	Node* tail = Head;
	
	while (tail != NULL && (--Location) >= 0) {
		tail = tail->NextNode;
	}

	return tail;


}
int   SLL_GetNodeCount(Node* Head) {
	Node* tail = Head;
	int count = 0;
	while (tail != NULL) {
		tail = tail->NextNode;
		count++;
	}

	return count;


}