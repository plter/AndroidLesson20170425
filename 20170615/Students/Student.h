//
// Created by plter on 6/15/17.
//

#ifndef STUDENTS_STUDENT_H
#define STUDENTS_STUDENT_H

typedef struct {
    int age;
    char *name;
} Student;

Student *createStudent(int age, char *name);

void freeStudent(Student *student);

#endif //STUDENTS_STUDENT_H
