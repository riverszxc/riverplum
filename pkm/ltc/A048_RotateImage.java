/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A048_RotateImage 
 * @author riverz
 * @updateDate 2017年8月27日 上午11:34:38
 * @Description:You are given an n x n 2D matrix representing an image.
Rotate the image by 90 degrees (clockwise).
Note:
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
DO NOT allocate another 2D matrix and do the rotation.
Example 1:
Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
Example 2:
Given input matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
], 
rotate the input matrix in-place such that it becomes:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]
Related Topics :
Array 
 */
public class A048_RotateImage {

	public void rotate(int[][] matrix) {
        int tmp = 0;
        for(int i=0; i<matrix.length; i++){
        	for(int j=i+1; j<matrix.length; j++){
        		tmp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = tmp;
        	}
        }
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix.length/2; j++){
        		tmp = matrix[i][j];
        		matrix[i][j] = matrix[i][matrix.length-j-1];
        		matrix[i][matrix.length-j-1] = tmp;
        	}
        }
    }
	
	public static void main(String[] args) {
		A048_RotateImage a48 = new A048_RotateImage();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		a48.rotate(matrix);
		System.out.println(13);
	}

}
