package me.riverz.leetcode;

//UPDATE20170411:
//Given an array of integers that is already sorted in ascending order, 
//find two numbers such that they add up to a specific target number.
//The function twoSum should return indices of the two numbers such that they add up to the target, 
//where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
//You may assume that each input would have exactly one solution and you may not use the same element twice.
//Input: numbers={2, 7, 11, 15}, target=9
//Output: index1=1, index2=2
//Tags: Array, Two Pointers, Binary Search
//Similar Problems: (E) A001_Two Sum


public class A167_TwoSumIIInputArrayisSorted {

	public static int[] twoSum(int[] numbers, int target) {
        int start = 0, end = numbers.length-1;
        while(start < end){
        	long sum = numbers[start] + numbers[end];
        	if(sum == target)
        		break;
        	else if(sum < target)
        		start++;
        	else{
        		end--;
        	}
        }
        return new int[]{start+1,end+1};
    }
	
	public static void main(String[] args) {
		int[] res = twoSum(new int[]{2, 7, 11, 15}, 9);
		System.out.println(res[0]+","+res[1]);
	}

}
