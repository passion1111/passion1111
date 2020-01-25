#include<stdio.h>
#include<stdlib.h>

typedef struct tagName {
	int data;
	struct tagName* NextNode;
}Node;



Node* sllcreatenode(int data) {
	Node* Head = (Node*)malloc(sizeof(Node));
	Head->data = data;
	Head->NextNode = NULL;


	return Head;
};


void sllinsertnode(Node** list,Node* node) {
	*list;
	**list;
	if ( (*list) == NULL) {
		(*list) = node;
	}
	else {

		Node* tail = (*list);
		while ((*list)->NextNode != NULL) {
			tail = tail->NextNode;
		}
		tail->NextNode = node;
	}

};

void printnode(Node* list) {
	if (list == NULL) {
		return;
	}
	while (list != NULL) {
		printf("%d\n", list->data);
		list = list->NextNode;

	}
}

	int main() {
		Node* list;
		printf("das");
		list=sllcreatenode( 6);
		Node* first(sllcreatenode(33));
		sllinsertnode(&list, first);
		printnode(list);



	

};