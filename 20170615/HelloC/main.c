#include <stdio.h>
#include <stdint.h>


void printValue() {
    static int count = 1;

    count++;

    printf("Current count %d\n", count);
}

void sayHello() {

    int num = 20;

    printf("Hello World %d\n", num);
}

int main() {
//    printf("Hello, World %d!\n", 10);

//    puts("Hello World\n");


//    int32_t arrLength = 10;
//    int32_t intArr[arrLength];
//
//    for (int32_t i = 0; i < arrLength; i++) {
//        intArr[i] = i;
//    }
//
//    for (int j = 0; j < arrLength; ++j) {
//        printf("Value:%d\n", intArr[j]);
//    }

//    sayHello();

    printValue();
    printValue();
    return 0;
}