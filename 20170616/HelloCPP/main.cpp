#include <iostream>

#include "Hello.h"

int main(int argc, char **argv) {

//    Hello h("XiaoMing");
//    h.sayHello();


    Hello *h = new Hello("XiaoMing");
    h->sayHello();
    delete h;

    return 0;
}