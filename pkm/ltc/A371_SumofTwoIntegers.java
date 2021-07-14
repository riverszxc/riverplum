/**
 * 
 */
package me.riverz.leetcode;

/**
 * @ClassName: A371_SumofTwoIntegers 
 * @author rivers
 * @date 2017年5月25日 下午8:17:40
 * @Description: Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 * Credits:
 * Special thanks to @fujiaozhu for adding this problem and creating all test cases.
 * Tags: Bit Manipulation
 * Similar Problems (M) A002_Add Two Numbers
 */
public class A371_SumofTwoIntegers {

	/**@date 2017年5月25日 下午8:17:40*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A371_SumofTwoIntegers a371 = new A371_SumofTwoIntegers();
		
		long startTime=System.currentTimeMillis();
		System.out.println(a371.getSum(989193954, 21313));
		long endTime=System.currentTimeMillis();
		System.out.println("耗时:"+(endTime-startTime)+"ms");
	}
	
	/**@date 2017年5月25日 下午8:23:22*/
	public int getSum(int a, int b) {
		//相加，只需考虑1
		int carry=(a&b)<<1; //哪些位置有两个1相加，即1+1需要进位
		int ones=a^b; //哪些位置只有一个1，即1+0
		while(carry!=0){
			int carryt = (carry&ones);
			ones = carry^ones;
			carry = carryt<<1;		
		}
		return ones;
    }
	
	public int getSum_recursion(int a, int b){
		if(a==0)
			return b;
		int carry = a&b;
		int ones = a^b;
		return getSum_recursion(carry<<1,ones);
	}

}
