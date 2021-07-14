package me.riverz.recursion;

import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		Permutation p = new Permutation();
		int[] array = {1,2,3};
		p.fullPermutation(array, 0, 2);

	}
	/* 全排列
	 * 第一步，同一层级利用for循环依次将当前序列的每一位交换到最前端
	 * 第二步，利用递归依次作用于子问题，递归到最底层则输出
	 * */
	public void fullPermutation(int[] array, int s, int e){
		if(s==e){
			for(int i=0;i<=e;i++){
				System.out.print(array[i]);
			}
			System.out.println();
		}
		else{
			for(int i=s; i<=e; i++){
				swap(array,s,i);
				fullPermutation(array,s+1,e);
				swap(array,s,i);
			}
		}
		
	}
	private void swap(int[] array,int a, int b){
		int t = array[a];
		array[a]= array[b];
		array[b]=t;
	}

}
