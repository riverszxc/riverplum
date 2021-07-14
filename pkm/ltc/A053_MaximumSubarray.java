/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A053_MaximumSubarray 
 * @author rivers
 * @date 2017年8月27日 下午1:17:48
 * @Description:Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
Related Topics 
Array, Dynamic Programming, Divide and Conquer 
Similar Questions 
(E)A121_Best Time to Buy and Sell Stock  (M)A152_Maximum Product Subarray 
 */
public class A053_MaximumSubarray {

	/**@date 2017年8月27日 下午1:17:48
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

	}
	
	/**@date 2017年8月27日 下午4:57:02
	 * @Description: 动态规划：dp[i]=dp[i-1]>0?(dp[i-1]+nums[i]):nums[i]
	 * 每次只用到前一个数，所以可以用一个参数代替dp*/
	public static int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for(int i=1;i<nums.length;i++){
			dp[i] = dp[i-1]>0?(dp[i-1]+nums[i]):nums[i];
			max = dp[i]>max?dp[i]:max;
		}
		return max;
    }

}
