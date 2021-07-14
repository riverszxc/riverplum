/**
 * 
 */
package me.riverz.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @ClassName: Fanpujinke 
 * @author rivers
 * @date 2017年9月18日 下午4:00:50
 * @Description:
 */
public class Fanpujinke {

	/**@date 2017年9月18日 下午4:00:50
	 * @Description: */
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		if(n<=1){
//			System.out.println(1);
//			return;
//		}
//		int[] ren = new int[n+1];
//		for(int i=1;i<=n;i++)
//			ren[i] = sc.nextInt();
//		int a=0,b=0;
//		List<Set<Integer>> list = new ArrayList<>();
//		list.add(new HashSet<Integer>());
//		for(int i=1;i<=n;i++){
//			for(int j=0;j<list.size();j++){
//				if(list.get(j).contains(i))
//					a=j;
//				if(list.get(j).contains(ren[i]))
//					b=j;
//				if(a>0&&b>0)
//					break;
//			}
//			if(a>0&&b==0)
//				list.get(a).add(ren[i]);
//			else if(a==0&&b>0)
//				list.get(b).add(i);
//			else if(a==0&&b==0){
//				Set<Integer> s = new HashSet<>();
//				s.add(i);
//				s.add(ren[i]);
//				list.add(s);
//			}
//			else if(a>0&&b>0&&a!=b){
//				list.get(a).addAll(list.get(b));
//				list.remove(b);
//			}
//			a=0;
//			b=0;
//		}
//		System.out.println(list.size()-1);
//	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] c = String.valueOf(n).toCharArray();
		StringBuilder sb = new StringBuilder();
		Set<Character> s = new HashSet<>();
		int i=0;
		for(;i<c.length;i++){
			if(s.contains(c[i]))
				break;
			s.add(c[i]);
			sb.append(c[i]);
		}
		for(int j=0;j<9;j++){
			if(!s.contains(j)&&j>(c[i]-'0')){
				s.add((char)j);
				sb.append(j);
				break;
			}
		}
		for(int j=0;j<c.length-i-1;j++){
			for(int k=0;k<9;k++){
				if(!s.contains(k)){
					s.add((char)k);
					sb.append(k);
					break;
				}
			}
		}
		System.out.println(sb);
		
	}

}
