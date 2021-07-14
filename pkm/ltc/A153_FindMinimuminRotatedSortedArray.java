/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A153_FindMinimuminRotatedSortedArray 
 * @author riverz
 * @date 2017年8月24日 下午8:40:55
 * @Description:Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.
Related Topics 
Array, Binary Search 
Similar Questions 
(M)A033_Search in Rotated Sorted Array (H)A154_Find Minimum in Rotated Sorted Array II 
 */
public class A153_FindMinimuminRotatedSortedArray {

	/**@date 2017年8月24日 下午8:40:55
	 * @Description: */
	public static void main(String[] args) {
		int[] nums = {7,5,6};
		System.out.println(findMin(nums));

	}
	
	/**@date 2017年8月24日 下午8:43:42
	 * @Description: */
	public static int findMin(int[] nums) {
		int lo=0, hi=nums.length-1,mid;
		while(lo<hi){
			mid=lo+(hi-lo)/2;
			if(nums[mid]>nums[hi])
				lo=mid+1;
			else
				hi=mid;
		}
        return nums[lo];
    }

}
