/**
 * 
 */
package me.riverz.bishi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: Aiqiyi 
 * @author rivers
 * @date 2017年10月28日 下午7:12:04
 * @Description:
 */
public class Aiqiyi {

	/**@date 2017年10月28日 下午7:12:04
	 * @Description: 最少添加括号数
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int morel=0,morer=0;
    	for(int i=0;i<s.length();i++){
    		if(s.charAt(i)=='(')
    			morel++;
    		else if(s.charAt(i)==')'){
    			if(morel>0)
    				morel--;
    			else
    				morer++;
    		}
    	}
    	System.out.println(morel+morer);

	}*/
	/*564=509+50+5
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		long x = Long.valueOf(sc.nextLine());
		for(long i=x-x/10;i>0;i++){
			long sum=0;
			long j=i;
			while(j!=0){
				sum+=j;
				j=j/10;
			}
			if(sum==x){
				System.out.println(i);
				break;
			}else if(sum>x){
				System.out.println(-1);
				break;
			}
		}
	}*/

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt(), k=sc.nextInt(), nums[]=new int[n];
		for(int i=0;i<n;i++){
			nums[i]=sc.nextInt();
		}
		int[][] dp = new int[n][k];
		for(int x=n-2;x>=0;x--){
			for(int kk=0;kk<k;kk++){
				dp[x][kk] = nixu_x(nums,x)+dp[x+1][kk];
				if(kk>=1){
					for(int y=x+1;y<n-1;y++){
						int l=x,r=y;
						while(l<r){
							int t=nums[l];
							nums[l]=nums[r];
							nums[r] = t;
							l++;
							r--;
						}
						dp[x][kk]=Math.min(dp[x][kk], nixu_x(nums,x))+dp[y+1][kk-1];
						l=x;
						r=y;
						while(l<r){
							int t=nums[l];
							nums[l]=nums[r];
							nums[r] = t;
							l++;
							r--;
						}
					}
				}
			}
		}
		System.out.println(dp[0][k-1]);
	}
	
	public static int nixu_x(int[] nums, int x){
		int res=0;
		for(int i=0;i<x;i++){
			if(nums[i]>nums[x])
				res++;
		}
		return res;
	}
	

}
