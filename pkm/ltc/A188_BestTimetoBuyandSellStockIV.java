/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A188_BestTimetoBuyandSellStockIV 
 * @author riverz
 * @date 2017年8月29日 上午11:28:18
 * @Description:Say you have an array for which the ith element is the price of a given stock on day i.
Design an algorithm to find the maximum profit. You may complete at most k transactions.
Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
Credits:
Special thanks to @Freezen for adding this problem and creating all test cases.
Related Topics 
Dynamic Programming 
Similar Questions 
(E) A121_Best Time to Buy and Sell Stock  (E) A122_Best Time to Buy and Sell Stock II  (H) A123_Best Time to Buy and Sell Stock III
 */
public class A188_BestTimetoBuyandSellStockIV {

	/**@date 2017年8月29日 上午11:28:18
	 * @Description: */
	public static void main(String[] args) {
//		System.out.println(maxProfit(1,new int[]{3,4,5,6,0,3,1,4}));
		System.out.println(maxProfit(2,new int[]{1,8,5,4,3}));

	}


    
    /**@date 2017年8月29日 下午4:18:08
     * @Description: 若k>prices.length/2相当于可进行无限次交易获取最大利益，直接获取最大差值即可
     * profit[k][i]第k次交易第i天的最大利润，该日无交易，profit[k][i]=profit[k][i-1]，该日卖出，则profit[k][i]=prices[i]-cost
     * cost负债，该日不买入cost=cost，该日买入，cost=prices[i]-profit[k-1][i-1]*/
    public static int maxProfit(int k, int[] prices){
    	if(k<1||prices.length<2) return 0;
    	
    	if(k>prices.length/2){
    		int sum=0;
    		for(int i=1;i<prices.length;i++){
    			sum += Math.max(0, prices[i]-prices[i-1]);
    		}
    		return sum;
    	}
    	
    	int[][] profit = new int[k+1][prices.length];
    	for(int kk=1;kk<=k;kk++){
    		int cost = prices[0];
    		for(int i=1;i<prices.length;i++){
    			profit[kk][i] = Math.max(profit[kk][i-1], prices[i]-cost);
    			cost = Math.min(cost, prices[i]-profit[kk-1][i-1]);
    		}
    	}
    	return profit[k][prices.length-1];
    }

}
