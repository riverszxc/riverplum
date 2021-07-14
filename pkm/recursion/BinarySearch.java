package me.riverz.recursion;

import com.riverszhao.datastructure.Sort;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] l = {3,2,1,1,4};
		for(int x:l)
			System.out.print(x);
		Sort.bubbleSort(l);
		System.out.println();
		for(int x:l)
			System.out.print(x);
		System.out.println();
		System.out.println(binarySearch(l,1));
	}
	
	public static int binarySearch(int[] array, int key){
		return bs(array,0,array.length,key);
	}
	
	private static int bs(int[] array, int start,int size, int key){
		int mid = start+size/2;
		if(key==array[mid])
			return mid;
		else if(size==1)
			return -1;
		else{
			if(key<array[mid])
				return bs(array, start, mid-start, key);
			else
				return bs(array, mid+1, size+start-mid-1, key);
		}
	}
	
	 

}
