#include <iostream>
#include <vector>
#include <map>


int main() {


//    std::vector<int> vector;
//
//    vector.push_back(10);
//    vector.push_back(11);
//    vector.push_back(9);
//
//    auto i = vector.begin();
//    vector.insert(i, 20);
//    vector.insert(i + 3, 12);

//    std::cout << vector[0] << std::endl;

//    for (auto it = vector.begin(); it != vector.end(); it++) {
//        std::cout << *it << std::endl;
//    }

//    for (int &it : vector) {
//        std::cout << it << std::endl;
//    }

    std::map<std::string, std::string> m;
    m["name"] = "ZhangSan";
    m["gender"] = "male";

    std::cout << m["name"] << std::endl;

    return 0;
}