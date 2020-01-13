#include<cstdio>

int strlen(char* str) {
    int len = 0;
    for (int i = 0; str[i]!=NULL; i++)
    {
        len++;
    }


    return len;
}

int main() {
    char test[16];
    scanf("%s", &test);
    //%[^\n]
    int result=0;
    for (int i = 0; test[i] != NULL; i++)
        if ('A' <= test[i] && test[i] <= 'C')
            result += 2;
        else if ('D' <= test[i] && test[i] <= 'F')
            result += 3;
        else if ('G' <= test[i] && test[i] <= 'I')
            result += 4;
        else if ('J' <= test[i] && test[i] <= 'L')
            result += 5;
        else if ('M' <= test[i] && test[i] <= 'O')
            result += 6;
        else if ('P' <= test[i] && test[i] <= 'S')
            result += 7;
        else if ('T' <= test[i] && test[i] <= 'V')
            result += 8;
        else if ('W' <= test[i] && test[i] <= 'Z')
            result += 9;

    result += strlen(test);

    printf("%d", result);

   return 0;
}