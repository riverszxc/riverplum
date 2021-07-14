/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A026_RemoveDuplicatesfromSortedArray 
 * @author riverz
 * @updateDate 2017年6月12日 上午8:56:01
 * @Description:Given a sorted array, remove the duplicates in place such that each element appear only once 
and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
For example,
Given input array nums = [1,1,2],
Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. 
It doesn't matter what you leave beyond the new length.
Tags: Array, Two Pointers
Similar Problems (E) A027_Remove Element

 */
public class A026_RemoveDuplicatesfromSortedArray {
	
	public static void main(String[] args) {
		A026_RemoveDuplicatesfromSortedArray a26 = new A026_RemoveDuplicatesfromSortedArray();
		int nums[] = {1,1,2};
		System.out.println(a26.removeDuplicates(nums));
		for(int x : nums)
			System.out.println(x);

	}
	
	/**@date 2017年6月12日 上午9:06:40
	 * @Description: 从第二个开始遍历，若与前一个相等，则k++，若不等，则往前挪k位*/
	public int removeDuplicates(int[] nums){
		if(nums.length<2)
			return nums.length;
		int k=0;
		for(int i=1;i<nums.length;i++){
			if(nums[i]==nums[i-1])
				k++;
			else
				nums[i-k]=nums[i];
		}
		
		return nums.length-k;
	}

	/*Old Version:*/
	public int removeDuplicates1(int[] nums) {
		int len = nums.length;
		int k = 0;
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]==nums[i+1]){
				len--;
				k++;
			}else{
				nums[i-k] = nums[i];
			}
		}
		
		if(nums.length>1)
			nums[nums.length-k-1] = nums[nums.length-1];
		return len;
    }



}
