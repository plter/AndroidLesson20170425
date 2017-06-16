//
// Created by plter on 6/16/17.
//

#ifndef OO_STUDENT_H
#define OO_STUDENT_H


#include <string>

class Student {

private:
    int age;
    std::string name;
    std::string gender;

public:
    Student(int age, const std::string &name, const std::string &gender);

    virtual void sayHello();

    int getAge() const;

    void setAge(int age);

    const std::string &getName() const;

    void setName(const std::string &name);

    const std::string &getGender() const;

    void setGender(const std::string &gender);
};


#endif //OO_STUDENT_H
