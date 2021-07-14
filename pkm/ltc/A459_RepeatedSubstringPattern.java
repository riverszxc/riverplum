/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A459_RepeatedSubstringPattern 
 * @author riverz
 * @date 2017年6月12日 上午9:58:48
 * @Description:Given a non-empty string check if it can be constructed by taking a substring of it and 
appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"
Output: False
Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
Tags： String
Similar Problems (E) A028_Implement strStr()

 */
public class A459_RepeatedSubstringPattern {

	/**@date 2017年6月12日 上午9:58:48
	 * @Description: */
	public static void main(String[] args) {
		String s = "abcabcabcabc";
		System.out.println(repeatedSubstringPattern(s));
	}
	
	/**@date 2017年6月12日 上午10:01:13
	 * @Description: 用KMP求的最长前缀，若剩余部分的长度的倍数恰好等于总长度，说明字符串就由该部分循环构成*/
	public static boolean repeatedSubstringPattern(String s) {
		int[] next = KMP(s);
		int maxprelen = next[next.length-1];
		return (maxprelen>0)&&(s.length()%(s.length()-maxprelen)==0);
    }
	/**@date 2017年6月12日 上午10:40:42
	 * @Description: KMP, 长度s.length+1*/
	public static int[] KMP(String s){
		int[] next = new int[s.length()+1];
		for(int i=1;i<s.length();i++){
			int index = next[i];
			while(index>0 && s.charAt(index)!=s.charAt(i))
				index = next[index];
			if(s.charAt(index)==s.charAt(i))
				next[i+1] = index+1;
		}
		return next;
	}

}
