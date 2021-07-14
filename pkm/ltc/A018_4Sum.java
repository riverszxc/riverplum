/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author riverz
 * @description Given an array S of n integers, are there elements a, b, c, 
 * and d in S such that a + b + c + d = target? Find all unique quadruplets in the array 
 * which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *     
 *         A solution set is:
 *             (-1,  0, 0, 1)
 *             (-2, -1, 1, 2)
 *             (-2,  0, 0, 2)

 * @ClassName: A018_4Sum 
 * @author river
 * @updateDate 2017年6月4日 下午2:44:27
 * @Description:Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.
Note: The solution set must not contain duplicate quadruplets.
For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
Tags: Array, Hash Table, Two Pointers
Similar Problems (E) A001_Two Sum (M) A015_3Sum (M) A454_4Sum II
 */
public class A018_4Sum {
	
	public static void main(String[] args) {
		A018_4Sum a018 = new A018_4Sum();
		int a[] = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> list = a018.fourSum(a, 0);
		for(List<Integer> l:list){
			for(int x:l)
				System.out.print(x);
			System.out.println();
		}
	}

	public List<List<Integer>> fourSum(int[] nums, int target){
		List<List<Integer>> ress = new ArrayList<>();
		if(nums.length<4) return ress;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-3;i++){//剩3个给3sum
			if(i==0 || nums[i]!=nums[i-1]){
				List<List<Integer>> res = threeSum_new(nums, i+1, target-nums[i]);
				for(List<Integer> re:res){
					//利用asList生成的List不能进行add，remove等操作,所以转换成ArrayList
					List<Integer> r = new ArrayList<>(re);
					r.add(0, nums[i]);
					ress.add(r);
				}
			}
		}
		return ress;
	}
	public static List<List<Integer>> threeSum_new(int[] nums,int start,int target){
		//Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for(int i=start;i<nums.length-2;i++){//i从start开始
			if(i==start || nums[i]!=nums[i-1]){
				int lo=i+1,hi=nums.length-1,sum=target-nums[i];
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
	
	/*Old Version:*/
	public List<List<Integer>> fourSum1(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(nums.length<4) return list;
		Arrays.sort(nums);
		for(int i=0; i<nums.length-3; i++){ //后面留两位给2sum
			while(i>0 && i<nums.length-1 && nums[i]==nums[i-1])  //从第二个开始往前判断是否相等，若相等则累加
				i++;
			List<List<Integer>> list1 = threeSum(nums, i+1, target-nums[i]);
			for(int j=0; j<list1.size(); j++){
				list1.get(j).add(0, nums[i]);
				list.add(list1.get(j));
			}
			
		}
		return list; 
        
    }
	
	public List<List<Integer>> threeSum(int[] nums, int start, int target) {
		if(nums.length<3) return null;
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		for(int i=start; i<nums.length-2; i++){ //后面留两位给2sum
			while(i>start && i<nums.length-1 && nums[i]==nums[i-1])  //从第二个开始往前判断是否相等，若想等则累加
				i++;
			List<List<Integer>> list2 = twoSum(nums, i+1, target-nums[i]);
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
//				list1.add(Arrays.asList(nums[i],nums[j])); 利用asList生成的List不能进行add，remove等操作
				i++;
				j--;
			}else if(nums[i]+nums[j]<target)
				i++;
			else
				j--;
		}
		return list1;
	}
	
	

}
