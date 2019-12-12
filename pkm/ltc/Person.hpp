//
//  Person.hpp
//  testcpp
//
//  Created by 赵小川 on 2019/11/15.
//  Copyright © 2019 赵小川. All rights reserved.
//

#ifndef Person_hpp
#define Person_hpp

#include <stdio.h>
#include <string>

using std::string;

class Person {
public:
    Person (string name, int age, string gender):
        name_(name),
        age_(age),
        gender_(gender) {
            std::cout << "person info: " << name << age << gender << std::endl;
        }
    virtual ~Person() {}
    string name_;
    int age_;
    string gender_;
    
    string concat_info();
    bool CalcFea();
};
#endif /* Person_hpp */
