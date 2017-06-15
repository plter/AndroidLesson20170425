#include <stdlib.h>
#include <stdio.h>

typedef struct {
    int age;
    char *name;
} Student;

int main() {

    Student *s = malloc(sizeof(Student));
    s->age = 10;
    s->name = "XiaoMing";

    Student *s1 = s;
    s1->age = 20;

    printf("s(name=%s,age=%d)", s->name, s->age);

    return 0;
}