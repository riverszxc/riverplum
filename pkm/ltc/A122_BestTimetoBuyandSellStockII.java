/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A122_BestTimetoBuyandSellStockII 
 * @author riverz
 * @date 2017年8月27日 下午9:25:49
 * @Description:Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). 
However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
Related Topics 
Array Greedy 
Similar Questions 
(E) A121_Best Time to Buy and Sell Stock  (H) A123_Best Time to Buy and Sell Stock III  (H) A188_Best Time to Buy and Sell Stock IV  (M) A309_Best Time to Buy and Sell Stock with Cooldown
 */
public class A122_BestTimetoBuyandSellStockII {

	/**@date 2017年8月27日 下午9:25:49
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

	}
	
    public static int maxProfit(int[] prices) {
    	if(prices.length<2) return 0;
        int sum=0;
        for(int i=1;i<prices.length;i++){
        	sum += Math.max(0, prices[i]-prices[i-1]);
        }
    	return sum;
    }

}
