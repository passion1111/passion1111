//A�� B���� ū ��쿡�� '>'�� ����Ѵ�.
//A�� B���� ���� ��쿡�� '<'�� ����Ѵ�.
//A�� B�� ���� ��쿡�� '=='�� ����Ѵ�.
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