/**
 * 
 */
package me.riverz.bishi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: Huawei 
 * @author riverz
 * @date 2017年9月26日 下午6:53:11
 * @Description:
 */
public class Huawei {

	/**@date 2017年9月26日 下午6:53:11
	 * @Description: 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.nextLine().toCharArray();
		char[] b = sc.nextLine().toCharArray();
		Map<Character,List<Integer>> mapa = new HashMap<>();
		for(int i=0;i<a.length;i++){
			if(mapa.containsKey(a[i])){
				mapa.get(a[i]).add(i);
			}else{
				List<Integer> l = new ArrayList<>();
				l.add(i);
				mapa.put(a[i], l);
			}
		}
		for(int i=0;i<b.length;i++){
			if(mapa.containsKey(b[i])){
				for(int k:mapa.get(b[i])){
					a[k]='_';
				}
				b[i]='_';
			}
		}
		System.out.println(new String(a));
		System.out.println(new String(b));

	}*/
	/*
	public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String isbn = sc.next();
        if(isbn.length()!=11){
            System.out.println("ERROR");
            return;
        }
        int res = 0;
        int num = 1;
        for(int i = 0; i< isbn.length(); i++){
            char c = isbn.charAt(i);
            if(i!=1&&i!=5){
                if(c>='0'&&c<='9'){
                	res+=(c-'0')*num;
                    num++;
                }else{
                	System.out.println("ERROR");
                    return;
                }
            }else{
                if(c!='-'){
                    System.out.println("ERROR");
                    return;
                }
            }
        }
        String x = (res%11)<10?((res%11)+""):"X";
        StringBuilder sb = new StringBuilder(isbn);
        sb.append("-"+x);
        System.out.println(sb.toString());
    }
*/
	

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String dom = sc.nextLine();
		String[] doms = dom.split("\\|");
		
		Arrays.sort(doms, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String[] aa = a.split("\\.");
                String[] bb = b.split("\\.");
                for(int i = aa.length-1,j = bb.length-1;i>=0&&j>=0;i--,j--){
                    int c = aa[i].compareTo(bb[j]);
                    if(c!=0) 
                    	return c;
                    else{
                        if(i==0) 
                        	return -1;
                        if(j==0) 
                        	return 1;
                    }
                }
                return 0;
            }
        });
		StringBuilder sb = new StringBuilder();
		for(String r:doms){
			sb.append(r);
			sb.append("|");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);
		
	}
	

}
