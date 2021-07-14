/**
 * 
 */
package me.riverz.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: A336_PalindromePairs 
 * @author rivers
 * @date 2017年6月1日 下午7:05:03
 * @Description:Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, 
		so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
		Example 1:
		Given words = ["bat", "tab", "cat"]
		Return [[0, 1], [1, 0]]
		The palindromes are ["battab", "tabbat"]
		Example 2:
		Given words = ["abcd", "dcba", "lls", "s", "sssll"]
		Return [[0, 1], [1, 0], [3, 2], [2, 4]]
		The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
		Tags: Hash Table, String, Trie
		Similar Problems (M) A005_Longest Palindromic Substring (H) A214_Shortest Palindrome
 */
public class A336_PalindromePairs {

	/**@date 2017年6月1日 下午7:05:03
	 * @Description: */
	public static void main(String[] args) {
		A336_PalindromePairs a336 = new A336_PalindromePairs();
		String[] words = {"a",""};
		List<List<Integer>> ress = a336.palindromePairs(words);
		System.out.println(ress.size());
	}
	
	/**@date 2017年6月1日 下午8:24:42
	 * @Description: Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.
					 Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
					 Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] , then s2+s1 is palindrome.
					 Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut] , then s1+s2 is palindrome.*/
	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ress = new ArrayList<>();
		if(words.length<2)
			return ress;
		Map<String,Integer> m = new HashMap<>();
		for(int i=0;i<words.length;i++)
			m.put(words[i], i);
		for(int i=0;i<words.length;i++){
			for(int j=0;j<=words[i].length();j++){ //j<=words[i].length(),应对words = {"a",""}的情况
				String s1 = words[i].substring(0, j);
				String s2 = words[i].substring(j);
				if(isPalindrome(s1)){
					String s2rvs = new StringBuilder(s2).reverse().toString();
					if(m.containsKey(s2rvs) && m.get(s2rvs)!=i)
						ress.add(Arrays.asList(m.get(s2rvs),i));
				}
				if(s2.length()!=0 && isPalindrome(s2)){
					String s1rvs = new StringBuilder(s1).reverse().toString();
					if(m.containsKey(s1rvs) && m.get(s1rvs)!=i)
						ress.add(Arrays.asList(i,m.get(s1rvs)));
				}
			}
		}
		
		return ress;
    }
	/**@date 2017年6月1日 下午8:24:46
	 * @Description: */
	public static boolean isPalindrome(String s){
		int lo=0,hi=s.length()-1;
		while(lo<hi){
			if(s.charAt(lo)!=s.charAt(hi))
				return false;
			lo++;
			hi--;
		}
		return true;
	}

}
