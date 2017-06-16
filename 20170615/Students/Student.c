//
// Created by plter on 6/15/17.
//

#include "Student.h"
#include <stdlib.h>


Student *createStudent(int age, char *name) {
    Student *s = malloc(sizeof(Student));
    s->name = name;
    s->age = age;
    return s;
}

void freeStudent(Student *student) {
    free(student);
}
