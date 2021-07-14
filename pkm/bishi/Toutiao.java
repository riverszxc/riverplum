/**
 * 
 */
package me.riverz.bishi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Toutiao 
 * @author rivers
 * @date 2017年9月10日 下午7:38:17
 * @Description:
 */
public class Toutiao {

	/**@date 2017年9月10日 下午7:38:17
	 * @Description: 第一题
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Map<Integer,ArrayList<Integer>> keyuser = new HashMap<>();
		int t = 0;
		for(int i=1;i<=n;i++){
			t = in.nextInt();
			if(keyuser.containsKey(t))
				keyuser.get(t).add(i);
			else{
				keyuser.put(t, new ArrayList<Integer>());
				keyuser.get(t).add(i);
			}
		}
		int q = in.nextInt(), l=0,r=0,k=0;
		
		for(int i=0;i<q;i++){
			l=in.nextInt();
			r=in.nextInt();
			k=in.nextInt();
			if(!keyuser.containsKey(k))
				System.out.println(0);
			else{
				int num=0;
				for(int u:keyuser.get(k)){
					if(l<=u&&u<=r)
						num++;
				}
				System.out.println(num);
			}
			
		}
		
	}
	*/
	
	/**@date 2017年9月10日 下午8:11:31
	 * @Description: 第二题*/
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int c = in.nextInt();
		Map<Integer,HashSet<Integer>> keycolor = new HashMap<>();
		for(int i=1;i<=n;i++){
			keycolor.put(i, new HashSet<Integer>());
			int num_i = in.nextInt();
			if(num_i==0) 
				keycolor.get(i).add(0);
			for(int j=0;j<num_i;j++){
				keycolor.get(i).add(in.nextInt());
			}
		}
		boolean[] used = new boolean[c];
		for(int i=1;i<=n;i++){
			for(int j=m-1;j>0;j--){
				int check = (i+n-j-1)%n+1;
				if(keycolor.get(check).contains(0))
					continue;
				for(int color:keycolor.get(i)){
					if(keycolor.get(check).contains(color))
						used[color-1]=true;
				}
			}
		}
		int nocorrect=0;
		for(boolean b:used){
			if(b==true)
				nocorrect++;
		}
		System.out.println(nocorrect);
	}
	

}
