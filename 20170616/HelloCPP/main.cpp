#include <iostream>

#include "Hello.h"


using namespace lib;

int main(int argc, char **argv) {

//    Hello h("XiaoMing");
//    h.sayHello();

//    auto h = new Hello("XiaoMing");//C++ 11
//    h->sayHello();
//    delete h;

    std::shared_ptr<Hello> hp(new Hello("XiaoMing"));
    hp->sayHello();

    return 0;
}