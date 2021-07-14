/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A516_LongestPalindromicSubsequence 
 * @author rivers
 * @date 2017年6月3日 下午6:32:52
 * @Description:Given a string s, find the longest palindromic subsequence's length in s. 
You may assume that the maximum length of s is 1000.
Example 1:
Input:
"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:
"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
Tags: Dynamic Programming
Similar Problems (M) A214_Longest Palindromic Substring

 */
public class A516_LongestPalindromicSubsequence {

	/**@date 2017年6月3日 下午6:32:52
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq("bbbab"));
//		int[] i = {0,1,2};
//		test(i);
//		System.out.println(i[0]);
	}
//	public static void test(int[] i){
//		i[0]=1;
//	}
	
	/**@date 2017年6月3日 下午6:35:28
	 * @Description: 循环
		dp[i][j]: the longest palindromic subsequence's length of substring(i, j)
		State transition:
		dp[i][j] = dp[i+1][j-1] + 2 if s.charAt(i) == s.charAt(j)
		otherwise, dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1])
		Initialization: dp[i][i] = 1*/
	public static int longestPalindromeSubseq(String s) {
		int[][] dp = new int[s.length()][s.length()];
		for(int i=s.length()-1;i>=0;i--){	//i 头<--尾
			dp[i][i] = 1;
			for(int j=i+1;j<s.length();j++){	//j i-->尾
//				System.out.println("i:"+i+",j:"+j);
				if(s.charAt(i)==s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				}else{
					dp[i][j] = dp[i+1][j]>dp[i][j-1]?dp[i+1][j]:dp[i][j-1];
				}
			}
		}
		/*或  j 头-->尾   i 头-->j
		for(int j=0;j<s.length();j++){
			dp[j][j] = 1;
			for(int i=0;i<j;i++){
				if(s.charAt(i)==s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				}else{
					dp[i][j] = dp[i+1][j]>dp[i][j-1]?dp[i+1][j]:dp[i][j-1];
				}
			}
		}
		*/
		return dp[0][s.length()-1];
    }
	
	/**@date 2017年6月3日 下午7:19:06
	 * @Description: 递归*/
	public static int longestPalindromeSubseq1(String s){
		return longestPalindromeSubseq_recursion(s,0,s.length()-1,new int[s.length()][s.length()]);
	}
	public static int longestPalindromeSubseq_recursion(String s,int lo,int hi,int[][] dp){
		if(lo==hi)
			return 1;
		if(lo>hi)
			return 0;
		if(dp[lo][hi]!=0)
			return dp[lo][hi];
		if(s.charAt(lo)==s.charAt(hi))
			dp[lo][hi] = longestPalindromeSubseq_recursion(s,lo+1,hi-1,dp) + 2;
		else
			dp[lo][hi] = Math.max(longestPalindromeSubseq_recursion(s,lo,hi-1,dp), longestPalindromeSubseq_recursion(s,lo+1,hi,dp));
		return dp[lo][hi];
	}

}
