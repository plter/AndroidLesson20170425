#include <stdio.h>

int main(int argc, char **argv) {

    for (int i = 0; i < argc; ++i) {
        printf("%s\n", argv[i]);
    }

    printf("End!\n");
    return 0;
}