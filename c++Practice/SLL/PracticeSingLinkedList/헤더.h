#ifndef LinkedList_h
#define LinkedList_h

#include<stdio.h>
#include<stdlib.h>

typedef int ElementType;

typedef struct tagNode {

	ElementType Data;
	struct tagNode* NextNode;

}Node;

Node* SLL_CreateNode(ElementType NewData);
void  SLL_DestroyNode(Node* Node);
void  SLL_AppendNode(Node** Head,Node* Node);
void  SLL_InsertAfter(Node* Current, Node* NewNode);
void  SLL_InsertNewHead(Node** Head, Node* newNode);
void  SLL_RemoveNode(Node** Head, Node* Remove);
Node* SLL_GetNodeAt(Node* Head, int Location);
int   SLL_GetNodeCount(Node* Head);

#endif