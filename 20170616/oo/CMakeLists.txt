cmake_minimum_required(VERSION 3.8)
project(oo)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp Student.cpp Student.h Boy.cpp Boy.h)
add_executable(oo ${SOURCE_FILES})