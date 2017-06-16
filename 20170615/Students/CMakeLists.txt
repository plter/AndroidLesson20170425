cmake_minimum_required(VERSION 3.8)
project(Students)

set(CMAKE_C_STANDARD 11)

set(SOURCE_FILES main.c Student.c Student.h)
add_executable(Students ${SOURCE_FILES})