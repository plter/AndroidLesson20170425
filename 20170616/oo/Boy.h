//
// Created by plter on 6/16/17.
//

#ifndef OO_BOY_H
#define OO_BOY_H


#include "Student.h"

class Boy : public Student {
public:
    Boy(int age, const std::string &name);

    void sayHello() override;
};


#endif //OO_BOY_H
