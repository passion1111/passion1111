//A가 B보다 큰 경우에는 '>'를 출력한다.
//A가 B보다 작은 경우에는 '<'를 출력한다.
//A와 B가 같은 경우에는 '=='를 출력한다.
#include<cstdio>

int main() {
    int x, y;
    scanf("%d %d", &x, &y);

    if (x > y) {
        printf(">");
    }
    else if (x < y) {
        printf("<");
    }
    else {
        printf("==");
    }
    return 0;

 }