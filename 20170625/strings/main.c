#include <stdio.h>
#include <strings.h>

int main() {

//    char *str = "Hello World";

    char str[20];
    str[0] = 'H';
    str[1] = 'e';
    str[2] = 'l';
    str[3] = 'l';
    str[4] = 'o';
    str[5] = 0;
    str[6] = 'W';
    str[7] = 'o';

    printf("str:%s,len:%zd\n", str, strlen(str));
    return 0;
}