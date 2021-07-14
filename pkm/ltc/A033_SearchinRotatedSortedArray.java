/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A033_SearchinRotatedSortedArray 
 * @author riverz
 * @date 2017年6月12日 上午11:04:20
 * @Description:Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
Tags: Binary Search, Array
Similar Problems (M) A081_Search in Rotated Sorted Array II (M) A153_Find Minimum in Rotated Sorted Array

 */
public class A033_SearchinRotatedSortedArray {

	/**@date 2017年6月12日 上午11:04:20
	 * @Description: */
	public static void main(String[] args) {
		int[] nums = {5,1,3};
		int target = 3;
		System.out.println(search(nums,target));

	}
	
    /**@date 2017年6月12日 上午11:07:46
     * @Description: 先找到分界点，然后判断target与分界点的大小关系，在其中一侧进行二分查找
     * 此题需要注意很多下标小细节*/
    public static int search(int[] nums, int target) {
    	if(nums.length==0) return -1;
		int lo=0, hi=nums.length-1, mid=0;
		while(lo<hi){//lo<hi,当lo==hi时已经找到rotate点
			mid = lo+(hi-lo)/2;
			if(nums[mid]>nums[hi])
				lo=mid+1;
			else
				hi=mid;//hi=mid不是hi=mid-1，mid恰好在分界点时满足nums[mid]<=nums[hi]
		}
		int rotate = lo;
//		System.out.println(rotate);
		lo = target<=nums[nums.length-1]?rotate:0;
		hi = target<=nums[nums.length-1]?nums.length-1:rotate-1;
		while(lo<=hi){//lo<=hi，当lo==hi时需要判断一下nums[mid]==target
			mid = lo+(hi-lo)/2;
			if(nums[mid]==target) return mid;
			else if(nums[mid]>target) hi=mid-1;
			else lo=mid+1;
		}
		return -1;
    }

}
