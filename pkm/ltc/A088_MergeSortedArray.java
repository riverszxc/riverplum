/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: A088_MergeSortedArray 
 * @author riverz
 * @date 2017年6月9日 上午11:19:01
 * @Description:Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. 
The number of elements initialized in nums1 and nums2 are m and n respectively.
Tags： Array， Two Pointers
Similar Problems (E) A021_Merge Two Sorted Lists

 */
public class A088_MergeSortedArray {

	/**@date 2017年6月9日 上午11:19:01
	 * @Description: */
	public static void main(String[] args) {
		int[] nums1 = {2,5,9,0,0};
		int[] nums2 = {3,6};
		merge(nums1,3,nums2,2);
		for(int x:nums1)
			System.out.print(x);
	}
	
	/**@date 2017年6月9日 上午11:41:20
	 * @Description: 从后往前比较和放置数字，当i==0&&j>0时将剩余的nums2放入剩余的nums1，当i>0&&j==0时，其余的nums1已经在正确的位置*/
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int i=m-1,j=n-1,k=m+n-1;
		while(i>=0&&j>=0)
			nums1[k--] = nums1[i]>nums2[j]?nums1[i--]:nums2[j--];
		while(j>=0)
			nums1[k--] = nums2[j--];
    }

}
