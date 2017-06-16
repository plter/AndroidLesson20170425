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

    printf("s(name=%s,age=%d)\n", s->name, s->age);

    free(s);
    return 0;
}