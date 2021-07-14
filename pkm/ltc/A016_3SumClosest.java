/**
 * 
 */
package me.riverz.leetcode;

import java.util.Arrays;

/**
 * @ClassName: A016_3SumClosest 
 * @author riverz
 * @updateDate 2017年6月4日 下午3:23:38
 * @Description:Given an array S of n integers, 
find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.
    For example, given array S = {-1 2 1 -4}, and target = 1.
    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Tags: Array, Two Pointers
Similar Problems (M) A015_3Sum (M) 3Sum Smaller

 */
public class A016_3SumClosest {
	
	public static void main(String[] args) {
		A016_3SumClosest a016 = new A016_3SumClosest();
		int a[] = {0,0,0};
		System.out.println(a016.threeSumClosest(a, 1));

	}
	
	/**@date 2017年6月4日 下午3:33:09
	 * @Description: */
	public int threeSumClosest(int[] nums, int target){
		
		return threeSumClosest1(nums,target);
	}
	
	
	
	/*Old Version:*/
	public int threeSumClosest1(int[] nums, int target){
		int sum=0, tsum, dis = Integer.MAX_VALUE;
		Arrays.sort(nums);
		for(int i=0; i<nums.length-2; i++){
			tsum = nums[i] + this.twoSumClosest(nums, i+1, target-nums[i]);
			if(Math.abs(target-tsum)<dis){
				sum = tsum;
				dis = Math.abs(target-tsum);
			}
		}
		
		return sum;	
	}
	
	public int twoSumClosest(int[] nums, int start, int target){
		int i=start, j=nums.length-1, dis = Integer.MAX_VALUE, sum=0;
		while(i<j){
			if(Math.abs(nums[i]+nums[j]-target)<dis){
				dis = Math.abs(nums[i]+nums[j]-target);
				sum = nums[i]+nums[j];
			}
			if(nums[i]+nums[j]<target)
				i++;
			else if(nums[i]+nums[j]>target)
				j--;
			else
				break;
		}
		
		return sum;	
	}

	

}
