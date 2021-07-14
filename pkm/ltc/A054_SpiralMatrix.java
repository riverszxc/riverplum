/**
 * 
 */
package me.riverz.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: A054_SpiralMatrix 
 * @author riverz
 * @date 2017年9月12日 下午12:53:25
 * @Description:Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
For example,
Given the following matrix:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
Related Topics 
Array 
Similar Questions 
(M) A059_Spiral Matrix II 
 */
public class A054_SpiralMatrix {

	/**@date 2017年9月12日 下午12:53:26
	 * @Description: */
	public static void main(String[] args) {
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] matrix = {{1,2,3}};
		List<Integer> res = spiralOrder(matrix);
		System.out.println(res);

	}
	
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList<>();
    	int m=matrix.length;
    	if(m==0) return res;
    	int n=matrix[0].length;
		int u=0,r=n-1,d=m-1,l=0;
		
		while(u<=d&&l<=r){
			for(int i=l;i<=r;i++)
				res.add(matrix[u][i]);
			u++;
			for(int i=u;i<=d;i++)
				res.add(matrix[i][r]);
			r--;
			for(int i=r;i>=l&&u<=d;i--)//预防单行
				res.add(matrix[d][i]);
			d--;
			for(int i=d;i>=u&&l<=r;i--)//预防单列
				res.add(matrix[i][l]);
			l++;
		}
    	return res;
    }

}
