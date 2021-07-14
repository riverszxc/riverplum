/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A031_NextPermutation 
 * @author riverz
 * @date 2017年8月24日 下午9:45:01
 * @Description:Implement next permutation, 
 * which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
Related Topics 
Array 
Similar Questions 
(M)A046_Permutations (M)A047_Permutations II (M)A060_Permutation Sequence  (M)Palindrome Permutation II 
 */
public class A031_NextPermutation {
	
	public static void main(String[] args) {
		A031_NextPermutation a31 = new A031_NextPermutation();
		int[] nums = {1,2,2,4,3};
		a31.nextPermutation(nums);
		for(int x : nums)
			System.out.print(x);

	}
	
	/**@date 2017年8月24日 下午9:38:51
	 * @Description:如125432， 
	 * 1.从右到左找到最靠右的升序对25，即逆转位pos1=1的元素2
	 * 2.从右到左找到第一个比逆转位大的数pos2=4的元素3
	 * 3.交换pos12(135422)，逆转pos1后的部分(132245)*/
	public void nextPermutation(int[] nums) {
        int pos=-1;
        for(int i=nums.length-1;i>0;i--){
        	if(nums[i]>nums[i-1]){
        		pos=i-1;
        		break;
        	}
        }
        if(pos<0)
        	reverse(nums,0,nums.length-1);
        else{
        	int rev=0;
            for(int i=nums.length-1;i>pos;i--){//125431
            	if(nums[i]>nums[pos]){
            		rev = i;
            		break;
            	}
            }
            int t = nums[rev];
            nums[rev] = nums[pos];
            nums[pos] = t;
            reverse(nums, pos+1, nums.length-1);
        }
        	
    }
	
	public void reverse(int[] nums, int s, int e){
		int t=0;
		while(s<e){
			t = nums[s];
			nums[s] = nums[e];
			nums[e] = t;
			s++;
			e--;
		}
	}



}
