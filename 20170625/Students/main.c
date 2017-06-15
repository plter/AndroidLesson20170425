#include <stdio.h>
#include "Student.h"

int main() {
    Student *s = createStudent(10, "XiaoMing");

    printf("s(name=%s,age=%d)\n", s->name, s->age);

    freeStudent(s);

    return 0;
}