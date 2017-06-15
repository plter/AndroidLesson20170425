#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main() {

    srand(time(NULL));
    int randomNumber;

    for (int i = 0; i < 10; ++i) {
        randomNumber = rand() % 100;
    }

    puts("请输入一个0到一100之间的数字\n");

    int inputValue;

    while (1) {
        scanf("%d", &inputValue);
        if (inputValue > randomNumber) {
            puts("输入的数字大\n");
        } else if (inputValue < randomNumber) {
            puts("输入的数字小\n");
        } else {
            puts("输入数字正确，游戏退出\n");
            break;
        }
    }


    return 0;
}