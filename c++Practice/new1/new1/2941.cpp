#include<cstdio>

int main() {

    char str[101];
    scanf("%s", str);
    int result = 0;
    for (int i = 0; str[i]!=NULL ; i++)
    {
        if (str[i] == 'c') {

            if (str[i + 1] == '=') {

                i++;
                result++;
            }
            else if (str[i + 1] == '-') {

                i++;
                result++;
            }
            else {

                result++;
            }
        }
        else if (str[i] == 'd') {

            if (str[i + 1] == 'z' && str[i + 2] == '=') {

                i+=2;
                result++;
            }
            else if (str[i + 1] == '-') {

                i++;
                result++;
            }
            else {

                result++;
            }
        }
        else if (str[i] == 'l') {

            if (str[i + 1] == 'j') {

                i++;
                result++;
            }
            else {

                result++;
            }
        }
        else if (str[i] == 'n') {

            if (str[i + 1] == 'j') {

                i++;
                result++;
            }
            else {
                result++;
            }
        }
        else if (str[i] == 's') {


                if (str[i + 1] == '='){
                    i++;
                  result++;
            }
                else {

                    result++;
                }

        }
        else if (str[i] == 'z') {

                if (str[i + 1] == '=') {

                    i++;
                    result++;
                }
                else
                    result++;
        }

        else {

            result++;
        }
    }
    printf("%d", result);

}