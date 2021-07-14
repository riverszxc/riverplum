/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A154_FindMinimuminRotatedSortedArrayII 
 * @author rivers
 * @date 2017年8月24日 下午8:49:50
 * @Description:Follow up for "Find Minimum in Rotated Sorted Array":
What if duplicates are allowed?
Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
The array may contain duplicates.
Related Topics 
Array Binary Search 
Similar Questions 
(M)A153_Find Minimum in Rotated Sorted Array 
 */
public class A154_FindMinimuminRotatedSortedArrayII {

	/**@date 2017年8月24日 下午8:49:50
	 * @Description: */
	public static void main(String[] args) {
		int[] nums = {3,1,1,3};
		System.out.println(findMin(nums));

	}
	

	/**@date 2017年8月24日 下午8:50:54
	 * @Description: */
	public static int findMin(int[] nums) {
		int lo=0, hi=nums.length-1,mid;
		while(lo<hi){
			if(nums[lo]==nums[hi]){
				lo++;
				continue;
			}
			mid=lo+(hi-lo)/2;
			if(nums[mid]>nums[hi])
				lo=mid+1;
			else
				hi=mid;
		}
		System.out.println("rotate:"+lo);
        return nums[lo];
    }

}
