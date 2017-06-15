#include <stdio.h>
#include <assert.h>


#define ARR_LENGTH 10

int arr[ARR_LENGTH];

void putValue(int value, int index) {

    assert(index < ARR_LENGTH);//断言

    arr[index] = value;
}

int getValue(int index) {
    return arr[index];
}


int main() {
    putValue(20, 9);

    printf("Hello, World!%d\n", getValue(9));
    return 0;
}