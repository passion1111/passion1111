#include "ArrayStack.h"

int main(void) {


	int i = 0;
	ArrayStack* Stack=NULL;
	As_CreateStack(&Stack, 10);
	As_Push(Stack, 1);
	As_Push(Stack, 4);
	As_Push(Stack, 5);
	As_Push(Stack, 6);
	As_Push(Stack, 7);
	As_Push(Stack, 8);

	printf("Capacity :%d,Size : %d Top: %d \n\n", Stack->Capacity, As_GetSize(Stack), As_Top(Stack));

	for (int i = 0; i < 6; i++) {
		if (As_IsEmpty(Stack)) {
			break;
		}
		printf("Popped: %d\n\n", As_Pop(Stack));

		if (!As_IsEmpty(Stack)) {
			printf("Current %d\n", As_Top(Stack));
		}
		else {
			printf("stack is Empty\n");
		}



	}
		As_DestroyStack(Stack);

}