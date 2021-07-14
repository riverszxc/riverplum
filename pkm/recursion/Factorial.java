package me.riverz.recursion;

public class Factorial {

	public static void main(String[] args) {
		
		System.out.println(factorial1(3));

	}
	
	/*阶乘
	 * */
	/*线性递归*/
	public static double factorial(double n){
		if(n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
	/*尾递归*/
	public static double factorial1(double n){
		return f1(1,1,n);
	}
	private static double f1(double r,double c,double n){
		if(c>n)
			return r;
		return f1(r*c,++c,n);
	}
	
	/*循环*/
	public static double factorial2(double n){
		int r=1;
		for(double i=n;i>0;i--)
			r*=i;
		return r;
	}

}
