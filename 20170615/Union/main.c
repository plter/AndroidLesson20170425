#include <stdio.h>
#include <stdint.h>


union Nums {
    int a;
    int b;
};

typedef struct {
    uint8_t blue;
    uint8_t green;
    uint8_t red;
    uint8_t alpha;
} Channels;

typedef union {
    int32_t color;
    Channels channels;
} Color;


int main() {

//    union Nums n1;
//    n1.a = 10;
//    printf("%d\n", n1.b);

    Color c = {0xffff0000};

    printf("%d,%d,%d,%d\n", c.channels.alpha, c.channels.red, c.channels.green, c.channels.blue);

    return 0;
}