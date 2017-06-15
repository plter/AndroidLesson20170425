#include <stdio.h>
#include <strings.h>

int main() {

    //define string
//    char *str = "Hello World";

//    char str[20];
//    str[0] = 'H';
//    str[1] = 'e';
//    str[2] = 'l';
//    str[3] = 'l';
//    str[4] = 'o';
//    str[5] = 0;
//    str[6] = 'W';
//    str[7] = 'o';
//
//    printf("str:%s,len:%zd\n", str, strlen(str));


    //contact string
    char str[20];
//    strcat(str, "Hello");
//    strcat(str, "World");
    sprintf(str, "Hello %d", 100);

    size_t strLength = strlen(str);

    printf("%s\n", str);
    printf("size of str :%zd,and the string length is :%zd\n", sizeof(str), strlen(str));

//    size_t strLength = strlen(str);

    for (int i = 0; i < strLength; ++i) {
        printf("%c\n", str[i]);
    }

//    printf("%c\n", *str);

    char *cp = str;
    char c;
    while ((c = *cp) > 0) {
        printf("%c\n", c);

        cp++;
    }

    return 0;
}