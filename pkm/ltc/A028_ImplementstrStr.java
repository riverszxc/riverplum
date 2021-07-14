/**
 * 
 */
package me.riverz.leetcode;

/**
 * @author rivers
 * @description Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 */
/**
 * @ClassName: A028_ImplementstrStr 
 * @author riverz
 * @updateDate 2017年6月12日 上午9:17:57
 * @Description:Implement strStr().
Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
Tags: Two Pointers, String
Similar Problems (H) A214_Shortest Palindrome (E) A459_Repeated Substring Pattern

 */
public class A028_ImplementstrStr {
	
	public static void main(String[] args){
		A028_ImplementstrStr a28 = new A028_ImplementstrStr();
		System.out.println(a28.strStr("dvaaac", "aac"));
	}
	
	public int strStr(String haystack, String needle) {
		for(int i=0;;i++)
			for(int j=0;;j++){
				if(j==needle.length())
					return i;
				if(i+j==haystack.length())
					return -1;
				if(haystack.charAt(i+j)!=needle.charAt(j))
					break;
			}
    }
	


}
