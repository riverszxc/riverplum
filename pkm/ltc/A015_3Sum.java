/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rivers
 * @description Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *  For example, given array S = {-1 0 1 2 -1 -4},
 *  
 *     A solution set is:
 *         (-1, 0, 1)
 *         (-1, -1, 2)
 *
 */

//UPDATE20170523:
//	Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//  Find all unique triplets in the array which gives the sum of zero.
//			Note: The solution set must not contain duplicate triplets.
//			For example, given array S = [-1, 0, 1, 2, -1, -4],
//			A solution set is:
//			[
//			  [-1, 0, 1],
//			  [-1, -1, 2]
//			]
//			Subscribe to see which companies asked this question.
//			Hide Tags Array Two Pointers
//			Hide Similar Problems (E) A001_Two Sum (M) A016_3Sum Closest (M) A018_4Sum (M) 3Sum Smaller


public class A015_3Sum {

	/*20170523
	 * 排序，i从0至倒数第3项遍历为第一个数，并从>i的部分找到其和=-num[i]的后两个数
	 * 因为有重复元素，所以不能嵌套A001_TwoSum的方法*/
	public static List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for(int i=0;i<nums.length-2;i++){
			if(i==0 || i>0 && nums[i]!=nums[i-1]){
				int lo=i+1,hi=nums.length-1,sum=-nums[i];
				while(lo<hi){
					if(nums[lo]+nums[hi]==sum){
						res.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
						while(lo<hi && nums[lo]==nums[lo+1])
							lo++;
						lo++;
						while(lo<hi && nums[hi]==nums[hi-1])
							hi--;
						hi--;
					}else if(nums[lo]+nums[hi]>sum){
						while(lo<hi && nums[hi]==nums[hi-1])
							hi--;
						hi--;
					}else{
						while(lo<hi && nums[lo]==nums[lo+1])
							lo++;
						lo++;
					}
				}
			}
		}
		return res;
	}
	
	
/*Old Version:
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		if(nums.length<3) return list1;
		Arrays.sort(nums);
		for(int i=0; i<nums.length-2; i++){ //后面留两位给2sum
			while(i>0 && i<nums.length-1 && nums[i]==nums[i-1])  //从第二个开始往前判断是否相等，若想等则累加
				i++;
			List<List<Integer>> list2 = twoSum(nums, i+1, -nums[i]);
			for(int j=0; j<list2.size(); j++){
				list2.get(j).add(0, nums[i]);
				list1.add(list2.get(j));
			}
			
		}
		return list1;       
    }
	public List<List<Integer>> twoSum(int[] nums, int start, int target){
		if(nums.length<2) return null;
		int i=start, j=nums.length-1;
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		while(i<j){
			while(i>start && i<j && nums[i]==nums[i-1])  //从第二个开始验重，与前一个相等则递增
				i++;
			if(i==j) break;  //若前面i累加到j的位置，直接跳出
			while(j<nums.length-1 && j>i && nums[j]==nums[j+1])  //从倒数第二个开始验重，与后一个相等则递减
				j--;
			if(i==j) break;  //若后面j递减到i的位置，直接跳出  //i与j都要验重，防止{-2,0,0,2,2}的情况发生
			if(nums[i]+nums[j]==target){
				List<Integer> list2 = new ArrayList<Integer>();
				list2.add(nums[i]);
				list2.add(nums[j]);
				list1.add(list2);
				i++;
				j--;
			}else if(nums[i]+nums[j]<target)
				i++;
			else
				j--;
		}
		return list1;
	}
*/
	public static void main(String[] args) {
		A015_3Sum a15 = new A015_3Sum();
		int a[] = {-1, 0, 1, 2, -1, -4};
		//int a[] = {-2,0,1,1,2};
		//List<List<Integer>> list = a15.twoSum(a, 0, 4);
		List<List<Integer>> list = a15.threeSum(a);
		for(List<Integer> x:list){
			for(int y:x)
				System.out.print(y);
			System.out.println();
		}
	}

}
