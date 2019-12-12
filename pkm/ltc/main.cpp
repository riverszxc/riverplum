//
//  main.cpp
//  testcpp
//
//  Created by 赵小川 on 2019/11/13.
//  Copyright © 2019 赵小川. All rights reserved.
//

#include <iostream>
#include <vector>
#include <string>
#include <map>
#include "Person.hpp"

using std::vector;
using std::string;
using std::cout;
using std::endl;
using std::to_string;
using std::map;

struct Person1{
    int age;
};



int main(int argc, const char * argv[]) {
    /*
    Person1 v;
    v.age = 1;
    cout << "hello" + to_string(v.age) << endl;

    */
    Person p("ming", 20, "male");
    //p.CalcFea();
    
    vector<int> x{1,2,3};
    vector<float> y(x.size(), 0);
    for (auto& t : y) {
        cout << t << endl;
    }
    cout << "====" << endl;
    float t;
    int tt;
    cout << t << ", " << tt << endl;
    t=0.0;
    cout << t << endl;
    
    map<string, int> m = {
        {"a", 1},
        {"b", 1}
    };
    cout << "m:" << m["a"] << endl;
    m["a"]++;
    cout << "m[a]:" << m["a"] << endl;
    
    cout << "=====" << endl;
    map<int, int> mm = {
        {1, 11},
        {2, 22}
    };
    for (auto& x : mm) {
        cout << x.first << x.second << endl;
    }
    cout << "=====2" << endl;
    int aa = 1;
    int* ap = &aa;
    cout << "aa=" << aa << endl;
    cout << "ap=" << *ap << endl;
    int*& app = ap;
    cout << "app=" << *app << endl;
    
    return 0;
}
