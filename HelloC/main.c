#include <stdio.h>

int main() {
//    printf("Hello, World!\n");

    for (int i = 0; i < 100; ++i) {
        if(i % 2 == 0) {
            printf("The number is %d\n", i);
        }
    }

    return 0;
}