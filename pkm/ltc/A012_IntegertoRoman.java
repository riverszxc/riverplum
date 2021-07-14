/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A012_IntegertoRoman 
 * @author riverz
 * @updateDate 2017年6月4日 下午12:44:42
 * @Description:Given an integer, convert it to a roman numeral.
Input is guaranteed to be within the range from 1 to 3999.
Tags: Math, String
Similar Problems (E) A013_Roman to Integer (H) A273_Integer to English Words

 */
public class A012_IntegertoRoman {

	public static void main(String[] args) {
		
		A012_IntegertoRoman a12 = new A012_IntegertoRoman();
		System.out.println(a12.intToRoman(1233));

	}
	
	public String intToRoman(int num) {
		
		String c[][] = {{"0","I","II","III","IV","V","VI","VII","VIII","IX"}
		,{"0","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}
		,{"0","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}
		,{"0","M","MM","MMM"}};
		
		String r = "";
		
		if(num/1000 != 0) r+=c[3][num/1000];
		if((num%1000)/100 != 0) r+=c[2][(num%1000)/100];
		if((num%100)/10 != 0) r+=c[1][(num%100)/10];
		if(num%10 != 0) r+=c[0][num%10];
		
		return r;
        
    }

}
