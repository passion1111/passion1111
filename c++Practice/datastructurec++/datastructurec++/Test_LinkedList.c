#include "LinkedList.h"


int main() {
	int i = 0;
	int Count = 0;
	Node* List = NULL;
	Node* Current = NULL;
	Node* NewNode = NULL;
	
	for (int i = 0; i < 5; i++) {
		NewNode = SLL_CreateNode(i);
		SLL_AppendNode(&List, NewNode);
	}




	NewNode = SLL_CreateNode(-3);
	SLL_InsertNewHead(&List, NewNode);


	NewNode = SLL_CreateNode(-46);
	SLL_InsertNewHead(&List, NewNode);


	//���
	Count = SLL_GEtNodeCount(List);
	for (int i = 0; i < Count; i++)
	{
		Current = SLL_GetNodeAt(List,i);
		printf("List[%d] : %d \n", i, Current->Data);


	}

	//����Ʈ ������ ���ڿ� ����� ����// 
	printf("\nInserting 5252 After[2] \n\n");
	Current = SLL_GetNodeAt(List, 2);
	NewNode = SLL_CreateNode(5252);
	SLL_InsertAfter(Current, NewNode);
	//�ٽ����
	
	Count = SLL_GEtNodeCount(List);
	for (int i = 0; i < Count; i++)
	{
		Current = SLL_GetNodeAt(List, i);
		printf("List[%d]: %d \n", i, Current->Data);
	}



	//�޸�����
	printf("\n�޸����� \n");
	for (int i = 0; i < Count; i++) {
		Current = SLL_GetNodeAt(List, 0);
		if (Current != NULL) {
			SLL_RemoveNode(&List, Current);
			SLL_DestoryNode(Current);

		}
	}










}