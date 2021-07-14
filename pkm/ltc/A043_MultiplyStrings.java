/**
 * 
 */
package me.riverz.leetcode;

/**
 * @author riverz
 * @description Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note:
 * The numbers can be arbitrarily large and are non-negative.
 * Converting the input string to integer is NOT allowed.
 * You should NOT use internal library such as BigInteger.
 */

/*UPDATE:20170523
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
Note:
The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
Subscribe to see which companies asked this question.
Tags: Math, String
Similar Problems: (M) A002_Add Two Numbers (E) A066_Plus One (E) A067_Add Binary (E) A415_Add Strings
*/
public class A043_MultiplyStrings {

	/**
	 @date 2017年5月25日 上午10:53:42
	*/
	public String multiply(String num1,String num2){
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		int a = num1.length();
		int b = num2.length();
		int carry = 0;
		char[] res = new char[a+b];
		for(int i=0;i<a+b;i++)
			res[i]='0';
		for(int j=b-1; j>=0; j--){
			carry = 0;
			for(int i=a-1; i>=0; i--){
				int x = (num2.charAt(j)-'0') * (num1.charAt(i)-'0') + (res[i+j+1]-'0') + carry;//利用-'0'将char转为数字
				res[i+j+1] = (char) (x%10 + '0');//利用+'0'将数字转为char
				carry = x/10;
			}
			res[j] = (char) (carry+'0');//设置每一轮的最高进位
		}
		if(res[0]=='0') return new String(res).substring(1);//没有最高进位则截掉
        return new String(res);
	}
	
/*Old Version:
	public String multiply(String num1, String num2) {
		if(num1.equals("0") || num2.equals("0"))
			return "0";
		int a = num1.length();
		int b = num2.length();
		int carry = 0;
		char[] res = new char[a+b];
		for(int i=0;i<a+b;i++)
			res[i]='0';
		for(int j=b-1; j>=0; j--){
			carry = 0;
			for(int i=a-1; i>=0; i--){
				int x = (num2.charAt(j)-'0') * (num1.charAt(i)-'0') + (res[i+j+1]-'0') + carry;
				res[i+j+1] = (char) (x%10 + '0');
				carry = x/10;
			}
			res[j] = (char) (carry+'0');
			if(j==0)
				res[0] = (char) (carry+'0');
		}
		if(res[0]=='0') return new String(res).substring(1);
        return new String(res);
    }
*/
	public static void main(String[] args) {
		A043_MultiplyStrings a43 = new A043_MultiplyStrings();
		System.out.println(a43.multiply("99", "20"));
	}

}