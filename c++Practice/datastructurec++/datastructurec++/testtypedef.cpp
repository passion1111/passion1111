#include<cstdio>


typedef enum {
	Left='(',right=')',
	plus='+',operand
}symbol;


void checkenum(int* type) {
	*type = plus;
	*type = Left;
	*type = right;
	*type = operand;


}

int main() {


	int Type;
	checkenum(&Type);

}