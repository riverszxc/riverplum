/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: A060_PermutationSequence 
 * @author riverz
 * @date 2017年8月24日 下午9:47:44
 * @Description:The set [1,2,3,…,n] contains a total of n! unique permutations.
By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):
"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
Note: Given n will be between 1 and 9 inclusive.
Related Topics 
Backtracking Math 
Similar Questions 
(M)A031_Next Permutation  (M)A046_Permutations 
 */
public class A060_PermutationSequence {

	/**@date 2017年8月24日 下午9:47:44
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(getPermutation(3,5));

	}
	
	public static String getPermutation(int n, int k) {
		int[] factorial = new int[n];
		factorial[0] = 1;
		for(int i=1;i<n;i++){
			factorial[i] = factorial[i-1]*i;
		}
		
		List<Integer> num = new ArrayList<>();
		for(int i=1;i<=n;i++){
			num.add(i);
		}
		/*
		"123"
		"132"
		"213"
		"231"
		"312"
		"321"
		n=3,3/((n-1)!)=1,4/((n-1)!)=2,本来值应该一样，所以此处取k=k-1,那么2/((n-1)!)=1,3/((n-1)!)=1
		 */
		k--;
		StringBuilder sb = new StringBuilder();
		for(int i=n;i>0;i--){
			System.out.println("k:"+k+",fac:"+factorial[i-1]);
			int current = k/factorial[i-1];
			k = k%factorial[i-1];
			sb.append(String.valueOf(num.get(current)));
			num.remove(current);
		}
		return sb.toString();
    }
	


}
