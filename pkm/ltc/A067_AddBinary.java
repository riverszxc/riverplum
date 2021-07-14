/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A67_AddBinary 
 * @author riverz
 * @date 2017年5月25日 上午10:54:52
 * @Description:Given two binary strings, return their sum (also a binary string).
 	* For example,
 	* a = "11"
 	* b = "1"
 	* Return "100".
 	* Tags: Math, String
 	* Similar Problems: (M) A002_Add Two Numbers (M) A043_Multiply Strings (E) A066_Plus One		
 */
public class A067_AddBinary {

	/**@date 2017年5月25日 上午10:54:52*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A067_AddBinary a67 = new A067_AddBinary();
		System.out.println(a67.addBinary("111", "111"));

	}
	

	/**@date 2017年5月25日 上午10:57:20*/
	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int ai=a.length()-1,bi=b.length()-1,carry=0;
		while(ai>=0 || bi>=0 || carry>0){
			int sum = (ai>=0?(a.charAt(ai)-'0'):0) + (bi>=0?(b.charAt(bi)-'0'):0) + carry;
			ai--;
			bi--;
			sb.append(sum%2);
			carry = sum/2;	
		}
        return new String(sb.reverse());
    }

}
