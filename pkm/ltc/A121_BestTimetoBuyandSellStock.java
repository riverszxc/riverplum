/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A121_BestTimetoBuyandSellStock 
 * @author riverz
 * @date 2017年8月27日 下午5:20:18
 * @Description:Say you have an array for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), 
design an algorithm to find the maximum profit.
Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5
max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0
In this case, no transaction is done, i.e. max profit = 0.
Related Topics 
Array, Dynamic Programming 
Similar Questions 
(E) A053_Maximum Subarray  (E) A122_Best Time to Buy and Sell Stock II  (H) A123_Best Time to Buy and Sell Stock III  (H) A188_Best Time to Buy and Sell Stock IV  (M) A309_Best Time to Buy and Sell Stock with Cooldown 
 */
public class A121_BestTimetoBuyandSellStock {

	/**@date 2017年8月27日 下午5:20:18
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

	}
	
	/**@date 2017年8月27日 下午6:29:22
	 * @Description: dp[i]=(prices[i]-prices[i-1]+dp[i-1])>0?(prices[i]-prices[i-1]+dp[i-1]):0  
	 * 因为每次只用到dp[i-1]所以可以不需要dp[]，只需要一个参数记录上一个最大值即可
	 * */
	public static int maxProfit(int[] prices) {
        int diff=0, maxdiff=0;
        for(int i=1;i<prices.length;i++){
        	diff = (prices[i]-prices[i-1]+diff)>0?(prices[i]-prices[i-1]+diff):0;
        	maxdiff = Math.max(maxdiff, diff);
        }
		return maxdiff;
    }

}
