#ifndef ArrayStack_H
#define ArrayStack_H

#include<stdio.h>
#include<stdlib.h>


typedef int ElementType;
typedef struct tagNode
{
	ElementType Data;
}Node;
typedef struct tagArrayStack
{
	int Capacity;
	int Top;
	Node* Nodes;

}ArrayStack;

void As_CreateStack(ArrayStack** Stack, int Capacity);
void As_DestroyStack(ArrayStack* Stack);
void As_Push(ArrayStack* Stack, ElementType Data);
ElementType As_Pop(ArrayStack* Stack);
ElementType As_Top(ArrayStack* Stack);
int As_GetSize(ArrayStack* Stack);
int As_IsEmpty(ArrayStack* Stack);
#endif
