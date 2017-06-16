//
// Created by plter on 6/16/17.
//

#include "Hello.h"
#include <stdio.h>

void Hello::sayHello() {
    printf("Hello %s\n", name.c_str());
}

void Hello::sayHi() {
    printf("Hi\n");
}

Hello::Hello(const std::string &name) : name(name) {}

