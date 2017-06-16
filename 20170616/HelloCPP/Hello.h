//
// Created by plter on 6/16/17.
//

#ifndef HELLOCPP_HELLO_H
#define HELLOCPP_HELLO_H


#include <string>

namespace lib {

    class Hello {

    private:
        std::string name;

    public:
        Hello(const std::string &name);

        virtual ~Hello();

        void sayHello();

        void sayHi();
    };
}


#endif //HELLOCPP_HELLO_H
