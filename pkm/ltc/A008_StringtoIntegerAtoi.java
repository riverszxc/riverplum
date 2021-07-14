/**
 * 
 */
package me.riverz.leetcode;


/**
 * @ClassName: A008_StringtoIntegerAtoi 
 * @author riverz
 * @updateDate 2017年6月3日 下午7:40:32
 * @Description:Implement atoi to convert a string to an integer.
Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
spoilers alert... click to show requirements for atoi.
Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
Tags: Math, String
Similar Problems (E) A007_ReverseInteger (H) A065_ValidNumber

 */
public class A008_StringtoIntegerAtoi {

	/**@date 2017年6月3日 下午7:46:47
	 * @Description: */
	public static void main(String[] args) {
		System.out.println(myAtoi("   +"));

	}
	/**@date 2017年6月3日 下午7:48:07
	 * @Description: */
	public static int myAtoi(String str) {
		if(str.equals("")) return 0;
		long sum=0;
		int sig=1;
		char[] c = str.toCharArray();
		int i=0;
		while(c[i]==' ') ++i;
		if(c[i]=='+'){ 
			sig=1;
			++i;
		}
		else if(c[i]=='-'){ 
			sig=-1;
			++i;
		}
		for(; i<c.length; i++){
			if(c[i]>='0' && c[i]<='9'){
				sum = sum*10 + (c[i]-'0'); //既然可以与'0''9'比大小，那么就可以利用c[i]-'0'直接将字符转换为数字
			}else
				break;//题目要求不符合格式直接返回0
			if(sum*sig>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if(sum*sig<Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		sum*=sig;
		return (int)sum;
    }
	
	/*Old Version*/
	public static int myAtoi1(String str) {
		long sum=0;
		int sig=1;
		char[] c = str.toCharArray();
		int i=0;
		
		if(str.equals("")) return 0;
		
		while(c[i]==' ') ++i;
		if(c[i]=='+'){ 
			sig=1;
			++i;
		}
		else if(c[i]=='-'){ 
			sig=-1;
			++i;
		}
		for(; i<c.length; i++){
			if(c[i]>='0' && c[i]<='9'){
				switch(c[i]){
				case '0':
					sum = sum*10 + 0;
					break;
				case '1':
					sum = sum*10 + 1;
					break;
				case '2':
					sum = sum*10 + 2;
					break;
				case '3':
					sum = sum*10 + 3;
					break;
				case '4':
					sum = sum*10 + 4;
					break;
				case '5':
					sum = sum*10 + 5;
					break;
				case '6':
					sum = sum*10 + 6;
					break;
				case '7':
					sum = sum*10 + 7;
					break;
				case '8':
					sum = sum*10 + 8;
					break;
				case '9':
					sum = sum*10 + 9;
					break;
				}
			}else
				break;
			if(sum*sig>Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if(sum*sig<Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
		}
		sum*=sig;
		
		return (int)sum;
        
    }
	
}
