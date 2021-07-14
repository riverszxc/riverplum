/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A123_BestTimetoBuyandSellStockIII 
 * @author riverz
 * @date 2017年8月28日 下午9:41:45
 * @Description:Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most two transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
Related Topics 
Array Dynamic Programming 
Similar Questions 
(E) A121_Best Time to Buy and Sell Stock  (E) A122_Best Time to Buy and Sell Stock II  (H) A188_Best Time to Buy and Sell Stock IV
 */
public class A123_BestTimetoBuyandSellStockIII {

	/**@date 2017年8月28日 下午9:41:45
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

	}
	
    
    /**@date 2017年8月29日 上午11:26:12
     * @Description: [7, 1, 5, 3, 6, 4]
     * cost支出 profit收入*/
    public static int maxProfit(int[] prices) {
        int cost1=Integer.MAX_VALUE, profit1=0, cost2=Integer.MAX_VALUE, profit2=0;
        for(int p:prices){
        	cost1 = Math.min(cost1, p);
        	profit1 = Math.max(profit1, p-cost1);
        	cost2 = Math.min(cost2, p-profit1);
        	profit2 = Math.max(profit2, p-cost2);
        }
    	return profit2;
    }

}
