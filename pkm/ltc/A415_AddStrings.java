/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A415_AddStrings 
 * @author riverz
 * @date 2017年5月26日 下午12:49:08
 * @Description:Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Tags: Math
 * Similar Problems (M) A002_Add Two Numbers (M) A043_Multiply Strings
 */
public class A415_AddStrings {

	/**@date 2017年5月26日 下午12:49:08*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A415_AddStrings a415 = new A415_AddStrings();
		System.out.println(a415.addStrings("111", "221"));
	}
	
	/**@date 2017年5月26日 下午2:22:33*/
	public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int ai=num1.length()-1,bi=num2.length()-1,carry=0;
        while(ai>=0 || bi>=0 || carry!=0){
        	int sum = (ai>=0?(num1.charAt(ai)-'0'):0) + (bi>=0?(num2.charAt(bi)-'0'):0) + carry; 
        	sb.append(sum%10);
        	carry = sum/10;
        	ai--;
        	bi--;
        }
		return new String(sb.reverse());
    }

}
