/**
 * 
 */
package me.riverz.bishi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName: Yixin 
 * @author rivers
 * @date 2017年10月26日 下午9:05:59
 * @Description:
 */
public class Yixin {

	/**@date 2017年10月26日 下午9:05:59
	 * @Description: */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		String eyi = sc.nextLine();
		eyi = sc.nextLine();
		String[] eyici = eyi.split(" ");
		for(int i=0;i<m;i++){
			String web = sc.nextLine();
			String[] key = sc.nextLine().split(" ");
			Set<String> ss = new HashSet<>();
			for(String s:key){
				ss.add(s);
			}
			int num=0;
			for(String e:eyici){
				if(ss.contains(e))
					num++;
				if(num==k){
					System.out.println(web);
					break;
				}
			}
			ss.clear();
		}

	}

}
