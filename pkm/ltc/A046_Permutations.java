/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: A046_Permutations 
 * @author riverz
 * @updateDate 2017年8月24日 下午9:12:35
 * @Description:
Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
Related Topics 
Backtracking 
Similar Questions 
(M)A031_Next Permutation (M)A047_Permutations II (M)A060_Permutation Sequence (M)A077_Combinations 
 */
public class A046_Permutations {

	public static void main(String[] args) {
		A046_Permutations a46 = new A046_Permutations();
		int[] nums = {1,2,3};
		List<List<Integer>> ress = a46.permute(nums);
		for(List<Integer> x : ress){
			for(int y : x)
				System.out.print(y);
			System.out.println();
		}
	}

    /**@date 2017年8月24日 下午9:18:34
     * @Description: */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ress = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums,ress,res,used);
        return ress;
    }
    
    /**@date 2017年8月24日 下午9:25:40
     * @Description: */
    private void dfs(int[] nums, List<List<Integer>> ress, List<Integer> res, boolean[] used){
    	if(res.size()==nums.length){
    		ress.add(new ArrayList<Integer>(res));
    		return;
    	}
    	//每递归一次，都是从首位开始遍历
    	for(int i=0;i<nums.length;i++){
    		if(!used[i]){
    			used[i]=true;
    			res.add(nums[i]);
    			dfs(nums,ress,res,used);
    			res.remove(res.size()-1);
    			used[i]=false;
    		}
    	}
    }




}
