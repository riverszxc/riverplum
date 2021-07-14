/**
 * 
 */
package me.riverz.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @ClassName: A020_ValidParentheses 
 * @author riverz
 * @updateDate 2017年6月4日 下午3:38:39
 * @Description:Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
Tags： Stack， String
Similar Problems (M) A022_Generate Parentheses (H) A032_Longest Valid Parentheses (H) A301_Remove Invalid Parentheses

 */
public class A020_ValidParentheses {
	
	public static void main(String[] args) {
		A020_ValidParentheses a020 = new A020_ValidParentheses();
		System.out.println(a020.isValid("([)]"));

	}
	
	/**@date 2017年6月4日 下午4:47:21
	 * @Description: 遍历，前括号都进栈，遇到与栈顶配对的后括号则出栈，最后栈为空则true*/
	public boolean isValid(String s){
		Map<Character, Character> m = new HashMap<>();
		m.put('(', ')');
		m.put('[', ']');
		m.put('{', '}');
		Stack<Character> st = new Stack<>();//只进栈前括号
		for(int i=0;i<s.length();i++){
			if(!st.isEmpty() && s.charAt(i)==m.get(st.peek())){//配对，前括号出栈
				st.pop();
			}else if(m.containsKey(s.charAt(i)))//前括号进栈
				st.push(s.charAt(i));
			else//既没有配对也不是前括号直接false
				return false;
		}
		return st.isEmpty();
	}
	
	
	/*Old Version:*/
	public boolean isValid_old(String s) {
		char[] c = s.toCharArray();
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<c.length; i++){
			if(stack.isEmpty() || !map.get(stack.peek()).equals(c[i])){
				if(!map.containsKey(c[i])) // 后半括号只要进栈就不可能出去，故直接return false
					return false;
				stack.push(c[i]);
			} else{
				stack.pop();
			}				
		}
		if(stack.isEmpty())
			return true;		
		return false;
        
    }
	
	

}
