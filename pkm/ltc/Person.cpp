//
//  Person.cpp
//  testcpp
//
//  Created by 赵小川 on 2019/11/15.
//  Copyright © 2019 赵小川. All rights reserved.
//

#include "Person.hpp"
#include <sstream>
#include <vector>
#include <map>
#include <iostream>

using std::to_string;
using std::stringstream;
using std::vector;
using std::map;
using std::max;
using std::cout;
using std::endl;

string Person::concat_info() {
    stringstream s;
    s << name_ << ", " << age_ << ", " << gender_;
    return s.str();
}

bool Person::CalcFea() {
    vector<string> i2behav{"CLICK", "FOLLOW", "ADDCART", "ORDER"};
    vector<vector<float>> feature_hour_list = {
        {1,1,1,1},
        {2,2,2,2},
        {3,3,3,3},
        {4,4,4,4},
        {5,5,5,5},
        {6,6,6,6}
    };
    map<string, map<int, vector<float> > > feature_behav_map;
    vector<int> time_ranges{1, 3, 6};  // 此vector可按需改为从config取值来构建
    vector<float> tmpsum(i2behav.size());
    vector<float> tmpmax(i2behav.size());
    for (size_t i = 0, k = 0; i < feature_hour_list.size(); ++i) {
        for (size_t j = 0; j < feature_hour_list[i].size() && j < i2behav.size(); ++j) {
            tmpsum[j] += feature_hour_list[i][j];
            tmpmax[j] = max(tmpmax[j], feature_hour_list[i][j]);
            if (static_cast<int>(i) == time_ranges[k] - 1) {
                feature_behav_map[i2behav[j]][time_ranges[k]].emplace_back(tmpsum[j]);  // sum
                feature_behav_map[i2behav[j]][time_ranges[k]].emplace_back(tmpsum[j]/(i+1));  // avg
                feature_behav_map[i2behav[j]][time_ranges[k]].emplace_back(tmpmax[j]);  // max
                if (j == feature_hour_list[i].size() - 1)
                    ++k;
            }
        }
    }
    for (auto& x : feature_behav_map) {
        cout << x.first << endl;
        for (auto& y : x.second) {
            cout << y.first << endl;
            for (auto& z : y.second) {
                cout << z << " ";
            }
            cout << endl;
        }
    }
    return true;
}

void median_of_2_ordered_list() {
    vector<int> a{1,3,5,7};
    vector<int> b{2,4,6,8};
    
}
