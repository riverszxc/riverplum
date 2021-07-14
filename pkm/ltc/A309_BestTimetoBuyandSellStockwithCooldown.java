/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A309_BestTimetoBuyandSellStockwithCooldown 
 * @author riverz
 * @date 2017年9月5日 下午4:13:38
 * @Description:Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(ie, buy one and sell one share of the stock multiple times) with the following restrictions:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:
prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]
Related Topics 
Dynamic Programming 
Similar Questions 
(E) A121_Best Time to Buy and Sell Stock   (E) A122_Best Time to Buy and Sell Stock II 
 */
public class A309_BestTimetoBuyandSellStockwithCooldown {

	/**@date 2017年9月5日 下午4:13:38
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{1, 2, 3, 0, 2}));

	}
	
    /**@date 2017年9月5日 下午4:50:32
     * @Description: buy[i],sell[i]当前最高利润*/
    public static int maxProfit(int[] prices) {
    	if(prices.length<2) return 0;
    	int[] buy=new int[prices.length], sell=new int[prices.length];
    	buy[0]=-prices[0];
    	for(int i=1;i<prices.length;i++){
    		buy[i] = Math.max(sell[i>1?(i-2):0]-prices[i], buy[i-1]);
    		sell[i] = Math.max(prices[i]+buy[i-1], sell[i-1]);
    	}
        return sell[prices.length-1];
    }

}
