/**
 * 
 */
package me.riverz.leetcode;

/**
 * @author rivers
 * @description Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 */
/**
 * @ClassName: A027_RemoveElement 
 * @author riverz
 * @updateDate 2017年6月12日 上午9:11:10
 * @Description:Given an array and a value, remove all instances of that value in place and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
Example:
Given input array nums = [3,2,2,3], val = 3
Your function should return length = 2, with the first two elements of nums being 2.
Tags: Array, Two Pointers
Similar Problems (E) A026_Remove Duplicates from Sorted Array (E) A203_Remove Linked List Elements (E) A283_Move Zeroes

 */
public class A027_RemoveElement {
	
	public static void main(String[] args){
		A027_RemoveElement a27 = new A027_RemoveElement();
		int[] nums = {1,2,3};
		int val = 1;
		System.out.println(a27.removeElement(nums, val));
		for(int x:nums)
			System.out.print(x);
	}
	
	public int removeElement(int[] nums, int val){
		int len = nums.length, k=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]==val){
				len--;
				k++;
			}else{
				nums[i-k] = nums[i];
			}
		}
		return len;
	}
	

}
