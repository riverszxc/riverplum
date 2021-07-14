/**
 * 
 */
package me.riverz.bishi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName: Baidu 
 * @author rivers
 * @date 2017年9月27日 下午8:19:36
 * @Description:
 */
public class Baidu {

	/**@date 2017年9月27日 下午8:19:36
	 * @Description: 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int k=0;
		Set<Integer> sumap = new HashSet<>();
		int i=13;
		for(;i<=1000000;i++){
			if(isSu(i)){
				int trans = trans(i);
				if(i!=trans){
					sumap.add(i);
					if(sumap.contains(trans) || isSu(trans)){
						k++;
						if(k==K){
							System.out.println(i);
							return;
						}
					}
				}
			}
		}
		if(i>1000000)
			System.out.println(-1);
	}
	private static boolean isSu(int n) {
        for (int j = 2; j <= Math.sqrt(n); j++)
            if (n % j == 0)
                return false;
        return true;
    }
	public static int trans(int num){
		int res=0;
		while(true)
		{
			int n=num%10;
			res=res*10+n;
			num=num/10;
			if(num==0)
				break;
		}
		return res;
	}*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[][] pa = new int[k][8];
		for(int i=0;i<k;i++){
			for(int j=0;j<8;j++){
				pa[i][j] = sc.nextInt();
			}
		}
		int n = sc.nextInt();
		int[] index = new int[k];
		for(int i=0;i<n;i++){
			int minn = 0;
			for(int j=0;j<k;j++){
				if(func(pa[j],index[j])<func(pa[minn],index[minn])){
					minn=j;
				}
			}
			index[minn]++;
			if(i==(n-2)){
				System.out.println(func(pa[minn],index[minn]));
				return;
			}
		}
		
	}
	public static long func(int[] pa, int x){
		return (long) (pa[0]*Math.pow(x, 7)+pa[1]*Math.pow(x, 6)+pa[2]*Math.pow(x, 5)+pa[3]*Math.pow(x, 4)+pa[4]*Math.pow(x, 3)+pa[5]*Math.pow(x, 2)+pa[6]*x+pa[7]);
	}

}
