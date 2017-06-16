cmake_minimum_required(VERSION 3.8)
project(HelloCPP)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES main.cpp Hello.cpp Hello.h)
add_executable(HelloCPP ${SOURCE_FILES})