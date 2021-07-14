package me.riverz.recursion;

public class Fibonacci {

	public static void main(String[] args) {
		for(int i=1;i<100;i++)
			System.out.println(fibonacci1(i));

	}
	/*线性递归*/
	public static double fibonacci(int n){
		return (n==1||n==2)?1:fibonacci(n-1)+fibonacci(n-2);		
	}
	
	/*尾递归*/
	public static double fibonacci1(int n){
		return (n==1||n==2)?1:f1(1,1,n);
	}
	private static double f1(int a,int b,int n){
		if(n==3)
			return a+b;
		return f1(b,a+b,n-1);
	}
	
	/*循环*/
	public static double fibonacci2(int n){
		if(n<=2)
			return 1;
		int a=1,b=1,s=0;
		for(int i=0;i<n-2;i++){
			s=a+b;
			a=b;
			b=s;
		}
		return s;
	}

}
