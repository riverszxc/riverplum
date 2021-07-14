/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A081_SearchinRotatedSortedArrayII 
 * @author riverz
 * @date 2017年6月12日 下午12:05:28
 * @Description:Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Write a function to determine if a given target is in the array.
The array may contain duplicates.
Tags: Array, Binary Search
Similar Problems (M) A033_Search in Rotated Sorted Array

 */
public class A081_SearchinRotatedSortedArrayII {

	/**@date 2017年6月12日 下午12:05:29
	 * @Description: */
	public static void main(String[] args) {
		int[] nums = {6,1,1,1};//1,1,3,1
		int target = 6;
		System.out.println(search(nums,target));

	}
	
    /**@date 2017年6月13日 上午7:54:22
     * @Description: 先找到分界点，然后判断target与分界点的大小关系，在其中一侧进行二分查找
     * 此题需要注意很多下标小细节*/
    public static boolean search(int[] nums, int target) {
    	if(nums.length==0) return false;
		int lo=0, hi=nums.length-1, mid=0;
		while(lo<hi){//lo<hi,当lo==hi时已经找到rotate点
			//首位相等则左侧递进
			if(nums[lo]==nums[hi]){
				lo++;
				continue;
			}
			mid = lo+(hi-lo)/2;
			if(nums[mid]>nums[hi])
				lo=mid+1;
			else
				hi=mid;//hi=mid不是hi=mid-1，mid恰好在分界点时满足nums[mid]<=nums[hi]
		}
		int rotate = lo;
		System.out.println("rotate:"+rotate);
		lo = target<=nums[nums.length-1]?rotate:0;
		hi = target<=nums[nums.length-1]?nums.length-1:rotate-1;
		while(lo<=hi){//lo<=hi，当lo==hi时需要判断一下nums[mid]==target
			mid = lo+(hi-lo)/2;
			if(nums[mid]==target) return true;
			else if(nums[mid]>target) hi=mid-1;
			else lo=mid+1;
		}
		return false;
    }
}
