#include <stdio.h>

//typedef struct Student {
//    int age;
//    char *name;
//} Student_t;

typedef struct {
    int age;
    char *name;
} Student;


int main() {

//    struct Student student = {100, "Hello"};
//    student.age = 10;
//    student.name = "XiaoMing";

//    struct Student s1 = student;
//    s1.age = 200;

    Student s = {100, "Hello"};

    Student s1 = s;

    printf("Student(age=%d,name=%s)\n", s.age, s.name);
    return 0;
}