//
// Created by plter on 6/16/17.
//

#include <iostream>
#include "Student.h"

Student::Student(int age, const std::string &name, const std::string &gender) :
        age(age),
        name(name),
        gender(gender) {}

void Student::sayHello() {
    std::cout << name << " say hello" << std::endl;
}

int Student::getAge() const {
    return age;
}

void Student::setAge(int age) {
    Student::age = age;
}

const std::string &Student::getName() const {
    return name;
}

void Student::setName(const std::string &name) {
    Student::name = name;
}

const std::string &Student::getGender() const {
    return gender;
}

void Student::setGender(const std::string &gender) {
    Student::gender = gender;
}

void Student::learn() {
    std::cout << name << " learn" << std::endl;
}
