/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author rivers
 * @description 
 */
/**
 * @ClassName: A047_PermutationsII 
 * @author rivers
 * @date 2017年8月24日 下午9:49:18
 * @Description:Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
Related Topics 
Backtracking 
Similar Questions 
(M)A031_Next Permutation (M)A046_Permutations   (M)Palindrome Permutation II 
 */
public class A047_PermutationsII {
	
	public static void main(String[] args) {
		A047_PermutationsII a47 = new A047_PermutationsII();
		int[] nums = {1,1,3};
		List<List<Integer>> ress = a47.permuteUnique(nums);
		System.out.println(ress);
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ress = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums); 
        dfs(nums,ress,res,used);
        return ress;
    }
	
	/**@date 2017年8月24日 下午9:59:16
	 * @Description: 因为数组已经过排序，如（1，1，3），
	 * 为避免重复，当取第二个1时，若此时是第一层递归的第二轮循环，则不使用第二个1
	 * 因为，在第一层递归第一轮循环使用第一个1时的下一层递归会使用第二个1*/
	private void dfs(int[] nums, List<List<Integer>> ress, List<Integer> res, boolean[] used){
    	if(res.size() == nums.length){
    		ress.add(new ArrayList<Integer>(res));
    		return;
    	}
    	for(int i=0; i<nums.length; i++){
    		if(i>0 && !used[i-1] && nums[i]==nums[i-1]) 
    			continue;
    		if(!used[i]){
    			used[i] = true;
    			res.add(nums[i]);
    			dfs(nums, ress, res, used);
    			res.remove(res.size()-1);
    			used[i] = false;
    		}
    	}
    }
	


}
