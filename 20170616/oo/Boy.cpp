//
// Created by plter on 6/16/17.
//

#include <iostream>
#include "Boy.h"

Boy::Boy(int age, const std::string &name) : Student(age, name, "male") {}

void Boy::sayHello() {
    std::cout << "Boy " << getName() << " say hello" << std::endl;
}
