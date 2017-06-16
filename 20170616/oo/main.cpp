#include <iostream>
#include "Student.h"
#include "Boy.h"

int main() {

//    Student s(10, "XiaoMing", "male");
//    s.sayHello();
//
//    Boy b(10, "XiaoHua");
//    Student s1 = b;
//    s1.sayHello();
//    std::cout << b.getGender() << std::endl;

//    auto b = new Boy(10, "XiaoMing");
//    Student *s = b;
//
//    s->sayHello();
//
//    delete b;

    std::shared_ptr<Boy> b(new Boy(10, "XiaoMing"));
    b->sayHello();

    std::shared_ptr<Student> s(b);
    s->sayHello();

    b->Student::sayHello();

    return 0;
}