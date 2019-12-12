//
//  a4_MedianofTwoSortedArrays.cpp
//  ltc
//
//  Created by 赵小川 on 2019/12/9.
//  Copyright © 2019 赵小川. All rights reserved.
//
/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
你可以假设 nums1 和 nums2 不会同时为空。

示例 1:
nums1 = [1, 3]
nums2 = [2]
则中位数是 2.0

示例 2:
nums1 = [1, 2]
nums2 = [3, 4]
则中位数是 (2 + 3)/2 = 2.5
 */

#include <stdio.h>
#include <vector>
using std::vector;

int main() {
    printf("hello\n");
    std::vector<int> a = {1, 2, 3};
    for (auto& x : a)
        printf("%d\n", x);
}

class Solution {
 public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        return 0;
    }
};


/*
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }
    //i: nums1的起始位置 j: nums2的起始位置
    public int findKth(int[] nums1, int i, int[] nums2, int j, int k){
        if( i >= nums1.length) return nums2[j + k - 1];//nums1为空数组
        if( j >= nums2.length) return nums1[i + k - 1];//nums2为空数组
        if(k == 1){
            return Math.min(nums1[i], nums2[j]);
        }
        int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
        int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
        if(midVal1 < midVal2){
            return findKth(nums1, i + k / 2, nums2, j , k - k / 2);
        }else{
            return findKth(nums1, i, nums2, j + k / 2 , k - k / 2);
        }        
    }
}
 */

/* */
// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         /**
//         如果两个数组的中位数 mid1 < mid2, 则说明合并后的中位数位于 num1.right + num2之间
//         否则合并后的中位数位于 nums2.right + nums1 之间 (right 是相对于 mid 而言的) 
//         getKth 函数负责找到两个数组合并(假设)后有序的数组中的第 k 个元素, k 从 1 开始计算
//         **/   
//         if(nums1.length == 0 && nums2.length == 0) return 0.0;
//         int m = nums1.length, n = nums2.length;
//         // l: 合并后数组的左半部分的最后一个数 r: 合并后数组的右半部分的第一个数
//         int l = (m+n+1) / 2; 
//         int r = (m+n+2) / 2;
//         // 如果 m+n 是奇数 getKth 的返回值是相同的, 是偶数则是合并后数组的中间两个数
//         if(l == r) return getKth(nums1, 0, nums2, 0, l);
//         return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
//     }
    
//     private double getKth(int[] nums1, int st1, int[] nums2, int st2, int k) {
//         // 边界情况, 如果 nums1数组已经穷尽了, 则只能返回 nums2 中的第 k 个元素
//         if(st1 > nums1.length-1) return nums2[st2 + k - 1];
//         if(st2 > nums2.length-1) return nums1[st1 + k - 1];
//         // 边界情况, k = 1 则返回两个数组中最小的那个
//         if(k == 1) return Math.min(nums1[st1], nums2[st2]);
//         // 在 nums1 和 nums2 当前范围内找出 mid1 和 mid2 判断舍弃哪半部分
//         int mid1 = Integer.MAX_VALUE;
//         int mid2 = Integer.MAX_VALUE;
//         if(st1 + k/2 - 1 < nums1.length) mid1 = nums1[st1 + k/2 - 1];
//         if(st2 + k/2 - 1 < nums2.length) mid2 = nums2[st2 + k/2 - 1];
//         // mid1 < mid2 在 nums1.right 和 nums2 之间搜索, 丢掉 k/2 个数.
//         if(mid1 < mid2)
//             return getKth(nums1, st1 + k/2, nums2, st2, k - k/2);
//         else
//             return getKth(nums1, st1, nums2, st2 + k/2, k - k/2);
//     }
// }