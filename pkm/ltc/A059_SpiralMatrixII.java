/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A059_SpiralMatrixII 
 * @author riverz
 * @date 2017年9月12日 下午1:49:26
 * @Description:Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
For example,
Given n = 3,
You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
Related Topics 
Array 
Similar Questions 
(M) A054_Spiral Matrix 
 */
public class A059_SpiralMatrixII {

	/**@date 2017年9月12日 下午1:49:26
	 * @Description: */
	public static void main(String[] args) {
		int[][] res = generateMatrix(4);
		for(int[] r:res){
			for(int x:r)
				System.out.print(x);
			System.out.println();
		}
	}
	
	/**@date 2017年9月12日 下午2:03:05
	 * @Description: */
	public static int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		
		int u=0,r=n-1,d=n-1,l=0,k=1;
		
		while(u<=d&&l<=r){
			for(int i=l;i<=r;i++){
				res[u][i]=k++;
			}
			u++;
			for(int i=u;i<=d;i++)
				res[i][r]=k++;
			r--;
			for(int i=r;i>=l&&u<=d;i--)//预防单行
				res[d][i]=k++;
			d--;
			for(int i=d;i>=u&&l<=r;i--)//预防单列
				res[i][l]=k++;
			l++;
		}
        return res;
    }

}
