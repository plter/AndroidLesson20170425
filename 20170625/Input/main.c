#include <stdio.h>
#include <stdint.h>

int main() {

//    int value = getchar();
//    char buf[1024];
//    gets(buf);
//
//    printf("Input value is %s!\n", buf);

    uint32_t value;
    scanf("%d", &value);

    printf("Input number is %d", value);
    return 0;
}