/**
 * 
 */
package me.riverz.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: A013_RomantoInteger 
 * @author riverz
 * @updateDate 2017年6月4日 下午12:15:06
 * @Description:Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.
Tags： Math， String
Similar Problems (M) A012_Integer to Roman
 */
public class A013_RomantoInteger {

	public static void main(String[] args) {
		
		A013_RomantoInteger a13 = new A013_RomantoInteger();
		System.out.println(a13.romanToInt("MCMXCVI"));
	}
	
	/**@date 2017年6月4日 下午12:29:30
	 * @Description: 从倒数第二位像首位遍历，若当前位>=后一位，则加，否则减*/
	public int romanToInt(String s){
		Map<Character,Integer> m = new HashMap<>();
		m.put('I', 1);
		m.put('V', 5);
		m.put('X', 10);
		m.put('L', 50);
		m.put('C', 100);
		m.put('D', 500);
		m.put('M', 1000);
		int res = 0;
		for(int i=0;i<s.length()-1;i++){
			System.out.println(i);
			if(m.get(s.charAt(i))>=m.get(s.charAt(i+1)))
				res+=m.get(s.charAt(i));
			else
				res-=m.get(s.charAt(i));
		}
		return res+m.get(s.charAt(s.length()-1));
	}
	
	/*Old Version:*/
	public int romanToInt1(String s) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int last = map.get(s.charAt(s.length()-1));
		int result = last;
		for(int i=s.length()-1; i>0; i--){
			if(map.get(s.charAt(i-1)) >= map.get(s.charAt(i))){
				result += map.get(s.charAt(i-1));
			} else{
				result -= map.get(s.charAt(i-1));
			}
		}
		
		return result;
        
    }
}
