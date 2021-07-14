/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A152_MaximumProductSubarray 
 * @author riverz
 * @date 2017年8月27日 下午8:44:11
 * @Description:Find the contiguous subarray within an array (containing at least one number) which has the largest product.
For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
Related Topics 
Array Dynamic Programming 
Similar Questions 
(E) A053_Maximum Subarray  (E) A198_House Robber  (M) A238_Product of Array Except Self  (E) A628_Maximum Product of Three Numbers 
 */
public class A152_MaximumProductSubarray {

	/**@date 2017年8月27日 下午8:44:11
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{-4,-3,-2}));

	}
	
    /**@date 2017年8月27日 下午9:18:39
     * @Description: 每一轮前一个最大最小值与当前值相乘记录当前最大最小值，为防止0值，也要与当前值比较*/
    public static int maxProduct(int[] nums) {
    	int maxprod=nums[0], minprod=nums[0], max=nums[0];
    	for(int i=1;i<nums.length;i++){
    		int temp=maxprod;
    		maxprod = Math.max(Math.max(maxprod*nums[i], minprod*nums[i]),nums[i]);
    		minprod = Math.min(Math.min(temp*nums[i], minprod*nums[i]),nums[i]);
    		max = Math.max(max, Math.max(maxprod, minprod));
    	}
        return max;
    }

}
