/**
 * 
 */
package me.riverz.bishi;

import java.util.Scanner;

/**
 * @ClassName: Xiaomi 
 * @author rivers
 * @date 2017年9月18日 下午5:13:10
 * @Description:
 */
public class Xiaomi {

	/**@date 2017年9月18日 下午5:13:10
	 * @Description: 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String x = sc.nextLine();
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			int l=0,r=0,k=0,mink=Integer.MAX_VALUE;
			
			for(int i=0;i<a.length();i++){
				for(;i<a.length();i++){
					if(a.charAt(i)==b.charAt(0))
						break;
				}
				int bi=0,ai=i;
				for(;bi<b.length();){
					if(ai==a.length())
						break;
					for(;ai<a.length();){
						if(a.charAt(ai)==b.charAt(bi)){
							ai++;
							bi++;
							break;
						}
						if(a.charAt(ai)!=b.charAt(bi)){
							ai++;
							continue;
						}
					}
				}
				if(bi==b.length()){
					if(ai-i<mink){
						mink=ai-i;
						l=i;
						r=ai;
					}
				}
				
			}
			if(mink<Integer.MAX_VALUE)
				System.out.println(l+" "+(r-1));
			else
				System.out.println(-1+" "+-1);
		}

	}*/
	/*
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		String rr="1";
		for(long i=n;i>0;i--){
			rr = multiply(rr,i+"");
		}
		System.out.println(rr);
	}
	
	public static String multiply(String num1,String num2){
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
		}
		if(res[0]=='0') return new String(res).substring(1);
        return new String(res);
	}*/
/*
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n==0){
			System.out.println(1);
			return;
		}
		int[] res = {0};
		dfs(n,0,res);
		System.out.println(res[0]);
	}
	public static void dfs(int n,int now,int[] res){
		if(now==n){
			res[0]++;
			return;
		}
		if(now>n)
			return;
		dfs(n,now+1,res);
		dfs(n,now+2,res);
	}*/
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] f = new int[n+1];
		f[0]=1;
		f[1]=1;
		for(int i=2;i<=n;i++){
			f[i]=f[i-2]+f[i-1];
		}
		System.out.println(f[n]);
	}

}
