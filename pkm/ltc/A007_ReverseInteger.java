/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A007_ReverseInteger 
 * @author riverz
 * @updateDate 2017年6月3日 下午8:04:56
 * @Description:Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321
click to show spoilers.
Have you thought about this?
Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
then the reverse of 1000000003 overflows. How should you handle such cases?
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
Tags: Math
Similar Problems (M) A008_String to Integer (atoi)
 */
public class A007_ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverse(-12313)); //-2147483648  2147483647
	}
	
	/**@date 2017年6月3日 下午8:22:02
	 * @Description: */
	public static int reverse(int x) {
        int sum=0;
        while(x!=0){
        	int temp = sum*10 + x%10;
        	if(temp/10!=sum)//若越界，则temp/10一定不等于sum
        		return 0;
        	sum=temp;
        	x/=10;
        }
        return sum;
    }

	/*Old Version*/
    public static int reverse1(int x) {
        //int sum = 0;
    	long sum = 0;
		while(x!=0){
			int temp=x%10;
//			int a = sum*10+temp;
//			if((a>Integer.MAX_VALUE/10 || a<Integer.MIN_VALUE/10)&&x/10!=0)
//				return 0;
//			else
//				sum = sum*10+temp;
			sum = sum*10+temp;
			if(sum>Integer.MAX_VALUE || sum<Integer.MIN_VALUE)
				return 0;
			
			x=x/10;
		}
		return (int)sum;
    }

}

