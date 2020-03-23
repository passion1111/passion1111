#include "CircularDoublyLinkedList.h"

Node* CDLL_CreateNode(ElementType NewData) {
    Node* NewNode = (Node*)malloc(sizeof(Node));
    NewNode->Data = NewData;
    NewNode->NextNode = NULL;
    NewNode->PrevNode = NULL;

     



    
    return NewNode;
}
void  CDLL_DestroyNode(Node* Node) {
    
    free(Node);
}
void  CDLL_AppendNode(Node** Head, Node* NewNode) {

    if ((*Head) == NULL) {
        *Head = NewNode;
        (*Head)->NextNode = NewNode;
        (*Head)->PrevNode = NewNode;
    }
    else {
        Node* tail = *Head;
        tail->PrevNode->NextNode = NewNode;
        NewNode->PrevNode = tail->PrevNode;
        NewNode->NextNode = tail;
        tail->PrevNode = NewNode;
    }


}
void  CDLL_InsertAfter(Node* Current, Node* NewNode) {

    Current->NextNode->PrevNode = NewNode;
    NewNode->PrevNode = Current;
    NewNode->NextNode = Current->NextNode;
    Current->NextNode = NewNode;


}
void  CDLL_RemoveNode(Node** Head, Node* Remove) {

    if ((*Head) == Remove) {
        (*Head)->PrevNode->NextNode = Remove->NextNode;
        (*Head)->NextNode->PrevNode = Remove->PrevNode;
        (*Head) = Remove->NextNode;
    }
    else {
        Node* tail = *Head;


        while (tail != NULL && tail->NextNode != Remove) {
            tail = tail->NextNode;
        }
        if (tail != NULL) {
            tail->NextNode = Remove->NextNode;
            tail->NextNode->PrevNode = Remove->PrevNode;
            Remove->NextNode = NULL;
            Remove->PrevNode = NULL;


        }


    }


}
Node* CDLL_GetNodeAt(Node* Head, int Location) {
    Node* tail = Head;

    while (tail != NULL && (--Location) >= 0 && tail->NextNode !=Head) {
        tail = tail->NextNode;
    }


    return tail;

}
int   CDLL_GetNodeCount(Node* Head) {
    Node* tail = Head;
    int count = 0;

    while (tail != NULL && tail->NextNode !=Head) {
        tail = tail->NextNode;
        count++;
    }

    return count;
}

void PrintNode(Node* _Node)
{
    if (_Node->PrevNode == NULL)
        printf("Prev: NULL");
    else
        printf("Prev: %d", _Node->PrevNode->Data);

    printf(" Current: %d ", _Node->Data);

    if (_Node->NextNode == NULL)
        printf("Next: NULL\n");
    else
        printf("Next: %d\n", _Node->NextNode->Data);
}
